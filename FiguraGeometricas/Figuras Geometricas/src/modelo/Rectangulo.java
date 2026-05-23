/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author roca
 */
public class Rectangulo extends Figura{
    private double valorBase;
    private double valorAltura;

    public Rectangulo() {
    }

    public Rectangulo(double valorBase, double valorAltura, String nombre, double area, double perimetro) {
        super(nombre, area, perimetro);
        this.valorBase = valorBase;
        this.valorAltura = valorAltura;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getValorAltura() {
        return valorAltura;
    }

    public void setValorAltura(double valorAltura) {
        this.valorAltura = valorAltura;
    }
    
    @Override
    public void calcularArea(){
        area = valorAltura * valorBase;
    }
    
    @Override
    public void calcularPerimetro(){
        perimetro = (2 * valorBase) + (2 * valorAltura);
    }
    
    
}
