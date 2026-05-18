/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author roca
 */
public class Reserva {
    LocalDate fechaIngreso;
    LocalDate fechaIda;
    int duracionEstadia;
    String serviciosAdicionales;
    Cuidador cuidador;
    Mascota mascota;

    public Reserva() {
    }

    
    public Reserva(int duracionEstadia, String serviciosAdicionales, Cuidador cuidador, Mascota mascota) {
        this.fechaIngreso = LocalDate.now();
        this.duracionEstadia = duracionEstadia;
        this.serviciosAdicionales = serviciosAdicionales;
        this.cuidador = cuidador;
        this.mascota = mascota;
        
        this.fechaIda = this.fechaIngreso.plusDays(this.duracionEstadia);
                
        
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaIda() {
        return fechaIda;
    }

    public void setFechaIda(LocalDate fechaIda) {
        this.fechaIda = fechaIda;
    }

    public Cuidador getCuidador() {
        return cuidador;
    }

    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    
    
    public int getDuracionEstadia() {
        return duracionEstadia;
    }

    public void setDuracionEstadia(int duracionEstadia) {
        this.duracionEstadia = duracionEstadia;
    }
    
    public String getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public void setServiciosAdicionales(String serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }
    
    public String obtenerFechaIda(){
        String fechaIdaTM = this.fechaIda.toString();
        return fechaIdaTM;
    }
    
    
}
