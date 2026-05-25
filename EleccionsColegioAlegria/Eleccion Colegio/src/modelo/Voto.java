/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author roca
 */
public class Voto {
    private Estudiante votante;
    private Candidato candidato;
    private boolean esNulo;

    public Voto() {
    }

    public Voto(Estudiante votante, Candidato candidato) {
        this.votante = votante;
        this.candidato = candidato;
        this.esNulo = false;
    }

    public Estudiante getVotante() {
        return votante;
    }

    public void setVotante(Estudiante votante) {
        this.votante = votante;
    }

    public boolean isEsNulo() {
        return esNulo;
    }

    public void setEsNulo(boolean esNulo) {
        this.esNulo = esNulo;
    }
    
    
    
}
