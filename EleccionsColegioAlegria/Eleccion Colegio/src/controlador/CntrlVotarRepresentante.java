/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Candidato;
import modelo.CandidatoPersoneria;
import modelo.CandidatoRepresentante;
import modelo.Eleccion;
import modelo.Estudiante;
import modelo.Voto;
import vista.JFIngresarEstudiante;
import vista.JFVotarRepresentante;

/**
 *
 * @author roca
 */
public class CntrlVotarRepresentante implements ActionListener {

    private JFVotarRepresentante frmVotarRepresentante;
    private JFIngresarEstudiante frmIngresarEstudiante;
    private ArrayList<Candidato> listaCandidato;
    private ArrayList<CandidatoRepresentante> listaRepresentante;
    private ArrayList<Estudiante> listaEstudiante;
    private int indexCandidato;
    private CntrlControladorEleccion cntrlControladorEleccion;
    
    public CntrlVotarRepresentante() {
    }

    public CntrlVotarRepresentante(JFVotarRepresentante frmVotarRepresentante, ArrayList<Candidato> listaCandidato, ArrayList<Estudiante> listaEstudiante, JFIngresarEstudiante frmIngresarEstudiante) {
        this.frmVotarRepresentante = frmVotarRepresentante;
        this.listaCandidato = listaCandidato;
        this.listaEstudiante = listaEstudiante;
        this.indexCandidato = 0;
        this.listaRepresentante = new ArrayList<>();
        this.frmIngresarEstudiante = frmIngresarEstudiante;
        
        this.frmVotarRepresentante.btnAdelante.addActionListener(this);
        this.frmVotarRepresentante.btnAtras.addActionListener(this);
        this.frmVotarRepresentante.btnVotar.addActionListener(this);

        this.frmVotarRepresentante.btnAtras.setEnabled(false);
    }

    public void iniciarCandidatos() {
        listaRepresentante.clear();
        if (!listaCandidato.isEmpty()) {
            for (Candidato candidato : this.listaCandidato) {
                if (candidato instanceof CandidatoRepresentante) {
                    if (candidato.getGrado().equals(listaEstudiante.getLast().getGrado())) {
                       CandidatoRepresentante candidatoPerTM = (CandidatoRepresentante) candidato;
                       this.listaRepresentante.add(candidatoPerTM); 
                    }
                }
            }
            frmVotarRepresentante.mostrarCandidatoEnPantalla(listaRepresentante.get(indexCandidato));
        }
    }
    
    public void votar(){
        Estudiante votante = listaEstudiante.getLast();
        Candidato candidato = listaRepresentante.get(indexCandidato);
        Voto votoTM = new Voto(votante, candidato);
        candidato.agregarVoto(votoTM);
        javax.swing.JOptionPane.showMessageDialog(frmVotarRepresentante, "Se ha guardado el voto con éxito.");
        frmVotarRepresentante.setVisible(false);
        frmIngresarEstudiante.setVisible(true);
        
        cntrlControladorEleccion.mostrarInformacionElectoral();
    }

    public void cambiarCandidatoAdelante() {
        indexCandidato++;
        frmVotarRepresentante.btnAtras.setEnabled(true);
        if (indexCandidato == (listaRepresentante.size() - 1)) {
            frmVotarRepresentante.btnAdelante.setEnabled(false);
            frmVotarRepresentante.mostrarCandidatoEnPantalla(listaRepresentante.get(listaRepresentante.size() - 1));
        } else {
            frmVotarRepresentante.mostrarCandidatoEnPantalla(listaRepresentante.get(indexCandidato));
        }
    }

    public void cambiarCandidatoAtras() {
        indexCandidato--;
        frmVotarRepresentante.btnAdelante.setEnabled(true);
        if (indexCandidato == 0) {
            frmVotarRepresentante.btnAtras.setEnabled(false);
            frmVotarRepresentante.mostrarCandidatoEnPantalla(listaRepresentante.get(0));
        } else {
            frmVotarRepresentante.mostrarCandidatoEnPantalla(listaRepresentante.get(indexCandidato));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmVotarRepresentante.btnAdelante) {
            cambiarCandidatoAdelante();
        }

        if (e.getSource() == frmVotarRepresentante.btnAtras) {
            cambiarCandidatoAtras();
        }

        if (e.getSource() == frmVotarRepresentante.btnVotar) {
            votar();
        }
    }

    public void setCntrlControladorEleccion(CntrlControladorEleccion cntrlControladorEleccion) {
        this.cntrlControladorEleccion = cntrlControladorEleccion;
    }

    
    
}
