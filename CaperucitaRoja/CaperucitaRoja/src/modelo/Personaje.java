
package modelo;
public class Personaje {
     protected String id;
     protected String nombre;
     protected Estado estado;
     protected String rol;

    public Personaje(String id, String nombre, Estado estado, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.rol = rol;
    }
     
     //GETTERS

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getRol() {
        return rol;
    }
    
    //SETTERS

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    ///////////////////////////////Métodos
    public void moverse(){
        
    }
    public void hablar(){
        
    }
}
