/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import vista.*;
import modelo.*;

/**
 *
 * @author roca
 */
public class CntrlRecomendador implements ActionListener {

    private JFRecomendador frmRecomendador;
    private JFRegistrarUsuario frmRegistrarUsuario;
    private JFComentario frmComentario;
    private JFVerComentarios frmVerComentarios;
    private ArrayList<Usuario> listaUsuario;
    private ArrayList<Pelicula> listaPeliculas;
    private int indexPelicula;

    public CntrlRecomendador() {
    }

    public CntrlRecomendador(JFRecomendador frmRecomendador, JFComentario frmComentario, JFVerComentarios frmVerComentarios, JFRegistrarUsuario frmRegistrarUsuario, ArrayList<Usuario> listaUsuario) {
        this.frmRecomendador = frmRecomendador;
        this.frmComentario = frmComentario;
        this.frmRegistrarUsuario = frmRegistrarUsuario;
        this.frmVerComentarios = frmVerComentarios;
        this.listaUsuario = listaUsuario;
        this.listaPeliculas = new ArrayList<>();
        crearPeliculas();

        indexPelicula = 0;
        frmRecomendador.mostrarPeliculaEnPantalla(listaPeliculas.get(indexPelicula));
        this.frmComentario.btnComentar.addActionListener(this);
        this.frmRecomendador.btnAdelante.addActionListener(this);
        this.frmRecomendador.btnAtras.addActionListener(this);
        this.frmRecomendador.btnComentar.addActionListener(this);
        this.frmRecomendador.btnRefrescarRecomendador.addActionListener(this);
        this.frmRecomendador.btnBuscar.addActionListener(this);
        this.frmRecomendador.btnRegresarRegistrar.addActionListener(this);
        this.frmRecomendador.btnVerComentarios.addActionListener(this);
        this.frmRecomendador.btnViEstaPelicula.addActionListener(this);

    }

    public void crearPeliculas() {
        listaPeliculas.add(new Pelicula("El Conjuro", "Terror", 2013, "James Wan", 3.0, "112 min", "el_conjuro.jpg"));
        listaPeliculas.add(new Pelicula("Sinister", "Terror", 2012, "Scott Derrickson", 3.0, "110 min", "sinister.jpg"));
        listaPeliculas.add(new Pelicula("Un Lugar en Silencio", "Terror", 2018, "John Krasinski", 3.0, "90 min", "un_lugar_en_silencio.jpg"));

        listaPeliculas.add(new Pelicula("¿Qué pasó ayer?", "Comedia", 2009, "Todd Phillips", 3.0, "100 min", "que_paso_ayer.jpg"));
        listaPeliculas.add(new Pelicula("Son Como Niños", "Comedia", 2010, "Dennis Dugan", 3.0, "102 min", "son_como_ninos.jpg"));
        listaPeliculas.add(new Pelicula("Superbad", "Comedia", 2007, "Greg Mottola", 3.0, "113 min", "superbad.jpg"));

        listaPeliculas.add(new Pelicula("Cuestión de Tiempo", "Romance", 2013, "Richard Curtis", 3.0, "123 min", "cuestion_de_tiempo.jpg"));
        listaPeliculas.add(new Pelicula("La La Land", "Romance", 2016, "Damien Chazelle", 3.0, "128 min", "la_la_land.jpg"));
        listaPeliculas.add(new Pelicula("Orgullo y Prejuicio", "Romance", 2005, "Joe Wright", 3.0, "129 min", "orgullo_y_prejuicio.jpg"));

        listaPeliculas.add(new Pelicula("John Wick", "Acción", 2014, "Chad Stahelski", 3.0, "101 min", "john_wick.jpg"));
        listaPeliculas.add(new Pelicula("Mad Max: Furia en el Camino", "Acción", 2015, "George Miller", 3.0, "120 min", "mad_max.jpg"));
        listaPeliculas.add(new Pelicula("Top Gun: Maverick", "Acción", 2022, "Joseph Kosinski", 3.0, "130 min", "top_gun_maverick.jpg"));

        listaPeliculas.add(new Pelicula("Mamma Mia!", "Musical", 2008, "Phyllida Lloyd", 3.0, "108 min", "mamma_mia.jpg"));
        listaPeliculas.add(new Pelicula("El Gran Showman", "Musical", 2017, "Michael Gracey", 3.0, "105 min", "el_gran_showman.jpg"));
        listaPeliculas.add(new Pelicula("Tick, Tick... Boom!", "Musical", 2021, "Lin-Manuel Miranda", 3.0, "115 min", "tick_tick_boom.jpg"));

        listaPeliculas.add(new Pelicula("Interstellar", "Scie-Fi", 2014, "Christopher Nolan", 3.0, "169 min", "interstellar.jpg"));
        listaPeliculas.add(new Pelicula("Blade Runner 2049", "Scie-Fi", 2017, "Denis Villeneuve", 3.0, "164 min", "blade_runner_2049.jpg"));
        listaPeliculas.add(new Pelicula("El Origen (Inception)", "Scie-Fi", 2010, "Christopher Nolan", 3.0, "148 min", "el_origen.jpg"));
    }

