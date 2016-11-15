/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonas Lauwers
 */
public class GameEngine {
    
   private Ship ship;
   private List<Enemy> enemies;
   private BulletList bullets;
   
   //TODO empty construct, set ship and set difficulty?
   public GameEngine(Ship ship) {
       this.ship = ship;
       enemies = new ArrayList<>();
       bullets = new BulletList();
   }
   
   //moves player (-)x, (-)y coords
   public void movePlayer(int x, int y) {
       ship.setxPos(ship.getxPos()+x);
       ship.setyPos(ship.getyPos()+y);
   }
   
   public void setPlayerAngle(double angle) {
       ship.setAngle(angle);
   }
   
   //test for angle
   public double getAngle() {
       return ship.getAngle();
   }
   
   //test for playerpos
   public int[] getPlayerPos() {
       int[] coord = new int[2];
       coord[0] = ship.getxPos();
       coord[1] = ship.getyPos();
       return coord;
   }
   
   //test for bullets
   public int getNumberOfBullets() {
       return bullets.getNumber();
   }
   
   public void playerShoot() {
       ship.shoot(bullets);
   }
   
   //test for enemies
   public int getNumberOfEnemies() {
       return enemies.size();
   }
   
   public void addEnemy(Enemy e) {
       enemies.add(e);
   }
   
   //TODO make enemy move to player ....
   //will be done with lib I guess, same for player.
   
   public void draw(Graphics g) {
       ship.draw(g);
       for(Enemy e : enemies) {
           e.draw(g);
       }
       bullets.draw(g);
   }
}
