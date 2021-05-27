/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jdk.nashorn.internal.ir.BreakableNode;

/**
 *
 * @author Marcin
 */
public class DialogChoiceHandler implements ActionListener{
    
    GameManager gm;
    
    public DialogChoiceHandler(GameManager gm){
        
        this.gm = gm;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String yourChoice = e.getActionCommand();
        
        switch (yourChoice){
            
            case "think":
                gm.ui.messageText.setText("Ah, the adventure begins...\n Let's ask around for info on the Demon Lord."); 
                gm.ui.messageText.setForeground(Color.yellow);
                break;
            
            case "move":
                /*gm.ui.currentScene = 1;
                gm.ui.nextScene = 3;
                gm.sceneChanger.showScreenNext(gm.ui.currentScene, gm.ui.nextScene);*/
                gm.sceneChanger.showScreen3();
                gm.ui.messageText.setText("A goblin appears!"); 
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addFightMenu();
                break;
            
        }
        
    }
    
}
