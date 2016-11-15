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
        
	public void draw(Graphics g){
		for(int i=0;i<bulletList.size();i++){
			bulletList.get(i).draw(g);
		}
	}
}
