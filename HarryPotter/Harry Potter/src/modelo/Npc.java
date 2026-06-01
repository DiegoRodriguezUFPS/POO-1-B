package modelo;

public class Npc extends Personaje {

    private boolean tieneMision;

    public Npc() {}

    public Npc(boolean tieneMision) {
        this.tieneMision = tieneMision;
    }

    public boolean isTieneMision() { return tieneMision; }
    public void setTieneMision(boolean tieneMision) { this.tieneMision = tieneMision; }

    public void hablarConNpc(Npc npc) {}

    public void darMision() {}
}
