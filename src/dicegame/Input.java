/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 * Class that contains static methods that allow for input from the GUI
 * @author Wesley
 */
public class Input {
        
    /**
     * Gets the number of dice from a string input by calling parseNumberOfSides
     * @param in String for input
     * @return returns int for number of sides
     */
    public static int getNumberOfSides(String in){
        int numberOfSides = parseNumberOfSides(in);      
        return numberOfSides;
    }
    

    /**
     * Gets the number of Dice from a string
     * @param in String for input
     * @return int for number of sides
     */
    public static int getNumberOfDice(String in){ 
        int numDice = parseNumberOfDie(in);   
        return numDice;
    }

    
    /**
     * Gets the player name from a string
     * @param in String for input
     * @return String for player name
     */
    public static String getPlayerName(String in){
        String s = in;
        return s;
    }
    
     /**
     * Gets the starting account value from a string that is entered
     * @param in String for input
     * @return AcctValue object with a starting account value
     */
    public static AcctValue getStartingAcctVal(String in){
        AcctValue value = new AcctValue(-1,-1);
        value = parseValue(in);
        return value;
    }
    
    /**
     * Gets the user entered wager from a string by calling the parseValue function
     * @param in Scanner object for input
     * @return String indicating yes(y) no(n) 
     */
    public static AcctValue getWager(String in){ 
        AcctValue value = new AcctValue(-1,-1);
        value = parseValue(in);
        return value;
    }
   

    /**
     * Parses the number of dice from a string
     * @param a String input value
     * @return int representing number of die
     */
    private static int parseNumberOfDie(String a) {
        int x = Integer.valueOf(a);
        return x;
    }
    
    /**
     * Parses the number of sides from a string and determines if the value is numeric
     * as well as verifies that there are less than 13 digits because we do not want 
     * die that big then if the value seems reasonable cast to a string after that if 
     * evaluates that is greater than 1
     * @param a String representing input
     * @return integer for the number of sides or negative one for bad input
     */
    private static int parseNumberOfSides(String a){
        int x = -1;
        Boolean isNum = isNumeric(a);
        if (a.length() <13 && isNum){
            x= Integer.valueOf(a);
            if(x<=1){
                return x;
            }
            return x;
        }
        return x;
    }
    

    /**
     * Parses a value and returns an Account Value (AcctValue) object from a string
     * @param value An input string
     * @return an account value object
     */
    private static AcctValue parseValue(String value) {

        if (value.length() < 30) {

            //Check if the input account string has a decimal
            Boolean hasDecimal = isNumericWithDecimal(value);

            //if so...
            if (hasDecimal) {

                //Split string on decimal
                String[] array = value.split("\\.");
    
                int dollars = Integer.parseInt(array[0]);
                int cents = Integer.parseInt(array[1]);

                AcctValue acc = new AcctValue(dollars, cents);
                return acc;
                    

                
            } //We do not have a decimal
            else {

                //check for reasonable length and if value is numeric
                int dollars = Integer.parseInt(value);
                int cents = 0;

                AcctValue acc = new AcctValue(dollars, cents);
                return acc;
                
            }
        } else {
            //System.out.println("Account value too large, try less than 25 digits.");
            return new AcctValue(0, 0);
        }

        

    }

    /**
     * Determines if a string is numeric with a decimal using regex
     * @param str An input string
     * @return a boolean
     */
    public static boolean isNumericWithDecimal(String str) {
        //"^\\d*\\.\\d+|\\d+\\.\\d*$"
        return str.matches("^\\d*\\.\\d+|\\d+\\.\\d*$");
    }

    /**
     * Determines if a string is numeric using regex
     * @param str An input string
     * @return a boolean
     */
    public static boolean isNumeric(String str) {
        //"[0-9]+"
        return str.matches("[0-9]+");
    }
    
    /**
     * Determines if a string consists of letters only using regex
     * @param str An input string
     * @return boolean
     */
    public static boolean isLettersOnly(String str){
        return str.matches("[A-Za-z]*");
    }

}
