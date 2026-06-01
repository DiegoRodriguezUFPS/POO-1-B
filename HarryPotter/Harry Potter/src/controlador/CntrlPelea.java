package controlador;

import modelo.Hechizo;
import vista.JFPelea;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CntrlPelea {

    // ── Vista ──────────────────────────────────────────────────────────────────
    private JFPelea vista;

    // ── Referencia a CntrlDialogo para mostrar escenas entre combates ────────
    private CntrlDialogo cntrlDialogo;

    // ── Combate actual (1, 2 o 3) ─────────────────────────────────────────────
    private int combateActual;

    // ── Estado del combate ─────────────────────────────────────────────────────
    private int vidaJugador    = 50;
    private int vidaMaxJugador = 50;
    private int vidaEnemigo;
    private int vidaMaxEnemigo;

    private boolean elixirDisponible       = true;
    private boolean elixirActivado         = false;
    private boolean esperandoSiguienteTurno = false; // true tras resolver un turno, espera click para nueva narrativa

    private String tipoAtaqueEnemigo;

    // ── Narrativas Combate 1 – Draco (vida enemigo: 50) ────────────────────────
    private static final String[][] NARRATIVAS_C1 = {
        {"FUEGO", "Draco sonr\u00ede con arrogancia mientras el aire alrededor de su varita empieza a distorsionarse por un calor sofocante."},
        {"FUEGO", "Una chispa de un rojo intenso brilla en la punta de la varita de Malfoy, calentando el ambiente del lugar de golpe."},
        {"HIELO", "Malfoy murmura un hechizo entre dientes y notas c\u00f3mo el suelo del lugar empieza a cubrirse de una escarcha resbaladiza."},
        {"HIELO", "Un viento g\u00e9lido cruza el lugar y peque\u00f1os cristales brillantes comienzan a flotar alrededor de la t\u00fanica de Draco."},
        {"AGUA",  "Con un movimiento fluido de su varita, Malfoy invoca un sonido pesado, similar al de una ola rompiendo a gran velocidad."},
        {"AGUA",  "El aire se satura de humedad y pesadas gotas flotantes comienzan a condensarse alrededor de Draco, listas para salir disparadas."}
    };

    // ── Narrativas Combate 2 – Bellatrix (vida enemigo: 70) ───────────────────
    private static final String[][] NARRATIVAS_C2 = {
        {"FUEGO", "Bellatrix suelta una risotada salvaje mientras las sombras del lugar empiezan a bailar fren\u00e9ticamente, recortadas por un resplandor cegador que consume el ox\u00edgeno a tu alrededor."},
        {"FUEGO", "La bruja te mira con ojos desorbitados; un siseo violento y seco brota de su varita, trayendo un s\u00fabito olor a azufre que vuelve la atm\u00f3sfera del lugar pesada e irrespirable."},
        {"HIELO", "Bellatrix sonr\u00ede con malicia pura. De repente, notas c\u00f3mo tu propia respiraci\u00f3n se vuelve visible en el aire del lugar mientras un crujido sordo se extiende r\u00e1pidamente bajo tus pies."},
        {"HIELO", "La mort\u00edfaga dibuja un arco lento en el aire; una palidez antinatural drena el color del lugar y sientes un entumecimiento agudo que te paraliza los dedos de golpe."},
        {"AGUA",  "Una mueca s\u00e1dica deforma su rostro cuando un rugido sordo y torrencial empieza a vibrar en las paredes, distorsionando la luz del lugar como si miraras a trav\u00e9s de un espejo roto."},
        {"AGUA",  "Bellatrix agita su varita con furia; el ambiente del lugar se vuelve tan denso y pesado que sientes una presi\u00f3n sofocante en los o\u00eddos, como si te estuvieras hundiendo a gran profundidad."},
        {"HIELO", "Bellatrix te mira fijamente con una sonrisa macabra y te grita con burla: \"\u00a1Vamos, sangre sucia, desborda tu varita, des\u00e1tame un oc\u00e9ano si te atreves!\""},
        {"HIELO", "Entre carcajadas hist\u00e9ricas, la mort\u00edfaga hace un adem\u00e1n exagerado imitando una fogata y conjura chispas rojas falsas que no queman."}
    };

    // ── Narrativas Combate 3 – Voldemort (vida enemigo: 90) ───────────────────
    private static final String[][] NARRATIVAS_C3 = {
        // FUEGO normales → contraatacar con AGUA
        {"FUEGO", "Voldemort mueve su varita con una elegancia letal; el aire alrededor del lugar comienza a titilar y distorsionarse, mientras sientes que tu piel se reseca y el ox\u00edgeno empieza a escasear de golpe."},
        {"FUEGO", "El Se\u00f1or Tenebroso clava sus ojos rojos en ti en absoluto silencio; un crujido sordo y profundo vibra en el suelo del lugar mientras finas part\u00edculas de ceniza gris comienzan a flotar desde las sombras."},
        {"FUEGO", "De la varita de Voldemort emana un resplandor carms\u00ed tan intenso que borra los l\u00edmites del lugar, proyectando sombras gigantescas que danzan de forma fren\u00e9tica y violenta."},
        // FUEGO trampas → el ambiente simula fuego pero el ataque real es HIELO → contraatacar con FUEGO
        {"HIELO", "El Se\u00f1or Tenebroso inunda el lugar con un resplandor carms\u00ed y un calor sofocante, pero si prestas atenci\u00f3n, de la punta de su varita no sale humo, sino una sutil escarcha blanca que baja por sus p\u00e1lidos dedos."},
        {"HIELO", "Las sombras del lugar bailan como si estuvieran rodeadas de llamas invisibles y un fuerte olor a azufre golpea tu nariz, pero un inquietante sonido de cristales rompi\u00e9ndose delata la verdadera magia que est\u00e1 canalizando."},
        // HIELO normales → contraatacar con FUEGO
        {"HIELO", "Voldemort apunta su varita hacia el suelo del lugar; un silencio sepulcral lo domina todo mientras una capa opaca y cristalina avanza velozmente, haciendo que tu respiraci\u00f3n se vuelva vaho al instante."},
        {"HIELO", "Un entumecimiento agudo y doloroso golpea tus extremidades, y un sonido similar al de cristales rompi\u00e9ndose resuena en las paredes del lugar a medida que el aire parece solidificarse."},
        {"HIELO", "El heredero de Slytherin levanta apenas su mano; la luz natural del lugar se apaga por completo, reemplazada por reflejos geom\u00e9tricos y p\u00e1lidos que destellan peligrosamente alrededor de su t\u00fanica."},
        // HIELO trampas → el ambiente simula hielo pero el ataque real es AGUA → contraatacar con HIELO
        {"AGUA",  "Una r\u00e1faga de viento helado te golpea y Voldemort exhala vaho en medio del lugar, pero bajo tus pies no hay ni rastro de escarcha, sino un charco que brota de la nada con una presi\u00f3n agobiante."},
        {"AGUA",  "El ambiente del lugar se enfr\u00eda de golpe, palideciendo los colores a tu alrededor para enga\u00f1ar tus sentidos; sin embargo, en lugar de entumecimiento, sientes tu ropa extra\u00f1amente pesada y empapada."},
        // AGUA normales → contraatacar con HIELO
        {"AGUA",  "Voldemort traza un arco perfecto en el aire; una presi\u00f3n descomunal aplasta tus o\u00eddos y tu pecho, como si las paredes del lugar se estuvieran hundiendo en las profundidades del oc\u00e9ano."},
        {"AGUA",  "Un rugido fluido y torrencial reverbera en los cimientos del lugar, mientras la luz ambiental se refracta de forma extra\u00f1a, distorsionando las formas como si miraras a trav\u00e9s de una corriente r\u00e1pida."},
        {"AGUA",  "La atm\u00f3sfera del lugar se satura de una humedad tan pesada que espesas gotas flotantes se condensan en el aire, suspendidas como dagas l\u00edquidas listas para ser disparadas."},
        // AGUA trampas → el ambiente simula agua pero el ataque real es FUEGO → contraatacar con AGUA
        {"FUEGO", "Un estruendo similar a una cascada violenta retumba en el lugar y el aire parece ondular como si estuvieras sumergido, pero extra\u00f1amente, sientes la garganta seca y la piel te arde por una temperatura invisible."},
        {"FUEGO", "Voldemort alza la varita y el lugar se llena con un eco de gotas pesadas cayendo al vac\u00edo; no obstante, el intenso resplandor anaranjado que se refleja en sus pupilas rojas revela una combusti\u00f3n letal a punto de estallar."}
    };

    // Cola barajada del combate activo
    private final List<String[]> colaNarrativas = new ArrayList<>();

    // ── Constructor ────────────────────────────────────────────────────────────
    public CntrlPelea(JFPelea vista) {
        this.vista = vista;
        this.combateActual = 1;
        registrarEventos();
    }

    // ── API publica: llamar desde CntrlDialogo ─────────────────────────────────
    public void iniciarCombate(int numeroCombate) {
        cargarCombate(numeroCombate);
    }

    /** Carga todo lo especifico del combate indicado y arranca el primer turno. */
    private void cargarCombate(int numeroCombate) {
        combateActual = numeroCombate;
        cargarImagenes();
        resetearEstado();
        generarTurno();
    }

    // ── Imagenes segun combate ─────────────────────────────────────────────────
    private void cargarImagenes() {
        cargarImagen(vista.lblHarry, "HarryPelea.png", 180, 290);
        switch (combateActual) {
            case 1:
                cargarImagen(vista.lblFondo,      "Comedor.jpg",       806, 484);
                cargarImagen(vista.lblPersonaje2, "DracoPelea.png",    180, 290);
                break;
            case 2:
                cargarImagen(vista.lblFondo,      "Ciudad.jpg",        806, 484);
                cargarImagen(vista.lblPersonaje2, "BellatrixPelea.png",180, 290);
                break;
            case 3:
                cargarImagen(vista.lblFondo,      "Hogwarts.jpeg",     806, 484);
                cargarImagen(vista.lblPersonaje2, "VoldemorPelea.png", 180, 290);
                break;
        }
    }

    private void cargarImagen(JLabel label, String recurso, int ancho, int alto) {
        java.net.URL url = getClass().getClassLoader().getResource("Imagenes/" + recurso);
        if (url != null) {
            ImageIcon original = new ImageIcon(url);
            Image escalada = original.getImage()
                    .getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(escalada));
        } else {
            System.err.println("No se encontro el recurso: " + recurso);
        }
    }

    // ── Reset de estado segun combate ──────────────────────────────────────────
    private void resetearEstado() {
        vidaJugador      = 50;
        vidaMaxJugador   = 50;
        elixirDisponible        = true;
        elixirActivado          = false;
        esperandoSiguienteTurno = false;

        switch (combateActual) {
            case 1: vidaEnemigo = 50; break;
            case 2: vidaEnemigo = 70; break;
            case 3: vidaEnemigo = 90; break;
        }
        vidaMaxEnemigo = vidaEnemigo;

        actualizarVidaJugador();
        actualizarVidaEnemigo();

        vista.btnUsarElixir.setEnabled(true);
        vista.btnSeguirTurno.setEnabled(true);
        vista.txtAMostrar.setText("");

        recargarCola();

        // ── Hechizos (iguales en todos los combates) ───────────────────────────
        vista.comBHechizo.removeAllItems();
        Hechizo[] hechizos = {
            new Hechizo("Aguamenti", "AGUA",  true, "AGU01"),
            new Hechizo("Incendio",  "FUEGO", true, "INC01"),
            new Hechizo("Glacius",   "HIELO", true, "GLA01")
        };
        for (Hechizo h : hechizos) {
            vista.comBHechizo.addItem(h);
        }

        // ── Pociones (iguales en todos los combates) ───────────────────────────
        vista.comBPocion.removeAllItems();
        vista.comBPocion.addItem(null); // indice 0 = "no usar pocion" (seleccion por defecto)
        modelo.Pocion[] pociones = {
            new modelo.Pocion("Pocion de Vida", 20),
            new modelo.Pocion("Pocion de Vida", 20)
        };
        for (modelo.Pocion p : pociones) {
            vista.comBPocion.addItem(p);
        }
        vista.comBPocion.setSelectedIndex(0); // asegurar que arranca en el item vacio
    }

    private void registrarEventos() {
        vista.btnSeguirTurno.addActionListener(e -> procesarTurno());
        vista.btnUsarElixir.addActionListener(e -> activarElixir());
    }

    // ── Gestion de la cola de narrativas ──────────────────────────────────────
    private void recargarCola() {
        colaNarrativas.clear();
        String[][] fuente;
        switch (combateActual) {
            case 1:  fuente = NARRATIVAS_C1; break;
            case 2:  fuente = NARRATIVAS_C2; break;
            default: fuente = NARRATIVAS_C3; break;
        }
        for (String[] entrada : fuente) {
            colaNarrativas.add(entrada);
        }
        Collections.shuffle(colaNarrativas);
    }

    private String[] siguienteNarrativa() {
        if (colaNarrativas.isEmpty()) recargarCola();
        return colaNarrativas.remove(0);
    }

    // ── Generacion de turno ────────────────────────────────────────────────────
    private void generarTurno() {
        String[] entrada  = siguienteNarrativa();
        tipoAtaqueEnemigo = entrada[0];
        vista.txtAMostrar.setText(entrada[1]);
    }

    // ── Procesamiento del turno ────────────────────────────────────────────────
    private void procesarTurno() {
        // Si el combate ya termino, no hacer nada
        if (vidaJugador <= 0 || vidaEnemigo <= 0) return;
        // Si ya se resolvio el turno anterior, cargar nueva narrativa
        if (esperandoSiguienteTurno) {
            esperandoSiguienteTurno = false;
            generarTurno();
            return;
        }
        // Si hay una pocion real seleccionada (no el item vacio del indice 0)
        modelo.Pocion seleccion = (modelo.Pocion) vista.comBPocion.getSelectedItem();
        if (seleccion != null) {
            usarPocion(seleccion);
        } else {
            usarHechizo();
        }
    }

    private void usarPocion(modelo.Pocion pocion) {
        int curacion = 20;
        vidaJugador = Math.min(vidaJugador + curacion, vidaMaxJugador);
        actualizarVidaJugador();
        vista.comBPocion.removeItem(pocion);
        vista.comBPocion.setSelectedIndex(0); // volver al item vacio

        vista.txtAMostrar.setText("Harry ha usado una pocion y recupera " + curacion + " puntos de vida.\nPresiona Siguiente Turno para continuar.");

        esperandoSiguienteTurno = true;
        verificarFinPartida();
    }

    private void usarHechizo() {
        Hechizo hechizoSeleccionado = (Hechizo) vista.comBHechizo.getSelectedItem();
        if (hechizoSeleccionado == null) {
            JOptionPane.showMessageDialog(vista,
                "Selecciona un hechizo para atacar.",
                "Atencion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String  modoJugador   = hechizoSeleccionado.getModo().toUpperCase();
        boolean esEfectivo    = esContraataque(modoJugador, tipoAtaqueEnemigo);
        int     multiplicador = elixirActivado ? 2 : 1;
        int     danio         = 10 * multiplicador;
        String  nombreEnemigo = nombreEnemigo();

        if (esEfectivo) {
            vidaEnemigo = Math.max(vidaEnemigo - danio, 0);
            actualizarVidaEnemigo();
            vista.txtAMostrar.append(elixirActivado
                ? "\n\nEl Elixir amplifica el poder! El hechizo de Harry es devastadoramente efectivo y logra sobrepasar el hechizo de " + nombreEnemigo + ", causando " + danio + " puntos de daño."
                : "\n\nEl hechizo que hizo Harry es efectivo y logra sobrepasar el hechizo del rival, causando " + danio + " puntos de daño.");
        } else {
            vidaJugador = Math.max(vidaJugador - danio, 0);
            actualizarVidaJugador();
            vista.txtAMostrar.append(elixirActivado
                ? "\n\nEl Elixir se vuelve en tu contra! El hechizo de " + nombreEnemigo + " traspasa la defensa de Harry con el doble de fuerza, causando " + danio + " puntos de daño."
                : "\n\nEl hechizo de Harry no fue efectivo. El ataque de " + nombreEnemigo + " impacta a Harry, causando " + danio + " puntos de daño.");
        }

        elixirActivado = false;
        esperandoSiguienteTurno = true;

        verificarFinPartida();
        // El jugador debe presionar btnSeguirTurno para cargar la siguiente narrativa
    }

    // ── Elixir ─────────────────────────────────────────────────────────────────
    private void activarElixir() {
        if (!elixirDisponible) return;
        elixirActivado   = true;
        elixirDisponible = false;
        vista.btnUsarElixir.setEnabled(false);
        vista.txtAMostrar.append("\n\nHarry ha bebido el Elixir Magico! El proximo hechizo tendra el doble de efecto.");
    }

    // ── Logica de contraataque ─────────────────────────────────────────────────
    // Agua > Fuego  |  Fuego > Hielo  |  Hielo > Agua
    private boolean esContraataque(String modoJugador, String modoEnemigo) {
        return (modoJugador.equals("AGUA")  && modoEnemigo.equals("FUEGO"))
            || (modoJugador.equals("FUEGO") && modoEnemigo.equals("HIELO"))
            || (modoJugador.equals("HIELO") && modoEnemigo.equals("AGUA"));
    }

    // ── Nombre del enemigo segun combate ───────────────────────────────────────
    private String nombreEnemigo() {
        switch (combateActual) {
            case 1:  return "Draco";
            case 2:  return "Bellatrix";
            case 3:  return "Voldemort";
            default: return "el enemigo";
        }
    }

    // ── Actualizacion de UI ────────────────────────────────────────────────────
    private void actualizarVidaJugador() {
        vista.txtAVida.setText(vidaJugador + "/" + vidaMaxJugador);
    }

    private void actualizarVidaEnemigo() {
        vista.txtVidaEnemigo.setText(vidaEnemigo + "/" + vidaMaxEnemigo);
    }

    // ── Setter para CntrlDialogo ──────────────────────────────────────────────
    public void setCntrlDialogo(CntrlDialogo cntrlDialogo) {
        this.cntrlDialogo = cntrlDialogo;
    }

    // ── Verificacion de fin de partida ─────────────────────────────────────────
    private void verificarFinPartida() {
        if (vidaJugador <= 0) {
            esperandoSiguienteTurno = false;
            JOptionPane.showMessageDialog(vista,
                "Has sido derrotado por " + nombreEnemigo() + "...\nEl combate se reiniciara!",
                "Has perdido", JOptionPane.ERROR_MESSAGE);
            resetearEstado();
            generarTurno();
        } else if (vidaEnemigo <= 0) {
            if (combateActual == 1 && cntrlDialogo != null) {
                vista.setVisible(false);
                cntrlDialogo.mostrarEscena2();
            } else if (combateActual == 2 && cntrlDialogo != null) {
                vista.setVisible(false);
                cntrlDialogo.mostrarEscena3();
            } else if (combateActual < 3) {
                int siguiente = combateActual + 1;
                JOptionPane.showMessageDialog(vista,
                    "Has ganado al enemigo!\n" + nombreEnemigo() + " ha sido derrotado!",
                    "Victoria!", JOptionPane.INFORMATION_MESSAGE);
                cargarCombate(siguiente);
            } else if (combateActual == 3 && cntrlDialogo != null) {
                vista.setVisible(false);
                cntrlDialogo.mostrarEscena4();
            } else {
                JOptionPane.showMessageDialog(vista,
                    "Has ganado al enemigo!\nHas superado todos los combates!",
                    "Victoria final!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
