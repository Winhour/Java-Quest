/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.monsters.Skeletons;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


/**
 *
 * @author Marcin
 */
public class CombatChoiceHandler implements ActionListener{
    
    GameManager gm;
    Random rand = new Random();
    
    public CombatChoiceHandler(GameManager gm){
        
        this.gm = gm;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String yourChoice = e.getActionCommand();
        int damageRoll2;
        
        switch (yourChoice){
            case "fight":
                
                int damageRoll = rand.nextInt(gm.playerInfo.getModifiedATK()+1);
                damageRoll2 = rand.nextInt(gm.monster.getATK()+1);
                
                gm.monster.setHealth(gm.monster.getHealth()-damageRoll);
                if(gm.monster.getHealth()>0){
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);
                    gm.ui.messageText.setText("You slashed at the " + gm.monster.getName() + "! It took " + damageRoll + " damage\n It attacks back! You took " + damageRoll2 + " damage");
                } else {
                    gm.ui.messageText.setText("The " + gm.monster.getName() + " was defeated!\n You gain " + gm.monster.getExp() + "exp and " + gm.monster.getGold() + "gold.");
                    gm.playerInfo.setCash(gm.playerInfo.getCash()+gm.monster.getGold());
                    
                    if (gm.monster.getName().equals("Goblin") && gm.ui.goblinFlag){
                    //gm.ui.messageText.setText("testg");
                    gm.ui.bgPanel[3].remove(0);
                    gm.ui.goblinFlag = false;
                    }
                    if (gm.monster.getName().equals("Skeletons") && gm.ui.skeleFlag){
                        //gm.ui.messageText.setText("tests");
                        gm.ui.bgPanel[2].remove(0);
                        gm.ui.skeleFlag = false;
                    }
                    gm.ui.addInteractMenu();
                }
                gm.ui.addPlayerInfo();
                break;
                
            case "fireball":
                
                if (gm.playerInfo.getMana() < 6) {
                    
                    gm.ui.messageText.setText("Insufficient mana!");
                    gm.ui.addFightMenu();
                    
                }
                
                else {
                
                    gm.playerInfo.setMana(gm.playerInfo.getMana()-6);
                    int firedamage = 20+gm.playerInfo.getMAG();
                    damageRoll2 = rand.nextInt(gm.monster.getATK()+1);

                    gm.monster.setHealth(gm.monster.getHealth()-firedamage);
                    if(gm.monster.getHealth()>0){
                        gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);
                        gm.ui.messageText.setText("Flames engulf the " + gm.monster.getName() + "! It took " + firedamage + " damage\n It attacks back! You took " + damageRoll2 + " damage");
                        gm.ui.addFightMenu();
                    } else {
                        gm.ui.messageText.setText("The " + gm.monster.getName() + " was defeated!\n You gain " + gm.monster.getExp() + "exp");
                        if (gm.monster.getName().equals("Goblin") && gm.ui.goblinFlag){
                            //gm.ui.messageText.setText("testg");
                            gm.ui.bgPanel[3].remove(0);
                            gm.ui.goblinFlag = false;
                        }
                        if (gm.monster.getName().equals("Skeletons") && gm.ui.skeleFlag){
                            //gm.ui.messageText.setText("tests");
                            gm.ui.bgPanel[2].remove(0);
                            gm.ui.skeleFlag = false;
                        }
                        gm.ui.addInteractMenu();
                    }
                    gm.ui.addPlayerInfo();
                    
                }
                
                
                
                break;

            case "spell":
                gm.ui.messageText.setText("Choose your spell:"); 
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addSpellMenu();
                break;
                
            case "item":
                gm.ui.messageText.setText("Choose your item:");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addItemMenu();
                break;
                
            case "run":
                gm.ui.messageText.setText("Got away safely!"); 
                gm.ui.messageText.setForeground(Color.white);
                //gm.ui.goBack();
                gm.ui.restoreScene();
                gm.ui.addInteractMenu();
                break; 
                
            case "goback":
                gm.ui.messageText.setText("The " + gm.monster.getName() + " approaches cautiously...");
                gm.ui.addFightMenu();
                break;
                
            case "continue":
                if(gm.ui.bgPanel[2].isVisible()){
                    gm.sceneChanger.showScreen1();
                } else {
                gm.ui.messageText.setText("This will be previous screen"); 
                }
                gm.ui.addFightMenu();
                break;
                
            case "advance":
                gm.ui.messageText.setText("A group of skeletons burst out from their tombs!");
                gm.monster = new Skeletons();
                gm.sceneChanger.showScreen2();
                gm.ui.addFightMenu();
                break;
        }
        
    }
    
    
    
}
