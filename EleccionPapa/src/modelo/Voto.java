/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author estudiante
 */
public class Voto {
    Ronda ronda;
    Cardenal cardenal;

    public Voto() {
    }

    public Voto(Ronda ronda, Cardenal cardinal) {
        this.ronda = ronda;
        this.cardenal = cardinal;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public Cardenal getCardenal() {
        return cardenal;
    }

    public void setCardenal(Cardenal cardinal) {
        this.cardenal = cardinal;
    }
    
}
