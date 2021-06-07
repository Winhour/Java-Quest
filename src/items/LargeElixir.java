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
public class LargeElixir extends GameItem {
    
    String name = "L Elixir";
    String effectMessage = "You fully recovered your mana!";
    
    public LargeElixir() {  
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
