import javax.swing.*;
import java.awt.*;

public class VentanaMain extends JFrame {
    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194,190,212);
    Color mini = new Color(46,43,65);
    Color margen = new Color(106,97,148);
    Color boton = new Color(30,27,41);

    JLabel nombreLabel;
    JLabel cedulaLabel;
    JLabel numeroLabel;
    JLabel direccionLabel;

    public VentanaMain() {
        setTitle("Guardería de mascotas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(fondo);

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
        JLabel labelDatos = new JLabel("Datos del dueño:");
        labelDatos.setForeground(text);
        panelDatos.add(labelDatos);

        nombreLabel = new JLabel("Nombre: ");
        nombreLabel.setForeground(text);
        panelDatos.add(nombreLabel);

        cedulaLabel = new JLabel("Cedula: ");
        cedulaLabel.setForeground(text);
        panelDatos.add(cedulaLabel);

        numeroLabel = new JLabel("Numero: ");
        numeroLabel.setForeground(text);
        panelDatos.add(numeroLabel);

        direccionLabel = new JLabel("Direccion: ");
        direccionLabel.setForeground(text);
        panelDatos.add(direccionLabel);

        // Agregar el panel a la ventana
        panelPrincipal.add(panelDatos, BorderLayout.EAST);

        // Crear un panel central con un GridLayout para las cajas de ingreso de mascotas
        JPanel panelIngreso = new JPanel(new GridLayout(2, 4, 10, 10));
        panelIngreso.setBackground(fondo);

        // Ejemplo de cajas de texto para ingresar datos de mascotas
        for (int i = 1; i <= 8; i++) {
            JTextField textField = new JTextField();
            textField.setBackground(mini);
            textField.setForeground(text);
            textField.setBorder(BorderFactory.createLineBorder(margen));
            panelIngreso.add(textField);
        }

        // Agregar los paneles al panel principal
        panelPrincipal.add(panelIngreso, BorderLayout.CENTER);

        setVisible(true);
    }

    public void mostrarDatos(String nombre, String cedula, String direccion, String telefono) {
        nombreLabel.setText("Nombre: " + nombre);
        cedulaLabel.setText("Cedula: " + cedula);
        direccionLabel.setText("Direccion: " + direccion);
        numeroLabel.setText("Numero: " + telefono);
    }
}