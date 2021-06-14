/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Marcin
 */
public class CustomCursor {                                 /* work in progress */
    
    public void changeCursor(JFrame window){
        
        Toolkit t1 = Toolkit.getDefaultToolkit();
        Image img = t1.getImage("/res/mycursor.png");
        Point p = new Point(0,0);
        Cursor c = t1.createCustomCursor(img, p, "hand_cursor");
        
        window.setCursor(c);
        
        
    }
    
}
