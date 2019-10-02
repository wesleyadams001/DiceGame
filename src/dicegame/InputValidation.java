/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 * Class that contains static methods that do basic input validation
 * @author Wesley
 */
public class InputValidation {

    /**
     * parses dice information
     * @param a input string
     * @return returns a die object
     */
    public static Die parseDiceInfo(String a) {
        Die die = null;
        if (a.length() < 50 && a.contains(",")) {
            //Split string on comma
            String[] array = a.split(",");

            if (isNumeric(array[0]) && isNumeric(array[1])) {
                int sides = Integer.parseInt(array[0]);
                int startPoint = Integer.parseInt(array[1]);
                die = new Die(sides, startPoint);
                return die;
            }

            return die;
        }
        return die;
    }

    /**
     *
     * @param a String input value
     * @return int representing number of die
     */
    public static int parseNumberOfDie(String a) {
        int x = -1;
        Boolean isNum = isNumeric(a);
        if (isNum) {
            x = Integer.valueOf(a);
            return x;
        }

        return x;
    }
    
    /**
     * Parses the number of sides from a string and determines if the value is numeric
     * as well as verifies that there are less than 13 digits because we do not need 
     * die that big then if the value seems reasonable cast to a string after that if 
     * evaluates that is greater than 1
     * @param a String representing input
     * @return integer for the number of sides or negative one for bad input
     */
    public static int parseNumberOfSides(String a){
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
     * Parses a value and returns a AcctValue with a flag that indicates valid or not
     * @param value An input string
     * @return an account value object
     */
    public static AcctValue parseValue(String value) {

        if (value.length() < 30) {

            //Check if the input account string has a decimal
            Boolean hasDecimal = isNumericWithDecimal(value);

            //if so...
            if (hasDecimal) {

                //Split string on decimal
                String[] array = value.split("\\.");

                //examine lengths for proper values
                if (array[0].length() < 12 && array[1].length() < 3) {

                    //Try parsing to integer both dollars and cents
                    try {
                        int dollars = Integer.parseInt(array[0]);
                        int cents = Integer.parseInt(array[1]);

                        AcctValue acc = new AcctValue(dollars, cents, true);
                        return acc;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            } //We do not have a decimal
            else {

                //check for reasonable length and if value is numeric
                if (value.length() < 12 && isNumeric(value)) {
                    int dollars = Integer.parseInt(value);
                    int cents = 0;

                    AcctValue acc = new AcctValue(dollars, cents, true);
                    return acc;
                } else {
                    //System.out.println("Make sure to use a value less than 12 digits and that consists of numbers");
                }
            }
        } else {
            //System.out.println("Account value too large, try less than 25 digits.");
            return new AcctValue(0, 0, false);
        }

        return new AcctValue(0, 0, false);

    }

    /**
     * determines if a string is numeric with a decimal
     * @param value An input string
     * @return a boolean
     */
    private static boolean isNumericWithDecimal(String str) {
        //"^\\d*\\.\\d+|\\d+\\.\\d*$"
        return str.matches("^\\d*\\.\\d+|\\d+\\.\\d*$");
    }

    /**
     * determines if a string is numeric 
     * @param value An input string
     * @return a boolean
     */
    private static boolean isNumeric(String str) {
        //"[0-9]+"
        return str.matches("[0-9]+");
    }
}
