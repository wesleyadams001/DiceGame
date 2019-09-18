/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author Wesley
 * An Account class to handle the managing of the players account
 * information
 */
public class Account {
    private Locale locale;
    private long units;
    private String amount;
    private Currency c;
     
    /**
     * Default constructor that sets the currency locale 
     * and the amount in the account
     * @param locale a locale object represening country curreny type ie US United States
     * @param amount pennies
     */
    public Account(Locale locale, long val) {
        this.locale = locale;
        this.units = val;
        this.c = Currency.getInstance(locale);
    }
     
    /**
     * Get function that gets the current amount in the account
     * @return String a String representation of the amount in the account
     */
    public String getAmount() {
        AcctValue val = Utilities.convertUnitsToCurrency(this.units);
        amount = String.valueOf(val.getDollars()+ "." + val.getCents());
        return amount;
    }
     
    /**
     * Get function that gets the current locale of the account
     * @return locale returns the locale associated with the account
     */
    public Locale getLocale() {
        return this.locale;
    }
    
    /**
     * prints the current account status
     */
    public void status() {
        AcctValue val = Utilities.convertUnitsToCurrency(this.units);
        System.out.println(val.getDollars() + "." + val.getCents() + c.getCurrencyCode()+" in the account");
    }
    
    /**
     * Update function for the account that takes a int for dollars and cents
     * @param additionalunits units (pennies) add to the account
     */
    private long update(long addionalUnits) {
        this.units += addionalUnits;
        System.out.println(this.units/100 + "." + this.units%100 + c.getCurrencyCode()+" is current Balance.");
        return this.units;
    }
    
    /**
     * Withdrawals a amount from the account
     * @param wDollars int for dollars
     * @param wCents int for cents
     * @return long withdrawn value pennies
     */
    public long withdrawal(int wDollars, int wCents){
        long val = (wDollars*100)+wCents;
        if(val> this.units){
            System.out.println("Insufficient funds");
            
        }
        else{
            long withdrawal = -val;
            val = update(withdrawal);
        }
        return val;
    }
     
    
}
