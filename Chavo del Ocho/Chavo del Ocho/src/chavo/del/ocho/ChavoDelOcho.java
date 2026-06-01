/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chavo.del.ocho;

import controlador.Cntrl3enRaya;
import controlador.CntrlBienvenida;
import controlador.CntrlDialogos;
import controlador.CntrlFormulario;
import controlador.CntrlVecindad;
import modelo.Jugador;
import modelo.Vecindad;
import vista.JF3enRaya;
import vista.JFBienvenida;
import vista.JFDialogo;
import vista.JFFormulario;
import vista.JFGanador;
import vista.JFMemoria;
import vista.JFReflejos;
import vista.JFVecindad1;
import vista.JFVecindad2;

/**
 *
 * @author roca
 */
public class ChavoDelOcho {

    public static vista.JF3enRaya frm3enRaya;
    public static vista.JFMemoria frmMemoria;
    public static vista.JFReflejos frmReflejos;
    public static vista.JFFormulario frmFormulario;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Objetos
        Jugador jugador = new Jugador();
        Vecindad vecindad1 = new Vecindad("Vecindad1", "Primera parte", "/Imagenes/Vecindad1.jpeg");
        Vecindad vecindad2 = new Vecindad("Vecindad2", "Primera parte", "/Imagenes/Vecindad2.jpeg");

        JFVecindad1 frmVencindad1 = new JFVecindad1();
        JFVecindad2 frmFVecindad2 = new JFVecindad2();
        JFBienvenida frmBienvenida = new JFBienvenida();
        JFDialogo frmDialogo = new JFDialogo();
        JFGanador frmGanador = new JFGanador();

        frm3enRaya = new vista.JF3enRaya();
        frmReflejos = new JFReflejos();
        frmFormulario = new JFFormulario();
        frmMemoria = new JFMemoria();

        CntrlDialogos cntrlDialogos = new CntrlDialogos(frmDialogo, frm3enRaya, frmMemoria, frmReflejos, frmFormulario, frmVencindad1, frmFVecindad2, frmGanador, jugador);

        frm3enRaya.getCntrl3enRaya().setCntrlDialogos(cntrlDialogos);
        frmReflejos.getCntrlReflejos().setCntrlDialogos(cntrlDialogos);
        frmMemoria.getCntrlMemoria().setCntrlDialogos(cntrlDialogos);

        CntrlBienvenida cntrlBienvenida = new CntrlBienvenida(frmBienvenida, frmVencindad1, jugador);
        frmBienvenida.setVisible(true);
        CntrlFormulario cntrlFormulario = new CntrlFormulario(frmFormulario, cntrlDialogos);
        CntrlVecindad cntrlVecindad = new CntrlVecindad(frmVencindad1, frmFVecindad2, frmDialogo, cntrlDialogos);

    }

}
