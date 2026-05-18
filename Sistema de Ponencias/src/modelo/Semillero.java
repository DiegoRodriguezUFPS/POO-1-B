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
public class Semillero {
    private String nombre;
    private ArrayList<Estudiante> ListaEstudiantes;
    private GrupodeInvestigacion grupoInv;
    private Participante encargado;

    public Semillero() {
    }

    public Semillero(String nombre, Participante encargado, GrupodeInvestigacion grupoInv) {
        this.nombre = nombre;
        this.grupoInv = grupoInv;
        this.encargado = encargado;
        this.ListaEstudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Participante getEncargado() {
        return encargado;
    }

    public void setEncargado(Participante encargado) {
        this.encargado = encargado;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return ListaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> ListaEstudiantes) {
        this.ListaEstudiantes = ListaEstudiantes;
    }
    
    public String toString(){
        return nombre;
    }
}
