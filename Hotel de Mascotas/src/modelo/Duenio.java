
package modelo;

import java.util.ArrayList;

/**
 *
 * @author roca
 */
public class Duenio {
    private String nombre;
    private String identifiacion;
    private ArrayList<Mascota> ListaMascotas;

    public Duenio() {
    }

    
    
    public Duenio(String nombre, String identifiacion) {
        this.nombre = nombre;
        this.identifiacion = identifiacion;
        this.ListaMascotas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentifiacion() {
        return identifiacion;
    }

    public void setIdentifiacion(String identifiacion) {
        this.identifiacion = identifiacion;
    }

    public ArrayList<Mascota> getListaMascotas() {
        return ListaMascotas;
    }

    public void addMascota(Mascota mascota){
        ListaMascotas.add(mascota);
    }

    
    @Override
    public String toString() {
        return nombre;
    }
    
    
    
    
}
