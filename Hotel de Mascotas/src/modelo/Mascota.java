/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Mascota {
    private String nombre;
    private String raza; 
    private String edad;
    private String necesidadesEsp;
    private Duenio duenio;

    public Mascota(String nombre, String raza, String edad, String necesidadesEsp, Duenio duenio) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.necesidadesEsp = necesidadesEsp;
        this.duenio = duenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNecesidadesEsp() {
        return necesidadesEsp;
    }

    public void setNecesidadesEsp(String necesidadesEsp) {
        this.necesidadesEsp = necesidadesEsp;
    }

    public Duenio getDuenio() {
        return duenio;
    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

    @Override
    public String toString() {
        String aaaa = nombre + " de " + duenio.getNombre();
        return aaaa; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
