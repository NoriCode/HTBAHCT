import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Gui extends JFrame {

    List<JTextField> interactionSkills = new ArrayList<>();
    List<JTextField> knowledgeSkills = new ArrayList<>();
    List<JTextField> socialSkills = new ArrayList<>();



    public Gui() {
        setLayout(null);
        setVisible(true);
        setSize(400, 400);
        setTitle("Titel des Fensters");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(Color.WHITE);
    }
}