/**
 * @author Jeff Schmidt
 * Dice.java
 * Creates dice as necessary for the games, need to be rolled each time
 *  to get new results to return
 */

import java.util.Random;

public class Dice {

    Random random = new Random();

    private static int numDice = 0; //number of dice
    private static int numFace = 0; //number of faces on the die

    /**
     * construct a die
     * @param sides number of sides on the dice
     */
    public Dice(int dice, int sides) {
        numDice = dice;
        numFace = sides;
        this.roll();
    }
    /**
     * Roll a die
     * @return a rolled dice
     */
    public int roll() {
        //roll a die
        return random.nextInt(numFace) + 1;
    }

    /**
     * Roll all dice and store results
     */
    public int[] rollAll() {
        int results[] = new int[numDice]; //array to store results of rolls
        //for each die, make a roll and store in array
        for(int i = 0; i < numDice; i++) {
            int result = roll();
            results[i] = result;
        }
        return results;
    }

}
