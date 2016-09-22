/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable,KeyListener{
    //Game Loop
    private boolean running;
    private Thread thread;
    private long targetT;
    //Rendring
    private Graphics2D g2d;
    private BufferedImage image;
    private JButton button = new JButton("test");
    //Entities
    private int SIZE = 20;
    private Entity pl;
    private Entity tree1;
    private Entity tree2;
    private Entity slot;
    private ArrayList<Entity> trees = new ArrayList<Entity>();
    private ArrayList<Entity> inventories = new ArrayList<Entity>();
    //Variables
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 720;
    private int dx,dy,h = 0;
    private String wood = "wood";
    private ArrayList inventory = new ArrayList();
    private boolean up,down,left,right,t = false,harvest,inv = false;
    
    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        
        add(button);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        thread = new Thread(this);
        thread.start();
    }
    //Do I even have to say what this does
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();
		
        if(k == KeyEvent.VK_W){up = true;}
        if(k == KeyEvent.VK_S){down = true;}
        if(k == KeyEvent.VK_A){left = true;}
        if(k == KeyEvent.VK_D){right = true;}
        if(k == KeyEvent.VK_F){harvest = true;};
        if(k == KeyEvent.VK_E){inv = true;}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();
		
        if(k == KeyEvent.VK_W){up = false;}
        if(k == KeyEvent.VK_S){down = false;}
        if(k == KeyEvent.VK_A){left = false;}
        if(k == KeyEvent.VK_D){right = false;}
        if(k == KeyEvent.VK_F){harvest = false;};
        if(k == KeyEvent.VK_E){inv = false;}
    }
    
    //Game Loop
    @Override
    public void run() {
        if (running) {
            return;
        }
        initialize();
        long startT;
        long elapsed;
        long wait;
        while (running) {
            startT = System.nanoTime();
            update();
            requestRender();
            elapsed = System.nanoTime() - startT;
            wait = targetT - elapsed / 1000000;
            if (wait > 0) {
                try {
                    Thread.sleep(wait);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //Function to initialize anything that gets added once
    public void initialize() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g2d = image.createGraphics();
        
        running = true;
        
        pl = new Entity(SIZE);
        tree1 =  new Entity(SIZE);
        tree2 = new Entity(SIZE);
        slot = new Entity(SIZE + 10);
        
        trees.add(tree1);
        trees.add(tree2);
        
        int rand1 = (int)(Math.random()*900);
        int rand2 = (int)(Math.random()*600);
        tree1.setPos(rand1, rand2);
        rand1 = (int)(Math.random()*900);
        rand2 = (int)(Math.random()*600);
        tree2.setPos(rand1,rand2);
    }
    //Draws the background and places anything that needs to be rendered ontop
    private void requestRender() {
        render(g2d);
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0,null);
        g.dispose();
    }
    //Function to continuosly initialize anything that needs to be checked at all times
    private void update(){
        
        if(up){
            dy -= 1 * 0.0025;
        }
        if(down){
            dy += 1 * 1.0025;
        }
        if(left){
            dx -= 1 * 0.0025;
        }
        if(right){
            dx += 1 * 1.0025;
        }
        
        if(dx > 900){
            dx -= 10;
        }
        if(dy > 700){
            dy -= 10; 
        }
        
        pl.setPos(dx, dy);
        
        for(int i = 0; i < trees.size();i++){
            if(pl.colliding(trees.get(i))){
                h = i;
                t = true;
            }
        }
        if(harvest && t){
            trees.remove(h);
            Collections.addAll(inventory,wood,wood,wood);
            t = false;
        }
    }
    
   
    
    //Rendering graphics
    public void render(Graphics2D g2d) {
        g2d.clearRect(0, 0, WIDTH, HEIGHT);
        g2d.setColor(Color.BLUE);
        pl.render(g2d);
        
        if(t){
            g2d.setColor(Color.WHITE);
            g2d.drawString("Press \"F\" to harvest", 40, 40);
        }
        if(inv){
            g2d.setColor(Color.lightGray);
            for(int x = 0; x < 5;x++){
                for(int y = 0; y < 5;y++){
                    inventories.add(slot);
                    inventories.add(slot);
                    inventories.add(slot);
                    for(Entity e : inventories){
                        e.setPos(x+10, y-10);
                        e.render(g2d);
                    }
                }
            }
        }
        g2d.setColor(Color.ORANGE);
        for(Entity e : trees){
            e.render(g2d);
        }
    }
}
