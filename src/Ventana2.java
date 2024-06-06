import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.security.Guard;

public class Ventana2 extends JFrame {
    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194,190,212);
    Color mini = new Color(46,43,65);
    Color margen = new Color(106,97,148);
    Color boton = new Color(30,27,41);
    public Ventana2() {
        setTitle("Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(fondo);
        iniciar();
        setVisible(true);
    }
    private void iniciar() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Usar BoxLayout en eje Y
        panel.setBackground(fondo);

        JLabel name = new JLabel("Nombre");
        name.setForeground(text);
        name.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el label


        JTextField nombre = new JTextField();
        nombre.setMaximumSize(new Dimension(300, 20)); // Ajustar el tamaño máximo
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el campo de texto
        nombre.setBackground(mini);
        nombre.setBorder(BorderFactory.createLineBorder(margen));
        nombre.setForeground(Color.WHITE);

        JLabel pass = new JLabel("Contraseña");
        pass.setForeground(text);
        pass.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField contraseña = new JTextField();
        contraseña.setMaximumSize(new Dimension(300, 20));
        contraseña.setAlignmentX(Component.CENTER_ALIGNMENT);
        contraseña.setBackground(mini);
        contraseña.setBorder(BorderFactory.createLineBorder(margen));
        contraseña.setForeground(Color.WHITE);

        JLabel cedula = new JLabel("Cedula");
        cedula.setForeground(text);
        cedula.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el label


        JTextField documentos = new JTextField();
        documentos.setMaximumSize(new Dimension(300, 20)); // Ajustar el tamaño máximo
        documentos.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el campo de texto
        documentos.setBackground(mini);
        documentos.setBorder(BorderFactory.createLineBorder(margen));
        documentos.setForeground(Color.WHITE);

        JLabel direc = new JLabel("Direccion");
        direc.setForeground(text);
        direc.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField lugar = new JTextField();
        lugar.setMaximumSize(new Dimension(300, 20));
        lugar.setAlignmentX(Component.CENTER_ALIGNMENT);
        lugar.setBackground(mini);
        lugar.setBorder(BorderFactory.createLineBorder(margen));
        lugar.setForeground(Color.WHITE);

        JLabel phone = new JLabel("Telefono");
        phone.setForeground(text);
        phone.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField celular = new JTextField();
        celular.setMaximumSize(new Dimension(300, 20));
        celular.setAlignmentX(Component.CENTER_ALIGNMENT);
        celular.setBackground(mini);
        celular.setBorder(BorderFactory.createLineBorder(margen));
        celular.setForeground(Color.WHITE);

        JButton registrar = new JButton("Registrar");
        registrar.setForeground(text);
        registrar.setBorder(BorderFactory.createLineBorder(margen));
        registrar.setBackground(boton);
        Dimension buttonSize = new Dimension(100, 30);
        registrar.setMinimumSize(buttonSize);
        registrar.setPreferredSize(buttonSize);
        registrar.setMaximumSize(buttonSize);
        registrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        registrar.addActionListener(e -> {
            try {
                Registro registro = new Registro(nombre, documentos, lugar, celular, contraseña);
                if(registro.getDatos().equals("Fail")){
                    JOptionPane.showMessageDialog(null,"Llena todos los campos");
                } else if (registro.getDatos().equals("Rep")) {
                    JOptionPane.showMessageDialog(null, "Este usuario ya se encuentra registrado");
                } else {
                    GuardU.guardarDatos(registro.getDatos());
                    registro.limpiarCampos();
                    dispose();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        panel.add(Box.createVerticalGlue());
        panel.add(name);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre componentes
        panel.add(nombre);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(pass);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(contraseña);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(cedula);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(documentos);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(direc);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lugar);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(phone);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(celular);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(registrar);
        panel.add(Box.createRigidArea(new Dimension(0,10)));

        panel.add(Box.createVerticalGlue());

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.WEST);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.EAST);

    }
}

