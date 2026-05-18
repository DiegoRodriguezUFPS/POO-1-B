/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author roca
 */
public class Grupo {
    private String nombre;
    private int cantidadEstudiante;
    private Docente docente;

    public Grupo() {
    }

    public Grupo(String nombre, int cantidadEstudiante, Docente docente) {
        this.nombre = nombre;
        this.cantidadEstudiante = cantidadEstudiante;
        this.docente = docente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadEstudiante() {
        return cantidadEstudiante;
    }

    public void setCantidadEstudiante(int cantidadEstudiante) {
        this.cantidadEstudiante = cantidadEstudiante;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
    
}
