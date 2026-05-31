package controlador;

import vista.JFMemoria;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CntrlMemoria - Controlador del juego "Memoria de Cartas con Letras".
 */
public class CntrlMemoria {

    private JFMemoria vista;
    private CntrlDialogos cntrlDialogo;

    // ── Estado del tablero ─────────────────────────────────────────────────
    private String[] letrasTablero = new String[16];
    private boolean[] emparejadas = new boolean[16];

    // ── Estado del turno ───────────────────────────────────────────────────
    /**
     * Índice del primer botón volteado. -1 si no hay ninguno aún.
     */
    private int primerIndice = -1;

    /**
     * Bloqueo global mientras el Timer de 800ms está activo. Evita que el
     * jugador voltee una tercera carta durante la pausa.
     */
    private boolean tableroBloquea = false;

    // ── Contadores ─────────────────────────────────────────────────────────
    private int intentos = 0;
    private int paresEncontrados = 0;
    private static final int TOTAL_PARES = 8;

    // ── Colores ────────────────────────────────────────────────────────────
    private static final Color COLOR_OCULTA = new Color(220, 220, 220);
    private static final Color COLOR_REVELADA = new Color(200, 210, 230);
    private static final Color COLOR_EMPAREJADA = new Color(180, 220, 180);

    // ── Constructor ────────────────────────────────────────────────────────
    public CntrlMemoria(JFMemoria vista) {
        this.vista = vista;
        iniciarJuego();
        conectarBotones();
        conectarBtnReiniciar();
    }

    public void setCntrlDialogos(CntrlDialogos cntrlDialogos) {
        this.cntrlDialogo = cntrlDialogos;
    }

    // ── Inicialización ─────────────────────────────────────────────────────
    private void iniciarJuego() {
        primerIndice = -1;
        tableroBloquea = false;
        intentos = 0;
        paresEncontrados = 0;
        for (int i = 0; i < 16; i++) {
            emparejadas[i] = false;
        }

        // Generar 8 pares A-H y barajar
        List<String> letras = new ArrayList<>();
        for (String l : new String[]{"A", "B", "C", "D", "E", "F", "G", "H"}) {
            letras.add(l);
            letras.add(l);
        }
        Collections.shuffle(letras);
        for (int i = 0; i < 16; i++) {
            letrasTablero[i] = letras.get(i);
        }

        reiniciarVista();
        actualizarContadores();
    }

    private void reiniciarVista() {
        for (JButton btn : vista.getBotones()) {
            btn.setText("?");
            btn.setEnabled(true);
            btn.setBackground(COLOR_OCULTA);
            btn.setForeground(Color.DARK_GRAY);
            btn.setFont(new Font("Arial", Font.BOLD, 28));
        }
    }

    // ── Conexión de eventos ────────────────────────────────────────────────
    private void conectarBotones() {
        JButton[] botones = vista.getBotones();
        for (int i = 0; i < 16; i++) {
            final int indice = i;
            botones[i].addActionListener((ActionEvent e) -> manejarClic(indice));
        }
    }

    private void conectarBtnReiniciar() {
        vista.getBtnReiniciar().addActionListener((ActionEvent e) -> iniciarJuego());
    }

    // ── Lógica principal del clic ──────────────────────────────────────────
    private void manejarClic(int indice) {
        // Guards: ignorar clics inválidos
        if (tableroBloquea) {
            return;
        }
        if (emparejadas[indice]) {
            return;
        }
        if (indice == primerIndice) {
            return;
        }

        JButton[] botones = vista.getBotones();
        voltearCarta(botones[indice], letrasTablero[indice]);

        if (primerIndice == -1) {
            // Primer clic del turno
            primerIndice = indice;

        } else {
            // Segundo clic del turno
            intentos++;
            actualizarContadores();

            int segundoIndice = indice;

            if (letrasTablero[primerIndice].equals(letrasTablero[segundoIndice])) {
                // ── Par correcto ──
                marcarEmparejadas(primerIndice, segundoIndice);
                primerIndice = -1;

                if (paresEncontrados == TOTAL_PARES) {
                    Timer t = new Timer(400, ev -> mostrarVictoria());
                    t.setRepeats(false);
                    t.start();
                }

            } else {
                // ── Par incorrecto: bloquear y ocultar tras 800ms ──
                // CRÍTICO: bloquear ANTES de crear el Timer, no dentro de él,
                // para cerrar la ventana de clics desde este mismo hilo EDT.
                tableroBloquea = true;

                final int idx1 = primerIndice;
                final int idx2 = segundoIndice;

                Timer timerOcultar = new Timer(800, ev -> {
                    ocultarCarta(botones[idx1]);
                    ocultarCarta(botones[idx2]);
                    tableroBloquea = false;
                    primerIndice = -1;
                });
                timerOcultar.setRepeats(false);
                timerOcultar.start();
            }
        }
    }

    // ── Manipulación visual de cartas ──────────────────────────────────────
    private void voltearCarta(JButton btn, String letra) {
        btn.setText(letra);
        btn.setFont(new Font("Arial", Font.BOLD, 32));
        btn.setBackground(COLOR_REVELADA);
        btn.setForeground(Color.BLACK);
    }

    private void ocultarCarta(JButton btn) {
        btn.setText("?");
        btn.setFont(new Font("Arial", Font.BOLD, 28));
        btn.setBackground(COLOR_OCULTA);
        btn.setForeground(Color.DARK_GRAY);
    }

    private void marcarEmparejadas(int idx1, int idx2) {
        JButton[] botones = vista.getBotones();
        emparejadas[idx1] = true;
        emparejadas[idx2] = true;
        paresEncontrados++;

        for (int idx : new int[]{idx1, idx2}) {
            botones[idx].setBackground(COLOR_EMPAREJADA);
            botones[idx].setForeground(new Color(30, 100, 30));
            botones[idx].setEnabled(false);
        }
        actualizarContadores();
    }

    // ── Victoria ───────────────────────────────────────────────────────────
    private void mostrarVictoria() {
        javax.swing.JOptionPane.showMessageDialog(vista,
                "Felicitaciones!\n\nEncontraste los 8 pares en " + intentos + " intentos.\n\n");
        cntrlDialogo.finalizarFlorindayRamon();
        cntrlDialogo.mostrarDialogo();
        cntrlDialogo.frmDialogo.setVisible(true);
        vista.setVisible(false);

    }

    // ── Contadores ─────────────────────────────────────────────────────────
    private void actualizarContadores() {
        vista.getLblIntentos().setText("Intentos: " + intentos);
        vista.getLblPares().setText("Pares: " + paresEncontrados + " / " + TOTAL_PARES);
    }
}
