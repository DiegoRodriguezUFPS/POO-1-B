/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import modelo.TipoUsuario;
import modelo.Usuario;
import vista.JFUsuario;

/**
 *
 * @author roca
 */
public class CntrlUsuario implements ActionListener {

    public JFUsuario frmUsuario;
    private ArrayList<Usuario> listaUsuario;
    private CntrlPrestamo cntrlPrestamo;
    public CntrlDevolucion cntrlDevolucion;

    public CntrlUsuario() {
    }

    public CntrlUsuario(JFUsuario frmUsuario, ArrayList<Usuario> listaUsuario) {
        this.frmUsuario = frmUsuario;
        this.listaUsuario = listaUsuario;

        this.frmUsuario.btnGuardar.addActionListener(this);
    }

    public void guardar() {
        Timer tiempo = new Timer(3000, e -> {frmUsuario.lblMostrar.setText("...");});
        tiempo.setRepeats(false);
        
        String id = frmUsuario.txtIdentificacion.getText();
        boolean siEsta = false;
        for (Usuario usuario : listaUsuario) {
            if (id.equals(usuario.getId())) {
                siEsta = true;
                break;
            }
        }
        if (!siEsta) {
            String nombre = frmUsuario.txtNombre.getText();
            if (!nombre.equals("") && !id.equals("")) {
                String tipo = (String) frmUsuario.comBTipoJUsu.getSelectedItem();
                TipoUsuario tipoUsuarioTM = null;
                switch (tipo) {
                    case "Administrativo":
                        tipoUsuarioTM = tipoUsuarioTM.ADMINISTRATIVO;
                        break;
                    case "Profesor":
                        tipoUsuarioTM = tipoUsuarioTM.PROFESOR;
                        break;
                    case "Estudiante":
                        tipoUsuarioTM = tipoUsuarioTM.ESTUDIANTE;
                        break;
                    default:
                        throw new AssertionError();
                }
                Usuario usuarioTM = new Usuario(id, nombre, tipoUsuarioTM);
                listaUsuario.add(usuarioTM);
                frmUsuario.lblMostrar.setText("Se guardó correctamente!!!");
                tiempo.start();
                cntrlPrestamo.refrescarListaUsuario();
                cntrlDevolucion.refrescarListaUsuario();
            } else {
                frmUsuario.lblMostrar.setText("Rellen todos los datos, plis");
                tiempo.start();
            }

        } else {
            frmUsuario.lblMostrar.setText("Ya existe alguien con esa identificación");
            tiempo.start();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmUsuario.btnGuardar) {
            guardar();
        }
    }

    public CntrlPrestamo getCntrlPrestamo() {
        return cntrlPrestamo;
    }

    public void setCntrlPrestamo(CntrlPrestamo cntrlPrestamo) {
        this.cntrlPrestamo = cntrlPrestamo;
    }

    public CntrlDevolucion getCntrlDevolucion() {
        return cntrlDevolucion;
    }

    public void setCntrlDevolucion(CntrlDevolucion cntrlDevolucion) {
        this.cntrlDevolucion = cntrlDevolucion;
    }
    
    

    
    
}
