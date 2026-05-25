/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.CandidatoRepresentante;
import modelo.Eleccion;
import vista.JFGanador;

/**
 *
 * @author roca
 */
public class CntrlGanador implements ActionListener{
    JFGanador frmGanador;
    Eleccion eleccion;

    public CntrlGanador() {
    }

    public CntrlGanador(JFGanador fmrGanador, Eleccion eleccion) {
        this.frmGanador = fmrGanador;
        this.eleccion = eleccion;
             
        this.frmGanador.comBGrado.addActionListener(this);
        this.frmGanador.comBGradoMenosVotos.addActionListener(this);
    }
    
    public void rellenarDatos(){
        frmGanador.txtGanador.setText(eleccion.getCandidatoPersoneriaElegido().getNombres());
        frmGanador.txtPersoneroMenosVotos.setText(eleccion.getPersoneroMenosVotos().getNombres());
        
        String poblacionElectoral = String.valueOf(eleccion.getPoblacionElectoral());
        frmGanador.txtPoblacionElectoral.setText(poblacionElectoral);
    }
    
    public void mostrarCandidatoGanadorSegunGrado(){
        String grado = (String) frmGanador.comBGrado.getSelectedItem();
        CandidatoRepresentante candidatoGanador = (CandidatoRepresentante) eleccion.getCandidatoRepresentanteElegido(grado);
        frmGanador.txtRepresentanteGanador.setText(candidatoGanador.getNombres());
        
    }
    
    public void mostrarCandidatoMenosVotosSegunGrado(){
        String grado = (String) frmGanador.comBGradoMenosVotos.getSelectedItem();
        CandidatoRepresentante candidatoMenosVotos  = (CandidatoRepresentante) eleccion.getRepresentanteMenosVotos(grado);
        frmGanador.txtRepresentanteMenosVotos.setText(candidatoMenosVotos.getNombres());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmGanador.comBGrado) {
            mostrarCandidatoGanadorSegunGrado();
        }
        
        if (e.getSource() == frmGanador.comBGradoMenosVotos) {
            mostrarCandidatoMenosVotosSegunGrado();
        }
    }
    
    
}
