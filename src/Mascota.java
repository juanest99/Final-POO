import javax.swing.*;
import java.io.File;
import java.io.Serializable;

public abstract class Mascota implements Serializable {
    protected String nombre;
    protected String edad;
    protected String sexo;
    protected File imagen;
    protected String diaBaño;
    protected String diaEntrenar;
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
    public String getDiaBaño() {
        return diaBaño;
    }

    public void setDiaBaño(String diaBaño) {
        this.diaBaño = diaBaño;
    }

    public String getDiaEntrenar() {
        return diaEntrenar;
    }

    public void setDiaEntrenar(String diaEntrenar) {
        this.diaEntrenar = diaEntrenar;
    }
    // Getters
    public String getNombre() { return nombre; }
    public String getEdad() { return edad; }
    public String getSexo() { return sexo; }
    public String getImagen() { return imagen.getAbsolutePath(); }
}
