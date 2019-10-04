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
 *
 * @author Wesley
 */
public class LettersVerifier extends InputVerifier{
    
    private JFormattedTextField field;
    private String value;
    
    @Override
    public boolean verify(JComponent arg0) {
        //determine if letters and less than 20 in length
        this.value = this.field.getText();
        boolean result = Input.isLettersOnly(this.value) && this.value.length()<20;  
        return result; 
    }
    
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
