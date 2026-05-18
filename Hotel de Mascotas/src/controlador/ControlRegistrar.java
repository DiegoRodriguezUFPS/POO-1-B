/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Duenio;
import modelo.Mascota;
import vista.JFRegistrar;


public class ControlRegistrar implements ActionListener{
    private JFRegistrar frmRegistrar;       
    private ArrayList<Mascota> listaMascota;
    private ArrayList<Duenio> listaDuenio;
    private ControlReserva cntrlReserva;

    public ControlRegistrar() {
    }

    public ControlRegistrar(JFRegistrar frmRegistrar, ArrayList<Mascota> listaMascota, ControlReserva cntrlReserva) {
        this.frmRegistrar = frmRegistrar;
        this.listaMascota = listaMascota;
        this.listaDuenio = new ArrayList<>();
        this.cntrlReserva = cntrlReserva;
        
        this.frmRegistrar.btnGuardarDuenio.addActionListener(this);
        this.frmRegistrar.btnGuardarMascota.addActionListener(this);
        
    }

    public void guardarDuenio(){
        String nombreDuenio = frmRegistrar.txtNombreDuenio.getText();
        String identificacionDuenio = frmRegistrar.txtIdentificacionDuenio.getText();
        
        Duenio duenioTM = new Duenio(nombreDuenio, identificacionDuenio);
        listaDuenio.add(duenioTM);
        frmRegistrar.comBDuenio.removeAllItems();
        for (Duenio duenio : listaDuenio) {
            frmRegistrar.comBDuenio.addItem(duenio);
        }
        
    }

    public void guardarMascota(){
        String nombre = frmRegistrar.txtNombreMascota.getText();
        String raza = frmRegistrar.txtRazaMascota.getText();
        String edad = frmRegistrar.txtEdadMascota.getText();
        String necesidadEs = frmRegistrar.txtNecesidadesEsP.getText();
        Duenio duenioTM = (Duenio) frmRegistrar.comBDuenio.getSelectedItem();
        
        Mascota mascotaTM = new Mascota(nombre, raza, edad, necesidadEs, duenioTM);
        listaMascota.add(mascotaTM);
        duenioTM.addMascota(mascotaTM);
        cntrlReserva.refrescarListaMascota();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmRegistrar.btnGuardarDuenio) {
            guardarDuenio();
        }
        
        if (e.getSource() == frmRegistrar.btnGuardarMascota) {
            guardarMascota();
        }
        
    }
    
}
