/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.gui;

import be.howest.groep12.geowars.gui.gamemenu.CampaignMenu;
import be.howest.groep12.geowars.gui.gamemenu.MultiPlayerMenu;
import be.howest.groep12.geowars.gui.gamemenu.SettingsMenu;
import be.howest.groep12.geowars.gui.gamemenu.SinglePlayerMenu;
import be.howest.groep12.geowars.gui.gamemenu.TempGameScreen;
import be.howest.groep12.geowars.gui.gamemenu.TitleMenu;
import java.awt.*;
import javax.swing.*;
import be.howest.groep12.geowars.gui.gamemenu.tempPlayScreen;

/**
 *
 * @author Jonas Lauwers
 */
//INFO: Creates main JFrame and uses it's contentPane with a cardLayout
//      all the panes added to the cardLayout are premade Panels which are
//      initialized with the contentpane and layout so we can make them call
//      the layout to change it's pane.
//      TODO: we can make a class that extends JPanel with default settings
//              for colors and whatever and that contains the parent and layout
//              and extend all the different panels from that class ... 
//              easier for theming and not having to worry about implementing 
//              the contentpane and cardlayout or the methods of it.
//      This way we can configure each view completely seperated.
//      Just need to foresee that every panel is build based on the settings of
//      the contentpane.... and added in the preparingInteface method.
public class GameInterface {
    
    private Container contentPane;
    private CardLayout layout;
    
    public GameInterface() {
        prepareInterface();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameInterface gameInterface = new GameInterface();
    }
    
    private void prepareInterface() {
        //Init main frame
        JFrame root = new JFrame("Geowars");
        root.setSize(820,600);
        root.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        root.setAlwaysOnTop(true);
        root.setResizable(false);
        root.setVisible(true);
        
        //set the contentpane and it's layout
        contentPane = root.getContentPane();
        layout = new CardLayout();
        contentPane.setLayout(layout);
        
        //add all the views we will have in the game.
        contentPane.add(new TitleMenu(contentPane, layout),"TitleMenu");
        contentPane.add(new SinglePlayerMenu(contentPane, layout), "SinglePlayerMenu");
        contentPane.add(new MultiPlayerMenu(contentPane, layout), "MultiPlayerMenu");
        contentPane.add(new CampaignMenu(contentPane, layout), "CampaignMenu");
        contentPane.add(new SettingsMenu(contentPane, layout), "SettingsMenu");
        //contentPane.add(new TempGameScreen(contentPane, layout), "Game");
        contentPane.add(new tempPlayScreen(), "Game");
        //display default view.
        layout.show(contentPane, "LoginMenu");
        contentPane.setFocusable(true);
        contentPane.setVisible(true);
    }
}
