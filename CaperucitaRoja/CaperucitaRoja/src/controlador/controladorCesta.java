package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.Cesta;
import modelo.Objeto;
import modelo.Tipo;
import vista.JFCesta;

public class controladorCesta implements ActionListener {
    private JFCesta frmCesta;
    private Cesta cesta;
    private ArrayList<Objeto> listaObjetosAcumulados;
    private double pesoTotalAcumulado = 0.0;

    public controladorCesta(JFCesta frmCesta) {
        this.frmCesta = frmCesta;
        this.listaObjetosAcumulados = new ArrayList<>();
        
        this.frmCesta.btnGuardar.addActionListener(this);
        
        inicializarCestaAleatoria();
    }

    private void cargarOpcionesCombos() {
        frmCesta.ComboBTipo.removeAllItems();
        for (Tipo tipo : Tipo.values()) {
            frmCesta.ComboBTipo.addItem(tipo.toString());
        }

        frmCesta.comboBPeso.removeAllItems();
        frmCesta.comboBPeso.addItem("0.5");
        frmCesta.comboBPeso.addItem("1.0");
        frmCesta.comboBPeso.addItem("1.5");
        frmCesta.comboBPeso.addItem("2.0");
        frmCesta.comboBPeso.addItem("2.5");
        frmCesta.comboBPeso.addItem("3.0");
        frmCesta.comboBPeso.addItem("4.0");
        frmCesta.comboBPeso.addItem("5.0");
    }

    private void inicializarCestaAleatoria() {
        this.listaObjetosAcumulados.clear();
        this.pesoTotalAcumulado = 0.0;
        frmCesta.btnGuardar.setEnabled(true);
        
        cargarOpcionesCombos();
        
        Double[] poolPesos = {0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 4.0, 5.0};
        ArrayList<Double> listaPool = new ArrayList<>(Arrays.asList(poolPesos));
        Collections.shuffle(listaPool); 
        
        Random random = new Random();
        int cantidadPesosAUsar = 2 + random.nextInt(4); 
        double capacidadAleatoria = 0.0;
        
        for (int indicePool = 0; indicePool < cantidadPesosAUsar; indicePool++) {
            capacidadAleatoria += listaPool.get(indicePool);
        }
        
        capacidadAleatoria = Math.round(capacidadAleatoria * 10.0) / 10.0;

        String[] materiales = {"Mimbre", "Madera", "Bambú", "Plastico"};
        String[] colores = {"Marrón", "Rojo", "Verde", "Rosa"};
        
        String materialAleatorio = materiales[random.nextInt(materiales.length)];
        String colorAleatorio = colores[random.nextInt(colores.length)];
        
        this.cesta = new Cesta(capacidadAleatoria, materialAleatorio, colorAleatorio, listaObjetosAcumulados, false);
        
        frmCesta.txtCapacidadPeso.setText(String.valueOf(cesta.getCapacidadPeso()));
        frmCesta.txtMaterial.setText(cesta.getMaterial());
        frmCesta.txtColor.setText(cesta.getColor());
        frmCesta.txtPesoTotal.setText(String.valueOf(pesoTotalAcumulado));
    }

    @Override
    public void actionPerformed(ActionEvent eventoTM) {
        if (eventoTM.getSource() == frmCesta.btnGuardar) {
            agregarAlimentoACesta();
        }
    }

    private void agregarAlimentoACesta() {
        if (frmCesta.txtId.getText().trim().isEmpty() || frmCesta.txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(frmCesta, "Por favor, llena el ID y el Nombre del alimento.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int indiceSeleccionado = frmCesta.comboBPeso.getSelectedIndex();
        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(frmCesta, "No quedan más pesos disponibles en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String idAlimento = frmCesta.txtId.getText().trim();
        String nombreAlimento = frmCesta.txtNombre.getText().trim();
        
        String tipoSeleccionado = frmCesta.ComboBTipo.getSelectedItem().toString().toUpperCase();
        Tipo tipoEnumTM = Tipo.valueOf(tipoSeleccionado);

        double pesoAlimento = Double.parseDouble(frmCesta.comboBPeso.getSelectedItem().toString());

        Objeto nuevoAlimento = new Objeto(idAlimento, nombreAlimento, tipoEnumTM, pesoAlimento);
        listaObjetosAcumulados.add(nuevoAlimento);
        
        pesoTotalAcumulado += pesoAlimento;
        pesoTotalAcumulado = Math.round(pesoTotalAcumulado * 10.0) / 10.0; 
        frmCesta.txtPesoTotal.setText(String.valueOf(pesoTotalAcumulado));

        frmCesta.comboBPeso.removeItemAt(indiceSeleccionado);

        frmCesta.txtId.setText("");
        frmCesta.txtNombre.setText("");

        comprobarEstadoDePartida();
    }

    private void comprobarEstadoDePartida() {
        double capacidadMaxima = cesta.getCapacidadPeso();

        if (pesoTotalAcumulado == capacidadMaxima) {
            cesta.setEstaLlena(true);
            frmCesta.btnGuardar.setEnabled(false);
            JOptionPane.showMessageDialog(frmCesta, "¡GANASTE! Lograste llenar la cesta con el peso exacto de " + capacidadMaxima + " kg. Caperucita irá segura.", "¡Victoria!", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (pesoTotalAcumulado > capacidadMaxima) {
            cesta.setEstaLlena(false);
            JOptionPane.showMessageDialog(frmCesta, "¡PERDISTE! Te pasaste del peso permitido (" + pesoTotalAcumulado + " kg / " + capacidadMaxima + " kg).\nSe destruirá la canasta actual y se generará una nueva.", "Partida Terminada", JOptionPane.ERROR_MESSAGE);
            inicializarCestaAleatoria();
        }
        else if (frmCesta.comboBPeso.getItemCount() == 0) {
            JOptionPane.showMessageDialog(frmCesta, "¡PERDISTE! Te quedaste sin opciones de peso y no alcanzaste el peso ideal.\nSe generará una nueva canasta.", "Partida Terminada", JOptionPane.ERROR_MESSAGE);
            inicializarCestaAleatoria();
        }
    }

    public Cesta guardarCesta() {
        this.cesta.setListaObjeto(this.listaObjetosAcumulados);
        return this.cesta;
    }
    
    public void reiniciarCesta() {
        inicializarCestaAleatoria();
    }
}