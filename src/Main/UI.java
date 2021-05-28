/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.monsters.Goblin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author Marcin
 */
public class UI {
    
    GameManager gm;
    
    JFrame window;
    
    public JPanel titleNamePanel;
    public JLabel titleNameLabel;
    public JPanel startButtonPanel;
    public JButton startButton;
    
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    
    public JTextArea messageText = new JTextArea();
    public JPanel choiceButtonPanel;
    public JPanel playerInfoPanel;
    public JButton choice1, choice2, choice3, choice4;
    public JPanel bgPanel[] = new JPanel[20];
    public JLabel bgLabel[] = new JLabel[20];
    
    Font titleFont = new Font("Times New Roman",Font.PLAIN, 100);
    Font normalFont = new Font("Book Antiqua", Font.PLAIN, 36);
    Font playerInfoFont = new Font("Book Antiqua", Font.PLAIN, 24);
    Font smallerFont = new Font("Book Antiqua", Font.PLAIN, 18);
    
    public int previousScene = 0;
    public int currentScene = 1;
    public int nextScene = 0;
    
    boolean goblinFlag = true;
    boolean skeleFlag = true;
    
    public JLabel j1x1, j1x2, j1x3, j1x4;
    public JLabel j2x1, j2x2, j2x3, j2x4;
    public JLabel j3x1, j3x2, j3x3, j3x4;
    public JLabel j4x1, j4x2, j4x3, j4x4;
    public JLabel j1x5, j2x5, j3x5, j4x5;
    
    
    
    
    public UI(GameManager gm){
        
        this.gm = gm;
        
        createTitleScreen();
        
        //createMainField();
        
        //generateScreen();
        
        window.setVisible(true);
        
    }
    
     /**********************************************************************************************************************************/
    
    public void createTitleScreen(){
        
        window = new JFrame();
        window.setSize(1024,808);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(128,128,768,192);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("JAVA QUEST");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(400, 512, 220, 100);
        startButtonPanel.setBackground(Color.black);
        startButtonPanel.setForeground(Color.black);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(new Font("Book Antiqua", Font.PLAIN, 44));
        //startButton.setBorderPainted(false);
        startButton.setFocusable(false);
        startButton.addActionListener(tsHandler);
        
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        window.add(startButtonPanel);
        window.add(titleNamePanel);
        
        
    }
    
     /**********************************************************************************************************************************/
    
