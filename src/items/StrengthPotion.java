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
public class StrengthPotion extends GameItem{
    
    String name = "STR Potion";
    String effectMessage = "You got an extra 5 Strength for a short period of time";

    public StrengthPotion() {
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
