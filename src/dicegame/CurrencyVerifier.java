/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;


import java.util.Currency;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

/**
 * Currency verifier class for verifying inputs
 * @author Wesley
 */
public class CurrencyVerifier extends InputVerifier{
   
    public CurrencyVerifier(JComponent arg){
        this.btn = (JButton) arg;
    }
    
    private JButton btn;
    private JFormattedTextField field;
    private String value;
    
    /**
     * Takes a component and checks that the input conforms to having the boolean properties of 
     * numeric with decimal point or just numeric as well as verifies the lengths of the entered values
     * by splitting the string on "." and examining length
     * @param arg0 a Jcomponent
     * @return boolean
     */
    @Override
    public boolean verify(JComponent arg0) {
        
        this.field = (JFormattedTextField) arg0;
        boolean result = false;
        this.value = this.field.getText();
        result = Input.isNumericWithDecimal(this.value);
        
        //if it is numeric with a decimal
        if(result == true){
            
            //Split string on decimal
            String[] array = this.value.split("\\.");
            if (array[0].length() < 12 && array[1].length() < 3) {
                result = true;
            }
            else{
                result = false;
            }
            
        }
        //check for reasonable length and if value is only numeric
        else if (this.value.length() < 12 && Input.isNumeric(this.value)) {
            result = true;
        }
        
        return result;
    }
    
    /**
     * Determines if the control should yield focus based on the results of the verification method
     * @param input takes a JComponent as input
     * @return boolean to indicate if control should yield focus
     */
    @Override
    public boolean shouldYieldFocus(JComponent input) {
        this.field = (JFormattedTextField) input;
        if (verify(input)) {
            field.setValue(value);
            //this.btn.setEnabled(true);
            return true;
        } else {           
            return false;
        }
    }
}
