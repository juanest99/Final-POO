import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.List;

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

        String[] datosUsuario = LectorUsuarios.obtenerDatosUsuario(nombreTexto, contraseñaTexto);
        if (datosUsuario != null) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
            VentanaMain ventana = new VentanaMain();
            ventana.mostrarDatos(datosUsuario[0], datosUsuario[1], datosUsuario[2], datosUsuario[3]);
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
        }
    }
}