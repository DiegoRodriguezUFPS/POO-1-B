package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Jugador;
import modelo.Personaje;
import vista.JF3enRaya;
import vista.JFDialogo;
import vista.JFFormulario;
import vista.JFGanador;
import vista.JFMemoria;
import vista.JFReflejos;
import vista.JFVecindad1;
import vista.JFVecindad2;

public class CntrlDialogos implements ActionListener {

    // ── Vistas ─────────────────────────────────────────────────────────────
    JFDialogo frmDialogo;
    JF3enRaya frm3enRaya;
    JFMemoria frmMemoria;
    JFReflejos frmReflejos;
    JFFormulario frmFormulario;
    JFVecindad1 frmVecindad1;
    JFVecindad2 frmVecindad2;
    JFGanador frmGanador;

    // ── Modelo ─────────────────────────────────────────────────────────────
    Jugador jugador;

    // ── Estado de diálogos ─────────────────────────────────────────────────
    ArrayList<String> listaDialogos;
    int indexDialogo;

    // ── Seguimiento de eventos completados ────────────────────────────────
    private boolean completoQuico     = false;
    private boolean completoFlorinda  = false;
    private boolean completoPopis     = false;
    private boolean completoBarriga   = false;

    // ── Instancias de Personaje ────────────────────────────────────────────
    private final Personaje quico       = new Personaje("Quico",       9,  "presumido y llorón",      "antagonista");
    private final Personaje chilindrina = new Personaje("Chilindrina", 10, "pícara y presumida",      "antagonista");
    private final Personaje florinda    = new Personaje("Florinda",    38, "altiva y exigente",       "vecina");
    private final Personaje ramon       = new Personaje("Ramon",       40, "resignado y quejumbroso", "vecino");
    private final Personaje popis       = new Personaje("Popis",       8,  "alegre y juguetona",      "amiga");
    private final Personaje barriga     = new Personaje("Barriga",     50, "autoritario pero justo",  "arrendador");

    // ── Constructor ────────────────────────────────────────────────────────
    public CntrlDialogos(JFDialogo frmDialogo, JF3enRaya frm3enRaya,
            JFMemoria frmMemoria, JFReflejos frmReflejos,
            JFFormulario frmFormulario, JFVecindad1 frmVecindad1,
            JFVecindad2 frmVecindad2, JFGanador frmGanador, Jugador jugador) {

        this.frmDialogo    = frmDialogo;
        this.frm3enRaya    = frm3enRaya;
        this.frmMemoria    = frmMemoria;
        this.frmReflejos   = frmReflejos;
        this.frmFormulario = frmFormulario;
        this.frmVecindad1  = frmVecindad1;
        this.frmVecindad2  = frmVecindad2;
        this.frmGanador    = frmGanador;
        this.jugador       = jugador;

        this.listaDialogos = new ArrayList<>();
        this.indexDialogo  = 0;

        this.frmDialogo.btnSeguir.addActionListener(this);
    }

    // ── Helper ─────────────────────────────────────────────────────────────

    private void cargarDialogos(Personaje personaje) {
        listaDialogos.clear();
        indexDialogo = 0;
        listaDialogos.addAll(personaje.getDialogos());
    }

    // ── Verificar si todos los eventos están completos ─────────────────────

    private void verificarVictoria() {
        if (completoQuico && completoFlorinda && completoPopis && completoBarriga) {
            frmVecindad1.setVisible(false);
            frmVecindad2.setVisible(false);
            frmGanador.txtAGanaste.setText(
                    "¡Felicitaciones, " + jugador.getNombre() + "! Ganaste este juego.\n"
                    + "Gracias por interactuar con todos en la vecindad,\n"
                    + "¡Te esperamos muy pronto!"
            );
            frmGanador.setVisible(true);
        }
    }

    // ── Situaciones ────────────────────────────────────────────────────────

    public void iniciarQuicoYChilindrina() {
        quico.limpiarDialogos();
        quico.agregarDialogo("Quico: ¡Devuelveme mi pelota!");
        quico.agregarDialogo("Chilindrina: ¡No!, ahora es mia y de nadie más.");
        quico.agregarDialogo("Chavo: ¡Madres!, pero, ¿qué está pasando aquí?");
        quico.agregarDialogo("Quico: Apostamos que quien ganara jugando al 3 en raya yo me quedaría con su muñeca");
        quico.agregarDialogo("Chilindrina: Y yo su pelota. Y como yo soy la mejor jugando al 3 en raya, ¡gane! Pero ahora Quico quiere que le devuelva la peltota.");
        quico.agregarDialogo("Quico: Si eres ''Tan buena'' porque no juegas con el chavo, si te gana 3 veces me devuelves la pelota.");
        quico.agregarDialogo("Chilindrina: Acepto, pero no creas que ganarás, Chavo");
        quico.agregarDialogo("Chavo: ¡Quico, yo te devolveré tu querida pelota! \n[Adelante para empezar el juego]");
        quico.agregarDialogo("abrir3enRaya");
        cargarDialogos(quico);

        frmDialogo.lblPersonaje1.setIcon(escalarIcono("/Imagenes/QuicoEnojado.png", 90, 150));
        frmDialogo.lblPersonaje2.setIcon(escalarIcono("/Imagenes/ChilindrinaEnojada.png", 90, 150));
    }

