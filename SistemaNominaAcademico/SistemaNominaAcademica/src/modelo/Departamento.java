/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author roca
 */
public class Departamento {
    public String id;
    public String nombre;
    public String enfoque;

    public Departamento() {
    }

    public Departamento(String id, String nombre, String enfoque) {
        this.id = id;
        this.nombre = nombre;
        this.enfoque = enfoque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnfoque() {
        return enfoque;
    }

    public void setEnfoque(String enfoque) {
        this.enfoque = enfoque;
    }

    @Override
    public String toString() {
        return nombre; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}
