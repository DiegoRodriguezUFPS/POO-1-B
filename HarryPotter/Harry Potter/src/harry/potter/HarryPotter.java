/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package harry.potter;

import controlador.CntrlDialogo;
import controlador.CntrlPelea;
import vista.JFDialogo;
import vista.JFPelea;

/**
 *
 * @author roca
 */
public class HarryPotter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFDialogo frmDialogo = new JFDialogo();
        JFPelea frmPelea = new JFPelea();

        CntrlPelea cntrlPelea = new CntrlPelea(frmPelea);
        CntrlDialogo cntrlDialogo = new CntrlDialogo(frmDialogo, frmPelea, cntrlPelea);
        
        cntrlPelea.setCntrlDialogo(cntrlDialogo);

        frmDialogo.setVisible(true);
    }

}
