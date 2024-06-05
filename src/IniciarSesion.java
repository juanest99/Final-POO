
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IniciarSesion implements ActionListener {
    private JTextField nombre;
    private JTextField contraseña;

    public IniciarSesion(JTextField nombre, JTextField contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombreTexto = nombre.getText();
        String contraseñaTexto = contraseña.getText();
        JOptionPane.showMessageDialog(null, "Nombre: " + nombreTexto + "\nContraseña: " + contraseñaTexto);
    }
}

