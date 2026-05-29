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
public class Proyecto {
    private String id;
    private TipoProyecto tipoProyecto;
    private String nombre;
    private ArrayList<Producto> listaProducto;

    public Proyecto() {
    }

    public Proyecto(String id, TipoProyecto tipoProyecto, String nombre) {
        this.id = id;
        this.tipoProyecto = tipoProyecto;
        this.nombre = nombre;
        this.listaProducto = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setTipoProyecto(TipoProyecto tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public TipoProyecto getTipoProyecto() {
        return tipoProyecto;
    }
    
    public void agregarProducto(Producto producto){
        listaProducto.add(producto);
    }

    @Override
    public String toString() {
        return nombre; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
