import java.io.*;

public class GestorSerializacion {

    public static void guardarMascota(Mascota mascota, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo, true))) {
            oos.writeObject(mascota);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
