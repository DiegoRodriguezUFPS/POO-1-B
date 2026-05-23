/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package figuras.geometricas;

import controlador.ControladorCalculos;
import vista.JFCalculos;

/**
 *
 * @author roca
 */
public class FigurasGeometricas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFCalculos frmCalculos = new JFCalculos();
        ControladorCalculos cntrlCalculos = new ControladorCalculos(frmCalculos);
        
        frmCalculos.setVisible(true);
    }
    
}
