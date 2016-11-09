/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Jonas Lauwers
 */
public class MenuInterface extends javax.swing.JPanel implements Observer {
    
    protected Container parent;
    protected CardLayout layout;
    protected Image background;
    
    public MenuInterface(Container parent, CardLayout layout, SettingsModel settings) {
        this.parent = parent;
        this.layout = layout;
        settings.addObserver(this);
        background = settings.getBackground();
    }

    @Override
    public void update(Observable o, Object arg) {
        SettingsModel setting = (SettingsModel) o;
        this.setBackground(setting.getColor());
        this.background = setting.getBackground();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }
}
