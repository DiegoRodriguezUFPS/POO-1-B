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
import modelo.Administrativo;
import modelo.Asignatura;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Profesor;
import modelo.TipoProfesor;
import vista.JFIngresarEmpleado;

/**
 *
 * @author roca
 */
public class CntrlIngresarEmpleado implements ActionListener {

    private JFIngresarEmpleado frmIngresarEmpleado;
    private ArrayList<Empleado> listaEmpleado;
    private ArrayList<Asignatura> listaAsignatura;
    private ArrayList<Departamento> listaDepartamento;
    private CntrlGestorProyectos cntrlGestorProyectos;
    private CntrlMostrador cntrlMostrador;

    public CntrlIngresarEmpleado() {
    }

    public CntrlIngresarEmpleado(JFIngresarEmpleado frmIngresarEmpleado, ArrayList<Empleado> listaEmpleado, CntrlGestorProyectos cntrlGestorProyectos, CntrlMostrador cntrlMostrador) {
        this.frmIngresarEmpleado = frmIngresarEmpleado;
        this.listaEmpleado = listaEmpleado;
        this.listaAsignatura = new ArrayList<>();
        this.listaDepartamento = new ArrayList<>();
        this.cntrlGestorProyectos = cntrlGestorProyectos;
        this.cntrlMostrador = cntrlMostrador;

        crearListaAsignatura();

        this.frmIngresarEmpleado.btnAñadirAsignatura.addActionListener(this);
        this.frmIngresarEmpleado.btnGuardarDepartamento.addActionListener(this);
        this.frmIngresarEmpleado.btnGuardar.addActionListener(this);
        this.frmIngresarEmpleado.comBTipoEmpleado.addActionListener(this);

    }

    public void crearListaAsignatura() {
        ArrayList<Asignatura> listaAsignaturaTM = new ArrayList<>();
        listaAsignaturaTM.add(new Asignatura("0192", "Calculo", 5, 4));
        listaAsignaturaTM.add(new Asignatura("0484", "POO", 5, 6));
        listaAsignaturaTM.add(new Asignatura("0124", "Sociales", 3, 2));
        listaAsignaturaTM.add(new Asignatura("0123", "Inglés", 2, 2));
        listaAsignaturaTM.add(new Asignatura("0586", "Comunicacion", 2, 3));
        listaAsignaturaTM.add(new Asignatura("0596", "Algebra", 3, 5));

        for (Asignatura asignatura : listaAsignaturaTM) {
            frmIngresarEmpleado.comBAsignatura.addItem(asignatura);
        }

    }

