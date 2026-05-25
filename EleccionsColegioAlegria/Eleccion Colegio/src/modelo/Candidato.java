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
public class Candidato extends Estudiante{
    private String lema;
    private String numTarjeta;
    private ArrayList<Voto> listaVotos;
    private String fotoRuta;

    public Candidato() {
    }

    public Candidato(String lema, String numTarjeta, String id, String nombres, String apellidos, String grado, String grupo, String fotoRuta) {
        super(id, nombres, apellidos, grado, grupo);
        this.lema = lema;
        this.numTarjeta = numTarjeta;
        this.listaVotos = new ArrayList<>();
        this.fotoRuta = fotoRuta;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public ArrayList<Voto> getListaVotos() {
        return listaVotos;
    }
    
    public void agregarVoto(Voto voto){
        listaVotos.add(voto);
    }
    
    public int getVotosTotal(){
        int votosTotal = listaVotos.size();
        return votosTotal;
    }

    public String getFotoRuta() {
        return fotoRuta;
    }

    public void setFotoRuta(String fotoRuta) {
        this.fotoRuta = fotoRuta;
    }

    @Override
    public String toString() {
        return nombres + " (" + id + ") #Tarjeta: " + numTarjeta; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}

