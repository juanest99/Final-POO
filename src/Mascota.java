import java.io.File;
import java.io.Serializable;
import java.util.jar.JarOutputStream;

public class Mascota implements Serializable {
    private String nombre;
    private String edad;
    private String sexo;
    private File imagen;

    public Mascota(String nombre,String edad, String sexo,File imagen) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.imagen = imagen;
    }
    // Getters
    public String getNombre() { return nombre; }
    public String getEdad() { return edad; }
    public String getSexo() { return sexo; }

    public String getImagen() {
        return imagen.getAbsolutePath();
    }

    public String getInfo() {
        // Devuelve la información de la mascota como una cadena.
        // Modifica esto para que se ajuste a tus necesidades.
        return "Nombre: " + nombre;
    }


}