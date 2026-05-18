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
public class GrupodeInvestigacion {
    private String nombre; 
    private String clasificacion;
    private String institucion;
    private Director director;
    private LineaInv lineaInv;
    private ArrayList<Participante> ListaParticipantes;
    public GrupodeInvestigacion() {
    }

    public GrupodeInvestigacion(String nombre, String calificacion, Director director, LineaInv lineaInv, String institucion) {
        this.nombre = nombre;
        this.clasificacion = calificacion;
        this.director = director;
        this.lineaInv = lineaInv;
        this.institucion = institucion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalificacion() {
        return clasificacion;
    }

    public void setCalificacion(String calificacion) {
        this.clasificacion = calificacion;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public LineaInv getLineaInv() {
        return lineaInv;
    }

    public void setLineaInv(LineaInv lineaInv) {
        this.lineaInv = lineaInv;
    }

    public ArrayList<Participante> getListaParticipantes() {
        return ListaParticipantes;
    }

    public void setListaParticipantes(ArrayList<Participante> ListaParticipantes) {
        this.ListaParticipantes = ListaParticipantes;
    }
    
    @Override
    public String toString() {
    return nombre;
    }
    
}
