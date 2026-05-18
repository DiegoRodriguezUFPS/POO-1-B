/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.de.mascotas;

import controlador.ControlRegistrar;
import controlador.ControlReserva;
import java.util.ArrayList;
import modelo.Mascota;
import vista.JFCuidadores;
import vista.JFRegistrar;
import vista.JFReserva;
/**
 *
 * @author roca
 */
public class HotelDeMascotas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Mascota> ListaMascotasTodos = new ArrayList<>();
        JFReserva frmReserva = new JFReserva();
        JFCuidadores frmCuidadores = new JFCuidadores();
        
        ControlReserva cntrlReserva = new ControlReserva(ListaMascotasTodos, frmReserva, frmCuidadores);
        frmReserva.setVisible(true);
        
        JFRegistrar frmRegistrar = new JFRegistrar();
        
        ControlRegistrar cntrlRegistrar = new ControlRegistrar(frmRegistrar, ListaMascotasTodos, cntrlReserva);
        frmRegistrar.setVisible(true);
        
        
    }
    
}
