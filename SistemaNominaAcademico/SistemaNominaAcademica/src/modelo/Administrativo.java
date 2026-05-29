/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author roca
 */
public class Administrativo extends Empleado {

    private Departamento departamento;

    public Administrativo() {
    }

    public Administrativo(Departamento departamento, String id, String nombres, String apellidos, LocalDate fechaIngreso, String cargo, double SalarioBase) {
        super(id, nombres, apellidos, fechaIngreso, cargo, SalarioBase);
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public double calcularSalario() {
        double salario = salarioBase + calcularBonificacion();
        return salario;
    }

    @Override
    public double calcularBonificacion() {
        double bonificacion = 0;
        long antiguedad = calcularAntiguedad();
        if (antiguedad >= 3652) {
            bonificacion += 200000;
        } else if (antiguedad >= 2922) {
            bonificacion += 120000;
        } else if (antiguedad >= 1826) {
            bonificacion += 80000;
        }

        return bonificacion;
    }

    @Override
    public String toString() {
        return nombres; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

}
