/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Aliado;
import modelo.Enemigo;
import modelo.Equipo;
import modelo.Habilidad;
import modelo.TipoEquipo;
import modelo.TipoHabilidad;
import modelo.WonderWoman;
import vista.JFJuego;
import vista.JFRuletaHabilidad;
import vista.JFRuletaEquipo;

/**
 *
 * @author roca
 */
public class cntrlJuego implements ActionListener {

    //JF
    private JFJuego frmJuego;
    private JFRuletaEquipo frmRuletaEquipo;
    private JFRuletaHabilidad frmRuletaHabilidad;

    //Objetos
    private WonderWoman wonderWoman;
    private Aliado aliado;
    private Enemigo ares;

    //Listas
    private ArrayList<Enemigo> listaEnemigo;
    private ArrayList<Habilidad> listaHabilidad;
    private ArrayList<Equipo> listaEquipo;

    //Extra
    double probabilidad;
    boolean habilidadActiva;
    double vidaMaximaWonder;
    int puntos;

    public cntrlJuego() {
    }

    public cntrlJuego(JFJuego frmJuego, JFRuletaEquipo frmRuletaEquipo, JFRuletaHabilidad frmRuletaHabilidad) {
        this.frmJuego = frmJuego;
        this.frmRuletaEquipo = frmRuletaEquipo;
        this.frmRuletaHabilidad = frmRuletaHabilidad;
        this.probabilidad = 0;
        this.habilidadActiva = false;
        this.puntos = 0;

        crearListas();

        this.wonderWoman = new WonderWoman("Themyscira", "Diana", 100, 1);
        this.vidaMaximaWonder = this.wonderWoman.getCantidadVida();
        this.aliado = new Aliado("Dar Consejos", "Steve", 0, 0);
        this.ares = new Enemigo(35, "Ares", 50000, 5);
        

        this.frmJuego.txtVidaWonder.setText(wonderWoman.getCantidadVida() + "/" + vidaMaximaWonder);
        this.frmJuego.txtNivelWonder.setText(String.valueOf(this.wonderWoman.getNivel()));
        
        this.frmJuego.txtCantidadEnemigos.setText(listaEnemigo.size() + "x");
        
        // Inicializamos ambos textos de vida
        actualizarVidaEnemigo();
        actualizarVidaJefe();

        // Ocultamos las cosas de Ares al inicio
        this.frmJuego.lblAres.setVisible(false);
        this.frmJuego.btnAtacarAres.setVisible(false);
        this.frmJuego.txtVidaJefe.setVisible(false);

        //Botones
        this.frmJuego.btnInteractuar.addActionListener(this);
        this.frmJuego.btnRuletaEquipo.addActionListener(this);
        this.frmJuego.btnRuletaHabilidad.addActionListener(this);
        this.frmJuego.btnCuracion.addActionListener(this);
        this.frmJuego.btnHabilidad.addActionListener(this);
        this.frmJuego.btnEnemigo.addActionListener(this);
        this.frmJuego.btnAtacarAres.addActionListener(this);

        //Botones ruletas
        this.frmRuletaHabilidad.btnOK.addActionListener(this);
        this.frmRuletaEquipo.btnOK.addActionListener(this);
    }

