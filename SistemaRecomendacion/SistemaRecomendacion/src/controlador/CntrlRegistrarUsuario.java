/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import vista.*;
import modelo.*;

/**
 *
 * @author roca
 */
public class CntrlRegistrarUsuario implements ActionListener {

    JFRegistrarUsuario frmRegistrarUsuario;
    JFRecomendador frmRecomendador;
    ArrayList<Usuario> listaUsuario;
    CntrlRecomendador cntrlRecomendador;

    public CntrlRegistrarUsuario(JFRegistrarUsuario frmRegistrarUsuario, JFRecomendador frmRecomendador, ArrayList<Usuario> listaUsuario, CntrlRecomendador cntrlRecomendador) {
        this.frmRegistrarUsuario = frmRegistrarUsuario;
        this.frmRecomendador = frmRecomendador;
        this.listaUsuario = listaUsuario;
        this.cntrlRecomendador = cntrlRecomendador;

        this.frmRegistrarUsuario.btnGuardar.addActionListener(this);
    }

    public void guardarUsuario() {
        String id = frmRegistrarUsuario.txtId.getText().trim();
        String nombre = frmRegistrarUsuario.txtNombre.getText().trim();

        if (id.isEmpty() || nombre.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(frmRegistrarUsuario,
                    "Rellene todos los datos, porfavor",
                    "Campos Incompletos",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;

        }

        if (!frmRegistrarUsuario.jRadioAccion.isSelected()
                && !frmRegistrarUsuario.jRadioComedia.isSelected()
                && !frmRegistrarUsuario.jRadioMusical.isSelected()
                && !frmRegistrarUsuario.jRadioRomance.isSelected()
                && !frmRegistrarUsuario.jRadioScieFi.isSelected()
                && !frmRegistrarUsuario.jRadioTerror.isSelected()) {

            javax.swing.JOptionPane.showMessageDialog(frmRegistrarUsuario,
                    "Debes seleccionar por lo menos un género de película.",
                    "Faltan Preferencias",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        Usuario usuarioTM = new Usuario(id, nombre);

        if (frmRegistrarUsuario.jRadioAccion.isSelected()) {
            usuarioTM.agregarPreferencia("Accion");
        }
        if (frmRegistrarUsuario.jRadioComedia.isSelected()) {
            usuarioTM.agregarPreferencia("Comedia");
        }
        if (frmRegistrarUsuario.jRadioMusical.isSelected()) {
            usuarioTM.agregarPreferencia("Musical");
        }
        if (frmRegistrarUsuario.jRadioRomance.isSelected()) {
            usuarioTM.agregarPreferencia("Romance");
        }
        if (frmRegistrarUsuario.jRadioScieFi.isSelected()) {
            usuarioTM.agregarPreferencia("Scie-Fi");
        }
        if (frmRegistrarUsuario.jRadioTerror.isSelected()) {
            usuarioTM.agregarPreferencia("Terror");
        }

        listaUsuario.add(usuarioTM);

        javax.swing.JOptionPane.showMessageDialog(frmRegistrarUsuario,
                "Usuario registrado",
                "Éxito",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);

        cntrlRecomendador.RecomendarPeliculas();
        frmRegistrarUsuario.setVisible(false);
        frmRecomendador.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmRegistrarUsuario.btnGuardar) {
            guardarUsuario();
        }
    }

}
