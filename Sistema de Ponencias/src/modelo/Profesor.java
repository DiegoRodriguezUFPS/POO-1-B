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
public class Profesor extends Participante{
    private String especialidad;
    private ArrayList<Profesor> ListaProfesor;
    
    public Profesor() {
    }

    public Profesor(String especialidad, String codigo, String nombre, String institucion) {
        super(codigo, nombre, institucion);
        this.especialidad = especialidad;
    }
    

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<Profesor> getListaProfesor() {
        return ListaProfesor;
    }
    
    public void crearListaProfesor(){
       this.ListaProfesor = new ArrayList<>();
       ListaProfesor.add(new Profesor("876543", "", "Diego", "Quejeso"));
       ListaProfesor.add(new Profesor("654232", "", "Alejandro", "Quejeso"));
       ListaProfesor.add(new Profesor("237456", "", "Aguacate", "Quejeso"));
       ListaProfesor.add(new Profesor("645343", "", "Perrito", "Quejeso"));
       ListaProfesor.add(new Profesor("452356", "", "Jsjsjsj", "Quejeso"));
    }
    
    @Override
    public String toString(){
        return nombre + "(P)";
    }
    
    
}
