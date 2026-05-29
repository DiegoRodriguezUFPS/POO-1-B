/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author roca
 */
public abstract class Empleado {

    protected String id;
    protected String nombres;
    protected String apellidos;
    protected LocalDate fechaIngreso;
    protected String cargo;
    protected double salarioBase;

    public Empleado() {
    }

    public Empleado(String id, String nombres, String apellidos, LocalDate fechaIngreso, String cargo, double SalarioBase) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        this.salarioBase = SalarioBase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double SalarioBase) {
        this.salarioBase = SalarioBase;
    }

    public long calcularAntiguedad() {
        long antiguedad = 0;
        LocalDate fechaActual = LocalDate.now();
        antiguedad = ChronoUnit.DAYS.between(fechaIngreso, fechaActual);

        return antiguedad;
    }

    public abstract double calcularSalario();

    public abstract double calcularBonificacion();

}
