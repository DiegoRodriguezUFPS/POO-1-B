package controlador;

import vista.JFDialogo;
import vista.JFPelea;

import javax.swing.*;
import java.awt.*;

public class CntrlDialogo {

    // ── Vistas y controladores recibidos por constructor ───────────────────────
    private JFDialogo    vista;
    private JFPelea      frmPelea;
    private CntrlPelea   cntrlPelea;

    // ── Indices y motor activo ────────────────────────────────────────────────
    private int pasoActivo  = 0;  // indice del paso actual en motorActivo
    private String[][] motorActivo = null; // null = usando GUION principal

    // ── Constantes de imagen ───────────────────────────────────────────────────
    private static final int W_PERSONAJE = 200;
    private static final int H_PERSONAJE = 320;
    private static final int W_FONDO     = 806;
    private static final int H_FONDO     = 484;

    // ══════════════════════════════════════════════════════════════════════════
    // GUION
    //   {"FONDO",   "archivo"}  → cambia lblFondo
    //   {"P1",      "archivo"}  → cambia lblPersonaje1  ("none" = ocultar)
    //   {"P2",      "archivo"}  → cambia lblPersonaje2  ("none" = ocultar)
    //   {"DIALOGO", "Texto"}    → muestra texto y espera click
    //   {"PELEA",   "N"}        → lanza combate N
    // ══════════════════════════════════════════════════════════════════════════
    private static final String[][] GUION = {

        // ── Escena 1: exterior Hogwarts ───────────────────────────────────────
        {"FONDO",   "Hogwarts.jpeg"},
        {"P1",      "HarryParado.png"},
        {"P2",      "none"},
        {"DIALOGO", "Harry: \"Wow, as\u00ed que esta es el famoso Colegio de Magia. M\u00e1s que un colegio, parece un castillo del rey.\""},
        {"DIALOGO", "Harry: \"Ir\u00e9 a adentrarme, a ver qu\u00e9 puedo encontrar.\""},

        // ── Escena 2: pasillos ────────────────────────────────────────────────
        {"FONDO",   "HogwartsPasillos.jpeg"},
        {"P2",      "Profesor.png"},
        {"DIALOGO", "???: \"Oh, Harry. Aqu\u00ed te encuentras, \u00bfc\u00f3mo te fue en la expedici\u00f3n? \u00bfConseguiste lo que te ped\u00ed?.\""},
        {"DIALOGO", "Harry: \"Perd\u00f3n, \u00bflo conozco?\""},
        {"DIALOGO", "Profesor: \"\u00bfSe encuentra bien jovencito? S\u00ed soy su profesor de magia, desde siempre.\""},
        {"DIALOGO", "Harry: \"Lo siento, debi\u00f3 confundirse con otro Harry, yo soy nuevo en este Colegio.\""},
        {"DIALOGO", "Profesor: \"\u00bfPero qu\u00e9 sandeces dices?... Espera... *El profesor nota cierta aura que brota de Harry* Mmmm parece que fuiste afectado por un hechizo que te hizo olvidar de todo. \u00bfRecuerdas cu\u00e1l es tu apellido?\""},
        {"DIALOGO", "Harry: \"Ahora que lo dice... No realmente.\""},
        {"DIALOGO", "Profesor: \"T\u00fa eres Harry Potter. Y yo soy el Profesor Remus Lupin, hace poco te mand\u00e9 en una expedici\u00f3n con el fin de buscar una fuente de magia oscura y eliminarla. Una tarea f\u00e1cil, no pens\u00e9 podr\u00eda caer en un hechizo como este.\""},
        {"DIALOGO", "Profesor: \"La magia que cay\u00f3 en ti es poderosa, proviene de alg\u00fan mago o bruja oscura, no es f\u00e1cil de eliminar. Pero no hay planta que no se pueda desarraigar.\""},
        {"DIALOGO", "Profesor: \"Este tipo de hechizos tienen una debilidad. Si logras \u2018revivir\u2019 lo que hiciste hoy, recuperar\u00e1s la memoria.\""},
        {"DIALOGO", "Harry: \"\u00bfC\u00f3mo hago eso, profesor?\""},
        {"DIALOGO", "Profesor: \"Primero que todo, dev\u00faelvete al lugar que te mand\u00e9 que fueras, quiz\u00e1s all\u00ed encuentres respuesta. Pero, antes de eso, debo explicarte la magia b\u00e1sica antes de dejarte ir.\""},
        {"DIALOGO", "Profesor: \"Ven, acompa\u00f1ame al sal\u00f3n.\""},

        // ── Escena 3: salon de clase ──────────────────────────────────────────
        {"FONDO",   "SalonClase.jpeg"},
        {"DIALOGO", "Profesor: \"La magia de combate se basa en la reacci\u00f3n y el equilibrio de tres fuerzas esenciales: el Fuego, el Hielo y el Agua. Funciona como un ciclo perfecto donde cada elemento domina a otro.\""},
        {"DIALOGO", "Profesor: \"Empecemos con la primera regla: el Fuego vence al Hielo. Si un enemigo intenta congelarte, debes usar el calor para derretir su ataque en su propia cara.\""},
        {"DIALOGO", "[Harry aprendi\u00f3 el hechizo Incendio \uD83D\uDD25]"},
        {"DIALOGO", "Profesor: \"Ese es \u2018Incendio\u2019, tu hechizo de tipo FUEGO. Pero ten cuidado, si el oponente te contraataca con un torrente de Agua, tu fuego se apagar\u00e1 al instante. Para dominar el Agua, debes congelarla: el Hielo vence al Agua.\""},
        {"DIALOGO", "[Harry aprendi\u00f3 el hechizo Glacius \u2744\uFE0F]"},
        {"DIALOGO", "Profesor: \"Ah\u00ed tienes a \u2018Glacius\u2019, tu magia de tipo HIELO. Y para cerrar el ciclo, si el rival te lanza una llamarada de Fuego, tu hielo se evaporar\u00e1 y quedar\u00e1s indefenso. En ese caso, debes responder con Agua: el Agua apaga al Fuego.\""},
        {"DIALOGO", "[Harry aprendi\u00f3 el hechizo Aguamenti \uD83D\uDCA7]"},
        {"DIALOGO", "Profesor: \"Y ese es \u2018Aguamenti\u2019, tu hechizo de tipo AGUA. Recu\u00e9rdalo bien: el Fuego derrite al Hielo, el Hielo congela al Agua, y el Agua extingue al Fuego.\""},
        {"DIALOGO", "Profesor: \"Si prestas atenci\u00f3n a lo que hace tu oponente y lanzas el elemento fuerte, anular\u00e1s su ofensiva y le causar\u00e1s da\u00f1o. Si te equivocas, t\u00fa recibir\u00e1s el golpe.\""},
        {"DIALOGO", "Profesor: \"Ya conoces las bases, Harry. Es hora de que regreses al lugar de la expedici\u00f3n, enfrentes los peligros y recuperes tu memoria. Pero antes, seguramente est\u00e1s hambriento, ve al comedor y reabastece tus energ\u00edas.\""},
        {"DIALOGO", "Harry: \"S\u00ed, se\u00f1or.\""},

        // ── Escena 4: comedor ─────────────────────────────────────────────────
        {"FONDO",   "Comedor.jpg"},
        {"P2",      "none"},
        {"DIALOGO", "Harry: \"Wow, este lugar s\u00ed que es inmenso y ostentoso, dir\u00eda que demasiado solo para un comedor.\""},
        {"DIALOGO", "Harry, que por estar admirando el comedor, no se da cuenta y tropieza con alguien haciendo que la comida de este caiga al suelo."},
        {"DIALOGO", "???: \"\u00a1Rayos, Potter! \u00bf\u00a1Es qu\u00e9 no tienes ojos o qu\u00e9?!\""},
        {"DIALOGO", "Harry: \"Lo siento, no me fij\u00e9.\""},
        {"DIALOGO", "???: \"\u00a1No! Potter, ya me tienes cansado de tus artima\u00f1as. De esta no te escapar\u00e1s, lo jur\u00f3 por mi nombre, Draco Malfoy.\""},
        {"P2",      "DracoParado.png"},
        {"DIALOGO", "Draco: \"Tengamos un duelo de hechizos para poder al fin darte tu merecido.\""},

        // ── Fin → lanzar combate 1 ────────────────────────────────────────────
        {"PELEA",   "1"}
    };

