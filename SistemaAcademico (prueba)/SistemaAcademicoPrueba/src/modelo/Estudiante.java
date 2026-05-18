
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author roca
 */
public class Estudiante extends Persona {
   private Grupo grupo;

    public Estudiante() {
    }

    public Estudiante(Grupo grupo, String codigo, String nombre, String apellidos, LocalDate fechaNa, String direccion, String telefono, ArrayList<Materia> listaMaterias) {
        super(codigo, nombre, apellidos, fechaNa, direccion, telefono, listaMaterias);
        this.grupo = grupo;
    }

    

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    
   
   
}
