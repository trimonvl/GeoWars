/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.view;

import be.howest.groep12.geowars.Settings.SettingsModel;
import be.howest.groep12.geowars.Settings.StyleSettings;
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
    
    SettingsModel settings = SettingsModel.getSettings();
    
    public GameButton() {
        super();
        settings.addColorObserver(this);
        initStyle();
    }
    
    //place default styling for the button here.
    private void initStyle() {
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setForeground(settings.getTextColor());
        Color border = settings.getBorderColor();
        this.setBorder(new BasicBorders.ButtonBorder(border, border, border, border));
        this.setBorderPainted(false);
        this.addMouseListener(new GameButtonMouseListener(this));      
    }

    @Override
    public void update(Observable o, Object arg) {
        StyleSettings settings = (StyleSettings) o;
        this.setForeground(settings.getTextColor());
        Color border = settings.getBorderColor();
        this.setBorder(new BasicBorders.ButtonBorder(border, border, border, border));
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
