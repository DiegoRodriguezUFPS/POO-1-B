/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {
    
    protected String nombre;
    protected double cantidadVida;
    protected double nivel;

    public Personaje() {
    }

    public Personaje(String nombre, double cantidadVida, double nivel) {
        this.nombre = nombre;
        this.cantidadVida = cantidadVida;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidadVida() {
        return cantidadVida;
    }

    public void setCantidadVida(double cantidadVida) {
        this.cantidadVida = cantidadVida;
    }

    public double getNivel() {
        return nivel;
    }

    public void setNivel(double nivel) {
        this.nivel = nivel;
    }

   

    public abstract void atacar(Personaje enemigo);
    
}
