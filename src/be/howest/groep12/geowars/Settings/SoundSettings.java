/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.Settings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Scanner;

/**
 *
 * @author Jonas Lauwers
 */
public class SoundSettings extends Observable {
    
    private boolean musicOn;
    private boolean sfxOn;
    private int musicVolume;
    private int sfxVolume;
    private String filename;
    
    private SoundSettings(String dir) {
        musicOn = true;
        sfxOn = true;
        musicVolume = 80;
        sfxVolume = 80;
        this.filename = dir+"/soundSettings.conf";
    }
    
    private void save() {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(String.valueOf(musicOn)+"\n");
            fw.write(String.valueOf(sfxOn)+"\n");
            fw.write(String.valueOf(musicVolume)+"\n");
            fw.write(String.valueOf(sfxVolume)+"\n");
        }
        catch (IOException e) {
            System.err.println("settings not saved");
        }
    }
    
    public static SoundSettings load(String dir) {
        SoundSettings settings = new SoundSettings(dir);
        try (Scanner s = new Scanner(new File(settings.filename))) {
            if(s.hasNext()) {
                settings.setMusicOn(s.nextBoolean());
                settings.setSfxOn(s.nextBoolean());
                settings.setMusicVolume(s.nextInt());
                settings.setSfxVolume(s.nextInt());
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Could not load sound settings from file, using default");
            settings.save();
        }
        return settings;
        
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
    
    public void setMusicOn(boolean isOn) {
        musicOn = isOn;
        isChanged();
    }
    
    public void setSfxOn(boolean isOn) {
        sfxOn = isOn;
        isChanged();
    }
    
    public void setMusicVolume(int volume) {
        this.musicVolume = volume;
        isChanged();
    }
    
    public void setSfxVolume(int volume) {
        this.sfxVolume = volume;
        isChanged();
    }
    
    private void isChanged() {
        setChanged();
        notifyObservers();
        save();        
    }
}
