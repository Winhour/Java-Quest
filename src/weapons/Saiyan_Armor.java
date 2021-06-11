/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weapons;

/**
 *
 * @author Marcin
 */
public class Saiyan_Armor extends Weapon {
    
    String name = "Special Armor";
    int modifier = 7;
    String info = "Nobody knows where it came from, but this armor is of exquisite quality.";

    public Saiyan_Armor() {
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
    public int getModifier() {
        return modifier;
    }

    @Override
    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String info) {
        this.info = info;
    }
    
}
