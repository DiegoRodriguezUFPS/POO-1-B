/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.JFEleccion;
import modelo.Eleccion;
import vista.JFSimulacionCrear;

/**
 *
 * @author roca
 */
public class CntrlEleccion implements ActionListener {

    private JFEleccion frmEleccion;
    private JFSimulacionCrear frmSimulacion;
    private Eleccion eleccion;

    public CntrlEleccion(JFEleccion frmEleccion, JFSimulacionCrear frmSimulacion, Eleccion eleccion) {
        this.frmEleccion = frmEleccion;
        this.frmSimulacion = frmSimulacion;
        this.eleccion = eleccion;

        this.frmEleccion.btnEmpezar.addActionListener(this);
    }

    public void empezar() {
        String anio = frmEleccion.txtAnio.getText();
        if (anio.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(frmEleccion, "Ingrese un año válido.");
        } else {
            eleccion.setAnio(anio);
            frmSimulacion.setVisible(true);
            frmEleccion.setVisible(false);

            frmEleccion.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmEleccion.btnEmpezar) {
            empezar();
        }
    }

}
