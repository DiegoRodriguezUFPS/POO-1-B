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
public class Eleccion {

    private String anio;
    private ArrayList<Voto> listaVotos;
    private ArrayList<Candidato> listaCandidato;

    public Eleccion() {
        this.listaVotos = new ArrayList<>();
        this.listaCandidato = new ArrayList<>();
    }

    public Eleccion(ArrayList<Candidato> listaCandidato) {
        this.listaVotos = new ArrayList<>();
        this.listaCandidato = listaCandidato;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public ArrayList<Voto> getListaVotos() {
        return listaVotos;
    }

    public ArrayList<Candidato> getListaCandidato() {
        return listaCandidato;
    }

    public void agregarCandidato(Candidato candidato) {
        listaCandidato.add(candidato);
    }

    public void agregarVoto(Voto voto) {
        listaVotos.add(voto);
    }

    public int getPoblacionElectoral() {
        int poblacionElectoral = listaVotos.size();
        return poblacionElectoral;
    }

    public Candidato getCandidatoPersoneriaElegido() {
        Candidato PersoneroElegido = new Candidato();
        int votosMayor = 0;
        for (Candidato candidato : listaCandidato) {
            if (candidato instanceof CandidatoPersoneria) {
                int cantidadVotos = candidato.getVotosTotal();
                if (cantidadVotos > votosMayor) {
                    PersoneroElegido = candidato;
                    votosMayor = cantidadVotos;
                }
            }
        }
        return PersoneroElegido;
    }

    public Candidato getCandidatoRepresentanteElegido(String grado) {
        CandidatoRepresentante RepresentanteEscogido = new CandidatoRepresentante();
        int votosMayor = 0;
        for (Candidato candidato : listaCandidato) {
            if (candidato instanceof CandidatoRepresentante) {
                if (candidato.getGrado().equals(grado)) {
                    int cantidadVotos = candidato.getVotosTotal();
                    if (cantidadVotos > votosMayor) {
                        RepresentanteEscogido = (CandidatoRepresentante) candidato;
                        votosMayor = cantidadVotos;
                    }
                }
            }
        }
        return RepresentanteEscogido;
    }

    public Candidato getPersoneroMenosVotos() {
        Candidato PersoneroMenosVotos = new Candidato();
        int votosMenor = Integer.MAX_VALUE;
        for (Candidato candidato : listaCandidato) {
            if (candidato instanceof CandidatoPersoneria) {
                int cantidadVotos = candidato.getVotosTotal();
                if (cantidadVotos < votosMenor) {
                    PersoneroMenosVotos = candidato;
                    votosMenor = cantidadVotos;
                }
            }
        }
        return PersoneroMenosVotos;
    }

    public CandidatoRepresentante getRepresentanteMenosVotos(String grado) {
        CandidatoRepresentante RepresentanteMenosVotos = new CandidatoRepresentante();
        int votosMenor = Integer.MAX_VALUE;
        for (Candidato candidato : listaCandidato) {
            if (candidato instanceof CandidatoRepresentante) {
                if (candidato.getGrado().equals(grado)) {
                    int cantidadVotos = candidato.getVotosTotal();
                    if (cantidadVotos < votosMenor) {
                        RepresentanteMenosVotos = (CandidatoRepresentante) candidato;
                        votosMenor = cantidadVotos;
                    }
                }
            }
        }
        return RepresentanteMenosVotos;
    }

    public int getVotosNulos() {
        int votosNulos = 0;
        for (Voto voto : listaVotos) {
            if (voto.isEsNulo()) {
                votosNulos++;
            }
        }

        return votosNulos;
    }

}
