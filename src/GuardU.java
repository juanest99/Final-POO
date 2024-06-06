import javax.swing.*;
import java.io.*;

public class GuardU {

    public static void guardarDatos(String a) throws IOException {
        FileWriter writer = new FileWriter("gente.txt", true); // 'true' para añadir datos al archivo
        writer.write(a + "\n");
        writer.close();
        System.out.println(a);
        JOptionPane.showMessageDialog(null, "Datos guardados exitosamente");
    }
}