    public void crearListas() {
        //Enemigo
        listaEnemigo = new ArrayList<>();
        listaEnemigo.add(new Enemigo(10, "Soldado", 150, 1));
        listaEnemigo.add(new Enemigo(15, "Soldado", 200, 2));
        listaEnemigo.add(new Enemigo(20, "Soldado", 350, 3));
        listaEnemigo.add(new Enemigo(25, "Soldado", 500, 4));

        //Habilidad
        listaHabilidad = new ArrayList<Habilidad>();
        listaHabilidad.add(new Habilidad("01", "Bendición", TipoHabilidad.CURACION, "Cura 10 de vida y aumenta en 10 el nivel base; este efecto se acaba al llegar a 100 puntos", 200));
        listaHabilidad.add(new Habilidad("02", "SuperCorte", TipoHabilidad.ATAQUE, "El siguiente ataque inflige x2 del daño original", 150));
        listaHabilidad.add(new Habilidad("03", "Castigo", TipoHabilidad.DEFENSA, "Si el enemigo inflige daño a Wonder Woman, este puede recibir daño de vuelta (no garantizado)", 50));
        listaHabilidad.add(new Habilidad("04", "Azotar", TipoHabilidad.ATAQUE, "Wonder Woman usa su látigo de la verdad, haciendo que el siguiente ataque inflija 30 de daño", 90));
        listaHabilidad.add(new Habilidad("05", "Justicia", TipoHabilidad.ATAQUE, "El enemigo pierde 20 de vida extra en el siguiente ataque pero Wonder Woman perderá 20 puntos de vida", 120));

        //Equipo
        listaEquipo = new ArrayList<Equipo>();
        listaEquipo.add(new Equipo("01", "Escudo de Temiscira", TipoEquipo.ARMADURA, "La vida base aumenta 10 puntos"));
        listaEquipo.add(new Equipo("02", "Espada Matadioses", TipoEquipo.COMBATE, "El nivel base aumenta 6 puntos"));
        listaEquipo.add(new Equipo("03", "Tiara Real", TipoEquipo.ACCESORIO, "x2 en puntos."));
        listaEquipo.add(new Equipo("04", "Cinturón de Gea", TipoEquipo.ARMADURA, "La vida base aumenta 10 puntos"));
        listaEquipo.add(new Equipo("05", "Pendientes de Atenea", TipoEquipo.ACCESORIO, "El nivel base aumenta 3 puntos"));
        listaEquipo.add(new Equipo("06", "Botas de Hermes", TipoEquipo.ARMADURA, "La vida base aumenta 10 puntos"));
        listaEquipo.add(new Equipo("07", "Brazaletes de Sumisión", TipoEquipo.COMBATE, "El nivel base aumenta 3 puntos"));
        listaEquipo.add(new Equipo("08", "Anillos de Helios", TipoEquipo.ACCESORIO, "Los ataques tienen un 10% de hacer x2 de daño (acumulable)"));
        listaEquipo.add(new Equipo("09", "Elíxir de fuerza", TipoEquipo.COMBATE, "El nivel base aumenta 8 puntos"));
        listaEquipo.add(new Equipo("10", "Collar exótico", TipoEquipo.ACCESORIO, "Los ataques tienen un 10% de hacer x2 de daño (acumulable)"));

    }

    public void interactuar() {
        int random = (int) (Math.random() * 5) + 1;
        switch (random) {
            case 1:
                javax.swing.JOptionPane.showMessageDialog(frmJuego, "Steve: Prioriza tu vida sobre todo los demás", "Consejos de Steve", -1);
                break;
            case 2:
                javax.swing.JOptionPane.showMessageDialog(frmJuego, "Steve: Los enemigos aumentaran su nivel de hostilidad progresivamente. ¡Ten cuidado!", "Consejos de Steve", -1);
                break;
            case 3:
                javax.swing.JOptionPane.showMessageDialog(frmJuego, "Steve: Si le das a la ruleta de habilidad teniendo ya una habilidad, esta cambiará a la nueva que consigas", "Consejos de Steve", -1);
                break;
            case 4:
                javax.swing.JOptionPane.showMessageDialog(frmJuego, "Steve: Si eliminas a todos los enemigos podrás pelear con Ares", "Consejos de Steve", -1);
                break;
            case 5:
                javax.swing.JOptionPane.showMessageDialog(frmJuego, "Steve: Obten varios objetos, estos te ayudaran a ganar.", "Consejos de Steve", -1);
                break;
            default:
                throw new AssertionError();
        }
    }

    public void ruletaEquipo() {
        puntos -= 100;
        actualizarPuntos();
        if (wonderWoman.getListaEquipo().size() == listaEquipo.size()) {
            javax.swing.JOptionPane.showMessageDialog(frmJuego, "¡¡Ya obtuviste todos los equipos!!");

        } else {
            while (true) {
                int random = (int) (Math.random() * listaEquipo.size());
                Equipo equipoSeleccionado = listaEquipo.get(random);

                boolean esta = false;
                for (Equipo equipo : wonderWoman.getListaEquipo()) {
                    if (equipoSeleccionado.equals(equipo)) {
                        esta = true;
                        break;
                    }
                }
                if (!esta) {
                    wonderWoman.agregarEquipo(equipoSeleccionado);
                    frmRuletaEquipo.txtNombre.setText(equipoSeleccionado.getNombre());
                    frmRuletaEquipo.txtTipo.setText(equipoSeleccionado.getTipoEquipo().toString());
                    frmRuletaEquipo.txtDescripcion.setText(equipoSeleccionado.getDescripcion());
                    frmRuletaEquipo.setVisible(true);
                    utilizarEquipo(equipoSeleccionado);
                    return;

                }
            }
        }
    }

