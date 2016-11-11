/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.Settings;

import java.awt.Color;
import java.awt.Image;
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
public class StyleSettings extends Observable {
    
    private Color borderColor;
    private Color textColor;
    private Color backgroundColor;
    private Image background;
    private String backgroundFileName;
    private String filename;
    
    private StyleSettings(String dir) {
        borderColor = Color.RED;
        textColor = Color.WHITE;
        backgroundColor = Color.DARK_GRAY;
        backgroundFileName = "default.jpg";
        background = loadImage(backgroundFileName);
        this.filename = dir+"/styleSettings.conf";
    }
    
    private void save() {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(String.valueOf(borderColor.getRGB())+"\n");
            fw.write(String.valueOf(textColor.getRGB())+"\n");
            fw.write(String.valueOf(backgroundColor.getRGB())+"\n");
            fw.write(String.valueOf(backgroundFileName)+"\n");
        }
        catch (IOException e) {
            System.err.println("settings not saved");
        }
    }
    
    public static StyleSettings load(String dir) {
        StyleSettings settings = new StyleSettings(dir);
        try (Scanner s = new Scanner(new File(settings.filename))) {
            if(s.hasNext()) {
                settings.setBorderColor(new Color(s.nextInt()));
                settings.setTextColor(new Color(s.nextInt()));
                settings.setBackgroundColor(new Color(s.nextInt()));
                s.nextLine();
                settings.setBackground(s.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Could not load style settings from file, using default");
            settings.save();
        }
        return settings;
    }
    
    private Image loadImage(String filename) {
       try {
           Image load = ImageIO.read(new File("data/backgrounds/"+filename));
           backgroundFileName = filename;
           return load;
       }
       catch (IOException e) {
           System.err.println("Image not loaded");
       }
        return null;
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
    
    public void setBorderColor(Color color) {
        this.borderColor = color;
        ischanged();
    }
    
    public void setTextColor(Color color) {
        this.textColor = color;
        ischanged();
    }
    
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        ischanged();
    }
    
    public void setBackground(String fileName) {
        background = loadImage(fileName);
        ischanged();
    }
    
    public void ischanged() {
        setChanged();
        notifyObservers();
        save();
    }
}
