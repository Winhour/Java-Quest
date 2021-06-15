/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Marcin
 */
public class DisappearingLabel extends JLabel implements ActionListener{            /* Doesn't fully work yet */
    
    Timer alphaTimer = new Timer(20, this);
    BufferedImage img;
    float alphavalue = 1f;
    String objFileName;

    public DisappearingLabel(String objFileName) {
        
        loadBufferedImage(objFileName);
        alphaTimer.start();
        
    }
    
    
    
    public void loadBufferedImage(String objFileName){
        
        img = null;
        try {
            
            img = ImageIO.read(getClass().getResource(objFileName));
            
        } catch (IOException e){
            
        }
        
    }
    
    @Override
    public Dimension getPreferredSize() {
        return img == null ? super.getPreferredSize() : new Dimension(img.getWidth(), img.getHeight());
    }
    
    
    public void paint(Graphics g){
        
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphavalue));
        g2d.drawImage(img, 0,0,null);
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if (img != null) {
            int x = (getWidth() - img.getWidth()) / 2;
            int y = (getHeight() - img.getHeight()) / 2;
            g.drawImage(img, x, y, this);
        }
        super.paintComponent(g);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        alphavalue = alphavalue - 0.01f;
        if(alphavalue < 0){
            
            alphavalue = 0;
            alphaTimer.stop();
            
        }
        
        repaint();
        
    }
    
    
    
}
