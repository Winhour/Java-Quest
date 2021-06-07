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
public class MediumElixir extends GameItem {
    
    String name = "M Elixir";
    String effectMessage = "You recovered 20 mana!";

    public MediumElixir() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffectMessage() {
        return effectMessage;
    }

    public void setEffectMessage(String effectMessage) {
        this.effectMessage = effectMessage;
    }
    
    
    
    
    
}
