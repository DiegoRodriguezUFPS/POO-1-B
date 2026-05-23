/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cuadrado;
import modelo.Rectangulo;
import modelo.Triangulo;
import modelo.TrianguloRectangulo;
import vista.JFCalculos;

/**
 *
 * @author roca
 */
public class ControladorCalculos implements ActionListener {

    JFCalculos frmCalculos;

    public ControladorCalculos() {
    }

    public ControladorCalculos(JFCalculos frmCalculos) {
        this.frmCalculos = frmCalculos;
        this.frmCalculos.comBFigura.addActionListener(this);
        this.frmCalculos.btnCalcular.addActionListener(this);
    }

    public void calcular() {
        double areaTM = 0;
        double perimetroTM = 0;
        String seleccionada = (String) frmCalculos.comBFigura.getSelectedItem();

        if (seleccionada.equals("Cuadrado")) {
            double valorLados = Double.parseDouble(frmCalculos.txtCampo1.getText());
            Cuadrado cuadradoTM = new Cuadrado(valorLados, "Cuadrado", 0, 0);
            cuadradoTM.calcularArea();
            cuadradoTM.calcularPerimetro();
            areaTM = cuadradoTM.getArea();
            perimetroTM = cuadradoTM.getPerimetro();
            frmCalculos.txtArea.setText(String.valueOf(areaTM));
            frmCalculos.txtPerimetro.setText(String.valueOf(perimetroTM));
        }
        
        if (seleccionada.equals("Rectangulo")) {
            double valorBase = Double.parseDouble(frmCalculos.txtCampo1.getText());
            double valorAltura = Double.parseDouble(frmCalculos.txtCampo2.getText());
            Rectangulo rectanguloTM = new Rectangulo(valorBase, valorAltura, "Rectangulo", 0, 0);
            rectanguloTM.calcularArea();
            rectanguloTM.calcularPerimetro();
            areaTM = rectanguloTM.getArea();
            perimetroTM = rectanguloTM.getPerimetro();
            frmCalculos.txtArea.setText(String.valueOf(areaTM));
            frmCalculos.txtPerimetro.setText(String.valueOf(perimetroTM));
        }
        
        if (seleccionada.equals("Triangulo")) {
            double valorBase = Double.parseDouble(frmCalculos.txtCampo1.getText());
            double altura = Double.parseDouble(frmCalculos.txtCampo2.getText());
            double valorLado2 = Double.parseDouble(frmCalculos.txtCampo3.getText());
            double valorLado3 = Double.parseDouble(frmCalculos.txtCampo4.getText());
            Triangulo trianguloTM = new Triangulo(valorBase, valorLado2, valorLado3, altura, "Triangulo", 0, 0);
            trianguloTM.calcularArea();
            trianguloTM.calcularPerimetro();
            areaTM = trianguloTM.getArea();
            perimetroTM = trianguloTM.getPerimetro();
            frmCalculos.txtArea.setText(String.valueOf(areaTM));
            frmCalculos.txtPerimetro.setText(String.valueOf(perimetroTM));
        }

        if (seleccionada.equals("Triangulo Rectangulo")) {
            double cateto1 = Double.parseDouble(frmCalculos.txtCampo1.getText());
            double cateto2 = Double.parseDouble(frmCalculos.txtCampo2.getText());
            TrianguloRectangulo trianguloRecTM = new TrianguloRectangulo(cateto1, 0, 0, cateto2, "Triangulo Rectangulo", 0, 0);
            trianguloRecTM.calcularHipotenusa();
            trianguloRecTM.calcularArea();
            trianguloRecTM.calcularPerimetro();
            areaTM = trianguloRecTM.getArea();
            perimetroTM = trianguloRecTM.getPerimetro();
            double hipotenusaTM = trianguloRecTM.getHipotenusa();
            frmCalculos.txtArea.setText(String.valueOf(areaTM));
            frmCalculos.txtPerimetro.setText(String.valueOf(perimetroTM));
            frmCalculos.txtHipotenusa.setText(String.valueOf(hipotenusaTM));
        }

    }

    public void cambiarSegunFigura() {
        frmCalculos.lblCampo1.setText("...");
        frmCalculos.txtCampo1.setEnabled(false);
        frmCalculos.txtCampo1.setText("");
        frmCalculos.lblCampo2.setText("...");
        frmCalculos.txtCampo2.setEnabled(false);
        frmCalculos.txtCampo2.setText("");
        frmCalculos.lblCampo3.setText("...");
        frmCalculos.txtCampo3.setEnabled(false);
        frmCalculos.txtCampo3.setText("");
        frmCalculos.lblCampo4.setText("...");
        frmCalculos.txtCampo4.setEnabled(false);
        frmCalculos.txtCampo4.setText("");
        frmCalculos.lblHipotenusa.setText("...");
        frmCalculos.txtArea.setText("0");
        frmCalculos.txtHipotenusa.setText("0");
        frmCalculos.txtPerimetro.setText("0");

        String seleccionada = (String) frmCalculos.comBFigura.getSelectedItem();

        if (seleccionada.equals("Cuadrado")) {
            frmCalculos.lblCampo1.setText("Valor de Lados:");
            frmCalculos.txtCampo1.setEnabled(true);
        }

        if (seleccionada.equals("Rectangulo")) {
            frmCalculos.lblCampo1.setText("Base:");
            frmCalculos.txtCampo1.setEnabled(true);
            frmCalculos.lblCampo2.setText("Altura:");
            frmCalculos.txtCampo2.setEnabled(true);
        }

        if (seleccionada.equals("Triangulo")) {
            frmCalculos.lblCampo1.setText("Base:");
            frmCalculos.txtCampo1.setEnabled(true);
            frmCalculos.lblCampo2.setText("Altura:");
            frmCalculos.txtCampo2.setEnabled(true);
            frmCalculos.lblCampo3.setText("Lado1:");
            frmCalculos.txtCampo3.setEnabled(true);
            frmCalculos.lblCampo4.setText("Lado2:");
            frmCalculos.txtCampo4.setEnabled(true);
        }

        if (seleccionada.equals("Triangulo Rectangulo")) {
            frmCalculos.lblCampo1.setText("Cateto 1:");
            frmCalculos.txtCampo1.setEnabled(true);
            frmCalculos.lblCampo2.setText("Cateto 2: ");
            frmCalculos.txtCampo2.setEnabled(true);
            frmCalculos.lblHipotenusa.setText("Hipotenusa:");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmCalculos.btnCalcular) {
            calcular();
        }

        if (e.getSource() == frmCalculos.comBFigura) {
            cambiarSegunFigura();
        }
    }

}
