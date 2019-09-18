/*
 * Sample code for CS 321 at UAH
 * You can use this code if you modify it
 * or if you indicate that this is the original source.
 * Fall Semester 2019
 */
package dicegame;

import java.util.Random;

/**
 * A class that models a die (singular of dice). Allows the die to have an
 * arbitrary number of sides. By default the face numbering for the sides begins
 * with 1.
 *
 * @author drochowi Dan Rochowiak, CS321, Fall 2019
 */
public class Die {

    // A state or field variable to hold the number of sides for the die.
    // This is a private field which means that it cannot be accessed from 
    // outside of this class. The field is of the primitive type int.
    private int numberOfSides;

    // A private state or field to hole the current value of the die. 
    // Initialized to 0. This is an illegal value.
    // It will be corrected when the die is rolled to a legal value.
    private int currentValue = 0;

    // Private state or field to hold the minum value for the die.
    private int minValue;

    // Random generator class will be used in the second phaswe of this example.
    private Random randomGenerator = new Random();

    /**
     * Construct a dice object given the number of sides and a starting value
     * for the number of faces on the die.
     *
     * @param sides int representing the number of sides for the die
     * @param min int representing the starting value for numbering the sides
     */
    public Die(final int sides, final int min) {
        // Note that the object will be initialized to an illegal current value.
        numberOfSides = sides;
        minValue = min;
    }

    /**
     * Rolls the die to generate a new current value for the die face.
     */
    public void rollDie() {
        //Initial effort
        //currentValue = (int) (Math.random() * (((numberOfSides - minValue) + 1)) + minValue);
        // Used in example second phase
        // The following is incorrect
        //currentValue = randomGenerator.nextInt((((numberOfSides - minValue) + 1) + minValue));
        // A correct step by step approach
        //int bound = ((numberOfSides - minValue) + 1);
        // The best way
        int bound = numberOfSides;
        int rand = randomGenerator.nextInt(bound);
        // If you want a better look
        //System.out.println("Bound: " + bound + " rand: " + rand);
        currentValue = rand + minValue;
        //System.out.println("Current value: " + currentValue);
    }

    /**
     * Gets the current value
     * @return int representing current value of a die
     */
    public int getCurrentValue() {
        if (currentValue == 0) {
            rollDie();
        }
        return currentValue;
    }

}