    public void utilizarEquipo(Equipo equipoSeleccionado) {
        switch (equipoSeleccionado.getId()) {
            case "01" -> {
                vidaMaximaWonder += 10;
                actualizarVidaWonder();
            }
            case "02" -> {
                wonderWoman.setNivel(wonderWoman.getNivel() + 6);
            }
            case "03" -> {
                puntos = (puntos + 100) * 2;
                actualizarPuntos();
            }
            case "04" -> {
                vidaMaximaWonder += 10;
                actualizarVidaWonder();
            }
            case "05" -> {
                wonderWoman.setNivel(wonderWoman.getNivel() + 3);
            }
            case "06" -> {
                vidaMaximaWonder += 10;
                actualizarVidaWonder();
            }
            case "07" -> {
                wonderWoman.setNivel(wonderWoman.getNivel() + 3);
            }
            case "08" -> {
                probabilidad += 10;
            }
            case "09" -> {
                wonderWoman.setNivel(wonderWoman.getNivel() + 8);
            }
            case "10" -> {
                probabilidad += 10;
            }

            default ->
                throw new AssertionError();
        }
        actualizarDanioBase();
    }

    public void ruletaHabilidad() {
        while (true) {
            int random = (int) (Math.random() * listaHabilidad.size());
            Habilidad habilidad = listaHabilidad.get(random);
            if (!habilidad.equals(wonderWoman.getListaHabilidades().getFirst())) {
                wonderWoman.getListaHabilidades().set(0, habilidad);
                frmRuletaHabilidad.txtNombre.setText(habilidad.getNombre());
                frmRuletaHabilidad.txtTipo.setText(habilidad.getTipoHabilidad().toString());
                frmRuletaHabilidad.txtDescripcion.setText(habilidad.getDescripcion());
                frmRuletaHabilidad.setVisible(true);

                frmJuego.lblHabilidad.setText(habilidad.getNombre());
                frmJuego.btnHabilidad.setText("Requiere " + habilidad.getPuntosUsarlo());
                
                actualizarPuntos();
                return;
            }
        }
    }

    public void utilizarHabilidad(Habilidad habilidad, Enemigo enemigo) {
        int puntosAnt = puntos;
        
        if (habilidad == null || !habilidadActiva) {
            double nivelAn = wonderWoman.getNivel();
            int posibilidad = (int) (Math.random() * 100) + 1;
            boolean esCritico = posibilidad <= probabilidad;
            
            if (esCritico) {
                wonderWoman.setNivel(nivelAn * 2);
            }
            
            wonderWoman.atacar(enemigo);
            
            if (esCritico) {
                wonderWoman.setNivel(nivelAn);
            }
        } else if (habilidadActiva) {
            switch (habilidad.getId()) {
                case "01" -> {
                    wonderWoman.setCantidadVida(wonderWoman.getCantidadVida() + 10);
                    wonderWoman.setNivel(wonderWoman.getNivel()+10);
                    wonderWoman.atacar(enemigo);
                    puntos -= habilidad.getPuntosUsarlo();
                    if (puntos == puntosAnt + 100) {
                        wonderWoman.setCantidadVida(wonderWoman.getCantidadVida() - 10);
                        wonderWoman.setNivel(wonderWoman.getNivel()-10);
                    }
                    actualizarDanioBase();
                }
                case "02" -> {
                    wonderWoman.setNivel(wonderWoman.getNivel() * 2);
                    wonderWoman.atacar(enemigo);
                    puntos -= habilidad.getPuntosUsarlo();
                }
                case "03" -> {
                    enemigo.atacar(enemigo);
                    puntos -= habilidad.getPuntosUsarlo();
                }
                case "04" -> {
                    double nivelAn = wonderWoman.getNivel();
                    wonderWoman.setNivel(30);
                    wonderWoman.atacar(enemigo);
                    wonderWoman.setNivel(nivelAn);
                    puntos -= habilidad.getPuntosUsarlo();
                }
                case "05" -> {
                    double nivelAn = wonderWoman.getNivel();
                    wonderWoman.setNivel(wonderWoman.getNivel() + 20);
                    wonderWoman.atacar(enemigo);
                    wonderWoman.setNivel(nivelAn);
                    wonderWoman.setCantidadVida(wonderWoman.getCantidadVida() - 20);
                    actualizarVidaWonder();
                    verificarDerrota(); 
                    puntos -= habilidad.getPuntosUsarlo();
                }
                default ->
                    throw new AssertionError();
            }
            habilidadActiva = false;
        }
    }

