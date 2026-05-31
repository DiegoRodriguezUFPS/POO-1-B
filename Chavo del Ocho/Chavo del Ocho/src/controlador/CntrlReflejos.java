package controlador;

import vista.JFReflejos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class CntrlReflejos {

    // ── Vista ──────────────────────────────────────────────────────────────
    private JFReflejos vista;
    private CntrlDialogos cntrlDialogos;

    // ── Estado del juego ───────────────────────────────────────────────────
    private int puntuacion = 0;
    private int tiempoRestante = 30;
    private boolean juegoIniciado = false; // ← nuevo: controla si ya arrancó

    // ── Condición de victoria ──────────────────────────────────────────────
    private static final int PUNTOS_PARA_GANAR = 200;

    // ── Timer principal ────────────────────────────────────────────────────
    private Timer timerPrincipal;

    // ── Utilidad ───────────────────────────────────────────────────────────
    private Random random = new Random();

    // ── Constructor ────────────────────────────────────────────────────────
    public CntrlReflejos(JFReflejos vista) {
        this.vista = vista;
        configurarTimer();   // solo configura, NO arranca
        conectarBotonMunieca();
        // timerPrincipal.start() ← eliminado de aquí
    }

    public void setCntrlDialogos(CntrlDialogos cntrlDialogos) {
        this.cntrlDialogos = cntrlDialogos;
    }

    // ── Configuración del Timer ────────────────────────────────────────────
    private void configurarTimer() {
        timerPrincipal = new Timer(1000, (ActionEvent e) -> {
            moverMunieca();
            tiempoRestante--;
            vista.getLblTiempo().setText("Tiempo: " + tiempoRestante + "s");

            if (tiempoRestante <= 0) {
                terminarJuego();
            }
        });
    }

    // ── Conexión del botón ─────────────────────────────────────────────────
    private void conectarBotonMunieca() {
        vista.getBtnMunieca().addActionListener((ActionEvent e) -> {

            // Primer clic → arranca el timer
            if (!juegoIniciado) {
                juegoIniciado = true;
                timerPrincipal.start();
            }

            puntuacion += 10;
            vista.getLblPuntuacion().setText("Puntuacion: " + puntuacion);
            moverMunieca();
        });
    }

    // ── Movimiento de la muñeca ────────────────────────────────────────────
    private void moverMunieca() {
        JButton btn = vista.getBtnMunieca();
        int panelAncho = vista.getPanelJuego().getWidth();
        int panelAlto = vista.getPanelJuego().getHeight();
        int tamano = JFReflejos.TAMANO_BOTON;

        int maxX = Math.max(0, panelAncho - tamano);
        int maxY = Math.max(0, panelAlto - tamano);

        btn.setLocation(random.nextInt(maxX + 1), random.nextInt(maxY + 1));
    }

    // ── Resetear estado interno (para cuando la ventana se vuelve a abrir) ─
    public void reiniciar() {
        timerPrincipal.stop();
        puntuacion = 0;
        tiempoRestante = 30;
        juegoIniciado = false;
        vista.getLblPuntuacion().setText("Puntuacion: 0");
        vista.getLblTiempo().setText("Tiempo: 30s");
        vista.getBtnMunieca().setEnabled(true);
    }

    // ── Fin del juego ──────────────────────────────────────────────────────
    private void terminarJuego() {
        timerPrincipal.stop();
        vista.getBtnMunieca().setEnabled(false);
        vista.getLblTiempo().setText("Tiempo: 0s");

        if (puntuacion >= PUNTOS_PARA_GANAR) {
            JOptionPane.showMessageDialog(
                    vista,
                    "¡Felicitaciones! ¡Ganaste!\n\n"
                    + "Puntuacion final: " + puntuacion + " puntos.\n"
                    + "Superaste los " + PUNTOS_PARA_GANAR + " puntos requeridos.",
                    "¡Ganaste!",
                    JOptionPane.INFORMATION_MESSAGE
            );
            vista.setVisible(false);
            reiniciar(); // deja el juego listo por si se abre de nuevo
            cntrlDialogos.finalizarPopis();
            cntrlDialogos.mostrarDialogo();
            cntrlDialogos.frmDialogo.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(
                    vista,
                    "¡Se acabó el tiempo! Perdiste.\n\n"
                    + "Puntuacion final: " + puntuacion + " puntos.\n"
                    + "Necesitabas " + PUNTOS_PARA_GANAR + " puntos para ganar.\n"
                    + "Te faltaron " + (PUNTOS_PARA_GANAR - puntuacion) + " puntos.",
                    "Perdiste",
                    JOptionPane.WARNING_MESSAGE
            );
            // Al perder: vuelve al diálogo también
            vista.setVisible(false);
            reiniciar();
            cntrlDialogos.iniciarPopis(); // reinicia la secuencia de diálogos de Popis
            cntrlDialogos.frmDialogo.setVisible(true);
        }
    }
}
