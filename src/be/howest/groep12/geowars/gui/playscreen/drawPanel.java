/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.gui.playscreen;

import be.howest.groep12.geowars.gui.SettingsModel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Jonas Lauwers
 */
public class drawPanel extends javax.swing.JPanel implements Observer {
    
    private Image background;
    private List<testActor> actors;
    private testActor p;

    /**
     * Creates new form drawPanel
     */
    public drawPanel() {
        SettingsModel settings = new SettingsModel();
        background = settings.getBackground();
        
        initComponents();
        
        
    }
    
    public void setGame(List<testActor> drawable, testActor player) {
        actors = drawable;
        p = player;
        p.addObserver(this);
    }
    
    public void endGame() {
        p.deleteObserver(this);
        actors = null;
        p = null;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.setColor(Color.red);
        for(testActor ta: actors) {
            g.drawPolygon(ta.getShape());
        }
        g.drawOval(p.getX(), p.getY(), 5, 5);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
