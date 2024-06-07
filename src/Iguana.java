import javax.swing.*;
import java.io.File;

public class Iguana extends Mascota{
    private String veneno;
    public Iguana(String nombre, String edad, String sexo, File imagen, String veneno){
        super(nombre,edad,sexo,imagen);
        this.veneno = veneno;
    }
    @Override
    public void mostrarDatos() {
        String mensaje = "Nombre: " + getNombre() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "Sexo: " + getSexo() + "\n" +
                "Veneno: " + veneno + "\n";
        JOptionPane.showMessageDialog(null, mensaje, "Datos de la iguana", JOptionPane.INFORMATION_MESSAGE);
    }
    @Override
    public void setData() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre", getNombre());
        String edad = JOptionPane.showInputDialog(null, "Edad", getEdad());
        String sexo = JOptionPane.showInputDialog(null, "Sexo", getSexo());
        String veneno = JOptionPane.showInputDialog(null,"Veneno", this.veneno);

        if (nombre != null) this.nombre = nombre;
        if (edad != null) this.edad = edad;
        if (sexo != null) this.sexo = sexo;
        if(veneno != null) this.veneno = veneno;
    }
}
