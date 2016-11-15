package be.howest.groep12.geowars.model;

import static org.junit.Assert.*;
import org.junit.Test;


public class ShipTest {
        
        private Ship ship = new Ship(10,10);
    
	@Test
	public void setGetShip() {
		ship = new Ship(10,10);
		ship.setxPos(5);
		ship.setyPos(15);
		assertEquals(ship.getxPos(), 5);
		assertEquals(ship.getyPos(), 15);
	}

	@Test
	public void setGetEnemy() {
		Enemy enemy = new Enemy(10,10);
		ship.setxPos(5);
		ship.setyPos(15);
		assertEquals(ship.getxPos(), 5);
		assertEquals(ship.getyPos(), 15);
	}

	@Test
	public void setGetBullet() {
		Bullet bullet = new Bullet(10,10,"up");
		ship.setxPos(5);
		ship.setyPos(15);
		assertEquals(ship.getxPos(), 5);
		assertEquals(ship.getyPos(), 15);
	}
}
