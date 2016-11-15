/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
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
        private double angle;
        private Polygon pol;
        private Point[] original;
        private Point[] current;

	public Ship(int xPos, int yPos) {
		drones = new ArrayList<>();
		this.xPos = xPos;
		this.yPos = yPos;
                this.angle = 0;
                pol = new Polygon();
                
                //temp?
                this.original = new Point[3];
                this.original[0] = new Point(xPos, yPos-10);
                this.original[1] = new Point(xPos-10, yPos+10);
                this.original[2] = new Point(xPos+10, yPos+10);
                
                makePoly(original);
                
	}
        
        private void makePoly(Point[] points) {
            pol.reset();
            for(int i = 0; i < points.length; i++ ) {
                    pol.addPoint(points[i].x, points[i].y);
                }
        }

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
                translateShip(xPos-this.xPos, 0);
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
                translateShip(0, yPos-this.yPos);
		this.yPos = yPos;
	}
        
        public void setAngle(double angle) {
            this.angle = angle;
            rotateShip();
        }
        
        //temp for testing
        public double getAngle() {
            return angle;
        }
        
        private void rotateShip() {
            Point[] temp = new Point[3];
            //dunno why but without this error on adding to temp
            temp[0] = new Point(xPos, yPos-10);
            temp[1] = new Point(xPos-10, yPos+10);
            temp[2] = new Point(xPos+10, yPos+10);
            
            AffineTransform.getRotateInstance(Math.toRadians(angle),xPos, yPos).transform(original, 0, temp, 0, original.length);
            makePoly(temp);
        }
        
        private void translateShip(int xPos, int yPos) {
            AffineTransform.getTranslateInstance(xPos, yPos).transform(original,0,original,0,original.length);
            rotateShip();
        }

	public void addDrones(Drone drone) {
		drones.add(drone);
	}

	public void clearDrones() {
		drones.clear();
	}
	public void draw(Graphics g){
                g.fillPolygon(pol);
	}
        
        //TODO make draw bullet right in front of ship.
	public void shoot(BulletList bulletList){
		bulletList.add(new Bullet(pol.xpoints[0],pol.ypoints[0],"UP"));
	}
}
