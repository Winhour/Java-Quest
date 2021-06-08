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
    SoundEffect se = new SoundEffect();
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
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/heal_sound_s.wav");
                    se.play();
                
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()+10);

                    if (gm.playerInfo.getHealth() > gm.playerInfo.getMaxhealth()) gm.playerInfo.setHealth(gm.playerInfo.getMaxhealth());
                    
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);
                    if (gm.playerInfo.getHealth()<=0){
                            gm.combatChoiceHandler.loseState();
                        }

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
                
            case "S Potionnc":
                
                if (gm.playerInfo.getHealth() == gm.playerInfo.getMaxhealth()){
                    gm.ui.messageText.setText("Your health is full!");
                }
                else {
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/heal_sound_s.wav");
                    se.play();
                
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()+10);

                    if (gm.playerInfo.getHealth() > gm.playerInfo.getMaxhealth()) gm.playerInfo.setHealth(gm.playerInfo.getMaxhealth());
                    
                    gm.ui.messageText.setText(gm.potion.getEffectMessage());

                    for (int i=8;i>=0;i--){
                        if (gm.itemlist[i] != null && gm.itemlist[i].getName().equals("S Potion")){
                            gm.itemlist[i] = null;
                            break;
                        }
                    }

                    gm.ui.addPlayerInfo();
                }
                gm.ui.addInteractMenu();
                break;   
                
            case "M Potion":
                
                damageRoll2 = rand.nextInt(3);
                
                if (gm.playerInfo.getHealth() == gm.playerInfo.getMaxhealth()){
                    gm.ui.messageText.setText("Your health is full!");
                }
                else {
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/heal_sound_s.wav");
                    se.play();
                
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()+25);

                    if (gm.playerInfo.getHealth() > gm.playerInfo.getMaxhealth()) gm.playerInfo.setHealth(gm.playerInfo.getMaxhealth());
                    
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);
                    if (gm.playerInfo.getHealth()<=0){
                            gm.combatChoiceHandler.loseState();
                        }

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
                
            case "M Potionnc":
                
                if (gm.playerInfo.getHealth() == gm.playerInfo.getMaxhealth()){
                    gm.ui.messageText.setText("Your health is full!");
                }
                else {
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/heal_sound_s.wav");
                    se.play();
                
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()+25);

                    if (gm.playerInfo.getHealth() > gm.playerInfo.getMaxhealth()) gm.playerInfo.setHealth(gm.playerInfo.getMaxhealth());

                    gm.ui.messageText.setText(gm.potion3.getEffectMessage()); 

                    for (int i=8;i>=0;i--){
                        if (gm.itemlist[i] != null && gm.itemlist[i].getName().equals("M Potion")){
                            gm.itemlist[i] = null;
                            break;
                        }
                    }

                    gm.ui.addPlayerInfo();
                }
                gm.ui.addInteractMenu();
                break;    
                
                
            case "L Potion":
                
                damageRoll2 = rand.nextInt(3);
                
                if (gm.playerInfo.getHealth() == gm.playerInfo.getMaxhealth()){
                    gm.ui.messageText.setText("Your health is full!");
                }
                else {
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/heal_sound_s.wav");
                    se.play();
                
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()+60);

                    if (gm.playerInfo.getHealth() > gm.playerInfo.getMaxhealth()) gm.playerInfo.setHealth(gm.playerInfo.getMaxhealth());
                    
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);
                    if (gm.playerInfo.getHealth()<=0){
                            gm.combatChoiceHandler.loseState();
                        }

                    gm.ui.messageText.setText("You recovered 60 health!" + "\n" + "The " + gm.monster.getName() + " attacks you for " + damageRoll2); 

                    for (int i=8;i>=0;i--){
                        if (gm.itemlist[i] != null && gm.itemlist[i].getName().equals("L Potion")){
                            gm.itemlist[i] = null;
                            break;
                        }
                    }

                    gm.ui.addPlayerInfo();
                }
                gm.ui.addFightMenu();
                break;
                
            case "L Potionnc":
                
                if (gm.playerInfo.getHealth() == gm.playerInfo.getMaxhealth()){
                    gm.ui.messageText.setText("Your health is full!");
                }
                else {
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/heal_sound_s.wav");
                    se.play();
                
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()+60);

                    if (gm.playerInfo.getHealth() > gm.playerInfo.getMaxhealth()) gm.playerInfo.setHealth(gm.playerInfo.getMaxhealth());
                    
                    gm.ui.messageText.setText("You recovered 60 health!");

                    for (int i=8;i>=0;i--){
                        if (gm.itemlist[i] != null && gm.itemlist[i].getName().equals("L Potion")){
                            gm.itemlist[i] = null;
                            break;
                        }
                    }

                    gm.ui.addPlayerInfo();
                }
                gm.ui.addInteractMenu();
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
                    if (gm.playerInfo.getHealth()<=0){
                        gm.combatChoiceHandler.loseState();
                    }

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
                
            case "S Elixirnc":
                
                if (gm.playerInfo.getMana() == gm.playerInfo.getMaxmana()){
                    gm.ui.messageText.setText("Your mana is full!");
                }
                else {
                
                    gm.playerInfo.setMana(gm.playerInfo.getMana()+10);

                    if (gm.playerInfo.getMana() > gm.playerInfo.getMaxmana()) gm.playerInfo.setMana(gm.playerInfo.getMaxmana());

                    gm.ui.messageText.setText(gm.elixir.getEffectMessage()); 

                    for (int i=8;i>=0;i--){
                        if (gm.itemlist[i] != null && gm.itemlist[i].getName().equals("S Elixir")){
                            gm.itemlist[i] = null;
                            break;
                        }
                    }

                    gm.ui.addPlayerInfo();
                }
                gm.ui.addInteractMenu();
                break;   
                
                
            case "M Elixir":
                
                damageRoll2 = rand.nextInt(3);
                
                if (gm.playerInfo.getMana() == gm.playerInfo.getMaxmana()){
                    gm.ui.messageText.setText("Your mana is full!");
                }
                else {
                
                    gm.playerInfo.setMana(gm.playerInfo.getMana()+20);

                    if (gm.playerInfo.getMana() > gm.playerInfo.getMaxmana()) gm.playerInfo.setMana(gm.playerInfo.getMaxmana());
                    
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);
                    if (gm.playerInfo.getHealth()<=0){
                            gm.combatChoiceHandler.loseState();
                    }

                    gm.ui.messageText.setText("You recovered 20 mana!" + "\n" + "The " + gm.monster.getName() + " attacks you for " + damageRoll2); 

                    for (int i=8;i>=0;i--){
                        if (gm.itemlist[i] != null && gm.itemlist[i].getName().equals("M Elixir")){
                            gm.itemlist[i] = null;
                            break;
                        }
                    }

                    gm.ui.addPlayerInfo();
                }
                gm.ui.addFightMenu();
                break;    
                
            case "M Elixirnc":
                
                if (gm.playerInfo.getMana() == gm.playerInfo.getMaxmana()){
                    gm.ui.messageText.setText("Your mana is full!");
                }
                else {
                
                    gm.playerInfo.setMana(gm.playerInfo.getMana()+20);

                    if (gm.playerInfo.getMana() > gm.playerInfo.getMaxmana()) gm.playerInfo.setMana(gm.playerInfo.getMaxmana());

                    gm.ui.messageText.setText("You recovered 20 mana!"); 

                    for (int i=8;i>=0;i--){
                        if (gm.itemlist[i] != null && gm.itemlist[i].getName().equals("M Elixir")){
                            gm.itemlist[i] = null;
                            break;
                        }
                    }

                    gm.ui.addPlayerInfo();
                }
                gm.ui.addInteractMenu();
                break;      
                
             
            case "L Elixir":
                
                damageRoll2 = rand.nextInt(3);
                
                if (gm.playerInfo.getMana() == gm.playerInfo.getMaxmana()){
                    gm.ui.messageText.setText("Your mana is full!");
                }
                else {
                
                    gm.playerInfo.setMana(gm.playerInfo.getMaxmana());

                    if (gm.playerInfo.getMana() > gm.playerInfo.getMaxmana()) gm.playerInfo.setMana(gm.playerInfo.getMaxmana());
                    
                    gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);
                    if (gm.playerInfo.getHealth()<=0){
                            gm.combatChoiceHandler.loseState();
                    }

                    gm.ui.messageText.setText("You fully recovered your mana!" + "\n" + "The " + gm.monster.getName() + " attacks you for " + damageRoll2); 

                    for (int i=8;i>=0;i--){
                        if (gm.itemlist[i] != null && gm.itemlist[i].getName().equals("L Elixir")){
                            gm.itemlist[i] = null;
                            break;
                        }
                    }

                    gm.ui.addPlayerInfo();
                }
                gm.ui.addFightMenu();
                break;    
                
            case "L Elixirnc":
                
                if (gm.playerInfo.getMana() == gm.playerInfo.getMaxmana()){
                    gm.ui.messageText.setText("Your mana is full!");
                }
                else {
                
                    gm.playerInfo.setMana(gm.playerInfo.getMaxmana());

                    if (gm.playerInfo.getMana() > gm.playerInfo.getMaxmana()) gm.playerInfo.setMana(gm.playerInfo.getMaxmana());

                    gm.ui.messageText.setText("You fully recovered your mana!"); 

                    for (int i=8;i>=0;i--){
                        if (gm.itemlist[i] != null && gm.itemlist[i].getName().equals("L Elixir")){
                            gm.itemlist[i] = null;
                            break;
                        }
                    }

                    gm.ui.addPlayerInfo();
                }
                gm.ui.addInteractMenu();
                break;          
                
                
            case "empty":
                gm.ui.messageText.setText("It's unlikely this empty space will be too much help..."); 
                gm.ui.addFightMenu();
                break;
            
            case "emptync":
                gm.ui.messageText.setText("As nice it would be if something was in this space, alas it is not."); 
                gm.ui.addInteractMenu();
                break;    
        }
        
    }
    
}
