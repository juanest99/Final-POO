import java.io.File;

public class Hamster extends Mascota{
    private String color;
    public Hamster(String nombre, String edad, String sexo, File imagen, String color){
        super(nombre,edad,sexo,imagen);
        this.color = color;
    }
}
