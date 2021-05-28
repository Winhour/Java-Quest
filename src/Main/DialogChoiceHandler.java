/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

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
                if (gm.ui.bgPanel[1].isVisible()){
                    gm.ui.messageText.setText("Ah, the adventure begins...\n Let's ask around for info on the Demon Lord."); 
                }
                else if (gm.ui.bgPanel[2].isVisible()){
                    gm.ui.messageText.setText("Judging by all the Boneheads, I must be getting closer.");
                }
                else if (gm.ui.bgPanel[3].isVisible()){
                    gm.ui.messageText.setText("Goblins, huh? I guess even Demon Lords need cannon fodder.");
                }
                else if (gm.ui.bgPanel[4].isVisible()){
                    gm.ui.messageText.setText("The Mayor of Starhome hired me for the job, so I might as well talk to her.");
                }
                else if (gm.ui.bgPanel[5].isVisible()){
                    gm.ui.messageText.setText("Ok, let's make sure I spend my gold wisely.");
                }
                else if (gm.ui.bgPanel[6].isVisible()){
                    gm.ui.messageText.setText("It's always wise to invest in your weapons, they might save your life.");
                }
                else if (gm.ui.bgPanel[7].isVisible()){
                    gm.ui.messageText.setText("Wonder what they did to piss off that Demon Lord so much.");
                }
                else if (gm.ui.bgPanel[8].isVisible()){
                    gm.ui.messageText.setText("How am I able to carry all this stuff?");
                }
                else {
                    gm.ui.messageText.setText("How in nine hells did I end up here?");
                }
                gm.ui.messageText.setForeground(Color.yellow);
                break;
                
            
            case "item":
                gm.ui.messageText.setText("Choose your item:");
                gm.ui.addItemMenuNonFight();
                break;
                
            case "inventory":
                gm.ui.rememberCurrentScene();
                gm.sceneChanger.showScreen8();
                gm.ui.messageText.setText("Let's see what we're working with here.");
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.addInteractMenu();
                
                gm.ui.choice4.setText("<<<");
                gm.ui.choice4.setActionCommand("restore_scene");
                break;
                
            case "restore_scene":
                
                gm.ui.restoreScene();
                gm.ui.addInteractMenu();
                
                break;
                
                
                
            case "move":
                if (gm.ui.bgPanel[1].isVisible()){
                    gm.ui.addMoveMenu("Town", "Item Shop", "Dungeon", "move_twn2", "move_ishop", "move_gobdun");
                }
                else if (gm.ui.bgPanel[2].isVisible()){
                    gm.ui.addMoveMenu("Outskirts", "Sideroom", "Wooden Door", "move_twn", "move_side", "move_treas1");
                }
                else if (gm.ui.bgPanel[3].isVisible()){
                    gm.ui.addMoveMenu("Outskirts", "Sideroom", "Wooden Door", "move_twn", "move_side", "move_treas1");
                }
                else if (gm.ui.bgPanel[4].isVisible()){
                    gm.ui.addMoveMenu("Outskirts", "Smith", "Town Hall", "move_twn", "move_smith", "move_twnhall");
                }
                else if (gm.ui.bgPanel[5].isVisible()){
                    gm.ui.addMoveMenu("Outskirts", "", "", "move_twn", "", "");
                }
                else if (gm.ui.bgPanel[6].isVisible()){
                    gm.ui.addMoveMenu("Town", "", "", "move_twn2", "", "");
                }
                else if (gm.ui.bgPanel[7].isVisible()){
                    gm.ui.addMoveMenu("Town", "", "", "move_twn2", "", "");
                }
                else {
                    gm.ui.addMoveMenu("Town", "Item Shop", "Dungeon", "move_twn2", "move_ishop", "move_gobdun");
                }
                gm.ui.messageText.setText("Where do you want to go?");
                gm.ui.messageText.setForeground(Color.white);
                break;
                
                
                
            case "move_twn":
                gm.sceneChanger.showScreen1();
                gm.ui.messageText.setText("Back here again...");
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.addInteractMenu();
                break;
                
                
            case "move_twn2":
                gm.sceneChanger.showScreen4();
                gm.ui.messageText.setText("Looks like a place where I can earn some good gold.");
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.addInteractMenu();
                break;    
                
            case "move_ishop":
                gm.sceneChanger.showScreen5();
                gm.ui.messageText.setText("\"What are ya buyin?\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                break;   
                
            case "move_smith":
                gm.sceneChanger.showScreen6();
                gm.ui.messageText.setText("Ah, I love me some clanking noises.");
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.addInteractMenu();
                break;  
                
            case "move_twnhall":
                gm.sceneChanger.showScreen7();
                gm.ui.messageText.setText("There is a pleasant atmosphere in the hall.");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                break;       
            
            case "move_gobdun":
                /*gm.ui.currentScene = 1;
                gm.ui.nextScene = 3;
                gm.sceneChanger.showScreenNext(gm.ui.currentScene, gm.ui.nextScene);*/
                gm.sceneChanger.showScreen3();
                if(gm.ui.goblinFlag){
                    gm.ui.messageText.setText("A goblin appears!"); 
                    gm.ui.messageText.setForeground(Color.white);
                    gm.ui.addFightMenu();
                }
                else {
                    gm.ui.messageText.setText("Hopefully I don't run into more of these annoying things."); 
                    gm.ui.messageText.setForeground(Color.yellow);
                    gm.ui.addInteractMenu();
                }
                break;
                
            case "talk_priest":
                gm.ui.addTalkMenu("Demon Lord", "Religion", "Tips", "dl_priest", "religion", "tips_priest");
                gm.ui.messageText.setText("Ask about: ");
                gm.ui.messageText.setForeground(Color.white);
                break;
            
            case "talk_peasant":
                gm.ui.addTalkMenu("Demon Lord", "Town", "Himself", "dl_peasant", "town_info", "peasant_info");
                gm.ui.messageText.setText("Ask about: ");
                gm.ui.messageText.setForeground(Color.white);
                break;    
                
                
                
                
            /* Asking Priest about the Demon Lord  */    
                
                
                
                
                
            case "dl_priest":
                gm.ui.messageText.setText("\"Who exactly is the Demon Lord? Well, there are a number of theories...\"");        
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choiceButtonPanel.setVisible(false);
                gm.ui.window.remove(gm.ui.choiceButtonPanel);
        
                gm.ui.choiceButtonPanel = new JPanel(new GridLayout(1,1,180,10));
                gm.ui.choiceButtonPanel.setBounds(64, 640, 896, 100);
                gm.ui.choiceButtonPanel.setBackground(Color.black);
                gm.ui.window.add(gm.ui.choiceButtonPanel);
        
                gm.ui.choice1 = new JButton("Continue");
                gm.ui.choice1.setBackground(Color.black);
                gm.ui.choice1.setForeground(Color.white);
                gm.ui.choice1.setFont(new Font("Book Antiqua", Font.PLAIN, 36));
                gm.ui.choice1.addActionListener(gm.dialogChoiceHandler);
                gm.ui.choice1.setActionCommand("dl_priest2");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;
            
            case "dl_priest2":
                gm.ui.messageText.setText("\"Some believe it's the former ruler of this kingdom, seeking revenge...\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("dl_priest3");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;  
                
            case "dl_priest3":
                gm.ui.messageText.setText("\"A lot of other priests say that he's a punishment, sent here due to our sins...\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("dl_priest4");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;    
                
            case "dl_priest4":
                gm.ui.messageText.setText("\"The Yothians talk about end of the world and this being proof...\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("dl_priest5");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;      
                
            case "dl_priest5":
                gm.ui.messageText.setText("\"Well, I think he might just be a spooky Skeleton man.\"");
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.choice1.setActionCommand("dl_priest6");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;     
                
            case "dl_priest6":
                gm.ui.messageText.setText("\"Hoh! To be fair, we just don't really know, do we?\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("nothing");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;  
                
                
                
                
                
                
             /* Asking Priest about religion */   
                
                
                
                
            case "religion":
                gm.ui.messageText.setText("\"So, what do people believe around here?\"");        
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.choiceButtonPanel.setVisible(false);
                gm.ui.window.remove(gm.ui.choiceButtonPanel);
        
                gm.ui.choiceButtonPanel = new JPanel(new GridLayout(1,1,180,10));
                gm.ui.choiceButtonPanel.setBounds(64, 640, 896, 100);
                gm.ui.choiceButtonPanel.setBackground(Color.black);
                gm.ui.window.add(gm.ui.choiceButtonPanel);
        
                gm.ui.choice1 = new JButton("Continue");
                gm.ui.choice1.setBackground(Color.black);
                gm.ui.choice1.setForeground(Color.white);
                gm.ui.choice1.setFont(new Font("Book Antiqua", Font.PLAIN, 36));
                gm.ui.choice1.addActionListener(gm.dialogChoiceHandler);
                gm.ui.choice1.setActionCommand("religion2");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;
                
            case "religion2":
                gm.ui.messageText.setText("\"Hoh! I'm glad you asked. It all started...\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("religion3");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;  
                
            case "religion3":
                gm.ui.messageText.setText("\"The High prophets....Thirteen commandments......Patrocus and Patronicus.....The great schism.....Those damn heretics....\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("religion4");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;   
                
            case "religion4":
                gm.ui.messageText.setText("\"Our poor karma.......Crusaders........Three floods and four droughts..........Savior is coming........They can still repent....\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("religion5");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;  
                
            case "religion5":
                gm.ui.messageText.setText("\"Not zealous enough.......Church and State........Hell do they know?..........Bless the Peasants........The Other Side....\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("religion6");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;   
                
            case "religion6":
                gm.ui.messageText.setText("\"And that's why we can't eat poultry on mondays!\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("religion7");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break; 
                
            case "religion7":
                gm.ui.messageText.setText("\"I'm sorry I asked\"");
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.choice1.setActionCommand("nothing");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;     
                
                
                
            /* Asking Priest about tips */     
                
                
            case "tips_priest":
                gm.ui.messageText.setText("\"So where should I go next?\"");        
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.choiceButtonPanel.setVisible(false);
                gm.ui.window.remove(gm.ui.choiceButtonPanel);
        
                gm.ui.choiceButtonPanel = new JPanel(new GridLayout(1,1,180,10));
                gm.ui.choiceButtonPanel.setBounds(64, 640, 896, 100);
                gm.ui.choiceButtonPanel.setBackground(Color.black);
                gm.ui.window.add(gm.ui.choiceButtonPanel);
        
                gm.ui.choice1 = new JButton("Continue");
                gm.ui.choice1.setBackground(Color.black);
                gm.ui.choice1.setForeground(Color.white);
                gm.ui.choice1.setFont(new Font("Book Antiqua", Font.PLAIN, 36));
                gm.ui.choice1.addActionListener(gm.dialogChoiceHandler);
                gm.ui.choice1.setActionCommand("tips_priest2");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;
                
            case "tips_priest2":
                gm.ui.messageText.setText("\"If you're going after the Demon Lord, I would check around town, ask the Mayor and maybe Gunthar the Smith\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("tips_priest3");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;      
                
            case "tips_priest3":
                gm.ui.messageText.setText("\"I guess that makes sense. Thanks.\"");
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.choice1.setActionCommand("tips_priest4");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;      
                
             case "tips_priest4":
                gm.ui.messageText.setText("\"Hoh! Glad to be of service.\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("nothing");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;    
                
                
           /* Asking Peasant about Demon Lord */
                
            case "dl_peasant":
                 
                gm.ui.messageText.setText("\"What do you know about this so-called Demon Lord?\"");        
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.choiceButtonPanel.setVisible(false);
                gm.ui.window.remove(gm.ui.choiceButtonPanel);
        
                gm.ui.choiceButtonPanel = new JPanel(new GridLayout(1,1,180,10));
                gm.ui.choiceButtonPanel.setBounds(64, 640, 896, 100);
                gm.ui.choiceButtonPanel.setBackground(Color.black);
                gm.ui.window.add(gm.ui.choiceButtonPanel);
        
                gm.ui.choice1 = new JButton("Continue");
                gm.ui.choice1.setBackground(Color.black);
                gm.ui.choice1.setForeground(Color.white);
                gm.ui.choice1.setFont(new Font("Book Antiqua", Font.PLAIN, 36));
                gm.ui.choice1.addActionListener(gm.dialogChoiceHandler);
                gm.ui.choice1.setActionCommand("dl_peasant2");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break; 
                 

            case "dl_peasant2":
                gm.ui.messageText.setText("\"A lot of innocent people and reckless adventurers have been winding up dead recently.\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("dl_peasant3");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;   
                
            case "dl_peasant3":
                gm.ui.messageText.setText("\"Must be due to how close that damned dungeon is to this town.\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("dl_peasant4");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;   
                
            case "dl_peasant4":
                gm.ui.messageText.setText("\"If death is what you seek, that's where you should look.\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("dl_peasant5");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;     
                
            case "dl_peasant5":
                gm.ui.messageText.setText("\"Don't worry, I've been through worse.\"");
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.choice1.setActionCommand("nothing");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;    
                
            /* Asking Peasant about the Town */  
                
            case "town_info":
                
                gm.ui.messageText.setText("\"Way I've been told is this town has been founded close to where a Star fell\"");        
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choiceButtonPanel.setVisible(false);
                gm.ui.window.remove(gm.ui.choiceButtonPanel);
        
                gm.ui.choiceButtonPanel = new JPanel(new GridLayout(1,1,180,10));
                gm.ui.choiceButtonPanel.setBounds(64, 640, 896, 100);
                gm.ui.choiceButtonPanel.setBackground(Color.black);
                gm.ui.window.add(gm.ui.choiceButtonPanel);
        
                gm.ui.choice1 = new JButton("Continue");
                gm.ui.choice1.setBackground(Color.black);
                gm.ui.choice1.setForeground(Color.white);
                gm.ui.choice1.setFont(new Font("Book Antiqua", Font.PLAIN, 36));
                gm.ui.choice1.addActionListener(gm.dialogChoiceHandler);
                gm.ui.choice1.setActionCommand("town_info2");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break; 
                
            case "town_info2":   
                
                gm.ui.messageText.setText("\"Happened a long time ago... A Meteor people call it.\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("town_info3");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;   
                
            case "town_info3":   
                
                gm.ui.messageText.setText("\"I guess that the dungeon down south was originally created during the impact.\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("town_info4");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;    
                
            case "town_info4":   
                
                gm.ui.messageText.setText("\"It's a pretty small town these days, but I like it that way. Wouldn't change it one bit!\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("town_info5");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;   
                
            case "town_info5":   
                
                gm.ui.messageText.setText("\"Aside from all the monsters wandering around lately, I guess.\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("town_info6");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;     
            
            case "town_info6":   
                
                gm.ui.messageText.setText("\"Hmmm...\"");
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.choice1.setActionCommand("nothing");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;     
                
                
            /* Asking Peasant about himself */
                
            case "peasant_info":    
                
                gm.ui.messageText.setText("\"So, how's the livestock these days?\"");        
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.choiceButtonPanel.setVisible(false);
                gm.ui.window.remove(gm.ui.choiceButtonPanel);
        
                gm.ui.choiceButtonPanel = new JPanel(new GridLayout(1,1,180,10));
                gm.ui.choiceButtonPanel.setBounds(64, 640, 896, 100);
                gm.ui.choiceButtonPanel.setBackground(Color.black);
                gm.ui.window.add(gm.ui.choiceButtonPanel);
        
                gm.ui.choice1 = new JButton("Continue");
                gm.ui.choice1.setBackground(Color.black);
                gm.ui.choice1.setForeground(Color.white);
                gm.ui.choice1.setFont(new Font("Book Antiqua", Font.PLAIN, 36));
                gm.ui.choice1.addActionListener(gm.dialogChoiceHandler);
                gm.ui.choice1.setActionCommand("peasant_info2");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break; 
                
            case "peasant_info2":   
                
                gm.ui.messageText.setText("\"Not great, the Goblins stole half of the cows last week...\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("peasant_info3");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;      
                
            case "peasant_info3":   
                
                gm.ui.messageText.setText("\"Those sneaky buggers will know the wrath of my pitchfork when I catch them!\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("peasant_info4");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;    
                
            case "peasant_info4":   
                
                gm.ui.messageText.setText("\"Let the adventurers deal with them. You'd just get yourself killed.\"");
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.choice1.setActionCommand("peasant_info5");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break; 
                
            case "peasant_info5":
                
                gm.ui.messageText.setText("\"You think i can't deal with those demon spawns by myself? Come at me m'lord.\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("peasant_info6");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break; 
                
            case "peasant_info6":
                
                gm.ui.messageText.setText("\"I'd rather not.\"");
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.choice1.setActionCommand("nothing");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;    
                
                
            /* Priest interact */    
                
            case "interact_priest":
                
                gm.ui.messageText.setText("\"Would you like me to heal you for a mere donation of 20 gold?\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Sure!", "No Way", "priest_heal", "nothing");

                break;
                
            case "priest_heal":
                
                if (gm.playerInfo.getCash() >= 20){
                
                    gm.ui.messageText.setText("You feel a refreshing magic surging through you!\n Fully recovered HP and Mana.");
                    gm.playerInfo.setCash(gm.playerInfo.getCash()-20);
                    gm.playerInfo.setHealth(gm.playerInfo.getMaxhealth());
                    gm.playerInfo.setMana(gm.playerInfo.getMaxmana());
                    
                    gm.ui.addPlayerInfo();
                    
                } else {
                    gm.ui.messageText.setText("\"If you're good at something, never do it for free. That's what they say, Hoh!\"");
                    gm.ui.messageText.setForeground(Color.white);
                    
                }
                
                gm.ui.addInteractMenu();
                
                break;
                
            
                
            case "interact_peasant":
                
                gm.ui.messageText.setText("\"Eh, I'd rather not.\"");
                gm.ui.messageText.setForeground(Color.yellow);
                
                break;
                
            /* Priest look */  
                
            case "look_priest":   
                
                gm.ui.messageText.setText("\"Looks like the kind of guy that might know a thing or two, doesn't hurt to ask.\"");
                gm.ui.messageText.setForeground(Color.yellow);

                break;
                
           /* Peasant look */     
                
            case "look_peasant":
                
                gm.ui.messageText.setText("\"You see these kind of poor fellows quite a bit these days. I guess that's feudalism for ya.\"");
                gm.ui.messageText.setForeground(Color.yellow);

                break;
                
            case "look_mayor":
                
                gm.ui.messageText.setText("\"Well, hello there\"");
                gm.ui.messageText.setForeground(Color.yellow);

                break;
                
            case "nothing":
                gm.ui.addInteractMenu();
                if (gm.ui.bgPanel[8].isVisible()){
                    gm.ui.choice4.setText("<<<");
                    gm.ui.choice4.setActionCommand("restore_scene");
                }
                gm.ui.messageText.setText("What shall I do next?"); 
                gm.ui.messageText.setForeground(Color.yellow);
                break;
            
        }
        
    }
    
}
