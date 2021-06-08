/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import weapons.Broadsword;
import weapons.Demonsbane;
import weapons.Katana;
import weapons.Leather_Armor;
import weapons.Soldier_Armor;
import weapons.War_Axe;

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
                gm.ui.messageText.setText("A common trusty sword, often used by adventurers\n(ATK + 3)");
                gm.ui.messageText.setForeground(Color.white);
                break;
                
            case "equip_brdswrd"  :
                gm.ui.messageText.setText("Equipped <BROADSWORD>!");
                gm.ui.messageText.setForeground(Color.LIGHT_GRAY);
                gm.playerInfo.setWeapon(new Broadsword());
                gm.playerInfo.setModifiedATK(gm.playerInfo.getATK()+gm.playerInfo.getWeapon().getModifier());
                
                gm.ui.addPlayerInfo();
                gm.ui.makeStatsText();
                break;
                
            case "examine_empty":
                gm.ui.messageText.setText("The void stares back at you");
                gm.ui.messageText.setForeground(Color.white);
                break;
                
            case "equip_empty":
                gm.ui.messageText.setText("And how am I supposed to do that?");
                gm.ui.messageText.setForeground(Color.yellow);
                break;    
                
            case "examine_lthrarm":
                gm.ui.messageText.setText("It's not much, but it might protect you from arrows\n(DEF + 2)");
                gm.ui.messageText.setForeground(Color.white);
                break;
                
            case "equip_lthrarm"  :
                gm.ui.messageText.setText("Equipped <LEATHER ARMOR>!");
                gm.ui.messageText.setForeground(Color.LIGHT_GRAY);
                gm.playerInfo.setArmor(new Leather_Armor());
                gm.playerInfo.setModfifiedDEF(gm.playerInfo.getDEF()+gm.playerInfo.getArmor().getModifier());
                
                gm.ui.addPlayerInfo();
                gm.ui.makeStatsText();
                break;    
                
            case "examine_waraxe":
                gm.ui.messageText.setText("For fans of bloody battles, this axe serves it's purpose\n(ATK + 5)");
                gm.ui.messageText.setForeground(Color.white);
                break;
                
            case "equip_waraxe"  :
                gm.ui.messageText.setText("Equipped <WAR AXE>!");
                gm.ui.messageText.setForeground(Color.LIGHT_GRAY);
                gm.playerInfo.setWeapon(new War_Axe());
                gm.playerInfo.setModifiedATK(gm.playerInfo.getATK()+gm.playerInfo.getWeapon().getModifier());
                
                gm.ui.addPlayerInfo();
                gm.ui.makeStatsText();
                break;
                
            case "examine_sldarm":
                gm.ui.messageText.setText("A comfortable suit of armor, often worn by local militia\n(DEF + 4)");
                gm.ui.messageText.setForeground(Color.white);
                break;
                
            case "equip_sldarm"  :
                gm.ui.messageText.setText("Equipped <SOLDIER ARMOR>!");
                gm.ui.messageText.setForeground(Color.LIGHT_GRAY);
                gm.playerInfo.setArmor(new Soldier_Armor());
                gm.playerInfo.setModfifiedDEF(gm.playerInfo.getDEF()+gm.playerInfo.getArmor().getModifier());
                
                gm.ui.addPlayerInfo();
                gm.ui.makeStatsText();
                break;       
                
            case "examine_katana":
                gm.ui.messageText.setText("Glorious eastern steel, folded hundreds of times\n(ATK + 12)");
                gm.ui.messageText.setForeground(Color.white);
                break;    
                
            case "equip_katana"  :
                gm.ui.messageText.setText("Equipped <KATANA>!");
                gm.ui.messageText.setForeground(Color.LIGHT_GRAY);
                gm.playerInfo.setWeapon(new Katana());
                gm.playerInfo.setModifiedATK(gm.playerInfo.getATK()+gm.playerInfo.getWeapon().getModifier());
                
                gm.ui.addPlayerInfo();
                gm.ui.makeStatsText();
                break;      
                
            case "examine_demon" :
                gm.ui.messageText.setText("Sword infused with magic, can harm demonic entities\n(ATK + 10)");
                gm.ui.messageText.setForeground(Color.white);
                break;    
                
            case "equip_demon"  :
                gm.ui.messageText.setText("Equipped <DEMONSBANE>!");
                gm.ui.messageText.setForeground(Color.LIGHT_GRAY);
                gm.playerInfo.setWeapon(new Demonsbane());
                gm.playerInfo.setModifiedATK(gm.playerInfo.getATK()+gm.playerInfo.getWeapon().getModifier());
                
                gm.ui.addPlayerInfo();
                gm.ui.makeStatsText();
                break;         
             
            case "examine_bpelt"  :
                gm.ui.messageText.setText("A large pelt of Bear skin and fur");
                gm.ui.messageText.setForeground(Color.white);
                break;
                
            case "examine_ore"  :
                gm.ui.messageText.setText("A majestic ore glinting with the shine of moonlight");
                gm.ui.messageText.setForeground(Color.white);
                break;    
                
            case "examine_amulet_s" :
                
                gm.ui.messageText.setText("An amulet made out of Growltiger's claw (ATK +2)");
                gm.ui.messageText.setForeground(Color.white);
                
                break;
                
            case "examine_amulet_m" :
                
                gm.ui.messageText.setText("The magical jewel makes your magic more potent (MAG +3)");
                gm.ui.messageText.setForeground(Color.white);
                
                break;
                
            
        }
                
    }
    
}
