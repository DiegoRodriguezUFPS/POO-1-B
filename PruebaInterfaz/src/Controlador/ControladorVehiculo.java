/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Vehiculo;
import Modelo.Persona;
import View.JFPersona;
import View.JFVehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorVehiculo implements ActionListener{
    private JFVehiculo frmVehiculo;
    private JFPersona frmPersona;
    private ArrayList<Vehiculo> listaVehiculo;
    private ArrayList<Persona> listaPersona;    

    public ControladorVehiculo() {
    }

    public ControladorVehiculo(JFVehiculo frmVehiculo, ArrayList<Persona> listaPersona, ArrayList<Vehiculo> listaVehiculo) {
        this.frmVehiculo = frmVehiculo;
        this.listaVehiculo = listaVehiculo;
        this.listaPersona = listaPersona;
        this.frmVehiculo.btnGuadar1.addActionListener(this);
        this.frmVehiculo.btnLimpiar.addActionListener(this);
        this.frmVehiculo.btnEliminar.addActionListener(this);
        this.frmVehiculo.btnX.addActionListener(this);
        this.frmVehiculo.btnAtras.addActionListener(this);
    }
    
    public void mostrar(){
        frmVehiculo.txtAObjetosGuardados.setText("");
        
        for (int i = 0; i < listaVehiculo.size(); i++) {
         Vehiculo vehiculoTMM = listaVehiculo.get(i);
         frmVehiculo.txtAObjetosGuardados.append(vehiculoTMM.getPlaca()+ " | " + vehiculoTMM.getModelo()+ " | " + vehiculoTMM.getPropietario().getNombre()+ "\n");
        }

    }
    public void guardar(){
        String placa = frmVehiculo.txtPlaca.getText();
        String danio = frmVehiculo.txtDanio.getText();
        String modelo = frmVehiculo.txtModelo.getText();
        String propietario = frmVehiculo.txtPropietario.getText();
        String cilindraje = frmVehiculo.txtCilindraje.getText();
        String marca = frmVehiculo.txtMarca.getText();
        String color = frmVehiculo.txtColor.getText();
        String reparacion = frmVehiculo.txtReparacion.getText();
        boolean requiereR = reparacion.equalsIgnoreCase("Si");
        
        boolean encontrado = false;
        for (int i = 0; i < listaPersona.size(); i++) {
            Persona personaTM = listaPersona.get(i);
            if(personaTM.getNombre().equals(propietario)){
                encontrado = true;
        
                Vehiculo vehiculo = new Vehiculo(placa, modelo, marca, cilindraje, danio, listaPersona.get(i), requiereR, color);
                listaVehiculo.add(vehiculo);
                
                personaTM.agregarVehiculo(vehiculo);
                javax.swing.JOptionPane.showMessageDialog(frmVehiculo, "Se guardo los datos");
        
                mostrar();
            }
        }
        if(listaPersona.size()> 0 && !encontrado){
                 javax.swing.JOptionPane.showMessageDialog(frmVehiculo, "Se requiere llenar el apartado de Propietario");
            } 
            else if(listaPersona.size()== 0 && !encontrado){
                 javax.swing.JOptionPane.showMessageDialog(frmVehiculo, "No existe ninguna Persona que puede ser Propietaria");                
            }
        
        
    }
    
    public void limpiar(){
        frmVehiculo.txtPlaca.setText("");
        frmVehiculo.txtDanio.setText("");
        frmVehiculo.txtModelo.setText("");
        frmVehiculo.txtPropietario.setText("");
        frmVehiculo.txtCilindraje.setText("");
        frmVehiculo.txtMarca.setText("");
        frmVehiculo.txtColor.setText("");
        frmVehiculo.txtReparacion.setText("");
    }

    public void eliminar(){
        if (!listaVehiculo.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(frmVehiculo, "Se eliminaron los datos");
            listaVehiculo.clear();
            frmVehiculo.txtAObjetosGuardados.setText("");

        }
    }
    
    public void quitar(String placaTM){
        if (!listaVehiculo.isEmpty()) {
        String placa = placaTM;
            for (int i = 0; i < listaVehiculo.size(); i++) {
                Vehiculo vehiculoTMM = listaVehiculo.get(i);
                if (placa.equals(vehiculoTMM.getPlaca())) {
                    listaVehiculo.remove(vehiculoTMM);
                    break;
                }
            }
         frmVehiculo.txtAObjetosGuardados.setText("");
        
         mostrar();
         }
    }
    
    public void cambiarPagina(){
        frmPersona.setVisible(true);
        frmVehiculo.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frmVehiculo.btnGuadar1){
            guardar();
        }
        
        if(e.getSource() == frmVehiculo.btnLimpiar){
            limpiar();
        }
        
        if(e.getSource() == frmVehiculo.btnEliminar){
            eliminar();
        }
        
        if(e.getSource() == frmVehiculo.btnX){
            quitar(frmVehiculo.txtPlaca.getText());
        }
        
        if(e.getSource() == frmVehiculo.btnAtras){
            cambiarPagina();
        }
        
        
    }

    public JFPersona getFrmPersona() {
        return frmPersona;
    }

    public void setFrmPersona(JFPersona frmPersona) {
        this.frmPersona = frmPersona;
    }
    
    

}
