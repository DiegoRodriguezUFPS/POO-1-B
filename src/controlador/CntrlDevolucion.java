/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
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
        if (!haHechoPrestramo) {
            frmDevolucion.txtAResultado.setText("Este Usuario nunca ha hecho un préstamo.");
        } else {
            if (frmDevolucion.txtAnio.getText().trim().equals("") || frmDevolucion.txtmes.getText().trim().equals("") || frmDevolucion.txtdia.getText().trim().equals("")) {
                frmDevolucion.txtAResultado.setText("Rellene todos los datos, porfavor.");
            } else {
                double multa = 0;
                Usuario usuarioTM = (Usuario) frmDevolucion.comBUsuario.getSelectedItem();
                Libro libroTM = (Libro) frmDevolucion.comBLibroDevolver.getSelectedItem();

                int anio = Integer.parseInt(frmDevolucion.txtAnio.getText());
                int mes = Integer.parseInt(frmDevolucion.txtmes.getText());
                int dia = Integer.parseInt(frmDevolucion.txtdia.getText());

                LocalDate fechaDevolucion = LocalDate.of(anio, mes, dia);

                for (Prestamo prestamo : listaPrestamo) {
                    if (prestamo.getUsuario().equals(usuarioTM) && prestamo.getLibro().equals(libroTM)) {
                        prestamo.setFechaDevolucion(fechaDevolucion);
                        multa = prestamo.calcularMulta();
                        prestamo.getLibro().setCanCopiasHay(prestamo.getLibro().getCanCopiasHay() + 1);

                        if (multa == 0) {
                            frmDevolucion.txtAResultado.setText(""
                                    + "¡Buenas noticias, " + usuarioTM.getNombre() + "!\n"
                                    + "¡Se ha devuelto '" + libroTM.getTitulo() + "' con éxito!");
                        } else {
                            frmDevolucion.txtAResultado.setText(""
                                    + "¡Malas noticias, " + usuarioTM.getNombre() + "!\n"
                                    + "Se ha entegrado '" + libroTM.getTitulo() + "' después de la fecha acordada\n"
                                    + "Por lo tanto debe pagar una multa de: " + multa);
                        }

                        listaPrestamo.remove(prestamo);
                        mostrarLibro();
                        cntrlPrestamo.refrescarListaLibros();
                        break;
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
