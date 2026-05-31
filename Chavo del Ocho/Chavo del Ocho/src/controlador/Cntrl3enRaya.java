package controlador;

import vista.JF3enRaya;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Cntrl3enRaya - Controlador del juego Tres en Raya.
 *
 * Reglas de victoria:
 *  - El jugador gana el juego completo al acumular 3 victorias totales.
 *  - Las derrotas y empates NO restan ni reinician el contador.
 *  - La máquina usa IA: ganar > bloquear > aleatorio.
 */
public class Cntrl3enRaya {

    // ── Vista ──────────────────────────────────────────────────────────────
    private JF3enRaya vista;
    private CntrlDialogos cntrlDialogos;

    // ── Tablero lógico ─────────────────────────────────────────────────────
    // Siempre inicializado con "" para evitar NullPointerException.
    // "" = vacío | "X" = jugador | "O" = máquina
    // Índices: 0|1|2 / 3|4|5 / 6|7|8
    private String[] tablero;

    // ── Control de flujo ───────────────────────────────────────────────────
    // turnoJugador se bloquea ANTES del Timer para evitar doble clic
    // durante la pausa de la máquina.
    private boolean turnoJugador;
    private boolean partidaTerminada;

    // ── Contador de victorias ──────────────────────────────────────────────
    // Acumula victorias totales del jugador. No se reinicia por derrotas/empates.
    private int victoriasJugador = 0;
    private static final int META_VICTORIAS = 3;

    // ── Líneas ganadoras ───────────────────────────────────────────────────
    private static final int[][] LINEAS = {
        {0,1,2}, {3,4,5}, {6,7,8},  // filas
        {0,3,6}, {1,4,7}, {2,5,8},  // columnas
        {0,4,8}, {2,4,6}            // diagonales
    };

    // ── Constructor ────────────────────────────────────────────────────────
    public Cntrl3enRaya(JF3enRaya vista) {
        this.vista = vista;
        conectarBotones();
        conectarBtnSeguir();
        iniciarNuevaPartida();
    }

    public void setCntrlDialogos(CntrlDialogos cntrlDialogos) {
        this.cntrlDialogos = cntrlDialogos;
    }
    

    // ── Conexión de eventos ────────────────────────────────────────────────
    private void conectarBotones() {
        JButton[] botones = vista.getBotones();
        for (int i = 0; i < 9; i++) {
            final int idx = i;
            botones[i].addActionListener((ActionEvent e) -> manejarClick(idx));
        }
    }

    private void conectarBtnSeguir() {
        vista.getBtnSeguir().addActionListener((ActionEvent e) -> {
            if (partidaTerminada) iniciarNuevaPartida();
        });
    }

    // ── Turno del jugador ──────────────────────────────────────────────────
    private void manejarClick(int indice) {
        if (!turnoJugador || partidaTerminada || !tablero[indice].isEmpty()) {
            return;
        }

        // Bloquear turno ANTES del Timer: evita doble clic durante la pausa
        turnoJugador = false;

        realizarMovimiento(indice, "X");

        if (verificarEstado("X")) return;

        vista.getLblEstado().setText("Turno de la maquina...");
        Timer timer = new Timer(500, (ActionEvent e) -> turnoMaquina());
        timer.setRepeats(false);
        timer.start();
    }

    // ── Turno de la máquina ────────────────────────────────────────────────
    private void turnoMaquina() {
        // Guardia: si la partida terminó justo antes de que el Timer se disparara,
        // no mover (evita mover sobre un tablero ya cerrado o reiniciado).
        if (partidaTerminada) return;

        int mov = calcularMovimientoMaquina();
        realizarMovimiento(mov, "O");

        if (verificarEstado("O")) return;

        turnoJugador = true;
        vista.getLblEstado().setText("Tu turno");
    }

    // ── Realizar movimiento ────────────────────────────────────────────────
    private void realizarMovimiento(int indice, String simbolo) {
        tablero[indice] = simbolo;
        JButton btn = vista.getBotones()[indice];
        btn.setText(simbolo);
        btn.setForeground(simbolo.equals("X") ? Color.BLUE : Color.RED);
        btn.setEnabled(false);
    }

    // ── IA: ganar > bloquear > aleatorio ──────────────────────────────────
    private int calcularMovimientoMaquina() {
        int mov;

        // 1. ¿Puede ganar en este turno?
        mov = buscarDecisivo("O");
        if (mov != -1) return mov;

        // 2. ¿Necesita bloquear al jugador?
        mov = buscarDecisivo("X");
        if (mov != -1) return mov;

        // 3. Casilla aleatoria
        return casillaAleatoria();
    }

