import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Gui extends JFrame {

    List<JTextField> interactionSkills = new ArrayList<>();
    List<JTextField> knowledgeSkills = new ArrayList<>();
    List<JTextField> socialSkills = new ArrayList<>();



    public Gui() {
        int counter = 1;
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

/*
    public List<Skill> getInteractionSkills() {
        return generateSkillList(interactionSkills,0);
    }

    public List<Skill> getKnowledgeSkills() {
        return generateSkillList(knowledgeSkills,1);
    }

    public List<Skill> getSocialSkills() {
        return generateSkillList(socialSkills,2);
    }

    private List<Skill> generateSkillList(List<JTextField> skills, int skillgroup) {
        List<Skill> skillList = new ArrayList<>();

        for (JTextField skillname : skills) {
            skillList.add(new Skill(skillname.getText(),0, skillgroup));
        }

        return skillList;
    }

 */
}