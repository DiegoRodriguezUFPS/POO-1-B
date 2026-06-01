package modelo;

import java.util.ArrayList;

public class Personaje {

    protected String nombre;
    protected int edad;
    protected String personalidad;
    protected String rol;
    protected ArrayList<String> dialogos;

    public Personaje() {
        this.dialogos = new ArrayList<>();
    }

    public Personaje(String nombre, int edad, String personalidad, String rol) {
        this.nombre = nombre;
        this.edad = edad;
        this.personalidad = personalidad;
        this.rol = rol;
        this.dialogos = new ArrayList<>();
    }

    // ── Diálogos ───────────────────────────────────────────────────────────

    public void agregarDialogo(String dialogo) {
        dialogos.add(dialogo);
    }

    public ArrayList<String> getDialogos() {
        return dialogos;
    }

    public void limpiarDialogos() {
        dialogos.clear();
    }

    // ── Interacción ────────────────────────────────────────────────────────

    public void interactuarPersonaje(Personaje personaje) {
        // Cada instancia define su comportamiento cargando diálogos
    }

    // ── Getters y Setters ──────────────────────────────────────────────────

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public String getRol() {
        return rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
