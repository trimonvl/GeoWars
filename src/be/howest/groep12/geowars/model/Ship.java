/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonas Lauwers
 */
public class Ship {

	private final List<Drone> drones;
	private int xPos;
	private int yPos;

	public Ship(int xPos, int yPos) {
		drones = new ArrayList<>();
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public void addDrones(Drone drone) {
		drones.add(drone);
	}

	public void clearDrones() {
		drones.clear();
	}
	public void draw(Graphics g){
		int[] xPoints = {xPos,xPos-10,xPos+10};
		int[] yPoints = {yPos-10,yPos+10,yPos+10};
		int nPoints = 3;
		g.fillPolygon(xPoints, yPoints, nPoints);
	}
        
        //TODO make draw bullet right in front of ship.
	public void shoot(BulletList bulletList){
		bulletList.add(new Bullet(xPos,yPos-20,"UP"));
	}
}
