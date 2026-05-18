/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author roca
 */
public class Docente extends Persona{
    private String especialidad;
    private ArrayList<Grupo> ListaGrupos;

    public Docente() {
    }

    public Docente(String especialidad, String codigo, String nombre, String apellidos, LocalDate fechaNa, String direccion, String telefono, ArrayList<Materia> listaMaterias) {
        super(codigo, nombre, apellidos, fechaNa, direccion, telefono, listaMaterias);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Grupo> getListaGrupos() {
        return ListaGrupos;
    }

    public void setListaGrupos(ArrayList<Grupo> ListaGrupos) {
        this.ListaGrupos = ListaGrupos;
    }
    
    
    
    
}
