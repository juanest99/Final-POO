import javax.swing.*;
import java.io.File;
import java.io.Serializable;

public abstract class Mascota implements Serializable {
    protected String nombre;
    protected String edad;
    protected String sexo;
    protected File imagen;

    public Mascota(String nombre,String edad, String sexo,File imagen) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.imagen = imagen;
    }

    public void mostrarDatos() {
        String mensaje = "Nombre: " + nombre + "\n" +
                "Edad: " + edad + "\n" +
                "Sexo: " + sexo + "\n";
        JOptionPane.showMessageDialog(null, mensaje, "Datos de la mascota", JOptionPane.INFORMATION_MESSAGE);
    }

    public abstract void setData();

    // Getters
    public String getNombre() { return nombre; }
    public String getEdad() { return edad; }
    public String getSexo() { return sexo; }
    public String getImagen() { return imagen.getAbsolutePath(); }
}
