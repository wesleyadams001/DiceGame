/*
 * Sample code for CS 321 at UAH
 * You can use this code if you modify it
 * or if you indicate that this is the original source.
 * Fall Semester 2019
 */
package dicegame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * The class that holds the main method as well as inherent game logic
 * @author Wesley Adams
 */
public class Game {

    //The games player
    private Player player;
    
    //The target value
    private int targetValue;
    
    //ArrayList of die
    private ArrayList<Die> dice = new ArrayList<>();
    private int win = 0;
    private boolean push = false;
    private boolean quit = false;
    private int wins =0;
    private int losses =0;
    private int pushes =0;
    private double WIN_PERCENTILE_LB = 0;
    private double WIN_PERCENTILE_UB = 0;
    private double LOSE_PERCENTILE_LB = 0;
    private double LOSE_PERCENTILE_UB = 0;
    private static int MAX =0;
    private static int MIN = 0;
    
   

    public Game(Player player) {
        this.player = player;
        this.targetValue =0;
        
    }
    
    /*
    * Use the die class to make the dice
    * @return void
    */
    public void makeDice(int quant, int numSides) {
        for (int i = 0; i < quant; i++) {
            dice.add(new Die(numSides, 1));
        }
    }
    
    
    /*
    * Defines scoring based on number of dice available and the sides on the dice
    * @return void
    */
    public void defineScores(int numDice, int numSides, int winLowerBound, int winUpperBound, int loseLowerBound, int loseUpperBound){

        this.MIN = numDice;
        this.MAX = numDice * numSides;
        int[] intArray = new int[MAX-MIN];
        int start = this.MIN;
        
        for (int i = 0; i < intArray.length; i++){
            intArray[i] = start;
            start++;
            
        }  
        this.WIN_PERCENTILE_LB = Percentile(intArray, winLowerBound);
        this.WIN_PERCENTILE_UB = Percentile(intArray, winUpperBound);
        this.LOSE_PERCENTILE_LB = Percentile(intArray, loseLowerBound);
        this.LOSE_PERCENTILE_UB = Percentile(intArray, loseUpperBound);
        
        
    }
    
    /*
    * calculates a percentile and returns the value associated with that percentile from the array
    * @return long the index of the array to use
    */
    private static long Percentile(int[] arr, double Percentile)
    {     
        int Index = (int)Math.ceil(((double)Percentile / (double)100) * (double)arr.length);
        return arr[Index-1];
    }
    
    public void setTargetValue(int x){
        this.targetValue = x;
    }
    
    public ArrayList<Die> getDice(){
        return this.dice;
    }
    
    public void resetDice(){
        this.dice = new ArrayList<Die>();
    }
    
    
    public void incrementLosses(){
        this.losses++;
    }
    
    public void incrementWins(){
        this.wins++;
    }
    
    public void setWin(int x){
        this.win = x;
    }
    
    public int getWin(){
        return this.win;
    }
    
    public boolean getPush(){
        return this.push;
    }
    
    public void setPush(boolean p){
        this.push = p;
    }
    
    public void incrementPushes(){
        this.pushes++;
    }
    
   
    
    /*
    * Verifies the score by seeing if the result of a roll is in the winning or losing array
    * @return void
    */
    public void verifyScore(){
        //this.targetValue =12;
        if(this.targetValue<=this.WIN_PERCENTILE_UB && this.targetValue >= this.WIN_PERCENTILE_LB){
            this.win = 1;
        }
        else if(this.targetValue<=this.LOSE_PERCENTILE_UB && this.targetValue >= this.LOSE_PERCENTILE_LB){
            this.win = -1;
        }
        else{
            this.win =0;
        }
    }

    /*
    * Reports the game stats and score
    * @return void
    */
    public void reportGame() {
        System.out.println("Player is " + player.getName());
        System.out.println("There are " + dice.size() + " dice.");
        System.out.println("Winning values between: " + this.WIN_PERCENTILE_LB + " and " +this.WIN_PERCENTILE_UB);
        System.out.println("Losing values between: " + this.LOSE_PERCENTILE_LB + " and " +this.LOSE_PERCENTILE_UB);
        System.out.println("Totals");
        System.out.println("Losses: "+losses+" |Wins: "+wins+ "|Push:" +pushes);
    }
    
    /*
    * Reports the game stats and score as a string
    * @return String
    */
    public String reportGameText() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Player is ").append(player.getName()).append("\n");
        sb.append("There are ").append(dice.size()).append(" dice.\n");
        sb.append("Player Score: ").append(this.targetValue).append("\n");
        sb.append("Winning values between: ").append(this.WIN_PERCENTILE_LB).append(" and ").append(this.WIN_PERCENTILE_UB).append("\n");
        sb.append("Losing values between: ").append(this.LOSE_PERCENTILE_LB).append(" and ").append(this.LOSE_PERCENTILE_UB).append("\n");
        sb.append("Totals").append("\n");
        sb.append("Losses: ").append(this.losses).append(" |Wins: ").append(this.wins).append("|Push:").append(this.pushes);
        
