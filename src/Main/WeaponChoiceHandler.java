/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Marcin
 */
public class WeaponChoiceHandler implements ActionListener {
    
    GameManager gm;
    
    public WeaponChoiceHandler(GameManager gm){
        
        this.gm = gm;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String yourChoice = e.getActionCommand();
        
        switch (yourChoice){
            
            case "examine_brdswrd":
                gm.ui.messageText.setText("Yep, it's a broadsword");
                break;
                
            case "examine_empty":
                gm.ui.messageText.setText("The void stares back at you");
                break;
                
            case "examine_lthrarm":
                gm.ui.messageText.setText("Yep, it's leather armor");
                break;
                
            
            
        }
                
    }
    
}
