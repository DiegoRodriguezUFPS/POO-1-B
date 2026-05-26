/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Lobo extends Personaje{
    
    private boolean tieneDisfraz;

    public Lobo(boolean tieneDisfraz, String id, String nombre, Estado estado, String rol) {
        super(id, nombre, estado, rol);
        this.tieneDisfraz = tieneDisfraz;
    }
    
    //getters

    public boolean isTieneDisfraz() {
        return tieneDisfraz;
    }

   

    //setters

    public void setTieneDisfraz(boolean tieneDisfraz) {
        this.tieneDisfraz = tieneDisfraz;
    }

    
    
    /////métodos del Lobo
    public String correr(){
        String correr="El lobo empieza a correr hacia donde esta la abuelita";
        return correr;
    }
    public String tragarAbuela(){
        String tragarAbue="El lobo se traga a la abuelita y aCaperucita";
        return tragarAbue;
    }
    public String tragarCaperuza(){
        String tragarCaper="El lobo se traga a la abuelita y a Caperucita";
        return tragarCaper;
    }
    public String disfrazarse(){
        String disfraz="El lobo se disfraza con la ropa de la abuela";
        return disfraz;
    }
            
    
}
