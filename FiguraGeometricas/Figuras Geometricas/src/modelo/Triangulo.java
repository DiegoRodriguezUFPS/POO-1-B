/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author roca
 */
public class Triangulo extends Figura{
    protected double valorBase;
    private double valorLado2;
    private double valorLado3;
    private double altura;

    public Triangulo() {
        
    }

    public Triangulo(double valorBase, double valorLado2, double valorLado3, double altura, String nombre, double area, double perimetro) {
        super(nombre, area, perimetro);
        this.valorBase = valorBase;
        this.valorLado2 = valorLado2;
        this.valorLado3 = valorLado3;
        this.altura = altura;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getValorLado2() {
        return valorLado2;
    }

    public void setValorLado2(double valorLado2) {
        this.valorLado2 = valorLado2;
    }

    public double getValorLado3() {
        return valorLado3;
    }

    public void setValorLado3(double valorLado3) {
        this.valorLado3 = valorLado3;
    }
    
    @Override
    public void calcularArea(){
        area = (valorBase*altura)/2;
    }
    
    @Override
    public void calcularPerimetro(){
        perimetro = valorBase + valorLado2 + valorLado3;
    }
    

    
}
