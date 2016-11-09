/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.main;

import be.howest.groep12.geowars.gui.GameInterface;
import be.howest.groep12.geowars.gui.SettingsModel;

/**
 *
 * @author Jonas Lauwers
 */
public class GeowarsLoader {
    
    private GameInterface mainFrame;
    private SettingsModel settings;
    private static GeowarsLoader game;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new GeowarsLoader();
    }
    
    public GeowarsLoader() {
        settings = new SettingsModel();
        mainFrame = new GameInterface(settings);
    }
    
}
