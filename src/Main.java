import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //temporary code for testing
        List<String> input = new ArrayList<>();
        List <Skill> skills = new ArrayList<>();
        String[] lineText;

        BufferedReader br = new BufferedReader(new FileReader("F:\\Programmierkram\\HTBAHCT\\src\\testCharacter.txt"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            input.add(line);
            lineText = line.split(" ");

            skills.add(new Skill(lineText[0],Integer.parseInt(lineText[1]),Integer.parseInt(lineText[2])));
        }
        br.close();

        Hero hero = new Hero("klaus", "keiner",  "ledig",  'm',  2,  2,  2,skills);
        hero.addItemToInventory("gun");
        hero.addItemToInventory("gun");
        hero.addItemToInventory("gun");
        hero.addItemToInventory("gun");
        hero.addItemToInventory("gun");
    }
}
