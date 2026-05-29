/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Empleado;
import modelo.Producto;
import modelo.Profesor;
import modelo.Proyecto;
import modelo.TipoProducto;
import modelo.TipoProyecto;
import vista.JFCrearProducto;
import vista.JFGestorProyectos;

/**
 *
 * @author roca
 */
public class CntrlGestorProyectos implements ActionListener {

    JFGestorProyectos frmGestorProyectos;
    JFCrearProducto frmCrearProducto;
    ArrayList<Empleado> listaEmpleado;
    ArrayList<Producto> listaProducto;
    ArrayList<Proyecto> listaProyecto;

    public CntrlGestorProyectos() {
    }

    public CntrlGestorProyectos(JFGestorProyectos frmGestorProyectos, JFCrearProducto frmCrearProducto, ArrayList<Empleado> listaEmpleado) {
        this.frmGestorProyectos = frmGestorProyectos;
        this.frmCrearProducto = frmCrearProducto;
        listaProducto = new ArrayList<>();
        listaProyecto = new ArrayList<>();
        this.listaEmpleado = listaEmpleado;

        this.frmGestorProyectos.btnCrearProyecto.addActionListener(this);
        this.frmGestorProyectos.btnAgregarProfesor.addActionListener(this);
        this.frmGestorProyectos.btnAsignarProducto.addActionListener(this);
        this.frmGestorProyectos.btnCrearProducto.addActionListener(this);
        this.frmCrearProducto.btnGuardarProyecto.addActionListener(this);
    }

    public void crearProyecto() {
        String id = frmGestorProyectos.txtId.getText();
        String nombre = frmGestorProyectos.txtNombre.getText();
        String tipoProyectoTM = (String) frmGestorProyectos.comBTipoProyecto.getSelectedItem();
        TipoProyecto tipoProyecto = null;
        switch (tipoProyectoTM) {
            case "Investigacion" -> {
                tipoProyecto = TipoProyecto.INVESTIGACION;
            }
            case "Extension" -> {
                tipoProyecto = TipoProyecto.EXTENSION;
            }
            default ->
                throw new AssertionError();
        }

        Proyecto proyecto = new Proyecto(id, tipoProyecto, nombre);
        listaProyecto.add(proyecto);
        actualizarComBProyecto();
    }

    public void actualizarComBProyecto() {
        //Profesor
        frmGestorProyectos.comBProyectoProfesor.removeAllItems();
        for (Proyecto proyecto : listaProyecto) {
            frmGestorProyectos.comBProyectoProfesor.addItem(proyecto);
        }

        //Producto
        frmGestorProyectos.comBProyectoProducto.removeAllItems();
        for (Proyecto proyecto : listaProyecto) {
            frmGestorProyectos.comBProyectoProducto.addItem(proyecto);
        }
    }

    public void actualizarComBProfesor() {
        frmGestorProyectos.comBProfesor.removeAllItems();
        for (Empleado empleado : listaEmpleado) {
            if (empleado instanceof Profesor) {
                Profesor profesor = (Profesor) empleado;
                frmGestorProyectos.comBProfesor.addItem(profesor);
            }
        }
    }

    public void abrirCrearProducto() {
        frmCrearProducto.setVisible(true);
    }

    //JFCrearProducto
    public void CrearProducto() {
        String id = frmCrearProducto.txtId.getText();
        String nombre = frmCrearProducto.txtNombre.getText();
        String puntosTM = frmCrearProducto.txtPuntos.getText();

        if (id.trim().isEmpty() || nombre.trim().isEmpty() || puntosTM.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(frmCrearProducto, "Porfavor, rellene todos los campos");
        } else {
            String tipoProductoTM = (String) frmCrearProducto.comBTipoProyecto.getSelectedItem();
            TipoProducto tipoProducto = null;
            switch (tipoProductoTM) {
                case "Articulo" -> {
                    tipoProducto = TipoProducto.ARTICULO;
                }
                case "Libro" -> {
                    tipoProducto = TipoProducto.LIBRO;
                }
                case "Ponencia" -> {
                    tipoProducto = TipoProducto.PONENCIA;
                }
                case "Software" -> {
                    tipoProducto = TipoProducto.SOFTWARE;
                }
                default ->
                    throw new AssertionError();
            }
            int puntos = 0;
            boolean puntosNoInt = false;
            try {
                puntos = Integer.parseInt(puntosTM);
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(frmCrearProducto, "Los puntos deben ser estrictamentes numeros");
                puntosNoInt = true;
            }

            if (!puntosNoInt) {
                Producto producto = new Producto(id, nombre, tipoProducto, puntos);
                listaProducto.add(producto);
                frmGestorProyectos.comBProducto.removeAllItems();
                for (Producto productoTM : listaProducto) {
                    frmGestorProyectos.comBProducto.addItem(productoTM);
                }
            }
        }
    }

    public void agregarProfesoraProyecto() {
        Profesor profesorTM = (Profesor) frmGestorProyectos.comBProfesor.getSelectedItem();
        Proyecto proyectoTM = (Proyecto) frmGestorProyectos.comBProyectoProfesor.getSelectedItem();

        if (profesorTM == null || proyectoTM == null) {
            javax.swing.JOptionPane.showMessageDialog(frmGestorProyectos, "No hay un proyecto o profesor seleccionado");
        } else {
            for (Proyecto proyecto : profesorTM.getListaProyecto()) {
                if (proyectoTM.equals(proyecto)) {
                    javax.swing.JOptionPane.showMessageDialog(frmGestorProyectos, "Este profesor ya está en este proyecto");
                    return;
                }
            }
            profesorTM.agregarProyecto(proyectoTM);
            javax.swing.JOptionPane.showMessageDialog(frmGestorProyectos, "El profesor ahora pertece a ese proyecto");

        }
    }

    public void asignarProductoAProyecto() {
        Producto productoTM = (Producto) frmGestorProyectos.comBProducto.getSelectedItem();
        Proyecto proyectoTM = (Proyecto) frmGestorProyectos.comBProyectoProducto.getSelectedItem();

        if (productoTM == null || proyectoTM == null) {
            javax.swing.JOptionPane.showMessageDialog(frmGestorProyectos, "No hay un proyecto o producto seleccionado");
        } else {

            for (Producto producto : proyectoTM.getListaProducto()) {
                if (productoTM.equals(producto)) {
                    javax.swing.JOptionPane.showMessageDialog(frmGestorProyectos, "Ya existe este producto en este Proyecto");
                    return;
                }
            }
            proyectoTM.agregarProducto(productoTM);
            javax.swing.JOptionPane.showMessageDialog(frmGestorProyectos, "Se ha guardado el producto en el proyecto");

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmGestorProyectos.btnCrearProyecto) {
            crearProyecto();
        }

        if (e.getSource() == frmGestorProyectos.btnAgregarProfesor) {
            agregarProfesoraProyecto();
        }

        if (e.getSource() == frmGestorProyectos.btnAsignarProducto) {
            asignarProductoAProyecto();
        }

        if (e.getSource() == frmGestorProyectos.btnCrearProducto) {
            abrirCrearProducto();
        }

        if (e.getSource() == frmCrearProducto.btnGuardarProyecto) {
            CrearProducto();
        }
    }

}