    public void finalizarQuicoYChilindrina() {
        quico.limpiarDialogos();
        quico.agregarDialogo("Chilindrina: ¡Noooooo! La pelota era mía. WUAAA, WUAAAA.");
        quico.agregarDialogo("Quico: ¡Siii! Muchas gracias Chavito, ahora podre seguir jugando con mi pelota ");
        quico.agregarDialogo("acabar");
        cargarDialogos(quico);

        frmDialogo.lblPersonaje1.setIcon(escalarIcono("/Imagenes/QuicoNormal.png", 90, 150));
        frmDialogo.lblPersonaje2.setIcon(escalarIcono("/Imagenes/ChilindrinaTriste.png", 90, 150));
        frmVecindad1.lblQuico.setIcon(escalarIcono("/Imagenes/QuicoPelota.png", 90, 150));
        frmVecindad1.lblChilindrina.setIcon(escalarIcono("/Imagenes/ChilindrinaTriste.png", 90, 150));

        completoQuico = true;
    }

    public void iniciarFlorindayRamon() {
        florinda.limpiarDialogos();
        florinda.agregarDialogo("Ramon: AGH, me rindo, esto es muy complicado.");
        florinda.agregarDialogo("Florinda: Jumph, ¿es que usted es bobo? ¿Como no puede ganar en un juego para niños?");
        florinda.agregarDialogo("Chavo: ¿Pasa algo doña Florinda?");
        florinda.agregarDialogo("Florinda: Queria probar mis nuevas cartas que compre especiales de juntar parejas. Don Ramon se ofrecio para jugar conmigo y, aunque no me parecia buena idea, decidí darle una oportunidad. Y me ha decepcionado totalmente. ¡Hump! Lo esperado de una chusma como el");
        florinda.agregarDialogo("Ramon: No me ando insultado doña Florinda que yo siempre la he tratado con respeto. Además, ¡esto si está bien difícil!");
        florinda.agregarDialogo("Florinda: Deje de mentir, hasta el chavo podría ganar en un pis pas.");
        florinda.agregarDialogo("Ramon: Bueno, pues lo veo, juegue con el chavo, si no voy a poder yo menos un esquincle como el va a poder");
        florinda.agregarDialogo("Florinda: Juguemos, chavito.");
        florinda.agregarDialogo("abrirMemoria");
        cargarDialogos(florinda);

        frmDialogo.lblPersonaje1.setIcon(escalarIcono("/Imagenes/FlorindaEnojada.png", 50, 150));
        frmDialogo.lblPersonaje2.setIcon(escalarIcono("/Imagenes/RamonEnojado.png", 90, 150));
    }

    public void finalizarFlorindayRamon() {
        florinda.limpiarDialogos();
        florinda.agregarDialogo("Florinda: ¡Bien hecho Chavito!");
        florinda.agregarDialogo("Ramon: ¡QUEEE! ¿Como es posible?");
        florinda.agregarDialogo("Florinda: Don Ramon, cada dia me impresiona... ¡Pero a peor! Definitivamente no me debo juntar con una chusma como usted.");
        florinda.agregarDialogo("acabar");
        cargarDialogos(florinda);

        frmDialogo.lblPersonaje1.setIcon(escalarIcono("/Imagenes/FlorindaEnojada.png", 50, 150));
        frmDialogo.lblPersonaje2.setIcon(escalarIcono("/Imagenes/RamonDerrotado.png", 90, 150));
        frmVecindad1.lblRamon.setIcon(escalarIcono("/Imagenes/RamonDerrotado.png", 90, 150));

        completoFlorinda = true;
    }

    public void iniciarPopis() {
        popis.limpiarDialogos();
        popis.agregarDialogo("Popis: ¡¡Chavito, chavito, chavito!!");
        popis.agregarDialogo("Chavo: ¿Qué pasa Popis?");
        popis.agregarDialogo("Popis: ¿Quieres jugar conmigo? ¡Acabo de inventarme un juego bien chido!");
        popis.agregarDialogo("Chavo: Mmmmm, ¿de qué trata?");
        popis.agregarDialogo("Popis: Pondré mi muñeca en el suelo y la ire moviento a todos lados, al tocarla te voy a dar unos ciertos puntos. ¡Si llegas a 200 o más ganas!");
        popis.agregarDialogo("Chavo: ¡Bueno Juguemos!");
        popis.agregarDialogo("abrirReflejos");
        cargarDialogos(popis);

        frmDialogo.lblPersonaje1.setIcon(escalarIcono("/Imagenes/ChavoA.png", 50, 150));
        frmDialogo.lblPersonaje2.setIcon(escalarIcono("/Imagenes/Popis.png", 90, 150));
    }

