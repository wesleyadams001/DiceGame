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
    private static double WIN_PERCENTILE_LB = 0;
    private static double WIN_PERCENTILE_UB = 0;
    private static double LOSE_PERCENTILE_LB = 0;
    private static double LOSE_PERCENTILE_UB = 0;
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
    private void makeDice(int quant, int numSides) {
        for (int i = 0; i < quant; i++) {
            dice.add(new Die(numSides, 1));
        }
    }
    
    /*
    * Reads the current values of the dice
    * @return void
    */
    private void readDice(Game game){
        
        int i =1;
        for (Die temp : game.dice) 
        {
            System.out.println("Dice "+ i +"current value is: " + temp.getCurrentValue());
            i++;
        }
    }
    
    /*
    * Defines scoring based on number of dice available and the sides on the dice
    * @return void
    */
    private void defineScores(int numDice, int numSides, int winLowerBound, int winUpperBound, int loseLowerBound, int loseUpperBound){

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
    * @return long
    */
    public static long Percentile(int[] latencies, double Percentile)
    {     
        int Index = (int)Math.ceil(((double)Percentile / (double)100) * (double)latencies.length);
        return latencies[Index-1];
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
        System.out.println("Winning values are between: " + this.WIN_PERCENTILE_LB + " and " +this.WIN_PERCENTILE_UB);
        System.out.println("Losing values are between: " + this.LOSE_PERCENTILE_LB + " and " +this.LOSE_PERCENTILE_UB);
        System.out.println("Totals");
        System.out.println("Losses: "+losses+" |Wins: "+wins+ "|Push:" +pushes);
    }

    public static void main(String[] args) {

        
        Scanner in = new Scanner(System.in); 
        String name = promptPlayerName(in);
        AcctValue value = promptStartingAcctVal(in);
        
        Account acct = new Account(Locale.US, value.getUnits());
        Player player = new Player(name, acct);
        Game game = new Game(player);
        System.out.println(player.getAccount());
        
        String a = null, b = null, c = null, d = null;

        //prompt wager
        a = promptWager(in);
            
        //prompt number of dice
        int numberOfDice = getNumberOfDice(in);
        
        //prompt number of sides 
        int numberOfSides = getNumberOfSides(in);
        
        //define game scores
        game.defineScores(numberOfDice, numberOfSides, 5, 40, 41, 85 );
        
        //Make dice
        game.makeDice(numberOfDice, numberOfSides);
        
        AcctValue value2 = new AcctValue(-1,-1, false);
        
        //get wager
        value2 = retrieveWager(in);

        //set player wager
        player.setWager(value2);
        
        //if input is yes
        if(a.equals("y")){

            while(1==1){
                
                //prompt roll dice
                b = promptRollDice(in);

                if(b.equals("y")){


                    int tv = 0;
                    //roll each die
                    for (Die temp : game.dice) {

                        //Rolls die
                        temp.rollDie();

                        //sums values
                        tv = tv + temp.getCurrentValue();
                        
                    }
                    //assign the target value
                    game.targetValue = tv;
                    System.out.println("score: "+ tv);

                    //Verify the score
                    game.verifyScore();
                    
                    //Reads the dice result
                    //game.readDice(game);

                    //finish
                    game.reportGame();

                    if(game.win == 1){
                        //Won, retrieve the wager and update the players accound with the wager amount
                        AcctValue acctVal  = player.getWager();
                        player.updateAccount(-acctVal.getDollars(), -acctVal.getCents());
                        game.wins++;
                        game.win=0;
                    }
                    else if(game.win == 1 && game.push == true){
                        //Do nothing
                        game.win=0;
                    }
                    else if(game.win == -1){
                        //Otherwise lost, retrieve the wager
                        AcctValue acctVal  = player.getWager();

                        //flip it negative
                        player.updateAccount(acctVal.getDollars(), acctVal.getCents());
                        
                        game.losses++;
                        
                        game.win=0;
                    }
                    else{
                        System.out.println("===========Null game==========");
                    }
                }
                else if(b.equals("n")){
                    
                    //prompt to change wager
                    c=promptChangeWager(in);
                    
                    if(c.equals("y")){
                        
                        AcctValue value3 = new AcctValue(-1,-1, false);
                        
                        //get new wager
                        value3 = retrieveWager(in);

                        //set the new wager
                        player.setWager(value3);
                    }
                    
                    //Prompt quit
                    String quit = Quit(in);

                    //QUIT 
                    if(quit.equals("y")){
                        System.exit(0);
                    }

                }
                else if(b.equals("p")){
                    
                    //Notify pushed
                    System.out.println("==PUSHED==");
                    
                    //increment push
                    game.pushes++;
                }
            }
            
        }
        else{
            
            String quit = Quit(in);

            //QUIT 
            if(quit.equals("y")){
                System.exit(0);
            }
        }
        

        
    }
    
    public static int getNumberOfSides(Scanner in){
        System.out.println("Input number of sides: ");
        String input = in.nextLine();
        int numberOfSides = InputValidation.parseNumberOfSides(input);//add check for valid amt
                
        return numberOfSides;
    }
    
    public static int getNumberOfDice(Scanner in){
        
        System.out.println("Input number of dice: ");
        String input = in.nextLine();
        int numDice = InputValidation.parseNumberOfDie(input);//add check for valid amt
                
        return numDice;
    }
    
    public static String promptPlayerName(Scanner in){
        System.out.println("Enter player name");
        String s = in.nextLine();
        return s;
    }
    
    public static AcctValue promptStartingAcctVal(Scanner in){
        AcctValue value = new AcctValue(-1,-1, false);
        
        while(value.getValidity()==false){
            
            System.out.println("Enter money in starting account value.");
            String a = in.nextLine();
            value = InputValidation.parseValue(a);
        }
        return value;
    }
    
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
    
    public static AcctValue retrieveWager(Scanner in){
        AcctValue value2 = new AcctValue(-1,-1, false);
        while(value2.getValidity() == false){
            System.out.println("Enter a wager: ");
            String wager = in.nextLine();
            value2 = InputValidation.parseValue(wager);//add check for valid amt
            }
        return value2;

    }
    
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
