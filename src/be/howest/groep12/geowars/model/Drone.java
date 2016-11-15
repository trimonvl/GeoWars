/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.model;

import java.awt.Graphics;

/**
 *
 * @author Jonas Lauwers
 */
public class Drone {
	private int xPos;
	private int yPos;

	public Drone(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	public void draw(Graphics g){
		int[] xPoints = {xPos,xPos-5,xPos+5};
		int[] yPoints = {yPos-5,yPos+5,yPos+5};
		int nPoints = 3;
		g.drawPolygon(xPoints, yPoints, nPoints);
	}
}
