/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Estudiante;
import modelo.Modalidad;
import modelo.Participante;
import modelo.Ponencia;
import modelo.Profesor;
import modelo.Semillero;
import vista.JFParticipante;


public class ControladorParticipante implements ActionListener{
    private JFParticipante frmParticipante;
    private ArrayList<Ponencia> listaPonencias;
    private ArrayList<Estudiante> listaEstudiante;
    private ArrayList<Profesor> listaProfesor;
    private ArrayList<Semillero> listaSemillero;

    public ControladorParticipante() {
    }

    public ControladorParticipante(JFParticipante frmParticipante, ArrayList<Estudiante> listaEstudiante, ArrayList<Profesor> listaProfesor, ArrayList<Semillero> listaSemillero) {
        this.frmParticipante = frmParticipante;
        this.listaEstudiante = listaEstudiante;
        this.listaProfesor = listaProfesor;
        this.listaSemillero = listaSemillero;
        this.listaPonencias = new ArrayList<>();
        
        this.frmParticipante.btnGuardarEstudiante.addActionListener(this);
        this.frmParticipante.btnGuardarPon.addActionListener(this);
        
        //Empezar las comboBox
        //ParticipanteP
        for (Estudiante estudiante : this.listaEstudiante) {
            frmParticipante.comBoxParticipanteP.addItem(estudiante);
        }
        for (Profesor profesor : this.listaProfesor) {
            frmParticipante.comBoxParticipanteP.addItem(profesor);
        }
        //Semillero
        for (Semillero semillero : this.listaSemillero){
            frmParticipante.comBoxSemilleroPonencias.addItem(semillero);
        }
        
        //estudiantes
        for (Estudiante estudiante : this.listaEstudiante){
            frmParticipante.comBoxEstudiante.addItem(estudiante);
        }
        for (Semillero semillero : this.listaSemillero){
            frmParticipante.comBoxSemillero.addItem(semillero);
        }
    }

    public void refrescarListaSemillero() {
        frmParticipante.comBoxSemilleroPonencias.removeAllItems();
        frmParticipante.comBoxSemillero.removeAllItems();
    
        for (Semillero semilleroA : this.listaSemillero){
            frmParticipante.comBoxSemilleroPonencias.addItem(semilleroA);
            frmParticipante.comBoxSemillero.addItem(semilleroA);
        }
    }
    
    public void guardarPonencia() {
        String titulo = frmParticipante.txtNombrePon.getText();
        String descripcion = frmParticipante.txtADescripcion.getText();
        String modalidad = frmParticipante.txtModalidad.getText();
        Modalidad modalidadTM = null;
        if (modalidad.equalsIgnoreCase("oral")) {modalidadTM = Modalidad.ORAL;}
        if (modalidad.equalsIgnoreCase("poster")) {modalidadTM = Modalidad.PORSTER;}
        Participante participante = (Participante) frmParticipante.comBoxParticipanteP.getSelectedItem();
        Semillero semillero = (Semillero) frmParticipante.comBoxSemilleroPonencias.getSelectedItem();
        Ponencia ponenciaTM = new Ponencia(titulo, descripcion, modalidadTM, participante, semillero);
        listaPonencias.add(ponenciaTM);

    }
    
    public void guardarEstudiante() {
        Estudiante estudiante = (Estudiante) frmParticipante.comBoxEstudiante.getSelectedItem();
        Semillero semillero = (Semillero) frmParticipante.comBoxSemillero.getSelectedItem();
        semillero.getListaEstudiantes().add(estudiante);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmParticipante.btnGuardarPon) {
            guardarPonencia();
        }

        if (e.getSource() == frmParticipante.btnGuardarEstudiante) {
            guardarEstudiante();
        }
    }
    
    
    
    
    
    
}
