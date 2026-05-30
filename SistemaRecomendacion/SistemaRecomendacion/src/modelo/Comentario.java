package modelo;

public class Comentario {

    private String id;
    private String enunciado;
    private double calificacion;
    private Usuario usuario;

    public Comentario() {
    }

    public Comentario(String id, String enunciado, double calificacion, Usuario usuario) {
        this.id = id;
        this.enunciado = enunciado;
        this.calificacion = calificacion;
        this.usuario = usuario;
    }

    // Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
