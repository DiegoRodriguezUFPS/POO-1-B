package controlador;

import vista.JFFormulario;
import javax.swing.*;
import java.awt.event.*;

public class CntrlFormulario {

    private JFFormulario vista;
    private CntrlDialogos cntrlDialogos;

    // ── Preguntas ──────────────────────────────────────────────────────────
    private final String[] preguntas = {
        "Pregunta 1 de 8:\n\n"
        + "El verdadero nombre del Chavo nunca fue\n"
        + "revelado en la serie.\n\n"
        + "Selecciona: Verdadero  o  Falso",
        "Pregunta 2 de 8:\n\n"
        + "Don Ramón le debe exactamente 15 meses de\n"
        + "renta al Señor Barriga.\n\n"
        + "Selecciona: Verdadero  o  Falso",
        "Pregunta 3 de 8:\n\n"
        + "La Bruja del 71 en realidad se llama Clotilde,\n"
        + "y el \"71\" es por el año en que llegó\n"
        + "a la vecindad.\n\n"
        + "Selecciona: Verdadero  o  Falso",
        "Pregunta 4 de 8:\n\n"
        + "El Chavo vive dentro del barril; ese es su\n"
        + "hogar y ahí duerme todas las noches.\n\n"
        + "Selecciona: Verdadero  o  Falso",
        "Pregunta 5 de 8:\n\n"
        + "El profesor Jirafales y Doña Florinda nunca\n"
        + "se casaron a lo largo de la serie.\n\n"
        + "Selecciona: Verdadero  o  Falso",
        "Pregunta 6 de 8:\n\n"
        + "Godínez es el niño sabelotodo de la escuela\n"
        + "que siempre responde bien a las preguntas\n"
        + "del Profesor Jirafales.\n\n"
        + "Selecciona: Verdadero  o  Falso",
        "Pregunta 7 de 8:\n\n"
        + "Quico dice que su papá era tiburonero y que\n"
        + "murió cuando se lo tragó un tiburón.\n\n"
        + "Selecciona: Verdadero  o  Falso",
        "Pregunta 8 de 8:\n\n"
        + "El postre favorito del Chavo, por el que\n"
        + "es capaz de todo, es la torta de jamón.\n\n"
        + "Selecciona: Verdadero  o  Falso"
    };

    // true = Verdadero correcto, false = Falso correcto
    private final boolean[] respuestasCorrectas = {
        true, // 1. Nombre del Chavo nunca revelado → Verdadero
        false, // 2. 15 meses de renta → Falso (son 14)
        false, // 3. 71 por el año → Falso (es el núm. de apartamento)
        false, // 4. Vive en el barril → Falso (es solo escondite)
        true, // 5. Jirafales y Florinda no se casaron → Verdadero
        false, // 6. Godínez sabelotodo → Falso (es el distraído)
        true, // 7. Papá tiburonero → Verdadero
        true // 8. Torta de jamón → Verdadero
    };

    private final String[] explicaciones = {
        "",
        "Son 14 meses, ¡una deuda clásica!",
        "El 71 es por el número de su apartamento.",
        "El barril es solo su escondite; él vive en el apartamento de al lado.",
        "",
        "Godínez es el que vive distraído en el fondo.",
        "",
        ""
    };

    // ── Estado ─────────────────────────────────────────────────────────────
    private int preguntaActual = 0;
    private boolean respondioCorrectamente = false; // distingue si Siguiente avanza o reinicia

    // ── Constructor ────────────────────────────────────────────────────────
    public CntrlFormulario(JFFormulario vista, CntrlDialogos cntrlDialogos) {
        this.vista = vista;
        this.cntrlDialogos = cntrlDialogos;
        conectarBotones();
        mostrarPregunta();
    }

    public void setCntrlDialogos(CntrlDialogos cntrlDialogos) {
        this.cntrlDialogos = cntrlDialogos;
    }

    // ── Listeners ──────────────────────────────────────────────────────────
    private void conectarBotones() {
        vista.btnVerdadero.addActionListener(e -> procesarRespuesta(true));
        vista.btnFalso.addActionListener(e -> procesarRespuesta(false));
        vista.btnSiguiente.addActionListener(e -> avanzarSiguiente());
        vista.btnSiguiente.setEnabled(false);
    }

    // ── Mostrar pregunta ───────────────────────────────────────────────────
    private void mostrarPregunta() {
        vista.txtAMostrar.setText(preguntas[preguntaActual]);
        vista.btnVerdadero.setEnabled(true);
        vista.btnFalso.setEnabled(true);
        // Siguiente se desactiva siempre al mostrar una pregunta
        // EXCEPCIÓN: en pregunta 8 también queda desactivado tras responder
        vista.btnSiguiente.setEnabled(false);
        respondioCorrectamente = false;
    }

    // ── Procesar respuesta ─────────────────────────────────────────────────
    private void procesarRespuesta(boolean eligioVerdadero) {
        boolean esCorrecta = (eligioVerdadero == respuestasCorrectas[preguntaActual]);

        // Desactivar Verdadero/Falso mientras se muestra el resultado
        vista.btnVerdadero.setEnabled(false);
        vista.btnFalso.setEnabled(false);

        if (esCorrecta) {
            if (preguntaActual == 7) {
                // ¡Ganó! — última pregunta correcta
                vista.txtAMostrar.setText("✔ ¡Correcto! ¡Completaste todas las preguntas!");
                vista.btnSiguiente.setEnabled(false); // Siguiente queda desactivado en p.8
                JOptionPane.showMessageDialog(
                        vista,
                        "¡Felicitaciones!\n"
                        + "Respondiste las 8 preguntas correctamente.\n"
                        + "¡Eres todo un experto del Chavo del 8!",
                        "¡Ganaste!",
                        JOptionPane.INFORMATION_MESSAGE
                );
                cntrlDialogos.finalizarBarriga();
                cntrlDialogos.mostrarDialogo();

                cntrlDialogos.getFrmDialogo().setVisible(true);

            } else {
                // Respuesta correcta, no es la última
                vista.txtAMostrar.setText(
                        "✔ ¡Correcto!\n\n"
                        + "Pulsa  →  para ir a la siguiente pregunta."
                );
                respondioCorrectamente = true;
                vista.btnSiguiente.setEnabled(true);
            }
        } else {
            // Respuesta incorrecta
            String eligio = eligioVerdadero ? "Verdadero" : "Falso";
            String nota = explicaciones[preguntaActual].isEmpty()
                    ? ""
                    : "\n(" + explicaciones[preguntaActual] + ")";

            vista.txtAMostrar.setText(
                    "✘ ¡Qué mal! Escogiste \"" + eligio + "\", que es incorrecta." + nota + "\n\n"
                    + "Vuelves a la pregunta 1.\n\n"
                    + "Pulsa  →  para reiniciar."
            );
            respondioCorrectamente = false; // Siguiente va a reiniciar, no a avanzar
            vista.btnSiguiente.setEnabled(true);
        }
    }

    // ── btnSiguiente ───────────────────────────────────────────────────────
    private void avanzarSiguiente() {
        if (respondioCorrectamente) {
            preguntaActual++; // avanza solo si respondió bien
        } else {
            preguntaActual = 0; // reinicia al comienzo por error
        }
        mostrarPregunta();
    }
}
