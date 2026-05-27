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
public class Aliado extends Personaje{
    private String tipoAyuda;

    public Aliado() {
    }

    public Aliado(String tipoAyuda, String nombre, double cantidadVida, double nivel) {
        super(nombre, cantidadVida, nivel);
        this.tipoAyuda = tipoAyuda;
    }

    public String getTipoAyuda() {
        return tipoAyuda;
    }

    public void setTipoAyuda(String tipoAyuda) {
        this.tipoAyuda = tipoAyuda;
    }

    @Override
    public void atacar(Personaje enemigo) {
        if (tipoAyuda.equals("Ataque")) {
            enemigo.setCantidadVida(enemigo.getCantidadVida()-40);
        }
    }
}
