import java.io.File;

public class Perro extends Mascota{
    private String raza;
    public Perro(String nombre, String edad, String sexo, File imagen, String raza){
        super(nombre,edad,sexo,imagen);
        this.raza = raza;
    }
}
