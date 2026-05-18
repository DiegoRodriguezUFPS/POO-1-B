/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
/**
 *
 * @author estudiante
 */
public class Cardenal {
    private Pais paisRe;
    private TipoCardenal tipoCardenal;
    private String cedula;
    private String nombre;
    private int edad;
    ArrayList<Cardenal> listaCardinal = new ArrayList<>();


    public Cardenal() {
    }

    public Cardenal(Pais paisRe, TipoCardenal tipoCardenal, String cedula, String nombre, int edad) {
        this.paisRe = paisRe;
        this.tipoCardenal = tipoCardenal;
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void RegistrarCardenal(){
      //Juanito Pedrito Satiaguito Williamsito Adriancito 
      listaCardinal.add(new Cardenal(new Pais("Colombia", "100000"), tipoCardenal.DIACONO, "876543", "Juanito", 63));
      listaCardinal.add(new Cardenal(new Pais("Venezuela", "170000"), tipoCardenal.TRESBITERO, "876543", "Pedrito", 86));
      listaCardinal.add(new Cardenal(new Pais("Argentina", "340000"), tipoCardenal.OBISPO, "876543", "Satiaguito", 23));
      listaCardinal.add(new Cardenal(new Pais("Italia", "54000"), tipoCardenal.DIACONO, "876543", "Williamsito", 12));
      listaCardinal.add(new Cardenal(new Pais("España", "103400"), tipoCardenal.OBISPO, "876543", "Adriancito", 64));
    }
    
    public boolean cardenalElector(){
        boolean sies = false;
        if (edad < 80) {
            sies = true;
        }
        return sies;
    }

    public Pais getPaisRe() {
        return paisRe;
    }

    public void setPaisRe(Pais paisRe) {
        this.paisRe = paisRe;
    }

    public TipoCardenal getTipoCardenal() {
        return tipoCardenal;
    }

    public void setTipoCardenal(TipoCardenal tipoCardenal) {
        this.tipoCardenal = tipoCardenal;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Cardenal> getListaCardinal() {
        return listaCardinal;
    }

    public void setListaCardinal(ArrayList<Cardenal> listaCardinal) {
        this.listaCardinal = listaCardinal;
    }
    
    @Override
    public String toString() {
    return nombre;
    }
    
}
