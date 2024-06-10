import java.io.*;

public class GestorSerializacion {

    public static void guardarMascota(Mascota mascota, String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo, true))) {
            oos.writeObject(mascota);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Mascota cargarMascota(String archivo) {
        Mascota mascota = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            mascota = (Mascota) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mascota;
    }
}
