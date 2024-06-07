import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaMain extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L; // Para serialización

    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194, 190, 212);
    Color mini = new Color(46, 43, 65);
    Color margen = new Color(106, 97, 148);
    Color boton = new Color(30, 27, 41);
    List<Mascota> mascotas;
    List<JLabel> imageLabels;
    List<Boolean> ocupado;

    JLabel nombreLabel;
    JLabel cedulaLabel;
    JLabel numeroLabel;
    JLabel direccionLabel;

    public VentanaMain() {
        setTitle("Guardería de mascotas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(fondo);

        // Agregar listener para guardar los datos al cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                guardarDatos();
            }
        });

        // Inicialización de listas y componentes
        mascotas = new ArrayList<>();
        imageLabels = new ArrayList<>();
        ocupado = new ArrayList<>();

        // Crear un panel principal con BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(fondo);
        add(panelPrincipal);

        // Crear un panel para la derecha donde irán los datos
        JPanel panelDatos = new JPanel();
        panelDatos.setBackground(mini);
        panelDatos.setPreferredSize(new Dimension(200, 600));
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));

        // Agregar los datos al panel
        JLabel labelDatos = new JLabel(" Datos del dueño:");
        labelDatos.setForeground(text);
        panelDatos.add(labelDatos);

        nombreLabel = new JLabel("\nNombre: ");
        nombreLabel.setForeground(text);
        panelDatos.add(nombreLabel);

        cedulaLabel = new JLabel("\nCedula: ");
        cedulaLabel.setForeground(text);
        panelDatos.add(cedulaLabel);

        numeroLabel = new JLabel("\nNumero: ");
        numeroLabel.setForeground(text);
        panelDatos.add(numeroLabel);

        direccionLabel = new JLabel("\nDireccion: ");
        direccionLabel.setForeground(text);
        panelDatos.add(direccionLabel);

        // Agregar el panel a la ventana
        panelPrincipal.add(panelDatos, BorderLayout.EAST);

        // Crear un panel central con un GridLayout para las cajas de ingreso de mascotas
        JPanel panelIngreso = new JPanel(new GridLayout(2, 4, 10, 10));
        panelIngreso.setBackground(fondo);

        // Ejemplo de etiquetas para mostrar imágenes de mascotas
        for (int i = 1; i <= 8; i++) {
            JLabel imageLabel = new JLabel();
            imageLabel.setOpaque(true);
            imageLabel.setBackground(mini);
            imageLabel.setBorder(BorderFactory.createLineBorder(margen));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setVerticalAlignment(SwingConstants.CENTER);

            final int index = i - 1;
            imageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!ocupado.get(index)) {
                        nuevo();
                    } else {
                        Actividades actividades = new Actividades(VentanaMain.this, mascotas, index);
                    }
                }
            });
            imageLabels.add(imageLabel);
            ocupado.add(false); // Inicialmente todos los espacios están libres
            panelIngreso.add(imageLabel);
        }

        // Agregar los paneles al panel principal
        panelPrincipal.add(panelIngreso, BorderLayout.CENTER);

        // Cargar datos al inicio
        cargarDatos();

        // Mostrar los datos cargados en la interfaz gráfica
        actualizarListaMascotas(mascotas);

        setVisible(true);
    }

    public void mostrarDatos(String nombre, String cedula, String direccion, String telefono) {
        nombreLabel.setText("\nNombre: " + nombre);
        cedulaLabel.setText("\nCedula: " + cedula);
        direccionLabel.setText("\nDireccion: " + direccion);
        numeroLabel.setText(" \nNumero: " + telefono);
    }

    public void actualizarListaMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
        for (int i = 0; i < imageLabels.size(); i++) {
            if (i < mascotas.size()) {
                ImageIcon imageIcon = new ImageIcon(mascotas.get(i).getImagen());
                // Escalar la imagen para ajustarla al tamaño del JLabel
                Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imageLabels.get(i).setIcon(new ImageIcon(scaledImage));
                ocupado.set(i, true);// Marcar el espacio como ocupado
            } else {
                imageLabels.get(i).setIcon(null);
                ocupado.set(i, false); // Marcar el espacio como libre
            }
        }
    }

    public void nuevo() {
        new Ventana3(this, mascotas);
    }

    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datos.data"))) {
            oos.writeObject(mascotas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarDatos() {
        File file = new File("datos.data");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                mascotas = (List<Mascota>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
