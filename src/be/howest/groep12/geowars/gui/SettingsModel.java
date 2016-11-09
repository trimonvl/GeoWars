/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Jonas Lauwers
 */
//TODO split visual and audio settings in 2 parts..... 
public class SettingsModel extends Observable {
    
    private final String SETTINGSDIR = "data/settings";
    private final String SETTINGSFILE = "settings.txt";
    private final String DEFAULTBACKGROUND = "data/backgrounds/default.png";
    
    // figure out what we'll use on the color slider...
    private Color color;
    private boolean musicOn;
    private boolean sfxOn;
    private int volume;
    private BufferedImage background;
    
    public SettingsModel() {
        musicOn = true;
        sfxOn = true;
        volume = 80;
        color = Color.white;
        try {
            background = ImageIO.read(new File(DEFAULTBACKGROUND));
        }
        catch (IOException e) {
            System.err.println("No image found !!!");
        }
        loadSettings();
    }
    
    public Color getColor() {
        return color;
    }
    
    public boolean getMusicOn() {
        return musicOn;
    }
    
    public boolean getSfxOn() {
        return sfxOn;
    }
    
    public int getVolume() {
        return volume;
    }
    
    public void setColor(Color color) {
        this.color = color;
        this.setChanged();
        this.notifyObservers();
    }
    
    public Image getBackground() {
        return background;
    }
    
    public void setMusicOn(boolean isOn) {
        musicOn = isOn;
    }
    
    public void setSfxOn(boolean isOn) {
        sfxOn = isOn;
    }
    
    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    //TODO we don't like switches ... maybe change into json so we can parse that?
    public void loadSettings() {
        try (Scanner s = new Scanner(new File(SETTINGSDIR, SETTINGSFILE))) {
            while(s.hasNext()) {
                String[] settingLine = s.nextLine().split("=");
                switch(settingLine[0]) {
                    case "color":
                        setColor(new Color(Integer.parseInt(settingLine[1])));
                        break;
                    case "musicOn":
                        setMusicOn(Boolean.parseBoolean(settingLine[1]));
                        break;
                    case "sfxOn":
                        setSfxOn(Boolean.parseBoolean(settingLine[1]));
                        break;
                    case "volume":
                        setVolume(Integer.parseInt(settingLine[1]));
                        break;
                }
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Settings: No settings found, using default.");
            File dir = new File(SETTINGSDIR);
            dir.mkdirs();
        }
    }
    
    //TODO see loadSettings if changed to json then update this :)
    public void saveSettings() {
        try (FileWriter fw = new FileWriter(new File(SETTINGSDIR, SETTINGSFILE))) {
            fw.write(String.format("color=%d\n", getColor().getRGB()));
            fw.write(String.format("musicOn=%b\n", getMusicOn()));
            fw.write(String.format("sfxOn=%b\n", getSfxOn()));
            fw.write(String.format("volume=%d\n", getVolume()));
            fw.flush();
            fw.close();
        }
        catch (IOException e) {
            System.err.println("Settings: oops?");
        }
    }
}
