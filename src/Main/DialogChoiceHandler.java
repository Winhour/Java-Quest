/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.monsters.Bear;
import Main.monsters.Goblin;
import Main.monsters.LichLord;
import Main.monsters.Skeletons;
import Main.monsters.Zombie;
import items.LargeElixir;
import items.LargeHealthPotion;
import items.MediumElixir;
import items.MediumHealthPotion;
import items.SmallElixir;
import items.SmallHealthPotion;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author Marcin
 */
public class DialogChoiceHandler implements ActionListener{
    
    GameManager gm;
    SoundEffect se = new SoundEffect();
    //SoundEffect se = gm.context.getBean("se", SoundEffect.class);
    //SoundEffect se;
    
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
                else if (gm.ui.bgPanel[9].isVisible()){
                    gm.ui.messageText.setText("This must be the Dungeon.");
                }
                else if (gm.ui.bgPanel[10].isVisible()){
                    gm.ui.messageText.setText("Hope I never have to fight a Bear again.");
                }
                else if (gm.ui.bgPanel[11].isVisible()){
                    gm.ui.messageText.setText("Let's press on forward.");
                }
                else if (gm.ui.bgPanel[12].isVisible()){
                    gm.ui.messageText.setText("A dead end?");
                }
                else if (gm.ui.bgPanel[13].isVisible()){
                    gm.ui.messageText.setText("Kind of creepy...");
                }
                else if (gm.ui.bgPanel[14].isVisible()){
                    gm.ui.messageText.setText("What were they mining here? And who did exactly?");
                }
                else if (gm.ui.bgPanel[15].isVisible()){
                    gm.ui.messageText.setText("I pity the fools that ended their lives here.");
                }
                else if (gm.ui.bgPanel[16].isVisible()){
                    gm.ui.messageText.setText("They have their own armory here and all? I might have hit the jackpot (or a medieval equivalent)!");
                }
                else if (gm.ui.bgPanel[17].isVisible()){
                    gm.ui.messageText.setText("Comfy desk for a dungeon if you ask me.");
                }
                else if (gm.ui.bgPanel[18].isVisible()){
                    gm.ui.messageText.setText("Let's make sure I have everything I need before the final battle.");
                }
                else if (gm.ui.bgPanel[19].isVisible()){
                    gm.ui.messageText.setText("When this is all over, I'll come back here and gather all this loot.");
                }
                else if (gm.ui.bgPanel[20].isVisible()){
                    gm.ui.messageText.setText("The battle is finally over.");
                }
                else if (gm.ui.bgPanel[21].isVisible()){
                    gm.ui.messageText.setText("Did she make it in Paint or something?");
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
                
                if (!gm.ui.bgPanel[21].isVisible()){
                    gm.ui.rememberCurrentScene();
                }
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
                gm.ui.messageText.setText("What shall I do next?");
                gm.ui.messageText.setForeground(Color.yellow);
                
                break;
                
                
                
            case "move":
                if (gm.ui.bgPanel[1].isVisible()){
                    gm.ui.addMoveMenu("Town", "Item Shop", "Dungeon", "move_twn2", "move_ishop", "move_dunent");
                }
                else if (gm.ui.bgPanel[2].isVisible()){
                    gm.ui.addMoveMenu("Stairway", "Mine", "Metal Door", "move_treas1", "move_mine", "move_hub");
                }
                else if (gm.ui.bgPanel[3].isVisible()){
                    gm.ui.addMoveMenu("Entrance", "Sideroom", "Wooden Door", "move_dunent", "move_side", "move_treas1");
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
                else if (gm.ui.bgPanel[9].isVisible()){
                    gm.ui.addMoveMenu("Outskirts", "Woods", "Inside", "move_twn_back", "move_woods", "move_gobdun");
                }
                else if (gm.ui.bgPanel[10].isVisible()){
                    gm.ui.addMoveMenu("Entrance", "", "", "move_dunent", "", "");
                }
                else if (gm.ui.bgPanel[11].isVisible()){
                    gm.ui.addMoveMenu("Wooden Door", "Stairway", "Chapel", "move_gobdun", "move_skedun", "move_chapel");
                }
                else if (gm.ui.bgPanel[12].isVisible()){
                    gm.ui.addMoveMenu("Main Path", "Prison", "", "move_gobdun", "move_prison", "");
                }
                else if (gm.ui.bgPanel[13].isVisible()){
                    gm.ui.addMoveMenu("Hallway", "", "", "move_treas1", "", "");
                }
                else if (gm.ui.bgPanel[14].isVisible()){
                    gm.ui.addMoveMenu("Catacombs", "", "", "move_skedun", "", "");
                }
                else if (gm.ui.bgPanel[15].isVisible()){
                    gm.ui.addMoveMenu("Sideroom", "Armory", "", "move_side", "move_armory", "");
                }
                else if (gm.ui.bgPanel[16].isVisible()){
                    gm.ui.addMoveMenu("Prison", "Desk", "", "move_prison", "move_desk", "");
                }
                else if (gm.ui.bgPanel[17].isVisible()){
                    gm.ui.addMoveMenu("Armory", "", "", "move_armory", "", "");
                }
                else if (gm.ui.bgPanel[18].isVisible()){
                    gm.ui.addMoveMenu("Metal Door", "Treasure Room", "???", "move_skedun", "move_treas2", "move_boss");
                }
                else if (gm.ui.bgPanel[19].isVisible()){
                    gm.ui.addMoveMenu("Crossroads", "", "", "move_hub", "", "");
                }
                else if (gm.ui.bgPanel[20].isVisible()){
                    gm.ui.addMoveMenu("Crossroads", "", "", "move_hub", "", "");
                }
                else {
                    gm.ui.addMoveMenu("Town", "Item Shop", "Dungeon", "move_twn2", "move_ishop", "move_gobdun");
                }
                gm.ui.messageText.setText("Where do you want to go?");
                gm.ui.messageText.setForeground(Color.white);
                break;
                
                
                
            case "move_twn":
                gm.sceneChanger.showScreen1();
                gm.ui.messageText.setText("I think I'm ready to set off.");
                gm.ui.messageText.setForeground(Color.yellow);
                gm.ui.addInteractMenu();
                break;
                
            case "move_twn_back":
                gm.music.stop();
                gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_one.wav");
                gm.music.play_low();
                gm.music.loop();
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
                
            case "move_dunent":
                gm.sceneChanger.showScreen9();
                gm.ui.messageText.setText("You arrive at the entrance to the Dungeon.");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                break;     
                
            case "move_woods":
                gm.ui.rememberCurrentScene();
                gm.sceneChanger.showScreen10();
                if(gm.ui.bearFlag){
                    gm.ui.combatFlag = true;
                    gm.monster = gm.context.getBean("bear", Bear.class);
                    gm.music.stop();
                    gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/Fight.wav");
                    gm.music.play_low();
                    gm.music.loop();
                    gm.ui.messageText.setText("You come across an enraged bear!"); 
                    gm.ui.messageText.setForeground(Color.white);
                    gm.ui.addFightMenu();
                }
                else {
                    gm.music.stop();
                    gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_tavern.wav");
                    gm.music.play_low();
                    gm.music.loop();
                    gm.ui.messageText.setText("You hear sounds of nature all around.");
                    gm.ui.messageText.setForeground(Color.white);
                    gm.ui.addInteractMenu();
                }
                break;      
                
            case "move_treas1" :
                gm.sceneChanger.showScreen11();
                gm.ui.messageText.setText("You progress further down into the dungeon.");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                break; 
                
            case "move_side":
                gm.sceneChanger.showScreen12();
                gm.ui.messageText.setText("This path seems to lead to some sort of prison...");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                break;     
                
            case "move_chapel":
                gm.sceneChanger.showScreen13();
                gm.ui.messageText.setText("A headless knight is praying near a bloodsoaked altar.");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                break;      
                
            case "move_mine":
                gm.sceneChanger.showScreen14();
                gm.ui.messageText.setText("You find an abandoned mine.");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                break; 
                
            case "move_hub":
                if (!gm.ui.goldkeyFlag){
                    gm.ui.messageText.setText("This door needs a key to open.");
                    gm.ui.messageText.setForeground(Color.white);
                } else {
                    gm.sceneChanger.showScreen18();
                    gm.ui.messageText.setText("An ominous feeling of dread fills the air. The Demon Lord must be close..");
                    gm.ui.messageText.setForeground(Color.white);
                    gm.ui.addInteractMenu();
                }
                
                break;
            
            case "move_gobdun":
                gm.ui.rememberCurrentScene();
                
                gm.sceneChanger.showScreen3();
                if(gm.ui.goblinFlag){
                    gm.ui.bgPanel[3].getComponent(0).setVisible(false);
                    gm.ui.bgPanel[3].getComponent(1).setVisible(false);
                    gm.ui.bgPanel[3].getComponent(2).setVisible(false);
                    gm.ui.combatFlag = true;
                    gm.monster = gm.context.getBean("goblin", Goblin.class);
                    gm.music.stop();
                    gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/Fight.wav");
                    gm.music.play_low();
                    gm.music.loop();
                    gm.ui.messageText.setText("A goblin appears!"); 
                    gm.ui.messageText.setForeground(Color.white);
                    gm.ui.addFightMenu();
                }
                else {
                    gm.music.stop();
                    gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_adventure.wav");
                    gm.music.play_low();
                    gm.music.loop();
                    gm.ui.messageText.setText("Hopefully I don't run into more of these annoying things."); 
                    gm.ui.messageText.setForeground(Color.yellow);
                    gm.ui.addInteractMenu();
                }
                break;
                
            case "move_skedun":
                gm.ui.rememberCurrentScene();
                gm.sceneChanger.showScreen2();
                if(gm.ui.skeleFlag){
                    gm.ui.combatFlag = true;
                    gm.monster = gm.context.getBean("skeletons", Skeletons.class);
                    gm.music.stop();
                    gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/Fight.wav");
                    gm.music.play_low();
                    gm.music.loop();
                    gm.ui.messageText.setText("The dead burst out from their tombs!"); 
                    gm.ui.messageText.setForeground(Color.white);
                    gm.ui.addFightMenu();
                }
                else {
                    gm.music.stop();
                    gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_adventure.wav");
                    gm.music.play_low();
                    gm.music.loop();
                    gm.ui.messageText.setText("I wonder what's in that room..."); 
                    gm.ui.messageText.setForeground(Color.yellow);
                    gm.ui.addInteractMenu();
                }
                
                break;    
                
            case "move_prison":
                
                gm.ui.rememberCurrentScene();
                gm.sceneChanger.showScreen15();
                
                
                if(gm.ui.zombieFlag){
                    gm.ui.combatFlag = true;
                    gm.monster = gm.context.getBean("zombie", Zombie.class);
                    gm.music.stop();
                    gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/Fight.wav");
                    gm.music.play_low();
                    gm.music.loop();
                    gm.ui.messageText.setText("A zombie appears from inside the cells!"); 
                    gm.ui.messageText.setForeground(Color.white);
                    gm.ui.addFightMenu();
                }
                else {
                    gm.music.stop();
                    gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_adventure.wav");
                    gm.music.play_low();
                    gm.music.loop();
                    gm.ui.messageText.setText("This place gives me the creeps."); 
                    gm.ui.messageText.setForeground(Color.yellow);
                    gm.ui.addInteractMenu();
                }
                
                break;
                
            case "move_armory":
                gm.sceneChanger.showScreen16();
                gm.ui.messageText.setText("An abandoned armory appears before you.");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                break; 
                
            case "move_desk":
                gm.sceneChanger.showScreen17();
                gm.ui.messageText.setText("You notice various items scattered on the desk.");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                break;     
                
            case "move_treas2":
                
                gm.sceneChanger.showScreen19();
                gm.ui.messageText.setText("You come across Demon Lord's vault.");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                
                break;
                
            case "move_boss":    
                
                gm.ui.rememberCurrentScene();
                gm.sceneChanger.showScreen20();
                
                if(gm.ui.demonFlag){
                    gm.ui.combatFlag = true;
                    gm.monster = gm.context.getBean("dlord", LichLord.class);
                    gm.music.stop();
                    gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/Boss.wav");
                    gm.music.play_low();
                    gm.music.loop();
                    gm.ui.messageText.setText("Foolish mortal, you're no match for me!!"); 
                    gm.ui.messageText.setForeground(Color.red);
                    gm.ui.addFightMenu();
                }
                else {
                    gm.music.stop();
                    gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_adventure.wav");
                    gm.music.play_low();
                    gm.music.loop();
                    gm.ui.messageText.setText("The remains of our epic battle are still here..."); 
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
                
            case "talk_smith":
                gm.ui.addTalkMenu("Demon Lord", "Town", "Tips", "dl_smith", "smith_info", "tips_smith");
                gm.ui.messageText.setText("Ask about: ");
                gm.ui.messageText.setForeground(Color.white);
                break;    
                
            case "talk_hunter":
                gm.ui.addTalkMenu("Dungeon", "Hunting", "Woods", "dungeon_info", "hunting_talk", "woods_info");
                gm.ui.messageText.setText("Ask about: ");
                gm.ui.messageText.setForeground(Color.white);
                break;    
                
            case "talk_mayor":
                gm.ui.addTalkMenu("Demon Lord", "Quest", "Town", "dl_mayor", "quest_info", "town_mayor");
                gm.ui.messageText.setText("Ask about: ");
                gm.ui.messageText.setForeground(Color.white);
                break; 
                
            case "talk_merch":
                gm.ui.addTalkMenu("Buy items", "Business", "Need anything?", "merch_items", "merch_business", "merch_quest");
                gm.ui.messageText.setText("Ask about: ");
                gm.ui.messageText.setForeground(Color.white);
                break; 
                
                
                
            /* Asking Priest about the Demon Lord  */    
                

            case "dl_priest":
               
                talk_first("\"Who exactly is the Demon Lord? Well, there are a number of theories...\"", "dl_priest2", Color.white);
                
                break;
            
            case "dl_priest2":
                
                talk_next("\"Some believe it's the former ruler of this kingdom, seeking revenge...\"", "dl_priest3", Color.white);
                
                break;  
                
            case "dl_priest3":
                
                talk_next("\"A lot of other priests say that he's a punishment, sent here due to our sins...\"", "dl_priest4", Color.white);
                
                break;    
                
            case "dl_priest4":
                
                talk_next("\"The Yothians talk about end of the world and this being proof...\"", "dl_priest5", Color.white);
                
                break;      
                
            case "dl_priest5":
                
                talk_next("\"Well, I think he might just be a spooky Skeleton man.\"", "dl_priest6", Color.yellow);
                
                break;     
                
            case "dl_priest6":
                
                talk_next("\"Hoh! To be fair, we just don't really know, do we?\"", "nothing", Color.white);
                
                break;  
                
                

                
             /* Asking Priest about religion */   
                
                
                
                
            case "religion":
                
                talk_first("\"So, what do people believe around here?\"", "religion2", Color.yellow);
                
                break;
                
            case "religion2":
                
                talk_next("\"Hoh! I'm glad you asked. It all started...\"", "religion3", Color.white);
                
                break;  
                
            case "religion3":
                
                talk_next("\"The High prophets....Thirteen commandments......Patrocus and Patronicus.....The great schism.....Those damn heretics....\"", "religion4", Color.white);
                
                break;   
                
            case "religion4":
                
                talk_next("\"Our poor karma.......Crusaders........Three floods and four droughts..........Savior is coming........They can still repent....\"", "religion5", Color.white);
                
                break;  
                
            case "religion5":
                
                talk_next("\"Not zealous enough.......Church and State........Hell do they know?..........Bless the Peasants........The Other Side....\"", "religion6", Color.white);
                
                break;   
                
            case "religion6":
                
                talk_next("\"And that's why we can't eat poultry on mondays!\"", "religion7", Color.white);
                
                break; 
                
            case "religion7":
                
                talk_next("\"I'm sorry I asked\"", "nothing", Color.yellow);
                
                break;     
                
                
                
            /* Asking Priest about tips */     
                
                
            case "tips_priest":
                
                talk_first("\"So where should I go next?\"", "tips_priest2", Color.yellow);
                
                break;
                
            case "tips_priest2":
                
                talk_next("\"If you're going after the Demon Lord, I would check around town, ask the Mayor and maybe Gunthar the Smith\"", "tips_priest3", Color.white);
                
                break;      
                
            case "tips_priest3":
                
                talk_next("\"I guess that makes sense. Thanks.\"", "tips_priest4", Color.yellow);
                
                break;      
                
             case "tips_priest4":
                
                talk_next("\"Hoh! Glad to be of service.\"", "nothing", Color.white);
                
                break;    
                
                
           /* Asking Peasant about Demon Lord */
                
                
            case "dl_peasant":
                
                talk_first("\"What do you know about this so-called Demon Lord?\"", "dl_peasant2", Color.yellow);
                
                break; 


            case "dl_peasant2":
                
                talk_next("\"A lot of innocent people and reckless adventurers have been winding up dead recently.\"", "dl_peasant3", Color.white);
                
                break;   
                
            case "dl_peasant3":
                
                talk_next("\"Must be due to how close that damned dungeon is to this town.\"", "dl_peasant4", Color.white);
                
                break;   
                
            case "dl_peasant4":
                
                talk_next("\"If death is what you seek, that's where you should look.\"", "dl_peasant5", Color.white);
                
                break;     
                
            case "dl_peasant5":
                
                talk_next("\"Don't worry, I've been through worse.\"", "nothing", Color.yellow);
                
                break;    
                
                
            /* Asking Peasant about the Town */  
                
                
            case "town_info":

                talk_first("\"Way I've been told is this town has been founded close to where a Star fell\"", "town_info2", Color.white);
                
                break; 
                
            case "town_info2":   
                
                talk_next("\"Happened a long time ago... A Meteor people call it.\"", "town_info3", Color.white);
                
                break;   
                
            case "town_info3":   
                
                talk_next("\"I guess that the dungeon down south was originally created during the impact.\"", "town_info4", Color.white);
                
                break;    
                
            case "town_info4":   
                
                talk_next("\"It's a pretty small town these days, but I like it that way. Wouldn't change it one bit!\"", "town_info5", Color.white);
                
                break;   
                
            case "town_info5":   
                
                talk_next("\"Aside from all the monsters wandering around lately, I guess.\"", "town_info6", Color.white);
                
                break;     
            
            case "town_info6":   
                
                talk_next("\"Hmmm...\"", "nothing", Color.yellow);
                
                break;     
                
                
            /* Asking Peasant about himself */
                
            case "peasant_info":    

                talk_first("\"So, how's the livestock these days?\"", "peasant_info2", Color.yellow);
                
                break;
                
            case "peasant_info2":   
                
                talk_next("\"Not great, the Goblins stole half of the cows last week...\"", "peasant_info3", Color.white);
                
                break;      
                
            case "peasant_info3":   
                
                talk_next("\"Those sneaky buggers will know the wrath of my pitchfork when I catch them!\"", "peasant_info4", Color.white);
                
                break;    
                
            case "peasant_info4":   
                
                talk_next("\"Let the adventurers deal with them. You'd just get yourself killed.\"", "peasant_info5", Color.yellow);
                
                break; 
                
            case "peasant_info5":

                talk_next("\"You think i can't deal with those demon spawns by myself? Come at me m'lord.\"", "peasant_info6", Color.white);
                
                break; 
                
            case "peasant_info6":
                
                talk_next("\"I'd rather not.\"", "nothing", Color.yellow);
                
                break;    
                
                
            /* Asking the Hunter about Dungeon */    
                
            case "dungeon_info":
                
                talk_first("\"Interested in the dungeon, huh?\"", "dungeon_info2", Color.white);
                
                break; 
                
            case "dungeon_info2":

                talk_next("\"I don't really go inside myself, not enough room for a bowman like me\"", "dungeon_info3", Color.white);
                
                break;        
                
            case "dungeon_info3":
                
                talk_next("\"I've seen too many good men go against the Demon Lord and never come out\"", "dungeon_info4", Color.white);
                
                break;      
                
            case "dungeon_info4":
                
                talk_next("\"I prefer to hang around here and pick off stray goblins, I could use the exp you see\"", "dungeon_info5", Color.white);
                
                break;     
                
            case "dungeon_info5":
                
                talk_next("\"...\"", "nothing", Color.yellow);
                
                break;         
                
            /* Asking the Hunter about Hunting */     
                
            case "hunting_talk":
                
                talk_first("\"My lord sent me out here to get him a bear pelt\"", "hunting_talk2", Color.white);
                
                break;     
                
            case "hunting_talk2":
                
                talk_next("\"Klethys, he says, your archery skills are unmatched in the realm\"", "hunting_talk3", Color.white);
                
                break;         
                
            case "hunting_talk3":

                talk_next("\"The thing is... Bears are dangerous creatures, they close the distance to you in an instant\"", "hunting_talk4", Color.white);
                
                break;      
                
            case "hunting_talk4":
                
                talk_next("\"I would prefer not to put myself in the harm's way if possible\"", "hunting_talk5", Color.white);
                
                break;     
                
            case "hunting_talk5":
                
                talk_next("\"Tell you what, if you can get me a bear hide, I'll give you this nice sword in return\"", "hunting_talk6", Color.white);
                
                break;       
                
            case "hunting_talk6":
                
                talk_next("\"Deal.\"", "nothing", Color.yellow);
                
                break;          
                
            /* Asking the Hunter about Woods */     
                
            case "woods_info":

                talk_first("\"These woods are really nice, no?\"", "woods_info2", Color.white);
                
                break;    
                
            case "woods_info2":
                
                talk_next("\"As far as woods go, sure.\"", "woods_info3", Color.yellow);
                
                break;     
                
            case "woods_info3":
                
                talk_next("\"There's a lot of good game around these parts: deer, foxes...\"", "woods_info4", Color.white);
                
                break;         
                
            case "woods_info4":
                
                talk_next("\"But the bears seem more dangerous lately.\n It might be demonic influence...\"", "woods_info5", Color.white);
                
                break;       
                
            case "woods_info5":
                
                talk_next("\"I knew there's some catch to your deal.\"", "nothing", Color.yellow);
                
                break;      
                
                
            /* Asking Smith about the Demon Lord */    
                
            case "dl_smith":
                
                talk_first("\"The Demon Lord is immune to attacks from normal weapons\"", "dl_smith2", Color.white);
                
                break;        
                
            case "dl_smith2":     
                
                talk_next("\"You need a special blade created from a magical ore to harm him\"", "dl_smith3", Color.white);
                
                break;       
                
            case "dl_smith3":    
                
                talk_next("\"Should you bring one to me, I will be able to create such a weapon\"", "dl_smith4", Color.white);
                
                break;     
                
            case "dl_smith4":    

                talk_next("\"So, you need me to find you a rock?\"", "dl_smith5", Color.yellow);
                
                break; 
                
            case "dl_smith5":    
                
                talk_next("\"There might be a fitting one somewhere in the dungeon\"", "dl_smith6", Color.white);
                
                break;    
                      
                
            case "dl_smith6":    
                
                talk_next("\"Don't face the Demon Lord without the right weapon, understood?\"", "nothing", Color.white);
                
                break;       
                
            
            /* Asking Smith about the Town */     
                
            case "smith_info":

                talk_first("\"Starhome used to be a huge city, a pride of this kingdom\"", "smith_info2", Color.white);
                
                break;    
                
            case "smith_info2":    
                
                talk_next("\"Recently though, the people started to flee to the capitol...\"", "smith_info3", Color.white);
                
                break;     
                
            case "smith_info3":    
                
                talk_next("\"It was due to Demon Lord's attacks of course.\"", "smith_info4", Color.white);
                
                break;     
                
            case "smith_info4":    
                
                talk_next("\"If some hero doesn't stop all this monster business soon...\"", "smith_info5", Color.white);
                
                break;      
                
            case "smith_info5":    
                
                talk_next("\"I fear this town will get overran\"", "smith_info6", Color.white);
                
                break;      
                
            case "smith_info6":    
                
                talk_next("\"I won't let that happen\"", "nothing", Color.yellow);
                
                break;       
                
            /* Asking the Smith for tips */    
                
            case "tips_smith":
                
                talk_first("\"I sold one of my finest swords recently to Klethys the Hunter\"", "tips_smith2", Color.white);
                
                break;          
                
            case "tips_smith2":    
                
                talk_next("\"He often stalks his prey in the Woods close to the Dungeon\"", "tips_smith3", Color.white);
                
                break;      
                
            case "tips_smith3":    
                
                talk_next("\"Maybe hed'd be willing to trade if you help him out?\"", "tips_smith4", Color.white);
                
                break;     
                
            case "tips_smith4":    
                
                talk_next("\"I'll think about it\"", "nothing", Color.yellow);
                
                break;   
                
                
            /* Asking Mayor about the Demon Lord */   
                
                
            case "dl_mayor":
                
                talk_first("\"Many of our greatest warriors already failed trying to take him down\"", "dl_mayor2", Color.white);
                
                break;    
                
                
            case "dl_mayor2":
                
                talk_next("\"They said their weapons had no effect...\nMagic seemed to be working, but it wasn't enough\"", "dl_mayor3", Color.white);
                
                break; 
                
            case "dl_mayor3":  
                
                talk_next("\"There must be some trick to deafeating him, huh?\"", "dl_mayor4", Color.yellow);
                
                break;    
                
            case "dl_mayor4":
                
                talk_next("\"Gunthar in the weapon's shop might be able to help.\"", "nothing", Color.white);
                
                break;        

                
            /* Asking Mayor about the Quest */    
                
            case "quest_info":

                talk_first("\"It's good you managed to arrive in one piece.\"", "quest_info2", Color.white);
                
                break;      
                
            case "quest_info2":
                
                talk_next("\"So, what is the mission?\"", "quest_info3", Color.yellow);
                
                break;     
                
            case "quest_info3":
                
                talk_next("\"Defeat the Demon Lord that hides withing the Dungeon...\"", "quest_info4", Color.white);
                
                break;     
                
            case "quest_info4":
                
                talk_next("\"Slay him and you shall receive a mountain of gold and plethora of magical artifacts.\"", "quest_info5", Color.white);
                
                break;   
                
            case "quest_info5":
                
                talk_next("\"I like the sound of that.\"", "nothing", Color.yellow);
                
                break;        
                
                
            /* Asking Mayor about the Town */    
                
            case "town_mayor":
                
                talk_first("\"Before you set off, you should buy new weapons.\"", "town_mayor2", Color.white);
                
                break;    
                
            case "town_mayor2":
                
                talk_next("\"There is a good Blacksmith's shop nearby, stacked with Axes and Armor plates.\"", "town_mayor3", Color.white);
                
                break;      
                
            case "town_mayor3":
                
                talk_next("\"On the outskirts of the town you can also find an Item Shop...\"", "town_mayor4", Color.white);
                
                break;       
                    
            case "town_mayor4":
                
                talk_next("\"If you need healing or mana potions, that's where they can be found.\"", "town_mayor5", Color.white);
                
                break;           
                
            case "town_mayor5":
                
                talk_next("\"In case of emergency, remember that the local priests are also good healers.\"", "town_mayor6", Color.white);
                
                break;  
                
            case "town_mayor6":
                
                talk_next("\"Thanks, I'll be sure to keep those places in mind if I need anything.\"", "nothing", Color.yellow);
                
                break;  
                
                
            /* Buying items from Merchant */
                
            case "merch_items":
                
                gm.ui.addTalkMenu("Healing Potions", "Mana Elixirs", "Other", "merch_hsell", "merch_msell", "merch_osell");
                gm.ui.messageText.setText("\"How can I help you?\"");
                gm.ui.messageText.setForeground(Color.white);
                
                break;
                
            case "merch_hsell":
                
                gm.ui.addTalkMenu("S Potion", "M Potion", "L Potion", "merch_spotion", "merch_mpotion", "merch_lpotion");
                gm.ui.messageText.setText("\"Need healing items to fix yourself up?\"");
                gm.ui.messageText.setForeground(Color.white);
                
                break;
                
            case "merch_msell":
                
                gm.ui.addTalkMenu("S Elixir", "M Elixir", "L Elixir", "merch_selixir", "merch_melixir", "merch_lelixir");
                gm.ui.messageText.setText("\"If you plan on using spells a lot, you should buy some of these.\"");
                gm.ui.messageText.setForeground(Color.white);
                
                break;
                
            case "merch_osell":
                
                gm.ui.addTalkMenu("Mage's Amulet", "Dungeon Map", "", "merch_mamulet", "merch_dmap", "nothing");
                gm.ui.messageText.setText("\"Want something from this special selection?\"");
                gm.ui.messageText.setForeground(Color.white);
                
                break;
                
            case "merch_spotion":
                
                gm.ui.messageText.setText("\"Are you sure you want this one?\" \n(\"Small Health Potion\" +10 HP    Cost: 5 Gold)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Gimme!", "Nope", "bought_spotion", "nothing");
                
                break;
                
            case "bought_spotion":
                
                
                if (gm.playerInfo.getCash() >= 5 && gm.itemlist[8] == null){
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/coin_sound.wav");
                    se.play();
                    gm.playerInfo.setCash(gm.playerInfo.getCash()-5);
                    gm.ui.addPlayerInfo();

                    gm.ui.messageText.setText("You bought a [SMALL HEALTH POTION]!");
                    gm.ui.messageText.setForeground(Color.white);

                    for (int i=0;i<9;i++){
                            if (gm.itemlist[i] == null){
                                gm.itemlist[i] = new SmallHealthPotion();
                                break;
                            }
                        }
                } else if (gm.itemlist[8] != null){
                    
                    gm.ui.messageText.setText("You're carrying too many items!");
                    gm.ui.messageText.setForeground(Color.white);
                    
                } else {
                    
                    gm.ui.messageText.setText("Come on, you need money to buy items, duh!");
                    gm.ui.messageText.setForeground(Color.white);
                    
                }
                
                gm.ui.addInteractMenu();
                break;
                
                
            case "merch_mpotion":
                
                gm.ui.messageText.setText("\"Are you sure you want this one?\" \n(\"Medium Health Potion\" +25 HP    Cost: 12 Gold)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Gimme!", "Nope", "bought_mpotion", "nothing");
                
                break;    
                
            case "bought_mpotion":
                
                
                if (gm.playerInfo.getCash() >= 12 && gm.itemlist[8] == null){
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/coin_sound.wav");
                    se.play();
                    gm.playerInfo.setCash(gm.playerInfo.getCash()-12);
                    gm.ui.addPlayerInfo();

                    gm.ui.messageText.setText("You bought a [MEDIUM HEALTH POTION]!");
                    gm.ui.messageText.setForeground(Color.white);

                    for (int i=0;i<9;i++){
                            if (gm.itemlist[i] == null){
                                gm.itemlist[i] = new MediumHealthPotion();
                                break;
                            }
                        }
                } else if (gm.itemlist[8] != null){
                    
                    gm.ui.messageText.setText("You're carrying too many items!");
                    gm.ui.messageText.setForeground(Color.white);
                    
                } else {
                    
                    gm.ui.messageText.setText("Come on, you need money to buy items, duh!");
                    gm.ui.messageText.setForeground(Color.white);
                    
                }
                
                gm.ui.addInteractMenu();
                break;    
                
            case "merch_lpotion":
                
                gm.ui.messageText.setText("\"Are you sure you want this one?\" \n(\"Large Health Potion\" +60 HP    Cost: 28 Gold)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Gimme!", "Nope", "bought_lpotion", "nothing");
                
                break;    
                
            case "bought_lpotion":
                
                
                if (gm.playerInfo.getCash() >= 28 && gm.itemlist[8] == null){
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/coin_sound.wav");
                    se.play();
                    gm.playerInfo.setCash(gm.playerInfo.getCash()-28);
                    gm.ui.addPlayerInfo();

                    gm.ui.messageText.setText("You bought a [LARGE HEALTH POTION]!");
                    gm.ui.messageText.setForeground(Color.white);

                    for (int i=0;i<9;i++){
                            if (gm.itemlist[i] == null){
                                gm.itemlist[i] = new LargeHealthPotion();
                                break;
                            }
                        }
                } else if (gm.itemlist[8] != null){
                    
                    gm.ui.messageText.setText("You're carrying too many items!");
                    gm.ui.messageText.setForeground(Color.white);
                    
                } else {
                    
                    gm.ui.messageText.setText("Come on, you need money to buy items, duh!");
                    gm.ui.messageText.setForeground(Color.white);
                    
                }
                
                gm.ui.addInteractMenu();
                break;        
                
            case "merch_selixir":
                
                gm.ui.messageText.setText("\"Are you sure you want this one?\" \n(\"Small Elixir\" +10 MP    Cost: 10 Gold)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Gimme!", "Nope", "bought_selixir", "nothing");
                
                break; 
                
            case "bought_selixir":
                
                if (gm.playerInfo.getCash() >= 10 && gm.itemlist[8] == null){
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/coin_sound.wav");
                    se.play();
                    gm.playerInfo.setCash(gm.playerInfo.getCash()-10);
                    gm.ui.addPlayerInfo();

                    gm.ui.messageText.setText("You bought a [SMALL ELIXIR]!");
                    gm.ui.messageText.setForeground(Color.white);

                    for (int i=0;i<9;i++){
                            if (gm.itemlist[i] == null){
                                gm.itemlist[i] = new SmallElixir();
                                break;
                            }
                        }
                } else if (gm.itemlist[8] != null){
                    
                    gm.ui.messageText.setText("You're carrying too many items!");
                    gm.ui.messageText.setForeground(Color.white);
                    
                } else {
                    
                    gm.ui.messageText.setText("Come on, you need money to buy items, duh!");
                    gm.ui.messageText.setForeground(Color.white);
                    
                }
                
                gm.ui.addInteractMenu();
                
                break;
                
            case "merch_melixir":
                
                gm.ui.messageText.setText("\"Are you sure you want this one?\" \n(\"Medium Elixir\" +20 MP    Cost: 25 Gold)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Gimme!", "Nope", "bought_melixir", "nothing");
                
                break; 
                
            case "bought_melixir":
                
                if (gm.playerInfo.getCash() >= 25 && gm.itemlist[8] == null){
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/coin_sound.wav");
                    se.play();
                    gm.playerInfo.setCash(gm.playerInfo.getCash()-25);
                    gm.ui.addPlayerInfo();

                    gm.ui.messageText.setText("You bought a [MEDIUM ELIXIR]!");
                    gm.ui.messageText.setForeground(Color.white);

                    for (int i=0;i<9;i++){
                            if (gm.itemlist[i] == null){
                                gm.itemlist[i] = new MediumElixir();
                                break;
                            }
                        }
                } else if (gm.itemlist[8] != null){
                    
                    gm.ui.messageText.setText("You're carrying too many items!");
                    gm.ui.messageText.setForeground(Color.white);
                    
                } else {
                    
                    gm.ui.messageText.setText("Come on, you need money to buy items, duh!");
                    gm.ui.messageText.setForeground(Color.white);
                    
                }
                
                gm.ui.addInteractMenu();
                
                break;
                
            case "merch_lelixir":
                
                gm.ui.messageText.setText("\"Are you sure you want this one?\" \n(\"Large Elixir\" Full MP    Cost: 40 Gold)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Gimme!", "Nope", "bought_lelixir", "nothing");
                
                break;     
                
            case "bought_lelixir":
                
                if (gm.playerInfo.getCash() >= 40 && gm.itemlist[8] == null){
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/coin_sound.wav");
                    se.play();
                    gm.playerInfo.setCash(gm.playerInfo.getCash()-40);
                    gm.ui.addPlayerInfo();

                    gm.ui.messageText.setText("You bought a [LARGE ELIXIR]!");
                    gm.ui.messageText.setForeground(Color.white);

                    for (int i=0;i<9;i++){
                            if (gm.itemlist[i] == null){
                                gm.itemlist[i] = new LargeElixir();
                                break;
                            }
                        }
                } else if (gm.itemlist[8] != null){
                    
                    gm.ui.messageText.setText("You're carrying too many items!");
                    gm.ui.messageText.setForeground(Color.white);
                    
                } else {
                    
                    gm.ui.messageText.setText("Come on, you need money to buy items, duh!");
                    gm.ui.messageText.setForeground(Color.white);
                    
                }
                
                gm.ui.addInteractMenu();
                
                break;
                
             
            case "merch_mamulet":
                
                gm.ui.messageText.setText("\"A Mage's favorite, it can empower your spells!\" \n(\"Mage's Amulet\" (MAG +3)    Cost: 50 Gold)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Gimme!", "Nope", "bought_mamulet", "nothing");
                
                break;     
                
            case "bought_mamulet":  
                
                if (gm.playerInfo.getCash() >= 50){
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/coin_sound.wav");
                    se.play();
                    gm.playerInfo.setCash(gm.playerInfo.getCash()-50);
                    gm.ui.messageText.setText("\"The magical power courses through my entire body!\"");
                    gm.ui.messageText.setForeground(Color.yellow);
                    gm.ui.j4x1.setIcon(new ImageIcon(getClass().getResource("/res/magic_amulet.png")));
                    
                    gm.playerInfo.setMAG(gm.playerInfo.getMAG()+3);
                    gm.ui.addPlayerInfo();
                    gm.ui.makeStatsText();
                    gm.ui.statsText.setVisible(false);

                    JMenuItem menuItem4[] = new JMenuItem[2];

                    JPopupMenu popMenu4 = new JPopupMenu();

                    menuItem4[0] = new JMenuItem("Examine");
                    menuItem4[0].addActionListener(gm.weaponChoiceHandler);
                    menuItem4[0].setActionCommand("examine_amulet_m");
                    popMenu4.add(menuItem4[0]);

                    gm.ui.j4x1.addMouseListener(new MouseListener(){


                        @Override
                        public void mouseClicked(MouseEvent e){}

                        @Override
                        public void mousePressed(MouseEvent e){

                            if (SwingUtilities.isRightMouseButton(e)){
                                popMenu4.show(gm.ui.j4x1, e.getX(), e.getY());
                            }

                        }

                        @Override
                        public void mouseReleased(MouseEvent e){}

                        @Override
                        public void mouseEntered(MouseEvent e){}

                        @Override
                        public void mouseExited(MouseEvent e){}


                    });
                }
                else {
                    gm.ui.messageText.setText("\"I know it's expensive, but this not a charity!\"");
                    gm.ui.messageText.setForeground(Color.white);
                }
                
                
                gm.ui.addInteractMenu();     
                
                break;
                
                
            case "merch_dmap":
                
                gm.ui.messageText.setText("\"A rough sketch of the Dungeon and surrounding areas, interested?    (Cost: 5 Gold)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Gimme!", "Nope", "bought_dmap", "nothing");
                
                break;
                
                
            case "bought_dmap":
                
                if (gm.playerInfo.getCash() >= 5){
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/coin_sound.wav");
                    se.play();
                    gm.playerInfo.setCash(gm.playerInfo.getCash()-5);
                    gm.ui.messageText.setText("\"If I ever get lost, this might come in handy\"");
                    gm.ui.messageText.setForeground(Color.yellow);
                    gm.ui.j3x4.setIcon(new ImageIcon(getClass().getResource("/res/map.png")));

                    JMenuItem menuItem4[] = new JMenuItem[2];

                    JPopupMenu popMenu4 = new JPopupMenu();

                    menuItem4[0] = new JMenuItem("Examine");
                    menuItem4[0].addActionListener(gm.weaponChoiceHandler);
                    menuItem4[0].setActionCommand("examine_dmap");
                    popMenu4.add(menuItem4[0]);

                    gm.ui.j3x4.addMouseListener(new MouseListener(){


                        @Override
                        public void mouseClicked(MouseEvent e){}

                        @Override
                        public void mousePressed(MouseEvent e){

                            if (SwingUtilities.isRightMouseButton(e)){
                                popMenu4.show(gm.ui.j3x4, e.getX(), e.getY());
                            }

                        }

                        @Override
                        public void mouseReleased(MouseEvent e){}

                        @Override
                        public void mouseEntered(MouseEvent e){}

                        @Override
                        public void mouseExited(MouseEvent e){}


                    });
                }
                else {
                    gm.ui.messageText.setText("\"If you actually want it, come back with some money!\"");
                    gm.ui.messageText.setForeground(Color.white);
                }
                
                
                gm.ui.addInteractMenu();    
                
                
                break;
                
            /* Asking Merchant about the Business */        
             
            case "merch_business":
                
                talk_first("\"How is your business these days?\"", "merch_business2", Color.yellow);
   
                break;
                
            case "merch_business2":
                
                talk_next("\"No shortage of adventurers in need of potions around here recently\"", "merch_business3", Color.white);
                
                break;  
                
            case "merch_business3":
                
                talk_next("\"So you can say it's a good time to be an Item Merchant\"", "merch_business4", Color.white);
                
                break;
                
            case "merch_business4":
                
                talk_next("\"The future is looking pretty bleak though...\"", "merch_business5", Color.white);
                
                break;    
                
            case "merch_business5":
                
                talk_next("\"Either someone gets rid of the Demon Lord and there are no more adventurers coming around...\"", "merch_business6", Color.white);
                
                break;        
                
            case "merch_business6":
                
                talk_next("\"... or the Demon Lord destroys us all, this shop included.\"", "nothing", Color.white);
                
                break;       
                
                
                
            /* Asking Merchant about the Quest */       
                
            case "merch_quest":
                
                talk_first("\"Got any quests for someone like me?\"", "merch_quest2", Color.yellow);
   
                break;
                
            case "merch_quest2":
                
                talk_next("\"There is one thing, I need some leaves of Blueshrub tree.\n They are required for me to brew my potions.\"", "merch_quest3", Color.white);
                
                break;  
                
            case "merch_quest3":
                
                talk_next("\"I don't think I saw any of those trees around here...\"", "merch_quest4", Color.yellow);
                
                break;        
                
            case "merch_quest4":
                
                talk_next("\"Well, if you somehow manage to find some, bring them here and I'll give you a worthy reward.\"", "nothing", Color.white);
                
                break;        
                
                
            /* Priest interact */    
                
            case "interact_priest":
                
                gm.ui.messageText.setText("\"Would you like me to heal you for a mere donation of 20 gold?\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Sure!", "No Way", "priest_heal", "nothing");

                break;
                
            case "priest_heal":
                
                if (gm.playerInfo.getCash() >= 20){
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/heal_sound_s.wav");
                    se.play_nog();
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
                
                
            /* Buying things from the Smith */    
                
            case "interact_smith":
                
                if (gm.ui.moonoreFlag){
                    
                    gm.ui.messageText.setText("\"You found the moon ore? Splendid, adventurer.\"");         
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
                    gm.ui.choice1.setActionCommand("event_demonsbane");
                    gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                    
                    /* Add the removal of moon ore from inventory here */
                    
                } else {
                
                    gm.ui.messageText.setText("\"What are you looking for, adventurer?\"");
                    gm.ui.messageText.setForeground(Color.yellow);
                    gm.ui.addSmithBuyMenu();
                
                }
                
                break;
                
            case "event_demonsbane":
                
                gm.ui.messageText.setText("\"Just give me a second here.\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("event_demonsbane2");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;      
                
            case "event_demonsbane2":
                
                gm.ui.messageText.setText("\"...\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("event_demonsbane3");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;      
                
            case "event_demonsbane3":
                
                gm.ui.messageText.setText("\"Here you go, my masterpiece is finished.\"");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.choice1.setActionCommand("event_demonsbane4");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                break;     
                
            case "event_demonsbane4":
                
                gm.ui.messageText.setText("\"Received [DEMONSBANE]!\"");
                gm.ui.messageText.setForeground(Color.white);
                
                gm.ui.j1x4.setIcon(new ImageIcon(getClass().getResource("/res/demonsbane.png")));

                    JMenuItem menuItem[] = new JMenuItem[2];

                    JPopupMenu popMenu = new JPopupMenu();

                    menuItem[0] = new JMenuItem("Equip");
                    menuItem[0].addActionListener(gm.weaponChoiceHandler);
                    menuItem[0].setActionCommand("equip_demon");
                    popMenu.add(menuItem[0]);

                    menuItem[1] = new JMenuItem("Examine");
                    menuItem[1].addActionListener(gm.weaponChoiceHandler);
                    menuItem[1].setActionCommand("examine_demon");
                    popMenu.add(menuItem[1]);

                    gm.ui.j1x4.addMouseListener(new MouseListener(){


                        @Override
                        public void mouseClicked(MouseEvent e){}

                        @Override
                        public void mousePressed(MouseEvent e){

                            if (SwingUtilities.isRightMouseButton(e)){
                                popMenu.show(gm.ui.j1x4, e.getX(), e.getY());
                            }

                        }

                        @Override
                        public void mouseReleased(MouseEvent e){}

                        @Override
                        public void mouseEntered(MouseEvent e){}

                        @Override
                        public void mouseExited(MouseEvent e){}


                    });
                    
                gm.ui.moonoreFlag = false;
                
                gm.ui.choice1.setActionCommand("nothing");
                gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                
                break;         
                
                
                
                
            case "buy_axe":   
                gm.ui.messageText.setText("\"Ah, a splendid choice. Is this what you want?\" \n(\"War Axe\" +5 ATK    Cost: 40 Gold)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Gimme!", "Nope", "bought_axe", "nothing");
                break;
                
            case "bought_axe":
                if (gm.playerInfo.getCash() >= 40){
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/coin_sound.wav");
                    se.play();
                    gm.playerInfo.setCash(gm.playerInfo.getCash()-40);
                    gm.ui.addPlayerInfo();
                    gm.ui.messageText.setText("\"Now that I got this shiny new Axe, I should try it out on something. Or someone.\"");
                    gm.ui.messageText.setForeground(Color.yellow);
                    gm.ui.j1x2.setIcon(new ImageIcon(getClass().getResource("/res/war_axe.png")));

                    JMenuItem menuItem2[] = new JMenuItem[2];

                    JPopupMenu popMenu2 = new JPopupMenu();

                    menuItem2[0] = new JMenuItem("Equip");
                    menuItem2[0].addActionListener(gm.weaponChoiceHandler);
                    menuItem2[0].setActionCommand("equip_waraxe");
                    popMenu2.add(menuItem2[0]);

                    menuItem2[1] = new JMenuItem("Examine");
                    menuItem2[1].addActionListener(gm.weaponChoiceHandler);
                    menuItem2[1].setActionCommand("examine_waraxe");
                    popMenu2.add(menuItem2[1]);

                    gm.ui.j1x2.addMouseListener(new MouseListener(){


                        @Override
                        public void mouseClicked(MouseEvent e){}

                        @Override
                        public void mousePressed(MouseEvent e){

                            if (SwingUtilities.isRightMouseButton(e)){
                                popMenu2.show(gm.ui.j1x2, e.getX(), e.getY());
                            }

                        }

                        @Override
                        public void mouseReleased(MouseEvent e){}

                        @Override
                        public void mouseEntered(MouseEvent e){}

                        @Override
                        public void mouseExited(MouseEvent e){}


                    });
                }
                else {
                    gm.ui.messageText.setText("\"Come back, when you have sufficient gold, adventurer.\"");
                    gm.ui.messageText.setForeground(Color.white);
                }
                
                
                gm.ui.addInteractMenu();
                
                break;
                
                
                
                
            case "buy_sarmor":
                gm.ui.messageText.setText("\"Everyone's buying this plate these days. Decided?\" \n(\"Soldier Armor\" +4 DEF    Cost: 40 Gold)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Gimme!", "Nope", "bought_sarmor", "nothing");
                break;
                
            case "bought_sarmor":  
                 
                 if (gm.playerInfo.getCash() >= 40){
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/coin_sound.wav");
                    se.play();
                    gm.playerInfo.setCash(gm.playerInfo.getCash()-40);
                    gm.ui.addPlayerInfo();
                    gm.ui.messageText.setText("\"Better safe than sorry. I should equip this as soon as possible.\"");
                    gm.ui.messageText.setForeground(Color.yellow);
                    gm.ui.j2x2.setIcon(new ImageIcon(getClass().getResource("/res/soldier_armor.png")));

                    JMenuItem menuItem3[] = new JMenuItem[2];

                    JPopupMenu popMenu3 = new JPopupMenu();

                    menuItem3[0] = new JMenuItem("Equip");
                    menuItem3[0].addActionListener(gm.weaponChoiceHandler);
                    menuItem3[0].setActionCommand("equip_sldarm");
                    popMenu3.add(menuItem3[0]);

                    menuItem3[1] = new JMenuItem("Examine");
                    menuItem3[1].addActionListener(gm.weaponChoiceHandler);
                    menuItem3[1].setActionCommand("examine_sldarm");
                    popMenu3.add(menuItem3[1]);

                    gm.ui.j2x2.addMouseListener(new MouseListener(){


                        @Override
                        public void mouseClicked(MouseEvent e){}

                        @Override
                        public void mousePressed(MouseEvent e){

                            if (SwingUtilities.isRightMouseButton(e)){
                                popMenu3.show(gm.ui.j2x2, e.getX(), e.getY());
                            }

                        }

                        @Override
                        public void mouseReleased(MouseEvent e){}

                        @Override
                        public void mouseEntered(MouseEvent e){}

                        @Override
                        public void mouseExited(MouseEvent e){}


                    });
                }
                else {
                    gm.ui.messageText.setText("\"Come back, when you have sufficient gold, adventurer.\"");
                    gm.ui.messageText.setForeground(Color.white);
                }
                
                
                gm.ui.addInteractMenu();
                
                break;
                
            case "buy_amulet":
                 
                gm.ui.messageText.setText("\"This jewel can bring out your inner ferocity. Decided?\" \n(\"Strength Amulet\" +2 ATK    Cost: 40 Gold)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addConfirmMenu("Gimme!", "Nope", "bought_amulet", "nothing");
                break; 
                
            case "bought_amulet":
                 
                if (gm.playerInfo.getCash() >= 40){
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/coin_sound.wav");
                    se.play();
                    gm.playerInfo.setCash(gm.playerInfo.getCash()-40);
                    gm.ui.messageText.setText("\"I feel stronger already! I hope there are no side effects...\"");
                    gm.ui.messageText.setForeground(Color.yellow);
                    gm.ui.j3x1.setIcon(new ImageIcon(getClass().getResource("/res/amulet_strength.png")));
                    
                    gm.playerInfo.setATK(gm.playerInfo.getATK()+2);
                    gm.playerInfo.setModifiedATK(gm.playerInfo.getModifiedATK()+2);
                    gm.ui.addPlayerInfo();
                    gm.ui.makeStatsText();
                    gm.ui.statsText.setVisible(false);

                    JMenuItem menuItem4[] = new JMenuItem[2];

                    JPopupMenu popMenu4 = new JPopupMenu();

                    menuItem4[0] = new JMenuItem("Examine");
                    menuItem4[0].addActionListener(gm.weaponChoiceHandler);
                    menuItem4[0].setActionCommand("examine_amulet_s");
                    popMenu4.add(menuItem4[0]);

                    gm.ui.j3x1.addMouseListener(new MouseListener(){


                        @Override
                        public void mouseClicked(MouseEvent e){}

                        @Override
                        public void mousePressed(MouseEvent e){

                            if (SwingUtilities.isRightMouseButton(e)){
                                popMenu4.show(gm.ui.j3x1, e.getX(), e.getY());
                            }

                        }

                        @Override
                        public void mouseReleased(MouseEvent e){}

                        @Override
                        public void mouseEntered(MouseEvent e){}

                        @Override
                        public void mouseExited(MouseEvent e){}


                    });
                }
                else {
                    gm.ui.messageText.setText("\"Come back, when you have sufficient gold, adventurer.\"");
                    gm.ui.messageText.setForeground(Color.white);
                }
                
                
                gm.ui.addInteractMenu();     
                 
                break;

                
            /* Hunter interact */    
                
            case "interact_hunter":    
                
                if (!gm.ui.bearpeltFlag){
                    gm.ui.messageText.setText("\"Maybe if I had something this guy wants, he would give me a decent reward.\"");
                    gm.ui.messageText.setForeground(Color.yellow);
                } else {
                    gm.ui.messageText.setText("\"You have a bear pelt? I'll give you a nice a reward if you're willing to part with it.\"");
                    gm.ui.messageText.setForeground(Color.white);
                    gm.ui.addConfirmMenu("Deal", "No Deal", "katana_trade", "nothing");
                    
                }

                break;
                
            case "katana_trade":
                
                gm.ui.bearpeltFlag = false;
                
                gm.ui.j3x2.setIcon(new ImageIcon(getClass().getResource("/res/empty2.png")));

                    JPopupMenu popMenu5 = new JPopupMenu();
                    
                    JMenuItem menuItem5[] = new JMenuItem[2];
        
                    menuItem5[0] = new JMenuItem("Examine");
                    menuItem5[0].addActionListener(gm.weaponChoiceHandler);
                    menuItem5[0].setActionCommand("examine_empty");
                    popMenu5.add(menuItem5[0]);
        
                    gm.ui.j3x2.addMouseListener(new MouseListener(){


                        @Override
                        public void mouseClicked(MouseEvent e){}

                        @Override
                        public void mousePressed(MouseEvent e){

                            if (SwingUtilities.isRightMouseButton(e)){
                                popMenu5.show(gm.ui.j3x2, e.getX(), e.getY());
                            }

                        }

                        @Override
                        public void mouseReleased(MouseEvent e){}

                        @Override
                        public void mouseEntered(MouseEvent e){}

                        @Override
                        public void mouseExited(MouseEvent e){}


                    });
                    
                gm.ui.j1x3.setIcon(new ImageIcon(getClass().getResource("/res/katana.png")));    
                    
                    JPopupMenu popMenu6 = new JPopupMenu();
                    
                    menuItem5[0] = new JMenuItem("Equip");
                    menuItem5[0].addActionListener(gm.weaponChoiceHandler);
                    menuItem5[0].setActionCommand("equip_katana");
                    popMenu6.add(menuItem5[0]);
                    
                    menuItem5[1] = new JMenuItem("Examine");
                    menuItem5[1].addActionListener(gm.weaponChoiceHandler);
                    menuItem5[1].setActionCommand("examine_katana");
                    popMenu6.add(menuItem5[1]);
        
                    gm.ui.j1x3.addMouseListener(new MouseListener(){


                        @Override
                        public void mouseClicked(MouseEvent e){}

                        @Override
                        public void mousePressed(MouseEvent e){

                            if (SwingUtilities.isRightMouseButton(e)){
                                popMenu6.show(gm.ui.j1x3, e.getX(), e.getY());
                            }

                        }

                        @Override
                        public void mouseReleased(MouseEvent e){}

                        @Override
                        public void mouseEntered(MouseEvent e){}

                        @Override
                        public void mouseExited(MouseEvent e){}


                    });
                    
                gm.ui.messageText.setText("You got [KATANA].\nGlorious eastern steel (+12 ATK)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                
                
                
                break;
                
            /* Mayor interact */    
                
            case "interact_mayor":
                
                gm.ui.messageText.setText("\"[Some kind of interaction here]\"");
                gm.ui.messageText.setForeground(Color.yellow);

                break;
                
                
            /* Item shop interact */
                
            case "interact_merch":
                
                if (!gm.ui.blueleavesFlag){
                    gm.ui.messageText.setText("\"I'm sure she'll be up for a trade, assuming I can get the right items.\"");
                    gm.ui.messageText.setForeground(Color.yellow);
                } else {
                    gm.ui.messageText.setText("\"You have them! I can give you this special suit of armor that apparently came here from outer space in return.\"");
                    gm.ui.messageText.setForeground(Color.white);
                    gm.ui.addConfirmMenu("Deal", "No Deal", "sparmor_trade", "nothing");
                }
              
                break;
                
            case "sparmor_trade":
                
                gm.ui.blueleavesFlag = false;
                
                gm.ui.j4x3.setIcon(new ImageIcon(getClass().getResource("/res/empty2.png")));

                    JPopupMenu popMenu9 = new JPopupMenu();
                    
                    JMenuItem menuItem9[] = new JMenuItem[2];
        
                    menuItem9[0] = new JMenuItem("Examine");
                    menuItem9[0].addActionListener(gm.weaponChoiceHandler);
                    menuItem9[0].setActionCommand("examine_empty");
                    popMenu9.add(menuItem9[0]);
        
                    gm.ui.j4x3.addMouseListener(new MouseListener(){


                        @Override
                        public void mouseClicked(MouseEvent e){}

                        @Override
                        public void mousePressed(MouseEvent e){

                            if (SwingUtilities.isRightMouseButton(e)){
                                popMenu9.show(gm.ui.j4x3, e.getX(), e.getY());
                            }

                        }

                        @Override
                        public void mouseReleased(MouseEvent e){}

                        @Override
                        public void mouseEntered(MouseEvent e){}

                        @Override
                        public void mouseExited(MouseEvent e){}


                    });
                    
                gm.ui.j2x4.setIcon(new ImageIcon(getClass().getResource("/res/saiyan-suit.png")));    
                    
                    JPopupMenu popMenu10 = new JPopupMenu();
                    
                    menuItem9[0] = new JMenuItem("Equip");
                    menuItem9[0].addActionListener(gm.weaponChoiceHandler);
                    menuItem9[0].setActionCommand("equip_sparmor");
                    popMenu10.add(menuItem9[0]);
                    
                    menuItem9[1] = new JMenuItem("Examine");
                    menuItem9[1].addActionListener(gm.weaponChoiceHandler);
                    menuItem9[1].setActionCommand("examine_sparmor");
                    popMenu10.add(menuItem9[1]);
        
                    gm.ui.j2x4.addMouseListener(new MouseListener(){


                        @Override
                        public void mouseClicked(MouseEvent e){}

                        @Override
                        public void mousePressed(MouseEvent e){

                            if (SwingUtilities.isRightMouseButton(e)){
                                popMenu10.show(gm.ui.j2x4, e.getX(), e.getY());
                            }

                        }

                        @Override
                        public void mouseReleased(MouseEvent e){}

                        @Override
                        public void mouseEntered(MouseEvent e){}

                        @Override
                        public void mouseExited(MouseEvent e){}


                    });
                    
                gm.ui.messageText.setText("You got [SPECIAL ARMOR].\nArmor of exquisite quality. (DEF + 7)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                
                
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
                
            case "look_smith":
                
                gm.ui.messageText.setText("\"Armor crafting seems like his strong suit\"");
                gm.ui.messageText.setForeground(Color.yellow);

                break;    
                
            case "look_mayor":
                
                gm.ui.messageText.setText("\"Well, hello there\"");
                gm.ui.messageText.setForeground(Color.yellow);

                break;
                
            case "look_hunter":
                
                gm.ui.messageText.setText("\"Wonder what he's hunting\"");
                gm.ui.messageText.setForeground(Color.yellow);

                break;    
                
            case "look_merch":
                
                gm.ui.messageText.setText("\"She seems nice, maybe I can negotiate a price drop on a few of these items\"");
                gm.ui.messageText.setForeground(Color.yellow);

                break;  
                
            case "examine_chest":
                
                gm.ui.messageText.setText("It's a wooden chest, doesn't seem like a trap and can be opened without a key");
                gm.ui.messageText.setForeground(Color.white);

                break;
                
            case "open_chest":
                
                se.setFile(System.getProperty("user.dir") + "/src/res/sound/getgold.wav");
                se.play();
                gm.ui.messageText.setText("You found 50 gold!");
                gm.playerInfo.setCash(gm.playerInfo.getCash()+50);
                gm.ui.bgPanel[11].remove(0);
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addPlayerInfo();

                break;
                
            case "examine_shelf":
                gm.ui.messageText.setText("You notice bookshelves filled with eastern picture books named \"Single Peace\"");
                gm.ui.messageText.setForeground(Color.white);
                
                break;
                
            case "interact_shelf":
                
                /* Let's make it infinite for now */
                
                se.setFile(System.getProperty("user.dir") + "/src/res/sound/getgold.wav");
                se.play();
                gm.ui.messageText.setText("You found 10 gold!");
                gm.playerInfo.setCash(gm.playerInfo.getCash()+10);
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addPlayerInfo();

                break;    
                
            case "examine_ore":
                gm.ui.messageText.setText("A majestic ore glinting with the shine of moonlight");
                gm.ui.messageText.setForeground(Color.white);
                
                break;
                
            case "grab_ore":
                
                gm.ui.bgPanel[14].remove(0);
                
                gm.ui.messageText.setText("You acquired [MOON ORE]");
                gm.ui.messageText.setForeground(Color.white);
                
                gm.ui.j4x2.setIcon(new ImageIcon(getClass().getResource("/res/ore_item.png")));

                        JMenuItem menuItem4[] = new JMenuItem[2];

                        JPopupMenu popMenu4 = new JPopupMenu();

                        menuItem4[0] = new JMenuItem("Examine");
                        menuItem4[0].addActionListener(gm.weaponChoiceHandler);
                        menuItem4[0].setActionCommand("examine_ore");
                        popMenu4.add(menuItem4[0]);

                        gm.ui.j4x2.addMouseListener(new MouseListener(){


                            @Override
                            public void mouseClicked(MouseEvent e){}

                            @Override
                            public void mousePressed(MouseEvent e){

                                if (SwingUtilities.isRightMouseButton(e)){
                                    popMenu4.show(gm.ui.j4x2, e.getX(), e.getY());
                                }

                            }

                            @Override
                            public void mouseReleased(MouseEvent e){}

                            @Override
                            public void mouseEntered(MouseEvent e){}

                            @Override
                            public void mouseExited(MouseEvent e){}


                        });
                        
                    gm.ui.moonoreFlag = true;
                     
                    break;    
                    
                    
            case "examine_secsid":
                
                gm.ui.messageText.setText("You notice a vial hiding inside a crevice");
                gm.ui.messageText.setForeground(Color.white);
                
                break;
                
            case "interact_secsid":
                
                gm.ui.messageText.setText("You found a [LARGE HEALTH POTION]!");
                gm.ui.messageText.setForeground(Color.white);
                
                for (int i=0;i<9;i++){
                        if (gm.itemlist[i] == null){
                            gm.itemlist[i] = new LargeHealthPotion();
                            gm.ui.bgPanel[12].remove(0);
                            break;
                        }
                        if (i==8){
                            gm.ui.messageText.setText("You're carrying too many items!");
                            break;
                        }
                    }

                break;
                
            case "examine_smiths":   
                
                gm.ui.messageText.setText("The Smith's shop I believe. Maybe I should come in to see what they have to offer?");
                gm.ui.messageText.setForeground(Color.yellow);
                
                break;
                
                
            case "examine_thall":
                
                gm.ui.messageText.setText("Looks like the local Town Hall, a place where the clerical workers can be found.");
                gm.ui.messageText.setForeground(Color.yellow);
                
                break;
                
            case "examine_barrels":   
                
                if (gm.ui.barrelgoldFlag){
                
                    gm.ui.messageText.setText("You notice something shining inside the barrels.");
                    gm.ui.messageText.setForeground(Color.white);
                
                } else {
                    
                    gm.ui.messageText.setText("A couple of wooden barrels.");
                    gm.ui.messageText.setForeground(Color.white);
                    
                }
                
                break;
                
            case "interact_barrels":
                
                if (gm.ui.barrelgoldFlag){
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/getgold.wav");
                    se.play();
                    gm.ui.messageText.setText("You found 20 gold!");
                    gm.playerInfo.setCash(gm.playerInfo.getCash()+20);
                    gm.ui.messageText.setForeground(Color.white);
                    gm.ui.barrelgoldFlag = false;
                    gm.ui.addPlayerInfo();
                
                } else {
                    gm.ui.messageText.setText("There doesn't seem to be anything else here...");
                    gm.ui.messageText.setForeground(Color.yellow);
                }

                break;   
                
            case "examine_gsword":
                
                gm.ui.messageText.setText("I would consider taking it, but I already have a sword of better quality.");
                gm.ui.messageText.setForeground(Color.yellow);
                
                break;
                
            case "examine_cultist":    
                
                gm.ui.messageText.setText("What is that thing?! And why can't I fight it?");
                gm.ui.messageText.setForeground(Color.yellow);
                
                break;
                
            case "examine_gbarrel":
                
                gm.ui.messageText.setText("Empty...");
                gm.ui.messageText.setForeground(Color.yellow);
                
                break;    
                
            case "examine_key":
                
                gm.ui.messageText.setText("A gold key lies on the table. Might be useful?");
                gm.ui.messageText.setForeground(Color.yellow);
                
                break;  
                
            case "grab_key":
                
                gm.ui.bgPanel[17].remove(0);
                gm.ui.bgPanel[17].setVisible(false);
                gm.ui.bgPanel[17].setVisible(true);
                
                gm.ui.messageText.setText("You acquired [GOLD KEY]!");
                gm.ui.messageText.setForeground(Color.white);
                
                gm.ui.j3x3.setIcon(new ImageIcon(getClass().getResource("/res/key.png")));

                JMenuItem menuItem7[] = new JMenuItem[2];

                JPopupMenu popMenu7 = new JPopupMenu();

                menuItem7[0] = new JMenuItem("Examine");
                menuItem7[0].addActionListener(gm.weaponChoiceHandler);
                menuItem7[0].setActionCommand("examine_key");
                popMenu7.add(menuItem7[0]);

                gm.ui.j3x3.addMouseListener(new MouseListener(){


                    @Override
                    public void mouseClicked(MouseEvent e){}

                    @Override
                    public void mousePressed(MouseEvent e){

                        if (SwingUtilities.isRightMouseButton(e)){
                            popMenu7.show(gm.ui.j3x3, e.getX(), e.getY());
                        }

                    }

                    @Override
                    public void mouseReleased(MouseEvent e){}

                    @Override
                    public void mouseEntered(MouseEvent e){}

                    @Override
                    public void mouseExited(MouseEvent e){}


                });

            gm.ui.goldkeyFlag = true;

            break;    
                
            
            case "examine_book":
                
                gm.ui.messageText.setText("Yep, it's a book.");
                gm.ui.messageText.setForeground(Color.yellow); 
                
                break;
                  
            case "examine_gold":    
                
                gm.ui.messageText.setText("Should I take some for the road?");
                gm.ui.messageText.setForeground(Color.yellow); 
                
                break;
                
            case "grab_gold":
                
                /* Let's make it infinite for now */
                
                se.setFile(System.getProperty("user.dir") + "/src/res/sound/getgold.wav");
                se.play();
                gm.ui.messageText.setText("You found 100 gold!");
                gm.playerInfo.setCash(gm.playerInfo.getCash()+100);
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addPlayerInfo();
                
                break;
                
                
            case "examine_leaves":
                
                gm.ui.messageText.setText("Looks like even demons see the value of Blueshrub leaves.");
                gm.ui.messageText.setForeground(Color.yellow); 
                
                break;
                
                
            case "grab_leaves":
                
                gm.ui.bgPanel[19].remove(0);
                gm.ui.bgPanel[19].setVisible(false);
                gm.ui.bgPanel[19].setVisible(true);
                
                gm.ui.messageText.setText("You acquired [BLUESHRUB LEAVES]!");
                gm.ui.messageText.setForeground(Color.white);
                
                gm.ui.j4x3.setIcon(new ImageIcon(getClass().getResource("/res/leaves.png")));

                JMenuItem menuItem8[] = new JMenuItem[2];

                JPopupMenu popMenu8 = new JPopupMenu();

                menuItem8[0] = new JMenuItem("Examine");
                menuItem8[0].addActionListener(gm.weaponChoiceHandler);
                menuItem8[0].setActionCommand("examine_leaves");
                popMenu8.add(menuItem8[0]);

                gm.ui.j4x3.addMouseListener(new MouseListener(){


                    @Override
                    public void mouseClicked(MouseEvent e){}

                    @Override
                    public void mousePressed(MouseEvent e){

                        if (SwingUtilities.isRightMouseButton(e)){
                            popMenu8.show(gm.ui.j4x3, e.getX(), e.getY());
                        }

                    }

                    @Override
                    public void mouseReleased(MouseEvent e){}

                    @Override
                    public void mouseEntered(MouseEvent e){}

                    @Override
                    public void mouseExited(MouseEvent e){}


                });

                gm.ui.blueleavesFlag = true;
                
                break;
                
                
            case "examine_karmor":
                
                gm.ui.messageText.setText("A suit of armor worthy of the greatest knights.");
                gm.ui.messageText.setForeground(Color.white); 
                
                break;
                
            case "grab_karmor":
                
                JMenuItem menuItem11[] = new JMenuItem[2];
                    
                gm.ui.j2x3.setIcon(new ImageIcon(getClass().getResource("/res/knight_armor.png")));    
                    
                    JPopupMenu popMenu11 = new JPopupMenu();
                    
                    menuItem11[0] = new JMenuItem("Equip");
                    menuItem11[0].addActionListener(gm.weaponChoiceHandler);
                    menuItem11[0].setActionCommand("equip_karmor");
                    popMenu11.add(menuItem11[0]);
                    
                    menuItem11[1] = new JMenuItem("Examine");
                    menuItem11[1].addActionListener(gm.weaponChoiceHandler);
                    menuItem11[1].setActionCommand("examine_karmor");
                    popMenu11.add(menuItem11[1]);
        
                    gm.ui.j2x3.addMouseListener(new MouseListener(){


                        @Override
                        public void mouseClicked(MouseEvent e){}

                        @Override
                        public void mousePressed(MouseEvent e){

                            if (SwingUtilities.isRightMouseButton(e)){
                                popMenu11.show(gm.ui.j2x3, e.getX(), e.getY());
                            }

                        }

                        @Override
                        public void mouseReleased(MouseEvent e){}

                        @Override
                        public void mouseEntered(MouseEvent e){}

                        @Override
                        public void mouseExited(MouseEvent e){}


                    });
                    
                gm.ui.messageText.setText("You got [KNIGHT ARMOR].\nA suit of armor worthy of the greatest knights. (DEF + 5)");
                gm.ui.messageText.setForeground(Color.white);
                gm.ui.addInteractMenu();
                
                break;
                
            case "look_dknight":
                
                gm.ui.messageText.setText("\"This guy seems like trouble...\"");
                gm.ui.messageText.setForeground(Color.yellow);
                
                break;
                
            case "interact_dknight":
                
                gm.ui.messageText.setText("\"Not really my kind of crowd.\"");
                gm.ui.messageText.setForeground(Color.yellow);
                
                break;
                
            case "talk_dknight":
                
                gm.ui.addTalkMenu("Option 1", "Option 2", "Option 3", "", "", "");
                gm.ui.messageText.setText("Ask about: ");
                gm.ui.messageText.setForeground(Color.white);
                
                break;
            
                
            case "nothing":
                
                gm.ui.addInteractMenu();
                if (gm.ui.bgPanel[8].isVisible()){
                    gm.ui.choice4.setText("<<<");
                    gm.ui.choice4.setActionCommand("restore_scene");
                }
                gm.ui.messageText.setText("What shall I do next?"); 
                gm.ui.messageText.setForeground(Color.yellow);
                
                se.setFile(System.getProperty("user.dir") + "/src/res/sound/click.wav");
                se.play();
                
                break;   
            
        }
        
    }
    
    public void talk_first(String talktext, String nextcase, Color textcolor){      /* I'll fix all the talk cases with these functions soon for clarity - DONE */
        
        gm.ui.messageText.setText(talktext);        
        gm.ui.messageText.setForeground(textcolor);
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
        gm.ui.choice1.setActionCommand(nextcase);
        gm.ui.choiceButtonPanel.add(gm.ui.choice1);

        se.setFile(System.getProperty("user.dir") + "/src/res/sound/click.wav");
        se.play();
        
    }
    
    public void talk_next(String talktext, String nextcase, Color textcolor){
        
        gm.ui.messageText.setText(talktext);
        gm.ui.messageText.setForeground(textcolor);
        gm.ui.choice1.setActionCommand(nextcase);
        gm.ui.choiceButtonPanel.add(gm.ui.choice1);

        se.setFile(System.getProperty("user.dir") + "/src/res/sound/click.wav");
        se.play();
        
    }
    
    
    
}
