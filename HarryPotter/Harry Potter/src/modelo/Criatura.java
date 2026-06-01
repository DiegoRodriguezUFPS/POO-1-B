package modelo;

public class Criatura {

    private String raza;
    private String nombre;
    private String tipoMagia;

    public Criatura() {}

    public Criatura(String raza, String nombre, String tipoMagia) {
        this.raza = raza;
        this.nombre = nombre;
        this.tipoMagia = tipoMagia;
    }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipoMagia() { return tipoMagia; }
    public void setTipoMagia(String tipoMagia) { this.tipoMagia = tipoMagia; }

    public void usarHechizo(Hechizo hechizo) {}
}
