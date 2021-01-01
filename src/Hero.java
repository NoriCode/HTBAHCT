import java.util.*;

public class Hero {
    private final String name;
    private final String job;
    private final String familyStatus;

    private final char sex;

    private final int age;
    private int hp;
    private final int size;
    private final int weight;

    /*  0 = interaction
        1 = knowledge
        2 = social
     */
    private final List<Integer> skillGroupPoints = new ArrayList<>();

    private List<String> inventory = new ArrayList<>();

    private final List<Skill> skills;
    private final List<List<Skill>> skillsSorted = new ArrayList<>();


    private final int[] bodyPartHP;

    public Hero(String name, String job, String familyStatus, char sex, int age, int size, int weight, List<Skill> skills) {
        this.name = name;
        this.job = job;
        this.familyStatus = familyStatus;
        this.sex = sex;
        this.age = age;
        this.size = size;
        this.weight = weight;

        this.hp = 100;
        this.bodyPartHP = new int[]{20, 20, 20, 20, 20, 60};

        this.skills = skills;


        calculateSkillGroups();
        calculateActualSkillpoints();
        sortSkills();
        //printSkills();
    }

    public void addItemToInventory(String item) {
        this.inventory.add(item);
    }

    public void calculateHp() {
        for (int bodyPart : bodyPartHP) {
            this.hp = this.hp + bodyPart;
        }
        if (this.hp > 100) {
            this.hp = 100;
        }
    }

    private void calculateSkillGroups() {
        int[] groupPoints = new int[]{0, 0, 0};
        for (Skill skill : skills) {
            groupPoints[skill.getSkillgroupID()] += (skill.getBasePoints());
        }
        for (int i = 0; i < 3; i++) {
            this.skillGroupPoints.add(groupPoints[i] / 10);
        }
    }

    private void calculateActualSkillpoints() {
        for (Skill skill : skills) {
            skill.setActualPoints(skill.getBasePoints() + skillGroupPoints.get(skill.getSkillgroupID()));
        }
    }

    private void sortSkills() {
        List<Skill> tempSkill = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (Skill skill : skills) {
                if (skill.getSkillgroupID() == i) {
                    tempSkill.add(skill);
                }
            }
            skillsSorted.add(tempSkill);
        }
    }

    private void printSkills() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " " + skillGroupPoints.get(i));
            for (Skill skill : skillsSorted.get(i)) {
                if (skill.getSkillgroupID() == i) {
                    System.out.println(skill.getName() + " " + skill.getActualPoints());
                }
            }
        }
    }

    public void printInventory() {
        for (String item : inventory) {
            System.out.println(item);
        }
    }
}
