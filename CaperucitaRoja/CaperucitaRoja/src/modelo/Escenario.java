/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Escenario {
    protected String nombre;
    protected double ancho;
    protected double altura;

    public Escenario(String nombre, double ancho, double altura) {
        this.nombre = nombre;
        this.ancho = ancho;
        this.altura = altura;
    }
    
    //getters

    public String getNombre() {
        return nombre;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAltura() {
        return altura;
    }

    
    //////setterss

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
    
}
