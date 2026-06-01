package modelo;

public class PersonajeJugador extends Personaje {

    private Objeto objetoMano;
    private Objeto[] inventario;

    public PersonajeJugador() {}

    public PersonajeJugador(Objeto objetoMano) {
        this.objetoMano = objetoMano;
    }

    public Objeto getObjetoMano() { return objetoMano; }
    public void setObjetoMano(Objeto objetoMano) { this.objetoMano = objetoMano; }

    public void removeObjetoInventario() {}

    public void addObjetoInventario(Objeto objeto) {}

    public void asistirClase() {}

    public void desplazarse(Escenario escenario) {}

    public void descubrirSecretos() {}

    public void aprenderHechizo(Hechizo hechizo) {}

    public void elegirCasa(Casa casa) {}

    public void retarDuelo(Estudiante estudiante) {}

    public void interactuarCriatura(Criatura criatura) {}

    public void hablarNpc(Npc npc) {}

    public void usarObjeto(Objeto objeto) {}
}
