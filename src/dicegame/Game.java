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
        long[] intArray = new long[MAX-MIN];
        long start = this.MIN;
        
        for (int i = 0; i < intArray.length; i++){
            intArray[i] = start;
            start++;
            
        }  
        this.WIN_PERCENTILE_LB = Percentile(intArray, winLowerBound);
        this.WIN_PERCENTILE_UB = Percentile(intArray, winUpperBound);
        this.LOSE_PERCENTILE_LB = Percentile(intArray, loseLowerBound);
        this.LOSE_PERCENTILE_UB = Percentile(intArray, loseUpperBound);
        
        //post-operative adjustment for Law of large numbers
        if(numDice>20 && numSides>20){
            
            //calculate average
            long avg = calculateAverage(intArray);
            
            //calculate the standard deviation
            long stDev = calculateStandardDev(intArray, avg);
            
            int denom = 0;
            if(numSides>numDice){
                denom = numDice;
            }
            else{
                denom = numSides;
            }
            
            //calculate adjustment factor
            long adjFactor = avg - (stDev/denom);
            
            //assign new bound
            if(this.WIN_PERCENTILE_UB<adjFactor || this.WIN_PERCENTILE_UB>adjFactor){
                this.WIN_PERCENTILE_UB = adjFactor;
                
                //prevent overlap on adjustment
                this.LOSE_PERCENTILE_LB = adjFactor;
            }
            
        }
        
    }
    
    /*
    * calculates a percentile and returns the value associated with that percentile from the array
    * @return long the index of the array to use
    */
    private static long Percentile(long[] arr, double Percentile)
    {     
        int Index = (int)Math.ceil(((double)Percentile / (double)100) * (double)arr.length);
        return arr[Index-1];
    }
    
    /*
    * calculates an average from the array
    * @return long average
    */
    private static long calculateAverage(long[] arr){
        long val = 0;
        for(int x = 0; x< arr.length; x++){
            val += arr[x];
        }
        val /= arr.length;
        return val;
    }
    
    /*
    * calculates a standard deviation from the array
    * @return long standard deviation
    */
    private static long calculateStandardDev(long[] arr, long avg){
        //set a double
        double sd = 0;
        
        //loop through array
        for (int i = 0; i < arr.length; i++)
        {
            //take value at i and subtract the mean then square it and divide by the length
            sd += Math.pow((arr[i] - avg),2) / arr.length;
        }
        
        //take the square root to get standard deviation
        double standardDeviation = Math.sqrt(sd);
        
        //round it to get the nearest long
        long val = Math.round(standardDeviation);
        return val;
    }
    
    
    /**
     * Sets the target value for comparison
     * @param x integer
     */
    public void setTargetValue(int x){
        this.targetValue = x;
    }
    
    /**
     * Returns the current arraylist of Die 
     * @return ArrayList<Die>
     */
    public ArrayList<Die> getDice(){
        return this.dice;
    }
    
    /**
     * Resets the contents of the arraylist of die
     */
    public void resetDice(){
        this.dice = new ArrayList<Die>();
    }
    
    /**
     * increases the total losses by 1
     */
    public void incrementLosses(){
        this.losses++;
    }
    
    /**
     * Increases the total wins by 1
     */
    public void incrementWins(){
        this.wins++;
    }
    
    /**
     * Sets the integer value representing a win
     * @param x as in integer
     */
    public void setWin(int x){
        this.win = x;
    }
    
    /**
     * Gets the value of the win 1,0,-1
     * @return integer
     */
    public int getWin(){
        return this.win;
    }
    
    /**
     * Gets the value of the push property indicating
     * if the player chose to push
     * @return bool
     */
    public boolean getPush(){
        return this.push;
    }
    
    /**
     * Sets the value of the push property indicating
     * if the player chose to push 
     * @param p bool
     */
    public void setPush(boolean p){
        this.push = p;
    }
    
    /**
     * Increases the total pushes by one
     */
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



}
