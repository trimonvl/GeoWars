/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.gui.gamemenu;

import be.howest.groep12.geowars.model.Bullet;
import be.howest.groep12.geowars.model.BulletList;
import be.howest.groep12.geowars.model.Enemy;
import be.howest.groep12.geowars.model.Ship;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 *
 * @author Jonas Lauwers
 */
public class tempPlayScreen extends JPanel implements Runnable, KeyListener, MouseListener {
    
    private Dimension d;
    private ArrayList enemies;
    private Ship ship;
    private BulletList shots;
    
    private Thread animator;
    
    public tempPlayScreen() {
        setFocusable(true);
        d = new Dimension(600,400);
        setBackground(Color.BLACK);
        gameInit();
        setDoubleBuffered(true);
        addKeyListener(this);
        addMouseListener(this);
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        addKeyListener(this);
        gameInit();
    }
    
    public void gameInit() {
        enemies = new ArrayList();
        for(int i = 0; i < 5; i++) {
            Enemy e = new Enemy(150+15*i, 150);
            enemies.add(e);
        }
        
        ship = new Ship(200, 200);
        
        shots = new BulletList();
        
        if(animator == null) {
            animator = new Thread(this);
            animator.start();
        }
    }
    
    public void drawEnemies(Graphics g) {
        Iterator it = enemies.iterator();
        while(it.hasNext()) {
            Enemy e = (Enemy) it.next();
            e.draw(g);
        }
    }
    
    public void drawPlayer(Graphics g) {
        ship.draw(g);
    }
    
    public void drawShots(Graphics g) {
        shots.draw(g);
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(this.getBackground());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.red);
        drawEnemies(g);
        drawPlayer(g);
        drawShots(g);
        g.dispose();
    }
    
    public void animate() {
        shots.move();
        ship.move(shots);
    }

    @Override
    public void run() {
        
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        while(true) {
            repaint();
            animate();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = 17 - timeDiff;

            if (sleep < 0) 
                sleep = 2;
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            beforeTime = System.currentTimeMillis();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ship.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ship.keyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ship.setShooting(true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ship.setShooting(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
