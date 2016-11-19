package be.howest.groep12.geowars.model;

import java.awt.Graphics;
import java.util.ArrayList;

public class BulletList {
    
	private ArrayList<Bullet> bulletList = new ArrayList<>(); 
        
	public void add(Bullet bullet){
		bulletList.add(bullet);
	}
        
        //test for bullets
        public int getNumber() {
            return bulletList.size();
        }
        
        public void move() {
            for(Bullet b : bulletList) {
                b.move();
            }
        }
        
	public void draw(Graphics g){
            for(Bullet b : bulletList) {
                b.draw(g);
            }
	}
}
