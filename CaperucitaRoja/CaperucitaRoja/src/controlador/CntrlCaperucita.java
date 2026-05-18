/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.JFCaperucita;

/**
 *
 * @author roca
 */
public class CntrlCaperucita implements ActionListener{
    JFCaperucita frmCaperucita;
    

    public CntrlCaperucita() {
    }

    public CntrlCaperucita(JFCaperucita frmCaperucita) {
        this.frmCaperucita = frmCaperucita;
        this.frmCaperucita.btnDerecha.addActionListener(this);
        this.frmCaperucita.btnCanasta.addActionListener(this);
        this.frmCaperucita.btnAbajo.addActionListener(this);
        this.frmCaperucita.btnArriba.addActionListener(this);
        
        //
        this.frmCaperucita.btnArriba.setEnabled(false);
        this.frmCaperucita.btnizquierda.setEnabled(false);
    }
    
    public void mover derecha;
    
    

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmCaperucita.btnDerecha) {
            
        }
    }
}
