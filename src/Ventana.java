import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194,190,212);
    Color mini = new Color(46,43,65);
    Color margen = new Color(106,97,148);
    Color boton = new Color(30,27,41);
    public Ventana() {
        setTitle("Guarderia de masacotas xd");
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

        JButton inicio = new JButton("Iniciar sesión");
        inicio.setForeground(text);
        inicio.setBorder(BorderFactory.createLineBorder(margen));
        inicio.setBackground(boton);
        inicio.setPreferredSize(new Dimension(100, 30));
        inicio.setAlignmentX(Component.CENTER_ALIGNMENT);


        panel.add(Box.createVerticalGlue());
        panel.add(name);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre componentes
        panel.add(nombre);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(pass);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(contraseña);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(inicio);
        panel.add(Box.createRigidArea(new Dimension(0,10)));

        panel.add(Box.createVerticalGlue());

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.WEST);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.EAST);

         }

}