    /**
     * Busca una casilla donde el símbolo tenga 2 en línea y la tercera esté vacía.
     * Descarta líneas que ya contengan fichas del rival (no son completables).
     */
    private int buscarDecisivo(String simbolo) {
        for (int[] linea : LINEAS) {
            int count = 0;
            int vacia = -1;
            boolean valida = true;

            for (int i : linea) {
                String celda = tablero[i];
                if (celda.equals(simbolo)) {
                    count++;
                } else if (celda.isEmpty()) {
                    vacia = i;
                } else {
                    valida = false; // Hay ficha rival → línea bloqueada
                    break;
                }
            }

            if (valida && count == 2 && vacia != -1) return vacia;
        }
        return -1;
    }

    private int casillaAleatoria() {
        List<Integer> vacias = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (tablero[i].isEmpty()) vacias.add(i);
        }
        return vacias.get(new Random().nextInt(vacias.size()));
    }

    // ── Verificar estado ───────────────────────────────────────────────────
    private boolean verificarEstado(String simbolo) {
        if (hayVictoria(simbolo)) {
            finPartida(simbolo.equals("X") ? "victoria" : "derrota");
            return true;
        }
        if (hayEmpate()) {
            finPartida("empate");
            return true;
        }
        return false;
    }

    private boolean hayVictoria(String s) {
        for (int[] l : LINEAS) {
            if (tablero[l[0]].equals(s)
             && tablero[l[1]].equals(s)
             && tablero[l[2]].equals(s)) {
                resaltarLinea(l);
                return true;
            }
        }
        return false;
    }

    private boolean hayEmpate() {
        for (String c : tablero) {
            if (c.isEmpty()) return false;
        }
        return true;
    }

    // ── Fin de partida ─────────────────────────────────────────────────────
    private void finPartida(String resultado) {
        partidaTerminada = true;
        turnoJugador     = false;

        switch (resultado) {
            case "victoria":
                // Sumar victoria acumulada (derrota/empate NO restan)
                victoriasJugador++;
                vista.getTxtPartidas().setText(String.valueOf(victoriasJugador));

                // ¿El jugador alcanzó la meta de victorias totales?
                if (victoriasJugador >= META_VICTORIAS) {
                    vista.getLblEstado().setText("Llegaste a 3 victorias! CAMPEON!");
                    Timer t = new Timer(700, e -> celebracion());
                    t.setRepeats(false);
                    t.start();
                    return;
                }
                vista.getLblEstado().setText(
                    "Ganaste! Victorias: " + victoriasJugador + "/" + META_VICTORIAS
                    + " - presiona Seguir"
                );
                break;

            case "derrota":
                // El contador NO se reinicia: el jugador conserva sus victorias
                vista.getLblEstado().setText(
                    "Gano la maquina. Victorias: " + victoriasJugador + "/" + META_VICTORIAS
                    + " - presiona Seguir"
                );
                break;

            case "empate":
                // El contador NO se reinicia: empate no penaliza al jugador
                vista.getLblEstado().setText(
                    "Empate. Victorias: " + victoriasJugador + "/" + META_VICTORIAS
                    + " - presiona Seguir"
                );
                break;
        }
    }

    private void celebracion() {
        JOptionPane.showMessageDialog(
            vista,
            "FELICITACIONES!\n\n" +
            "Acumulaste 3 victorias totales.\n" +
            "Eres el campeon del Tres en Raya.\n\n",
            "CAMPEON",
            JOptionPane.INFORMATION_MESSAGE
        );
        cntrlDialogos.finalizarQuicoYChilindrina();
        cntrlDialogos.mostrarDialogo();
        cntrlDialogos.getFrmDialogo().setVisible(true);
        vista.setVisible(false);
        // Reinicio completo: victorias vuelven a 0
        victoriasJugador = 0;
        vista.getTxtPartidas().setText("0");
        iniciarNuevaPartida();
    }

    // ── Reinicio del tablero ───────────────────────────────────────────────
    private void iniciarNuevaPartida() {
        // Inicializar SIEMPRE con "" para que isEmpty() funcione correctamente
        tablero = new String[9];
        for (int i = 0; i < 9; i++) tablero[i] = "";

        partidaTerminada = false;
        turnoJugador     = true;

        JButton[] botones = vista.getBotones();
        for (JButton btn : botones) {
            btn.setText("");
            btn.setEnabled(true);
            btn.setBackground(new Color(230, 230, 230));
            btn.setForeground(Color.BLACK);
        }

        vista.getLblEstado().setText("Tu turno");
    }

    // ── Helpers de vista ───────────────────────────────────────────────────
    private void resaltarLinea(int[] linea) {
        JButton[] botones = vista.getBotones();
        for (int i : linea) {
            botones[i].setBackground(new Color(180, 220, 180));
        }
    }
}
