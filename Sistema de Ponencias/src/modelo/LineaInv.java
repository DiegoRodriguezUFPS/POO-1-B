
package modelo;

/**
 *
 * @author roca
 */
public class LineaInv {
    private String nombre;
    private String proposito;

    public LineaInv() {
    }

    public LineaInv(String nombre, String proposito) {
        this.nombre = nombre;
        this.proposito = proposito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String toString(){
        return nombre;
    }
    
}
