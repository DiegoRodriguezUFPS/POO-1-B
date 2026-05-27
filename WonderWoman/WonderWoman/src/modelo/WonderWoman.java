/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author memoy
 */
public class WonderWoman extends Personaje{
    private String origen;
    private ArrayList<Habilidad> listaHabilidades;
    private ArrayList<Equipo> listaEquipo;

    public WonderWoman() {
    }

    public WonderWoman(String origen, String nombre, double cantidadVida, double nivel) {
        super(nombre, cantidadVida, nivel);
        this.origen = origen;
        this.listaHabilidades = new ArrayList<>();
        this.listaHabilidades.add(new Habilidad());
        this.listaEquipo = new ArrayList<>();
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public ArrayList<Habilidad> getListaHabilidades() {
        return listaHabilidades;
    }

    public ArrayList<Equipo> getListaEquipo() {
        return listaEquipo;
    }
    
    public void agregarHabilidad(Habilidad habilidad){
        listaHabilidades.add(habilidad);
    }
    
    public void agregarEquipo(Equipo equipo){
        listaEquipo.add(equipo);
    }
    
    @Override
    public void atacar(Personaje enemigo) {
        enemigo.setCantidadVida(enemigo.getCantidadVida()-nivel);
    }
    
    
    

    
}