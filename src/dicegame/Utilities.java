/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 * A Utilities class to hold simple helper functions related to currency
 * @author Wesley
 */
public class Utilities {
    
    /**
     * converts units to currency
     * @param units
     * @return AcctValue with dollars and cents
     */
    public static AcctValue convertUnitsToCurrency(long units){
        int dollars = (int) units/100;
        int cents = (int) units%100;
        AcctValue val = new AcctValue(dollars,cents);
        return val;
    }
    
    /**
     * converts currency to units
     * @param val
     * @return long with pennies
     */
    public static long convertCurrencyToUnits(AcctValue val){
        long units = (val.getDollars()*100)+val.getCents();
        return units;
    }
    
    /**
     * converts currency to units
     * @param dollars
     * @param cents
     * @return long with pennies
     */
    public static long convertCurrencyToUnits(int dollars, int cents){
        long units = (dollars*100)+cents;
        return units;
    }
}
