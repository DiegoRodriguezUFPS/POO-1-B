package modelo;

public class Jugador {

    private String id;
    private String nombre;
    private int edad;

    public Jugador() {
    }

    public Jugador(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    // ── Interacción con objetos del mundo ──────────────────────────────────

    public void interactuarObjeto(Objeto objeto) {
        // El jugador interactúa con un objeto; retorna su descripción
        System.out.println(nombre + " interactúa con: " + objeto.getNombre()
                + " - " + objeto.getDescripcion());
    }

    // ── Getters y Setters ──────────────────────────────────────────────────

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
