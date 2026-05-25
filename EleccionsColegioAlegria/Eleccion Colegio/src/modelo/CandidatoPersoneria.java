/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author roca
 */
public class CandidatoPersoneria extends Candidato{
    private Mascota mascota;

    public CandidatoPersoneria() {
    }

    public CandidatoPersoneria(Mascota mascota, String lema, String numTarjeta, String id, String nombres, String apellidos, String grado, String grupo, String fotoRuta) {
        super(lema, numTarjeta, id, nombres, apellidos, grado, grupo, fotoRuta);
        this.mascota = mascota;
    }

    

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    
    
}
