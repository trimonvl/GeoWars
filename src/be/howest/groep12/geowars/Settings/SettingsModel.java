/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.Settings;

import java.awt.Color;
import java.awt.Image;
import java.util.Observer;

/**
 *
 * @author Jonas Lauwers
 */
//TODO this holds all the settings and should deal with them (proxy pattern?)
//so we only have to give the settingsmodel to anything so it can set whatever it needs to ...
//this doesn't need to know how to set settings but should delegate to the one that does know.
public class SettingsModel {
    
    private final SoundSettings sound;
    private final StyleSettings style;
    //private final InputSettings input;
    private static SettingsModel settings;
    
    private final String SETTINGSDIR = "data/settings";
    
    public static SettingsModel getSettings() {
        if(settings == null ) {
            settings = new SettingsModel();
        }
        return settings;
    }
    
    private SettingsModel() {
        sound = SoundSettings.load(SETTINGSDIR);
        style = StyleSettings.load(SETTINGSDIR);
    }
    
    public Color getBorderColor() {
        return style.getBorderColor();
    }
    
    public Color getTextColor() {
        return style.getTextColor();
    }
    
    public Color getBackgroundColor() {
        return style.getBackgroundColor();
    }
    
    public Image getBackground() {
        return style.getBackground();
    }
    
    public void setBorderColor(Color color) {
        style.setBorderColor(color);
    }
    
    public void setTextColor(Color color) {
        style.setTextColor(color);
    }
    
    public void setBackgroundColor(Color color) {
        style.setBackgroundColor(color);
    }
    
    public void setBackground(String fileName) {
        style.setBackground(fileName);
    }
    
    public boolean getMusicOn() {
        return sound.getMusicOn();
    }
    
    public boolean getSfxOn() {
        return sound.getSfxOn();
    }
    
    public int getMusicVolume() {
        return sound.getMusicVolume();
    }
    
    public int getSfxVolume() {
        return sound.getSfxVolume();
    }
    
    public void setMusicOn(boolean isOn) {
        sound.setMusicOn(isOn);
    }
    
    public void setSfxOn(boolean isOn) {
        sound.setSfxOn(isOn);
    }
    
    public void setMusicVolume(int volume) {
        sound.setMusicVolume(volume);
    }
    
    public void setSfxVolume(int volume) {
        sound.setSfxVolume(volume);
    }
    
    public void addColorObserver(Observer o) {
        style.addObserver(o);
    }
    public void removeColorObserver(Observer o) {
        style.deleteObserver(o);
    }
    
    public void addSoundObserver(Observer o) {
        sound.addObserver(o);
    }
    
    public void removeSoundObserver(Observer o) {
        sound.deleteObserver(o);
    }
}