    public void formularioSegunEmpleado() {
        if (frmIngresarEmpleado.comBTipoEmpleado.getSelectedItem() == null) {
            return;
        }

        String tipoEmpleado = (String) frmIngresarEmpleado.comBTipoEmpleado.getSelectedItem();

        if (tipoEmpleado.equalsIgnoreCase("Profesor")) {
            frmIngresarEmpleado.jPanelProfesor.setEnabled(true);
            frmIngresarEmpleado.lblEspecialidad.setEnabled(true);
            frmIngresarEmpleado.txtEspecialidad.setEnabled(true);
            frmIngresarEmpleado.lblTipoProfesor.setEnabled(true);

            frmIngresarEmpleado.jPanelAsignatura.setEnabled(true);
            frmIngresarEmpleado.lblAsignatura.setEnabled(true);
            frmIngresarEmpleado.comBAsignatura.setEnabled(true);
            frmIngresarEmpleado.comBTipoProfesor.setEnabled(true);
            frmIngresarEmpleado.lblTextoProfesor.setEnabled(true);
            frmIngresarEmpleado.btnAñadirAsignatura.setEnabled(true);

            frmIngresarEmpleado.jPanelAdministrativo.setEnabled(false);
            frmIngresarEmpleado.jPanelDepartamento.setEnabled(false);
            frmIngresarEmpleado.lblIdDepartamento.setEnabled(false);
            frmIngresarEmpleado.txtIdAdministrativo.setEnabled(false);
            frmIngresarEmpleado.lblNombreDepartamento.setEnabled(false);
            frmIngresarEmpleado.txtNombreDepartamento.setEnabled(false);
            frmIngresarEmpleado.txtEnfoque.setEnabled(false);
            frmIngresarEmpleado.btnGuardarDepartamento.setEnabled(false);
            frmIngresarEmpleado.lblTextoDepartamento.setEnabled(false);
            frmIngresarEmpleado.comBDepartamento.setEnabled(false);

        } else if (tipoEmpleado.equalsIgnoreCase("Administrativo")) {
            frmIngresarEmpleado.jPanelProfesor.setEnabled(false);
            frmIngresarEmpleado.lblEspecialidad.setEnabled(false);
            frmIngresarEmpleado.txtEspecialidad.setEnabled(false);
            frmIngresarEmpleado.lblTipoProfesor.setEnabled(false);

            frmIngresarEmpleado.jPanelAsignatura.setEnabled(false);
            frmIngresarEmpleado.lblAsignatura.setEnabled(false);
            frmIngresarEmpleado.comBAsignatura.setEnabled(false);
            frmIngresarEmpleado.lblTextoProfesor.setEnabled(false);
            frmIngresarEmpleado.btnAñadirAsignatura.setEnabled(false);
            frmIngresarEmpleado.comBTipoProfesor.setEnabled(false);

            frmIngresarEmpleado.jPanelAdministrativo.setEnabled(true);
            frmIngresarEmpleado.jPanelDepartamento.setEnabled(true);
            frmIngresarEmpleado.lblIdDepartamento.setEnabled(true);
            frmIngresarEmpleado.txtIdAdministrativo.setEnabled(true);
            frmIngresarEmpleado.lblNombreDepartamento.setEnabled(true);
            frmIngresarEmpleado.txtNombreDepartamento.setEnabled(true);
            frmIngresarEmpleado.txtEnfoque.setEnabled(true);
            frmIngresarEmpleado.lblEnfoque.setEnabled(true);
            frmIngresarEmpleado.btnGuardarDepartamento.setEnabled(true);
            frmIngresarEmpleado.lblTextoDepartamento.setEnabled(true);
            frmIngresarEmpleado.comBDepartamento.setEnabled(true);
        } else {
            frmIngresarEmpleado.jPanelProfesor.setEnabled(false);
            frmIngresarEmpleado.lblEspecialidad.setEnabled(false);
            frmIngresarEmpleado.txtEspecialidad.setEnabled(false);
            frmIngresarEmpleado.lblTipoProfesor.setEnabled(false);

            frmIngresarEmpleado.jPanelAsignatura.setEnabled(false);
            frmIngresarEmpleado.lblAsignatura.setEnabled(false);
            frmIngresarEmpleado.comBAsignatura.setEnabled(false);
            frmIngresarEmpleado.lblTextoProfesor.setEnabled(false);
            frmIngresarEmpleado.btnAñadirAsignatura.setEnabled(false);
            frmIngresarEmpleado.comBTipoProfesor.setEnabled(false);
            frmIngresarEmpleado.jPanelAdministrativo.setEnabled(false);
            frmIngresarEmpleado.jPanelDepartamento.setEnabled(false);
            frmIngresarEmpleado.lblIdDepartamento.setEnabled(false);
            frmIngresarEmpleado.txtIdAdministrativo.setEnabled(false);
            frmIngresarEmpleado.lblNombreDepartamento.setEnabled(false);
            frmIngresarEmpleado.txtNombreDepartamento.setEnabled(false);
            frmIngresarEmpleado.txtEnfoque.setEnabled(false);
            frmIngresarEmpleado.btnGuardarDepartamento.setEnabled(false);
            frmIngresarEmpleado.lblTextoDepartamento.setEnabled(false);
            frmIngresarEmpleado.comBDepartamento.setEnabled(false);
        }
    }

