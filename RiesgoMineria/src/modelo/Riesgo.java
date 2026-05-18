/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Riesgo {
    private String codigo;
    private String descripcion;
    private String tipo;
    private int nivelPeligro;

    public Riesgo() {
    }

    public Riesgo(String codigo, String descripcion, String tipo, int nivelPeligro) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.nivelPeligro = nivelPeligro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivelPeligro() {
        return nivelPeligro;
    }

    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }
    
    
}
