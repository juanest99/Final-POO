import javax.swing.*;
import java.io.File;

public class Perro extends Mascota{
    private String raza;
    public Perro(String nombre, String edad, String sexo, File imagen, String raza){
        super(nombre,edad,sexo,imagen);
        this.raza = raza;
    }
    @Override
    public void mostrarDatos() {
        String mensaje = "Nombre: " + getNombre() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "Sexo: " + getSexo() + "\n" +
                "Raza: " + raza + "\n";
        JOptionPane.showMessageDialog(null, mensaje, "Datos del perro", JOptionPane.INFORMATION_MESSAGE);
    }
    @Override
    public void setData() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre", getNombre());
        String edad = JOptionPane.showInputDialog(null, "Edad", getEdad());
        String sexo = JOptionPane.showInputDialog(null, "Sexo", getSexo());
        String raza = JOptionPane.showInputDialog(null, "Raza", this.raza);

        if (nombre != null) this.nombre = nombre;
        if (edad != null) this.edad = edad;
        if (sexo != null) this.sexo = sexo;
        if (raza != null) this.raza = raza;
    }

}
