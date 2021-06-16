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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 *
 * @author Marcin
 */
public class GameManager {
    
    /* Main function, hub for all the moving pieces */
    
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");       /* Will try to convert as much as possbile to Spring and do IOC + dependency injections */

    //PlayerInfo playerInfo = new PlayerInfo();
    
    PlayerInfo playerInfo = context.getBean("playerInfo", PlayerInfo.class);
    
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
    DataSaveLoad dsl = new DataSaveLoad(this);
    SceneChanger sceneChanger = new SceneChanger(this);
    
    SoundEffect music = context.getBean("music",SoundEffect.class);
    
    
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
        
        music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_one.wav");
        
        /* https://wingless-seraph.net/en/material-music_battle.html for music */

               
    }
    
}
