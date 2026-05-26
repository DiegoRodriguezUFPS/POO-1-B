package controlador;

import java.awt.Image;
import java.awt.Point;
import modelo.Abuela;
import modelo.Arbol;
import modelo.Bosque;
import modelo.Caperucita;
import modelo.Cesta;
import modelo.Escenario;
import modelo.Estado;
import modelo.Lenador;
import modelo.Lobo;
import modelo.Objeto;
import modelo.Personaje;
import modelo.Tipo;

import controlador.controladorCesta;
import vista.JFInterfaz;
import vista.JFDatos; 
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class controladorVista implements ActionListener {
    private JFInterfaz frmInterfaz;
    private JFDatos frmDatos; 
    private controladorCesta controlCesta;
    private int contador = 1;
    
    private Caperucita caperucita;
    private Lobo lobo;
    private Lenador lenador;
    private Abuela abuela;

    private Point posInicialCaper;
    private Point posInicialLobo;
    private Point posInicialLenador;

    public controladorVista(JFInterfaz frmInterfaz, controladorCesta controlCesta, JFDatos frmDatos) {
        this.frmInterfaz = frmInterfaz;
        this.controlCesta = controlCesta;
        this.frmDatos = frmDatos; 
        
        this.frmInterfaz.btnEvento.addActionListener(this);
        this.frmInterfaz.btnReiniciar.addActionListener(this);
        this.frmInterfaz.btnMostrarInformacion.addActionListener(this); 
        
        this.posInicialCaper = this.frmInterfaz.jLabel3Caper.getLocation();
        this.posInicialLobo = this.frmInterfaz.Label4Lobo.getLocation();
        this.posInicialLenador = this.frmInterfaz.Label5Leñador.getLocation();
        
        this.caperucita = new Caperucita(controlCesta.guardarCesta(), "1091973761", "Caperucita", Estado.NORMAL, "Protagonista");
        this.lobo = new Lobo(false, "1091973762", "Lobo", Estado.NORMAL, "Villano");
        Objeto hacha = new Objeto("1222", "Hacha", Tipo.HERRAMIENTA, 34.0);
        this.lenador = new Lenador(hacha, "1091973763", "Leñador", Estado.NORMAL, "Héroe");
        this.abuela = new Abuela(98, "En deterioro", "1091973765", "Abuela", Estado.NORMAL, "Víctima");
        
        actualizarTodosLosDatos();
        configurarCombos(true, false, false, false);
        mostrarInstruccionesIniciales();
    }
    
    private void mostrarInstruccionesIniciales() {
        frmInterfaz.TextArea1.setText("");
        frmInterfaz.TextArea1.append("¡BIENVENIDO AL JUEGO INTERACTIVO DE CAPERUCITA ROJA!\n\n");
        frmInterfaz.TextArea1.append("Instrucciones de juego:\n");
        frmInterfaz.TextArea1.append("1. En cada acto de la historia se te presentará una situación y un dilema de opción múltiple.\n");
        frmInterfaz.TextArea1.append("2. Debes desplegar el menú (ComboBox) del personaje activo y escoger la opción correcta.\n");
        frmInterfaz.TextArea1.append("3. Si eliges la opción equivocada, se te dara una pista para solucionarlo.\n\n");
        frmInterfaz.TextArea1.append("Para continuar dale a siguiente.");
    }
    
    private void configurarCombos(boolean caper, boolean lobo, boolean abuela, boolean lenador) {
        frmInterfaz.ComboCaperucita.setEnabled(caper);
        frmInterfaz.ComboLobo.setEnabled(lobo);
        frmInterfaz.ComboAbuela.setEnabled(abuela);
        frmInterfaz.ComboLeñador.setEnabled(lenador);
    }
    
    private void actualizarDatosCaperucita() {
        frmDatos.txtIdCaperucita.setText(caperucita.getId());
        frmDatos.txtNombreCaperucita.setText(caperucita.getNombre());
        frmDatos.txtRolCaperucita.setText(caperucita.getRol());
        frmDatos.txtEstadoCaperucita.setText(caperucita.getEstado().toString());
    }

    private void actualizarDatosLobo() {
        frmDatos.txtIdLobo.setText(lobo.getId());
        frmDatos.txtNombreLobo.setText(lobo.getNombre());
        frmDatos.txtRolLobo.setText(lobo.getRol());
        frmDatos.txtEstadoLobo.setText(lobo.getEstado().toString());
        frmDatos.txtTieneDisfraz.setText(String.valueOf(lobo.isTieneDisfraz()));
    }

    private void actualizarDatosAbuela() {
        frmDatos.txtIDAbuela.setText(abuela.getId());
        frmDatos.txtNombreAbuela.setText(abuela.getNombre());
        frmDatos.txtRolAbuela.setText(abuela.getRol());
        frmDatos.txtEstadoAbuela.setText(abuela.getEstado().toString());
        frmDatos.txtEdad.setText(String.valueOf(abuela.getEdad()));
    }

    private void actualizarDatosLenador() {
        frmDatos.txtIdLeniador.setText(lenador.getId());
        frmDatos.txtNombreLeniador.setText(lenador.getNombre());
        frmDatos.txtRolLeniador.setText(lenador.getRol());
        frmDatos.txtEstadoLeniador.setText(lenador.getEstado().toString());
        frmDatos.txtEdadLeniador.setText(lenador.getHacha().getNombre()); 
    }

    private void actualizarTodosLosDatos() {
        actualizarDatosCaperucita();
        actualizarDatosLobo();
        actualizarDatosAbuela();
        actualizarDatosLenador();
    }
    
    public void siguienteEvento() {
        if (contador == 1) {
            configurarCombos(true, false, false, false);
            frmInterfaz.TextArea1.setText(""); 
            frmInterfaz.TextArea1.append("[ACTO 1]\n");
            frmInterfaz.TextArea1.append("En un bosque muy lejano vivía una alegre niña llamada Caperucita Roja. Un día, su madre le pidió que cruzara el bosque para llevarle una cesta con comida a su abuelita, que se encontraba enferma.\n\n");
            frmInterfaz.TextArea1.append("Mientras Caperucita caminaba, empezó a aburrirse en el trayecto.\n"
                    + "¿Qué crees que hará para entretenerse?\n"
                    + "a) Cantar\n"
                    + "b) Bailar\n"
                    + "c) Mirar Facebook");
        }
        
        String caperucitaTM = frmInterfaz.ComboCaperucita.getSelectedItem().toString();
        if (contador == 2) {
            if (caperucitaTM.equals("Cantar")) {
                frmInterfaz.TextArea1.append("\n\nBIEN: " + caperucita.cantar());
            } else if (caperucitaTM.equals("Bailar")) {
                frmInterfaz.TextArea1.append("\n\nMAL: Caperucita no se va a poner a bailar sola en medio del bosque hostil.");
                contador = 1; 
            } else if (caperucitaTM.equals("Mirar Facebook")) {
                frmInterfaz.TextArea1.append("\n\nMAL: En esta época de fantasía no existen los smartphones ni las redes sociales.");
                contador = 1;
            }
        }

        if (contador == 3) {        
            configurarCombos(false, true, false, false);
            frmInterfaz.jLabel3Caper.setLocation(posInicialCaper.x - 348, posInicialCaper.y);
            frmInterfaz.TextArea1.setText(""); 
            frmInterfaz.TextArea1.append("[ACTO 2]\n");
            frmInterfaz.TextArea1.append("Mientras Caperucita avanzaba, se topó con el Lobo Feroz. Este, con intenciones ocultas, se le acercó amablemente y le preguntó: —¿A dónde vas tan sola, pequeña niña?. Caperucita, sin malicia, respondió: —Voy a la casa de mi abuelita a llevarle esta merienda.\n\n");
            frmInterfaz.TextArea1.append("El lobo, planeando un engaño para quedarse con ambas, decidió rápidamente:\n"
                    + "a) Correr\n"
                    + "b) Tragar Caperucita\n"
                    + "c) Disfrazarse\n"
                    + "d) Tragar Abuelita");
        }
 
        String loboTM = frmInterfaz.ComboLobo.getSelectedItem().toString();
        if (contador == 4) {
            if (loboTM.equals("Correr")) {
                frmInterfaz.TextArea1.append("\n\nBIEN: " + lobo.correr());
                frmInterfaz.Label4Lobo.setLocation(posInicialLobo.x + 149, posInicialLobo.y - 388);
            } else if (loboTM.equals("Tragar Caperucita")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lobo.tragarCaperuza() + " (Si se la come aquí, perderá la oportunidad de devorar también a la abuela).");
                contador = 3;
            } else if (loboTM.equals("Disfrazarse")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lobo.disfrazarse() + " (¿Disfrazarse frente a ella en el camino? Lo descubriría de inmediato).");
                contador = 3;
            } else if (loboTM.equals("Tragar Abuelita")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lobo.tragarAbuela() + " (La abuela no está aquí en el sendero, se encuentra en su cabaña).");
                contador = 3;
            }
        }
        
        if (contador == 5) {
            configurarCombos(false, false, true, false);
            frmInterfaz.TextArea1.setText(""); 
            frmInterfaz.TextArea1.append("[ACTO 3]\n");
            frmInterfaz.TextArea1.append("Tomando el camino más corto, el lobo tomó la delantera y llegó primero a la casa de la abuela. Golpeó la puerta fingiendo ser su nieta. La anciana, completamente confiada, lo invitó a pasar sin sospechar el peligro.\n\n");
            frmInterfaz.TextArea1.append("Al ver que la puerta se abría, la abuelita reacciona e intenta:\n"
                    + "a) Gritar\n"
                    + "b) Estudiar POO\n"
                    + "c) Cambiarse ropa");
        }

        String abuelaTM = frmInterfaz.ComboAbuela.getSelectedItem().toString();
        if (contador == 6) {
            if (abuelaTM.equals("Gritar")) {
                frmInterfaz.TextArea1.append("\n\nBIEN: " + abuela.gritar());
                frmInterfaz.jLabel2Abuelita.setVisible(false);
                frmInterfaz.Label4Lobo.setLocation(posInicialLobo.x + 89, posInicialLobo.y - 398);
                
                abuela.setEstado(Estado.COMIDO);
                actualizarDatosAbuela();
            } else if (abuelaTM.equals("Estudiar POO")) {
                frmInterfaz.TextArea1.append("\n\nMAL: La abuelita no entiende de clases ni objetos, ¡y el lobo ya la va a atacar!");
                contador = 5;
            } else if (abuelaTM.equals("Cambiarse ropa")) {
                frmInterfaz.TextArea1.append("\n\nMAL: No hay tiempo para elegir otro outfit, ¡el depredador está encima!");
                contador = 5;
            }
        }
     
        if (contador == 7) {
            configurarCombos(false, false, false, true);
            frmInterfaz.jLabel3Caper.setLocation(posInicialCaper.x - 78, posInicialCaper.y - 230);
            frmInterfaz.TextArea1.setText(""); 
            frmInterfaz.TextArea1.append("[ACTO 4]\n");
            frmInterfaz.TextArea1.append("Mientras tanto, Caperucita estaba en su ruta. En el trayecto divisó a un leñador de la zona que trabajaba en el bosque. Al saludarlo, el buen hombre le advirtió que tuviera extremo cuidado, ya que se reportaba la presencia de un lobo merodeando por los alrededores.\n\n");
            frmInterfaz.TextArea1.append("Al ver a la niña preocupada, el leñador decide:\n"
                    + "a) Salvar\n"
                    + "b) Regalar dulce\n"
                    + "c) Rellenar Panza\n"
                    + "d) Abrir Panza");
        }

        String lenadorTM = frmInterfaz.ComboLeñador.getSelectedItem().toString();
        if (contador == 8) {
            if (lenadorTM.equals("Regalar dulce")) {
                frmInterfaz.TextArea1.append("\n\nBIEN: El detalle logra tranquilizar el susto de Caperucita.");
            } else if (lenadorTM.equals("Salvar")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lenador.salvar() + " (¿Salvar a quién? Caperucita está perfectamente bien aquí en el camino).");
                contador = 7;
            } else if (lenadorTM.equals("Rellenar Panza")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lenador.rellenarPanza() + " (No hay ninguna panza que rellenar en este momento del cuento).");
                contador = 7;
            } else if (lenadorTM.equals("Abrir Panza")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lenador.abrirPanza() + " (El lobo ni siquiera está presente aquí para interactuar con él).");
                contador = 7;
            }
        } 
        
        if (contador == 9) {
            configurarCombos(false, true, false, false);
            frmInterfaz.jLabel3Caper.setLocation(posInicialCaper.x - 288, posInicialCaper.y - 390);
            frmInterfaz.TextArea1.setText(""); 
            frmInterfaz.TextArea1.append("[ACTO 5]\n");
            frmInterfaz.TextArea1.append("Caperucita finalmente llegó a la casa de su abuela. Al notar la puerta entornada, pasó con cautela y se acercó a la cama. Al ver un aspecto extraño en su abuelita, empezó a interrogarla sin saber que quien yacía allí era el lobo esperándola.\n\n");
            frmInterfaz.TextArea1.append("¿Qué hizo el lobo justo antes de que la niña entrara a la habitación?\n"
                    + "a) Correr\n"
                    + "b) Tragar Caperucita\n"
                    + "c) Disfrazarse\n"
                    + "d) Tragar Abuelita");
        }

        if (contador == 10) {
            if (loboTM.equals("Disfrazarse")) {
                frmInterfaz.TextArea1.append("\n\nBIEN: " + lobo.disfrazarse());
                ImageIcon iconoLoboAbuela = new ImageIcon(getClass().getResource("/imagen/Lobo abuelita.png"));
                Image imagenLoboAbuelita = iconoLoboAbuela.getImage();
                frmInterfaz.Label4Lobo.setIcon(new ImageIcon(imagenLoboAbuelita.getScaledInstance(frmInterfaz.Label4Lobo.getWidth(), frmInterfaz.Label4Lobo.getHeight(), Image.SCALE_SMOOTH)));
                
                lobo.setTieneDisfraz(true); 
                actualizarDatosLobo();
            } else if (loboTM.equals("Correr")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lobo.correr() + " (Si el lobo huye ahora, arruinaría su propia emboscada).");
                contador = 9;
            } else if (loboTM.equals("Tragar Caperucita")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lobo.tragarCaperuza() + " (Aún no, primero debe esperar que ella se acerque a la cama).");
                contador = 9;
            } else if (loboTM.equals("Tragar Abuelita")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lobo.tragarAbuela() + " (¡Imposible! El lobo ya devoró a la abuelita en el Acto 3).");
                contador = 9;
            }
        }
         
        if (contador == 11) {
            configurarCombos(false, true, false, false);
            frmInterfaz.TextArea1.setText(""); 
            frmInterfaz.TextArea1.append("[ACTO 6]\n");
            frmInterfaz.TextArea1.append("—¡Qué orejas tan grandes tienes!, ¡Qué ojos tan grandes tienes!— decía la niña confundida. El lobo respondía astutamente a cada observación, impaciente por terminar su plan ante tanta insistencia de Caperucita.\n\n");
            frmInterfaz.TextArea1.append("¿Cómo reacciona el lobo ante la última pregunta sobre sus grandes dientes?\n"
                    + "a) Correr\n"
                    + "b) Tragar Caperucita\n"
                    + "c) Disfrazarse\n"
                    + "d) Tragar Abuelita");
        }

        if (contador == 12) {
            if (loboTM.equals("Disfrazarse")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lobo.disfrazarse() + " (Ya está usando el disfraz, lo que debe hacer ahora es atacar).");
                contador = 11;
            } else if (loboTM.equals("Correr")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lobo.correr() + " (El lobo no va a escapar teniendo la cena completamente servida).");
                contador = 11;
            } else if (loboTM.equals("Tragar Caperucita")) {
                frmInterfaz.TextArea1.append("\n\nBIEN: " + lobo.tragarCaperuza());
                frmInterfaz.jLabel3Caper.setVisible(false);
                ImageIcon iconoLoboGordo = new ImageIcon(getClass().getResource("/imagen/Lobo Gordo.png"));
                Image imagenLoboGordo = iconoLoboGordo.getImage();
                frmInterfaz.Label4Lobo.setIcon(new ImageIcon(imagenLoboGordo.getScaledInstance(frmInterfaz.Label4Lobo.getWidth(), frmInterfaz.Label4Lobo.getHeight(), Image.SCALE_SMOOTH)));
                
                caperucita.setEstado(Estado.COMIDO);
                actualizarDatosCaperucita();
            } else if (loboTM.equals("Tragar Abuelita")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lobo.tragarAbuela() + " (La abuela ya está en su estómago desde hace rato).");
                contador = 11;
            }
        }
        
        if (contador == 13) {
            configurarCombos(false, false, false, true);
            frmInterfaz.Label5Leñador.setLocation(posInicialLenador.x - 250, posInicialLenador.y - 171);
            frmInterfaz.TextArea1.setText(""); 
            frmInterfaz.TextArea1.append("[ACTO 7]\n");
            frmInterfaz.TextArea1.append("Por fortuna, el leñador pasó caminando cerca de la cabaña y escuchó unos ronquidos extraños y descomunales. Intuyendo que algo andaba mal con la anciana, entró con decisión y descubrió al animal durmiendo plácidamente tras su banquete.\n\n");
            frmInterfaz.TextArea1.append("¿Qué acción toma el leñador para resolver la situación?:\n"
                    + "a) Salvar\n"
                    + "b) Regalar dulce\n"
                    + "c) Rellenar Panza\n"
                    + "d) Abrir Panza");
        }

        if (contador == 14) {
            if (lenadorTM.equals("Abrir Panza")) {
                frmInterfaz.TextArea1.append("\n\nBIEN: " + lenador.abrirPanza());
                frmInterfaz.Label4Lobo.setVisible(false);
                
                lobo.setEstado(Estado.MUERTO);
                abuela.setEstado(Estado.RESCATADO);
                caperucita.setEstado(Estado.RESCATADO);
                
                actualizarTodosLosDatos();
            } else if (lenadorTM.equals("Salvar")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lenador.salvar() + " (Solo con exclamar 'salvar' no logrará nada, ¡necesita usar la herramienta!).");
                contador = 13;
            } else if (lenadorTM.equals("Regalar dulce")) {
                frmInterfaz.TextArea1.append("\n\nMAL: ¿Darle un obsequio al lobo dormido? Lo que el animal se merece es un hachazo.");
                contador = 13;
            } else if (lenadorTM.equals("Rellenar Panza")) {
                frmInterfaz.TextArea1.append("\n\nMAL: " + lenador.rellenarPanza() + " (Primero hay que extraer a las víctimas antes de colocar las piedras).");
                contador = 13;
            }
        }
 
        if (contador == 15) {
            configurarCombos(false, false, false, false);
            frmInterfaz.jLabel2Abuelita.setVisible(true);
            frmInterfaz.jLabel3Caper.setVisible(true);
            frmInterfaz.Label5Leñador.setLocation(posInicialLenador.x - 180, posInicialLenador.y - 171);       
            frmInterfaz.TextArea1.setText(""); 
            frmInterfaz.TextArea1.append("[ACTO 8]\n");
            frmInterfaz.TextArea1.append("Con el lobo derrotado, la abuelita y Caperucita Roja salieron completamente ilesas. Ambas agradecieron infinitamente al valiente leñador por su oportuna ayuda. Desde ese día, la niña prometió seguir estrictamente los consejos de su madre y no volver a confiar en extraños en el bosque. Y así, vivieron felices y tranquilos para siempre.");
        }
        contador += 1;
    }
    
    public void reiniciar() {
        frmInterfaz.TextArea1.setText("");
        contador = 1; 
        
        this.caperucita = new Caperucita(controlCesta.guardarCesta(), "1091973761", "Caperucita", Estado.NORMAL, "Protagonista");
        this.lobo = new Lobo(false, "1091973762", "Lobo", Estado.NORMAL, "Villano");
        Objeto hacha = new Objeto("1222", "Hacha", Tipo.HERRAMIENTA, 34.0);
        this.lenador = new Lenador(hacha, "1091973763", "Leñador", Estado.NORMAL, "Héroe");
        this.abuela = new Abuela(98, "En deterioro", "1091973765", "Abuela", Estado.NORMAL, "Víctima");
        
        frmInterfaz.jLabel2Abuelita.setVisible(true);
        frmInterfaz.jLabel3Caper.setVisible(true);
        frmInterfaz.Label4Lobo.setVisible(true);
        
        ImageIcon iconoLobo = new ImageIcon(getClass().getResource("/imagen/Lobo.png"));
        Image imagen = iconoLobo.getImage().getScaledInstance(frmInterfaz.Label4Lobo.getWidth(), frmInterfaz.Label4Lobo.getHeight(), Image.SCALE_SMOOTH);
        frmInterfaz.Label4Lobo.setIcon(new ImageIcon(imagen));
        
        frmInterfaz.Label4Lobo.setLocation(posInicialLobo);
        frmInterfaz.jLabel3Caper.setLocation(posInicialCaper);
        frmInterfaz.Label5Leñador.setLocation(posInicialLenador);
        
        actualizarTodosLosDatos();
        configurarCombos(true, false, false, false);
        mostrarInstruccionesIniciales();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmInterfaz.btnEvento) {
            siguienteEvento();
        }
        if (e.getSource() == frmInterfaz.btnReiniciar) { 
            reiniciar();
        }
        if (e.getSource() == frmInterfaz.btnMostrarInformacion) {
            frmDatos.setVisible(true); 
        }
    }
}