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
public class Libro {

    private String titulo;
    private String autor;
    private String isnn;
    private TipoLibro tipoLibro;
    private int canCopiasExisten;
    private int canCopiasHay;
    private String anioPublicacion;
    private String editorial;
    private ArrayList<Libro> listaLibros;

    public Libro() {
    }

    public Libro(String Libro, String autor, String isnn, TipoLibro tipoLibro, int canCopiasExisten, String anioPublicacion, String editorial) {
        this.titulo = Libro;
        this.autor = autor;
        this.isnn = isnn;
        this.tipoLibro = tipoLibro;
        this.canCopiasExisten = canCopiasExisten;
        this.canCopiasHay = this.canCopiasExisten;
        this.anioPublicacion = anioPublicacion;
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsnn() {
        return isnn;
    }

    public void setIsnn(String isnn) {
        this.isnn = isnn;
    }

    public TipoLibro getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(TipoLibro tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    public int getCanCopiasExisten() {
        return canCopiasExisten;
    }

    public void setCanCopiasExisten(int canCopiasExisten) {
        this.canCopiasExisten = canCopiasExisten;
    }

    public int getCanCopiasHay() {
        return canCopiasHay;
    }

    public void setCanCopiasHay(int canCopiasHay) {
        this.canCopiasHay = canCopiasHay;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public void crearListaLibros() {
        listaLibros = new ArrayList<>();
        listaLibros.add(new Libro(
                "Fisica 2",
                "Juan Mont. ",
                "123",
                TipoLibro.COLECCION_GENERAL,
                3,
                "2020",
                "Norma"
        ));
        listaLibros.add(new Libro(
                "POO",
                "Carlos Mendoza",
                "84291357",
                TipoLibro.COLECCION_GENERAL,
                5,
                "2018",
                "McGraw Hill"
        ));

        listaLibros.add(new Libro(
                "Enciclopedia de Biologia",
                "Laura Ramirez",
                "73519284",
                TipoLibro.REFERENCIA,
                2,
                "2015",
                "Santillana"
        ));

        listaLibros.add(new Libro(
                "Fisica Universitaria",
                "Roberto Salazar",
                "61829473",
                TipoLibro.COLECCION_GENERAL,
                3,
                "2020",
                "Pearson"
        ));

        listaLibros.add(new Libro(
                "Atlas Mundial Moderno",
                "Andrea Gutierrez",
                "49281736",
                TipoLibro.REFERENCIA,
                2,
                "2022",
                "Norma"
        ));
    }

    @Override
    public String toString() {
        if (canCopiasHay == 0) {
            return titulo + " / " + autor;
        } else {
            return titulo + " / " + autor + " / (" + canCopiasHay + ")";
        }
    }

}
