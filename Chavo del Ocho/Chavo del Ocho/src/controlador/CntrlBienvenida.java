package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Jugador;
import vista.JFBienvenida;
import vista.JFVecindad1;

public class CntrlBienvenida implements ActionListener {

    JFBienvenida frmBienvenida;
    JFVecindad1 frmVecindad1;
    Jugador jugador;

    public CntrlBienvenida(JFBienvenida frmBienvenida, JFVecindad1 frmVecindad1, Jugador jugador) {
        this.frmBienvenida = frmBienvenida;
        this.frmVecindad1  = frmVecindad1;
        this.jugador       = jugador;

        this.frmBienvenida.btnEmpezar.addActionListener(this);
    }

    public void empezar() {
        String nombre = frmBienvenida.txtNombre.getText().trim();
        String edadTxt = frmBienvenida.txtEdad.getText().trim();

        // ── Validar que ambos campos estén llenos ──────────────────────────
        if (nombre.isEmpty() || edadTxt.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(
                    frmBienvenida,
                    "Por favor, escribe tu nombre y tu edad para continuar.",
                    "Campos requeridos",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // ── Validar que la edad sea un número ──────────────────────────────
        int edad;
        try {
            edad = Integer.parseInt(edadTxt);
            if (edad <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(
                    frmBienvenida,
                    "La edad debe ser un número válido.",
                    "Edad inválida",
                    javax.swing.JOptionPane.WARNING_MESSAGE
            );
            frmBienvenida.txtEdad.setText("");
            frmBienvenida.txtEdad.requestFocus();
            return;
        }

        // ── Setear datos al jugador ────────────────────────────────────────
        jugador.setNombre(nombre);
        jugador.setEdad(edad);

        // ── Avanzar al juego ───────────────────────────────────────────────
        frmVecindad1.setVisible(true);
        frmBienvenida.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmBienvenida.btnEmpezar) {
            empezar();
        }
    }
}
