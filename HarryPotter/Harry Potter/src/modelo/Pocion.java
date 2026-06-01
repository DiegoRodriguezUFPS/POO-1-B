package modelo;

public class Pocion extends Objeto {

    private String efecto;
    private double duracionEfecto;

    public Pocion() {}

    public Pocion(String nombre, double duracionEfecto) {
        this.nombre = nombre;
        this.efecto = nombre;
        this.duracionEfecto = duracionEfecto;
    }

    public String getEfecto() { return efecto; }
    public void setEfecto(String efecto) { this.efecto = efecto; }

    public double getDuracionEfecto() { return duracionEfecto; }
    public void setDuracionEfecto(double duracionEfecto) { this.duracionEfecto = duracionEfecto; }

    @Override
    public String toString() {
        return nombre != null ? nombre : "Poción";
    }
}
