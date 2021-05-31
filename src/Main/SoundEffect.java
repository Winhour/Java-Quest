/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author Marcin
 */
public class SoundEffect {
    
    Clip clip;
    
    public void setFile(String soundFileName){
        
        try{
            
            File file = new File(soundFileName);
            if (file.exists()){
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            } else {
                System.out.println("Audio file doesn't exist");
            }
            
        } catch (Exception e){
            System.out.println("Problem with audio sound");
        }
        
    }
    
    public void play(){
        
        clip.setFramePosition(0);
        FloatControl gainControl = 
        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f);
        clip.start();
        
    }
    
    
}
