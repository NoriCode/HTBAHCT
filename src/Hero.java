import java.util.*;

public class Hero {
    private CharacterView overView;

    private final String name;
    private final String job;
    private final String familyStatus;

    private final char sex;

    private final int age;
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
        //arm arm leg leg head torso HP
        this.bodyPartHP = new int[]{100, 20, 20, 20, 60, 20, 20};

        this.skills = skills;


        calculateSkillGroups();
        calculateActualSkillpoints();
        sortSkills();
        //printSkills();
        overView = new CharacterView(this);
    }

    public void addItemToInventory(String item) {
        this.inventory.add(item);
    }

    public void calculateHp() {
        int testsum = 0;
        for (int i = 1; i < 7; i++) {
            testsum += bodyPartHP[i];
        }
        if(testsum!=160){
            testsum = 160-testsum;
        }
        this.bodyPartHP[0]= this.bodyPartHP[0]-testsum;
    }

    public int[] getBodyPartHP(){
        return bodyPartHP;
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
