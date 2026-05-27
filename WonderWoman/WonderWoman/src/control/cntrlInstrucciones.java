/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.JFInstrucciones;
import vista.JFJuego;

/**
 *
 * @author roca
 */
public class cntrlInstrucciones implements ActionListener{
    JFInstrucciones frmInstrucciones;
    JFJuego frmJuego;

    public cntrlInstrucciones(JFInstrucciones frmInstrucciones, JFJuego frmJuego) {
        this.frmInstrucciones = frmInstrucciones;
        this.frmJuego = frmJuego;
        
        this.frmInstrucciones.btnComenzar.addActionListener(this);
    }

    public void comenzar(){
        frmInstrucciones.dispose();
        frmJuego.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmInstrucciones.btnComenzar) {
            comenzar();
        }
    }
    
}