    public void ok() {
        frmRuletaEquipo.setVisible(false);
        frmRuletaHabilidad.setVisible(false);
    }

    public void activarHabilidad() {
        habilidadActiva = true;
        actualizarPuntos(); 
    }

    public void atacarEnemigo() {
        if (listaEnemigo.isEmpty()) {
            // CORRECCIÓN VISUAL: Ocultamos los componentes del soldado cansón
            frmJuego.btnEnemigo.setVisible(false);
            frmJuego.txtVidaEnemigo.setVisible(false);
            
            frmJuego.lblAres.setVisible(true);
            frmJuego.btnAtacarAres.setVisible(true);
            frmJuego.txtVidaJefe.setVisible(true);
            
            actualizarVidaEnemigo();
            actualizarVidaJefe(); 
            javax.swing.JOptionPane.showMessageDialog(frmJuego, "¡Ya no quedan soldados! Enfréntate a Ares.");
            return;
        }

        Enemigo actualEnemigo = listaEnemigo.getFirst();
        
        utilizarHabilidad(wonderWoman.getListaHabilidades().getFirst(), actualEnemigo);
        puntos += (int) wonderWoman.getNivel();
        actualizarPuntos(); 
        frmJuego.txtPuntos.setText(String.valueOf(puntos));

        if (actualEnemigo.getCantidadVida() <= 0) {
            listaEnemigo.remove(actualEnemigo);
            frmJuego.txtCantidadEnemigos.setText(listaEnemigo.size() + "x");
            
            if (listaEnemigo.isEmpty()) {
                // CORRECCIÓN VISUAL: Ocultamos los componentes si la lista queda vacía tras tu ataque
                frmJuego.btnEnemigo.setVisible(false);
                frmJuego.txtVidaEnemigo.setVisible(false);
                
                frmJuego.lblAres.setVisible(true);
                frmJuego.btnAtacarAres.setVisible(true);
                frmJuego.txtVidaJefe.setVisible(true);
                
                javax.swing.JOptionPane.showMessageDialog(frmJuego, "¡Has derrotado a todos los soldados! ¡Ares ha despertado!");
            }
        } else {
            actualEnemigo.atacar(wonderWoman);
            actualizarVidaWonder();
            verificarDerrota(); 
            
            if (actualEnemigo.getCantidadVida() <= 0) {
                listaEnemigo.remove(actualEnemigo);
                frmJuego.txtCantidadEnemigos.setText(listaEnemigo.size() + "x");
                
                if (listaEnemigo.isEmpty()) {
                    // CORRECCIÓN VISUAL: Ocultamos los componentes si muere por contraataque
                    frmJuego.btnEnemigo.setVisible(false);
                    frmJuego.txtVidaEnemigo.setVisible(false);
                    
                    frmJuego.lblAres.setVisible(true);
                    frmJuego.btnAtacarAres.setVisible(true);
                    frmJuego.txtVidaJefe.setVisible(true);
                    
                    javax.swing.JOptionPane.showMessageDialog(frmJuego, "¡El último soldado cayó por contraataque! ¡Ares aparece!");
                }
            }
        }

        actualizarVidaEnemigo();
        actualizarVidaJefe(); 
    }

    public void atacarAres() {
        if (ares.getCantidadVida() <= 0) {
            frmJuego.btnAtacarAres.setEnabled(false);
            javax.swing.JOptionPane.showMessageDialog(frmJuego, "Ares ya fue derrotado. ¡Salvaste el mundo!");
            return;
        }

        utilizarHabilidad(wonderWoman.getListaHabilidades().getFirst(), ares);
        puntos += (int) wonderWoman.getNivel();
        actualizarPuntos();
        frmJuego.txtPuntos.setText(String.valueOf(puntos));

        if (ares.getCantidadVida() <= 0) {
            frmJuego.btnAtacarAres.setEnabled(false);
            javax.swing.JOptionPane.showMessageDialog(frmJuego, "¡¡INCREÍBLE!! ¡Has derrotado a Ares y salvado la humanidad!");
        } else {
            ares.atacar(wonderWoman);
            actualizarVidaWonder();
            verificarDerrota(); 
            
            if (ares.getCantidadVida() <= 0) {
                frmJuego.btnAtacarAres.setEnabled(false);
                javax.swing.JOptionPane.showMessageDialog(frmJuego, "¡Ares cayó ante su propio daño! ¡Victoria total!");
            }
        }

        actualizarVidaEnemigo(); 
        actualizarVidaJefe(); 
    }

