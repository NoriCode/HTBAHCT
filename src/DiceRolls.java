public class DiceRolls {
    private int diceGroup;
    private int diceresult;

    public DiceRolls(int diceGroup, int diceresult) {
        this.diceGroup = diceGroup;
        this.diceresult = diceresult;
    }

    public int getDiceGroup() {
        return diceGroup;
    }

    public int getDiceresult() {
        return diceresult;
    }
}
