public class DiceTestArea { public static void main(String[] args){
    resulter(2);
    resulter(3);
    resulter(4);
    resulter(6);
    resulter(8);
    resulter(10);
    resulter(20);
    resulter(100);

}

    private static void resulter(int input) {
        System.out.println("Dice: d" + input);
        int[] results = new int[100];

        for (int j = 0; j < 100; j++) {
            results[j] = 0;
        }

        for (int i = 0; i < 1000; i++) {
            int dice = diceroller(input);
            for (int j = 1; j <= input; j++) {
                if (j == dice) {
                    results[j - 1]++;
                }
            }
        }

        for (int i = 0; i < input; i++) {
            System.out.println("Number: " +(i+1) +" rolled " + results[i]+" times");
        }
    }

    private static int diceroller(int diceIn) {
        int dice;
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
        dice = (int) (((value1 % diceIn + value2 % diceIn) % diceIn) + 1);
        return dice;

    }
}
