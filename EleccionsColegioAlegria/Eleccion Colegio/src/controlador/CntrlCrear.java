/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author roca
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Candidato;
import modelo.CandidatoPersoneria;
import modelo.CandidatoRepresentante;
import modelo.Estudiante;
import modelo.Mascota;
import modelo.TipoAnimal;
import vista.JFCrear;
import vista.JFIngresarEstudiante;

public class CntrlCrear implements ActionListener {

    private JFCrear frmCrear;
    private ArrayList<Candidato> listaCandidatos;
    private int numTarjetaPersonero;
    private int numTarjetaRepresentante;
    private JFIngresarEstudiante frmIngresar;

    public CntrlCrear(JFCrear frmCrear, ArrayList<Candidato> listaCandidatos, JFIngresarEstudiante frmIngresar) {
        this.frmCrear = frmCrear;
        this.listaCandidatos = listaCandidatos;
        this.numTarjetaPersonero = 0;
        this.numTarjetaRepresentante = 0;
        this.frmIngresar = frmIngresar; 
        
        this.frmCrear.btnGuardarPersonero.addActionListener(this);
        this.frmCrear.btnGuardarRepresentante.addActionListener(this);
        this.frmCrear.btnFinalizar.addActionListener(this);
    }

    private boolean estanCamposPersoneroLlenos() {
        return !frmCrear.txtId.getText().trim().isEmpty() &&
               !frmCrear.txtNombre.getText().trim().isEmpty() &&
               !frmCrear.txtApellido.getText().trim().isEmpty() &&
               !frmCrear.txtFotoRuta.getText().trim().isEmpty() &&
               !frmCrear.txtLemaPersonero.getText().trim().isEmpty() &&
               !frmCrear.txtIdMascota.getText().trim().isEmpty() &&
               !frmCrear.txtNombreMascota.getText().trim().isEmpty() &&
               !frmCrear.txtGeneroMascota.getText().trim().isEmpty() &&
               !frmCrear.txtEdadMascota.getText().trim().isEmpty() &&
               !frmCrear.txtCualidadesMascota.getText().trim().isEmpty();
    }

    private boolean estanCamposRepresentanteLlenos() {
        return !frmCrear.txtIdRepresentante.getText().trim().isEmpty() &&
               !frmCrear.txtNombreRepresentante.getText().trim().isEmpty() &&
               !frmCrear.txtApellidoRepresentante.getText().trim().isEmpty() &&
               !frmCrear.txtFotoRutaRepresentante.getText().trim().isEmpty() &&
               !frmCrear.txtLemaRepresentante.getText().trim().isEmpty() &&
               !frmCrear.txtIdFormula.getText().trim().isEmpty() &&
               !frmCrear.txtNombreFormula.getText().trim().isEmpty() &&
               !frmCrear.txtApellidosFormula.getText().trim().isEmpty();
    }

