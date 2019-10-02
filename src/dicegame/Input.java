/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

import java.util.Scanner;

/**
 * Class that contains static methods that allow for input from the GUI
 * @author Wesley
 */
public class Input {
        
    /**
     *
     * @param in Scanner object for input
     * @return returns int for number of sides
     */
    public static int getNumberOfSides(String in){
        int numberOfSides = InputValidation.parseNumberOfSides(in);      
        return numberOfSides;
    }
    

    /**
     *
     * @param in Scanner object for input
     * @return int for number of sides
     */
    public static int getNumberOfDice(String in){ 
        int numDice = InputValidation.parseNumberOfDie(in);   
        return numDice;
    }

    
    /**
     *
     * @param in String object for input
     * @return String for player name
     */
    public static String getPlayerName(String in){
        String s = in;
        return s;
    }
    
     /**
     *
     * @param in String for input
     * @return AcctValue object with a starting account value
     */
    public static AcctValue getStartingAcctVal(String in){
        AcctValue value = new AcctValue(-1,-1, false);
        value = InputValidation.parseValue(in);
        return value;
    }
    
    /**
     *
     * @param in Scanner object for input
     * @return String indicating yes(y) no(n) 
     */
    public static AcctValue getWager(String in){ 
        AcctValue value = new AcctValue(-1,-1, false);
        value = InputValidation.parseValue(in);
        return value;
    }

}
