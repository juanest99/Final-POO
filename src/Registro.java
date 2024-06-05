import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro implements ActionListener {
    private JTextField nombre;
    private JTextField cedula;
    private  JTextField direccion;
    private JTextField telefono;
    private JTextField contraseña;

    public Registro(JTextField nombre, JTextField cedula, JTextField direccion, JTextField telefono, JTextField contraseña){
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contraseña= contraseña;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Ventana2 ventana2 = new Ventana2();
    }

}
