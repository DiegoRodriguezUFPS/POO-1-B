/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author roca
 */
public class Prestamo {
    private String id;
    private LocalDate fechaPrestramo;
    private LocalDate fechaDebeDevolver;
    private LocalDate fechaDevolucion;
    private Usuario usuario;
    private Libro libro;
    private EstadoPrestamo estadoPrestamo;

    public Prestamo() {
    }

    public Prestamo(String id, Usuario usuario, Libro libro) {
        this.id = id;
        this.usuario = usuario;
        this.libro = libro;
        this.estadoPrestamo = EstadoPrestamo.PRESTADO;
        this.fechaPrestramo = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaPrestramo() {
        return fechaPrestramo;
    }

    public void setFechaPrestramo(LocalDate fechaPrestramo) {
        this.fechaPrestramo = fechaPrestramo;
    }

    public LocalDate getFechaDebeDevolver() {
        return fechaDebeDevolver;
    }

    public void setFechaDebeDevolver(LocalDate fechaDebeDevolver) {
        this.fechaDebeDevolver = fechaDebeDevolver;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public EstadoPrestamo getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }
    
    
    
    public double calcularMulta(){
        double multa = 0;
        if (fechaDevolucion.isAfter(fechaDebeDevolver)) {
            multa = 50000;
            long diasentre = ChronoUnit.DAYS.between(fechaDebeDevolver, fechaDevolucion);
            multa *= diasentre;
        }
        return multa;
    }
    
    
}
