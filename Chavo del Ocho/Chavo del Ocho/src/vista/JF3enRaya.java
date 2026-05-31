package vista;

import controlador.Cntrl3enRaya;
import controlador.CntrlDialogos;
import javax.swing.*;
import java.awt.*;

/**
 * JF3enRaya - Vista del juego Tres en Raya.
 * Solo construye y expone la interfaz gráfica. Sin lógica de juego.
 */
public class JF3enRaya extends javax.swing.JFrame {

    // ── Componentes ───────────────────────────────────────────────────────
    private JButton[]  botones = new JButton[9];
    private JLabel     lblEstado;
    private JTextField txtPartidas;
    private JButton    btnSeguir;
    private Cntrl3enRaya cntrl3enRaya;

    // ── Constructor ───────────────────────────────────────────────────────
    public JF3enRaya() {
        initComponents();
        cntrl3enRaya = new controlador.Cntrl3enRaya(this);
    }

    // ── Construcción de la UI ─────────────────────────────────────────────
    private void initComponents() {
        setTitle("3 en Raya");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Panel raíz con margen interior
        JPanel raiz = new JPanel(new BorderLayout(5, 8));
        raiz.setBorder(BorderFactory.createEmptyBorder(8, 10, 10, 10));
        raiz.setBackground(UIManager.getColor("Panel.background"));

        // ── Label de estado (arriba) ──
        lblEstado = new JLabel("Haz clic en una casilla para comenzar");
        lblEstado.setFont(new Font("Arial", Font.PLAIN, 12));
        lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
        raiz.add(lblEstado, BorderLayout.NORTH);

        // ── Tablero 3x3 ──
        JPanel tablero = new JPanel(new GridLayout(3, 3, 4, 4));
        tablero.setBackground(Color.GRAY);
        tablero.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        for (int i = 0; i < 9; i++) {
            botones[i] = new JButton();
            botones[i].setFont(new Font("Arial", Font.BOLD, 36));
            botones[i].setBackground(new Color(230, 230, 230));
            botones[i].setFocusPainted(false);
            botones[i].setPreferredSize(new Dimension(90, 90));
            tablero.add(botones[i]);
        }
        raiz.add(tablero, BorderLayout.CENTER);

        // ── Panel inferior: botón Seguir + partidas ganadas ──
        // lblRacha eliminado; solo queda Seguir y el contador de victorias totales.
        JPanel panelInf = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 4));
        panelInf.setBackground(UIManager.getColor("Panel.background"));

        btnSeguir = new JButton("Seguir");
        btnSeguir.setFont(new Font("Arial", Font.PLAIN, 12));
        panelInf.add(btnSeguir);

        JLabel lblPartidas = new JLabel("Partidas Ganadas:");
        lblPartidas.setFont(new Font("Arial", Font.PLAIN, 12));
        panelInf.add(lblPartidas);

        txtPartidas = new JTextField("0", 5);
        txtPartidas.setEditable(false);
        txtPartidas.setHorizontalAlignment(JTextField.CENTER);
        txtPartidas.setFont(new Font("Arial", Font.PLAIN, 12));
        panelInf.add(txtPartidas);

        raiz.add(panelInf, BorderLayout.SOUTH);

        setContentPane(raiz);
        pack();
        setLocationRelativeTo(null);
    }

    // ── Getters para el controlador ───────────────────────────────────────
    public JButton[]  getBotones()     { return botones; }
    public JLabel     getLblEstado()   { return lblEstado; }
    public JTextField getTxtPartidas() { return txtPartidas; }
    public JButton    getBtnSeguir()   { return btnSeguir; }
    public Cntrl3enRaya getCntrl3enRaya() { return cntrl3enRaya; }

    // ── Main ──────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JF3enRaya().setVisible(true));
    }
}
