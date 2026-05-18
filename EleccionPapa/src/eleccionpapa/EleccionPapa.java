/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eleccionpapa;

import Controlador.ControladorVotacionConclave;
import javax.swing.JFrame;
import modelo.Cardenal;
import vista.JFVotacion;

/**
 *
 * @author estudiante
 */
public class EleccionPapa {

    public static void main(String[] args) {
        Cardenal cardenalTM = new Cardenal();
        cardenalTM.RegistrarCardenal();
        JFVotacion frmVotacion = new JFVotacion();
        Controlador.ControladorVotacionConclave controladorVotacion = new ControladorVotacionConclave(frmVotacion, cardenalTM.getListaCardinal());
        frmVotacion.setVisible(true);
    }
    
    public int totalizarVotos(){
        int totalVotos = 0;
        return totalVotos;
    }
}
        