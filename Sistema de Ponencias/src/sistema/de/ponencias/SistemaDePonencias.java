/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.de.ponencias;
import controlador.ControladorParticipante;
import vista.JFParticipante;
import controlador.ControladorVicerector;
import java.util.ArrayList;
import modelo.Estudiante;
import modelo.Profesor;
import modelo.Semillero;
import vista.JFVicerector;

public class SistemaDePonencias {

    public static void main(String[] args) {
        Estudiante estudianteTM = new Estudiante();
        estudianteTM.crearListaEstudiante();
        
        ArrayList<Semillero> ListaSemillero = new ArrayList<>();
        
        Profesor profesorTM = new Profesor();
        profesorTM.crearListaProfesor();
        
        JFParticipante frmParticipante = new JFParticipante();
        ControladorParticipante controlParticipante = new ControladorParticipante(frmParticipante,  estudianteTM.getListaEstudiante(), profesorTM.getListaProfesor(), ListaSemillero);
        
        JFVicerector frmVicerector = new JFVicerector();
        ControladorVicerector controlVicerector = new ControladorVicerector(controlParticipante ,frmVicerector, profesorTM.getListaProfesor(), estudianteTM.getListaEstudiante(), ListaSemillero);
        
        frmVicerector.setVisible(true);
        frmParticipante.setVisible(true);
        
    }
    
}
