import static org.junit.Assert.*;

import org.junit.Test;

import be.howest.groep12.geowars.model.Ship;

public class ShipTest {

	@Test
	public void setGetShip() {
		Ship ship = new Ship(10,10);
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
		Bullet bullet = new Bullet(10,10);
		ship.setxPos(5);
		ship.setyPos(15);
		assertEquals(ship.getxPos(), 5);
		assertEquals(ship.getyPos(), 15);
	}
}
