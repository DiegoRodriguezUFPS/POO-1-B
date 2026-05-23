
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Timer;
import modelo.Cuidador;
import modelo.Reserva;
import vista.JFAdministrador;

public class ControlAdministrador implements ActionListener {

    JFAdministrador frmAdministrador;
    ArrayList<Reserva> listaReserva;
    private Cuidador cuidador;

    public ControlAdministrador() {
    }

    public ControlAdministrador(JFAdministrador frmAdministrador, ArrayList<Reserva> listaReserva) {
        this.frmAdministrador = frmAdministrador;
        this.listaReserva = listaReserva;
        this.cuidador = new Cuidador();
        this.cuidador.crearListaCuidador();

        this.frmAdministrador.btnGuardarC.addActionListener(this);
        this.frmAdministrador.btnX.addActionListener(this);
        this.frmAdministrador.comBReserva.addActionListener(this);

        for (Cuidador cuidadorTM : this.cuidador.getListaCuaidador()) {
            this.frmAdministrador.comBCuidador.addItem(cuidadorTM);
        }
    }

    public void refrescarComBReserva() {
        frmAdministrador.comBReserva.removeActionListener(this);
        
        frmAdministrador.comBReserva.removeAllItems();
        for (Reserva reserva : listaReserva) {
            frmAdministrador.comBReserva.addItem(reserva);
        }
        
        frmAdministrador.comBReserva.addActionListener(this);
    }

    public void mostrarDatos() {
        Reserva reservaSeleccionada = (Reserva) frmAdministrador.comBReserva.getSelectedItem();
        
        if (reservaSeleccionada != null) { 
            LocalDate fechaIngreso = reservaSeleccionada.getFechaIngreso();
            Date fechaDate = Date.from(fechaIngreso.atStartOfDay(ZoneId.systemDefault()).toInstant());
            frmAdministrador.jDateIngreso.setDate(fechaDate);

            LocalDate fechaIda = reservaSeleccionada.getFechaIda();
            Date fechaDateIda = Date.from(fechaIda.atStartOfDay(ZoneId.systemDefault()).toInstant());
            frmAdministrador.jDateIda.setDate(fechaDateIda);

            frmAdministrador.txtAServicios.setText(reservaSeleccionada.getServiciosAdicionales());
            frmAdministrador.comBCuidador.setSelectedItem(reservaSeleccionada.getCuidador());
        }
    }

    public void guardarCambios() {
        Reserva reservaSeleccionada = (Reserva) frmAdministrador.comBReserva.getSelectedItem();
        Timer tiempo = new Timer(3000, (e) -> {
            frmAdministrador.lblMostrar.setText("...");
        });
        
        if (reservaSeleccionada != null) {
            if (frmAdministrador.jDateIngreso.getDate() != null && frmAdministrador.jDateIda.getDate() != null) {
                
                Date fechaDate = frmAdministrador.jDateIngreso.getDate();
                LocalDate fechaIngreso = fechaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                fechaDate = frmAdministrador.jDateIda.getDate();
                LocalDate fechaIda = fechaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                String serviciosAdicionales = frmAdministrador.txtAServicios.getText();
                Cuidador cuidadorTM = (Cuidador) frmAdministrador.comBCuidador.getSelectedItem();

                reservaSeleccionada.setFechaIngreso(fechaIngreso);
                reservaSeleccionada.setFechaIda(fechaIda);
                reservaSeleccionada.setServiciosAdicionales(serviciosAdicionales);
                reservaSeleccionada.setCuidador(cuidadorTM);

                frmAdministrador.lblMostrar.setText("Se han guardado los cambios");
            } else {
                frmAdministrador.lblMostrar.setText("Error: Selecciona fechas válidas.");
            }
            tiempo.start();
        } else {
            frmAdministrador.lblMostrar.setText("No hay una reserva seleccionada.");
            tiempo.start();
        }
    }

    public void borrarReserva() {
        Reserva reservaSeleccionada = (Reserva) frmAdministrador.comBReserva.getSelectedItem();
        Timer tiempo = new Timer(3000, (e) -> {
            frmAdministrador.lblMostrar.setText("...");
        });
        
        if (reservaSeleccionada != null) {
            listaReserva.remove(reservaSeleccionada);

            frmAdministrador.lblMostrar.setText("Se ha eliminado la reserva");
            
            frmAdministrador.comBCuidador.setSelectedIndex(0); 
            frmAdministrador.jDateIda.setDate(null);
            frmAdministrador.jDateIngreso.setDate(null);
            frmAdministrador.txtAServicios.setText("");
            
            refrescarComBReserva();
            tiempo.start();
        } else {
            frmAdministrador.lblMostrar.setText("No hay una reserva seleccionada.");
            tiempo.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmAdministrador.btnGuardarC) {
            guardarCambios();
        }
        if (e.getSource() == frmAdministrador.comBReserva) {
            mostrarDatos();
        }
        if (e.getSource() == frmAdministrador.btnX) {
            borrarReserva();
        }
    }
}