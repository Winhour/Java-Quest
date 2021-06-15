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
    
    /* Change between the scenes */
    
    GameManager gm;
    SoundEffect se = new SoundEffect();
    
    
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
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);

    }
    
    public void showScreen2(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(true);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
        
    }
    
    public void showScreen3(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(true);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
        
    }
    
    public void showScreen4(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(true);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
        
    }
    
    public void showScreen5(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(true);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
        
    }
    
    public void showScreen6(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(true);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen7(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(true);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen8(){
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(true);
        gm.ui.statsText.setVisible(true);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen9(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.music.stop();
        gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_tavern.wav");
        gm.music.play_low();
        gm.music.loop();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(true);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen10(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(true);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
        
    }
    
    public void showScreen11(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(true);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen12(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(true);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen13(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(true);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen14(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(true);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen15(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(true);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen16(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(true);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen17(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(true);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen18(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(true);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen19(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(true);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen20(){
        
        se.setFile(System.getProperty("user.dir") + "/src/res/sound/move.wav");
        se.play();
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(true);
        gm.ui.bgPanel[21].setVisible(false);
    }
    
    public void showScreen21(){
        
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.bgPanel[5].setVisible(false);
        gm.ui.bgPanel[6].setVisible(false);
        gm.ui.bgPanel[7].setVisible(false);
        gm.ui.bgPanel[8].setVisible(false);
        gm.ui.bgPanel[9].setVisible(false);
        gm.ui.bgPanel[10].setVisible(false);
        gm.ui.bgPanel[11].setVisible(false);
        gm.ui.bgPanel[12].setVisible(false);
        gm.ui.bgPanel[13].setVisible(false);
        gm.ui.bgPanel[14].setVisible(false);
        gm.ui.bgPanel[15].setVisible(false);
        gm.ui.bgPanel[16].setVisible(false);
        gm.ui.bgPanel[17].setVisible(false);
        gm.ui.bgPanel[18].setVisible(false);
        gm.ui.bgPanel[19].setVisible(false);
        gm.ui.bgPanel[20].setVisible(false);
        gm.ui.bgPanel[21].setVisible(true);
        
    }
    
}
