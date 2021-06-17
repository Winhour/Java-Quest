/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.monsters;

/**
 *
 * @author Marcin
 */
public class Zombie extends Monster {
    
    /*int health;
    int exp;
    String name;
    int gold;
    
    int ATK;
    int DEF;
    int SPD;*/
    
    /*int health = 220;
    int exp = 120;
    String name = "Zombie";
    int gold = 30;
    
    int ATK = 8;
    int DEF = 2;
    int SPD = 1;*/

    public Zombie() {
    }

    @Override
    public int getHealth() {
        return health;
    }
    
    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getExp() {
        return exp;
    }

    @Override
    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public int getATK() {
        return ATK;
    }

    @Override
    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    @Override
    public int getDEF() {
        return DEF;
    }

    @Override
    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    @Override
    public int getSPD() {
        return SPD;
    }

    @Override
    public void setSPD(int SPD) {
        this.SPD = SPD;
    }
    
    
    
}
