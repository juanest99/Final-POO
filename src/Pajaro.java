import java.io.File;

public class Pajaro extends Mascota{
    private String especie;
    public Pajaro(String nombre, String edad, String sexo, File imagen, String especie){
        super(nombre,edad,sexo,imagen);
        this.especie=especie;
    }
}
