package com.uacm.edu.championsmx.vista;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VistaPrincipal extends JFrame {

    private JPanel panelPrincipal;
    private JPanel panelPartidos;
    private JPanel panelCalendario;
    private CardLayout cardLayout;
    private JPanel panelContenido;

    private JButton btnPartidos;
    private JButton btnClasificacion;

    private String[] diasSemana = {"dom", "lun", "mar", "mié", "jue", "vie", "sáb"};

    public VistaPrincipal() {
        inicializarComponentes();
        mostrarPartidosEjemplo();
    }

    private void inicializarComponentes() {
        setTitle("Liga MX - Temporada 2025");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);

        panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(Color.WHITE);

        // Encabezado
        JPanel panelEncabezado = crearPanelEncabezado();
        panelPrincipal.add(panelEncabezado, BorderLayout.NORTH);

        // Contenido central con CardLayout
        cardLayout = new CardLayout();
        panelContenido = new JPanel(cardLayout);

        // Panel de Partidos
        panelPartidos = new JPanel();
        panelPartidos.setLayout(new BoxLayout(panelPartidos, BoxLayout.Y_AXIS));
        panelPartidos.setBackground(Color.WHITE);
        panelPartidos.setBorder(new EmptyBorder(15, 20, 15, 20));

        JScrollPane scrollPartidos = new JScrollPane(panelPartidos);
        scrollPartidos.setBorder(null);
        panelContenido.add(scrollPartidos, "PARTIDOS");

        // Panel de Clasificación
        JPanel panelClasificacion = new JPanel(new BorderLayout());
        panelClasificacion.setBackground(Color.WHITE);
        JLabel lblClasificacion = new JLabel("📊 Aquí se mostrarán los goleadores", SwingConstants.CENTER);
        lblClasificacion.setFont(new Font("Arial", Font.PLAIN, 16));
        panelClasificacion.add(lblClasificacion, BorderLayout.CENTER);
        panelContenido.add(panelClasificacion, "CLASIFICACION");

        // Panel de Agregar partido
        JPanel panelAgregar = new JPanel(new BorderLayout());
        panelAgregar.setBackground(Color.WHITE);
        JLabel lblAgregar = new JLabel("➕ Aquí se abrirá el modal de nuevo partido", SwingConstants.CENTER);
        lblAgregar.setFont(new Font("Arial", Font.PLAIN, 16));
        panelAgregar.add(lblAgregar, BorderLayout.CENTER);
        panelContenido.add(panelAgregar, "AGREGAR");

        panelPrincipal.add(panelContenido, BorderLayout.CENTER);

        add(panelPrincipal);
    }

    private JPanel crearPanelEncabezado() {
        JPanel panelEncabezado = new JPanel(new BorderLayout());
        panelEncabezado.setBackground(Color.WHITE);
        panelEncabezado.setBorder(new EmptyBorder(15, 20, 15, 20));

        // Logo + Título
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTitulo.setBackground(Color.WHITE);

        JLabel lblLogo = new JLabel("⭐");
        lblLogo.setFont(new Font("Arial", Font.BOLD, 26));
        lblLogo.setForeground(new Color(44, 62, 143));

        JLabel lblTitulo = new JLabel("Champions MX");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(44, 62, 143));

        panelTitulo.add(lblLogo);
        panelTitulo.add(lblTitulo);

        panelEncabezado.add(panelTitulo, BorderLayout.WEST);

        // Botón temporada
        JLabel lblTemporada = new JLabel("Temporada 2025");
        lblTemporada.setFont(new Font("Arial", Font.PLAIN, 12));
        lblTemporada.setForeground(Color.GRAY);
        panelEncabezado.add(lblTemporada, BorderLayout.EAST);

        // Barra de navegación
        JPanel panelNav = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelNav.setBackground(Color.WHITE);

        btnPartidos = crearBotonNav("Partidos", true);
        btnClasificacion = crearBotonNav("Clasificación", false);

        // Listeners
        btnPartidos.addActionListener(e -> mostrarSeccion("PARTIDOS", btnPartidos));
        btnClasificacion.addActionListener(e -> mostrarSeccion("CLASIFICACION", btnClasificacion));

        panelNav.add(btnPartidos);
        panelNav.add(btnClasificacion);

        panelEncabezado.add(panelNav, BorderLayout.CENTER);

        // Botón nuevo partido arriba
        JButton btnNuevo = new JButton("➕ Nuevo Partido");
        btnNuevo.setBackground(new Color(44, 62, 143));
        btnNuevo.setForeground(Color.WHITE);
        btnNuevo.setFocusPainted(false);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setPreferredSize(new Dimension(150, 35));

        btnNuevo.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Aquí se abriría el formulario para agregar un nuevo partido.")
        );

        panelEncabezado.add(btnNuevo, BorderLayout.SOUTH);

        return panelEncabezado;
    }

    private JButton crearBotonNav(String texto, boolean activo) {
        JButton boton = new JButton(texto);
        boton.setPreferredSize(new Dimension(140, 35));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setOpaque(true);

        if (activo) {
            boton.setBackground(new Color(44, 62, 143));
            boton.setForeground(Color.WHITE);
        } else {
            boton.setBackground(new Color(220, 220, 220));
            boton.setForeground(Color.BLACK);
        }

        return boton;
    }

    private void mostrarSeccion(String nombrePanel, JButton botonActivo) {
        // Cambiar panel
        cardLayout.show(panelContenido, nombrePanel);

        // Resetear colores
        btnPartidos.setBackground(new Color(220, 220, 220));
        btnPartidos.setForeground(Color.BLACK);
        btnClasificacion.setBackground(new Color(220, 220, 220));
        btnClasificacion.setForeground(Color.BLACK);

        // Activar botón seleccionado
        botonActivo.setBackground(new Color(44, 62, 143));
        botonActivo.setForeground(Color.WHITE);
    }

    private void mostrarPartidosEjemplo() {
        // Datos de ejemplo
        String[][] partidos = {
                {"Cruz Azul", "2 - 2", "América"},
                {"Tigres UANL", "2 - 0", "Atlas"},
                {"Toluca", "6 - 2", "Monterrey"},
                {"Santos Laguna", "1 - 0", "Club Tijuana"},
                {"Atlético San Luis", "0 - 1", "Club América"}
        };

        for (String[] partido : partidos) {
            JPanel panel = crearPanelPartido(partido[0], partido[1], partido[2]);
            panelPartidos.add(panel);
            panelPartidos.add(Box.createVerticalStrut(10));
        }
    }

    private JPanel crearPanelPartido(String equipoLocal, String marcador, String equipoVisitante) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(250, 250, 250));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                new EmptyBorder(10, 15, 10, 15)
        ));

        // Contenedor central alineado con GridLayout
        JPanel panelCentro = new JPanel(new GridLayout(1, 3));
        panelCentro.setBackground(new Color(250, 250, 250));

        JLabel lblLocal = new JLabel(equipoLocal, SwingConstants.RIGHT);
        JLabel lblMarcador = new JLabel(marcador, SwingConstants.CENTER);
        JLabel lblVisitante = new JLabel(equipoVisitante, SwingConstants.LEFT);

        Font fuente = new Font("Arial", Font.BOLD, 16);
        lblLocal.setFont(fuente);
        lblMarcador.setFont(new Font("Arial", Font.BOLD, 18));
        lblVisitante.setFont(fuente);

        panelCentro.add(lblLocal);
        panelCentro.add(lblMarcador);
        panelCentro.add(lblVisitante);

        // Panel derecho con botones
        JPanel panelDerecha = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelDerecha.setBackground(new Color(250, 250, 250));

        JButton btnDetalles = new JButton("Detalles");
        JButton btnEliminar = new JButton("Eliminar");

        btnDetalles.setBackground(new Color(44, 62, 143));
        btnDetalles.setForeground(Color.WHITE);
        btnDetalles.setFocusPainted(false);

        btnEliminar.setBackground(new Color(200, 50, 50));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);

        panelDerecha.add(btnDetalles);
        panelDerecha.add(btnEliminar);

        panel.add(panelCentro, BorderLayout.CENTER);
        panel.add(panelDerecha, BorderLayout.EAST);

        return panel;
    }
}