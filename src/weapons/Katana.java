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
public class Katana extends Weapon {
    
    String name = "Katana";
    int modifier = 12;
    String info = "Glorious eastern steel, folded hundreds of times";

    public Katana() {
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
