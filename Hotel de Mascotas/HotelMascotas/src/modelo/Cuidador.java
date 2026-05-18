/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author roca
 */
public class Cuidador {
    private String id;
    private String nombre;
    private String nivExperiencia;
    private AtiendeEsp atiendeEsp;
    private boolean estaDisponible;
    private ArrayList<Cuidador> ListaCuaidador;

    public Cuidador() {
    }

    
    public Cuidador(String id, String nombre, String nivExperiencia, AtiendeEsp atiendeEsp) {
        this.id = id;
        this.nombre = nombre;
        this.nivExperiencia = nivExperiencia;
        this.atiendeEsp = atiendeEsp;
        this.estaDisponible = true;
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

    public String getNivExperiencia() {
        return nivExperiencia;
    }

    public void setNivExperiencia(String nivExperiencia) {
        this.nivExperiencia = nivExperiencia;
    }

    public AtiendeEsp getAtiendeEsp() {
        return atiendeEsp;
    }

    public void setAtiendeEsp(AtiendeEsp atiendeEsp) {
        this.atiendeEsp = atiendeEsp;
    }

    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }
    

    
    public ArrayList<Cuidador> getListaCuaidador() {
        return ListaCuaidador;
    }

    public void setListaCuaidador(ArrayList<Cuidador> ListaCuaidador) {
        this.ListaCuaidador = ListaCuaidador;
    }

    public void crearListaCuidador(){
        ListaCuaidador = new ArrayList<>();
        ListaCuaidador.add(new Cuidador("5643", "Pepe", "Alto", AtiendeEsp.ACUATICOS));
        ListaCuaidador.add(new Cuidador("5343", "Carlitos", "Medio", AtiendeEsp.CANINOS));
        ListaCuaidador.add(new Cuidador("5321", "Yesenia", "Bajo", AtiendeEsp.FELINOS));
        ListaCuaidador.add(new Cuidador("5311", "Junior", "Medio", AtiendeEsp.ROEDORES));
        ListaCuaidador.add(new Cuidador("5398", "Yeikleiverson", "Alto", AtiendeEsp.CANINOS));
    }

    @Override
    public String toString() {
        return nombre;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}