    // ── Constructor ────────────────────────────────────────────────────────────
    public CntrlDialogo(JFDialogo vista, JFPelea frmPelea, CntrlPelea cntrlPelea) {
        this.vista       = vista;
        this.frmPelea    = frmPelea;
        this.cntrlPelea  = cntrlPelea;
        cntrlPelea.setCntrlDialogo(this); // enlace bidireccional
        registrarEventos();
        ejecutarPasos(); // carga fondo/imagenes iniciales sin esperar click
    }

    // ── Eventos ────────────────────────────────────────────────────────────────
    private void registrarEventos() {
        vista.btnSeguir.addActionListener(e -> avanzar());
    }

    private void avanzar() {
        ejecutarPasosConMotor();
    }

    // ── Motor del guion ────────────────────────────────────────────────────────
    private void ejecutarPasosConMotor() {
        String[][] guion = (motorActivo != null) ? motorActivo : GUION;

        while (pasoActivo < guion.length) {
            String tipo  = guion[pasoActivo][0];
            String valor = guion[pasoActivo][1];
            pasoActivo++;

            switch (tipo) {
                case "FONDO":
                    cargarFondo(valor);
                    break;
                case "P1":
                    cargarPersonaje(vista.lblPersonaje1, valor);
                    break;
                case "P2":
                    cargarPersonaje(vista.lblPersonaje2, valor);
                    break;
                case "DIALOGO":
                    vista.txtDialogo.setText(valor);
                    return; // esperar siguiente click del boton
                case "PELEA":
                    lanzarPelea(Integer.parseInt(valor));
                    return;
                case "FIN":
                    vista.btnSeguir.setEnabled(false);
                    return;
            }
        }
    }

