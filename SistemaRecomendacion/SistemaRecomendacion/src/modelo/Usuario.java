package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String id;
    private String nombre;
    private List<String> listaPreferencias;
    private List<Pelicula> peliculasVistas;

    public Usuario() {
    }

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaPreferencias = new ArrayList<>();
        this.peliculasVistas = new ArrayList<>();
    }

    

    // Getters & Setters

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

    public List<String> getListaPreferencias() {
        return listaPreferencias;
    }

    public void agregarPreferencia(String preferencia){
        listaPreferencias.add(preferencia);
    }

    public List<Pelicula> getPeliculasVistas() {
        return peliculasVistas;
    }

    public void agregarPeliculaVista(Pelicula pelicula) {
        peliculasVistas.add(pelicula);
    }

    public Comentario comentarPelicula(Pelicula pelicula, String contenido) {
        return null;
    }

    @Override
    public String toString() {
        return nombre; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
