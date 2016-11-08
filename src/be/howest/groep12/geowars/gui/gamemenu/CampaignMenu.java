/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.gui.gamemenu;

import java.awt.CardLayout;
import java.awt.Container;

/**
 *
 * @author Jonas Lauwers
 */
public class CampaignMenu extends javax.swing.JPanel {

    private Container parent;
    private CardLayout layout;
    
    /**
     * Creates new form CampaignMenu
     */
    public CampaignMenu(Container parent, CardLayout layout) {
        this.parent = parent;
        this.layout = layout;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        loadGameButton = new be.howest.groep12.geowars.gui.gamemenu.GameMenuButton();
        newGameButton = new be.howest.groep12.geowars.gui.gamemenu.GameMenuButton();
        backButton = new be.howest.groep12.geowars.gui.gamemenu.GameMenuButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CAMPAIGN");

        loadGameButton.setText("Load");
        loadGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGameButtonActionPerformed(evt);
            }
        });

        newGameButton.setText("New");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(newGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addGap(246, 246, 246))
            .addGroup(layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(375, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loadGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        layout.show(parent, "SinglePlayerMenu");
    }//GEN-LAST:event_backButtonActionPerformed

    private void loadGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadGameButtonActionPerformed

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newGameButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private be.howest.groep12.geowars.gui.gamemenu.GameMenuButton backButton;
    private javax.swing.JLabel jLabel1;
    private be.howest.groep12.geowars.gui.gamemenu.GameMenuButton loadGameButton;
    private be.howest.groep12.geowars.gui.gamemenu.GameMenuButton newGameButton;
    // End of variables declaration//GEN-END:variables
}
