/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.JFBienvenida;
import vista.JFVecindad1;

/**
 *
 * @author roca
 */
public class CntrlBienvenida implements ActionListener{
    JFBienvenida frmBienvenida;
    JFVecindad1 frmVecindad1;

    public CntrlBienvenida(JFBienvenida frmBienvenida, JFVecindad1 frmVecindad1) {
        this.frmBienvenida = frmBienvenida;
        this.frmVecindad1 = frmVecindad1;
        
        this.frmBienvenida.btnEmpezar.addActionListener(this);
    }
    
    public void empezar(){
        frmVecindad1.setVisible(true);
        frmBienvenida.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmBienvenida.btnEmpezar) {
            empezar();
        }
    }
    
    
}
