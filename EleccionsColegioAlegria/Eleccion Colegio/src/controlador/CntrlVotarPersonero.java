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
import modelo.Eleccion;
import modelo.Estudiante;
import modelo.Voto;
import vista.JFVotarPersonero;
import vista.JFVotarRepresentante;

/**
 *
 * @author roca
 */
public class CntrlVotarPersonero implements ActionListener {

    private JFVotarPersonero frmVotar;
    private JFVotarRepresentante frmRepresentante;
    private ArrayList<Candidato> listaCandidato;
    private ArrayList<CandidatoPersoneria> listaCandidatoPer;
    private ArrayList<Estudiante> listaEstudiante;
    private int indexCandidato;
    private Eleccion eleccion;
    private CntrlControladorEleccion cntrlEleccion;

    public CntrlVotarPersonero() {
    }

    public CntrlVotarPersonero(JFVotarPersonero frmVotar, ArrayList<Candidato> listaCandidato, ArrayList<Estudiante> listaEstudiante, Eleccion eleccion, JFVotarRepresentante frmRepresentante) {
        this.frmVotar = frmVotar;
        this.listaCandidato = listaCandidato;
        this.listaEstudiante = listaEstudiante;
        this.eleccion = eleccion;
        this.indexCandidato = 0;
        this.frmRepresentante = frmRepresentante;
        
        this.listaCandidatoPer = new ArrayList<>();
        this.frmVotar.btnAdelante.addActionListener(this);
        this.frmVotar.btnAtras.addActionListener(this);
        this.frmVotar.btnVotar.addActionListener(this);

        this.frmVotar.btnAtras.setEnabled(false);

    }

    public void votar() {
        Estudiante votante = listaEstudiante.getLast();
        Candidato candidato = listaCandidatoPer.get(indexCandidato);
        Voto votoTM = new Voto(votante, candidato);
        candidato.agregarVoto(votoTM);
        eleccion.agregarVoto(votoTM);
        javax.swing.JOptionPane.showMessageDialog(frmVotar, "Se ha guardado el voto con éxito.");
        frmRepresentante.setVisible(true);
        frmVotar.setVisible(false);
        cntrlEleccion.mostrarInformacionElectoral();

    }

    public void iniciarCandidatos() {
        if (!listaCandidato.isEmpty()) {
            for (Candidato candidato : this.listaCandidato) {
                if (candidato instanceof CandidatoPersoneria) {
                    CandidatoPersoneria candidatoPerTM = (CandidatoPersoneria) candidato;
                    this.listaCandidatoPer.add(candidatoPerTM);
                }
            }
            frmVotar.mostrarCandidatoEnPantalla(listaCandidatoPer.get(indexCandidato));
        }
    }

    public void cambiarCandidatoAdelante() {
        indexCandidato++;
        frmVotar.btnAtras.setEnabled(true);
        if (indexCandidato == (listaCandidatoPer.size() - 1)) {
            frmVotar.btnAdelante.setEnabled(false);
            frmVotar.mostrarCandidatoEnPantalla(listaCandidatoPer.get(listaCandidatoPer.size() - 1));
        } else {
            frmVotar.mostrarCandidatoEnPantalla(listaCandidatoPer.get(indexCandidato));
        }
    }

    public void cambiarCandidatoAtras() {
        indexCandidato--;
        frmVotar.btnAdelante.setEnabled(true);
        if (indexCandidato == 0) {
            frmVotar.btnAtras.setEnabled(false);
            frmVotar.mostrarCandidatoEnPantalla(listaCandidatoPer.get(0));
        } else {
            frmVotar.mostrarCandidatoEnPantalla(listaCandidatoPer.get(indexCandidato));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmVotar.btnAdelante) {
            cambiarCandidatoAdelante();
        }

        if (e.getSource() == frmVotar.btnAtras) {
            cambiarCandidatoAtras();
        }

        if (e.getSource() == frmVotar.btnVotar) {
            votar();
        }
    }

    public void setCntrlEleccion(CntrlControladorEleccion cntrlEleccion) {
        this.cntrlEleccion = cntrlEleccion;
    }

    
}
