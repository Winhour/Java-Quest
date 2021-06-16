/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Marcin
 */
public class DataSaveLoad {
    
    /* Will save and load data (playerinfo, inventory, currentscene) to/from a file */
    
    GameManager gm;
    
    public DataSaveLoad(GameManager gm){
        
        this.gm = gm;
        
    }
    
    public void saveData(){

        gm.ui.rememberCurrentScene();
        int scene = gm.ui.currentScene;
        
        boolean goblinFlag = gm.ui.goblinFlag;
        boolean skeleFlag = gm.ui.skeleFlag;
        boolean bearFlag = gm.ui.bearFlag;
        boolean zombieFlag = gm.ui.zombieFlag;
        boolean demonFlag = gm.ui.demonFlag;
        boolean bearpeltFlag = gm.ui.bearpeltFlag;
        boolean moonoreFlag = gm.ui.moonoreFlag;
        boolean combatFlag = gm.ui.combatFlag;
        boolean barrelgoldFlag = gm.ui.barrelgoldFlag;                 
        boolean goldkeyFlag = gm.ui.goldkeyFlag;
        boolean blueleavesFlag = gm.ui.blueleavesFlag;
        
        int health = gm.playerInfo.getHealth();
        int mana = gm.playerInfo.getMana();
        String weapon_equipped = gm.playerInfo.getWeapon().getName();
        String armor_equipped = gm.playerInfo.getArmor().getName();
        int level = gm.playerInfo.getLevel();
        int maxhealth = gm.playerInfo.getMaxhealth();
        int exp = gm.playerInfo.getExp();
        int nextlevelexp = gm.playerInfo.getNextlevelexp();
        int cash = gm.playerInfo.getCash();
        
        int ATK = gm.playerInfo.getATK();
        int DEF = gm.playerInfo.getDEF();
        int MAG = gm.playerInfo.getMAG();
        int SPD = gm.playerInfo.getSPD();

        int modifiedATK = gm.playerInfo.getModifiedATK();
        int modifiedDEF = gm.playerInfo.getModfifiedDEF();

        int maxmana = gm.playerInfo.getMaxmana();
        

        
    }
    
    public void loadData(){
        
    }
    
}
