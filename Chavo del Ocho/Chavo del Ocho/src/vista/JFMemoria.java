package vista;

import controlador.CntrlDialogos;
import controlador.CntrlMemoria;
import javax.swing.*;
import java.awt.*;

/**
 * JFMemoria - Vista del juego "Memoria de Cartas con Letras".
 * Diseño simple estilo NetBeans por defecto.
 */
public class JFMemoria extends JFrame {

    private JButton[] botones = new JButton[16];
    private JLabel     lblIntentos;
    private JLabel     lblPares;
    private JButton    btnReiniciar;
    private CntrlMemoria cntrlMemoria;

    public JFMemoria() {
        initComponents();
        cntrlMemoria = new CntrlMemoria(this);
    }

    private void initComponents() {
        setTitle("Memoria de Cartas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel raiz = new JPanel(new BorderLayout(5, 8));
        raiz.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ── Label de título ──
        JLabel lblTitulo = new JLabel("Memoria de Cartas", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        raiz.add(lblTitulo, BorderLayout.NORTH);

        // ── Tablero 4x4 ──
        JPanel panelTablero = new JPanel(new GridLayout(4, 4, 4, 4));
        panelTablero.setBackground(Color.GRAY);
        panelTablero.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));

        for (int i = 0; i < 16; i++) {
            botones[i] = new JButton("?");
            botones[i].setFont(new Font("Arial", Font.BOLD, 28));
            botones[i].setBackground(new Color(220, 220, 220));
            botones[i].setFocusPainted(false);
            botones[i].setPreferredSize(new Dimension(75, 75));
            panelTablero.add(botones[i]);
        }
        raiz.add(panelTablero, BorderLayout.CENTER);

        // ── Panel inferior: contadores + botón ──
        JPanel panelInf = new JPanel(new FlowLayout(FlowLayout.CENTER, 16, 4));

        lblIntentos = new JLabel("Intentos: 0");
        lblIntentos.setFont(new Font("Arial", Font.PLAIN, 12));

        lblPares = new JLabel("Pares: 0 / 8");
        lblPares.setFont(new Font("Arial", Font.PLAIN, 12));

        btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setFont(new Font("Arial", Font.PLAIN, 12));

        panelInf.add(lblIntentos);
        panelInf.add(new JSeparator(SwingConstants.VERTICAL));
        panelInf.add(lblPares);
        panelInf.add(btnReiniciar);

        raiz.add(panelInf, BorderLayout.SOUTH);

        setContentPane(raiz);
        pack();
        setLocationRelativeTo(null);
    }

    // ── Getters ───────────────────────────────────────────────────────────
    public JButton[] getBotones()      { return botones; }
    public JLabel    getLblIntentos()  { return lblIntentos; }
    public JLabel    getLblPares()     { return lblPares; }
    public JButton   getBtnReiniciar() { return btnReiniciar; }
    public CntrlMemoria getCntrlMemoria() {return cntrlMemoria;}

    // ── Main ──────────────────────────────────────────────────────────────
    public static void main(String[] args){ 
        SwingUtilities.invokeLater(() -> {
            JFMemoria vista = new JFMemoria();
            new controlador.CntrlMemoria(vista);
            vista.setVisible(true);
        });
    }
}
