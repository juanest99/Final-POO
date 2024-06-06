import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro implements ActionListener {
    private JTextField nombre;
    private JTextField cedula;
    private JTextField direccion;
    private JTextField telefono;
    private JTextField contraseña;


    public Registro(JTextField nombre, JTextField cedula, JTextField direccion, JTextField telefono, JTextField contraseña){
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contraseña= contraseña;
    }
    public void limpiarCampos() {
        nombre.setText("");
        cedula.setText("");
        direccion.setText("");
        telefono.setText("");
        contraseña.setText("");

        nombre.getParent().revalidate();
        nombre.getParent().repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Ventana2 ventana2 = new Ventana2();
    }
    public String getDatos(){

        if (LectorUsuarios.verificarUsuarioNoRepetido(nombre.getText())){
            return "Rep";
        }
        if(nombre.getText().isEmpty() || cedula.getText().isEmpty() || direccion.getText().isEmpty() ||telefono.getText().isEmpty()
        ||contraseña.getText().isEmpty() || LectorUsuarios.verificarUsuarioNoRepetido(nombre.getText())){

            return "Fail";
        }
        String data ="";
        data += "Nombre:"+nombre.getText();
        data += "\nCedula:"+cedula.getText();
        data += "\nDireccion:"+direccion.getText();
        data += "\nTelefono:"+telefono.getText();
        data += "\nContraseña:"+ contraseña.getText();
        data +="\n";
        return data;
    }

}
