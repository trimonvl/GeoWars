/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.gui;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Jonas Lauwers
 */
//TODO split visual and audio settings in 2 parts or create 2 observer ..... 
public class SettingsModel extends Observable implements  SoundObservable, ColorObservable {
    
    private final String DATADIR = "data/";
    private final String SETTINGSDIR = DATADIR+"settings/";
    private final String SETTINGSFILE = SETTINGSDIR+"settings.txt";
    private final String BACKGROUNDDIR = DATADIR+"backgrounds/";
    //CHECK: are default finals needed?
    private final String DEFAULTBACKGROUND = "default.jpg";
    private final int DEFAULTVOLUME = 80;
    private final Color DEFAULTTEXTCOLOR = Color.WHITE;
    private final Color DEFAULTBORDERCOLOR = Color.RED;
    private final Color DEFAULTBACKGROUNDCOLOR = Color.DARK_GRAY;
   
    private final List<Observer> soundObservers;
    private final List<Observer> colorObservers;
    
    private boolean musicOn;
    private boolean sfxOn;
    private int musicVolume;
    private int sfxVolume;
    private Color borderColor;
    private Color textColor;
    private Color backgroundColor;
    private Image background;
    private String backgroundFileName;
    
    public SettingsModel() {
        soundObservers = new ArrayList<>();
        colorObservers = new ArrayList<>();
        if(!loadSettings()) {
            musicOn = true;
            sfxOn = true;
            musicVolume = DEFAULTVOLUME;
            sfxVolume = DEFAULTVOLUME;
            borderColor = DEFAULTBORDERCOLOR;
            textColor = DEFAULTTEXTCOLOR;
            backgroundColor = DEFAULTBACKGROUNDCOLOR;
            backgroundFileName = DEFAULTBACKGROUND;
            background = loadImage(DEFAULTBACKGROUND);
        }
    }
    
    private Image loadImage(String imageName) {
        Image load = null;
        try {
            load = ImageIO.read(new File(BACKGROUNDDIR+DEFAULTBACKGROUND));
            backgroundFileName = imageName;
        }
        catch (IOException e) {
            System.err.println("No image found !!!");
        }
        return load;
    }
    //TODO we don't like switches ... maybe change into json so we can parse that?
    public boolean loadSettings() {
        if(!new File(SETTINGSFILE).exists()) {
            File dir = new File(SETTINGSDIR);
            dir.mkdirs();
        }
        try (Scanner s = new Scanner(new File(SETTINGSFILE))) {
            while(s.hasNext()) {
                String[] settingLine = s.nextLine().split("=");
                switch(settingLine[0]) {
                    case "musicOn":
                        setMusicOn(Boolean.parseBoolean(settingLine[1]));
                        break;
                    case "sfxOn":
                        setSfxOn(Boolean.parseBoolean(settingLine[1]));
                        break;
                    case "musicvolume":
                        setMusicVolume(Integer.parseInt(settingLine[1]));
                        break;
                    case "sfxvolume":
                        setSfxVolume(Integer.parseInt(settingLine[1]));
                        break;
                    case "bordercolor":
                        setBorderColor(new Color(Integer.parseInt(settingLine[1])));
                        break;
                    case "textcolor":
                        setTextColor(new Color(Integer.parseInt(settingLine[1])));
                        break;
                    case "backgroundcolor":
                        setBackgroundColor(new Color(Integer.parseInt(settingLine[1])));
                        break;
                    case "background":
                        setBackground(settingLine[1]);
                }
            }
            return true;
        }
        catch (FileNotFoundException e) {
            System.err.println("Settings: No settings found, using default.");
        }
        return false;
    }
    
    //TODO see loadSettings if changed to json then update this :)
    public void saveSettings() {
        try (FileWriter fw = new FileWriter(new File(SETTINGSFILE))) {
            fw.write(String.format("musicOn=%b\n", getMusicOn()));
            fw.write(String.format("sfxOn=%b\n", getSfxOn()));
            fw.write(String.format("musicvolume=%d\n", getMusicVolume()));
            fw.write(String.format("sfvvolume=%d\n", getSfxVolume()));
            fw.write(String.format("bordercolor=%d\n", getBorderColor().getRGB()));
            fw.write(String.format("textcolor=%d\n", getTextColor().getRGB()));
            fw.write(String.format("backgroundcolor=%d\n", getBackgroundColor().getRGB()));
            fw.write(String.format("background=%s\n", backgroundFileName));
            fw.flush();
            fw.close();
        }
        catch (IOException e) {
            System.err.println("Settings: oops?");
        }
    }
    
    public boolean getMusicOn() {
        return musicOn;
    }
    
    public boolean getSfxOn() {
        return sfxOn;
    }
    
    public int getMusicVolume() {
        return musicVolume;
    }
    
    public int getSfxVolume() {
        return sfxVolume;
    }
    
    public Color getBorderColor() {
        return borderColor;
    }
    
    public Color getTextColor() {
        return textColor;
    }
    
    public Color getBackgroundColor() {
        return backgroundColor;
    }
    
    public Image getBackground() {
        return background;
    }
    
    public void setMusicOn(boolean isOn) {
        musicOn = isOn;
        notifySoundObservers();
    }
    
    public void setSfxOn(boolean isOn) {
        sfxOn = isOn;
        notifySoundObservers();
    }
    
    public void setMusicVolume(int volume) {
        this.musicVolume = volume;
        notifySoundObservers();
    }
    
    public void setSfxVolume(int volume) {
        this.sfxVolume = volume;
        notifySoundObservers();
    }
    
    public void setBorderColor(Color color) {
        this.borderColor = color;
        notifyColorObservers();
    }
    
    public void setTextColor(Color color) {
        this.textColor = color;
        notifyColorObservers();
    }
    
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        notifyColorObservers();
    }
    
    public void setBackground(String fileName) {
        background = loadImage(fileName);
        notifyColorObservers();
    }

    @Override
    public void addSoundObserver(Observer o) {
        soundObservers.add(o);
    }

    @Override
    public void removeSoundObserver(Observer o) {
        soundObservers.remove(o);
    }

    @Override
    public void notifySoundObservers() {
        for(Observer o : soundObservers) {
            o.update(this, null);
        }
    }

    @Override
    public void addColorObserver(Observer o) {
        colorObservers.add(o);
    }

    @Override
    public void removeColorObserver(Observer o) {
        colorObservers.remove(o);
    }

    @Override
    public void notifyColorObservers() {
        for(Observer o: colorObservers) {
            o.update(this, null);
        }
    }
}
