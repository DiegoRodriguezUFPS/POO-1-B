/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Estudiante;
import vista.JFIngresarEstudiante;
import vista.JFVotarPersonero;

/**
 *
 * @author roca
 */
public class CntrlIngresarEstudiante implements ActionListener {

    private JFIngresarEstudiante frmIngresarEstudiante;
    private JFVotarPersonero frmVotar;
    private ArrayList<Estudiante> listaEstudiante;
    private CntrlVotarRepresentante cntrlVotarRepresentante;

    public CntrlIngresarEstudiante() {
    }

    public CntrlIngresarEstudiante(JFIngresarEstudiante frmIngresarEstudiante, JFVotarPersonero frmVotar, ArrayList<Estudiante> listaEstudiante, CntrlVotarRepresentante cntrlVotarRepresentante) {
        this.frmIngresarEstudiante = frmIngresarEstudiante;
        this.frmVotar = frmVotar;
        this.listaEstudiante = listaEstudiante;
        this.cntrlVotarRepresentante = cntrlVotarRepresentante;

        this.frmIngresarEstudiante.btnGuardarYSeguir.addActionListener(this);
    }

    public void guardarDatos() {
        String id = frmIngresarEstudiante.txtId.getText();

        for (Estudiante est : listaEstudiante) {
            if (est.getId().equals(id)) {
                javax.swing.JOptionPane.showMessageDialog(frmIngresarEstudiante, "El estudiante con este ID ya se encuentra registrado.");
                return;
            }
        }

        String nombres = frmIngresarEstudiante.txtNombres.getText();
        String apellidos = frmIngresarEstudiante.txtApellidos.getText();

        if (id.trim().isEmpty() || nombres.trim().isEmpty() || apellidos.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(frmIngresarEstudiante, "Por favor, rellene todos los campos obligatorios (ID, Nombres y Apellidos).");
            return;
        }

        if (frmIngresarEstudiante.comBGrado.getSelectedIndex() == -1 || frmIngresarEstudiante.comBGrupo.getSelectedIndex() == -1) {
            javax.swing.JOptionPane.showMessageDialog(frmIngresarEstudiante, "Por favor, seleccione un grado y un grupo válidos.");
            return;
        }

        String grado = frmIngresarEstudiante.comBGrado.getSelectedItem().toString().toLowerCase();
        String grupo = (String) frmIngresarEstudiante.comBGrupo.getSelectedItem();

        listaEstudiante.add(new Estudiante(id, nombres, apellidos, grado, grupo));

        cntrlVotarRepresentante.iniciarCandidatos();
        frmVotar.setVisible(true);
        frmIngresarEstudiante.setVisible(false);
        limpiarDatos();
    }

    public void limpiarDatos() {
        frmIngresarEstudiante.txtId.setText("");
        frmIngresarEstudiante.txtNombres.setText("");
        frmIngresarEstudiante.txtApellidos.setText("");
        frmIngresarEstudiante.comBGrado.setSelectedItem(0);
        frmIngresarEstudiante.comBGrupo.setSelectedItem(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmIngresarEstudiante.btnGuardarYSeguir) {
            guardarDatos();
        }
    }

}
