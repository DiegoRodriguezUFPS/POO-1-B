/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import vista.JF3enRaya;
import vista.JFDialogo;
import vista.JFFormulario;
import vista.JFMemoria;
import vista.JFReflejos;
import vista.JFVecindad1;
import vista.JFVecindad2;

/**
 *
 * @author roca
 */
public class CntrlDialogos implements ActionListener {

    JFDialogo frmDialogo;
    ArrayList<String> listaDialogos;
    int indexDialogo;
    JF3enRaya frm3enRaya;
    JFMemoria frmMemoria;
    JFReflejos frmReflejos;
    JFFormulario frmFormulario;
    JFVecindad1 frmVecindad1;
    JFVecindad2 frmVecindad2;

    public CntrlDialogos(JFDialogo frmDialogo, JF3enRaya frm3enRaya,
            JFMemoria frmMemoria,
            JFReflejos frmReflejos, JFFormulario frmFormulario, JFVecindad1 frmVecindad1,
            JFVecindad2 frmVecindad2) {
        this.frmDialogo = frmDialogo;
        this.frm3enRaya = frm3enRaya;
        this.frmMemoria = frmMemoria;
        this.frmReflejos = frmReflejos;
        this.frmFormulario = frmFormulario;
        this.listaDialogos = new ArrayList<>();
        this.indexDialogo = 0;
        this.frmVecindad1 = frmVecindad1;
        this.frmVecindad2 = frmVecindad2;

        this.frmDialogo.btnSeguir.addActionListener(this);

    }

    private void prepararDialogos() {
        listaDialogos.clear();
        indexDialogo = 0;
    }

    public void mostrarDialogo() {
        if (listaDialogos.isEmpty() || indexDialogo >= listaDialogos.size()) {
            return;
        }

        String actual = listaDialogos.get(indexDialogo);

        if (actual.equals("acabar")) {
            frmDialogo.setVisible(false);
            indexDialogo = 0;
            listaDialogos.clear();
            return;
        }
        if (actual.equals("abrir3enRaya")) {
            frm3enRaya.setVisible(true);
            frmDialogo.setVisible(false);
            indexDialogo = 0;
            listaDialogos.clear();
            return;
        }
        if (actual.equals("abrirMemoria")) {
            frmDialogo.setVisible(false);
            frmMemoria.setVisible(true);
            indexDialogo = 0;
            listaDialogos.clear();
            return;
        }
        if (actual.equals("abrirReflejos")) {
            frmDialogo.setVisible(false);
            frmReflejos.setVisible(true);
            indexDialogo = 0;
            listaDialogos.clear();
            return;
        }
        if (actual.equals("abrirFormulario")) {
            frmDialogo.setVisible(false);
            frmFormulario.setVisible(true);
            indexDialogo = 0;
            listaDialogos.clear();
            return;
        }

        frmDialogo.txtADialogo.setText(actual);
        indexDialogo++;
    }