    public void cambiarPeliculaAdelante() {
        indexPelicula++;
        frmRecomendador.btnAtras.setEnabled(true);
        if (indexPelicula == listaPeliculas.size() - 1) {
            frmRecomendador.btnAdelante.setEnabled(false);
            frmRecomendador.mostrarPeliculaEnPantalla(listaPeliculas.get(indexPelicula));
        } else {
            frmRecomendador.mostrarPeliculaEnPantalla(listaPeliculas.get(indexPelicula));
        }
        actualizarEstadoBtnVista();
    }

    public void cambiarPeliculaAtras() {
        indexPelicula--;
        frmRecomendador.btnAdelante.setEnabled(true);
        if (indexPelicula == 0) {
            frmRecomendador.btnAtras.setEnabled(false);
            frmRecomendador.mostrarPeliculaEnPantalla(listaPeliculas.get(indexPelicula));
        } else {
            frmRecomendador.mostrarPeliculaEnPantalla(listaPeliculas.get(indexPelicula));
        }
        actualizarEstadoBtnVista();
    }

    public void viEstaPelicula() {
        listaUsuario.getLast().agregarPeliculaVista(listaPeliculas.get(indexPelicula));
        frmRecomendador.btnViEstaPelicula.setEnabled(false);
    }

    private void actualizarEstadoBtnVista() {
        Pelicula peliculaActual = listaPeliculas.get(indexPelicula);
        boolean yaVista = false;

        for (Pelicula vista : listaUsuario.getLast().getPeliculasVistas()) {
            if (vista.equals(peliculaActual)) {
                yaVista = true;
                break;
            }
        }

        frmRecomendador.btnViEstaPelicula.setEnabled(!yaVista);
    }

    public void abrirVerComentarios() {
        frmVerComentarios.setVisible(true);
    }

    public void actualizarComentarios() {
        frmVerComentarios.txtAComentarios.setText("");
        for (Comentario comentario : listaPeliculas.get(indexPelicula).getListaComentarios()) {
            frmVerComentarios.txtAComentarios.append(comentario.getId() + " ------------------\n");
            frmVerComentarios.txtAComentarios.append("Usuario: " + comentario.getUsuario().toString() + "\n");
            frmVerComentarios.txtAComentarios.append(comentario.getEnunciado() + "\n");
            long estrellasCalificadas = Math.round(comentario.getCalificacion());
            String califiacionEstrella = null;
            if (comentario.getCalificacion() == 1) {
                califiacionEstrella = "★☆☆☆☆";
            } else if (estrellasCalificadas == 2) {
                califiacionEstrella = "★★☆☆☆";
            } else if (comentario.getCalificacion() == 3) {
                califiacionEstrella = "★★★☆☆";
            } else if (comentario.getCalificacion() == 4) {
                califiacionEstrella = "★★★★☆";
            } else if (comentario.getCalificacion() == 5) {
                califiacionEstrella = "★★★★★";
            } else {
                califiacionEstrella = "☆☆☆☆☆";
            }
            frmVerComentarios.txtAComentarios.append("Calificacion: " + califiacionEstrella + "\n");
        }
    }

    public void abrirComentar() {
        Pelicula peliculaActual = listaPeliculas.get(indexPelicula);
        boolean yaVista = false;

        for (Pelicula vista : listaUsuario.getLast().getPeliculasVistas()) {
            if (vista.equals(peliculaActual)) {
                yaVista = true;
                break;
            }
        }

        if (!yaVista) {
            javax.swing.JOptionPane.showMessageDialog(
                    frmRecomendador,
                    "¡Primero debes marcar esta película como vista para poder comentarla!"
            );
            return;
        }

        frmComentario.setVisible(true);
    }

    public void Comentar() {
        String enunciado = frmComentario.txtAEnunciado.getText();
        if (enunciado.isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(frmComentario, "Por favor, ingrese un comentario.");
            return;
        }

        String calificacionTM = (String) frmComentario.comBCalificacion.getSelectedItem();
        if (calificacionTM == null) {
            javax.swing.JOptionPane.showMessageDialog(frmComentario, "Por favor, seleccione una calificación.");
            return;
        }

        double calificacion = switch (calificacionTM) {
            case "★☆☆☆☆" ->
                1;
            case "★★☆☆☆" ->
                2;
            case "★★★☆☆" ->
                3;
            case "★★★★☆" ->
                4;
            case "★★★★★" ->
                5;
            default -> {
                javax.swing.JOptionPane.showMessageDialog(frmComentario, "Calificación no válida.");
                yield -1;
            }
        };

        if (calificacion == -1) {
            return;
        }

        int idLocal = listaPeliculas.get(indexPelicula).getListaComentarios().size() + 1;

        Comentario comentario = new Comentario(
                String.valueOf(idLocal),
                enunciado,
                calificacion,
                listaUsuario.getLast()
        );

        listaPeliculas.get(indexPelicula).agregarComentario(comentario);
        if (calificacion >= 4) {
            String genero = listaPeliculas.get(indexPelicula).getGenero();
            List<String> preferenciasActuales = listaUsuario.getLast().getListaPreferencias();

            if (!preferenciasActuales.contains(genero)) {
                listaUsuario.getLast().agregarPreferencia(genero);
            }
        }

        frmComentario.txtAEnunciado.setText("");
        frmComentario.comBCalificacion.setSelectedIndex(0);
        frmComentario.setVisible(false);

        javax.swing.JOptionPane.showMessageDialog(frmComentario, "¡Comentario agregado exitosamente!");
        actualizarComentarios();
        actualizarCalificacionEnPantalla();

    }

