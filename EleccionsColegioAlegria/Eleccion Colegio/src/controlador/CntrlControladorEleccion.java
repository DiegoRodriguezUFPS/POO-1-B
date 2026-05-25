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
import vista.JFControladorEleccion;
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
public class CntrlControladorEleccion implements ActionListener {

    private JFControladorEleccion frmControladorEleccion;
    private ArrayList<Candidato> listaCandidato;
    private Eleccion eleccion;
    private CntrlGanador cntrlGanador;

    //Todos JF
    private JFEleccion frmEleccion;
    private JFGanador frmGanador;
    private JFIngresarEstudiante frmIngresar;
    private JFSimulacionCrear frmSimulacion;
    private JFVotarPersonero frmVotarPersonero;
    private JFVotarRepresentante frmVotarRepresentante;

    public CntrlControladorEleccion() {
    }

    public CntrlControladorEleccion(JFControladorEleccion frmControladorEleccion, ArrayList<Candidato> listaCandidato, JFEleccion frmEleccion, JFGanador frmGanador, JFIngresarEstudiante frmIngresar, JFSimulacionCrear frmSimulacion, JFVotarPersonero frmVotarPersonero, JFVotarRepresentante frmVotarRepresentante, Eleccion eleccion, CntrlGanador cntrlGanador) {
        this.frmControladorEleccion = frmControladorEleccion;
        this.listaCandidato = listaCandidato;
        this.frmEleccion = frmEleccion;
        this.frmGanador = frmGanador;
        this.frmIngresar = frmIngresar;
        this.frmSimulacion = frmSimulacion;
        this.frmVotarPersonero = frmVotarPersonero;
        this.frmVotarRepresentante = frmVotarRepresentante;
        this.eleccion = eleccion;
        this.cntrlGanador = cntrlGanador;

        this.frmControladorEleccion.btnFinalizarEleccion.addActionListener(this);
        this.frmControladorEleccion.comBTipoCandidato.addActionListener(this);
        this.frmControladorEleccion.comBCandidato.addActionListener(this);
    }

    public void actualizarCandidato() {
        frmControladorEleccion.comBCandidato.removeAllItems();
        String tipoCandidato = (String) frmControladorEleccion.comBTipoCandidato.getSelectedItem();
        for (Candidato candidato : listaCandidato) {
            if (tipoCandidato.equals("Personero")) {
                if (candidato instanceof CandidatoPersoneria) {
                    frmControladorEleccion.comBCandidato.addItem(candidato);
                }
            }
            if (tipoCandidato.equals("Representante")) {
                if (candidato instanceof CandidatoRepresentante) {
                    frmControladorEleccion.comBCandidato.addItem(candidato);
                }
            }
        }
    }

    public void mostrarInformacionCandidato() {
        Candidato candidatoTM = (Candidato) frmControladorEleccion.comBCandidato.getSelectedItem();
        if (candidatoTM != null) {
            String votosTotales = String.valueOf(candidatoTM.getListaVotos().size());
            frmControladorEleccion.txtVotosTotales.setText(votosTotales);
        }
    }

    public void mostrarInformacionElectoral() {
        String poblacionElectoral = String.valueOf(eleccion.getPoblacionElectoral());
        frmControladorEleccion.txtPoblacionElectoral.setText(poblacionElectoral);
    }

    public void finalizarEleccion() {
        cntrlGanador.rellenarDatos();
        
        frmGanador.setVisible(true);
        frmControladorEleccion.dispose();
        frmEleccion.dispose();
        frmIngresar.dispose();
        frmSimulacion.dispose();
        frmVotarPersonero.dispose();
        frmVotarRepresentante.dispose();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmControladorEleccion.btnFinalizarEleccion) {
            finalizarEleccion();
        }

        if (e.getSource() == frmControladorEleccion.comBTipoCandidato) {
            actualizarCandidato();
        }

        if (e.getSource() == frmControladorEleccion.comBCandidato) {
            mostrarInformacionCandidato();
        }
    }

}
