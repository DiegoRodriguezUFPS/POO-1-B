/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Administrativo;
import modelo.Empleado;
import modelo.Profesor;
import vista.JFMostrador;

/**
 *
 * @author roca
 */
public class CntrlMostrador implements ActionListener {

    private JFMostrador frmMostrador;
    private ArrayList<Empleado> listaEmpleado;

    public CntrlMostrador(JFMostrador frmMostrador, ArrayList<Empleado> listaEmpleado) {
        this.frmMostrador = frmMostrador;
        this.listaEmpleado = listaEmpleado;
        this.frmMostrador.btnMostrar.addActionListener(this);
    }

    public void mostrar() {
        Empleado empleadoTM = (Empleado) frmMostrador.comBEmpleado.getSelectedItem();

        if (empleadoTM == null) {
            javax.swing.JOptionPane.showMessageDialog(frmMostrador, "No hay empleado seleccionado: ");
        } else {
            frmMostrador.txtAResultados.setText("");
            frmMostrador.txtAResultados.append(" ------- INFORMACION -------\n");
            frmMostrador.txtAResultados.append("Id: " + empleadoTM.getId() + "\n");
            frmMostrador.txtAResultados.append("Nombres: " + empleadoTM.getNombres() + "\n");
            frmMostrador.txtAResultados.append("Apellidos: " + empleadoTM.getApellidos() + "\n");
            frmMostrador.txtAResultados.append("Cargo: " + empleadoTM.getCargo() + "\n");
            frmMostrador.txtAResultados.append("Antigüedad: " + empleadoTM.calcularAntiguedad() + "\n");

            if (empleadoTM instanceof Profesor) {
                Profesor profesor = (Profesor) empleadoTM;
                frmMostrador.txtAResultados.append("# Proyectos que pertenece: " + profesor.getListaProyecto().size() + "\n");
                frmMostrador.txtAResultados.append("Cantidad de puntos acumulados: " + profesor.getCantidadPuntos() + "\n");
                frmMostrador.txtAResultados.append("Salario Base: " + profesor.getSalarioBase() + "\n");
                frmMostrador.txtAResultados.append("El valor de Bonificacion: " + profesor.calcularBonificacion() + "\n");
                frmMostrador.txtAResultados.append("Salario Total: " + profesor.calcularSalario() + "\n");
            }

            if (empleadoTM instanceof Administrativo) {
                Administrativo administrativo = (Administrativo) empleadoTM;
                frmMostrador.txtAResultados.append("Salario Base: " + administrativo.getSalarioBase() + "\n");
                frmMostrador.txtAResultados.append("Departamento: " + administrativo.getDepartamento() + "\n");
                frmMostrador.txtAResultados.append("El valor de Bonificacion: " + administrativo.calcularBonificacion() + "\n");
                frmMostrador.txtAResultados.append("Salario Total: " + administrativo.calcularSalario() + "\n");

            }

        }

    }

    public void refrescarComBEmpleado() {
        frmMostrador.comBEmpleado.removeAllItems();
        for (Empleado empleado : listaEmpleado) {
            frmMostrador.comBEmpleado.addItem(empleado);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmMostrador.btnMostrar) {
            mostrar();
        }
    }

}
