/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.monsters.Goblin;
import Main.monsters.Monster;
import items.GameItem;
import items.MediumHealthPotion;
import items.SmallElixir;
import items.SmallHealthPotion;



/**
 *
 * @author Marcin
 */
public class GameManager {

    PlayerInfo playerInfo = new PlayerInfo();
    
    Monster monster = new Goblin();
    
    GameItem potion = new SmallHealthPotion();
    GameItem potion2 = new SmallHealthPotion();
    GameItem potion3 = new MediumHealthPotion();
    GameItem elixir = new SmallElixir();
    
    
    GameItem[] itemlist= new GameItem[9];
    
    CombatChoiceHandler combatChoiceHandler = new CombatChoiceHandler(this);
    ItemChoiceHandler itemChoiceHandler = new ItemChoiceHandler(this);
    DialogChoiceHandler dialogChoiceHandler = new DialogChoiceHandler(this);
    WeaponChoiceHandler weaponChoiceHandler = new WeaponChoiceHandler(this);
    UI ui = new UI(this);
    SceneChanger sceneChanger = new SceneChanger(this);
    
    public static void main(String[] args) {
        
        new GameManager();

    }
    
    public GameManager(){
        
        itemlist[0] = potion;
        itemlist[1] = potion2;
        itemlist[2] = potion3;
        itemlist[3] = elixir;
        itemlist[4] = null;
        itemlist[5] = null;
        itemlist[6] = null;
        itemlist[7] = null;
        itemlist[8] = null;
        playerInfo.setItemlist(itemlist);
               
    }
    
}
