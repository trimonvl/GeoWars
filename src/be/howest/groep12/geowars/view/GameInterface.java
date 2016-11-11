/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.view;

import be.howest.groep12.geowars.Settings.SettingsModel;
import be.howest.groep12.geowars.view.menu.CampaignMenu;
import be.howest.groep12.geowars.view.menu.MultiPlayerMenu;
import be.howest.groep12.geowars.view.menu.SettingsMenu;
import be.howest.groep12.geowars.view.menu.SinglePlayerMenu;
import be.howest.groep12.geowars.view.menu.TitleMenu;
import be.howest.groep12.geowars.view.game.GamePanel;
import java.awt.*;
import javax.swing.*;

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
    
    private SettingsModel settings;
    
    public GameInterface(SettingsModel settings) {
        this.settings = settings;
        prepareInterface();
    }
    
    private void prepareInterface() {
        //Init main frame
        JFrame root = new JFrame("Geowars");
        root.setSize(820,600);
        root.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        root.setAlwaysOnTop(true);
        root.setResizable(false);
        root.setBounds(root.getBounds());
        root.setVisible(true);
        
        //set the contentpane and it's layout
        Container contentPane = root.getContentPane();
        CardLayout layout = new CardLayout();
        contentPane.setLayout(layout);
        
        //add all the views we will have in the game
        contentPane.add(new GamePanel(settings), "game");
        contentPane.add(new TitleMenu(contentPane, layout, settings),"TitleMenu");
        contentPane.add(new SinglePlayerMenu(contentPane, layout, settings), "SinglePlayerMenu");
        contentPane.add(new MultiPlayerMenu(contentPane, layout, settings), "MultiPlayerMenu");
        contentPane.add(new CampaignMenu(contentPane, layout, settings), "CampaignMenu");
        contentPane.add(new SettingsMenu(contentPane, layout, settings), "SettingsMenu");
        
        //display default view.
        layout.show(contentPane, "TitleMenu");
        root.pack();
        contentPane.setVisible(true);
        
    }
}
