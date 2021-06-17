/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import items.GameItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import weapons.Weapon;


/**
 *
 * @author Marcin
 */
public class PlayerInfo {
    

    @Value("${playerInfo.health}")
    private int health;
    
    @Value("${playerInfo.mana}")
    private int mana;
    
    @Autowired
    @Qualifier("broadsword")
    private Weapon weapon;
    
    @Autowired
    @Qualifier("larmor")
    private Weapon armor;
    
    private int level;
    private int maxhealth;
    private int exp;
    private int nextlevelexp;
    private int cash;
    
    private int ATK;
    private int DEF;
    private int MAG;
    private int SPD;
    
    private int modifiedATK;
    private int modfifiedDEF;

    private int maxmana;
  
    /*public int health = 100;
    public int mana = 20;
    public Weapon weapon = new Broadsword();
    public Weapon armor = new Leather_Armor();
    public int level = 1;
    public int maxhealth = 100 + (level-1)*20;
    public int exp = 0;
    public int nextlevelexp = 150 + (level-1)*40;
    public int cash = 90;
    
    public int ATK = 5;
    public int DEF = 1;
    public int MAG = 0;
    public int SPD = 5;
    
    public int modifiedATK = ATK + weapon.getModifier();
    public int modfifiedDEF = DEF + armor.getModifier();

    public int maxmana = 20 + MAG*5;*/
    
    public GameItem[] itemlist = new GameItem[9];
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getArmor() {
        return armor;
    }

    public void setArmor(Weapon armor) {
        this.armor = armor;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getSPD() {
        return SPD;
    }

    public void setSPD(int SPD) {
        this.SPD = SPD;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxhealth() {
        return maxhealth;
    }

    public void setMaxhealth(int maxhealth) {
        this.maxhealth = maxhealth;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNextlevelexp() {
        return nextlevelexp;
    }

    public void setNextlevelexp(int nextlevelexp) {
        this.nextlevelexp = nextlevelexp;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getMAG() {
        return MAG;
    }

    public void setMAG(int MAG) {
        this.MAG = MAG;
    }

    public int getMaxmana() {
        return maxmana;
    }

    public void setMaxmana(int maxmana) {
        this.maxmana = maxmana;
    }

    public GameItem[] getItemlist() {
        return itemlist;
    }

    public void setItemlist(GameItem[] itemlist) {
        this.itemlist = itemlist;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getModifiedATK() {
        return modifiedATK;
    }

    public int getModfifiedDEF() {
        return modfifiedDEF;
    }

    public void setModifiedATK(int modifiedATK) {
        this.modifiedATK = modifiedATK;
    }

    public void setModfifiedDEF(int modfifiedDEF) {
        this.modfifiedDEF = modfifiedDEF;
    }
    
    
    
    
    

    
    
    
    
    
    
    
}
