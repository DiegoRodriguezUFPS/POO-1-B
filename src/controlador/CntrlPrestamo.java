/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Usuario;
import vista.JFPrestamo;

/**
 *
 * @author roca
 */
public class CntrlPrestamo implements ActionListener {

    private JFPrestamo frmPrestamo;
    private ArrayList<Usuario> ListaUsuario;
    private ArrayList<Prestamo> listaPrestamo;
    private Libro libro;
    private CntrlUsuario cntrlUsuario;
    private int idPrestamos;

    public CntrlPrestamo() {
    }

    public CntrlPrestamo(JFPrestamo frmPrestamo, ArrayList<Usuario> ListaUsuario, CntrlUsuario cntrlUsuario, ArrayList<Prestamo> listaPrestamo) {
        this.frmPrestamo = frmPrestamo;
        this.ListaUsuario = ListaUsuario;
        this.libro = new Libro();
        this.libro.crearListaLibros();
        this.cntrlUsuario = cntrlUsuario;
        this.idPrestamos = 0;
        this.listaPrestamo = listaPrestamo;

        this.frmPrestamo.btnRPrestamo.addActionListener(this);
        this.frmPrestamo.btnRegistrarUsuario.addActionListener(this);

        refrescarListaLibros();
    }

    public void refrescarListaLibros() {
        frmPrestamo.comBLibro.removeAllItems();
        for (Libro libro : this.libro.getListaLibros()) {
            if (libro.getCanCopiasHay() != 0) {
                frmPrestamo.comBLibro.addItem(libro);
            }
        }
        
    }

    public void refrescarListaUsuario() {
        frmPrestamo.comUsuario.removeAllItems();
        for (Usuario usuario : ListaUsuario) {
            frmPrestamo.comUsuario.addItem(usuario);
        }
    }

    public void abrirPanelUsuario() {
        cntrlUsuario.frmUsuario.setVisible(true);
    }

    public void guardarPrestamo() {
        Usuario usuarioTM = (Usuario) frmPrestamo.comUsuario.getSelectedItem();
        Libro libroTM = (Libro) frmPrestamo.comBLibro.getSelectedItem();
        boolean yaPrestamo = false;
        for (Prestamo prestamo : listaPrestamo) {
            if (prestamo.getUsuario().equals(usuarioTM) && prestamo.getLibro().equals(libroTM)) {
                yaPrestamo = true;
                break;
            }
        }

        if (yaPrestamo) {
            frmPrestamo.txtAMostrar.setText("El usuario ya realizó un prestrámo de este Libro.");
        } else {
            if (libroTM.getCanCopiasHay() == 0) {
                frmPrestamo.txtAMostrar.setText("Ya no hay copias de este libro.");
            } else {
                libroTM.setCanCopiasHay(libroTM.getCanCopiasHay() - 1);
                idPrestamos++;
                String idPrestamoTM = Integer.toString(idPrestamos);
                switch (idPrestamoTM.length()) {
                    case 1:
                        idPrestamoTM = "000" + idPrestamoTM;
                        break;
                    case 2:
                        idPrestamoTM = "00" + idPrestamoTM;
                        break;
                    case 3:
                        idPrestamoTM = "0" + idPrestamoTM;
                        break;
                    default:
                        throw new AssertionError();
                }
                Prestamo prestamoTM = new Prestamo(idPrestamoTM, usuarioTM, libroTM);
                switch (usuarioTM.getTipoUsuario()) {
                    case ADMINISTRATIVO:
                        prestamoTM.setFechaDebeDevolver(prestamoTM.getFechaPrestramo().plusDays(3));
                        break;
                    case PROFESOR:
                        prestamoTM.setFechaDebeDevolver(prestamoTM.getFechaPrestramo().plusDays(15));
                        break;
                    case ESTUDIANTE:
                        prestamoTM.setFechaDebeDevolver(prestamoTM.getFechaPrestramo().plusDays(15));
                        break;
                    default:
                        throw new AssertionError();
                }
                listaPrestamo.add(prestamoTM);
                refrescarListaLibros();

                frmPrestamo.txtAMostrar.setText(""
                        + "¡Se ha realizado un préstamo! \n"
                        + "Información del préstamo: \n"
                        + "Codigo: " + prestamoTM.getId() + "\n"
                        + "Usuario: " + usuarioTM.getNombre() + " (" + usuarioTM.getId() + ") \n"
                        + "Libro: '" + libroTM.getTitulo() + "' escrito por " + libroTM.getAutor() + "\n"
                        + "Fecha de préstamo: " + prestamoTM.getFechaPrestramo().toString() + "\n"
                        + "Fecha máxima que debe ser devuelto el libro: " + prestamoTM.getFechaDebeDevolver().toString() + "\n");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPrestamo.btnRegistrarUsuario) {
            abrirPanelUsuario();
        }
        if (e.getSource() == frmPrestamo.btnRPrestamo) {
            guardarPrestamo();
        }

    }

}
