/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

public class Cesta {
private double capacidadPeso;
private String material;
private String color;
private ArrayList<Objeto> ListaObjeto;
private boolean estaLlena;

    public Cesta(double capacidadPeso, String material, String color,ArrayList<Objeto> ListaObjeto, boolean estaLlena) {
        this.capacidadPeso = capacidadPeso;
        this.material = material;
        this.color = color;
        this.ListaObjeto = ListaObjeto;
        this.estaLlena = estaLlena;
    }

    public double getCapacidadPeso() {
        return capacidadPeso;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    

    public ArrayList<Objeto> getListaObjeto() {
        return ListaObjeto;
    }

    public boolean isEstaLlena() {
        return estaLlena;
    }

    //setters

    public void setCapacidadPeso(double capacidadPeso) {
        this.capacidadPeso = capacidadPeso;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setListaObjeto(ArrayList<Objeto> ListaObjeto) {
        this.ListaObjeto = ListaObjeto;
    }

    public void setEstaLlena(boolean estaLlena) {
        this.estaLlena = estaLlena;
    }
    
    

   
    //métodos de Cesta
    
    public void verificarEstado(){
        double pesoObjetos=0.0;
        for(Objeto e: ListaObjeto){
            pesoObjetos+=e.getPeso();
        }
            
     if(capacidadPeso<pesoObjetos){
         System.out.println("No cabe en la canasta");}
     else if(capacidadPeso==pesoObjetos){
         System.out.println("La canasta esta llena");}
     else{
          System.out.println("La canasta no esta llena");}
}
    
}
    

