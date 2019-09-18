/*
 * Sample code for CS 321 at UAH
 * You can use this code if you modify it
 * or if you indicate that this is the original source.
 * Fall Semester 2019
 */
package dicegame;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author drochowi Dan Rochowiak, CS321, Fall 2019
 */
public class Player {

    private String name;
    private Account account;
    private AcctValue wager = null;
    private int lastDie = -1;

    public Player(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    /**
     * Gets the name of a player
     * @return string
     */
    public String getName() {
        return this.name;
    }

    /**
     * gets the players account amount
     * @return string
     */
    public String getAccount() {
        return this.account.getAmount();
    }

    /**
     * updates the players account 
     * @param dollars int
     * @param cents int
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
     * @return AcctValue
     */
    public AcctValue getWager(){
        return this.wager;
    }


}
