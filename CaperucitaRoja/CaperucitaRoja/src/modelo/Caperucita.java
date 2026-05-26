/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Caperucita extends Personaje {
    
private Cesta cesta;

    public Caperucita(Cesta cesta, String id, String nombre, Estado estado, String rol) {
        super(id, nombre, estado, rol);
        this.cesta = cesta;
    }
    
    
    ///getters

    public Cesta getCesta() {
        return cesta;
    }
    
    /// setters

    public void setCesta(Cesta cesta) {
        this.cesta = cesta;
    }
    /////////metodos de Caperucita
    public String cantar(){
       String texto="Caperucita canta: Los pollitos dicen: PIO PIO PIOOO";
       return texto;
    }
}
