/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

/**
 *
 * @author Marcin
 */
public class LargeHealthPotion extends GameItem {
    
    String name = "L Potion";
    String effectMessage = "You recovered 60 health!";

    public LargeHealthPotion() {
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
    public String getEffectMessage() {
        return effectMessage;
    }

    @Override
    public void setEffectMessage(String effectMessage) {
        this.effectMessage = effectMessage;
    }
    
}
