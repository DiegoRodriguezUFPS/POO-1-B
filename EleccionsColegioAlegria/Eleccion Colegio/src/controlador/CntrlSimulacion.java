/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Candidato;
import modelo.CandidatoPersoneria;
import modelo.CandidatoRepresentante;
import modelo.Estudiante;
import modelo.Mascota;
import modelo.TipoAnimal;
import vista.JFCrear;
import vista.JFIngresarEstudiante;
import vista.JFSimulacionCrear;

/**
 *
 * @author roca
 */
public class CntrlSimulacion implements ActionListener {

    private JFSimulacionCrear frmSimulacion;
    private ArrayList<Candidato> listaCandidatos;
    private JFIngresarEstudiante frmIngresarEs;
    private CntrlVotarPersonero cntrlVotarPersonero;
    private JFCrear frmCrear;

    public CntrlSimulacion(JFCrear frmCrear,JFSimulacionCrear frmSimulacion, ArrayList<Candidato> listaCandidatos, JFIngresarEstudiante frmIngresarEs, CntrlVotarPersonero cntrlVotarPersonero) {
        this.frmCrear = frmCrear;
        this.frmSimulacion = frmSimulacion;
        this.listaCandidatos = listaCandidatos;
        this.frmIngresarEs = frmIngresarEs;
        this.cntrlVotarPersonero = cntrlVotarPersonero;

        this.frmSimulacion.btnCrear.addActionListener(this);
        this.frmSimulacion.btnSimulacion.addActionListener(this);
    }

    public void crearSimulacion() {
        //Personeria
        listaCandidatos.add(new CandidatoPersoneria(new Mascota("M01", "Gato", "Macho", "2", "Agil", TipoAnimal.TERRESTRE), "Por un futuro mejor", "1", "101", "Gojo", "Satoru", "11°", "A", "Gojo.jpg"));
        listaCandidatos.add(new CandidatoPersoneria(new Mascota("M02", "Pez", "Hembra", "1", "Tranquila", TipoAnimal.ACUATICO), "Que viva el arroz", "2", "102", "Joy", "Park", "11°", "A", "Joy.jpg"));
        listaCandidatos.add(new CandidatoPersoneria(new Mascota("M03", "Perro", "Macho", "3", "Leal", TipoAnimal.TERRESTRE), "Unidos por el cambio", "3", "103", "Juan", "Perez", "11°", "B", "Juan.jpg"));
        listaCandidatos.add(new CandidatoPersoneria(new Mascota("M04", "Aguila", "Hembra", "4", "Veloz", TipoAnimal.AEREO), "Paso a paso con firmeza", "4", "104", "Mario", "Bros", "11°", "B", "Mario.jpg"));
        listaCandidatos.add(new CandidatoPersoneria(new Mascota("M05", "Loro", "Macho", "5", "Hablador", TipoAnimal.AEREO), "Volando alto en el estudio", "5", "105", "Robin", "Hood", "11°", "A", "Robin.jpg"));
        listaCandidatos.add(new CandidatoPersoneria(null, "", "", "", "Voto en Blanco", "", "", "", ""));

        //Representante
        String[] gradosFijos = {"6°", "7°", "8°", "9°", "10°", "11°"};
        for (int i = 1; i <= 12; i++) {
            int indiceGrado = (i - 1) / 2;
            String grado = gradosFijos[indiceGrado];
            String grupo = "A";

            String id = "1090" + (100 + i);
            String nombres = "CandidatoNomb " + i;
            String apellidos = "Apellido " + i;
            String lema = "¡Por un mejor bienestar para " + grado + "!";
            String numTarjeta = String.valueOf(i);

            String fotoRuta = "imagenGenerica.jpg";

            listaCandidatos.add(new CandidatoRepresentante(
                    new Estudiante(id, nombres, apellidos, grado, grupo),
                    lema,
                    numTarjeta,
                    id,
                    nombres,
                    apellidos,
                    grado,
                    grupo,
                    fotoRuta
            ));

        }

        cntrlVotarPersonero.iniciarCandidatos();

        frmSimulacion.setVisible(false);
        frmIngresarEs.setVisible(true);

        frmSimulacion.dispose();
    }
    
    public void irACrear(){
        frmCrear.setVisible(true);
        frmSimulacion.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmSimulacion.btnSimulacion) {
            crearSimulacion();
        }
        
        if (e.getSource() == frmSimulacion.btnCrear) {
            irACrear();
        }
    }

}
