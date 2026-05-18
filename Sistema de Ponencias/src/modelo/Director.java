/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author roca
 */
public class Director extends Profesor{
    private String categoria;

    public Director() {
    }

    public Director(String categoria, String especialidad, String codigo, String nombre, String institucion) {
        super(especialidad, codigo, nombre, institucion);
        this.categoria = categoria;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
