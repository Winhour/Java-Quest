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
public class Broadsword extends Weapon {
    
    String name = "Broadsword";
    int modifier = 3;
    String info = "A common trusty sword, often used by adventurers";

    public Broadsword() {
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
