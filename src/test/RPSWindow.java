/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author aldic2547
 */
public class RPSWindow extends javax.swing.JFrame {

    public static int p1 = 0,cpu = 0;
    public RPSWindow() {
        
        initComponents();
    }

    public static void rps(){
        runner();
    }
    
    public static void checker(){
        cpu = (int)(Math.ceil(Math.random()*(3)));
        switch(p1){
            case 1:
                if(cpu == 1){
                    stanceLabel.setText("CPU also chose Rock.Draw!");
                }
                else if(cpu == 2){
                    stanceLabel.setText("CPU chose Paper.CPU Wins!");
                }
                else if(cpu == 3){
                    stanceLabel.setText("CPU chose Scissors.Player Wins!");
                }
                break;
            case 2:
                if(cpu==2){
                    stanceLabel.setText("CPU also chose Paper.Draw!");
                }
                else if(cpu == 3){
                    stanceLabel.setText("CPU chose Scissors.CPU Wins!");
                }
                else if(cpu == 1){
                    stanceLabel.setText("CPU chose Rock.Player Wins!");
                }
                break;
            case 3:
                if(cpu==3){
                   stanceLabel.setText("CPU also chose Scissors.Draw!"); 
                }
                else if(cpu == 2){
                    stanceLabel.setText("CPU chose Paper.Player Wins!");
                }
                else if(cpu == 1){
                    stanceLabel.setText("CPU chose Rock.CPU Wins!");
                }
                break;
        }
    }
    
    public static void runner(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RPSWindow().setVisible(true);
                
            }
        });
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rockButton = new javax.swing.JButton();
        paperButton = new javax.swing.JButton();
        scissorsButton = new javax.swing.JButton();
        stanceLabel = new javax.swing.JLabel();
        titelLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rockButton.setText("Rock");
        rockButton.setBorder(null);
        rockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rockButtonActionPerformed(evt);
            }
        });

        paperButton.setText("Paper");
        paperButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paperButtonActionPerformed(evt);
            }
        });

        scissorsButton.setText("Scissors");
        scissorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scissorsButtonActionPerformed(evt);
            }
        });

        stanceLabel.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        stanceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        titelLabel1.setFont(new java.awt.Font("MV Boli", 0, 36)); // NOI18N
        titelLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titelLabel1.setText("Rock, Paper, Scissors");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(paperButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scissorsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(titelLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titelLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(scissorsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(paperButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(stanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paperButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paperButtonActionPerformed
        p1 = 2;
        checker();
    }//GEN-LAST:event_paperButtonActionPerformed

    private void rockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rockButtonActionPerformed
        p1 = 1;
        checker();
    }//GEN-LAST:event_rockButtonActionPerformed

    private void scissorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scissorsButtonActionPerformed
        p1 = 3;
        checker();
    }//GEN-LAST:event_scissorsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton paperButton;
    private javax.swing.JButton rockButton;
    private javax.swing.JButton scissorsButton;
    private static javax.swing.JLabel stanceLabel;
    private javax.swing.JLabel titelLabel1;
    // End of variables declaration//GEN-END:variables
}
