/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author roca
 */
public class CandidatoRepresentante extends Candidato{
    private Estudiante formula;

    public CandidatoRepresentante() {
    }

    public CandidatoRepresentante(Estudiante formula, String lema, String numTarjeta, String id, String nombres, String apellidos, String grado, String grupo, String fotoRuta) {
        super(lema, numTarjeta, id, nombres, apellidos, grado, grupo, fotoRuta);
        this.formula = formula;
    }

    

    public Estudiante getFormula() {
        return formula;
    }

    public void setFormula(Estudiante formula) {
        this.formula = formula;
    }
    
    
    
    
}
