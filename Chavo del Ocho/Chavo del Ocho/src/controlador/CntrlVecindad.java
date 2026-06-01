package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Jugador;
import modelo.Objeto;
import vista.JFDialogo;
import vista.JFVecindad1;
import vista.JFVecindad2;

public class CntrlVecindad implements ActionListener {

    // ── Vistas ─────────────────────────────────────────────────────────────
    JFVecindad1 frmVecindad1;
    JFVecindad2 frmVecindad2;
    JFDialogo frmDialogo;
    CntrlDialogos cntrlDialogos;

    // ── Modelo: jugador y objetos de la vecindad ───────────────────────────
    private final Jugador jugador = new Jugador("J1", "Chavo", 8);

    private final Objeto pelota  = new Objeto(
            "Pelota de Quico",
            "Otra pelota de Quico, una de las muchas que tiene"
    );
    private final Objeto munieca = new Objeto(
            "Juanchis",
            "Juanchis, una muñeca de Popis, que para ella, es como una de sus mejores amigas"
    );

    // ── Constructor ────────────────────────────────────────────────────────
    public CntrlVecindad(JFVecindad1 frmVecindad1, JFVecindad2 frmVecindad2,
            JFDialogo frmDialogo, CntrlDialogos cntrlDialogos) {

        this.frmVecindad1  = frmVecindad1;
        this.frmVecindad2  = frmVecindad2;
        this.frmDialogo    = frmDialogo;
        this.cntrlDialogos = cntrlDialogos;

        this.frmVecindad1.btnQuicoYChilindrina.addActionListener(this);
        this.frmVecindad1.btnFlorindaYRamon.addActionListener(this);
        this.frmVecindad1.btnFlechaDerecha.addActionListener(this);
        this.frmVecindad1.btnPelota.addActionListener(this);

        this.frmVecindad2.btnBarriga.addActionListener(this);
        this.frmVecindad2.btnPopis.addActionListener(this);
        this.frmVecindad2.btnFlechaDerecha.addActionListener(this);
        this.frmVecindad2.btnMunieca.addActionListener(this);
    }

    // ── Situaciones de diálogo ─────────────────────────────────────────────

    public void situactionQuicoYChilindrina() {
        cntrlDialogos.iniciarQuicoYChilindrina();
        cntrlDialogos.mostrarDialogo();
        frmDialogo.setVisible(true);
        frmVecindad1.btnQuicoYChilindrina.setVisible(false);
    }

    public void situacionFlorindaYRamon() {
        cntrlDialogos.iniciarFlorindayRamon();
        cntrlDialogos.mostrarDialogo();
        frmDialogo.setVisible(true);
        frmVecindad1.btnFlorindaYRamon.setVisible(false);
    }

    public void situactionPopis() {
        cntrlDialogos.iniciarPopis();
        cntrlDialogos.mostrarDialogo();
        frmVecindad2.btnPopis.setVisible(false);
        frmDialogo.setVisible(true);
    }

    public void situacionBarriga() {
        cntrlDialogos.iniciarBarriga();
        cntrlDialogos.mostrarDialogo();
        frmDialogo.setVisible(true);
        frmVecindad2.btnBarriga.setVisible(false);
    }

    // ── Navegación entre vecindades ────────────────────────────────────────

    public void irAVecindad2() {
        frmVecindad1.setVisible(false);
        frmVecindad2.setVisible(true);
    }

    public void irAVecindad1() {
        frmVecindad1.setVisible(true);
        frmVecindad2.setVisible(false);
    }

    // ── Interacción con objetos (usa el modelo) ────────────────────────────

    public void mostrarPelota() {
        jugador.interactuarObjeto(pelota);
        javax.swing.JOptionPane.showMessageDialog(frmVecindad1, pelota.getDescripcion());
    }

    public void mostrarMunieca() {
        jugador.interactuarObjeto(munieca);
        javax.swing.JOptionPane.showMessageDialog(frmVecindad2, munieca.getDescripcion());
    }

    // ── actionPerformed ────────────────────────────────────────────────────

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmVecindad1.btnQuicoYChilindrina) {
            situactionQuicoYChilindrina();
        }
        if (e.getSource() == frmVecindad1.btnFlorindaYRamon) {
            situacionFlorindaYRamon();
        }
        if (e.getSource() == frmVecindad2.btnPopis) {
            situactionPopis();
        }
        if (e.getSource() == frmVecindad2.btnBarriga) {
            situacionBarriga();
        }
        if (e.getSource() == frmVecindad2.btnFlechaDerecha) {
            irAVecindad1();
        }
        if (e.getSource() == frmVecindad1.btnFlechaDerecha) {
            irAVecindad2();
        }
        if (e.getSource() == frmVecindad1.btnPelota) {
            mostrarPelota();
        }
        if (e.getSource() == frmVecindad2.btnMunieca) {
            mostrarMunieca();
        }
    }
}
