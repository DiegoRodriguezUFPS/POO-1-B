package modelo;

public class Varita extends Objeto {

    private String tipoMadera;
    private String tipoNucleo;
    private double longitud;
    private Hechizo hechizoEquipado;

    public Varita() {}

    public Varita(String tipoMadera, String tipoNucleo, double longitud, Hechizo hechizoEquipado) {
        this.tipoMadera = tipoMadera;
        this.tipoNucleo = tipoNucleo;
        this.longitud = longitud;
        this.hechizoEquipado = hechizoEquipado;
    }

    public String getTipoMadera() { return tipoMadera; }
    public void setTipoMadera(String tipoMadera) { this.tipoMadera = tipoMadera; }

    public String getTipoNucleo() { return tipoNucleo; }
    public void setTipoNucleo(String tipoNucleo) { this.tipoNucleo = tipoNucleo; }

    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }

    public Hechizo getHechizoEquipado() { return hechizoEquipado; }
    public void setHechizoEquipado(Hechizo hechizoEquipado) { this.hechizoEquipado = hechizoEquipado; }
}
