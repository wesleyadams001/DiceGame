/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 *
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
     *
     * @return boolean for if valid account value
     */
    public Boolean getValidity(){
        return this.isValid;
    }
    
    /**
     *
     * @return int for dollars
     */
    public int getDollars(){
        return this.dollars;
    }
    
    /**
     *
     * @return int for cents 
     */
    public int getCents(){
        return this.cents;
    }
    
    /**
     * Gets the value in units (pennies)
     * @return long
     */
    public long getUnits(){
        return Utilities.convertCurrencyToUnits(this);
    }
    
}
