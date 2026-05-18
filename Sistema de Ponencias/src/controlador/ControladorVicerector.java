/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.LineaInv;
import modelo.GrupodeInvestigacion;
import modelo.Director;
import modelo.Estudiante;
import modelo.Participante;
import modelo.Semillero;
import modelo.Profesor;
import vista.JFVicerector;
        
        
        
public class ControladorVicerector implements ActionListener {
    private ControladorParticipante cntrlParticipante;
    private ArrayList<LineaInv> ListaLineaInv;
    private JFVicerector frmVicerector;
    private ArrayList<Profesor> listaProfesor;
    private ArrayList<Estudiante> listaEstudiante;
    private ArrayList<GrupodeInvestigacion> listaGrupoInv;
    private ArrayList<Semillero> listaSemillero;

    public ControladorVicerector() {
    }
    
    

    public ControladorVicerector(ControladorParticipante cntrlParticipante, JFVicerector frmVicerector, ArrayList<Profesor> ListaProfesor, ArrayList<Estudiante> ListaEstudiante, ArrayList<Semillero> listaSemillero) {
        this.cntrlParticipante = cntrlParticipante;
        this.ListaLineaInv = ListaLineaInv;
        this.frmVicerector = frmVicerector;
        this.ListaLineaInv = new ArrayList<>();
        this.listaGrupoInv = new ArrayList<>();
        this.listaProfesor = ListaProfesor;
        this.listaEstudiante = ListaEstudiante;
        this.listaSemillero = listaSemillero;
        this.frmVicerector.btnGuardarInv.addActionListener(this);
        this.frmVicerector.btnGuardarGrupo.addActionListener(this);
        this.frmVicerector.btnGuardarSemillero.addActionListener(this);
        
        //Llenar los comboBox
        //comBox Director
        for (Profesor profesor : this.listaProfesor) {
            frmVicerector.comBoxDirector.addItem(profesor);
        }
        
        //comBox Encargado
        for (Estudiante estudiante : this.listaEstudiante) {
            frmVicerector.comBoxEncargado.addItem(estudiante);
        }
        for (Profesor profesor : this.listaProfesor) {
            frmVicerector.comBoxEncargado.addItem(profesor);
        }
    }
    
    public void guardarLineaInv(){
        String nombre = frmVicerector.txtNombreInv.getText();
        String proposito = frmVicerector.txtPropositoInv.getText();
        
        LineaInv lineaInvTM = new LineaInv(nombre, proposito);
        ListaLineaInv.add(lineaInvTM);
        frmVicerector.comBoxLineaInv.removeAllItems();
        for (LineaInv lineaInvTMM : ListaLineaInv) {
            frmVicerector.comBoxLineaInv.addItem(lineaInvTMM);
        }
    }
    
    public void guardarGrupo(){
        String nombre = frmVicerector.txtNombreGrupo.getText();
        String clasificacion = (String) frmVicerector.comBoxClasificacion.getSelectedItem();
        Profesor profesorTM = (Profesor) frmVicerector.comBoxDirector.getSelectedItem();
        String categoriaProfe = (String) frmVicerector.comBoxCategoria.getSelectedItem();
        Director directorTM = new Director(categoriaProfe, profesorTM.getEspecialidad(), profesorTM.getCodigo(), profesorTM.getNombre(), profesorTM.getInstitucion());
        LineaInv lineaInv = (LineaInv) frmVicerector.comBoxLineaInv.getSelectedItem();
        String institucion = frmVicerector.txtInstitucion.getText();
        
        GrupodeInvestigacion grupoTM = new GrupodeInvestigacion(nombre, clasificacion, directorTM, lineaInv, institucion);
        listaGrupoInv.add(grupoTM);
        
        frmVicerector.comBoxGrupo.removeAllItems();
        for (GrupodeInvestigacion grupoInv : listaGrupoInv) {
            frmVicerector.comBoxGrupo.addItem(grupoInv);
        }
    }
    
    public void guardarSemillero(){
        String nombre = frmVicerector.txtNombreSemillero.getText();
        Participante encargado = (Participante) frmVicerector.comBoxEncargado.getSelectedItem();
        GrupodeInvestigacion grupoInvTM = (GrupodeInvestigacion) frmVicerector.comBoxGrupo.getSelectedItem();
        
        Semillero semilleroTM = new Semillero(nombre, encargado, grupoInvTM);
        listaSemillero.add(semilleroTM);
        
        cntrlParticipante.refrescarListaSemillero();       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmVicerector.btnGuardarInv) {
            guardarLineaInv();
        }
        
        if (e.getSource() == frmVicerector.btnGuardarGrupo) {
            guardarGrupo();
        }
        
        if (e.getSource() == frmVicerector.btnGuardarSemillero) {
            guardarSemillero();
        }
    }
    
    
    
}