    public void guardarDatos() {
        String id = frmIngresarEmpleado.txtId.getText();
        String nombres = frmIngresarEmpleado.txtNombre.getText();
        String apellidos = frmIngresarEmpleado.txtApellido.getText();
        String cargo = frmIngresarEmpleado.txtCargo.getText();
        String salarioString = frmIngresarEmpleado.txtSalario.getText();
        Date fechaDate = frmIngresarEmpleado.jDateIngreso.getDate();

        if (id.trim().equals("")
                || nombres.trim().equals("")
                || apellidos.trim().equals("")
                || cargo.trim().equals("")
                || salarioString.trim().equals("")
                || fechaDate == null) {

            javax.swing.JOptionPane.showMessageDialog(frmIngresarEmpleado, "Rellene todos los datos antes de registrar al empleado.");
        } else {
            LocalDate fechaIngreso = fechaDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            Double salarioBase = 0.0;
            boolean salarioBaseNumero = true;
            try {
                salarioBase = Double.valueOf(salarioString);
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(frmIngresarEmpleado, "Revise el salario base, debe ingreasar un número.");
                salarioBaseNumero = false;
            }
            if (salarioBaseNumero) {
                if (frmIngresarEmpleado.comBTipoEmpleado.getSelectedItem().equals(" ")) {
                    javax.swing.JOptionPane.showMessageDialog(frmIngresarEmpleado, "Porfavor, escoja que tipo de empleado es.");
                    return;
                }

                String tipoEmpleado = (String) frmIngresarEmpleado.comBTipoEmpleado.getSelectedItem();

                if (tipoEmpleado.equalsIgnoreCase("Profesor")) {
                    String especialidad = frmIngresarEmpleado.txtEspecialidad.getText();
                    String tipoProfesorTM = (String) frmIngresarEmpleado.comBTipoProfesor.getSelectedItem();
                    TipoProfesor tipoProfesor = null;
                    switch (tipoProfesorTM) {
                        case "Catedratico" -> {
                            tipoProfesor = TipoProfesor.CATEDRATICO;
                        }
                        case "Ocasional" -> {
                            tipoProfesor = TipoProfesor.OCASIONAL;
                        }
                        case "Asociado" -> {
                            tipoProfesor = TipoProfesor.ASOCIADO;
                        }
                        default ->
                            throw new AssertionError();
                    }

                    Profesor profesor = new Profesor(especialidad, tipoProfesor, id, nombres, apellidos, fechaIngreso, cargo, salarioBase);
                    if (!listaAsignatura.isEmpty()) {
                        ArrayList<Asignatura> listaAsignaturaTM = new ArrayList<>(listaAsignatura);
                        profesor.setListaAsignatura(listaAsignaturaTM);
                        listaAsignatura.clear();
                        listaEmpleado.add(profesor);
                        javax.swing.JOptionPane.showMessageDialog(frmIngresarEmpleado, "Se ha guardado el empleado.");
                        limpiarCampos();
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(frmIngresarEmpleado, "No ha añadido ninguna asignatura.");
                    }

                } else if (tipoEmpleado.equalsIgnoreCase("Administrativo")) {
                    Departamento departamento = (Departamento) frmIngresarEmpleado.comBDepartamento.getSelectedItem();
                    if (departamento != null) {
                        Administrativo administrativo = new Administrativo(departamento, id, nombres, apellidos, fechaIngreso, cargo, salarioBase);
                        listaEmpleado.add(administrativo);
                        javax.swing.JOptionPane.showMessageDialog(frmIngresarEmpleado, "Se ha guardado el empleado.");
                        limpiarCampos();

                    } else {
                        javax.swing.JOptionPane.showMessageDialog(frmIngresarEmpleado, "Seleccione/Cree un nuevo departamento");

                    }
                }

            }
        }
        cntrlGestorProyectos.actualizarComBProfesor();
        cntrlMostrador.refrescarComBEmpleado();
    }

    public void guardarDepartamento() {
        String idDepartamento = frmIngresarEmpleado.txtIdAdministrativo.getText();
        String nombreDepartamento = frmIngresarEmpleado.txtNombreDepartamento.getText();
        String enfoque = frmIngresarEmpleado.txtEnfoque.getText();

        if (idDepartamento.trim().equals("") || nombreDepartamento.trim().equals("") || enfoque.trim().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(frmIngresarEmpleado, "Rellene todos los datos antes de crear el departamento");

        }

        Departamento departamento = new Departamento(idDepartamento, nombreDepartamento, enfoque);
        listaDepartamento.add(departamento);
        actualizarcomBDepartamento();
    }

    public void aniadirAsignatura() {
        Asignatura asignatura = (Asignatura) frmIngresarEmpleado.comBAsignatura.getSelectedItem();

        boolean yaEsta = false;
        for (Asignatura asignaturaTM : listaAsignatura) {
            if (asignaturaTM.equals(asignatura)) {
                javax.swing.JOptionPane.showMessageDialog(frmIngresarEmpleado, "Ya añadió esta asignatura.");
                yaEsta = true;
                return;
            }
        }

        if (!yaEsta) {
            listaAsignatura.add(asignatura);
        }
    }

    public void actualizarcomBDepartamento() {
        frmIngresarEmpleado.comBDepartamento.removeAllItems();
        for (Departamento departamento : listaDepartamento) {
            frmIngresarEmpleado.comBDepartamento.addItem(departamento);
        }
    }

    public void limpiarCampos() {
        frmIngresarEmpleado.txtId.setText("");
        frmIngresarEmpleado.txtNombre.setText("");
        frmIngresarEmpleado.txtApellido.setText("");
        frmIngresarEmpleado.txtCargo.setText("");
        frmIngresarEmpleado.txtSalario.setText("");
        frmIngresarEmpleado.txtEnfoque.setText("");
        frmIngresarEmpleado.txtEspecialidad.setText("");
        frmIngresarEmpleado.txtIdAdministrativo.setText("");
        frmIngresarEmpleado.txtNombreDepartamento.setText("");

        frmIngresarEmpleado.jDateIngreso.setDate(null);
        frmIngresarEmpleado.comBTipoEmpleado.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmIngresarEmpleado.comBTipoEmpleado) {
            formularioSegunEmpleado();
        }

        if (e.getSource() == frmIngresarEmpleado.btnGuardar) {
            guardarDatos();
        }

        if (e.getSource() == frmIngresarEmpleado.btnAñadirAsignatura) {
            aniadirAsignatura();
        }

        if (e.getSource() == frmIngresarEmpleado.btnGuardarDepartamento) {
            guardarDepartamento();
        }
    }
}
