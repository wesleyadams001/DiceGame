/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

import static dicegame.InputValidation.isNumeric;
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
    
    @Override
    public boolean verify(JComponent arg0) {
        
        this.field = (JFormattedTextField) arg0;
        boolean result = false;
        this.value = this.field.getText();
        result = InputValidation.isNumericWithDecimal(this.value);
        
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
        else if (this.value.length() < 12 && InputValidation.isNumeric(this.value)) {
            result = true;
        }
        
        return result;
    }
    
    @Override
    public boolean shouldYieldFocus(JComponent input) {
        this.field = (JFormattedTextField) input;
        if (verify(input)) {
            field.setValue(value);
            return true;
        } else {           
            return false;
        }
    }
}
