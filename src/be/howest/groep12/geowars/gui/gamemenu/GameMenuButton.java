/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.gui.gamemenu;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author Jonas Lauwers
 */
//TODO extend jbutton and restyle ... nicer to scale and make button layout.
//!!!! should read color stuff from the settings and there we need to have better themeing!!!!!
public class GameMenuButton extends JButton {
    
    public GameMenuButton() {
        super();
        initStyle();
    }
    
    //place default styling for the button here.
    private void initStyle() {
        this.setBackground(Color.blue);
        this.setForeground(Color.white);
        this.setBorder(new BasicBorders.ButtonBorder(Color.CYAN, Color.CYAN, Color.BLUE, Color.BLUE));
        this.setBorderPainted(false);
        this.addMouseListener(new GameButtonMouseListener(this));      
    }
    
    
    //place restyling here when hovering over button
    private class GameButtonMouseListener extends MouseAdapter {
        GameMenuButton caller;
        
        public GameButtonMouseListener(GameMenuButton caller) {
            this.caller = caller;
        }
        
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            caller.setBackground(Color.red);
            caller.setBorderPainted(true);
        }
        
        public void mouseExited(java.awt.event.MouseEvent evt) {
            caller.setBackground(Color.blue);
            caller.setBorderPainted(false);
        }
    }
}
