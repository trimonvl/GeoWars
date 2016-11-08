/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonas Lauwers
 */
public class Ship {
    
    private final List<Drone> drones;
    private final List<Power> powers;
    private int attack = 10;
    private int defense = 10;
    private Coordinate location;
    
    public Ship() {
        powers = new ArrayList<>();
        drones = new ArrayList<>();
    }
    
     public void addDrones(Drone drone) {
        drones.add(drone);
    }
    
    public void addPower(Power power) {
        powers.add(power);
    }
    
    public void clearDrones() {
        drones.clear();
    }
    
    public void clearPowers() {
        powers.clear();
    }
    
    public void ishit() {
        defense--;
    }
    
    public boolean isDead() {
        return defense <=0;
    }
    
    public int fire() {
        return attack;
    }
    
    public void move(int xMovement, int yMovement) {
        location.updateX(xMovement);
        location.updateY(yMovement);
    }
}