    public void buscarPelicula() {
        String tipoBusqueda = (String) frmRecomendador.comBTitulo.getSelectedItem();
        String busqueda = frmRecomendador.txtBusqueda.getText();
        if (tipoBusqueda.equals("Titulo")) {
            for (Pelicula pelicula : listaPeliculas) {
                if (pelicula.getTitulo().equals(busqueda)) {
                    indexPelicula = listaPeliculas.indexOf(pelicula);
                    frmRecomendador.mostrarPeliculaEnPantalla(pelicula);
                    return;
                }
            }
        } else if (tipoBusqueda.equals("Genero")) {
            for (Pelicula pelicula : listaPeliculas) {
                if (pelicula.getGenero().equals(busqueda)) {
                    indexPelicula = listaPeliculas.indexOf(pelicula);
                    frmRecomendador.mostrarPeliculaEnPantalla(pelicula);
                    return;
                }
            }
        } else if (tipoBusqueda.equals("Director")) {
            for (Pelicula pelicula : listaPeliculas) {
                if (pelicula.getDirector().equals(busqueda)) {
                    indexPelicula = listaPeliculas.indexOf(pelicula);
                    frmRecomendador.mostrarPeliculaEnPantalla(pelicula);
                    return;
                }
            }
        } else {
            javax.swing.JOptionPane.showConfirmDialog(frmRecomendador, "No se ha encontrado ninguna pelicula");
        }
        actualizarEstadoBtnVista();
    }

    public void regresarRegistrar() {
        frmRecomendador.setVisible(false);
        frmComentario.setVisible(false);
        frmVerComentarios.setVisible(false);
        frmRegistrarUsuario.setVisible(true);
    }

    public void RecomendarPeliculas() {
        if (listaUsuario.isEmpty()) {
            return;
        }

        List<String> preferencias = listaUsuario.getLast().getListaPreferencias();

        listaPeliculas.sort((p1, p2) -> {
            int idx1 = preferencias.indexOf(p1.getGenero());
            int idx2 = preferencias.indexOf(p2.getGenero());

            if (idx1 == -1) {
                idx1 = preferencias.size();
            }
            if (idx2 == -1) {
                idx2 = preferencias.size();
            }

            return Integer.compare(idx1, idx2);
        });

        indexPelicula = 0;
        frmRecomendador.btnAtras.setEnabled(false);
        frmRecomendador.btnAdelante.setEnabled(true);
        frmRecomendador.mostrarPeliculaEnPantalla(listaPeliculas.get(indexPelicula));
        actualizarEstadoBtnVista();
    }

    private void actualizarCalificacionEnPantalla() {
        double promedio = listaPeliculas.get(indexPelicula).calcularCalificacionPromedio();
        long estrellasRedondeadas = Math.round(promedio);

        String estrellas = switch ((int) estrellasRedondeadas) {
            case 1 ->
                "★☆☆☆☆";
            case 2 ->
                "★★☆☆☆";
            case 3 ->
                "★★★☆☆";
            case 4 ->
                "★★★★☆";
            case 5 ->
                "★★★★★";
            default ->
                "☆☆☆☆☆";
        };

        frmRecomendador.txtClasificacion.setText(estrellas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmRecomendador.btnComentar) {
            abrirComentar();
        }

        if (e.getSource() == frmRecomendador.btnVerComentarios) {
            abrirVerComentarios();
        }

        if (e.getSource() == frmComentario.btnComentar) {
            Comentar();
        }

        if (e.getSource() == frmRecomendador.btnAtras) {
            cambiarPeliculaAtras();
        }

        if (e.getSource() == frmRecomendador.btnAdelante) {
            cambiarPeliculaAdelante();
        }

        if (e.getSource() == frmRecomendador.btnViEstaPelicula) {
            viEstaPelicula();
        }

        if (e.getSource() == frmRecomendador.btnRegresarRegistrar) {
            regresarRegistrar();
        }

        if (e.getSource() == frmRecomendador.btnBuscar) {
            buscarPelicula();
        }

        if (e.getSource() == frmRecomendador.btnRefrescarRecomendador) {
            RecomendarPeliculas();
        }
    }

}