    public void iniciarQuicoYChilindrina() {
        prepararDialogos();
        frmDialogo.lblPersonaje1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/QuicoEnojado.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));
        frmDialogo.lblPersonaje2.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ChilindrinaEnojada.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));

        listaDialogos.add("Quico: ¡Devuelveme mi pelota!");
        listaDialogos.add("Chilindrina: ¡No!, ahora es mia y de nadie más.");
        listaDialogos.add("Chavo: ¡Madres!, pero, ¿qué está pasando aquí?");
        listaDialogos.add("Quico: Apostamos que quien ganara jugando al 3 en raya yo me quedaría con su muñeca");
        listaDialogos.add("Chilindrina: Y yo su pelota. Y como yo soy la mejor jugando al 3 en raya, ¡gane! Pero ahora Quico quiere que le devuelva la peltota.");
        listaDialogos.add("Quico: Si eres ''Tan buena'' porque no juegas con el chavo, si te gana 3 veces me devuelves la pelota.");
        listaDialogos.add("Chilindrina: Acepto, pero no creas que ganarás, Chavo");
        listaDialogos.add("Chavo: ¡Quico, yo te devolveré tu querida pelota! \n[Adelante para empezar el juego]");
        listaDialogos.add("abrir3enRaya");
    }

    public void finalizarQuicoYChilindrina() {
        prepararDialogos();
        frmDialogo.lblPersonaje1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/QuicoNormal.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));
        frmDialogo.lblPersonaje2.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ChilindrinaTriste.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));

        listaDialogos.add("Chilindrina: ¡Noooooo! La pelota era mía. WUAAA, WUAAAA.");
        listaDialogos.add("Quico: ¡Siii! Muchas gracias Chavito, ahora podre seguir jugando con mi pelota ");
        listaDialogos.add("acabar");
        
        frmVecindad1.lblQuico.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/QuicoPelota.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));
        frmVecindad1.lblChilindrina.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ChilindrinaTriste.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));

    }

    public void iniciarFlorindayRamon() {
        prepararDialogos();
        frmDialogo.lblPersonaje1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FlorindaEnojada.png")).getImage().getScaledInstance(50, 150, java.awt.Image.SCALE_SMOOTH)));
        frmDialogo.lblPersonaje2.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RamonEnojado.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));

        listaDialogos.add("Ramon: AGH, me rindo, esto es muy complicado.");
        listaDialogos.add("Florinda: Jumph, ¿es que usted es bobo? ¿Como no puede ganar en un juego para niños?");
        listaDialogos.add("Chavo: ¿Pasa algo doña Florinda");
        listaDialogos.add("Florinda: Queria probar mis nuevas cartas que compre especiales de juntar parejas. Don Ramon se ofrecio para jugar conmigo y, aunque no me parecia buena idea, decidí darle una oportunidad. Y me ha decepcionado totalmente. ¡Hump! Lo esperado de una chusma como el");
        listaDialogos.add("Ramon: No me ando insultado doña Florinda que yo siempre la he tratado con respeto. Además, ¡esto si está bien difícil!");
        listaDialogos.add("Florinda: Deje de mentir, hasta el chavo podría ganar en un pis pas.");
        listaDialogos.add("Ramon: Bueno, pues lo veo, juegue con el chavo, si no voy a poder yo menos un esquincle como el va a poder");
        listaDialogos.add("Florinda: Juguemos, chavito.");
        listaDialogos.add("abrirMemoria");
    }

    public void finalizarFlorindayRamon() {
        prepararDialogos();
        frmDialogo.lblPersonaje1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FlorindaEnojada.png")).getImage().getScaledInstance(50, 150, java.awt.Image.SCALE_SMOOTH)));
        frmDialogo.lblPersonaje2.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RamonDerrotado.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));

        listaDialogos.add("Florinda: ¡Bien hecho Chavito!");
        listaDialogos.add("Ramon: ¡QUEEE! ¿Como es posible?");
        listaDialogos.add("Florinda: Don Ramon, cada dia me impresiona... ¡Pero a peor! Definitivamente no me debo juntar con una chusma como usted.");
        listaDialogos.add("acabar");
        
        frmVecindad1.lblRamon.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RamonDerrotado.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));


    }

    public void iniciarPopis() {
        prepararDialogos();
        frmDialogo.lblPersonaje1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ChavoA.png")).getImage().getScaledInstance(50, 150, java.awt.Image.SCALE_SMOOTH)));
        frmDialogo.lblPersonaje2.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Popis.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));

        listaDialogos.add("Popis: ¡¡Chavito, chavito, chavito!!");
        listaDialogos.add("Chavo: ¿Qué pasa Popis?");
        listaDialogos.add("Popis: ¿Quieres jugar conmigo? ¡Acabo de inventarme un juego bien chido!");
        listaDialogos.add("Chavo: Mmmmm, ¿de qué trata?");
        listaDialogos.add("Popis: Pondré mi muñeca en el suelo y la ire moviento a todos lados, al tocarla te voy a dar unos ciertos puntos. ¡Si llegas a 200 o más ganas!");
        listaDialogos.add("Chavo: ¡Bueno Juguemos!");
        listaDialogos.add("abrirReflejos");
    }

    public void finalizarPopis() {
        prepararDialogos();
        frmDialogo.lblPersonaje1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ChavoB.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));
        frmDialogo.lblPersonaje2.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Popis.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));

        listaDialogos.add("Popis: ¡Wuaaa lo conseguiste!");
        listaDialogos.add("Chavo: Estaba muy facil popis. Para la proxima pon algo más dificil");
        listaDialogos.add("Popis: ¡Ya veras la proxima! Por hoy te me escapas.");
        listaDialogos.add("acabar");
    }

    public void iniciarBarriga() {
        prepararDialogos();
        frmDialogo.lblPersonaje1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ChavoA.png")).getImage().getScaledInstance(50, 150, java.awt.Image.SCALE_SMOOTH)));
        frmDialogo.lblPersonaje2.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Barriga.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));

        listaDialogos.add("Barriga: Chavo, venga para acá, necesito su ayuda.");
        listaDialogos.add("Chavo: ¡Hola señor Barriga! ¿qué necesita?");
        listaDialogos.add("Barriga: Verás, tengo que rellenar un formulario con preguntas sobre esta vecindad. Los co-arrendatarios pensaron que era buena idea, y pues me toco hacerla yo.");
        listaDialogos.add("Barriga: Entonces chavo, si lo hace, le prometo que la proxima semana le compro una torta.");
        listaDialogos.add("Chavo: ¿¿¡¡UNA TORTA!!?? Claro, señor Barriga yo le ayudo");
        listaDialogos.add("Barriga: Gracias Chavito");
        listaDialogos.add("abrirFormulario");
    }

    public void finalizarBarriga() {
        prepararDialogos();
        frmDialogo.lblPersonaje1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ChavoA.png")).getImage().getScaledInstance(50, 150, java.awt.Image.SCALE_SMOOTH)));
        frmDialogo.lblPersonaje2.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Barriga.png")).getImage().getScaledInstance(90, 150, java.awt.Image.SCALE_SMOOTH)));

        listaDialogos.add("Chavo: Ahí está, señor Barriga.");
        listaDialogos.add("Barriga: Muchas gracias, Chavito, me has salvado de esta.");
        listaDialogos.add("acabar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmDialogo.btnSeguir) {
            mostrarDialogo();
        }
    }

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

}
