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
public class Estudiante extends Participante{
    private boolean perteneceSemillero;
    private ArrayList<Estudiante> ListaEstudiante;

    public Estudiante() {
    }

    public Estudiante(boolean perteneceSemillero, String codigo, String nombre, String institucion) {
        super(codigo, nombre, institucion);
        this.perteneceSemillero = perteneceSemillero;
    }

    public boolean isPerteneceSemillero() {
        return perteneceSemillero;
    }

    public void setPerteneceSemillero(boolean perteneceSemillero) {
        this.perteneceSemillero = perteneceSemillero;
    }

    public ArrayList<Estudiante> getListaEstudiante() {
        return ListaEstudiante;
    }

    public void setListaEstudiante(ArrayList<Estudiante> ListaEstudiante) {
        this.ListaEstudiante = ListaEstudiante;
    }
    
    public void crearListaEstudiante(){
        ListaEstudiante = new ArrayList<>();
        ListaEstudiante.add(new Estudiante(false, "435112", "James", "Patria"));
        ListaEstudiante.add(new Estudiante(false, "756231", "Lucas", "Niveria"));
        ListaEstudiante.add(new Estudiante(false, "089765", "Esper", "San Jose"));
        ListaEstudiante.add(new Estudiante(false, "293458", "Quito", "Queresca"));
        ListaEstudiante.add(new Estudiante(false, "972349", "Humos", "Marimondo"));
    }
    
    @Override
    public String toString() {
    return nombre + "(E)";
    }
}