    public void verificarDerrota() {
        if (wonderWoman.getCantidadVida() <= 0) {
            javax.swing.JOptionPane.showMessageDialog(frmJuego, "¡Has sido derrotada! El mundo ha caído ante la oscuridad.", "GAME OVER", javax.swing.JOptionPane.ERROR_MESSAGE);
            frmJuego.dispose(); 
        }
    }

    public void actualizarVidaWonder() {
        frmJuego.txtVidaWonder.setText(String.valueOf(wonderWoman.getCantidadVida()) + "/" + String.valueOf(vidaMaximaWonder));
    }

    public void actualizarVidaEnemigo() {
        if (!listaEnemigo.isEmpty()) {
            frmJuego.txtVidaEnemigo.setText(String.valueOf(listaEnemigo.getFirst().getCantidadVida()));
        } else if (ares.getCantidadVida() > 0) {
            frmJuego.txtVidaEnemigo.setText(String.valueOf(ares.getCantidadVida()));
        } else {
            frmJuego.txtVidaEnemigo.setText("0");
        }
    }

    public void actualizarVidaJefe() {
        frmJuego.txtVidaJefe.setText(String.valueOf(ares.getCantidadVida()));
    }

    public void actualizarPuntos() {
        frmJuego.txtPuntos.setText(String.valueOf(puntos));
        if (puntos >= 100) {
            frmJuego.btnRuletaEquipo.setEnabled(true);
            frmJuego.btnRuletaEquipo.setText("Utilizar");
        } else {
            frmJuego.btnRuletaEquipo.setEnabled(false);
            frmJuego.btnRuletaEquipo.setText("Requiere 100");
        }

        if (puntos >= 200) {
            frmJuego.btnRuletaHabilidad.setEnabled(true);
            frmJuego.btnRuletaHabilidad.setText("Utilizar");
        } else {
            frmJuego.btnRuletaHabilidad.setEnabled(false);
            frmJuego.btnRuletaHabilidad.setText("Requiere 200");
        }

        if (puntos >= 50) {
            frmJuego.btnCuracion.setEnabled(true);
            frmJuego.btnCuracion.setText("Utilizar");
        } else {
            frmJuego.btnCuracion.setEnabled(false);
            frmJuego.btnCuracion.setText("Requiere 50");
        }

        int puntosRequeridos = wonderWoman.getListaHabilidades().getFirst().getPuntosUsarlo();
        
        if (habilidadActiva) {
            frmJuego.btnHabilidad.setEnabled(false);
            frmJuego.btnHabilidad.setText("Requiere " + puntosRequeridos);
        } else {
            if (puntosRequeridos == 0) {
                frmJuego.btnHabilidad.setEnabled(false);
                frmJuego.btnHabilidad.setText("Sin habilidad");
            } else if (puntos >= puntosRequeridos) {
                frmJuego.btnHabilidad.setEnabled(true);
                frmJuego.btnHabilidad.setText("Utilizar");
            } else {
                frmJuego.btnHabilidad.setEnabled(false);
                frmJuego.btnHabilidad.setText("Requiere " + puntosRequeridos);
            }
        }

    }

    public void actualizarDanioBase() {
        frmJuego.txtNivelWonder.setText(String.valueOf(wonderWoman.getNivel()));
    }

    public void curar() {
        wonderWoman.setCantidadVida(wonderWoman.getCantidadVida() + 50);
        if (wonderWoman.getCantidadVida() > vidaMaximaWonder) {
            wonderWoman.setCantidadVida(vidaMaximaWonder);
        }
        puntos -= 50;
        actualizarPuntos();
        actualizarVidaWonder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmJuego.btnInteractuar) {
            interactuar();
        }

        if (e.getSource() == frmRuletaEquipo.btnOK || e.getSource() == frmRuletaHabilidad.btnOK) {
            ok();
        }

        if (e.getSource() == frmJuego.btnRuletaEquipo) {
            ruletaEquipo();
        }

        if (e.getSource() == frmJuego.btnRuletaHabilidad) {
            ruletaHabilidad();
        }

        if (e.getSource() == frmJuego.btnCuracion) {
            curar();
        }

        if (e.getSource() == frmJuego.btnEnemigo) {
            atacarEnemigo();
        }
        
        if (e.getSource() == frmJuego.btnHabilidad) {
            activarHabilidad();
        }

        if (e.getSource() == frmJuego.btnAtacarAres) {
            atacarAres();
        }
    }

}