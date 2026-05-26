/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Bosque extends Escenario {
    
    private Arbol arbol;

    public Bosque(Arbol arbol, String nombre, double ancho, double altura) {
        super(nombre, ancho, altura);
        this.arbol = arbol;
    }
    
    //getters

    public Arbol getArbol() {
        return arbol;
    }
    
    //setters

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }
    
    
}
