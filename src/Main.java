import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //charactertest();
        System.out.println(diceroller(2));
        System.out.println(diceroller(3));
        System.out.println(diceroller(4));
        System.out.println(diceroller(6));
        System.out.println(diceroller(8));
        System.out.println(diceroller(10));
        System.out.println(diceroller(20));
        System.out.println(diceroller(100));
    }

    private static int diceroller(int diceSize) {
        long systemTime = System.currentTimeMillis();
        long random0 = (long) (Math.random() * 1000000000);
        long random1 = (long) (Math.random() * 1000000000);
        long random2 = (long) (Math.random() * 1000000000);
        long random3 = (long) (Math.random() * 1000000000);
        long random4 = (long) (Math.random() * 1000000000);

        long value1 = systemTime - random0 - random1 - random2 - random3 - random4;
        long value2 = systemTime - value1 - random2 - random4;

        value1 *= Math.random() * 10;
        value2 *= Math.random() * 10;

        return (int) (((value1 % diceSize + value2 % diceSize) % diceSize) + 1);
    }

    private static void charactertest() throws IOException {
        //temporary code for testing
        List<String> input = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();
        String[] lineText;

        BufferedReader br = new BufferedReader(new FileReader("F:\\Programmierkram\\HTBAHCT\\src\\testCharacter.txt"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            input.add(line);
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