        return sb.toString();
    }

    
    /**
     *
     * @param in Scanner object for input
     * @return returns int for number of sides
     */
    public static int getNumberOfSides(Scanner in){
        System.out.println("Input number of sides: ");
        String input = in.nextLine();
        int numberOfSides = InputValidation.parseNumberOfSides(input);//add check for valid amt
                
        return numberOfSides;
    }
    /**
     *
     * @param in Scanner object for input
     * @return returns int for number of sides
     */
    public static int getNumberOfSides(String in){
        System.out.println("Input number of sides: ");
        String input = in;
        int numberOfSides = InputValidation.parseNumberOfSides(input);//add check for valid amt
                
        return numberOfSides;
    }
    
    /**
     *
     * @param in Scanner object for input
     * @return int for number of sides
     */
    public static int getNumberOfDice(Scanner in){
        
        System.out.println("Input number of dice: ");
        String input = in.nextLine();
        int numDice = InputValidation.parseNumberOfDie(input);//add check for valid amt
                
        return numDice;
    }
    
    /**
     *
     * @param in Scanner object for input
     * @return int for number of sides
     */
    public static int getNumberOfDice(String in){
        
        System.out.println("Input number of dice: ");
        String input = in;
        int numDice = InputValidation.parseNumberOfDie(input);//add check for valid amt
                
        return numDice;
    }
    
    /**
     *
     * @param in Scanner object for input
     * @return String for player name
     */
    public static String promptPlayerName(Scanner in){
        System.out.println("Enter player name");
        String s = in.nextLine();
        return s;
    }
    
    /**
     *
     * @param in String object for input
     * @return String for player name
     */
    public static String promptPlayerName(String in){
        //System.out.println("Enter player name");
        String s = in;
        return s;
    }
    
    /**
     *
     * @param in Scanner for input
     * @return AcctValue object with a starting account value
     */
    public static AcctValue promptStartingAcctVal(Scanner in){
        AcctValue value = new AcctValue(-1,-1, false);
        
        while(value.getValidity()==false){
            
            System.out.println("Enter money in starting account value.");
            String a = in.nextLine();
            value = InputValidation.parseValue(a);
        }
        return value;
    }
    
     /**
     *
     * @param in String for input
     * @return AcctValue object with a starting account value
     */
    public static AcctValue promptStartingAcctVal(String in){
        AcctValue value = new AcctValue(-1,-1, false);
        
        while(value.getValidity()==false){
            
            //System.out.println("Enter money in starting account value.");
            String a = in;
            value = InputValidation.parseValue(a);
        }
        return value;
    }
    
    /**
     *
     * @param in Scanner object for input
     * @return String indicating yes(y) no(n) 
     */
    public static String promptWager(Scanner in){
        
        String a = null;
        Boolean isValidResponse = false;
        while(isValidResponse != true){
        System.out.println("Would you like to make a wager? y/n");
        a = in.nextLine();
        isValidResponse = InputValidation.parseResponse(a);
        }
        return a;
    }
    
    /**
     *
     * @param in Scanner object for input
     * @return String indicating yes(y) no(n) 
     */
    public static String promptWager(String in){
        
        String a = null;
        Boolean isValidResponse = false;
        while(isValidResponse != true){
        System.out.println("Would you like to make a wager? y/n");
        a = in;
        isValidResponse = InputValidation.parseResponse(a);
        }
        return a;
    }
    
    /**
     *
     * @param in Scanner object for input
     * @return AcctValue object 
     */
    public static AcctValue retrieveWager(Scanner in){
        AcctValue value2 = new AcctValue(-1,-1, false);
        while(value2.getValidity() == false){
            System.out.println("Enter a wager: ");
            String wager = in.nextLine();
            value2 = InputValidation.parseValue(wager);//add check for valid amt
            }
        return value2;

    }
    
    /**
     *
     * @param in Scanner object for input
     * @return AcctValue object 
     */
    public static AcctValue retrieveWager(String in){
        AcctValue value2 = new AcctValue(-1,-1, false);
        while(value2.getValidity() == false){
            System.out.println("Enter a wager: ");
            String wager = in;
            value2 = InputValidation.parseValue(wager);//add check for valid amt
            }
        return value2;

    }
    
    
    
    /**
     *
     * @param in Scanner object for input
     * @return String with either yes(y), no(n) or push (p)
     */
    public static String promptRollDice(Scanner in){
        Boolean isValidResponse = false;
        String b = null;
        while(isValidResponse != true){
                    System.out.println("Would you like to roll the dice or push? y/n/p");
                    b = in.nextLine();
                    isValidResponse = InputValidation.parseResponse(b);
                }
        return b;
    }
    
    /**
     *
     * @param in Scanner object for input
     * @return String with yes(y) or no(n)
     */
    public static String promptChangeWager(Scanner in){
        Boolean isValidResponse = false;
        String c = null;
        while(isValidResponse != true){
                    System.out.println("Would you like to change your wager? y/n");
                    c = in.nextLine();
                    isValidResponse = InputValidation.parseResponse(c);
                    }
        return c;
    }
    
    /**
     *
     * @param in Scanner object for input
     * @return String with yes(y) or no (n)
     */
    public static String Quit(Scanner in){
        Boolean isValidResponse = false;
        String b = null;
        while(isValidResponse != true){
                System.out.println("Would you like to Quit? y/n");
                b = in.nextLine();
                isValidResponse = InputValidation.parseResponse(b);
                }
        return b;
    }
    
    
    
    
    
    
}
