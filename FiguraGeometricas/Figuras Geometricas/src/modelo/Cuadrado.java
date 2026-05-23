/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author roca
 */
public class Cuadrado extends Figura{
    private double valorLados;

    public Cuadrado() {
    }

    public Cuadrado(double valorLados, String nombre, double area, double perimetro) {
        super(nombre, area, perimetro);
        this.valorLados = valorLados;
    }

    public double getValorLados() {
        return valorLados;
    }

    public void setValorLados(double valorLados) {
        this.valorLados = valorLados;
    }
    
    @Override
    public void calcularArea(){
        area = valorLados*2;
    }
    
    @Override
    public void calcularPerimetro(){
        perimetro = 4 * valorLados;
    }
    
    
    
    
}
