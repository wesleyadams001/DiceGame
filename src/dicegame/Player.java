/*
 * Sample code for CS 321 at UAH
 * You can use this code if you modify it
 * or if you indicate that this is the original source.
 * Fall Semester 2019
 */
package dicegame;


/**
 * Class that contains player related information
 * @author Wesley adams
 */
public class Player {

    private String name;
    private Account account;
    private AcctValue wager = null;
    private Game game = null;

    public Player(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    /**
     * Gets the name of a player
     * @return string of the player name
     */
    public String getName() {
        return this.name;
    }

    /**
     * gets the players account amount
     * @return string a string of the account amount
     */
    public String getAccount() {
        return this.account.getAmount();
    }

    /**
     * updates the players account 
     * @param dollars int dollars
     * @param cents int cents
     */
    public void updateAccount(int dollars, int cents) {
        this.account.withdrawal(dollars, cents);
    }

    /**
     * sets the players wager
     * @param val AcctValue
     */
    public void setWager(AcctValue val){
        this.wager = val;
    }
   
    /**
     * gets the players wager
     * @return AcctValue AcctValue object
     */
    public AcctValue getWager(){
        return this.wager;
    }
    

}
