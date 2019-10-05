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
 * A class that inherits from Input verifier class to control for letter verification of text box inputs
 * @author Wesley
 */
public class LettersVerifier extends InputVerifier{
    
    private JFormattedTextField field;
    private String value;
    
    /**
     * Determines if the component input conforms to being explicitly letters by called the isLettersOnly method
     * on the text and verifies the length of the string to be reasonable as less than 20 in length
     * @param arg0 a Jcomponet
     * @return boolean indicating conformity
     */
    @Override
    public boolean verify(JComponent arg0) {
        //determine if letters and less than 20 in length
        this.value = this.field.getText();
        boolean result = Input.isLettersOnly(this.value) && this.value.length()<20;  
        return result; 
    }
    
    /**
     * Method that determines if the control should yield focus by calling the verify method on the controls input
     * then if it conforms it sets the value of the text box.
     * @param input a Jconponent
     * @return boolean to indicate if input passed verification
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
