import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
        charactertest();
        System.out.println(diceRoller(2));
        System.out.println(diceRoller(3));
        System.out.println(diceRoller(4));
        System.out.println(diceRoller(6));
        System.out.println(diceRoller(8));
        System.out.println(diceRoller(10));
        System.out.println(diceRoller(20));
        System.out.println(diceRoller(100));
        */
        DiceViewer dice = new DiceViewer();
    }

    private static int diceRoller(int diceSize) {
        Random rand = new Random();
        return rand.nextInt(diceSize) + 1;
    }

    private static void charactertest() throws IOException {
        List<Skill> skills = new ArrayList<>();
        String[] lineText;

        BufferedReader br = new BufferedReader(new FileReader("F:\\Programmierkram\\HTBAHCT\\src\\testCharacter.txt"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            lineText = line.split(" ");

            skills.add(new Skill(lineText[0], Integer.parseInt(lineText[1]), Integer.parseInt(lineText[2])));
        }
        br.close();

        Hero hero = new Hero("klaus", "keiner", "ledig", 'm', 2, 2, 2, skills);
        hero.addItemToInventory("gun");
        hero.addItemToInventory("gun");
        hero.addItemToInventory("gun");
        hero.addItemToInventory("gun");
        hero.addItemToInventory("gun");

        //JFrame fenster = new Gui();
    }
}
