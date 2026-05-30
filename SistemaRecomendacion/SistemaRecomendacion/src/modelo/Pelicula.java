package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {

    private String titulo;
    private String genero;
    private int anio;
    private String director;
    private double clasificacionPromedio;
    private String duracion;
    private List<Comentario> listaComentarios;
    private String fotoRuta;

    public Pelicula() {
    }

    public Pelicula(String titulo, String genero, int anio, String director,
            double clasificacionPromedio, String duracion, String fotoRuta) {
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.director = director;
        this.clasificacionPromedio = clasificacionPromedio;
        this.duracion = duracion;
        this.listaComentarios = new ArrayList<>();
        this.fotoRuta = fotoRuta;
    }

    // Getters & Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int año) {
        this.anio = año;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getClasificacionPromedio() {
        return clasificacionPromedio;
    }

    public double calcularCalificacionPromedio() {
        if (listaComentarios.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Comentario c : listaComentarios) {
            suma += c.getCalificacion();
        }
        return suma / listaComentarios.size();
    }

    public void setClasificacionPromedio(double clasificacionPromedio) {
        this.clasificacionPromedio = clasificacionPromedio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public String getFotoRuta() {
        return fotoRuta;
    }

    public void setFotoRuta(String fotoRuta) {
        this.fotoRuta = fotoRuta;
    }

    // Métodos extra
    public void agregarComentario(Comentario comentario) {
        listaComentarios.add(comentario);
    }
}
