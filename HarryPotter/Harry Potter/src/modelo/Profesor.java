package modelo;

public class Profesor extends Npc {

    private int aniosExperiencia;
    private String asignatura;
    private String especializacion;

    public Profesor() {}

    public Profesor(int aniosExperiencia, String asignatura, String especializacion) {
        this.aniosExperiencia = aniosExperiencia;
        this.asignatura = asignatura;
        this.especializacion = especializacion;
    }

    public int getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }

    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }

    public String getEspecializacion() { return especializacion; }
    public void setEspecializacion(String especializacion) { this.especializacion = especializacion; }

    public void darClase() {}
}
