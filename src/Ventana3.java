import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.List;

public class Ventana3 extends JFrame {
    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194, 190, 212);
    Color mini = new Color(46, 43, 65);
    Color margen = new Color(106, 97, 148);
    Color boton = new Color(30, 27, 41);
    private List<Mascota> mascotas;
    private JPanel dynamicPanel;
    private JTextField nombreField, edadField, sexoField, razaField, especieField, venenoField, colorField;
    private JLabel imagenLabel;
    private File imagen;
    private VentanaMain ventanaMain;
    private JSlider slider;

    public Ventana3(VentanaMain ventanaMain, List<Mascota> mascotas) {
        this.mascotas = mascotas;
        this.ventanaMain = ventanaMain;
        setTitle("Añadir Información de Mascota");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(fondo);

        iniciar();
        setVisible(true);
    }

    private void iniciar() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(fondo);

        JLabel nombreLabel = new JLabel("Nombre de la Mascota:");
        nombreLabel.setForeground(text);
        nombreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        nombreField = new JTextField();
        nombreField.setMaximumSize(new Dimension(300, 20));
        nombreField.setAlignmentX(Component.CENTER_ALIGNMENT);
        nombreField.setBackground(mini);
        nombreField.setBorder(BorderFactory.createLineBorder(margen));
        nombreField.setForeground(Color.WHITE);

        JLabel tipoLabel = new JLabel("Tipo de Mascota:");
        tipoLabel.setForeground(text);
        tipoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] tipos = {"Perro", "Gato", "Hamster", "Pajaro", "Iguana"};
        JComboBox<String> tipoComboBox = new JComboBox<>(tipos);
        tipoComboBox.setMaximumSize(new Dimension(300, 20));
        tipoComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        tipoComboBox.setBackground(mini);
        tipoComboBox.setForeground(Color.WHITE);

        dynamicPanel = new JPanel();
        dynamicPanel.setLayout(new BoxLayout(dynamicPanel, BoxLayout.Y_AXIS));
        dynamicPanel.setBackground(fondo);

        JButton imagenButton = new JButton("Subir imagen");
        imagenButton.setForeground(text);
        imagenButton.setBackground(fondo);
        imagenButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagenButton.addActionListener(e -> seleccionar());

        imagenLabel = new JLabel();
        imagenLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        slider = new JSlider(JSlider.VERTICAL, 50, 200, 100);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(e -> actualizarImagenEscalada());

        tipoComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                actualizarCampos((String) e.getItem());
            }
        });

        JButton guardarButton = new JButton("Guardar");
        guardarButton.setForeground(text);
        guardarButton.setBorder(BorderFactory.createLineBorder(margen));
        guardarButton.setBackground(boton);
        Dimension buttonSize = new Dimension(100, 30);
        guardarButton.setMinimumSize(buttonSize);
        guardarButton.setPreferredSize(buttonSize);
        guardarButton.setMaximumSize(buttonSize);
        guardarButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        guardarButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            String edad = edadField.getText();
            String sexo = sexoField.getText();
            String tipo = (String) tipoComboBox.getSelectedItem();

            Mascota mascota = null;
            if (tipo.equals("Perro") || tipo.equals("Gato")) {
                String raza = razaField.getText();
                if (tipo.equals("Perro")) {
                    mascota = new Perro(nombre, edad, sexo, imagen, raza);
                } else {
                    mascota = new Gato(nombre, edad, sexo, imagen, raza);
                }
            } else if (tipo.equals("Hamster")) {
                String color = colorField.getText();
                mascota = new Hamster(nombre, edad, sexo, imagen, color);
            } else if (tipo.equals("Pajaro")) {
                String especie = especieField.getText();
                mascota = new Pajaro(nombre, edad, sexo, imagen, especie);
            } else {
                String veneno = venenoField.getText();
                mascota = new Iguana(nombre, edad, sexo, imagen, veneno);
            }

            mascotas.add(mascota);
            ventanaMain.actualizarListaMascotas(mascotas);
            GestorSerializacion.guardarMascota(mascota, ventanaMain.getNombreUsuario() + ".data");
            dispose();
        });



        panel.add(Box.createVerticalGlue());
        panel.add(nombreLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(nombreField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(tipoLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(tipoComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(dynamicPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(imagenButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(imagenLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(slider);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(guardarButton);
        panel.add(Box.createVerticalGlue());

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.WEST);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.EAST);

        actualizarCampos(tipos[0]);
    }

    private void seleccionar() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            imagen = fileChooser.getSelectedFile();
            actualizarImagenEscalada();
        }
    }

    private void actualizarImagenEscalada() {
        if (imagen != null) {
            ImageIcon imageIcon = new ImageIcon(imagen.getAbsolutePath());
            int size = slider.getValue();
            Image scaledImage = imageIcon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
            imagenLabel.setIcon(new ImageIcon(scaledImage));
        }
    }

    private void actualizarCampos(String tipo) {
        dynamicPanel.removeAll();

        JLabel edadLabel = new JLabel("Edad:");
        edadLabel.setForeground(text);
        edadLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        edadField = new JTextField();
        edadField.setMaximumSize(new Dimension(300, 20));
        edadField.setAlignmentX(Component.CENTER_ALIGNMENT);
        edadField.setBackground(mini);
        edadField.setBorder(BorderFactory.createLineBorder(margen));
        edadField.setForeground(Color.WHITE);

        JLabel sexoLabel = new JLabel("Sexo:");
        sexoLabel.setForeground(text);
        sexoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        sexoField = new JTextField();
        sexoField.setMaximumSize(new Dimension(300, 20));
        sexoField.setAlignmentX(Component.CENTER_ALIGNMENT);
        sexoField.setBackground(mini);
        sexoField.setBorder(BorderFactory.createLineBorder(margen));
        sexoField.setForeground(Color.WHITE);

        dynamicPanel.add(edadLabel);
        dynamicPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        dynamicPanel.add(edadField);
        dynamicPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        dynamicPanel.add(sexoLabel);
        dynamicPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        dynamicPanel.add(sexoField);
        dynamicPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        if (tipo.equals("Perro") || tipo.equals("Gato")) {
            JLabel razaLabel = new JLabel("Raza:");
            razaLabel.setForeground(text);
            razaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            razaField = new JTextField();
            razaField.setMaximumSize(new Dimension(300, 20));
            razaField.setAlignmentX(Component.CENTER_ALIGNMENT);
            razaField.setBackground(mini);
            razaField.setBorder(BorderFactory.createLineBorder(margen));
            razaField.setForeground(Color.WHITE);

            dynamicPanel.add(razaLabel);
            dynamicPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            dynamicPanel.add(razaField);
            dynamicPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        } else if (tipo.equals("Pajaro")) {
            JLabel especieLabel = new JLabel("Especie:");
            especieLabel.setForeground(text);
            especieLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            especieField = new JTextField();
            especieField.setMaximumSize(new Dimension(300, 20));
            especieField.setAlignmentX(Component.CENTER_ALIGNMENT);
            especieField.setBackground(mini);
            especieField.setBorder(BorderFactory.createLineBorder(margen));
            especieField.setForeground(Color.WHITE);

            dynamicPanel.add(especieLabel);
            dynamicPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            dynamicPanel.add(especieField);
            dynamicPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        } else if (tipo.equals("Iguana")) {
            JLabel venenoLabel = new JLabel("Veneno:");
            venenoLabel.setForeground(text);
            venenoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            venenoField = new JTextField();
            venenoField.setMaximumSize(new Dimension(300, 20));
            venenoField.setAlignmentX(Component.CENTER_ALIGNMENT);
            venenoField.setBackground(mini);
            venenoField.setBorder(BorderFactory.createLineBorder(margen));
            venenoField.setForeground(Color.WHITE);

            dynamicPanel.add(venenoLabel);
            dynamicPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            dynamicPanel.add(venenoField);
            dynamicPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        } else if (tipo.equals("Hamster")) {
            JLabel colorLabel = new JLabel("Color:");
            colorLabel.setForeground(text);
            colorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            colorField = new JTextField();
            colorField.setMaximumSize(new Dimension(300, 20));
            colorField.setAlignmentX(Component.CENTER_ALIGNMENT);
            colorField.setBackground(mini);
            colorField.setBorder(BorderFactory.createLineBorder(margen));
            colorField.setForeground(Color.WHITE);

            dynamicPanel.add(colorLabel);
            dynamicPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            dynamicPanel.add(colorField);
            dynamicPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        dynamicPanel.revalidate();
        dynamicPanel.repaint();
    }
}
