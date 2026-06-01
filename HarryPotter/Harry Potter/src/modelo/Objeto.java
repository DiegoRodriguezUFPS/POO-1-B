package modelo;

public class Objeto {

    protected String nombre;
    protected String codigo;
    protected int cantidadUsos;

    public Objeto() {}

    public Objeto(String nombre, String codigo, int cantidadUsos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidadUsos = cantidadUsos;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCantidadUsos() { return cantidadUsos; }
    public void setCantidadUsos(int cantidadUsos) { this.cantidadUsos = cantidadUsos; }

    public void usar() {}
}
