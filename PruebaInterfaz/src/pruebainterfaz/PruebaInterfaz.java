/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebainterfaz;
import Controlador.ControladorPersona;
import Controlador.ControladorVehiculo;
import Modelo.Vehiculo;
import View.JFPersona;
import View.JFVehiculo;
import java.util.ArrayList;
/**
 *
 * @author Estudiante
 */
public class PruebaInterfaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancia formulario
        ArrayList<Vehiculo> listaVehiculo = new ArrayList<>();

        JFPersona frmPersona = new  JFPersona();
        ControladorPersona controladorpersona = new ControladorPersona(frmPersona, listaVehiculo);
        frmPersona.setVisible(true);
        
        JFVehiculo frmVehiculo = new  JFVehiculo();
        ControladorVehiculo controladorVehiculo = new ControladorVehiculo(frmVehiculo, controladorpersona.getListaPersona(), listaVehiculo);
        
        controladorpersona.setCntrVehiculo(controladorVehiculo);
        controladorpersona.setFrmVehiculo(frmVehiculo);
        
        controladorVehiculo.setFrmPersona(frmPersona);
    }
    
}
