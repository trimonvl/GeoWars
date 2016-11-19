package be.howest.groep12.geowars.model;

import java.awt.Graphics;

public class Bullet {
	private int xPos;
	private int yPos;
	private String Direction;

	public Bullet(int xPos, int yPos,String Direction) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.Direction = Direction;
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
	public String getDirection() {
		return Direction;
	}
	public void setDirection(String direction) {
		Direction = direction;
	}
        public void move() {
            switch(Direction) {
                case "UP":
                    yPos--;
                    break;
                case "DOWN":
                    yPos++;
                    break;
                case "LEFT":
                    xPos--;
                    break;
                case "RIGHT":
                    xPos++;
                    break;
            }
        }
	public void draw(Graphics g){
		int width = 5;
		int height = 5;
		g.fillOval(xPos, yPos, width, height);
	}
}
