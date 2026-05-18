/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author roca
 */
public class Ponencia {
    private String titulo;
    private String descripcion;
    private Modalidad modalidad;
    private Semillero semillero;
    private Participante participantePrincipal;

    public Ponencia() {
    } 

    public Ponencia(String titulo, String descripcion, Modalidad modalidad, Participante participantePrincipal, Semillero semillero) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
        this.participantePrincipal = participantePrincipal;
        this.semillero = semillero;
    }

    public Semillero getSemillero() {
        return semillero;
    }

    public void setSemillero(Semillero semillero) {
        this.semillero = semillero;
    }
   
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return descripcion;
    }

    public void setResumen(String resumen) {
        this.descripcion = resumen;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public Participante getParticipantePrincipal() {
        return participantePrincipal;
    }

    public void setParticipantePrincipal(Participante participantePrincipal) {
        this.participantePrincipal = participantePrincipal;
    }
    
    @Override
    public String toString(){
        return titulo;
    }
}
