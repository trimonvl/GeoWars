/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.groep12.geowars.view.menu;

import be.howest.groep12.geowars.view.MenuInterface;
import be.howest.groep12.geowars.Settings.SettingsModel;
import java.awt.CardLayout;
import java.awt.Container;

/**
 *
 * @author Jonas Lauwers
 */
public class SinglePlayerMenu extends MenuInterface {
    
    
    /**
     * Creates new form SinglePlayerMenu
     */
    public SinglePlayerMenu(Container parent, CardLayout layout, SettingsModel settings) {
        super(parent, layout, settings);
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

        campaignButton = new be.howest.groep12.geowars.view.GameButton();
        arcadeButton = new be.howest.groep12.geowars.view.GameButton();
        highscoresButton = new be.howest.groep12.geowars.view.GameButton();
        backButton = new be.howest.groep12.geowars.view.GameButton();
        jLabel1 = new javax.swing.JLabel();

        campaignButton.setText("Campaign");
        campaignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campaignButtonActionPerformed(evt);
            }
        });

        arcadeButton.setText("Arcade");
        arcadeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arcadeButtonActionPerformed(evt);
            }
        });

        highscoresButton.setText("Highscores");
        highscoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highscoresButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SINGLEPLAYER");
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(arcadeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(highscoresButton, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(campaignButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(371, 371, 371))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(campaignButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(arcadeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(highscoresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void arcadeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arcadeButtonActionPerformed
        layout.show(parent, "game");
    }//GEN-LAST:event_arcadeButtonActionPerformed

    private void highscoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highscoresButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_highscoresButtonActionPerformed

    private void campaignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campaignButtonActionPerformed
        layout.show(parent, "CampaignMenu");
    }//GEN-LAST:event_campaignButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        layout.show(parent, "TitleMenu");
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private be.howest.groep12.geowars.view.GameButton arcadeButton;
    private be.howest.groep12.geowars.view.GameButton backButton;
    private be.howest.groep12.geowars.view.GameButton campaignButton;
    private be.howest.groep12.geowars.view.GameButton highscoresButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}