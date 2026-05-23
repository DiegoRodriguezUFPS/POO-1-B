/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelDeMascotas;

import controlador.ControlAdministrador;
import controlador.ControlRegistrar;
import controlador.ControlReserva;
import java.util.ArrayList;
import modelo.Mascota;
import modelo.Reserva;
import vista.JFAdministrador;
import vista.JFCuidadores;
import vista.JFRegistrar;
import vista.JFReserva;
/**
 *
 * @author roca
 */
public class HotelMascotas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Mascota> ListaMascotasTodos = new ArrayList<>();
        ArrayList<Reserva> ListaReserva = new ArrayList<>();
        JFReserva frmReserva = new JFReserva();        
        
        JFAdministrador frmAdministrador = new JFAdministrador();
        ControlAdministrador cntrlAdministrador = new ControlAdministrador(frmAdministrador, ListaReserva);
        
        JFCuidadores frmCuidadores = new JFCuidadores();
        ControlReserva cntrlReserva = new ControlReserva(ListaReserva, ListaMascotasTodos, frmReserva, frmCuidadores, cntrlAdministrador);
        
        JFRegistrar frmRegistrar = new JFRegistrar();
        ControlRegistrar cntrlRegistrar = new ControlRegistrar(frmRegistrar, ListaMascotasTodos, cntrlReserva);
        
        frmReserva.setVisible(true);
        frmRegistrar.setVisible(true);
        frmAdministrador.setVisible(true);
        
    }
    
}