    // Metodo original redirige al motor con GUION principal
    private void ejecutarPasos() {
        motorActivo = null;
        pasoActivo  = 0;
        ejecutarPasosConMotor();
    }

    // ── Carga de imagenes ──────────────────────────────────────────────────────
    private void cargarFondo(String recurso) {
        java.net.URL url = getClass().getClassLoader().getResource("Imagenes/" + recurso);
        if (url != null) {
            Image img = new ImageIcon(url).getImage()
                    .getScaledInstance(W_FONDO, H_FONDO, Image.SCALE_SMOOTH);
            vista.lblFondo.setIcon(new ImageIcon(img));
        } else {
            System.err.println("Fondo no encontrado: Imagenes/" + recurso);
        }
    }

    private void cargarPersonaje(JLabel label, String recurso) {
        if (recurso.equalsIgnoreCase("none")) {
            label.setIcon(null);
            return;
        }
        java.net.URL url = getClass().getClassLoader().getResource("Imagenes/" + recurso);
        if (url != null) {
            Image img = new ImageIcon(url).getImage()
                    .getScaledInstance(W_PERSONAJE, H_PERSONAJE, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
        } else {
            System.err.println("Personaje no encontrado: Imagenes/" + recurso);
        }
    }

    // ── Lanzar pelea ───────────────────────────────────────────────────────────
    private void lanzarPelea(int numeroCombate) {
        vista.setVisible(false);
        cntrlPelea.iniciarCombate(numeroCombate);
        frmPelea.setVisible(true);
    }

    // ══════════════════════════════════════════════════════════════════════════
    // GUION ESCENA 2 – Post combate 1, pre combate 2
    // ══════════════════════════════════════════════════════════════════════════
    private static final String[][] GUION_ESCENA2 = {

        // ── Post-combate: comedor ─────────────────────────────────────────────
        {"FONDO",   "Comedor.jpg"},
        {"P1",      "HarryParado.png"},
        {"P2",      "DracoParado.png"},
        {"DIALOGO", "Draco: \"\u00a1Maldici\u00f3n, Potter! \u00bf\u00a1C\u00f3mo es posible que me hayas derrotado!? Esto no se va a quedar as\u00ed, \u00a1te lo juro!\""},
        {"DIALOGO", "Harry: \"Ni yo mismo s\u00e9 c\u00f3mo lo hice, Malfoy... Pero no tengo tiempo para tus amenazas, debo marcharme.\""},

        // ── Hogwarts: aparece el grifo ────────────────────────────────────────
        {"FONDO",   "Hogwarts.jpeg"},
        {"P2",      "Griffo.png"},
        {"DIALOGO", "Harry: \"Espera... Al ver a esta criatura, algo en mi mente hace click. \u00a1Empiezo a recordar que el transporte que us\u00e9 para ir a donde me indic\u00f3 el profesor fue este grifo!\""},
        {"DIALOGO", "Griffo: \"\u00a1\u00a1\u00a1Griaaaaaaa!!! *Agita sus majestuosas alas*\""},
        {"DIALOGO", "Harry: \"\u00a1S\u00ed, eres t\u00fa! Tengo que volver de inmediato a ese lugar si quiero romper este hechizo de amnesia. \u00a1S\u00e1came de aqu\u00ed, amigo!\""},

        // ── Ciudad: llegada ───────────────────────────────────────────────────
        {"FONDO",   "Ciudad.jpg"},
        {"P2",      "none"},
        {"DIALOGO", "Harry: \"\u00a1Vaya! El viaje fue una locura... Pero mirar estas casas est\u00e1 haciendo que mis recuerdos regresen poco a poco. \u00a1Ya s\u00e9 c\u00f3mo se llama este sitio! Esta es la Ciudad de Grimvalle.\""},
        {"DIALOGO", "Harry: \"Yo, antes de ir a donde me mandaron, fui a comprar una varita nueva por si acaso. Deber\u00eda ir a la tienda de varitas y preguntarle al vendedor si le dije a d\u00f3nde iba.\""},

        // ── Tienda de varitas ─────────────────────────────────────────────────
        {"FONDO",   "TiendaVaritas.jpg"},
        {"P2",      "VendedorTienda.png"},
        {"DIALOGO", "Harry: \"\u00a1Hola! Buenas tardes. Disculpe la molestia, pero quer\u00eda hacerle una pregunta...\""},
        {"DIALOGO", "Vendedor: \"\u00a1Ah! Pero si t\u00fa no eres el jovencito que me visit\u00f3 anteriormente. Qu\u00e9 sorpresa tenerte de vuelta tan r\u00e1pido, muchacho.\""},
        {"DIALOGO", "Harry: \"S\u00ed, soy yo... Ver\u00e1, es algo dif\u00edcil de explicar, pero sufr\u00ed un accidente y perd\u00ed la memoria. \u00bfDe casualidad recuerda si le mencion\u00e9 a d\u00f3nde me dirig\u00eda cuando sal\u00ed de aqu\u00ed?\""},
        {"DIALOGO", "Vendedor: \"\u00a1Por las barbas de Merl\u00edn! Qu\u00e9 desgracia... A ver, d\u00e9jame hacer memoria. \u00a1Ah, s\u00ed! Recuerdo que estabas muy apurado y me dijiste que te ibas a un bosque lejano de por ah\u00ed a cumplir una misi\u00f3n importante.\""},
        {"DIALOGO", "Narrador: \"De repente, una serie de gritos aterradores y el sonido de explosiones rompen la tranquilidad desde el exterior de la tienda, cortando la conversaci\u00f3n de golpe.\""},

        // ── Ciudad: aparece Bellatrix ─────────────────────────────────────────
        {"FONDO",   "Ciudad.jpg"},
        {"P1",      "none"},
        {"P2",      "BellatrixParada.png"},
        {"DIALOGO", "Bellatrix: \"\u00a1JAJAJAJAJA! \u00a1Corran, corran como las cucarachas que son! \u00a1No hay ning\u00fan lugar donde puedan esconderse de nosotros!\""},
        {"DIALOGO", "Bellatrix: \"\u00a1Miren c\u00f3mo tiemblan! Me encanta ver el p\u00e1nico en sus rostros... \u00a1Reduzcan este pat\u00e9tico sitio a cenizas! \u00a1JAJAJAJAJA!\""},

        // ── Harry entra en escena ─────────────────────────────────────────────
        {"P1",      "HarryParado.png"},
        {"DIALOGO", "Harry: \"\u00a1Alto ah\u00ed! \u00a1Deja en paz a esta gente, Bellatrix!\""},
        {"DIALOGO", "Bellatrix: \"\u00a1Vaya, vaya! \u00bfPero a qui\u00e9n tenemos aqu\u00ed? Si es el mocoso de antes... Veo que lograste escapar de mis garras en el bosque, Potter.\""},
        {"DIALOGO", "Bellatrix: \"\u00bfY dime, c\u00f3mo te va con el precioso regalo que te lanc\u00e9? \u00a1O mejor dicho, con tu absoluta FALTA de recuerdos! \u00a1JAJAJAJAJA!\""},
        {"DIALOGO", "Harry: \"\u00a1As\u00ed que fuiste t\u00fa...! T\u00fa eres la culpable de que no pueda recordar nada de lo que pas\u00f3 hoy.\""},
        {"DIALOGO", "Bellatrix: \"\u00a1Fui yo, mi querido y est\u00fapido Potter! Y esta vez no me limitar\u00e9 a borrar tu mente... \u00a1Esta vez voy a destruirte por completo! \u00a1Prepara tu varita!\""},
        {"DIALOGO", "Harry: \"A\u00fan no recupero toda mi memoria, pero el Profesor Lupin me ense\u00f1\u00f3 lo necesario para detenerte. \u00a1No te tengo miedo!\""},

        // ── Lanzar combate 2 ──────────────────────────────────────────────────
        {"PELEA",   "2"}
    };

    /** Llamado por CntrlPelea al ganar el combate 1. */
    public void mostrarEscena2() {
        pasoActivo  = 0;
        motorActivo = GUION_ESCENA2;
        vista.btnSeguir.setEnabled(true);
        vista.setVisible(true);
        ejecutarPasosConMotor();
    }


    // ══════════════════════════════════════════════════════════════════════════
    // GUION ESCENA 3 – Post combate 2, pre combate 3
    // ══════════════════════════════════════════════════════════════════════════
    private static final String[][] GUION_ESCENA3 = {

        // ── Ciudad: post-combate Bellatrix ────────────────────────────────────
        {"FONDO",   "Ciudad.jpg"},
        {"P1",      "HarryParado.png"},
        {"P2",      "BellatrixParada.png"},
        {"DIALOGO", "Bellatrix: \"\u00a1Maldito mocoso...! Puede que hayas ganado esta batalla, \u00a1pero no has ganado la guerra! \u00a1JAJAJAJAJA!\""},
        {"DIALOGO", "Bellatrix: \"Crees que me detuviste, pero llegas tarde. La fuente de magia oscura en el bosque era mucho m\u00e1s grande de lo que parec\u00eda... \u00a1Yo misma la canalic\u00e9 y se la env\u00ed a Lord Voldemort!\""},
        {"DIALOGO", "Bellatrix: \"\u00a1Con ese poder destructivo, el Se\u00f1or Tenebroso piensa borrar a Hogwarts del mapa, y en este preciso momento ya va de camino hacia all\u00e1! \u00a1JAJAJAJAJA!\""},

        // ── Bellatrix huye ────────────────────────────────────────────────────
        {"P2",      "none"},
        {"DIALOGO", "Narrador: \"Bellatrix agita su varita con furia y se desvanece en el aire en medio de una r\u00e1faga de humo negro, dejando su risa desquiciada resonando en el ambiente.\""},
        {"DIALOGO", "Harry: \"\u00a1Oh, no! \u00a1Debo salvar Hogwarts de inmediato! Si el castillo cae, todo estar\u00e1 perdido.\""},

        // ── Aparece el grifo ──────────────────────────────────────────────────
        {"P2",      "Griffo.png"},
        {"DIALOGO", "Griffo: \"\u00a1\u00a1\u00a1Griaaaaaaa!!! *Desciende del cielo rugiendo con fuerza*\""},
        {"DIALOGO", "Harry: \"\u00a1Amigo, qu\u00e9 bueno que apareces! S\u00fabete, tenemos que ir lo m\u00e1s r\u00e1pido posible hacia el colegio. \u00a1Lleg\u00f3 el momento de sacar todo tu potencial, vamos!\""},

        // ── Hogwarts: llegada ─────────────────────────────────────────────────
        {"FONDO",   "Hogwarts.jpeg"},
        {"P2",      "none"},
        {"DIALOGO", "Harry: \"\u00bfHabr\u00e9 llegado demasiado tarde? No veo a Voldemort por ning\u00fan lado... Espera, \u00bfqu\u00e9 es esa silueta oscura en la entrada? \u00a1Ah\u00ed est\u00e1!\""},

        // ── Aparece Voldemort ─────────────────────────────────────────────────
        {"P2",      "VoldemorParado.png"},
        {"DIALOGO", "Voldemort: \"\u00a1Por fin el poder absoluto de la magia oscura es m\u00edo! Nadie podr\u00e1 interponerse en mi camino... \u00a1Voy a reducir este pat\u00e9tico castillo a cenizas! \u00a1JAJAJAJAJA!\""},
        {"DIALOGO", "Harry: \"\u00a1Eso jam\u00e1s va a pasar, Voldemort! No permitir\u00e9 que destruyas este lugar. \u00a1Yo mismo te voy a detener!\""},

        // ── Lanzar combate 3 ──────────────────────────────────────────────────
        {"PELEA",   "3"}
    };

    /** Llamado por CntrlPelea al ganar el combate 2. */
    public void mostrarEscena3() {
        pasoActivo  = 0;
        motorActivo = GUION_ESCENA3;
        vista.btnSeguir.setEnabled(true);
        vista.setVisible(true);
        ejecutarPasosConMotor();
    }


    // ══════════════════════════════════════════════════════════════════════════
    // GUION ESCENA 4 – Post combate 3, final del juego
    // ══════════════════════════════════════════════════════════════════════════
    private static final String[][] GUION_ESCENA4 = {
        {"FONDO",   "Hogwarts.jpeg"},
        {"P1",      "HarryParado.png"},
        {"P2",      "Profesor.png"},
        {"DIALOGO", "Profesor: \"\u00a1Por las barbas de Merl\u00edn, Harry! \u00a1Lo hiciste! Has derrotado al mism\u00edsimo Lord Voldemort y has salvado a Hogwarts de una destrucci\u00f3n segura. \u00a1Fue una demostraci\u00f3n de magia excepcional!\""},
        {"DIALOGO", "Harry: \"*Se lleva una mano a la cabeza, tambale\u00e1ndose un poco* Ah... Profesor... Siento una sensaci\u00f3n muy extra\u00f1a en el pecho... Como si algo se estuviera rompiendo dentro de mi mente.\""},
        {"DIALOGO", "Profesor: \"\u00bfTe encuentras bien, Harry? D\u00e9jame revisar tu aura...\""},
        {"DIALOGO", "Harry: \"\u00a1Espere! Las im\u00e1genes... los rostros... \u00a1Ya lo recuerdo! \u00a1Recuerdo todo, profesor!\""},
        {"DIALOGO", "Profesor: \"\u00a1Fant\u00e1stico! Cu\u00e9ntame, \u00bfel efecto del maleficio desapareci\u00f3 por completo?\""},
        {"DIALOGO", "Harry: \"S\u00ed. Recuerdo perfectamente la expedici\u00f3n en el bosque lejano, c\u00f3mo encontr\u00e9 la fuente de magia oscura y el momento exacto en el que Bellatrix me emboscó por la espalda para rob\u00e1rsela y lanzarme ese maldito hechizo de amnesia.\""},
        {"DIALOGO", "Profesor: \"Tal como te lo dije en el sal\u00f3n: no hab\u00eda planta que no se pudiera desarraigar. Al enfrentarte a Draco, a Bellatrix y finalmente al Se\u00f1or Tenebroso, lograste 'revivir' las emociones y la magia de tu d\u00eda. Esa era la \u00fanica debilidad de un encantamiento tan oscuro.\""},
        {"DIALOGO", "Harry: \"No lo habr\u00eda conseguido sin usted, profesor. Recordar el ciclo del Fuego, el Hielo y el Agua en medio de los combates fue lo que me mantuvo con vida.\""},
        {"DIALOGO", "Profesor: \"El conocimiento es solo una herramienta, Harry, pero el valor para usarlo fue completamente tuyo. Ahora, el peligro ha pasado. Anda adentro, te has ganado un banquete bien merecido en el comedor... y esta vez, procura no tropezar con nadie.\""},
        {"DIALOGO", "Harry: \"*Se r\u00ede aliviado* \u00a1Se lo prometo, profesor! Esta vez mirar\u00e9 bien por d\u00f3nde camino.\""},
        {"FIN",     ""}
    };

    /** Llamado por CntrlPelea al ganar el combate 3. */
    public void mostrarEscena4() {
        pasoActivo  = 0;
        motorActivo = GUION_ESCENA4;
        vista.btnSeguir.setEnabled(true);
        vista.setVisible(true);
        ejecutarPasosConMotor();
    }

}