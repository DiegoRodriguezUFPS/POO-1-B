/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Habilidad {
    
    private String id;
    private String nombre;
    private TipoHabilidad tipoHabilidad;
    private String descripcion;
    private int PuntosUsarlo;

    public Habilidad() {
    }

    public Habilidad(String id, String nombre, TipoHabilidad tipoHabilidad, String descripcion,int puntosUsuarlo) {
        this.id = id;
        this.nombre = nombre;
        this.tipoHabilidad = tipoHabilidad;
        this.descripcion = descripcion;
        this.PuntosUsarlo = puntosUsuarlo;
    }

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

    public TipoHabilidad getTipoHabilidad() {
        return tipoHabilidad;
    }

    public void setTipoHabilidad(TipoHabilidad tipoHabilidad) {
        this.tipoHabilidad = tipoHabilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntosUsarlo() {
        return PuntosUsarlo;
    }

    public void setPuntosUsarlo(int PuntosUsarlo) {
        this.PuntosUsarlo = PuntosUsarlo;
    }
    
    
    
}
