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
    private Especialidad especialidad;
    private boolean estaDisponible;
    private ArrayList<Cuidador> ListaCuaidador;

    public Cuidador() {
    }

    public Cuidador(String id, String nombre, String nivExperiencia, Especialidad atiendeEsp) {
        this.id = id;
        this.nombre = nombre;
        this.nivExperiencia = nivExperiencia;
        this.especialidad = atiendeEsp;
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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
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

    public void crearListaCuidador() {
        ListaCuaidador = new ArrayList<>();
        ListaCuaidador.add(new Cuidador("5643", "Pepe", "Alto", Especialidad.ACUATICOS));
        ListaCuaidador.add(new Cuidador("5343", "Carlitos", "Medio", Especialidad.CANINOS));
        ListaCuaidador.add(new Cuidador("5321", "Yesenia", "Bajo", Especialidad.FELINOS));
        ListaCuaidador.add(new Cuidador("5311", "Junior", "Medio", Especialidad.ROEDORES));
        ListaCuaidador.add(new Cuidador("5398", "Yeikleiverson", "Alto", Especialidad.CANINOS));
        ListaCuaidador.add(new Cuidador("5421", "Estefany", "Alto", Especialidad.FELINOS));
        ListaCuaidador.add(new Cuidador("5477", "Brayan", "Bajo", Especialidad.ACUATICOS));
        ListaCuaidador.add(new Cuidador("5510", "Ximena", "Medio", Especialidad.ROEDORES));
        ListaCuaidador.add(new Cuidador("5688", "Wuilmer", "Alto", Especialidad.CANINOS));
        ListaCuaidador.add(new Cuidador("5732", "Camila", "Medio", Especialidad.FELINOS));
    }

    @Override
    public String toString() {
        return nombre;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
