import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorUsuarios {

    public static boolean verificarUsuario(String nombreTexto, String contraseñaTexto) {
        try (BufferedReader br = new BufferedReader(new FileReader("gente.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(":")) {
                    String nombre = line.split(":")[1].trim();
                    String cedula = br.readLine().split(":")[1].trim();
                    String direccion = br.readLine().split(":")[1].trim();
                    String telefono = br.readLine().split(":")[1].trim();
                    String contraseña = br.readLine().split(":")[1].trim();
                    if (nombre.equals(nombreTexto) && contraseña.equals(contraseñaTexto)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean verificarUsuarioNoRepetido(String nombreTexto) {
        try (BufferedReader br = new BufferedReader(new FileReader("gente.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(":")) {
                    String nombre = line.split(":")[1].trim();
                    String cedula = br.readLine().split(":")[1].trim();
                    String direccion = br.readLine().split(":")[1].trim();
                    String telefono = br.readLine().split(":")[1].trim();
                    String contraseña = br.readLine().split(":")[1].trim();
                    if (nombre.equals(nombreTexto)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static String[] obtenerDatosUsuario(String nombreTexto, String contraseñaTexto) {
        try (BufferedReader br = new BufferedReader(new FileReader("gente.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(":")) {
                    String nombre = line.split(":")[1].trim();
                    if (nombre.equals(nombreTexto)) {
                        String cedula = br.readLine().split(":")[1].trim();
                        String direccion = br.readLine().split(":")[1].trim();
                        String telefono = br.readLine().split(":")[1].trim();
                        String contraseña = br.readLine().split(":")[1].trim();
                        if (contraseña.equals(contraseñaTexto)) {
                            return new String[]{nombre, cedula, direccion, telefono};
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}