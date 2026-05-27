/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;




public class Escenario {
    private String id;
    private String nombre;
    private float posicionX;
    private float posicionY;
    private ArrayList<Personaje> listaPersonaje;

    public Escenario() {
    }

    public Escenario(String id, String nombre, float posicionX, float posicionY) {
        this.id = id;
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.listaPersonaje = new ArrayList<>();
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

    public float getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(float posicionX) {
        this.posicionX = posicionX;
    }

    public float getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(float posicionY) {
        this.posicionY = posicionY;
    }
    
    public void agregarPersonaje(Personaje personaje){
        listaPersonaje.add(personaje);
    }
    
    
}