    private void guardarPersonero() {
        if (!estanCamposPersoneroLlenos()) {
            JOptionPane.showMessageDialog(frmCrear, "¡Pilas! Tienes que llenar todos los datos del Personero y su mascota.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        numTarjetaPersonero++;
        
        String idMascota = frmCrear.txtIdMascota.getText();
        String nombreMascota = frmCrear.txtNombreMascota.getText();
        String generoMascota = frmCrear.txtGeneroMascota.getText();
        String edadMascota = frmCrear.txtEdadMascota.getText();
        String cualidades = frmCrear.txtCualidadesMascota.getText();
        String tipoAnimalTM = (String) frmCrear.comBTipoAnimal.getSelectedItem();
        TipoAnimal tipoAnimal = null;
        
        switch (tipoAnimalTM) {
            case "Terrestre":
                tipoAnimal = TipoAnimal.TERRESTRE;
                break;
            case "Acuatico":
                tipoAnimal = TipoAnimal.ACUATICO;
                break;
            case "Aereo":
                tipoAnimal = TipoAnimal.AEREO;
                break;
            default:
                throw new AssertionError();
        }

        Mascota mascota = new Mascota(idMascota, nombreMascota, generoMascota, edadMascota, cualidades, tipoAnimal);

        String id = frmCrear.txtId.getText();
        String nombre = frmCrear.txtNombre.getText();
        String apellido = frmCrear.txtApellido.getText();
        String grupo = (String) frmCrear.comBGrupo.getSelectedItem();
        String fotoRuta = frmCrear.txtFotoRuta.getText();
        String lema = frmCrear.txtLemaPersonero.getText();
        String numTarjeta = String.valueOf(numTarjetaPersonero);
        
        CandidatoPersoneria personero = new CandidatoPersoneria(mascota, lema, numTarjeta, id, nombre, apellido, "11°", grupo, fotoRuta);
        listaCandidatos.add(personero);

        JOptionPane.showMessageDialog(frmCrear, "¡Personero y su mascota guardados con éxito!");
        limpiarCamposPersonero();
    }

    private void guardarRepresentante() {
        if (!estanCamposRepresentanteLlenos()) {
            JOptionPane.showMessageDialog(frmCrear, "¡Hey! Faltan datos del Representante o de su fórmula.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = frmCrear.txtIdRepresentante.getText();
        String nombre = frmCrear.txtNombreRepresentante.getText();
        String apellido = frmCrear.txtApellidoRepresentante.getText();
        String grupo = (String) frmCrear.comBGrupoRepresentante.getSelectedItem();
        String fotoRuta = frmCrear.txtFotoRutaRepresentante.getText();
        String lema = frmCrear.txtLemaRepresentante.getText();
        String grado = (String) frmCrear.comBGrado.getSelectedItem();
        
        String idFormula = frmCrear.txtIdFormula.getText();
        String nombreFormula = frmCrear.txtNombreFormula.getText();
        String apellidosFormula = frmCrear.txtApellidosFormula.getText();

        Estudiante formula = new Estudiante(idFormula, nombreFormula, apellidosFormula, grupo, grado);

        CandidatoRepresentante representante = new CandidatoRepresentante(formula, lema, fotoRuta, id, nombre, apellido, grado, grupo, fotoRuta);
        listaCandidatos.add(representante);

        JOptionPane.showMessageDialog(frmCrear, "¡Representante y su fórmula guardados con éxito!");
        limpiarCamposRepresentante();
    }

    private void limpiarCamposPersonero() {
        frmCrear.txtId.setText("");
        frmCrear.txtNombre.setText("");
        frmCrear.txtApellido.setText("");
        frmCrear.txtFotoRuta.setText("");
        frmCrear.txtLemaPersonero.setText("");
        frmCrear.txtIdMascota.setText("");
        frmCrear.txtNombreMascota.setText("");
        frmCrear.txtGeneroMascota.setText("");
        frmCrear.txtEdadMascota.setText("");
        frmCrear.txtCualidadesMascota.setText("");
    }

    private void limpiarCamposRepresentante() {
        frmCrear.txtIdRepresentante.setText("");
        frmCrear.txtNombreRepresentante.setText("");
        frmCrear.txtApellidoRepresentante.setText("");
        frmCrear.txtFotoRutaRepresentante.setText("");
        frmCrear.txtLemaRepresentante.setText("");
        frmCrear.txtIdFormula.setText("");
        frmCrear.txtNombreFormula.setText("");
        frmCrear.txtApellidosFormula.setText("");
    }
    
    private void finalizar() {
        int totalPersoneros = 0;
        ArrayList<String> gruposRegistrados = new ArrayList<>();

        for (Candidato candidato : listaCandidatos) {
            if (candidato instanceof CandidatoPersoneria) {
                totalPersoneros++;
            } else if (candidato instanceof CandidatoRepresentante) {
                CandidatoRepresentante rep = (CandidatoRepresentante) candidato;
                String llaveGrupo = rep.getGrado() + "-" + rep.getGrupo();
                
                if (!gruposRegistrados.contains(llaveGrupo)) {
                    gruposRegistrados.add(llaveGrupo);
                }
            }
        }

        if (totalPersoneros < 2) {
            JOptionPane.showMessageDialog(frmCrear, "No puedes finalizar. Deben haber al menos 2 candidatos a Personero. Tienes: " + totalPersoneros, "Faltan Personeros", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        if (gruposRegistrados.isEmpty()) {
            JOptionPane.showMessageDialog(frmCrear, "No puedes finalizar. No has registrado ningún representante.", "Faltan Representantes", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (String grupoUnico : gruposRegistrados) {
            int conteo = 0;
            
            for (Candidato c : listaCandidatos) {
                if (c instanceof CandidatoRepresentante) {
                    CandidatoRepresentante rep = (CandidatoRepresentante) c;
                    String llave = rep.getGrado() + "-" + rep.getGrupo();
                    
                    if (llave.equals(grupoUnico)) {
                        conteo++;
                    }
                }
            }
            
            if (conteo < 2) {
                JOptionPane.showMessageDialog(frmCrear, "No puedes finalizar. El grupo " + grupoUnico + " solo tiene " + conteo + " representante(s). Mínimo son 2 por grupo.", "Faltan Representantes", JOptionPane.ERROR_MESSAGE);
                return; 
            }
        }

        frmIngresar.setVisible(true);
        frmCrear.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmCrear.btnGuardarPersonero) {
            guardarPersonero();
        }

        if (e.getSource() == frmCrear.btnGuardarRepresentante) {
            guardarRepresentante();
        }
        
        if (e.getSource() == frmCrear.btnFinalizar) {
            finalizar();
        }
    }
}