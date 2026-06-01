package modelo;

public class Vecindad {

    private String nombre;
    private String descripcion;
    private String fotoRuta;

    public Vecindad() {
    }

    public Vecindad(String nombre, String descripcion, String fotoRuta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoRuta = fotoRuta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoRuta() {
        return fotoRuta;
    }

    public void setFotoRuta(String fotoRuta) {
        this.fotoRuta = fotoRuta;
    }
    
    
}
