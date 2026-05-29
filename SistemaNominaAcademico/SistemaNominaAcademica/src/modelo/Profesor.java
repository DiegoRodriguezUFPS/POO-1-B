/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author roca
 */
public class Profesor extends Empleado {

    private String especialidad;
    private TipoProfesor tipoProfesor;
    private ArrayList<Asignatura> listaAsignatura;
    private ArrayList<Proyecto> listaProyecto;

    public Profesor() {
    }

    public Profesor(String especialidad, TipoProfesor tipoProfesor, String id, String nombres, String apellidos, LocalDate fechaIngreso, String cargo, double SalarioBase) {
        super(id, nombres, apellidos, fechaIngreso, cargo, SalarioBase);
        this.especialidad = especialidad;
        this.tipoProfesor = tipoProfesor;
        this.listaAsignatura = new ArrayList<>();
        this.listaProyecto = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public TipoProfesor getTipoProfesor() {
        return tipoProfesor;
    }

    public void setTipoProfesor(TipoProfesor tipoProfesor) {
        this.tipoProfesor = tipoProfesor;
    }

    public ArrayList<Asignatura> getListaAsignatura() {
        return listaAsignatura;
    }

    public void agregarAsignatura(Asignatura asignatura) {
        listaAsignatura.add(asignatura);
    }

    public ArrayList<Proyecto> getListaProyecto() {
        return listaProyecto;
    }

    public void setListaAsignatura(ArrayList<Asignatura> listaAsignatura) {
        this.listaAsignatura = listaAsignatura;
    }

    public void setListaProyecto(ArrayList<Proyecto> listaProyecto) {
        this.listaProyecto = listaProyecto;
    }

    
    
    public void agregarProyecto(Proyecto proyecto) {
        listaProyecto.add(proyecto);
    }

    public double getCantidadPuntos() {
        double puntos = 0;
        if (listaProyecto != null) {
            for (Proyecto proyecto : listaProyecto) {
                try {
                    for (Producto producto : proyecto.getListaProducto()) {
                        puntos += producto.getPuntos();
                    }
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }
        }
        return puntos;
    }

    public double calcularBonificacion() {
        double bonificacion = 0;
        double puntos = getCantidadPuntos();

        if (puntos >= 80) {
            bonificacion = 120000;
        } else if (puntos >= 70) {
            bonificacion = 100000;
        } else if (puntos >= 50) {
            bonificacion = 70000;
        } else if (puntos >= 30) {
            bonificacion = 40000;
        }

        return bonificacion;
    }

    @Override
    public double calcularSalario() {
        double bonificacion = calcularBonificacion();
        double salario = salarioBase + bonificacion;
        return salario;
    }

    @Override
    public String toString() {
        return nombres + " " + apellidos; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

}
