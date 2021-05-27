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
public class SmallElixir extends GameItem{
    
    String name = "S Elixir";
    String effectMessage = "You recovered 10 mana!";

    public SmallElixir() {
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
