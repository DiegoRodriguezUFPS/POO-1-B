/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import modelo.AtiendeEsp;
import modelo.Cuidador;
import modelo.Mascota;
import modelo.Reserva;
import vista.JFCuidadores;
import vista.JFReserva;

/**
 *
 * @author roca
 */
public class ControlReserva implements ActionListener{
    ArrayList<Mascota> ListaMascota;
    ArrayList<Reserva> ListaReserva;
    Cuidador cuidador;
    JFReserva frmReserva;
    JFCuidadores frmCuidadores;

    public ControlReserva () {
    }

    public ControlReserva(ArrayList<Mascota> ListaMascota, JFReserva frmReserva, JFCuidadores frmCuidadores) {
        this.ListaMascota = ListaMascota;
        this.ListaReserva = new ArrayList<>();
        this.cuidador = new Cuidador();
        this.cuidador.crearListaCuidador();
        this.frmReserva = frmReserva;
        this.frmCuidadores = frmCuidadores;
        
        this.frmReserva.btnGuardarReserva.addActionListener(this);
        this.frmReserva.btnMostarCuidador.addActionListener(this);
        
        for (Cuidador cuidador1 : cuidador.getListaCuaidador()) {
            frmReserva.comBCuidador.addItem(cuidador1);
            frmCuidadores.txtListaCuidadores.append(" - (" + cuidador1.getId() + ") " + cuidador1.getNombre() + " | " + "NivelExp: "+ cuidador1.getNivExperiencia() + " | " + "Disponibilidad: "+ cuidador1.isEstaDisponible() + " | " + "Especialidad: " + cuidador1.getAtiendeEsp() +"\n"); 
        }
        
        
    }
   
    
    public void refrescarListaMascota(){
        frmReserva.comBMascota.removeAllItems();
        for (Mascota mascota : ListaMascota) {
            frmReserva.comBMascota.addItem(mascota);
        }
    }
    
    public void mostrar(){
        frmReserva.txtAMostrar.append("- - - - - OwO - - - -\n");
        frmReserva.txtAMostrar.append("Se realizo una reserva por " + ListaMascota.getLast().getDuenio().getNombre() + " que es dueño de " + ListaMascota.getLast().getNombre() + "\n");
        frmReserva.txtAMostrar.append("Fecha de ingreso: "+ ListaReserva.getLast().getFechaIngreso().toString() + "\n");
        frmReserva.txtAMostrar.append("Fecha de desalojamiento: "+ ListaReserva.getLast().getFechaIda().toString() + "\n");
        frmReserva.txtAMostrar.append("Cuidador a cargo: "+ ListaReserva.getLast().getCuidador().getNombre() + "("+ ListaReserva.getLast().getCuidador().getId()+ ") \n");
    }
    
    public void guardarReserva(){
        Mascota mascota = (Mascota) frmReserva.comBMascota.getSelectedItem();
        String serviciosad = frmReserva.txtAServicios.getText();
        Cuidador cuidador = (Cuidador) frmReserva.comBCuidador.getSelectedItem();
        int diasEstadia = (int) frmReserva.SpinnerDias.getValue();
        Reserva reservaTM = new Reserva(diasEstadia, serviciosad, cuidador, mascota);
        ListaReserva.add(reservaTM);
        mostrar();
    }
    
    public void mostrarCuidador(){
        frmCuidadores.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmReserva.btnGuardarReserva) {
            guardarReserva();
        }
        
        if (e.getSource() == frmReserva.btnMostarCuidador) {
            mostrarCuidador();
        }
    }
    
    
}
