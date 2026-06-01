package modelo;

public class Hechizo {

    private String nombre;
    private String modo;
    private boolean esVerbal;
    private String codigo;

    public Hechizo() {}

    public Hechizo(String nombre, String modo, boolean esVerbal, String codigo) {
        this.nombre = nombre;
        this.modo = modo;
        this.esVerbal = esVerbal;
        this.codigo = codigo;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getModo() { return modo; }
    public void setModo(String modo) { this.modo = modo; }

    public boolean isEsVerbal() { return esVerbal; }
    public void setEsVerbal(boolean esVerbal) { this.esVerbal = esVerbal; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    @Override
    public String toString() {
        String emoji = "";
        if (modo != null) {
            switch (modo.toUpperCase()) {
                case "FUEGO": emoji = "🔥 "; break;
                case "HIELO": emoji = "❄️ "; break;
                case "AGUA":  emoji = "💧 "; break;
            }
        }
        return emoji + (nombre != null ? nombre : "Hechizo");
    }
}
