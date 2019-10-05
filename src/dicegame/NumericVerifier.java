/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

/**
 * A Numeric verifier class that extends the input verifier class and allows for verification of specificly numeric values
 * @author Wesley
 */
public class NumericVerifier extends InputVerifier {

    private JFormattedTextField field;
    private String value;
    
    /**
     * Verfies that the input of the control passed the requirement of being explicitly numeric by calling the isNumeric method on the input
     * @param arg0 a JComponent
     * @return a boolean indicating conformity of the input to isNumeric
     */
    @Override
    public boolean verify(JComponent arg0) {
        
        boolean result = false;
        this.value = this.field.getText();
        result = Input.isNumeric(this.value) && this.value.length() < 7;
        return result;
    }
    
    /**
     * Method that calls the verify method to check a components input and determines if the control focus
     * should be yielded if the input passed the check
     * @param input a JConponent
     * @return boolean
     */
    @Override
    public boolean shouldYieldFocus(JComponent input) {
        this.field = (JFormattedTextField) input;
        if (verify(input)) {
            this.field.setValue(value);
            return true;
        } else {
            return false;
        }
    }
}
