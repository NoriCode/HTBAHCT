import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceViewer extends JFrame {
    JButton rollInit = new JButton();

    private final List<JLabel> diceNames = new ArrayList<>();
    List<JLabel> diceResult = new ArrayList<>();
    private final List<DiceRolls> diceRolls = new ArrayList<>();
    private final List<JTextField> diceNumbers = new ArrayList<>();

    public DiceViewer() {
        rollInit.setBounds(900, 100, 100, 25);
        rollInit.setText("Würfeln");
        rollInit.addActionListener(e -> rollDice());

        add(rollInit);

        setLayout(null);
        setSize(1600, 900);
        setTitle("Dice Table");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        generateDice();

        //This needs to be the last Code
        setVisible(true);
    }

    private void rollDice() {
        diceRoller(2, Integer.parseInt(diceNumbers.get(0).getText()));
        diceRoller(3, Integer.parseInt(diceNumbers.get(0).getText()));
        diceRoller(4, Integer.parseInt(diceNumbers.get(0).getText()));
        diceRoller(6, Integer.parseInt(diceNumbers.get(0).getText()));
        diceRoller(8, Integer.parseInt(diceNumbers.get(0).getText()));
        diceRoller(10, Integer.parseInt(diceNumbers.get(0).getText()));
        diceRoller(20, Integer.parseInt(diceNumbers.get(0).getText()));
        diceRoller(100, Integer.parseInt(diceNumbers.get(0).getText()));

        printDice();
    }

    private void printDice() {
        JLabel result;
        diceResult.clear();
        for (int i = 0; i < diceRolls.size(); i++) {

            result = new JLabel();
            result.setHorizontalAlignment(SwingConstants.CENTER);
            result.setBounds(diceRolls.get(i).getDiceGroup() * 100, diceRolls.get(i).getDiceGroup()*100, 100, 25);
            result.setText(String.valueOf(diceRolls.get(i).getDiceresult()));

            add(result);
            diceResult.add(result);
        }
    }


    private void diceRoller(int diceSize, int diceCount) {
        Random rand = new Random();
        int position;
        switch (diceSize) {
            case 2 -> position = 0;
            case 3 -> position = 1;
            case 4 -> position = 2;
            case 6 -> position = 3;
            case 8 -> position = 4;
            case 10 -> position = 5;
            case 20 -> position = 6;
            case 100 -> position = 7;
        }
        for (int i = 0; i < diceCount; i++) {
            diceRolls.add(new DiceRolls(diceSize, rand.nextInt(diceSize) + 1));
        }
    }

    private void generateDice() {
        JLabel diceName;
        JTextField numberOfDice;
        String text;
        for (int i = 0; i < 8; i++) {
            diceName = new JLabel();
            diceName.setHorizontalAlignment(SwingConstants.CENTER);
            diceName.setBounds(i * 100, 100, 100, 25);

            numberOfDice = new JTextField();
            numberOfDice.setHorizontalAlignment(SwingConstants.CENTER);
            numberOfDice.setBounds(i * 100, 125, 100, 25);
            numberOfDice.setText("0");

            switch (i) {
                case 0 -> text = "D2";
                case 1 -> text = "D3";
                case 2 -> text = "D4";
                case 3 -> text = "D6";
                case 4 -> text = "D8";
                case 5 -> text = "D10";
                case 6 -> text = "D20";
                case 7 -> text = "D100";
                default -> throw new IllegalStateException("Unexpected value: " + i);
            }

            diceName.setText(text);
            add(diceName);
            add(numberOfDice);

            diceNames.add(diceName);
            diceNumbers.add(numberOfDice);
        }
    }
}
