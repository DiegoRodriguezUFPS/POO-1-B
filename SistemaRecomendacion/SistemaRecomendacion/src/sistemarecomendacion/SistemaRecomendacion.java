/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemarecomendacion;

import controlador.CntrlRecomendador;
import controlador.CntrlRegistrarUsuario;
import java.util.ArrayList;
import modelo.Usuario;
import vista.JFComentario;
import vista.JFRecomendador;
import vista.JFRegistrarUsuario;
import vista.JFVerComentarios;

/**
 *
 * @author roca
 */
public class SistemaRecomendacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        JFRegistrarUsuario frmRegistrarUsuario = new JFRegistrarUsuario();
        JFRecomendador frmRecomendador = new JFRecomendador();
        JFComentario frmComentario = new JFComentario();
        JFVerComentarios frmVerComentarios = new JFVerComentarios();

        CntrlRecomendador cntrlRecomendador = new CntrlRecomendador(frmRecomendador, frmComentario, frmVerComentarios, frmRegistrarUsuario, listaUsuario);
        CntrlRegistrarUsuario cntrlRegistrarUsuario = new CntrlRegistrarUsuario(frmRegistrarUsuario, frmRecomendador, listaUsuario, cntrlRecomendador);

        frmRegistrarUsuario.setVisible(true);

    }

}
