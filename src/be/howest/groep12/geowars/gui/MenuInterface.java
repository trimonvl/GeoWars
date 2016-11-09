/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Jonas Lauwers
 */
public abstract class MenuInterface extends javax.swing.JPanel implements Observer {
    
    protected Container parent;
    protected CardLayout layout;
    
    public MenuInterface(Container parent, CardLayout layout, Settings settings) {
        this.parent = parent;
        this.layout = layout;
        settings.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Settings setting = (Settings) o;
        this.setBackground(setting.getColor());
    }
    
    
    
    
}
