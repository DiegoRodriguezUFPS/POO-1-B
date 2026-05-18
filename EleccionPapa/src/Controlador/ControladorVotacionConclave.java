/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.JFVotacion;
import modelo.Voto;
import java.util.ArrayList;
import modelo.Cardenal;
import modelo.Jornada;
import modelo.Ronda;

/**
 *
 * @author estudiante
 */
public class ControladorVotacionConclave implements ActionListener{
    private JFVotacion frmVotacion;
    private ArrayList<Voto> ListaVotos;
    private ArrayList<Cardenal> ListaCardenal;
    private Jornada jornada ;


    public ControladorVotacionConclave() {
    }

    public ControladorVotacionConclave(JFVotacion frmVotacion, ArrayList<Cardenal> ListaCardenal) {
        this.frmVotacion = frmVotacion;
        this.ListaCardenal = ListaCardenal;
        this.ListaVotos = new ArrayList<>();
        this.jornada = Jornada.MAÑANA;
        
        frmVotacion.btnMostrarResultados.addActionListener(this);
        frmVotacion.btnSiguienteR.addActionListener(this);
        frmVotacion.btnVotar.addActionListener(this);
        
        frmVotacion.btnSiguienteR.setEnabled(false);
        
        for (Cardenal cardenal : ListaCardenal) {
            frmVotacion.txtCListaCardinales.addItem(cardenal);
        }
    }
    
    public void Siguiente(){
            frmVotacion.btnSiguienteR.setEnabled(false);
            frmVotacion.btnMostrarResultados.setEnabled(true);
            frmVotacion.btnVotar.setEnabled(true);
            int noRondas = Integer.parseInt(frmVotacion.txtNoRondas.getText()) + 1;
            
            if (noRondas <= 2) {
                jornada = Jornada.MAÑANA;
            }
            else {
                jornada = Jornada.TARDE;
            }
            
            String noRondasTM = Integer.toString(noRondas);
            frmVotacion.txtNoRondas.setText(noRondasTM);
            frmVotacion.txtAResultados.setText("");
            
            if (noRondas == 5) {
                javax.swing.JOptionPane.showMessageDialog(frmVotacion, "Se acabo el dia");
                frmVotacion.txtNoRondas.setText("1");        
            }    
    }
    
    
    public void Votar(){
 
        Cardenal cardinalTM = (Cardenal) frmVotacion.txtCListaCardinales.getSelectedItem();
        int noRondas = Integer.parseInt(frmVotacion.txtNoRondas.getText());
        Voto VotoTM = new Voto(new Ronda(Integer.parseInt(frmVotacion.txtNoRondas.getText()), jornada, 0), cardinalTM);
        ListaVotos.add(VotoTM);
        
        boolean huboganador = false;
        Cardenal cardenalMayor = null;

            if (ListaVotos.size() == 20 ) {
                int index = -1;
                for (Cardenal cardenalsa : ListaCardenal) {
                    int contador = 0;
                    for (Voto voto : ListaVotos) {
                        if(voto.getCardenal().equals(cardenalsa)){
                            contador++;
                            huboganador = true;
                        }
                        if(contador == 20){
                            index = ListaCardenal.indexOf(cardenalsa);
                            break;
                        }
                    }
                    
                }
               if (huboganador && index > -1) {
                   cardenalMayor = ListaCardenal.get(index);
                   frmVotacion.txtAResultados.setText("");
                   frmVotacion.txtAResultados.append("¡¡Hay nuevo Papa!! \n");
                   frmVotacion.txtAResultados.append("El cardenal "+ cardenalMayor.getNombre() + " que representa al pais "+ 
                           cardenalMayor.getPaisRe().getNombre() + " con " + cardenalMayor.getEdad() + " años,\n" + "fue elegido como el Papa"
                                   + " en la ronda "+ noRondas + " en la jornada de la "+ jornada.name());
                frmVotacion.btnSiguienteR.setEnabled(false);
                frmVotacion.btnMostrarResultados.setEnabled(false);
                frmVotacion.btnVotar.setEnabled(false);

               }
               else {
                   frmVotacion.btnSiguienteR.setEnabled(true);
                   frmVotacion.txtAResultados.setText("Todavía no han elegido a un Papa \n");
                   for (Cardenal cardenal : ListaCardenal) { 
                       int contador = 0;
                       for (Voto voto : ListaVotos) {
                        if (voto.getCardenal().equals(cardenal)) {
                            contador++;
                        }
                    }
                        frmVotacion.txtAResultados.append("Votos totales de "+ cardenal.getNombre() + ": " + contador + "\n");
                    }
                   ListaVotos.clear();
                   frmVotacion.btnMostrarResultados.setEnabled(false);
                   frmVotacion.btnVotar.setEnabled(false);
               }
            }
        
    }
    
    public void Mostrar(){
        frmVotacion.txtAResultados.setText("");
        
        for (Voto voto : ListaVotos) {
            if(voto.getRonda().getNumRonda() == Integer.parseInt(frmVotacion.txtNoRondas.getText())) {
               frmVotacion.txtAResultados.append(ListaVotos.indexOf(voto)+1 + " | " + voto.getCardenal().getNombre()+ "\n");    
            }
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmVotacion.btnSiguienteR) {
            Siguiente();
        }
        
        if (e.getSource() == frmVotacion.btnMostrarResultados) {
            Mostrar();
        }
        
        if (e.getSource() == frmVotacion.btnVotar) {
            Votar();
        }
    }
    
    
    
    
}
/*
frmVotacion.txtNoRondas.setText("-");
                frmVotacion.txtAResultados.append("Total de Votos: "+ ListaVotos.size() + "\n");
                Cardenal cardenalMayor = null;

                int mayor = 0;
                for (Cardenal cardenal : ListaCardenal) {
                    int contador = 0;
                    for (Voto voto : ListaVotos) {
                        if (voto.getCardenal().equals(cardenal)) {
                            contador++;
                        }
                    }
                    frmVotacion.txtAResultados.append("Votos totales de "+ cardenal.getNombre() + ": " + contador + "\n");
                    if(contador > mayor) { 
                        mayor = contador;
                        cardenalMayor = cardenal;
                    }
                }
                frmVotacion.txtAResultados.append("\n");
                if (cardenalMayor == null) {
                    frmVotacion.txtAResultados.append("No hubo votos, por lo tanto no hay nuevo Papa");
                }
                else {
                    frmVotacion.txtAResultados.append("El nuevo Papa será: \n");
                    frmVotacion.txtAResultados.append(cardenalMayor.getNombre() + " con " + cardenalMayor.getEdad() + " años que representa a " + cardenalMayor.getPaisRe().getNombre());
                }
*/
