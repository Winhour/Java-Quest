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
public class DataSaveLoad {
    
    /* Will save and load data (playerinfo, inventory, currentscene) to/from a file */
    
    GameManager gm;
    
    public DataSaveLoad(GameManager gm){
        
        this.gm = gm;
        
    }
    
    public void saveData(){

        gm.ui.rememberCurrentScene();
        int scene = gm.ui.currentScene;
        
        

        
    }
    
    public void loadData(){
        
    }
    
}
