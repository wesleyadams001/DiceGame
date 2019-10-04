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
public class NumericVerifier extends InputVerifier {

    private JFormattedTextField field;
    private String value;
    
    @Override
    public boolean verify(JComponent arg0) {
        
        boolean result = false;
        this.value = this.field.getText();
        result = InputValidation.isNumeric(this.value) && this.value.length() < 7;
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
