/**
 * @author Jeff Schmidt
 * Dicetester.java
 * Just for testing the Dice class
 * To use dice, use Dice(number of dice, sides) constructor
 *  roll() returns single int
 *  rollAll() returns int array of all dice
 */
public class Dicetester {
    public static void main(String args[]) {
        System.out.println("Test 2 D6:");
        //test 2 dice, 6 sides
        Dice diceTest = new Dice(2, 6);
        System.out.printf("One roll: ");
        System.out.println(diceTest.roll());
        System.out.printf("Roll all: ");
        //roll the pair of dice into int array
        int[] pairDice = diceTest.rollAll();
        System.out.printf("\nDice 1: " + pairDice[0] + "\nDice 2: " + pairDice[1]);

        Dice diceTest2 = new Dice(1, 20);
        System.out.println("\n\nTest 1 D20:");
        //test 1 d20
        System.out.printf("First roll: ");
        System.out.println(diceTest2.roll());
        System.out.printf("Second roll: ");
        System.out.println(diceTest2.roll());

        Dice diceTest3 = new Dice(5, 6);
        System.out.println("\n\nTest 5 D6: ");
        //test 5 D6
        //get int array of the dice
        int[] yahtzee = diceTest3.rollAll();
        //check for yahtzee
        if(yahtzee(yahtzee))
            System.out.println("YAHTZEE!");
        for (int i = 0; i < yahtzee.length; i++) {
            System.out.printf("Result " + i + " : " + yahtzee[i] + "\n");
        }
    }
        public static boolean yahtzee(int[] y)
        {
            for(int i = 1; i < y.length; i++) {
                if(y[0] != y[i])
                    return false;
            }
            return true;
        }




    }

