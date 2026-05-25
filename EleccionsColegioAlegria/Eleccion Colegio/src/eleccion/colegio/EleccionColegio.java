/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eleccion.colegio;

import controlador.CntrlControladorEleccion;
import controlador.CntrlCrear;
import controlador.CntrlEleccion;
import controlador.CntrlGanador;
import controlador.CntrlIngresarEstudiante;
import controlador.CntrlSimulacion;
import controlador.CntrlVotarPersonero;
import controlador.CntrlVotarRepresentante;
import java.util.ArrayList;
import modelo.Candidato;
import modelo.Eleccion;
import modelo.Estudiante;
import modelo.Voto;
import vista.JFControladorEleccion;
import vista.JFCrear;
import vista.JFEleccion;
import vista.JFGanador;
import vista.JFIngresarEstudiante;
import vista.JFSimulacionCrear;
import vista.JFVotarPersonero;
import vista.JFVotarRepresentante;

/**
 *
 * @author roca
 */
public class EleccionColegio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Vistas
        JFEleccion frmEleccion = new JFEleccion();
        JFVotarPersonero frmVotar = new JFVotarPersonero();
        JFIngresarEstudiante frmIngresar = new JFIngresarEstudiante();
        JFSimulacionCrear frmSimulacion = new JFSimulacionCrear();
        JFGanador frmGanador = new JFGanador();
        JFVotarRepresentante fmrVotarRepresentante = new JFVotarRepresentante();
        JFControladorEleccion frmControladorEleccion = new JFControladorEleccion();
        JFCrear frmCrear = new JFCrear();
        
        frmCrear.setLocationRelativeTo(null);
        frmControladorEleccion.setLocationRelativeTo(null);
        frmEleccion.setLocationRelativeTo(null);
        frmVotar.setLocationRelativeTo(null);
        frmIngresar.setLocationRelativeTo(null);
        frmSimulacion.setLocationRelativeTo(null);
        frmGanador.setLocationRelativeTo(null);
        
        //Listas
        ArrayList<Candidato> listaCandidatos = new ArrayList<>();
        ArrayList<Estudiante> listaEstudiante = new ArrayList<>();
        
        //Eleccion
        Eleccion eleccion = new Eleccion(listaCandidatos);
        
        //Cntrl
        CntrlVotarRepresentante cntrlVotarRepresentante = new CntrlVotarRepresentante(fmrVotarRepresentante, listaCandidatos, listaEstudiante, frmIngresar);
        CntrlVotarPersonero cntrlVotarPersonero = new CntrlVotarPersonero(frmVotar, listaCandidatos, listaEstudiante, eleccion, fmrVotarRepresentante);
        CntrlEleccion cntrlEleccion = new CntrlEleccion(frmEleccion, frmSimulacion, eleccion);
        CntrlCrear cntrlCrear = new CntrlCrear(frmCrear, listaCandidatos, frmIngresar);
        CntrlSimulacion cntrlSimulacion = new CntrlSimulacion(frmCrear, frmSimulacion, listaCandidatos, frmIngresar, cntrlVotarPersonero);
        CntrlIngresarEstudiante cntrlIngresar = new CntrlIngresarEstudiante(frmIngresar, frmVotar, listaEstudiante, cntrlVotarRepresentante);
        CntrlGanador cntrlGanador = new CntrlGanador(frmGanador, eleccion);
        
        
        CntrlControladorEleccion cntrlControladorEleccion = new CntrlControladorEleccion(frmControladorEleccion, listaCandidatos, frmEleccion, frmGanador, frmIngresar, frmSimulacion, frmVotar, fmrVotarRepresentante, eleccion, cntrlGanador);
        cntrlVotarPersonero.setCntrlEleccion(cntrlControladorEleccion);
        cntrlVotarRepresentante.setCntrlControladorEleccion(cntrlControladorEleccion);
        
        //setvisible
        frmEleccion.setVisible(true);
        frmControladorEleccion.setVisible(true);
        
    }
    
    
}
