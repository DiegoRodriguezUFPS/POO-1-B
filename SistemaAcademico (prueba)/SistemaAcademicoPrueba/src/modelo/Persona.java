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
public class Persona {
    private String codigo;
    private String nombre; 
    private String apellidos; 
    private LocalDate fechaNa; 
    private String direccion; 
    private String telefono;
    private ArrayList<Materia> ListaMaterias;


    public Persona() {
    }

    public Persona(String codigo, String nombre, String apellidos, LocalDate fechaNa, String direccion, String telefono, ArrayList<Materia> listaMaterias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNa = fechaNa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ListaMaterias = listaMaterias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNa() {
        return fechaNa;
    }

    public void setFechaNa(LocalDate fechaNa) {
        this.fechaNa = fechaNa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void agregarMateria(Materia materia){
        ListaMaterias.add(materia);
    }
    
    
}
