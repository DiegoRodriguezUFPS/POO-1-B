/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author roca
 */
public class TrianguloRectangulo extends Triangulo{
    private double hipotenusa;
    private double cateto1;
    private double cateto2;

    public TrianguloRectangulo() {
    }

    public TrianguloRectangulo(double valorBase, double valorLado2, double valorLado3, double altura, String nombre, double area, double perimetro) {
        super(valorBase, 0, 0, altura, nombre, area, perimetro);
        this.hipotenusa = 0;
        this.cateto1 = valorBase;
        this.cateto2 = altura;
    }

    public double getHipotenusa() {
        return hipotenusa;
    }

    public void setHipotenusa(double hipotenusa) {
        this.hipotenusa = hipotenusa;
    }

    public double getCateto1() {
        return cateto1;
    }

    public void setCateto1(double cateto1) {
        this.cateto1 = cateto1;
    }

    public double getCateto2() {
        return cateto2;
    }

    public void setCateto2(double cateto2) {
        this.cateto2 = cateto2;
    }

    public void calcularHipotenusa(){
        hipotenusa = Math.sqrt((cateto1*cateto1) + (cateto2*cateto2));
    }
    
    @Override
    public void calcularArea(){
        area =  (cateto1*cateto2)/2;
    }
    
    @Override
    public void calcularPerimetro(){
        perimetro = hipotenusa + cateto1 + cateto2;
    }
    
}
