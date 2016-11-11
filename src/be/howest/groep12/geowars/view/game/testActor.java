/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.view.game;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Jonas Lauwers
 */
public class testActor extends Observable {
    
    private int x;
    private int y;
    private Polygon shape;
    private List<testActor> test;
    
    public testActor(int x, int y, Polygon shape) {
        test = new ArrayList<>();
        this.shape = shape;
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Polygon getShape() {
        return shape;
    }
    
    public void setX(int x) {
        this.x = x;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void setY(int y) {
        this.y = y;
        this.setChanged();
        this.notifyObservers();
    }
    
    public List<testActor> getDrawables() {
        return test;
    }
    
    public void addDrawable(testActor ta) {
        test.add(ta);
    }
}
