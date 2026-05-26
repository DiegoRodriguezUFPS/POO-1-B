/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Lenador extends Personaje {
    private Objeto hacha;

    public Lenador(Objeto hacha, String id, String nombre, Estado estado, String rol) {
        super(id, nombre, estado, rol);
        this.hacha = hacha;
    }
    
    //getters

    public Objeto getHacha() {
        return hacha;
    }
    
    //setters

    public void setHacha(Objeto hacha) {
        this.hacha = hacha;
    }
    
    ///metodos del Leñadorrrr
    public String salvar(){
        String salva="El leñador procede a salvar a Caperucita"+"\n"
                     +"y a la Abuela";
        return salva;
    }
    public String abrirPanza(){
        String abrirPanza="El leñador abre la panza del lobo con su hacha"+"\n"
                          +"muy bien afilada";
        return abrirPanza;
    }
    public String rellenarPanza(){
        String rellenarPanza="El leñador procede a llenar la panza del lobo"+"\n"
                             +"con muchas piedras que encontró en el río";
        return rellenarPanza;
    }
}
