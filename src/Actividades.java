import javax.swing.*;
import java.awt.*;

public class Actividades extends JFrame {
    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194, 190, 212);
    Color mini = new Color(46, 43, 65);
    Color margen = new Color(106, 97, 148);
    Color boton = new Color(30, 27, 41);
    public Actividades() {
        setTitle("Actividades");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(fondo);

        setVisible(true);
    }
}
