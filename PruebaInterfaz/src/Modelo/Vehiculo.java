/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Vehiculo {
    private String placa;
    private String color;
    private String modelo;
    private String marca;
    private String cilindraje;
    private String danio;
    private Persona propietario;
    private boolean reparacion;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String modelo, String marca, String cilindraje, String danio, Persona propietario, boolean reparacion, String color) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.danio = danio;
        this.propietario = propietario;
        this.reparacion = reparacion;
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public String getDanio() {
        return danio;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public boolean isReparacion() {
        return reparacion;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public void setDanio(String danio) {
        this.danio = danio;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public void setReparacion(boolean reparacion) {
        this.reparacion = reparacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    
}
