import java.io.File;

public class Gato extends  Mascota{
    private String raza;
    public Gato(String nombre, String edad, String sexo, File imagen, String raza){
        super(nombre,edad,sexo,imagen);
        this.raza = raza;
    }
}
