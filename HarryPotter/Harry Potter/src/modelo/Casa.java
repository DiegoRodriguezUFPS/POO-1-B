package modelo;

public class Casa {

    private String animalEmblematico;
    private String color;
    private String caracteristicas;
    private String valor;

    public Casa() {}

    public Casa(String animalEmblematico, String color, String caracteristicas, String valor) {
        this.animalEmblematico = animalEmblematico;
        this.color = color;
        this.caracteristicas = caracteristicas;
        this.valor = valor;
    }

    public String getAnimalEmblematico() { return animalEmblematico; }
    public void setAnimalEmblematico(String animalEmblematico) { this.animalEmblematico = animalEmblematico; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getCaracteristicas() { return caracteristicas; }
    public void setCaracteristicas(String caracteristicas) { this.caracteristicas = caracteristicas; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }
}
