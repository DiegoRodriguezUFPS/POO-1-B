/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Riesgo;
import vista.JFRiesgos;



public class GestorRiesgo implements ActionListener {
    private ArrayList<Riesgo> ListaRiesgos;
    private JFRiesgos frmRiesgos;

    public GestorRiesgo() {
    }

    public GestorRiesgo(JFRiesgos frmRiesgos) {
        this.ListaRiesgos = new ArrayList<>();
        this.frmRiesgos = frmRiesgos;
        this.frmRiesgos.btnBuscar.addActionListener(this);
        this.frmRiesgos.btnGuardar.addActionListener(this);
        this.frmRiesgos.btnEliminar.addActionListener(this);
    }
    public void mostrar(){
        frmRiesgos.txtAResultados.setText("");
        for (Riesgo riesgo : ListaRiesgos) {
            frmRiesgos.txtAResultados.append((ListaRiesgos.indexOf(riesgo) + 1) + " | " + riesgo.getCodigo()+ " " + riesgo.getDescripcion() + "\n");
        }
    }
    
    
    public void guardar(){
        String codigo = frmRiesgos.txtCodigo.getText();
        String descripcion = frmRiesgos.txtNombre.getText();
        String tipo = frmRiesgos.txtTipo.getText();
        String nivelRiesgoTM = (String) frmRiesgos.comBoxNivel.getSelectedItem();
        int nivelRiesgo = Integer.parseInt(nivelRiesgoTM);
        
        boolean yaesta= false;
        for (Riesgo riesgo : ListaRiesgos) {
            if (riesgo.getCodigo().equals(codigo)) {
                yaesta= true;
                frmRiesgos.txtAResultados.setText("Ya existe un riesgo con este codigo, porfavor ingrese otro");
                break;
            }
        }
        if (!yaesta){
          Riesgo riegoTM = new Riesgo(codigo, descripcion, tipo, nivelRiesgo);
          ListaRiesgos.add(riegoTM);
          mostrar();
        }
    }
    
    public void buscar(){
        boolean encontrado = false;
        String codigo = frmRiesgos.txtCodigo.getText();
        for (Riesgo riesgo : ListaRiesgos) {
            if (riesgo.getCodigo().equals(codigo)) {
                encontrado = true;
                frmRiesgos.txtAResultados.setText("El riesgo de codigo "+ codigo + " está en la lista y se encuentra en la posicion "+ (ListaRiesgos.indexOf(riesgo)+ 1));
                break;
            }
        }
        if (!encontrado) {
            frmRiesgos.txtAResultados.setText("No se ha encontrado ningún riesgo con ese codigo");
        }
    }
    
    public void eliminar(){
        String codigo = frmRiesgos.txtCodigo.getText();
        boolean encontrado = false;
        for (Riesgo riesgo : ListaRiesgos) {
            if (riesgo.getCodigo().equals(codigo)) {
                encontrado = true;
                ListaRiesgos.remove(riesgo);
                mostrar();
                break;
            }
        }
        if (!encontrado) {
            frmRiesgos.txtAResultados.setText("No se ha encontrado ningún riesgo con ese codigo");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmRiesgos.btnGuardar) {
            guardar();
        }
        
        if (e.getSource() == frmRiesgos.btnBuscar) {
            buscar();
        }
        
        if (e.getSource() == frmRiesgos.btnEliminar) {
            eliminar();
        }
    }
}
