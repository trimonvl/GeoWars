/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.view;

import be.howest.groep12.geowars.Settings.SettingsModel;
import be.howest.groep12.geowars.Settings.StyleSettings;
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
    private SettingsModel settings;
    
    public MenuInterface(Container parent, CardLayout layout, SettingsModel settings) {
        this.parent = parent;
        this.layout = layout;
        this.settings = settings;
        settings.addColorObserver(this);
        background = settings.getBackground();
    }

    @Override
    public void update(Observable o, Object arg) {
        StyleSettings setting = (StyleSettings) o;
        this.setForeground(setting.getTextColor());
        this.setBackground(setting.getBackgroundColor());
        this.background = setting.getBackground();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }
}
