/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caperucitaroja;

import controlador.CntrlCaperucita;
import vista.JFCaperucita;

/**
 *
 * @author roca
 */
public class CaperucitaRoja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFCaperucita frmCaperucita = new JFCaperucita();
        CntrlCaperucita cntrlCaperucita = new CntrlCaperucita(frmCaperucita);
        frmCaperucita.setVisible(true);
        
    }
    
}
