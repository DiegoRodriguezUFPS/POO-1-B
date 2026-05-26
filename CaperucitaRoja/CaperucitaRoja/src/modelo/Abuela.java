/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Abuela extends Personaje {
    private int edad;
    private String estadoSalud;

    public Abuela(int edad, String estadoSalud, String id, String nombre, Estado estado, String rol) {
        super(id, nombre, estado, rol);
        this.edad = edad;
        this.estadoSalud = estadoSalud;
    }
    ///getters

    public int getEdad() {
        return edad;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }
    //setters

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }
    //métodos de abuelita
    public String gritar(){
        String gritar="AAAAAAAAAAAAAAAAAAAAAAAAAAAaaaaaaaa"+"\n"
                      +"NOOOOOOOOOOOOOOOOOO";
        return gritar;
    }
    
}
