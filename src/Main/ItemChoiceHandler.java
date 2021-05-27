/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import items.SmallHealthPotion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author Marcin
 */
public class ItemChoiceHandler implements ActionListener{
    
    GameManager gm;
    Random rand = new Random();
    
    public ItemChoiceHandler(GameManager gm){
        
        this.gm = gm;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        String yourChoice = e.getActionCommand();
        
        int damageRoll2;
        
        switch (yourChoice){
        
            case "S Potion":
                
                damageRoll2 = rand.nextInt(3);
                
                if (gm.playerInfo.getHealth() == gm.playerInfo.getMaxhealth()){
                    gm.ui.messageText.setText("Your health is full!");
                }
                else {
                
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()+10);

                    if (gm.playerInfo.getHealth() > gm.playerInfo.getMaxhealth()) gm.playerInfo.setHealth(gm.playerInfo.getMaxhealth());
                    
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);

                    gm.ui.messageText.setText(gm.potion.getEffectMessage() + "\n" + "The " + gm.monster.getName() + " attacks you for " + damageRoll2); 

                    for (int i=8;i>=0;i--){
                        if (gm.itemlist[i] != null && gm.itemlist[i].getName().equals("S Potion")){
                            gm.itemlist[i] = null;
                            break;
                        }
                    }

                    gm.ui.addPlayerInfo();
                }
                gm.ui.addFightMenu();
                break;
                
            case "M Potion":
                
                damageRoll2 = rand.nextInt(3);
                
                if (gm.playerInfo.getHealth() == gm.playerInfo.getMaxhealth()){
                    gm.ui.messageText.setText("Your health is full!");
                }
                else {
                
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()+25);

                    if (gm.playerInfo.getHealth() > gm.playerInfo.getMaxhealth()) gm.playerInfo.setHealth(gm.playerInfo.getMaxhealth());
                    
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);

                    gm.ui.messageText.setText(gm.potion3.getEffectMessage() + "\n" + "The " + gm.monster.getName() + " attacks you for " + damageRoll2); 

                    for (int i=8;i>=0;i--){
                        if (gm.itemlist[i] != null && gm.itemlist[i].getName().equals("M Potion")){
                            gm.itemlist[i] = null;
                            break;
                        }
                    }

                    gm.ui.addPlayerInfo();
                }
                gm.ui.addFightMenu();
                break;
                
            case "S Elixir":
                
                damageRoll2 = rand.nextInt(3);
                
                if (gm.playerInfo.getMana() == gm.playerInfo.getMaxmana()){
                    gm.ui.messageText.setText("Your mana is full!");
                }
                else {
                
                    gm.playerInfo.setMana(gm.playerInfo.getMana()+10);

                    if (gm.playerInfo.getMana() > gm.playerInfo.getMaxmana()) gm.playerInfo.setMana(gm.playerInfo.getMaxmana());
                    
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);

                    gm.ui.messageText.setText(gm.elixir.getEffectMessage() + "\n" + "The " + gm.monster.getName() + " attacks you for " + damageRoll2); 

                    for (int i=8;i>=0;i--){
                        if (gm.itemlist[i] != null && gm.itemlist[i].getName().equals("S Elixir")){
                            gm.itemlist[i] = null;
                            break;
                        }
                    }

                    gm.ui.addPlayerInfo();
                }
                gm.ui.addFightMenu();
                break;
                
            case "empty":
                gm.ui.messageText.setText("It's unlikely this empty space will be too much help..."); 
                gm.ui.addFightMenu();
                break;
            
        }
        
    }
    
}
