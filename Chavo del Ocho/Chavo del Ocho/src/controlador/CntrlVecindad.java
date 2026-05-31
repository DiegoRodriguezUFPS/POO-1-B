/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.JF3enRaya;
import vista.JFDialogo;
import vista.JFMemoria;
import vista.JFVecindad1;
import vista.JFVecindad2;

/**
 *
 * @author roca
 */
public class CntrlVecindad implements ActionListener {

    JFVecindad1 frmVecindad1;
    JFVecindad2 frmVecindad2;
    JFDialogo frmDialogo;
    CntrlDialogos cntrlDialogos;

    public CntrlVecindad(JFVecindad1 frmVecindad1, JFVecindad2 frmVecindad2, JFDialogo frmDialogo, CntrlDialogos cntrlDialogos) {
        this.frmVecindad1 = frmVecindad1;
        this.frmVecindad2 = frmVecindad2;
        this.frmDialogo = frmDialogo;
        this.cntrlDialogos = cntrlDialogos;
        
        this.frmVecindad1.btnQuicoYChilindrina.addActionListener(this);
        this.frmVecindad1.btnFlorindaYRamon.addActionListener(this);
        this.frmVecindad1.btnFlechaDerecha.addActionListener(this);
        
        this.frmVecindad2.btnBarriga.addActionListener(this);
        this.frmVecindad2.btnPopis.addActionListener(this);
        this.frmVecindad2.btnFlechaDerecha.addActionListener(this);
    }

    public void situactionQuicoYChilindrina() {
        cntrlDialogos.iniciarQuicoYChilindrina();
        cntrlDialogos.mostrarDialogo();
        frmDialogo.setVisible(true);
        frmVecindad1.btnQuicoYChilindrina.setVisible(false);
    }

    public void situacionFlorindaYRamon() {
        cntrlDialogos.iniciarFlorindayRamon();
        cntrlDialogos.mostrarDialogo();
        frmDialogo.setVisible(true);
        frmVecindad1.btnFlorindaYRamon.setVisible(false);

    }

    public void situactionPopis() {
        cntrlDialogos.iniciarPopis();
        cntrlDialogos.mostrarDialogo();
        frmVecindad2.btnPopis.setVisible(false);

        frmDialogo.setVisible(true);
    }

    public void situacionBarriga() {
        cntrlDialogos.iniciarBarriga();
        cntrlDialogos.mostrarDialogo();
        frmDialogo.setVisible(true);
        frmVecindad2.btnBarriga.setVisible(false);

    }
    
    public void irAVecindad2(){
        frmVecindad1.setVisible(false);
        frmVecindad2.setVisible(true);
    }
    
    public void irAVecindad1(){
        frmVecindad1.setVisible(true);
        frmVecindad2.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmVecindad1.btnQuicoYChilindrina) {
            situactionQuicoYChilindrina();
        }

        if (e.getSource() == frmVecindad1.btnFlorindaYRamon) {
            situacionFlorindaYRamon();
        }

        if (e.getSource() == frmVecindad2.btnPopis) {
            situactionPopis();
        }

        if (e.getSource() == frmVecindad2.btnBarriga) {
            situacionBarriga();
        }
        
        if (e.getSource() == frmVecindad2.btnFlechaDerecha) {
            irAVecindad1();
        }
        
        if (e.getSource() == frmVecindad1.btnFlechaDerecha) {
            irAVecindad2();
        }
    }

}
