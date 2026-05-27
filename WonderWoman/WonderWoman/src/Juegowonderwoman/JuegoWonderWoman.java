/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Juegowonderwoman;

import vista.*;
import control.*;



public class JuegoWonderWoman{

    public static void main(String[] args) {
        JFJuego frmJuego = new JFJuego();
        JFInstrucciones frmInstrucciones = new JFInstrucciones();
        
        cntrlInstrucciones controladorIns = new cntrlInstrucciones(frmInstrucciones, frmJuego);
        
        JFRuletaEquipo frmRuletaEquipo = new JFRuletaEquipo();
        JFRuletaHabilidad frmRuletaHabilidad = new JFRuletaHabilidad();
        cntrlJuego controlador = new cntrlJuego(frmJuego, frmRuletaEquipo, frmRuletaHabilidad);
        frmInstrucciones.setVisible(true);
        
        
    }
    
}
