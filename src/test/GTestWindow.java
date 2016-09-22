/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class GTestWindow {
    
    public static void runner(){
        
        JFrame frame = new JFrame("Survival");
        frame.setContentPane(new GamePanel());

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        frame.setResizable(false);
        frame.pack();

        frame.setPreferredSize(new Dimension(GamePanel.WIDTH,GamePanel.HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
