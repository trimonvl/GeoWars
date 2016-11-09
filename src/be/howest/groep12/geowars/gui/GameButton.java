/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author Jonas Lauwers
 */
//TODO extend jbutton and restyle ... nicer to scale and make button layout.
//!!!! should read color stuff from the settings and there we need to have better themeing!!!!!
public class GameButton extends JButton implements Observer {
    
    public GameButton() {
        super();
        initStyle();
    }
    
    //place default styling for the button here.
    private void initStyle() {
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setForeground(Color.white);
        this.setBorder(new BasicBorders.ButtonBorder(Color.RED, Color.RED, Color.RED, Color.RED));
        this.setBorderPainted(false);
        this.addMouseListener(new GameButtonMouseListener(this));      
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //place restyling here when hovering over button
    private class GameButtonMouseListener extends MouseAdapter {
        GameButton caller;
        
        public GameButtonMouseListener(GameButton caller) {
            this.caller = caller;
        }
        
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            caller.setBorderPainted(true);
        }
        
        public void mouseExited(java.awt.event.MouseEvent evt) {
            caller.setBorderPainted(false);
        }
    }
}
