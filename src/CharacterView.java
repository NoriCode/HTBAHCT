import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterView extends JFrame {

    List<JLabel> healthpoints = new ArrayList<>();
    List<JLabel> healthpointsText = new ArrayList<>();
    List<JLabel> skillGroups = new ArrayList<>();
    List<JLabel> interactionSkills = new ArrayList<>();
    List<JLabel> knowledgeSkills = new ArrayList<>();
    List<JLabel> socialSkills = new ArrayList<>();
    List<JLabel> interactionSkillsBasePoints = new ArrayList<>();
    List<JLabel> knowledgeSkillsBasePoints = new ArrayList<>();
    List<JLabel> socialSkillsBasePoints = new ArrayList<>();
    List<JLabel> interactionSkillsActualPoints = new ArrayList<>();
    List<JLabel> knowledgeSkillsActualPoints = new ArrayList<>();
    List<JLabel> socialSkillsActualPoints = new ArrayList<>();

    Hero myHero;

    public CharacterView(Hero myHero) {
        this.myHero = myHero;

        setLayout(null);
        setVisible(true);
        setSize(1600, 900);
        setTitle(this.myHero.getName());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        generateHealtpointView();
        skillGroupView();
        generateSkillView();
    }

    private void skillGroupView() {
        JLabel skillGroup, skillGroupPoints;
        String name, points;
        for (int i = 0; i < 3; i++) {
            skillGroup = new JLabel();
            skillGroup.setHorizontalAlignment(SwingConstants.CENTER);
            skillGroup.setBounds(i * 200, 150, 100, 25);
            skillGroup.setBackground(Color.white);

            skillGroupPoints = new JLabel();
            skillGroupPoints.setHorizontalAlignment(SwingConstants.LEFT);
            skillGroupPoints.setBounds(i * 200 + 200, 150, 100, 25);

            switch (i) {
                case 0 -> {
                    name = "Handeln";
                    points = String.valueOf(this.myHero.getSkillGroupPoints().get(0));
                }
                case 1 -> {
                    name = "Wissen ";
                    points = String.valueOf(this.myHero.getSkillGroupPoints().get(1));
                }
                case 2 -> {
                    name = "Soziales";
                    points = String.valueOf(this.myHero.getSkillGroupPoints().get(2));
                }
                default -> throw new IllegalStateException("Unexpected value: " + i);
            }

            skillGroup.setText(name);
            skillGroupPoints.setText(points);

            add(skillGroup);
            add(skillGroupPoints);

            healthpoints.add(skillGroup);
            healthpointsText.add(skillGroupPoints);
        }
    }

    private void generateSkillView() {
        int skillGroupId;
        JLabel skillname, skillBasePoints, skillActualPoints;
        String name, basePoints, actualPoints;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < this.myHero.getSkillsSorted().get(i).size(); j++) {
                skillGroupId = this.myHero.getSkills().get(j).getSkillgroupID();

                skillname = new JLabel();
                skillname.setHorizontalAlignment(SwingConstants.CENTER);
                skillname.setBounds(i * 200, 175 + j * 25, 100, 25);

                skillBasePoints = new JLabel();
                skillBasePoints.setHorizontalAlignment(SwingConstants.LEFT);
                skillBasePoints.setBounds(i * 200 + 100, 175 + j * 25, 100, 25);

                skillActualPoints = new JLabel();
                skillActualPoints.setHorizontalAlignment(SwingConstants.LEFT);
                skillActualPoints.setBounds(i * 200 + 200, 175 + j * 25, 100, 25);

                name = this.myHero.getSkillsSorted().get(i).get(j).getName();
                basePoints = String.valueOf(this.myHero.getSkillsSorted().get(i).get(j).getBasePoints());
                actualPoints = String.valueOf(this.myHero.getSkillsSorted().get(i).get(j).getActualPoints());

                skillname.setText(name);
                skillBasePoints.setText(basePoints);
                skillBasePoints.setText(actualPoints);

                add(skillname);
                add(skillBasePoints);
                add(skillActualPoints);

                switch (i) {
                    case 0 -> {
                        interactionSkills.add(skillname);
                        interactionSkillsBasePoints.add(skillBasePoints);
                        interactionSkillsActualPoints.add(skillActualPoints);
                    }
                    case 1 -> {
                        knowledgeSkills.add(skillname);
                        knowledgeSkillsBasePoints.add(skillBasePoints);
                        knowledgeSkillsActualPoints.add(skillActualPoints);
                    }
                    case 2 -> {
                        socialSkills.add(skillname);
                        socialSkillsBasePoints.add(skillBasePoints);
                        socialSkillsActualPoints.add(skillActualPoints);
                    }
                }
            }

        }
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


            hpText.setText(text);
            add(hpText);
            add(hpCounter);

            healthpoints.add(hpCounter);
            healthpointsText.add(hpText);
        }
    }


}
