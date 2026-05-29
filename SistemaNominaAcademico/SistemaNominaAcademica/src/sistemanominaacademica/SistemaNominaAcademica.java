/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemanominaacademica;

import controlador.CntrlGestorProyectos;
import controlador.CntrlIngresarEmpleado;
import controlador.CntrlMostrador;
import java.util.ArrayList;
import modelo.Empleado;
import vista.JFCrearProducto;
import vista.JFGestorProyectos;
import vista.JFIngresarEmpleado;
import vista.JFMostrador;

/**
 *
 * @author roca
 */
public class SistemaNominaAcademica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Lista
        ArrayList<Empleado> listaEmpleado = new ArrayList<>();
                       
        JFIngresarEmpleado frmIngresasEmpleado = new JFIngresarEmpleado();
        JFGestorProyectos frmGestorProyectos = new JFGestorProyectos();
        JFCrearProducto frmCrearProducto = new JFCrearProducto();
        JFMostrador frmMostrador = new JFMostrador();
        
        CntrlMostrador cntrlMostrador = new CntrlMostrador(frmMostrador, listaEmpleado);
        CntrlGestorProyectos cntrlGestroProyectos = new CntrlGestorProyectos(frmGestorProyectos, frmCrearProducto, listaEmpleado);
        CntrlIngresarEmpleado cntrlIngresarEmpleado = new CntrlIngresarEmpleado(frmIngresasEmpleado, listaEmpleado, cntrlGestroProyectos, cntrlMostrador);
        
        
        frmIngresasEmpleado.setVisible(true);
        frmGestorProyectos.setVisible(true);
        frmMostrador.setVisible(true);
    }
    
}
