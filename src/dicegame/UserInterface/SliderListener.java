/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame.UserInterface;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Slider listener that aids in setting slider max values dependent on 
 * alternative sliders value
 * @author Wesley
 */
public class SliderListener implements ChangeListener{
    
      /**
     * state change event handler that balances the number of sides and dice
     * based on accepted parameters of 90000 and 9000 to prevent overflowing type
     * @param arg0 takes a property change event
     */
    @Override
    public void stateChanged(ChangeEvent arg0) {
        Object source = arg0.getSource();
        if (source == DiceGameUI.getNumDiceSlider()) {
          JLabel lbl = DiceGameUI.getNumDiceLbl();
          lbl.setText(String.valueOf(DiceGameUI.getNumDiceSlider().getValue()));
          if(DiceGameUI.getNumDiceSlider().getValue()>=90000){
              DiceGameUI.getNumSidesSlider().setMaximum(9000);
          }
          else if(DiceGameUI.getNumDiceSlider().getValue()<9000){
              DiceGameUI.getNumSidesSlider().setMaximum(90000);
          }
          
        }
        if (source == DiceGameUI.getNumSidesSlider()){
            JLabel lbl = DiceGameUI.getNumSidesLbl();
            lbl.setText(String.valueOf(DiceGameUI.getNumSidesSlider().getValue()));
            if(DiceGameUI.getNumSidesSlider().getValue()>=90000){
              DiceGameUI.getNumDiceSlider().setMaximum(9000);
            }
            else if(DiceGameUI.getNumSidesSlider().getValue()<9000){
              DiceGameUI.getNumDiceSlider().setMaximum(90000);
            }
        }
    }
}
