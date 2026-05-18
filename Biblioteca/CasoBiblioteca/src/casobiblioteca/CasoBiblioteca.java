/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casobiblioteca;

import controlador.CntrlDevolucion;
import controlador.CntrlPrestamo;
import controlador.CntrlUsuario;
import java.util.ArrayList;
import modelo.Prestamo;
import modelo.Usuario;
import vista.JFDevolucion;
import vista.JFPrestamo;
import vista.JFUsuario;

/**
 *
 * @author roca
 */
public class CasoBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Usuario> ListaUsuario = new ArrayList<>();
        ArrayList<Prestamo> ListaPrestamo = new ArrayList<>();
        
        JFUsuario frmUsuario = new JFUsuario();
        CntrlUsuario cntrlUsuario = new CntrlUsuario(frmUsuario, ListaUsuario);
        
        JFPrestamo frmPrestamo = new JFPrestamo();
        CntrlPrestamo cntrlPrestamo = new CntrlPrestamo(frmPrestamo, ListaUsuario, cntrlUsuario, ListaPrestamo);
        frmPrestamo.setVisible(true);
        
        JFDevolucion frmDevolucion = new JFDevolucion();
        CntrlDevolucion cntrlDevolucion = new CntrlDevolucion(frmDevolucion, ListaUsuario, ListaPrestamo, cntrlPrestamo);
        frmDevolucion.setVisible(true);
        
        cntrlUsuario.setCntrlPrestamo(cntrlPrestamo);
        cntrlUsuario.setCntrlDevolucion(cntrlDevolucion);
        
    }
    
}
