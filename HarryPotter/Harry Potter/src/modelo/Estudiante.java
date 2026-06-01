package modelo;

public class Estudiante extends Npc {

    private String colorBufanda;
    private double promedio;

    public Estudiante() {}

    public Estudiante(String colorBufanda, double promedio) {
        this.colorBufanda = colorBufanda;
        this.promedio = promedio;
    }

    public String getColorBufanda() { return colorBufanda; }
    public void setColorBufanda(String colorBufanda) { this.colorBufanda = colorBufanda; }

    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }

    public void aceptarDuelo() {}
}
