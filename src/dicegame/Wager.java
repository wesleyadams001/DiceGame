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
public class Wager {
    
    private AcctValue accVal = null;
    public Wager(int dollarAmt, int centAmount){
        this.accVal = new AcctValue(dollarAmt, centAmount, true);
        
    }
    
    public AcctValue getWager(){
        return this.accVal;
    }
}
