/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame.UserInterface;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;

/**
 * Registers a property change listener on the value property of a formatted text field
 * @author Wesley
 */
public class FormattedTextFieldListener implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
       Object source = arg0.getSource();
        if (source == DiceGameUI.getInitialAcctValueField()) {
            JButton btn = DiceGameUI.getSubmitBtn();
            btn.setEnabled(true);
        }
        if (source == DiceGameUI.getWagerValueField()){
            JButton btn = DiceGameUI.getRollBtn();
            btn.setEnabled(true);
        }
        
    }
}
