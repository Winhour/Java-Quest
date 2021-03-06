/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import items.GameItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
    public JPanel menuCogPanel;
    public JButton choice1, choice2, choice3, choice4;
    public JPanel bgPanel[] = new JPanel[30];
    public JLabel bgLabel[] = new JLabel[30];
    public JTextArea statsText;
    
    /* FONTS */
    
    Font titleFont = new Font("Times New Roman",Font.PLAIN, 100);
    Font normalFont = new Font("Book Antiqua", Font.PLAIN, 36);
    Font playerInfoFont = new Font("Book Antiqua", Font.PLAIN, 24);
    Font smallerFont = new Font("Book Antiqua", Font.PLAIN, 18);
    
    public int previousScene = 0;
    public int currentScene = 1;
    public int nextScene = 0;
    
    /* FLAGS */
    
    boolean goblinFlag = true;
    boolean skeleFlag = true;
    boolean bearFlag = true;
    boolean zombieFlag = true;
    boolean demonFlag = true;
    boolean bearpeltFlag = false;
    boolean moonoreFlag = false;
    boolean combatFlag = false;
    boolean barrelgoldFlag = true;                  
    boolean goldkeyFlag = false;
    boolean blueleavesFlag = false; 
    
    public JLabel j1x1, j1x2, j1x3, j1x4;
    public JLabel j2x1, j2x2, j2x3, j2x4;
    public JLabel j3x1, j3x2, j3x3, j3x4;
    public JLabel j4x1, j4x2, j4x3, j4x4;
    public JLabel j1x5, j2x5, j3x5, j4x5;
    
    public JPanel gameOverPanel;
    public JLabel gameOverLabel;
    public JTextArea deathText = new JTextArea();
    public JPanel continueButtonPanel;
    public JButton continueButton;
    
    GameOverHandler goHandler = new GameOverHandler();
    
    //CustomCursor cCursor;
    
    
    
    
    public UI(GameManager gm){
        
        this.gm = gm;
        
        createTitleScreen();

        //createMainField();
        
        //generateScreen();
        
        window.setVisible(true);
        
    }
    
     /**********************************************************************************************************************************/
    
    public void createTitleScreen(){                                                /* Title screen for the game */
        
        window = new JFrame();
        window.setSize(1024,808);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/sword_shield_icon.jpg")));

        
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
    
    public void createMainField(){                                                  /* Create the text window */
        
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
    
    public void createBackground(int bgNum, String bgFileName){                     /* Create the background for a scene */
        
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
    
    public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName){       /* Create an object to add to a scene */
        
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx,objy,objWidth,objHeight);
        
        ImageIcon objectIcon = new ImageIcon(getClass().getResource(objFileName));
        objectLabel.setIcon(objectIcon);
        
        bgPanel[bgNum].add(objectLabel);
        
    }
    
     /**********************************************************************************************************************************/
    
    public void createObjectInteractable(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName,
            String choice1Name, String choice2Name, String choice3Name, String choice1Command, String choice2Command, String choice3Command){
        
        /* Create an interactable object to add to a scene */
        
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
    
    public void generateScreen(){                               /* Create the scenes */
        
        //SCENE 1   Outskirts
        
        createBackground(1, "/res/village.jpg");
        createObjectInteractable(1, 40,80,400,400,"/res/priest.png", "Talk", "Interact", "Look", "talk_priest", "interact_priest", "look_priest");
        createObjectInteractable(1, 480,80,400,400,"/res/peasant.png", "Talk", "Interact", "Look", "talk_peasant", "interact_peasant","look_peasant");
        bgPanel[1].add(bgLabel[1]);
        
        //SCENE 2   Skeleton
        
        createBackground(2, "/res/dungeon2.jpg");
        createObject(2, 240,60,400,400,"/res/skeletons.png");
        bgPanel[2].add(bgLabel[2]);
        
         //SCENE 3  Goblin
        
        createBackground(3, "/res/dungeon.jpg");
        createObjectInteractable(3,170,310,100,100,"/res/blank.png", "Examine", "", "", "examine_gsword", "", "");
        createObjectInteractable(3,300,200,100,100,"/res/blank.png", "Examine", "", "", "examine_cultist", "", "");
        createObjectInteractable(3,470,280,100,100,"/res/blank.png", "Examine", "", "", "examine_gbarrel", "", "");
        createObject(3, 240,60,400,400,"/res/goblin.png");
        bgPanel[3].add(bgLabel[3]);
        
        //SCENE 4   Town
        
        createBackground(4, "/res/town.jpg");
        bgPanel[4].add(bgLabel[4]);
        createObjectInteractable(4,30,180,100,100,"/res/blank.png", "Examine", "Interact", "", "examine_thall", "move_twnhall", "");
        createObjectInteractable(4,330,280,100,100,"/res/blank.png", "Examine", "Interact", "", "examine_smiths", "move_smith", "");
        createObjectInteractable(4,675,390,50,50,"/res/blank.png", "Examine", "Interact", "", "examine_barrels", "interact_barrels", "");
        
        
        //SCENE 5   Shop
        
        createBackground(5, "/res/shop.jpg");
        createObjectInteractable(5,40,130,200,400,"/res/merchant.png", "Talk", "Interact", "Look", "talk_merch", "interact_merch", "look_merch");
        createObjectInteractable(5,280,180,100,100,"/res/blank.png", "Examine", "Interact", "", "examine_shelf", "interact_shelf", "");
        bgPanel[5].add(bgLabel[5]);
        
        //SCENE 6   Smith
        
        createBackground(6, "/res/smith.jpg");
        createObjectInteractable(6,320,70,400,400,"/res/blacksmith.png", "Talk", "Interact", "Look", "talk_smith", "interact_smith", "look_smith");
        bgPanel[6].add(bgLabel[6]);
        
        
        //SCENE 7   Town Hall
        
        createBackground(7, "/res/hall.jpg");
        createObjectInteractable(7,240,70,400,400,"/res/mayor.png", "Talk", "Interact", "Look", "talk_mayor", "interact_mayor", "look_mayor");
        bgPanel[7].add(bgLabel[7]);
        
        
        //SCENE 8   Inventory
        
        inventoryScreen();
        statsText.setVisible(false);
        
        //SCENE 9   Dungeon Entrance
        
        createBackground(9, "/res/dungeon_entrance.jpg");
        createObjectInteractable(9,20,70,400,400,"/res/hunter.png", "Talk", "Interact", "Look", "talk_hunter", "interact_hunter", "look_hunter");
        bgPanel[9].add(bgLabel[9]);
        
        //SCENE 10  Woods
        
        createBackground(10, "/res/woods.jpg");
        createObject(10, 210,30,463,500,"/res/bear.png");
        bgPanel[10].add(bgLabel[10]);
        
        //SCENE 11  Dungeon Hallway
        
        createBackground(11, "/res/dungeon_hallway.jpg");
        createObjectInteractable(11, 230,180,300,300,"/res/chest.png","Open","Examine","","open_chest","examine_chest","nothing");
        bgPanel[11].add(bgLabel[11]);
        
        //SCENE 12  Dungeon Sideroom
        
        createBackground(12, "/res/side_room.jpg");
        createObjectInteractable(12,580,310,80,80,"/res/blank.png", "Examine", "Interact", "", "examine_secsid", "interact_secsid", "nothing");
        bgPanel[12].add(bgLabel[12]);
        
        //SCENE 13  Dungeon Chapel
        
        createBackground(13, "/res/chapel.jpg");
        createObjectInteractable(13,180,30,400,510,"/res/dark_knight.png", "Talk", "Interact", "Look", "talk_dknight", "interact_dknight", "look_dknight");
        bgPanel[13].add(bgLabel[13]);

        //SCENE 14  Dungeon Mine
        
        createBackground(14, "/res/mine.jpg");
        createObjectInteractable(14, 520,270,150,100,"/res/ore.png","Grab","Examine","","grab_ore","examine_ore","");
        bgPanel[14].add(bgLabel[14]);
        
        //SCENE 15  Prison
        
        createBackground(15, "/res/prison.jpg");
        createObject(15, 240,60,400,400,"/res/zombie.png");
        bgPanel[15].add(bgLabel[15]);
        
        
        //SCENE 16  Armory
        
        createBackground(16, "/res/armory.jpg");
        createObjectInteractable(16, 500,210,100,200,"/res/blank.png","Grab","Examine","","grab_karmor","examine_karmor","");
        createObjectInteractable(16, 50,210,200,120,"/res/blank.png","Examine","Interact","","examine_desk","interact_desk","");
        bgPanel[16].add(bgLabel[16]);
        
        
        //SCENE 17 Desk
        
        createBackground(17, "/res/desk.jpg");
        createObjectInteractable(17, 660,210,100,65,"/res/key_object.png","Grab","Examine","","grab_key","examine_key","");
        createObjectInteractable(17, 320,210,200,100,"/res/blank.png","Examine","","","examine_book","","");
        createObjectInteractable(17, 50,100,100,100,"/res/blank.png","Examine","","","examine_letter","","");
        createObjectInteractable(17, 50,210,100,100,"/res/blank.png","Examine","","","examine_stack","","");
        bgPanel[17].add(bgLabel[17]);
        
        //SCENE 18  Hub
        
        createBackground(18, "/res/hub.jpg");
        bgPanel[18].add(bgLabel[18]);
        
        
        //SCENE 19  Treasure Room
        
        createBackground(19, "/res/treasure_room.jpg");
        createObjectInteractable(19, 660,230,100,100,"/res/leaves_object.png","Grab","Examine","","grab_leaves","examine_leaves","");
        createObjectInteractable(19, 10,180,100,100,"/res/blank.png","Grab","Examine","","grab_gold","examine_gold","");
        bgPanel[19].add(bgLabel[19]);
        
        
        //SCENE 20 Boss Room
        
        createBackground(20, "/res/boss.jpg");
        createObject(20, 240,60,400,400,"/res/lich.png");
        bgPanel[20].add(bgLabel[20]);
        
        
        //SCENE 21 Map
        
        createBackground(21, "/res/map_paint.png");
        bgPanel[21].add(bgLabel[21]);
        
        
        
    }
    
     /**********************************************************************************************************************************/
    
    public void addPlayerInfo(){                            /* Add/Update the player information bar */
        
        if(playerInfoPanel != null){
            playerInfoPanel.setVisible(false);
            window.remove(playerInfoPanel);
        }
        
        playerInfoPanel = new JPanel();
        playerInfoPanel.setBounds(20,5,940,50);
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
        wpnLabel.setText(gm.playerInfo.getWeapon().getName() + "   ");
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
        armLabel.setText(gm.playerInfo.getArmor().getName() + "   ");
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
        
        addMenuCog();
        
    }
    
     /**********************************************************************************************************************************/
    
    public void addMenuCog(){                                           /* Menu cog in the right top corner */
        
        if(menuCogPanel != null){
            menuCogPanel.setVisible(false);
            window.remove(menuCogPanel);
        }
        
        menuCogPanel = new JPanel();
        menuCogPanel.setBounds(960,5,40,50);
        menuCogPanel.setBackground(Color.black);
        window.add(menuCogPanel);
        
        
        
        JLabel menu_cog = new JLabel();
        menu_cog.setBounds(10,10,40,40);
        ImageIcon menuIcon = new ImageIcon(getClass().getResource("/res/cog.png"));
        menu_cog.setIcon(menuIcon);
        menuCogPanel.add(menu_cog);
        menu_cog.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
                if (!combatFlag){   /* Check if player is in combat, can't save in combat */
                    int response = JOptionPane.showConfirmDialog(window, "Do you want to save and quit the game? (NOTE: Save doesn't work yet)", "Java Quest", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION){

                        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
                    } else  {
                        //System.out.println("nothing");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(window, "Can't save right now!", "Java Quest", JOptionPane.WARNING_MESSAGE);
                }
                
                
            }  
        }); 
 
    }
    
    
    
     /**********************************************************************************************************************************/
    
    
    public void addFightMenu(){                                             /* Add Fight Menu */
        
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
    
    
    public void addInteractMenu(){                                                  /* Add Interaction Menu */
        
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
         
         /* Add Talk Menu */
        
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
        
        /* Add Move Menu */
        
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
        
        /* Add Confirm Menu */
        
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
        
        /* Add Spell Menu */
        
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
        
        /* Add Item Menu */
        
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
        
        /* Add Item Menu outside of combat */
        
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
    
    
    public void addSmithBuyMenu(){
        
        /* Add Smith's Shop Menu */
        
        choiceButtonPanel.setVisible(false);
        window.remove(choiceButtonPanel);
        
        choiceButtonPanel = new JPanel(new GridLayout(1,4,10,10));
        choiceButtonPanel.setBounds(64, 640, 896, 100);
        choiceButtonPanel.setBackground(Color.black);
        window.add(choiceButtonPanel);
        
        choice1 = new JButton("War Axe");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(playerInfoFont);
        choice1.addActionListener(gm.dialogChoiceHandler);
        choice1.setActionCommand("buy_axe");
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton("Soldier Armor");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(playerInfoFont);
        choice2.addActionListener(gm.dialogChoiceHandler);
        choice2.setActionCommand("buy_sarmor");
        choiceButtonPanel.add(choice2);
        
        choice3 = new JButton("Strength Amulet");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(playerInfoFont);
        choice3.addActionListener(gm.dialogChoiceHandler);
        choice3.setActionCommand("buy_amulet");
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
    
    public void inventoryScreen(){
        
        /* Create an inventory screen */

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
        /* Will fix it at some point to just have one method for all of these and just use it in a loop */
        
        j1x1 = new JLabel();
        //j1x1.setBounds(0,0,100,100);
        
        JPopupMenu popMenu = new JPopupMenu();
        
        menuItem[0] = new JMenuItem("Equip");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("equip_brdswrd");
        popMenu.add(menuItem[0]);
        
        menuItem[1] = new JMenuItem("Examine");
        menuItem[1].addActionListener(gm.weaponChoiceHandler);
        menuItem[1].setActionCommand("examine_brdswrd");
        popMenu.add(menuItem[1]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/broadsword.png"));
        j1x1.setIcon(objectIcon);
        
        //MouseListener ml;
        
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
        
        menuItem[0] = new JMenuItem("Examine");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("examine_empty");
        popMenu3.add(menuItem[0]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty2.png"));
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
        
        menuItem[0] = new JMenuItem("Examine");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("examine_empty");
        popMenu4.add(menuItem[0]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty2.png"));
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
        
        menuItem[0] = new JMenuItem("Examine");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("examine_empty");
        popMenu7.add(menuItem[0]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty2.png"));
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
        
        menuItem[0] = new JMenuItem("Examine");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("examine_empty");
        popMenu8.add(menuItem[0]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty2.png"));
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
        
        menuItem[0] = new JMenuItem("Examine");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("examine_empty");
        popMenu11.add(menuItem[0]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty2.png"));
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
        
        menuItem[0] = new JMenuItem("Examine");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("examine_empty");
        popMenu12.add(menuItem[0]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty2.png"));
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
        
        menuItem[0] = new JMenuItem("Examine");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("examine_empty");
        popMenu15.add(menuItem[0]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty2.png"));
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
        
        menuItem[0] = new JMenuItem("Examine");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("examine_empty");
        popMenu16.add(menuItem[0]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty2.png"));
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
        
        menuItem[0] = new JMenuItem("Examine");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("examine_empty");
        popMenu19.add(menuItem[0]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty2.png"));
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
        
        menuItem[0] = new JMenuItem("Examine");
        menuItem[0].addActionListener(gm.weaponChoiceHandler);
        menuItem[0].setActionCommand("examine_empty");
        popMenu20.add(menuItem[0]);
        
        objectIcon = new ImageIcon(getClass().getResource("/res/empty2.png"));
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
        
        
        
        
        
        
        bgPanel[8].add(inventoryPanel);
        makeStatsText();
        

        
    }
    

    /**********************************************************************************************************************************/
    
    public void makeStatsText(){
        
        /* Create stats panel (part of inventory screen) */
        
        
        if(statsText != null){
            statsText.setVisible(false);
            bgPanel[8].remove(statsText);
            window.remove(statsText);
        }
        
        statsText = new JTextArea("   \nClass: Adventurer\n"
                + "Level: " + gm.playerInfo.getLevel() + "\n\n" + "ATK: " + gm.playerInfo.getModifiedATK() + " (" + gm.playerInfo.getATK()+ ")\n" +
                "DEF: " + gm.playerInfo.getModfifiedDEF() + " (" + gm.playerInfo.getDEF()+ ")\n" + 
                "MAG: " + gm.playerInfo.getMAG() + "\n" + "SPD: " + gm.playerInfo.getSPD() + "\n");
        statsText.setBounds(500,0,300,500);
        statsText.setBackground(Color.DARK_GRAY);
        statsText.setForeground(Color.WHITE);
        statsText.setEditable(false);
        statsText.setLineWrap(true);
        statsText.setWrapStyleWord(true);
        statsText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        
        bgPanel[8].add(statsText);
        
    }
    
    /**********************************************************************************************************************************/
    
    public void goBack(){
        
        /* Outdated at the moment */
        
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
        
        /* Outdated at the moment */
        
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
    
    public void gameOverScreen(){                                       /* Game Over screen, appears when players health <= 0 */
        
        playerInfoPanel.setVisible(false);
        window.remove(playerInfoPanel);
        choiceButtonPanel.setVisible(false);
        window.remove(choiceButtonPanel);
        messageText.setVisible(false);
        window.remove(messageText);
        menuCogPanel.setVisible(false);
        window.remove(menuCogPanel);
        
        for (int i=1;i<22;i++){
            bgPanel[i].setVisible(false);
            window.remove(bgPanel[i]);
        }
        
        gameOverPanel = new JPanel();
        gameOverPanel.setBounds(128,128,768,192);
        gameOverPanel.setBackground(Color.black);
        gameOverLabel = new JLabel("GAME OVER");
        gameOverLabel.setForeground(Color.red);
        gameOverLabel.setFont(titleFont);
        
        deathText = new JTextArea("");
        deathText.setBounds(150,350,724,80);
        deathText.setBackground(Color.BLACK);
        deathText.setForeground(Color.WHITE);
        deathText.setEditable(false);
        deathText.setLineWrap(true);
        deathText.setWrapStyleWord(true);
        deathText.setFont(new Font("Book Antiqua", Font.PLAIN, 32));
        
        continueButtonPanel = new JPanel();
        continueButtonPanel.setBounds(360, 512, 280, 100);
        continueButtonPanel.setBackground(Color.black);
        continueButtonPanel.setForeground(Color.black);
        
        continueButton = new JButton("CONTINUE");
        continueButton.setBackground(Color.black);
        continueButton.setForeground(Color.white);
        continueButton.setFont(new Font("Book Antiqua", Font.PLAIN, 44));
        continueButton.setFocusable(false);
        continueButton.addActionListener(goHandler);
        
        gameOverPanel.add(gameOverLabel);
        continueButtonPanel.add(continueButton);
        window.add(continueButtonPanel);
        window.add(gameOverPanel);
        window.add(deathText);
        
        
        
    }

     /**********************************************************************************************************************************/
    
    public void backTitleScreen(){                              /* Go back to title screen */
        
        gameOverPanel.setVisible(false);
        window.remove(gameOverPanel);
        continueButtonPanel.setVisible(false);
        window.remove(continueButtonPanel);
        deathText.setVisible(false);
        window.remove(deathText);
        
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
    
    public class TitleScreenHandler implements ActionListener{
        
        /* Get to the game from the title screen */

        @Override
        public void actionPerformed(ActionEvent e) {
            
            titleNamePanel.setVisible(false);
            startButtonPanel.setVisible(false);
            
            //window.remove(titleNamePanel);
            //window.remove(startButtonPanel);
            
            createMainField();
        
            generateScreen();
            
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
            
            window.setVisible(true);
            
            gm.music.setFile(System.getProperty("user.dir") + "/src/res/sound/medieval_loop_one.wav");
            gm.music.play_low();
            gm.music.loop();
            
        }
    
    }
    
     /**********************************************************************************************************************************/
    
    public class GameOverHandler implements ActionListener{
        
        /* Get to the title screen from game over and restore some data back to starting point */

        @Override
        public void actionPerformed(ActionEvent e) {
            
            gm.playerInfo = gm.context.getBean("playerInfo", PlayerInfo.class);
            gm.playerInfo.setLevel(1);
            gm.playerInfo.setMaxhealth(100);
            gm.playerInfo.setMaxmana(20);
            gm.playerInfo.setATK(5);
            gm.playerInfo.setDEF(1);
            gm.playerInfo.setMAG(0);
            gm.playerInfo.setSPD(5);
            gm.playerInfo.setExp(0);
            gm.playerInfo.setNextlevelexp(150);
            gm.playerInfo.setCash(90);
            gm.playerInfo.setModifiedATK(8);
            gm.playerInfo.setModfifiedDEF(3);
            
            gm.playerInfo.setHealth(gm.playerInfo.getMaxhealth());
            gm.playerInfo.setMana(gm.playerInfo.getMaxmana());
            
            /*playerInfo.health = 100
            playerInfo.mana = 20
            playerInfo.level = 1
            playerInfo.maxhealth = 100
            playerInfo.exp = 0
            playerInfo.nextlevelexp = 150
            playerInfo.cash = 90
            playerInfo.ATK = 5
            playerInfo.DEF = 1
            playerInfo.MAG = 0
            playerInfo.SPD = 5
            playerInfo.modifiedATK = 8
            playerInfo.modfifiedDEF = 3
            playerInfo.maxmana = 20*/

            gm.itemlist = new GameItem[9];
            gm.itemlist[0] = gm.potion;
            gm.itemlist[1] = gm.potion2;
            gm.itemlist[2] = gm.potion3;
            gm.itemlist[3] = gm.elixir;
            gm.itemlist[4] = null;
            gm.itemlist[5] = null;
            gm.itemlist[6] = null;
            gm.itemlist[7] = null;
            gm.itemlist[8] = null;
            gm.playerInfo.setItemlist(gm.itemlist);
            
            goblinFlag = true;
            skeleFlag = true;
            bearFlag = true;
            zombieFlag = true;
            demonFlag = true;
            bearpeltFlag = false;
            moonoreFlag = false;
            combatFlag = false;
            barrelgoldFlag = true;
            goldkeyFlag = false;
            blueleavesFlag = false;
            
            currentScene = 1;
            
            backTitleScreen();
            
        }
    
    }
    
    
    /**********************************************************************************************************************************/
    
    public void rememberCurrentScene(){
        
        /* Remember the current scene */
        
        if (bgPanel[1].isVisible()) currentScene = 1;
        else if (bgPanel[2].isVisible()) currentScene = 2;
        else if (bgPanel[3].isVisible()) currentScene = 3;
        else if (bgPanel[4].isVisible()) currentScene = 4;
        else if (bgPanel[5].isVisible()) currentScene = 5;
        else if (bgPanel[6].isVisible()) currentScene = 6;
        else if (bgPanel[7].isVisible()) currentScene = 7;
        else if (bgPanel[9].isVisible()) currentScene = 9;
        else if (bgPanel[10].isVisible()) currentScene = 10;
        else if (bgPanel[11].isVisible()) currentScene = 11;
        else if (bgPanel[12].isVisible()) currentScene = 12;
        else if (bgPanel[13].isVisible()) currentScene = 13;
        else if (bgPanel[14].isVisible()) currentScene = 14;
        else if (bgPanel[15].isVisible()) currentScene = 15;
        else if (bgPanel[16].isVisible()) currentScene = 16;
        else if (bgPanel[17].isVisible()) currentScene = 17;
        else if (bgPanel[18].isVisible()) currentScene = 18;
        else if (bgPanel[19].isVisible()) currentScene = 19;
        else if (bgPanel[20].isVisible()) currentScene = 20;
        else if (bgPanel[21].isVisible()) currentScene = 21;
        
        
        
    }
    
    /**********************************************************************************************************************************/
    
    public void restoreScene(){
        
        /* Restore the saved scene */
        
        if (currentScene == 1) gm.sceneChanger.showScreen1();
        if (currentScene == 2) gm.sceneChanger.showScreen2();
        if (currentScene == 3) gm.sceneChanger.showScreen3();
        if (currentScene == 4) gm.sceneChanger.showScreen4();
        if (currentScene == 5) gm.sceneChanger.showScreen5();
        if (currentScene == 6) gm.sceneChanger.showScreen6();
        if (currentScene == 7) gm.sceneChanger.showScreen7();
        if (currentScene == 9) gm.sceneChanger.showScreen9();
        if (currentScene == 10) gm.sceneChanger.showScreen10();
        if (currentScene == 11) gm.sceneChanger.showScreen11();
        if (currentScene == 12) gm.sceneChanger.showScreen12();
        if (currentScene == 13) gm.sceneChanger.showScreen13();
        if (currentScene == 14) gm.sceneChanger.showScreen14();
        if (currentScene == 15) gm.sceneChanger.showScreen15();
        if (currentScene == 16) gm.sceneChanger.showScreen16();
        if (currentScene == 17) gm.sceneChanger.showScreen17();
        if (currentScene == 18) gm.sceneChanger.showScreen18();
        if (currentScene == 19) gm.sceneChanger.showScreen19();
        if (currentScene == 20) gm.sceneChanger.showScreen20();
        if (currentScene == 21) gm.sceneChanger.showScreen21();
        
        
    }
    
    /**********************************************************************************************************************************/
    
  
    
}
