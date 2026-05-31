package modelo;

public class Jugador {
    private String nombre;
    private String id;
    private int edad;

    public Jugador() {}

    public Jugador(String nombre, String id, int edad) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public int getEdad() { return edad; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setId(String id) { this.id = id; }
    public void setEdad(int edad) { this.edad = edad; }

    public void controlarPersonaje() {}
}
