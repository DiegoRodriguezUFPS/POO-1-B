package modelo;

public class Personaje {

    protected String nombre;
    protected Casa casa;
    protected int nivelMagia;
    protected String habilidades;
    protected Hechizo[] hechizos;

    public Personaje() {}

    public Personaje(String nombre, Casa casa, int nivelMagia, String habilidades) {
        this.nombre = nombre;
        this.casa = casa;
        this.nivelMagia = nivelMagia;
        this.habilidades = habilidades;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getHabilidades() { return habilidades; }
    public void setHabilidades(String habilidades) { this.habilidades = habilidades; }

    public void usarVarita() {}

    public void cambiarHechizo() {}
}
