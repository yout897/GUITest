/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author aldic2547
 */
public class GUITest extends javax.swing.JFrame{

    public String input = "",picked,cpPicked;
    public boolean deckCreated = false;
    
    public ArrayList deck = new ArrayList(51);
    public ArrayList hand,cpHand,warHand,cpWarHand;
    
    public GUITest() {
        initComponents();
        commandsPanel.setVisible(true);
        textArea1.setText("Welcome!\nIf you don't know any commands please type \"help\"!");
        Cards.setDeck(Cards.propDeck);
        hand = new ArrayList();
        cpHand = new ArrayList();
        warHand = new ArrayList();
        cpWarHand = new ArrayList();
    }

    public void commands(){
        
        input = inputField1.getText();
        if(commandsPanel.isVisible()){
            if(input.equalsIgnoreCase("Hi")){
                textArea1.setText(textArea1.getText() + "\nHello there!");
            }
            else if(input.equalsIgnoreCase("/help")){
                textArea1.setText(textArea1.getText() + "\n\nCommands:\tOutput:\n------------------------------------------------------------------------\n/escape:\tCloses the program\n/clear:\tClears the screen."
                        + "\n/tableflip:\t...What do you think it does.\n/rand:\tCreates a random number between 1 and 100!"
                        + "\n/repeat:\tRepeats everything after the word repeat.\n/rps:\tOpens a game of Rock,Paper,Scissors."
                        + "\n/deck:\tCreates a deck of sorted cards.\n/deck.shuffle:\tShuffles the current deck, and prints."
                        + "\n/deck.sort:\tSorts the deck by suit, and prints." + "\n/deck.print:\tPrints the deck."
                        + "\n/deal (numOfCards):\tDeals the amount of cards given, only if a deck has been created.");
            }
            else if(input.equalsIgnoreCase("/tableflip")){
                textArea1.setText(textArea1.getText() + "\n(ヘ･_･)ヘ┳━┳");    
                textArea1.setText(textArea1.getText() + "\n(┛◉Д◉)┛彡┻━┻");   
            }
            else if(input.equalsIgnoreCase("/rand")){
                int randomNum;
                randomNum = (int)(Math.ceil(Math.random()*100));
                textArea1.setText(textArea1.getText() + "\nYour Random Number is "+randomNum);
            }
            else if(input.startsWith("/repeat")){
                String str;
                int n = input.indexOf("/repeat");
                str = input.substring(n+7);
                textArea1.setText(textArea1.getText() + "\n\n" + str);
            }
            else if(input.equalsIgnoreCase("/rps")){
                RPSWindow.rps();
            }
            else if(input.startsWith("/deck")){
                if(input.equalsIgnoreCase("/deck")){    
                    Cards.setDeck(deck);
                    deckCreated = true;
                    textArea1.setText(textArea1.getText() + "\nDeck Created!");
                }
                else if(input.contains(".shuffle")){
                    Cards.shuffle(deck);
                    textArea1.setText(textArea1.getText() + "\nDeck Shuffled!");
                }
                else if(input.contains(".sort")){
                    Cards.sortDeck(deck);
                    textArea1.setText(textArea1.getText() + "\nDeck Sorted!");
                }
                else if(input.contains(".print")){
                    deck.stream().forEach((deck1) -> {
                        textArea1.setText(textArea1.getText() + "\n" + deck1);
                    });
                }
            }
            else if(input.startsWith("/deal") && deckCreated){
                deal(input);
            }      
            else if(input.equalsIgnoreCase("/game")){
                GTestWindow.runner();
            }
            else if(input.equalsIgnoreCase("/clear")){
                textArea1.setText("");
            }
            else if(input.equalsIgnoreCase("/escape")){
                System.exit(0);
            }
            else{
                textArea1.setText(textArea1.getText() + "\nThat is not a valid command.");
            }
        }
    }
    public void deal(String str){
        int n = input.indexOf("/deal");
        str = input.substring(n+5);
        str = str.trim();
        int s;
        s = Integer.parseInt(str);
        
        for(int i = 0;i < s;i++){
            int rand = (int)(Math.ceil(Math.random()*51));
            String card = deck.get(rand).toString();
            hand.add(card);
            textArea1.setText(textArea1.getText() + "\n" + hand.get(i));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        commandsPanel = new javax.swing.JPanel();
        inputField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputField1ActionPerformed(evt);
            }
        });

        textArea1.setEditable(false);
        textArea1.setColumns(20);
        textArea1.setRows(5);
        textArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textArea1);

        javax.swing.GroupLayout commandsPanelLayout = new javax.swing.GroupLayout(commandsPanel);
        commandsPanel.setLayout(commandsPanelLayout);
        commandsPanelLayout.setHorizontalGroup(
            commandsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(commandsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputField1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        commandsPanelLayout.setVerticalGroup(
            commandsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commandsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(inputField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commandsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commandsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputField1ActionPerformed
        commands();
        inputField1.setText("");
    }//GEN-LAST:event_inputField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUITest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUITest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUITest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUITest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GUITest().setVisible(true);
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel commandsPanel;
    private javax.swing.JTextField inputField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
