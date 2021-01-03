import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterView extends JFrame {

    List<JLabel> healthpoints = new ArrayList<>();
    List<JLabel> healthpointsText = new ArrayList<>();
    Hero myHero;

    JPanel hpView = new JPanel();

    public CharacterView(Hero myHero) {
        this.myHero = myHero;

        setLayout(null);
        setVisible(true);
        setSize(1600, 900);
        setTitle("Titel des Fensters");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(Color.WHITE);

        generateHealtpointView();
    }

    private void generateHealtpointView() {

        JLabel hpText, hpCounter;
        String text;
        for (int i = 0; i < 7; i++) {
            hpText = new JLabel();
            hpText.setHorizontalAlignment(SwingConstants.CENTER);
            hpText.setBounds(i * 100, 25, 100, 25);

            hpCounter = new JLabel();
            hpCounter.setHorizontalAlignment(SwingConstants.CENTER);
            hpCounter.setBounds(i * 100, 50, 100, 25);

            switch (i) {
                case 0 -> {
                    text = "HP";
                }
                case 1 -> {
                    text = "Head ";
                }
                case 2 -> {
                    text = "Left Arm";
                }
                case 3 -> {
                    text = "Left Leg";
                }
                case 4 -> {
                    text = "Torso";
                }
                case 5 -> {
                    text = "Right Arm";
                }
                case 6 -> {
                    text = "Right Leg";
                }
                default -> throw new IllegalStateException("Unexpected value: " + i);
            }

            hpCounter.setText(String.valueOf(myHero.getBodyPartHP()[i]));

            healthpoints.add(hpCounter);

            hpText.setText(text);
            add(hpText);
            add(hpCounter);

            healthpointsText.add(hpText);
        }
    }


}
