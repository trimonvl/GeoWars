package be.howest.groep12.geowars.model;

import java.awt.Graphics;
import java.util.ArrayList;

public class BulletList {
	ArrayList<Bullet> bulletList = new ArrayList<>(); 
	public void add(Bullet bullet){
		bulletList.add(bullet);
	}
	public void draw(Graphics g){
		for(int i=0;i<bulletList.size();i++){
			bulletList.get(i).draw(g);
		}
	}
}