    public void finalizarPopis() {
        popis.limpiarDialogos();
        popis.agregarDialogo("Popis: ¡Wuaaa lo conseguiste!");
        popis.agregarDialogo("Chavo: Estaba muy facil popis. Para la proxima pon algo más dificil");
        popis.agregarDialogo("Popis: ¡Ya veras la proxima! Por hoy te me escapas.");
        popis.agregarDialogo("acabar");
        cargarDialogos(popis);

        frmDialogo.lblPersonaje1.setIcon(escalarIcono("/Imagenes/ChavoB.png", 90, 150));
        frmDialogo.lblPersonaje2.setIcon(escalarIcono("/Imagenes/Popis.png", 90, 150));

        completoPopis = true;
    }

    public void iniciarBarriga() {
        barriga.limpiarDialogos();
        barriga.agregarDialogo("Barriga: Chavo, venga para acá, necesito su ayuda.");
        barriga.agregarDialogo("Chavo: ¡Hola señor Barriga! ¿qué necesita?");
        barriga.agregarDialogo("Barriga: Verás, tengo que rellenar un formulario con preguntas sobre esta vecindad. Los co-arrendatarios pensaron que era buena idea, y pues me toco hacerla yo.");
        barriga.agregarDialogo("Barriga: Entonces chavo, si lo hace, le prometo que la proxima semana le compro una torta.");
        barriga.agregarDialogo("Chavo: ¿¿¡¡UNA TORTA!!?? Claro, señor Barriga yo le ayudo");
        barriga.agregarDialogo("Barriga: Gracias Chavito");
        barriga.agregarDialogo("abrirFormulario");
        cargarDialogos(barriga);

        frmDialogo.lblPersonaje1.setIcon(escalarIcono("/Imagenes/ChavoA.png", 50, 150));
        frmDialogo.lblPersonaje2.setIcon(escalarIcono("/Imagenes/Barriga.png", 90, 150));
    }

    public void finalizarBarriga() {
        barriga.limpiarDialogos();
        barriga.agregarDialogo("Chavo: Ahí está, señor Barriga.");
        barriga.agregarDialogo("Barriga: Muchas gracias, Chavito, me has salvado de esta.");
        barriga.agregarDialogo("acabar");
        cargarDialogos(barriga);

        frmDialogo.lblPersonaje1.setIcon(escalarIcono("/Imagenes/ChavoA.png", 50, 150));
        frmDialogo.lblPersonaje2.setIcon(escalarIcono("/Imagenes/Barriga.png", 90, 150));

        completoBarriga = true;
    }

    // ── Mostrar diálogo ────────────────────────────────────────────────────

    public void mostrarDialogo() {
        if (listaDialogos.isEmpty() || indexDialogo >= listaDialogos.size()) {
            return;
        }

        String actual = listaDialogos.get(indexDialogo);

        switch (actual) {
            case "acabar":
                frmDialogo.setVisible(false);
                indexDialogo = 0;
                listaDialogos.clear();
                verificarVictoria(); // ← revisa si ya completó todo
                return;
            case "abrir3enRaya":
                frm3enRaya.setVisible(true);
                frmDialogo.setVisible(false);
                indexDialogo = 0;
                listaDialogos.clear();
                return;
            case "abrirMemoria":
                frmDialogo.setVisible(false);
                frmMemoria.setVisible(true);
                indexDialogo = 0;
                listaDialogos.clear();
                return;
            case "abrirReflejos":
                frmDialogo.setVisible(false);
                frmReflejos.setVisible(true);
                indexDialogo = 0;
                listaDialogos.clear();
                return;
            case "abrirFormulario":
                frmDialogo.setVisible(false);
                frmFormulario.setVisible(true);
                indexDialogo = 0;
                listaDialogos.clear();
                return;
            default:
                frmDialogo.txtADialogo.setText(actual);
                indexDialogo++;
        }
    }

    // ── Utilidad: escalar imágenes ─────────────────────────────────────────

    private javax.swing.ImageIcon escalarIcono(String ruta, int ancho, int alto) {
        return new javax.swing.ImageIcon(
            new javax.swing.ImageIcon(getClass().getResource(ruta))
                .getImage()
                .getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH)
        );
    }

    // ── Getters ────────────────────────────────────────────────────────────

    public JFDialogo getFrmDialogo() {
        return frmDialogo;
    }

    public void setFrmDialogo(JFDialogo frmDialogo) {
        this.frmDialogo = frmDialogo;
    }

    public JF3enRaya getFrm3enRaya() {
        return frm3enRaya;
    }

    public void setFrm3enRaya(JF3enRaya frm3enRaya) {
        this.frm3enRaya = frm3enRaya;
    }

    public JFMemoria getFrmMemoria() {
        return frmMemoria;
    }

    public void setFrmMemoria(JFMemoria frmMemoria) {
        this.frmMemoria = frmMemoria;
    }

    public JFFormulario getFrmFormulario() {
        return frmFormulario;
    }

    public void setFrmFormulario(JFFormulario frmFormulario) {
        this.frmFormulario = frmFormulario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmDialogo.btnSeguir) {
            mostrarDialogo();
        }
    }
}
