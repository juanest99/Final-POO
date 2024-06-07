import javax.swing.*;
import java.io.File;

public class Pajaro extends Mascota{
    private String especie;

    public Pajaro(String nombre, String edad, String sexo, File imagen, String especie){
        super(nombre, edad, sexo, imagen);
        this.especie = especie;
    }

    @Override
    public void mostrarDatos() {
        String mensaje = "Nombre: " + getNombre() + "\n" +
                "Edad: " + getEdad() + "\n" +
                "Sexo: " + getSexo() + "\n" +
                "Especie: " + especie + "\n";
        JOptionPane.showMessageDialog(null, mensaje, "Datos del pájaro", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void setData() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre", getNombre());
        String edad = JOptionPane.showInputDialog(null, "Edad", getEdad());
        String sexo = JOptionPane.showInputDialog(null, "Sexo", getSexo());
        String especie = JOptionPane.showInputDialog(null, "Especie", this.especie);

        if (nombre != null) this.nombre = nombre;
        if (edad != null) this.edad = edad;
        if (sexo != null) this.sexo = sexo;
        if (especie != null) this.especie = especie;
    }
}
