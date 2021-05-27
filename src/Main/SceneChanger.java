/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Marcin
 */
public class SceneChanger {
    
    GameManager gm;
    
    public SceneChanger(GameManager gm){
        
        this.gm = gm;
        
    }
    
    /*int current = gm.ui.currentScene;
    int next = gm.ui.nextScene;
    int previous = gm.ui.previousScene;
    
    
    public void showScreenNext(int current, int next){
        
        gm.ui.bgPanel[current].setVisible(false);
        gm.ui.bgPanel[next].setVisible(true);
        
        gm.ui.previousScene = current;
        gm.ui.currentScene = next;
        
    }
    
    public void showScreenPrevious(int current, int previous){
        
        gm.ui.bgPanel[current].setVisible(false);
        gm.ui.bgPanel[previous].setVisible(true);
        
        gm.ui.currentScene = previous;
        
    }
    */
    
    public void showScreen1(){
        
        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);

    }
    
    public void showScreen2(){
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(true);
        gm.ui.bgPanel[3].setVisible(false);
        
    }
    
    public void showScreen3(){
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(true);
    }
    
}