    public void createMainField(){
        
        messageText = new JTextArea("~ Starhome, the town of possibilities looms close in the distance~");
        messageText.setBounds(64,550,896,80);
        messageText.setBackground(Color.BLACK);
        messageText.setForeground(Color.WHITE);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 32));
        window.add(messageText);
        
        addInteractMenu();
        
        addPlayerInfo();

        
        
        
    }
    
     /**********************************************************************************************************************************/
    
    public void createBackground(int bgNum, String bgFileName){
        
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(110,50,800,500);
        bgPanel[bgNum].setBackground(Color.BLACK);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);
        
        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0,0,800,500);
        
        ImageIcon bgIcon = new ImageIcon(getClass().getResource(bgFileName));
        bgLabel[bgNum].setIcon(bgIcon);
        
        
                
    }
    
     /**********************************************************************************************************************************/
    
    public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName){
        
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx,objy,objWidth,objHeight);
        
        ImageIcon objectIcon = new ImageIcon(getClass().getResource(objFileName));
        objectLabel.setIcon(objectIcon);
        
        bgPanel[bgNum].add(objectLabel);
        
    }
    
     /**********************************************************************************************************************************/
    
    public void createObjectInteractable(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName,
            String choice1Name, String choice2Name, String choice3Name, String choice1Command, String choice2Command, String choice3Command){
        
        JPopupMenu popMenu = new JPopupMenu();
        
        JMenuItem menuItem[] = new JMenuItem[4];
        
        menuItem[1] = new JMenuItem(choice1Name);
        menuItem[1].addActionListener(gm.dialogChoiceHandler);
        menuItem[1].setActionCommand(choice1Command);
        popMenu.add(menuItem[1]);
        
        menuItem[2] = new JMenuItem(choice2Name);
        menuItem[2].addActionListener(gm.dialogChoiceHandler);
        menuItem[2].setActionCommand(choice2Command);
        popMenu.add(menuItem[2]);
        
        menuItem[3] = new JMenuItem(choice3Name);
        menuItem[3].addActionListener(gm.dialogChoiceHandler);
        menuItem[3].setActionCommand(choice3Command);
        popMenu.add(menuItem[3]);
        
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx,objy,objWidth,objHeight);
        
        ImageIcon objectIcon = new ImageIcon(getClass().getResource(objFileName));
        objectLabel.setIcon(objectIcon);
        
        objectLabel.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu.show(objectLabel, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        bgPanel[bgNum].add(objectLabel);
        
    }
    
     /**********************************************************************************************************************************/
    
    public void generateScreen(){
        
        //SCENE 1   Outskirts
        
        createBackground(1, "/res/village.jpg");
        createObjectInteractable(1, 40,80,400,400,"/res/priest.png", "Talk", "Interact", "Look", "talk_priest", "interact_priest", "look_priest");
        createObjectInteractable(1, 480,80,400,400,"/res/peasant.png", "Talk", "Interact", "Look", "talk_peasant", "interact_peasant","look_peasant");
        bgPanel[1].add(bgLabel[1]);
        
        //SCENE 2   Goblin
        
        createBackground(2, "/res/dungeon2.jpg");
        createObject(2, 240,60,400,400,"/res/skeletons.png");
        bgPanel[2].add(bgLabel[2]);
        
         //SCENE 3  Skeleton
        
        createBackground(3, "/res/dungeon.jpg");
        createObject(3, 240,60,400,400,"/res/goblin.png");
        bgPanel[3].add(bgLabel[3]);
        
        //SCENE 4   Town
        
        createBackground(4, "/res/town.jpg");
        bgPanel[4].add(bgLabel[4]);
        
        //SCENE 5   Shop
        
        createBackground(5, "/res/shop.jpg");
        bgPanel[5].add(bgLabel[5]);
        
        //SCENE 6   Smith
        
        createBackground(6, "/res/smith.jpg");
        createObjectInteractable(6,320,70,400,400,"/res/blacksmith.png", "Talk", "Interact", "Look", "talk_smith", "interact_smith", "look_smith");
        bgPanel[6].add(bgLabel[6]);
        
        
        //SCENE 7   Town Hall
        
        createBackground(7, "/res/hall.jpg");
        createObjectInteractable(7,240,70,400,400,"/res/mayor.png", "Talk", "Interact", "Look", "talk_mayor", "interact_mayor", "look_mayor");
        bgPanel[7].add(bgLabel[7]);
        
        
        //SCENE 8 Inventory
        
        inventoryScreen();
        
        
    }
    
     /**********************************************************************************************************************************/
    
    public void addPlayerInfo(){
        
        if(playerInfoPanel != null){
            playerInfoPanel.setVisible(false);
            window.remove(playerInfoPanel);
        }
        
        playerInfoPanel = new JPanel();
        playerInfoPanel.setBounds(20,5,960,50);
        playerInfoPanel.setBackground(Color.black);
        window.add(playerInfoPanel);
        
        JLabel heart = new JLabel();
        heart.setBounds(10,10,40,40);
        ImageIcon heartIcon = new ImageIcon(getClass().getResource("/res/heart.png"));
        heart.setIcon(heartIcon);
        playerInfoPanel.add(heart);
        
        JLabel hpLabel = new JLabel("");
        hpLabel.setFont(playerInfoFont);
        hpLabel.setBackground(Color.black);
        hpLabel.setForeground(Color.white);
        String hpstring = String.valueOf(gm.playerInfo.getHealth());
        String maxhpstring = String.valueOf(gm.playerInfo.getMaxhealth());
        hpLabel.setText(hpstring + "/" + maxhpstring + "   ");
        playerInfoPanel.add(hpLabel);
        
        JLabel mana = new JLabel();
        mana.setBounds(10,10,40,40);
        ImageIcon manaIcon = new ImageIcon(getClass().getResource("/res/mana.png"));
        mana.setIcon(manaIcon);
        playerInfoPanel.add(mana);
        
        JLabel mnLabel = new JLabel("");
        mnLabel.setFont(playerInfoFont);
        mnLabel.setBackground(Color.black);
        mnLabel.setForeground(Color.white);
        String mnstring = String.valueOf(gm.playerInfo.getMana());
        String maxmnstring = String.valueOf(gm.playerInfo.getMaxmana());
        mnLabel.setText(mnstring + "/" + maxmnstring + "   ");
        playerInfoPanel.add(mnLabel);
        
        JLabel weapon = new JLabel();
        weapon.setBounds(10,10,40,40);
        ImageIcon wpnIcon = new ImageIcon(getClass().getResource("/res/weapon.png"));
        weapon.setIcon(wpnIcon);
        playerInfoPanel.add(weapon);
        
        JLabel wpnLabel = new JLabel("");
        wpnLabel.setFont(playerInfoFont);
        wpnLabel.setBackground(Color.black);
        wpnLabel.setForeground(Color.white);
        wpnLabel.setText(gm.playerInfo.getWeapon() + "   ");
        playerInfoPanel.add(wpnLabel);
        
        JLabel armor = new JLabel();
        armor.setBounds(10,10,40,40);
        ImageIcon armIcon = new ImageIcon(getClass().getResource("/res/armor.png"));
        armor.setIcon(armIcon);
        playerInfoPanel.add(armor);
        
        JLabel armLabel = new JLabel("");
        armLabel.setFont(playerInfoFont);
        armLabel.setBackground(Color.black);
        armLabel.setForeground(Color.white);
        armLabel.setText(gm.playerInfo.getArmor() + "   ");
        playerInfoPanel.add(armLabel);
        
        JLabel cash = new JLabel();
        cash.setBounds(10,10,40,40);
        ImageIcon cashIcon = new ImageIcon(getClass().getResource("/res/cash.png"));
        cash.setIcon(cashIcon);
        playerInfoPanel.add(cash);
        
        JLabel cashLabel = new JLabel("");
        cashLabel.setFont(playerInfoFont);
        cashLabel.setBackground(Color.black);
        cashLabel.setForeground(Color.white);
        cashLabel.setText(String.valueOf(gm.playerInfo.getCash()));
        playerInfoPanel.add(cashLabel);
  
        
    }
    
     /**********************************************************************************************************************************/
    
    
    public void addFightMenu(){
        
        if(choiceButtonPanel != null){
            choiceButtonPanel.setVisible(false);
            window.remove(choiceButtonPanel);
        }
        
        choiceButtonPanel = new JPanel(new GridLayout(1,4,10,10));
        choiceButtonPanel.setBounds(64, 640, 896, 100);
        choiceButtonPanel.setBackground(Color.black);
        window.add(choiceButtonPanel);
        
        choice1 = new JButton("Fight");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.addActionListener(gm.combatChoiceHandler);
        choice1.setActionCommand("fight");
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton("Spell");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.addActionListener(gm.combatChoiceHandler);
        choice2.setActionCommand("spell");
        choiceButtonPanel.add(choice2);
        
        choice3 = new JButton("Item");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.addActionListener(gm.combatChoiceHandler);
        choice3.setActionCommand("item");
        choiceButtonPanel.add(choice3);
        
        choice4 = new JButton("Run");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.addActionListener(gm.combatChoiceHandler);
        choice4.setActionCommand("run");
        choiceButtonPanel.add(choice4);
        
    }
    
     /**********************************************************************************************************************************/
    
    
    public void addInteractMenu(){
        
        if(choiceButtonPanel != null){
            choiceButtonPanel.setVisible(false);
            window.remove(choiceButtonPanel);
        }
        
        choiceButtonPanel = new JPanel(new GridLayout(1,4,10,10));
        choiceButtonPanel.setBounds(64, 640, 896, 100);
        choiceButtonPanel.setBackground(Color.black);
        window.add(choiceButtonPanel);
        
        choice1 = new JButton("Think");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.addActionListener(gm.dialogChoiceHandler);
        choice1.setActionCommand("think");
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton("Inventory");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.addActionListener(gm.dialogChoiceHandler);
        choice2.setActionCommand("inventory");
        choiceButtonPanel.add(choice2);
        
        choice3 = new JButton("Item");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.addActionListener(gm.dialogChoiceHandler);
        choice3.setActionCommand("item");
        choiceButtonPanel.add(choice3);
        
        choice4 = new JButton("Move");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.addActionListener(gm.dialogChoiceHandler);
        choice4.setActionCommand("move");
        choiceButtonPanel.add(choice4);
        
    }
    
     /**********************************************************************************************************************************/
    
     public void addTalkMenu(String ch1, String ch2, String ch3, String ch1Command, String ch2Command, String ch3Command){
        
        if(choiceButtonPanel != null){
            choiceButtonPanel.setVisible(false);
            window.remove(choiceButtonPanel);
        }
        
        choiceButtonPanel = new JPanel(new GridLayout(1,4,10,10));
        choiceButtonPanel.setBounds(64, 640, 896, 100);
        choiceButtonPanel.setBackground(Color.black);
        window.add(choiceButtonPanel);
        
        choice1 = new JButton(ch1);
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(playerInfoFont);
        choice1.addActionListener(gm.dialogChoiceHandler);
        choice1.setActionCommand(ch1Command);
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton(ch2);
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(playerInfoFont);
        choice2.addActionListener(gm.dialogChoiceHandler);
        choice2.setActionCommand(ch2Command);
        choiceButtonPanel.add(choice2);
        
        choice3 = new JButton(ch3);
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(playerInfoFont);
        choice3.addActionListener(gm.dialogChoiceHandler);
        choice3.setActionCommand(ch3Command);
        choiceButtonPanel.add(choice3);
        
        choice4 = new JButton("Nothing");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(playerInfoFont);
        choice4.addActionListener(gm.dialogChoiceHandler);
        choice4.setActionCommand("nothing");
        choiceButtonPanel.add(choice4);
        
    }
     
    /**********************************************************************************************************************************/
     
    public void addMoveMenu(String ch1, String ch2, String ch3, String ch1Command, String ch2Command, String ch3Command){
        
        if(choiceButtonPanel != null){
            choiceButtonPanel.setVisible(false);
            window.remove(choiceButtonPanel);
        }
        
        choiceButtonPanel = new JPanel(new GridLayout(1,4,10,10));
        choiceButtonPanel.setBounds(64, 640, 896, 100);
        choiceButtonPanel.setBackground(Color.black);
        window.add(choiceButtonPanel);
        
        choice1 = new JButton(ch1);
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(playerInfoFont);
        choice1.addActionListener(gm.dialogChoiceHandler);
        choice1.setActionCommand(ch1Command);
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton(ch2);
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(playerInfoFont);
        choice2.addActionListener(gm.dialogChoiceHandler);
        choice2.setActionCommand(ch2Command);
        choiceButtonPanel.add(choice2);
        
        choice3 = new JButton(ch3);
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(playerInfoFont);
        choice3.addActionListener(gm.dialogChoiceHandler);
        choice3.setActionCommand(ch3Command);
        choiceButtonPanel.add(choice3);
        
        choice4 = new JButton("<<<");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(playerInfoFont);
        choice4.addActionListener(gm.dialogChoiceHandler);
        choice4.setActionCommand("nothing");
        choiceButtonPanel.add(choice4);
        
    } 
    
     /**********************************************************************************************************************************/
    
    public void addConfirmMenu(String ch1, String ch2, String ch1Command, String ch2Command){
        
        if(choiceButtonPanel != null){
            choiceButtonPanel.setVisible(false);
            window.remove(choiceButtonPanel);
        }
        
        choiceButtonPanel = new JPanel(new GridLayout(1,2,30,10));
        choiceButtonPanel.setBounds(164, 640, 696, 100);
        choiceButtonPanel.setBackground(Color.black);
        window.add(choiceButtonPanel);
        
        choice1 = new JButton(ch1);
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(playerInfoFont);
        choice1.addActionListener(gm.dialogChoiceHandler);
        choice1.setActionCommand(ch1Command);
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton(ch2);
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(playerInfoFont);
        choice2.addActionListener(gm.dialogChoiceHandler);
        choice2.setActionCommand(ch2Command);
        choiceButtonPanel.add(choice2);
        
        
    } 
    
     /**********************************************************************************************************************************/
    
    public void addSpellMenu(){
        
        choiceButtonPanel.setVisible(false);
        window.remove(choiceButtonPanel);
        
        choiceButtonPanel = new JPanel(new GridLayout(1,4,10,10));
        choiceButtonPanel.setBounds(64, 640, 896, 100);
        choiceButtonPanel.setBackground(Color.black);
        window.add(choiceButtonPanel);
        
        choice1 = new JButton("Fireball");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.addActionListener(gm.combatChoiceHandler);
        choice1.setActionCommand("fireball");
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton("Thunder");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.addActionListener(gm.combatChoiceHandler);
        choice2.setActionCommand("thunder");
        choiceButtonPanel.add(choice2);
        
        choice3 = new JButton("Freeze Bolt");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.addActionListener(gm.combatChoiceHandler);
        choice3.setActionCommand("freeze");
        choiceButtonPanel.add(choice3);
        
        choice4 = new JButton("<<<");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.addActionListener(gm.combatChoiceHandler);
        choice4.setActionCommand("goback");
        choiceButtonPanel.add(choice4);
        
    }
    
     /**********************************************************************************************************************************/
    
    public void addItemMenu(){
        
        choiceButtonPanel.setVisible(false);
        window.remove(choiceButtonPanel);
        
        choiceButtonPanel = new JPanel(new GridLayout(2,5,10,10));
        choiceButtonPanel.setBounds(64, 640, 896, 100);
        choiceButtonPanel.setBackground(Color.black);
        window.add(choiceButtonPanel);
        
        for (int i=0; i<9; i++){
            if(gm.playerInfo.getItemlist()[i] != null){
                choice1 = new JButton(gm.playerInfo.getItemlist()[i].getName());
                choice1.setBackground(Color.black);
                choice1.setForeground(Color.white);
                choice1.setFont(smallerFont);
                choice1.addActionListener(gm.itemChoiceHandler);
                choice1.setActionCommand(gm.playerInfo.getItemlist()[i].getName());
                choiceButtonPanel.add(choice1);
            }
            else {
                choice1 = new JButton("Empty");
                choice1.setBackground(Color.black);
                choice1.setForeground(Color.white);
                choice1.setFont(smallerFont);
                choice1.addActionListener(gm.itemChoiceHandler);
                choice1.setActionCommand("empty");
                choiceButtonPanel.add(choice1);
            }
        }
        
        choice2 = new JButton("<<<");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(smallerFont);
        choice2.addActionListener(gm.combatChoiceHandler);
        choice2.setActionCommand("goback");
        choiceButtonPanel.add(choice2);
        
    }
    
    /**********************************************************************************************************************************/
    
    public void addItemMenuNonFight(){
        
        choiceButtonPanel.setVisible(false);
        window.remove(choiceButtonPanel);
        
        choiceButtonPanel = new JPanel(new GridLayout(2,5,10,10));
        choiceButtonPanel.setBounds(64, 640, 896, 100);
        choiceButtonPanel.setBackground(Color.black);
        window.add(choiceButtonPanel);
        
        for (int i=0; i<9; i++){
            if(gm.playerInfo.getItemlist()[i] != null){
                choice1 = new JButton(gm.playerInfo.getItemlist()[i].getName());
                choice1.setBackground(Color.black);
                choice1.setForeground(Color.white);
                choice1.setFont(smallerFont);
                choice1.addActionListener(gm.itemChoiceHandler);
                choice1.setActionCommand(gm.playerInfo.getItemlist()[i].getName()+"nc");
                choiceButtonPanel.add(choice1);
            }
            else {
                choice1 = new JButton("Empty");
                choice1.setBackground(Color.black);
                choice1.setForeground(Color.white);
                choice1.setFont(smallerFont);
                choice1.addActionListener(gm.itemChoiceHandler);
                choice1.setActionCommand("emptync");
                choiceButtonPanel.add(choice1);
            }
        }
        
        choice2 = new JButton("<<<");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(smallerFont);
        choice2.addActionListener(gm.dialogChoiceHandler);
        choice2.setActionCommand("nothing");
        choiceButtonPanel.add(choice2);
        
    }
    
     /**********************************************************************************************************************************/
    
    public void inventoryScreen(){
        
        
        /* 5x4 inventory for weapons, armor, key items and also stats and level on the side, have to figure out how to go back to current scene*/
        
        bgPanel[8] = new JPanel();
        bgPanel[8].setBounds(110,50,800,500);
        bgPanel[8].setBackground(Color.BLACK);
        bgPanel[8].setLayout(null);
        window.add(bgPanel[8]);
        
        JPanel inventoryPanel = new JPanel(new GridLayout(5,4,0,0));
        inventoryPanel.setBounds(0, 0, 400, 500);
        inventoryPanel.setBackground(Color.blue);
        
        ImageIcon objectIcon;
        JMenuItem menuItem[] = new JMenuItem[2];
        
        
        /* The way these labels get added to the Jpanel makes no sense to me, so this part of the code is a huge mess currently */
        
        j1x1 = new JLabel();
        //j1x1.setBounds(0,0,100,100);
        
        JPopupMenu popMenu = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_brswrd");
        popMenu.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_brdswrd");
        popMenu.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/broadsword.png"));
        j1x1.setIcon(objectIcon);
        
        
        j1x1.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu.show(j1x1, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j1x1);
                
        j2x1 = new JLabel();
        //j3x2.setBounds(0,100,100,100);
        
        JPopupMenu popMenu2 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_lthrarm");
        popMenu2.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_lthrarm");
        popMenu2.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/leather.png"));
        j2x1.setIcon(objectIcon);
        
        j2x1.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu2.show(j2x1, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j2x1);
        
        j3x1 = new JLabel();
        //j3x1.setBounds(0,200,100,100);
        
        JPopupMenu popMenu3 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu3.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu3.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j3x1.setIcon(objectIcon);
        
        j3x1.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu3.show(j3x1, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j3x1);
        
        
        
        j4x1 = new JLabel();
        //j4x1.setBounds(0,300,100,100);
        
        JPopupMenu popMenu4 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu4.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu4.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j4x1.setIcon(objectIcon);
        
        j4x1.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu4.show(j4x1, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j4x1);
        
        j1x2 = new JLabel();
        
        JPopupMenu popMenu5 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu5.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu5.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j1x2.setIcon(objectIcon);
        
        j1x2.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu5.show(j1x2, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j1x2);
        
        j2x2 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu6 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu6.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu6.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j2x2.setIcon(objectIcon);
        
        j2x2.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu6.show(j2x2, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j2x2);
        
        j3x2 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu7 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu7.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu7.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j3x2.setIcon(objectIcon);
        
        j3x2.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu7.show(j3x2, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j3x2);
        
        j4x2 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu8 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu8.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu8.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j4x2.setIcon(objectIcon);
        
        j4x2.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu8.show(j4x2, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j4x2);
        
        
        j1x3 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu9 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu9.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu9.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j1x3.setIcon(objectIcon);
        
        j1x3.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu9.show(j1x3, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j1x3);
        
        
        j2x3 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu10 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu10.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu10.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j2x3.setIcon(objectIcon);
        
        j2x3.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu10.show(j2x3, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j2x3);
        
        j3x3 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu11 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu11.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu11.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j3x3.setIcon(objectIcon);
        
        j3x3.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu11.show(j3x3, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j3x3);
        
        j4x3 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu12 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu12.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu12.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j4x3.setIcon(objectIcon);
        
        j4x3.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu12.show(j4x3, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j4x3);
        
        
        j1x4 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu13 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu13.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu13.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j1x4.setIcon(objectIcon);
        
        j1x4.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu13.show(j1x4, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j1x4);
        
        
        j2x4 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu14 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu14.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu14.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j2x4.setIcon(objectIcon);
        
        j2x4.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu14.show(j2x4, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j2x4);
        
        j3x4 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu15 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu15.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu15.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j3x4.setIcon(objectIcon);
        
        j3x4.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu15.show(j3x4, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j3x4);
        
        
        j4x4 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu16 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu16.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu16.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j4x4.setIcon(objectIcon);
        
        j4x4.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu16.show(j4x4, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j4x4);
        
        j1x5 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu17 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu17.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu17.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j1x5.setIcon(objectIcon);
        
        j1x5.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu17.show(j1x5, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j1x5);
        
        j2x5 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu18 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu18.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu18.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j2x5.setIcon(objectIcon);
        
        j2x5.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu18.show(j2x5, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j2x5);
        
        j3x5 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu19 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu19.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu19.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j3x5.setIcon(objectIcon);
        
        j3x5.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu19.show(j3x5, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j3x5);
        
        j4x5 = new JLabel();
        //j1x2.setBounds(100,0,100,100);
        
        JPopupMenu popMenu20 = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_empty");
        popMenu20.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_empty");
        popMenu20.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty.png"));
        j4x5.setIcon(objectIcon);
        
        j4x5.addMouseListener(new MouseListener(){
        

            @Override
            public void mouseClicked(MouseEvent e){}
            
            @Override
            public void mousePressed(MouseEvent e){
            
                if (SwingUtilities.isRightMouseButton(e)){
                    popMenu20.show(j4x5, e.getX(), e.getY());
                }
            
            }
            
            @Override
            public void mouseReleased(MouseEvent e){}
            
            @Override
            public void mouseEntered(MouseEvent e){}
            
            @Override
            public void mouseExited(MouseEvent e){}
            
            
        });
        
        inventoryPanel.add(j4x5);
        
        
        
        
        
        
        JTextArea statsText = new JTextArea("   \nLevel 1\n"
                + "Hero: You\nATK:50\n");
        statsText.setBounds(500,0,300,500);
        statsText.setBackground(Color.DARK_GRAY);
        statsText.setForeground(Color.WHITE);
        statsText.setEditable(false);
        statsText.setLineWrap(true);
        statsText.setWrapStyleWord(true);
        statsText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        
        
        bgPanel[8].add(inventoryPanel);
        bgPanel[8].add(statsText);
        

        
        
        
        
    }
    

    /**********************************************************************************************************************************/
    
    public void goBack(){
        
        choiceButtonPanel.setVisible(false);
        window.remove(choiceButtonPanel);
        
        choiceButtonPanel = new JPanel(new GridLayout(1,1,180,10));
        choiceButtonPanel.setBounds(64, 640, 896, 100);
        choiceButtonPanel.setBackground(Color.black);
        window.add(choiceButtonPanel);
        
        choice1 = new JButton("Continue");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.addActionListener(gm.combatChoiceHandler);
        choice1.setActionCommand("continue");
        choiceButtonPanel.add(choice1);
        
    }
    
     /**********************************************************************************************************************************/
    
    public void progressForward(){
        
        choiceButtonPanel.setVisible(false);
        window.remove(choiceButtonPanel);
        
        choiceButtonPanel = new JPanel(new GridLayout(1,1,180,10));
        choiceButtonPanel.setBounds(64, 640, 896, 100);
        choiceButtonPanel.setBackground(Color.black);
        window.add(choiceButtonPanel);
        
        choice1 = new JButton("Continue");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.addActionListener(gm.combatChoiceHandler);
        choice1.setActionCommand("advance");
        choiceButtonPanel.add(choice1);
        
    }
    
     /**********************************************************************************************************************************/
    
    public class TitleScreenHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            titleNamePanel.setVisible(false);
            startButtonPanel.setVisible(false);
            
            //window.remove(titleNamePanel);
            //window.remove(startButtonPanel);
            
            createMainField();
        
            generateScreen();
            
            window.setVisible(true);
            
        }
    
    }
    
     /**********************************************************************************************************************************/
    
    public void rememberCurrentScene(){
        
        if (bgPanel[1].isVisible()) currentScene = 1;
        else if (bgPanel[2].isVisible()) currentScene = 2;
        else if (bgPanel[3].isVisible()) currentScene = 3;
        else if (bgPanel[4].isVisible()) currentScene = 4;
        else if (bgPanel[5].isVisible()) currentScene = 5;
        else if (bgPanel[6].isVisible()) currentScene = 6;
        else if (bgPanel[7].isVisible()) currentScene = 7;
        
    }
    
    /**********************************************************************************************************************************/
    
    public void restoreScene(){
        
        if (currentScene == 1) gm.sceneChanger.showScreen1();
        if (currentScene == 2) gm.sceneChanger.showScreen2();
        if (currentScene == 3) gm.sceneChanger.showScreen3();
        if (currentScene == 4) gm.sceneChanger.showScreen4();
        if (currentScene == 5) gm.sceneChanger.showScreen5();
        if (currentScene == 6) gm.sceneChanger.showScreen6();
        if (currentScene == 7) gm.sceneChanger.showScreen7();
        
        
    }
    
    /**********************************************************************************************************************************/
    
  
    
}
