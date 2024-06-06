import java.io.File;

public class Iguana extends Mascota{
    private String veneno;
    public Iguana(String nombre, String edad, String sexo, File imagen, String veneno){
        super(nombre,edad,sexo,imagen);
        this.veneno = veneno;
    }
}
