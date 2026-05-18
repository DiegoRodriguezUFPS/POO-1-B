/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Persona;
import Modelo.Vehiculo;
import View.JFPersona;
import View.JFVehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class ControladorPersona implements ActionListener {

    private JFPersona frmPersona;
    private JFVehiculo frmVehiculo;
    private ControladorVehiculo cntrVehiculo;
    private ArrayList<Persona> listaPersona;
    private ArrayList<Vehiculo> listaVehiculo;


    public ControladorPersona() {
    }

    public ControladorPersona(JFPersona frmPersona, ArrayList<Vehiculo> ListaVehiculo) {
        this.frmPersona = frmPersona;
        this.listaPersona = new ArrayList<>();
        this.listaVehiculo = ListaVehiculo;
        this.frmPersona.btnGuardar.addActionListener(this);
        this.frmPersona.btnLimpiar.addActionListener(this);
        this.frmPersona.btnEliminar.addActionListener(this);
        this.frmPersona.btnX.addActionListener(this);
        this.frmPersona.btnSiguiente.addActionListener(this);
    }
   
    
    public void mostrar(){
        frmPersona.txtAObjetosGuardados.setText("");
        
        for (int i = 0; i < listaPersona.size(); i++) {
            Persona personaTM = listaPersona.get(i);
           frmPersona.txtAObjetosGuardados.append(personaTM.getCedula()+ " | " + personaTM.getNombre() + "\n");
        }
        
    }
            
    public void guardar(){
        String cedula = frmPersona.txtCedula.getText();
        String nombre = frmPersona.txtNombre.getText();
        String apellido = frmPersona.txtApellido.getText();
        String direccion = frmPersona.txtDireccion.getText();
        String telefono = frmPersona.txtTelefono.getText();
        
        Persona persona = new Persona(cedula, nombre, apellido, direccion, telefono);
        listaPersona.add(persona);      
        javax.swing.JOptionPane.showMessageDialog(frmPersona, "Se guardo los datos");
        mostrar();
            
    }
    
    public void limpiar(){
        frmPersona.txtCedula.setText("");
        frmPersona.txtNombre.setText("");
        frmPersona.txtApellido.setText("");
        frmPersona.txtDireccion.setText("");
        frmPersona.txtTelefono.setText("");
    }
    

    public void eliminar(){
        if (!listaPersona.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(frmPersona, "Se eliminaron los datos");
            frmPersona.txtAObjetosGuardados.setText("");
            listaPersona.clear();
            cntrVehiculo.eliminar();
        }
        
    }
    
    public void quitar(){
        if (!listaPersona.isEmpty()) {
         String cedula = frmPersona.txtCedula.getText();
            for (int i = 0; i < listaPersona.size(); i++) {
                Persona personaTMM = listaPersona.get(i);
                if (cedula.equals(personaTMM.getCedula())) {
                    listaVehiculo.removeIf(vehiculo -> vehiculo.getPropietario().equals(personaTMM));
                    listaPersona.remove(personaTMM);
                    break;
                }
            }
         mostrar();
        }
        cntrVehiculo.mostrar();

    }
    
    public void cambiarPagina(){
        frmPersona.setVisible(false);
        frmVehiculo.setVisible(true);
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmPersona.btnGuardar){
            guardar();
        }
        
        if(e.getSource() == frmPersona.btnLimpiar){
            limpiar();
        }
        
        if(e.getSource() == frmPersona.btnEliminar){
            eliminar();
        }
        
        if(e.getSource() == frmPersona.btnX){
            quitar();
        }
        
        if(e.getSource() == frmPersona.btnSiguiente){
            cambiarPagina();
        }
    }

    public ArrayList<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(ArrayList<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public ArrayList<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(ArrayList<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }
   
    public ControladorVehiculo getCntrVehiculo() {
        return cntrVehiculo;
    }

    public void setCntrVehiculo(ControladorVehiculo cntrVehiculo) {
        this.cntrVehiculo = cntrVehiculo;
    }

    public JFVehiculo getFrmVehiculo() {
        return frmVehiculo;
    }

    public void setFrmVehiculo(JFVehiculo frmVehiculo) {
        this.frmVehiculo = frmVehiculo;
    }

    
    
}
