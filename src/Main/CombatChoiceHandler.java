/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.monsters.Skeletons;
import Other.DisappearingLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CombatChoiceHandler implements ActionListener{
    
    GameManager gm;
    SoundEffect se = new SoundEffect();
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
                
                int damageRoll = gm.playerInfo.getATK() + rand.nextInt(gm.playerInfo.getModifiedATK()+1);
                damageRoll2 = (gm.monster.getATK()/2) + rand.nextInt(gm.monster.getATK()+1);
                se.setFile(System.getProperty("user.dir") + "/src/res/sound/sword_swing.wav");
                
                gm.monster.setHealth(gm.monster.getHealth()+gm.monster.getDEF()-damageRoll);
                if(gm.monster.getHealth()>0){
                    se.play();
                    if(!gm.monster.getName().equals("Demon Lord")){
                        gm.ui.messageText.setText("You slashed at the " + gm.monster.getName() + "! It took " + (damageRoll-gm.monster.getDEF()) + " damage\n It attacks back! You took " + (damageRoll2-gm.playerInfo.getModfifiedDEF()) + " damage");
                    } else if (!gm.playerInfo.getWeapon().getName().equals("Demonsbane")){
                        gm.ui.messageText.setForeground(Color.white);
                        gm.ui.messageText.setText("Your weapon is ineffective!" + " Demon Lord sends out orbs of black magic! You took " + (damageRoll2-gm.playerInfo.getModfifiedDEF()) + " damage");
                    } else {
                        /* Demon Lord combat here, will make it more complex later, multiple random attacks etc. (also move this to separate function and also put in spells) */
                        
                        damageRoll2 = dLordCombat(damageRoll, damageRoll2);
                        
                    }
                    if ((gm.playerInfo.getModfifiedDEF()-damageRoll2)<0){
                        gm.playerInfo.setHealth(gm.playerInfo.getHealth()+gm.playerInfo.getModfifiedDEF()-damageRoll2);
                        if (gm.playerInfo.getHealth()<=0){
                            loseState();
                        }
                    }
                } else {
                    
                    try {
                        winState();
                    } catch (IOException ex) {
                        Logger.getLogger(CombatChoiceHandler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CombatChoiceHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                if (gm.playerInfo.getHealth()>0){
                    gm.ui.addPlayerInfo();
                }
                break;
                
            case "fireball":                            /* Add the Demon Lord cases to spells */
                
                if (gm.playerInfo.getMana() < 6) {
                    
                    gm.ui.messageText.setText("Insufficient mana!");
                    gm.ui.addFightMenu();
                    
                }
                
                else {
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/fireball.wav");
                    se.play();
                
                    gm.playerInfo.setMana(gm.playerInfo.getMana()-6);
                    int firedamage = 25+(gm.playerInfo.getMAG()*2);
                    damageRoll2 = rand.nextInt(gm.monster.getATK()+1);

                    gm.monster.setHealth(gm.monster.getHealth()-firedamage);
                    if(gm.monster.getHealth()>0){
                        gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);
                        if (gm.playerInfo.getHealth()<=0){
                            loseState();
                        }
                        gm.ui.messageText.setText("Flames engulf the " + gm.monster.getName() + "! It took " + firedamage + " damage\n It attacks back! You took " + damageRoll2 + " damage");
                        gm.ui.addFightMenu();
                    } else {
                        try {
                            winState();
                        } catch (IOException ex) {
                            Logger.getLogger(CombatChoiceHandler.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(CombatChoiceHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    gm.ui.addPlayerInfo();
                    
                }

                break;

            case "thunder":

                if (gm.playerInfo.getMana() < 2) {

                        gm.ui.messageText.setText("Insufficient mana!");
                        gm.ui.addFightMenu();

                    }

                    else {

                        se.setFile(System.getProperty("user.dir") + "/src/res/sound/zap.wav");
                        se.play();

                        gm.playerInfo.setMana(gm.playerInfo.getMana()-2);
                        int thunderdamage = 10+gm.playerInfo.getMAG();
                        damageRoll2 = rand.nextInt(gm.monster.getATK()+1);

                        gm.monster.setHealth(gm.monster.getHealth()-thunderdamage);
                        if(gm.monster.getHealth()>0){
                            gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);
                            if (gm.playerInfo.getHealth()<=0){
                                loseState();
                            }
                            gm.ui.messageText.setText("Lightning strikes the " + gm.monster.getName() + "! It took " + thunderdamage + " damage\n It attacks back! You took " + damageRoll2 + " damage");
                            gm.ui.addFightMenu();
                        } else {
                            try {
                                winState();
                            } catch (IOException ex) {
                                Logger.getLogger(CombatChoiceHandler.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CombatChoiceHandler.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        gm.ui.addPlayerInfo();

                    }    


                break;    

            case "freeze":
                
            if (gm.playerInfo.getMana() < 5) {
                    
                    gm.ui.messageText.setText("Insufficient mana!");
                    gm.ui.addFightMenu();
                    
                }
                
                else {
                    
                    se.setFile(System.getProperty("user.dir") + "/src/res/sound/ice.wav");
                    se.play();
                
                    gm.playerInfo.setMana(gm.playerInfo.getMana()-5);
                    int freezedamage = 15+gm.playerInfo.getMAG();
                    damageRoll2 = rand.nextInt(gm.monster.getATK()+1);
                    int freezechance = rand.nextInt(4);

                    gm.monster.setHealth(gm.monster.getHealth()-freezedamage);
                    if(gm.monster.getHealth()>0){
                        if(freezechance != 3){
                            gm.playerInfo.setHealth(gm.playerInfo.getHealth()-damageRoll2);
                            if (gm.playerInfo.getHealth()<=0){
                                loseState();
                            }
                            gm.ui.messageText.setText(gm.monster.getName() + " gets covered by a cold veil! It took " + freezedamage + " damage\n It attacks back! You took " + damageRoll2 + " damage");
                        } else {
                            gm.ui.messageText.setText(gm.monster.getName() + " gets covered by a cold veil! It took " + freezedamage 
                                    + " damage\nThe " + gm.monster.getName() + " is frozen solid");
                        }
                        gm.ui.addFightMenu();
                    } else {
                        try {
                            winState();
                        } catch (IOException ex) {
                            Logger.getLogger(CombatChoiceHandler.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(CombatChoiceHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
                
                gm.ui.combatFlag = false;
                gm.music.stop();
                gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_adventure.wav");
                gm.music.play_low();
                gm.music.loop();
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
                
            case "after_battle":
                
                if (gm.playerInfo.getExp()>=gm.playerInfo.getNextlevelexp()){
                    
                    gm.ui.messageText.setText("LEVEL UP!"); 
                    gm.ui.messageText.setForeground(Color.white);
                    gm.ui.choice1.setActionCommand("level_up");
                    gm.ui.choiceButtonPanel.add(gm.ui.choice1);
                    
                } else {
                
                    gm.ui.messageText.setText("Victory is mine!"); 
                    gm.ui.messageText.setForeground(Color.yellow);
                    gm.ui.addInteractMenu();

                }
                
                break;
                
                
            case "level_up":
                
                gm.ui.messageText.setText("You are filled with a newfound strength!");
                gm.playerInfo.setLevel(gm.playerInfo.getLevel()+1);
                gm.playerInfo.setATK(gm.playerInfo.getATK()+2);
                gm.playerInfo.setDEF(gm.playerInfo.getDEF()+1);
                gm.playerInfo.setMAG(gm.playerInfo.getMAG()+1);
                gm.playerInfo.setModifiedATK(gm.playerInfo.getATK() + gm.playerInfo.getWeapon().getModifier());
                gm.playerInfo.setModfifiedDEF(gm.playerInfo.getDEF() + gm.playerInfo.getArmor().getModifier());
                gm.playerInfo.setMaxhealth(100 + (gm.playerInfo.getLevel()-1)*20);
                gm.playerInfo.setMaxmana(20 + gm.playerInfo.getMAG()*5);
                gm.playerInfo.setExp(gm.playerInfo.getExp()-gm.playerInfo.getNextlevelexp());
                gm.playerInfo.setNextlevelexp(150 + (gm.playerInfo.getLevel()-1)*40);
                
                gm.ui.makeStatsText();
                gm.ui.statsText.setVisible(false);
                
                
                gm.ui.addPlayerInfo();
                gm.ui.addInteractMenu();
                
                break;
                
                
        }
        
    }
    
    public void winState() throws IOException, InterruptedException{
        
        se.play();
        gm.ui.combatFlag = false;
        gm.music.stop();
        gm.ui.messageText.setText("The " + gm.monster.getName() + " was defeated!\n You gain " + gm.monster.getExp() + " exp and " + gm.monster.getGold() + " gold.");
        gm.playerInfo.setCash(gm.playerInfo.getCash()+gm.monster.getGold());
        gm.playerInfo.setExp(gm.playerInfo.getExp()+gm.monster.getExp());

        if (gm.monster.getName().equals("Goblin") && gm.ui.goblinFlag){
            
            gm.ui.bgPanel[3].remove(3);
            gm.ui.bgPanel[3].remove(3);
            createObjectwg2d(3,240,60,400,400,"/res/goblin.png");
            gm.ui.bgPanel[3].add(gm.ui.bgLabel[3]);
            gm.ui.goblinFlag = false;
            gm.ui.bgPanel[3].getComponent(0).setVisible(true);
            gm.ui.bgPanel[3].getComponent(1).setVisible(true);
            gm.ui.bgPanel[3].getComponent(2).setVisible(true);

            gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_adventure.wav");
            gm.music.play_low();
            gm.music.loop();

        }
        if (gm.monster.getName().equals("Skeletons") && gm.ui.skeleFlag){
            gm.ui.bgPanel[2].remove(0);
            gm.ui.skeleFlag = false;

            gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_adventure.wav");
            gm.music.play_low();
            gm.music.loop();

        }
        if (gm.monster.getName().equals("Zombie") && gm.ui.zombieFlag){
            gm.ui.bgPanel[15].remove(0);
            gm.ui.zombieFlag = false;

            gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_adventure.wav");
            gm.music.play_low();
            gm.music.loop();

        }
        if (gm.monster.getName().equals("Bear") && gm.ui.bearFlag){
            gm.ui.bgPanel[10].remove(0);

            gm.ui.messageText.setText("The " + gm.monster.getName() + " was defeated!\n You got [BEAR PELT]");

            gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_tavern.wav");
            gm.music.play_low();
            gm.music.loop();

            gm.ui.j3x2.setIcon(new ImageIcon(getClass().getResource("/res/bear_pelt.png")));

            JMenuItem menuItem[] = new JMenuItem[2];

            JPopupMenu popMenu = new JPopupMenu();

            menuItem[0] = new JMenuItem("Examine");
            menuItem[0].addActionListener(gm.weaponChoiceHandler);
            menuItem[0].setActionCommand("examine_bpelt");
            popMenu.add(menuItem[0]);

            gm.ui.j3x2.addMouseListener(new MouseListener(){


                @Override
                public void mouseClicked(MouseEvent e){}

                @Override
                public void mousePressed(MouseEvent e){

                    if (SwingUtilities.isRightMouseButton(e)){
                        popMenu.show(gm.ui.j3x2, e.getX(), e.getY());
                    }

                }

                @Override
                public void mouseReleased(MouseEvent e){}

                @Override
                public void mouseEntered(MouseEvent e){}

                @Override
                public void mouseExited(MouseEvent e){}


            });


            gm.ui.bearFlag = false;
            gm.ui.bearpeltFlag = true;
        }
        if (gm.monster.getName().equals("Demon Lord") && gm.ui.demonFlag){
            gm.ui.bgPanel[20].remove(0);
            gm.ui.demonFlag = false;

            gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_adventure.wav");
            gm.music.play_low();
            gm.music.loop();

        }

        //gm.ui.addInteractMenu();

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
        gm.ui.choice1.addActionListener(gm.combatChoiceHandler);
        gm.ui.choice1.setActionCommand("after_battle");
        gm.ui.choiceButtonPanel.add(gm.ui.choice1);

                    
        
    }
    
    public void loseState(){
        
        gm.music.stop();
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/wilhelm_scream.wav");
        se.play();
        
        gm.ui.gameOverScreen();
        
        if(gm.monster.getName().equals("Bear")){
            gm.ui.deathText.setText("You could not bear to live anymore.");
        }
        if(gm.monster.getName().equals("Skeletons")){
            gm.ui.deathText.setText("You join your new skeletal friends on a brand new adventure.");
        }
        if(gm.monster.getName().equals("Goblin")){
            gm.ui.deathText.setText("You managed to die against a Goblin? Impressive.");
        }
        if(gm.monster.getName().equals("Zombie")){
            gm.ui.deathText.setText("Seems like you will remain in this prison forever...");
        }
        if(gm.monster.getName().equals("Demon Lord")){
            gm.ui.deathText.setText("\"Your soul is mine!\"");
            gm.ui.deathText.setForeground(Color.red);
        }
        
    }
    
    public int dLordCombat(int damageRoll, int damageRoll2){
        
        gm.ui.messageText.setForeground(Color.white);
                        
        int attackRand = rand.nextInt(6);

        if (attackRand == 0 && attackRand == 1 && attackRand == 2){
            gm.ui.messageText.setText("You attacked the Demon Lord! It took " + (damageRoll-gm.monster.getDEF()) + " damage\n It attacks back! You took " + (damageRoll2-gm.playerInfo.getModfifiedDEF()) + " damage");
        } else if (attackRand == 3){
            damageRoll2 = 20;
            gm.ui.messageText.setText("You attacked the Demon Lord! It took " + (damageRoll-gm.monster.getDEF()) + " damage\n It uses Void Blast! You took " + (damageRoll2) + " damage");
        } else if (attackRand == 4){
            damageRoll2 = 15;
           gm.ui.messageText.setText("You attacked the Demon Lord! It took " + (damageRoll-gm.monster.getDEF()) + " damage\n It uses Dark Strike! You took " + (damageRoll2) + " damage"); 
        } else {
            damageRoll2 = 10;
            gm.ui.messageText.setText("You attacked the Demon Lord! It took " + (damageRoll-gm.monster.getDEF()) + " damage\n It uses Necroslash! You took " + (damageRoll2) + " damage");
        }
        
        return damageRoll2;
    }
    
    /* Trying to figure out how to change object alpha value, work in progress */
    
    public void createObjectwg2d(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName) throws IOException, InterruptedException{
     
        DisappearingLabel objectLabel = new DisappearingLabel(objFileName);
        objectLabel.setBounds(objx,objy,objWidth,objHeight);
        
        /*ImageIcon objectIcon = new ImageIcon(getClass().getResource(objFileName));
        objectLabel.setIcon(objectIcon);
        
        gm.ui.bgPanel[bgNum].setVisible(false);
        gm.ui.bgPanel[bgNum].add(objectLabel);
        gm.ui.bgPanel[bgNum].setVisible(true);*/
        
    }
    
    
    
}
