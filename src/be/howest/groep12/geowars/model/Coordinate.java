/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.model;

/**
 *
 * @author Jonas Lauwers
 */
//TODO should contain all coordinates covering the outside of the object ...
//probably map all x coord to y coord or y to x ...
public class Coordinate {
    
    private int x;
    private int y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void updateX(int xChange) {
        x += xChange;
    }
    
    public void updateY(int ychange) {
        y += ychange;
    }
    
    public boolean isInCollision(Coordinate coord) {
        return this.x == coord.getX() && this.y == coord.getY();
    }
    
}
