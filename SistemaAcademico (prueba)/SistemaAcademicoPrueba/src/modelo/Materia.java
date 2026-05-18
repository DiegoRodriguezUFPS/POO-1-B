/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author roca
 */
public class Materia {
    private Grupo grupoEspecifico;
    private Docente docente; 
    private String horario;
    private double notaPrevio1;
    private double notaPrevio2;
    private double notaPrevio3;
    private double examenFinal;
    private double notaFinal;

    public Materia() {
    }

    public Materia(Grupo grupoEspecifico, Docente docente, String horario, double notaPrevio1, double notaPrevio2, double notaPrevio3, double examenFinal, double notaFinal) {
        this.grupoEspecifico = grupoEspecifico;
        this.docente = docente;
        this.horario = horario;
        this.notaPrevio1 = notaPrevio1;
        this.notaPrevio2 = notaPrevio2;
        this.notaPrevio3 = notaPrevio3;
        this.examenFinal = examenFinal;
        this.notaFinal = notaFinal;
    }

    public Grupo getGrupoEspecifico() {
        return grupoEspecifico;
    }

    public void setGrupoEspecifico(Grupo grupoEspecifico) {
        this.grupoEspecifico = grupoEspecifico;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getNotaPrevio1() {
        return notaPrevio1;
    }

    public void setNotaPrevio1(double notaPrevio1) {
        this.notaPrevio1 = notaPrevio1;
    }

    public double getNotaPrevio2() {
        return notaPrevio2;
    }

    public void setNotaPrevio2(double notaPrevio2) {
        this.notaPrevio2 = notaPrevio2;
    }

    public double getNotaPrevio3() {
        return notaPrevio3;
    }

    public void setNotaPrevio3(double notaPrevio3) {
        this.notaPrevio3 = notaPrevio3;
    }

    public double getExamenFinal() {
        return examenFinal;
    }

    public void setExamenFinal(double examenFinal) {
        this.examenFinal = examenFinal;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    
    
}
