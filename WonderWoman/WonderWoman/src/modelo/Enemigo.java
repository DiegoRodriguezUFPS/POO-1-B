/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;

/**
 *
 * @author memoy
 */
public class Enemigo extends Personaje{
    
    private int nivelHostilidad;

    public Enemigo() {
    }

    public Enemigo(int nivelHostilidad, String nombre, double cantidadVida, double nivel) {
        super(nombre, cantidadVida, nivel);
        this.nivelHostilidad = nivelHostilidad;
    }

    public int getNivelHostilidad() {
        return nivelHostilidad;
    }

    public void setNivelHostilidad(int nivelHostilidad) {
        this.nivelHostilidad = nivelHostilidad;
    }
    

    @Override
    public void atacar(Personaje personaje) {
        double danio = 0;
        int posibilidad = (int) (Math.random() * 100) + 1;
        if (posibilidad < nivelHostilidad) {
            danio = nivel * 3;
        }
        personaje.setCantidadVida(personaje.getCantidadVida()-danio);
    }
    
    
}
