/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Usuario;
import vista.JFDevolucion;

/**
 *
 * @author roca
 */
public class CntrlDevolucion implements ActionListener {

    JFDevolucion frmDevolucion;
    ArrayList<Usuario> listaUsuario;
    ArrayList<Prestamo> listaPrestamo;
    CntrlPrestamo cntrlPrestamo;
    boolean haHechoPrestramo;

    public CntrlDevolucion() {
    }

    public CntrlDevolucion(JFDevolucion frmDevolucion, ArrayList<Usuario> listaUsuario, ArrayList<Prestamo> listaPrestamo, CntrlPrestamo cntrlPrestamo) {
        this.frmDevolucion = frmDevolucion;
        this.listaUsuario = listaUsuario;
        this.listaPrestamo = listaPrestamo;
        this.cntrlPrestamo = cntrlPrestamo;
        this.haHechoPrestramo = false;

        this.frmDevolucion.btnDevolver.addActionListener(this);
        this.frmDevolucion.comBUsuario.addActionListener(this);
    }

    public void refrescarListaUsuario() {
        frmDevolucion.comBUsuario.removeAllItems();
        for (Usuario usuario : listaUsuario) {
            frmDevolucion.comBUsuario.addItem(usuario);
        }
    }

    public void mostrarLibro() {
        haHechoPrestramo = false;
        Usuario usuarioTM = (Usuario) frmDevolucion.comBUsuario.getSelectedItem();
        frmDevolucion.comBLibroDevolver.removeAllItems();
        for (Prestamo prestamo : listaPrestamo) {
            if (prestamo.getUsuario().equals(usuarioTM)) {
                frmDevolucion.comBLibroDevolver.addItem(prestamo.getLibro());
                haHechoPrestramo = true;
            }
        }
    }

    public void devolver() {
        Usuario usuarioTM = (Usuario) frmDevolucion.comBUsuario.getSelectedItem();
        if (usuarioTM == null) {
            frmDevolucion.txtAResultado.setText("Escoja un usuario, porfavor.");
        } else {
            if (!haHechoPrestramo) {
                frmDevolucion.txtAResultado.setText("Este Usuario nunca ha hecho un préstamo.");
            } else {
                Date fechaDate = frmDevolucion.jDateFechaD.getDate();
                if (fechaDate == null) {
                    frmDevolucion.txtAResultado.setText("No ha ingresado una fecha. Porfavor, hágalo.");
                } else {
                    double multa = 0;
                    Libro libroTM = (Libro) frmDevolucion.comBLibroDevolver.getSelectedItem();
                    LocalDate fechaDevolucion = fechaDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

                    for (Prestamo prestamo : listaPrestamo) {
                        if (prestamo.getUsuario().equals(usuarioTM) && prestamo.getLibro().equals(libroTM)) {
                            multa = prestamo.calcularMulta(fechaDevolucion);
                            prestamo.getLibro().setCanCopiasHay(prestamo.getLibro().getCanCopiasHay() + 1);

                            if (multa == -1) {
                                frmDevolucion.txtAResultado.setText("La fecha que se escogió es anterior a la fecha del Prestamo (" + prestamo.getFechaPrestramo().toString() + ")");
                            } else if (multa == 0) {
                                frmDevolucion.txtAResultado.setText(""
                                        + "¡Buenas noticias, " + usuarioTM.getNombre() + "!\n"
                                        + "¡Se ha devuelto '" + libroTM.getTitulo() + "' con éxito!");
                                listaPrestamo.remove(prestamo);
                                mostrarLibro();
                                cntrlPrestamo.refrescarListaLibros();
                            } else {
                                frmDevolucion.txtAResultado.setText(""
                                        + "¡Malas noticias, " + usuarioTM.getNombre() + "!\n"
                                        + "Se ha entegrado '" + libroTM.getTitulo() + "' después de la fecha acordada\n"
                                        + "Por lo tanto debe pagar una multa de: " + multa);
                                prestamo.getUsuario().setEsVetado(true);
                                listaPrestamo.remove(prestamo);
                                mostrarLibro();
                                cntrlPrestamo.refrescarListaLibros();
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmDevolucion.comBUsuario) {
            mostrarLibro();
        }

        if (e.getSource() == frmDevolucion.btnDevolver) {
            devolver();
        }
    }

}
