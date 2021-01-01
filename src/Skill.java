public class Skill {
    private final String name;
    private final int skillgroupID;
    private final int basePoints;
    private int actualPoints;

    public Skill(String name, int basePoints, int skillgroupID) {
        this.name = name;
        this.basePoints = basePoints;
        this.skillgroupID = skillgroupID;
    }

    public String getName() {
        return name;
    }

    public int getSkillgroupID() {
        return skillgroupID;
    }

    public int getBasePoints() {
        return basePoints;
    }

    public int getActualPoints() {
        return actualPoints;
    }

    public void setActualPoints(int actualPoints) {
        this.actualPoints = actualPoints;
    }
}
