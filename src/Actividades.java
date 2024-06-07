import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class Actividades extends JFrame {
    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194, 190, 212);
    Color mini = new Color(46, 43, 65);
    Color margen = new Color(106, 97, 148);
    Color boton = new Color(30, 27, 41);
    int baño = 0;
    int entrenar = 0;
    String[] mensajesConsulta = {
            "Tu mascota necesita una revisión completa para asegurarse de su buena salud.",
            "Recuerda vacunar a tu mascota según el calendario de vacunación.",
            "Es importante mantener el peso ideal de tu mascota para prevenir problemas de salud.",
            "No olvides desparasitar a tu mascota regularmente para su bienestar.",
            "Consulta con un veterinario si notas cambios en el comportamiento o apetito de tu mascota."
    };

    private List<Mascota> mascotas;
    private int index;
    private File archivoDatos;
    private VentanaMain ventanaMain; // Añadir referencia a VentanaMain

    public Actividades(VentanaMain ventanaMain, List<Mascota> mascotas, int index) { // Modificar el constructor
        this.ventanaMain = ventanaMain; // Inicializar la referencia
        this.mascotas = mascotas;
        this.index = index;
        this.archivoDatos = archivoDatos;
        setTitle("Actividades");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(fondo);

        if (!mascotas.isEmpty()) {
            Mascota primeraMascota = mascotas.get(index);

            JLabel nombreLabel = new JLabel("Nombre: " + primeraMascota.getNombre());
            nombreLabel.setForeground(text);
            getContentPane().add(nombreLabel, BorderLayout.NORTH);

            iniciar(mascotas, index);
        }

        setVisible(true);
    }

    public void iniciar(List<Mascota> mascotas, int index) {
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(fondo);
        panelBotones.setLayout(new GridLayout(5, 1, 10, 10));

        JButton botonBañar = new JButton("Bañar");
        botonBañar.setBackground(boton);
        botonBañar.setForeground(text);
        botonBañar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baño++;
                JOptionPane.showMessageDialog(null, mascotas.get(index).getNombre() + " tomó " +
                        baño + " un baño");
            }
        });
        panelBotones.add(botonBañar);

        JButton botonEntrenar = new JButton("Entrenar");
        botonEntrenar.setBackground(boton);
        botonEntrenar.setForeground(text);
        botonEntrenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entrenar++;
                JOptionPane.showMessageDialog(null, mascotas.get(index).getNombre() + " ha entrenado " +
                        entrenar + " vez");
            }
        });
        panelBotones.add(botonEntrenar);

        JButton botonConsultaMedica = new JButton("Consulta Médica");
        botonConsultaMedica.setBackground(boton);
        botonConsultaMedica.setForeground(text);
        botonConsultaMedica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int randomIndex = rand.nextInt(mensajesConsulta.length);
                JOptionPane.showMessageDialog(null, mensajesConsulta[randomIndex]);
            }
        });
        panelBotones.add(botonConsultaMedica);

        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.setBackground(boton);
        botonEliminar.setForeground(text);
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mascotas.remove(index);
                JOptionPane.showMessageDialog(null, "La mascota ha sido eliminada.");
                ventanaMain.actualizarListaMascotas(mascotas); // Actualiza la lista completa
                dispose();
            }
        });

        panelBotones.add(botonEliminar);

        JButton botonModificar = new JButton("Modificar");
        botonModificar.setBackground(boton);
        botonModificar.setForeground(text);
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mascotas.get(index).setData();
            }
        });
        panelBotones.add(botonModificar);

        JButton mostrarDatos = new JButton("Mostrar Datos");
        mostrarDatos.setBackground(boton);
        mostrarDatos.setForeground(text);
        mostrarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mascotas.get(index).mostrarDatos();
            }
        });
        panelBotones.add(mostrarDatos);

        getContentPane().add(panelBotones, BorderLayout.CENTER);
    }
}
