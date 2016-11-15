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
public class Enemy {
	private int xPos;
	private int yPos;

	public Enemy(int xPos, int yPos) {
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
	public void draw(Graphics g){
		int width = 10;
		int height = 10;
		g.fillRect(xPos, yPos, width, height);
	}
}
