import javax.swing.*;
import java.awt.*;

public class GUITest {

    public static void main(String[] args) {
        new GUITest();
    }

    public GUITest() {
        EventQueue.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            JFrame frame = new JFrame("Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.setLayout(new BorderLayout());
            frame.add(new CheckBoxTablePanel(10));

            frame.setSize(800,500);
            //frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }
}