/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonas Lauwers
 */
public class GameEngineTest {

    Ship ship = new Ship(150, 150);
    
    @Test
    public void initAndMoveTest() {
        GameEngine e = new GameEngine(ship);
        e.movePlayer(10, 0);
        int[] coords = e.getPlayerPos();
        assertEquals(coords[0], ship.getxPos());
        assertEquals(coords[1], ship.getyPos());
    }
    
    @Test
    public void addEnemy() {
        GameEngine e = new GameEngine(ship);
        assertEquals(e.getNumberOfEnemies(), 0);
        e.addEnemy(new Enemy(160, 160));
        assertEquals(e.getNumberOfEnemies(), 1);
    }
    
    @Test
    public void shoot() {
        GameEngine e = new GameEngine(ship);
        e.playerShoot();
        assertEquals(e.getNumberOfBullets(), 1);
        e.playerShoot();
        e.playerShoot();
        assertEquals(e.getNumberOfBullets(), 3);
    }
    
}
