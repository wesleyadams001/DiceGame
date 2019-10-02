/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 * A class that represents an account value such as an amount that is being deposited or an amount that is being withdrawn
 * This class contains a validity key as a boolean that indicates whether the value is invalid or valid based on interactions
 * with the input validation class. i.e. should the value not pass input validation it can still return an account value yet flag
 * it as invalid and do something else with it.
 * @author Wesley
 */
public class AcctValue {
    
    private Boolean isValid;
    private int dollars;
    private int cents;
    private long units;
    
    public AcctValue(int dollabills, int centos, Boolean validity){
        this.dollars = dollabills;
        this.cents = centos;
        this.isValid = validity;
        this.units = 0;
    }
    
    /**
     * Gets the value for validity
     * @return boolean for if valid account value
     */
    public Boolean getValidity(){
        return this.isValid;
    }
    
    /**
     * Gets the value for dollars
     * @return int for dollars
     */
    public int getDollars(){
        return this.dollars;
    }
    
    /**
     * Gets the value for cents
     * @return int for cents 
     */
    public int getCents(){
        return this.cents;
    }
    
    /**
     * Gets the value in units (pennies) for this instance of value
     * @return long
     */
    public long getUnits(){
        return Utilities.convertCurrencyToUnits(this);
    }
    
}
