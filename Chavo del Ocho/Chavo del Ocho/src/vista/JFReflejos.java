package vista;

import controlador.CntrlReflejos;
import javax.swing.*;
import java.awt.*;

/**
 * JFReflejos - Vista del juego "Atrapa la Muñeca".
 * Solo construye y expone la interfaz. Sin lógica de juego.
 * El controlador se instancia desde el main, no desde aquí.
 */
public class JFReflejos extends JFrame {

    // ── Componentes ───────────────────────────────────────────────────────
    private JLabel   lblPuntuacion;
    private JLabel   lblTiempo;
    private JButton  btnMunieca;
    private JPanel   panelJuego;
    private CntrlReflejos cntrlReflejos;

    // ── Dimensiones fijas ─────────────────────────────────────────────────
    public static final int ANCHO_VENTANA = 500;
    public static final int ALTO_VENTANA  = 500;
    public static final int TAMANO_BOTON  = 60;

    // ── Constructor ───────────────────────────────────────────────────────
    public JFReflejos() {
        initComponents();
        cntrlReflejos = new CntrlReflejos(this);
    }

    // ── Construcción de la UI ─────────────────────────────────────────────
    private void initComponents() {
        setTitle("Atrapa la Munieca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // ── Panel superior: puntuación y tiempo ──
        JPanel panelSup = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 6));

        lblPuntuacion = new JLabel("Puntuacion: 0");
        lblPuntuacion.setFont(new Font("Arial", Font.BOLD, 14));

        lblTiempo = new JLabel("Tiempo: 30s");
        lblTiempo.setFont(new Font("Arial", Font.BOLD, 14));

        panelSup.add(lblPuntuacion);
        panelSup.add(lblTiempo);

        // ── Panel de juego: layout nulo para posicionar el botón libremente ──
        panelJuego = new JPanel(null);
        panelJuego.setPreferredSize(new Dimension(ANCHO_VENTANA, ALTO_VENTANA));

        // Botón muñeca: carga la imagen desde la ruta y la escala al tamaño del botón.
        // Si la imagen no se encuentra, muestra un texto de respaldo.
        btnMunieca = new JButton();
        btnMunieca.setFocusPainted(false);
        btnMunieca.setSize(TAMANO_BOTON, TAMANO_BOTON);
        btnMunieca.setLocation(220, 220); // Posición inicial centrada

        ImageIcon icono = cargarImagen("Imagenes/Munieca.jpg");
        if (icono != null) {
            btnMunieca.setIcon(icono);
        } else {
            // Respaldo por si la imagen no está en la ruta indicada
            btnMunieca.setText("M");
            btnMunieca.setFont(new Font("Arial", Font.BOLD, 22));
        }
        panelJuego.add(btnMunieca);

        // ── Ensamblar ventana ──
        setLayout(new BorderLayout());
        add(panelSup,   BorderLayout.NORTH);
        add(panelJuego, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    // ── Getters para el controlador ───────────────────────────────────────
    public JLabel  getLblPuntuacion() { return lblPuntuacion; }
    public JLabel  getLblTiempo()     { return lblTiempo; }
    public JButton getBtnMunieca()    { return btnMunieca; }
    public JPanel  getPanelJuego()    { return panelJuego; }
    public CntrlReflejos getCntrlReflejos() {return  cntrlReflejos;}

    // ── Carga de imagen ───────────────────────────────────────────────────
    /**
     * Carga la imagen desde la ruta indicada y la escala al tamaño del botón.
     * Retorna null si el archivo no existe, para que el botón use texto de respaldo.
     *
     * @param ruta Ruta relativa al directorio raíz del proyecto (ej: "Imagenes/munieca.jpg")
     */
    private ImageIcon cargarImagen(String ruta) {
        java.io.File archivo = new java.io.File(ruta);
        if (!archivo.exists()) return null;

        ImageIcon original = new ImageIcon(archivo.getAbsolutePath());
        Image escalada = original.getImage()
                .getScaledInstance(TAMANO_BOTON, TAMANO_BOTON, Image.SCALE_SMOOTH);
        return new ImageIcon(escalada);
    }

    // ── Main ──────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFReflejos vista = new JFReflejos();
            new controlador.CntrlReflejos(vista);
            vista.setVisible(true);
        });
    }
}
