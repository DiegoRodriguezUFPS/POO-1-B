/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author roca
 */
public class Administrador {

    private String nombre;
    private String codigo;
    private String cargo;
    private ArrayList<Administrador> listaAdiministrador;

    public Administrador() {
    }

    public Administrador(String nombre, String codigo, String cargo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public ArrayList<Administrador> getListaAdiministrador() {
        return listaAdiministrador;
    }

    public void crearListaAdministrador() {
        listaAdiministrador = new ArrayList<>();
        listaAdiministrador.add(new Administrador("Juan", "12473", "General"));
        listaAdiministrador.add(new Administrador("Andrés", "12474", "Finanzas"));
        listaAdiministrador.add(new Administrador("Milena", "12475", "Recursos Humanos"));
        listaAdiministrador.add(new Administrador("Santiago", "12476", "Operaciones"));
        listaAdiministrador.add(new Administrador("Valentina", "12477", "General"));
    }

}
