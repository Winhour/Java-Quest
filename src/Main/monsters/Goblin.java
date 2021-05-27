/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.monsters;

import Main.monsters.Monster;

/**
 *
 * @author Marcin
 */
public class Goblin extends Monster{

    int health = 20;
    int exp = 100;
    String name = "Goblin";
    
    int ATK = 1;
    int DEF = 1;
    int SPD = 3;

    public Goblin() {
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
}
