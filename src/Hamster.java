import javax.swing.*;
import java.io.File;

public class Hamster extends Mascota{
    private String color;
    public Hamster(String nombre, String edad, String sexo, File imagen, String color){
        super(nombre,edad,sexo,imagen);
        this.color = color;
    }

    @Override
    public void mostrarDatos() {
        String mensaje = "Nombre: " + getNombre() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "Sexo: " + getSexo() + "\n" +
                "Color: " + color + "\n";
        JOptionPane.showMessageDialog(null, mensaje, "Datos del Hamster", JOptionPane.INFORMATION_MESSAGE);
    }
    @Override
    public void setData() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre", getNombre());
        String edad = JOptionPane.showInputDialog(null, "Edad", getEdad());
        String sexo = JOptionPane.showInputDialog(null, "Sexo", getSexo());
        String color = JOptionPane.showInputDialog(null,"Color", this.color);

        if (nombre != null) this.nombre = nombre;
        if (edad != null) this.edad = edad;
        if (sexo != null) this.sexo = sexo;

    }
}
