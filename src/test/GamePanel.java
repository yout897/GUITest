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
public class GamePanel extends JPanel implements Runnable, KeyListener {

    //Game Loop
    private boolean running;
    private Thread thread;
    private long targetT;
    //Rendering
    private Graphics2D g2d;
    private BufferedImage image;
    //Entities
    private final int SIZE = 20;
    private Entity pl;
    private Entity tree1, tree2;
    private Entity slot, slot2, slot3;
    private Entity topWall, botWall, leftWall, rightWall;
    private final ArrayList<Entity> trees = new ArrayList<>();
    private final ArrayList<Entity> inventories = new ArrayList<>();
    private final ArrayList<Entity> walls = new ArrayList<>();
    JButton button1 = new JButton("Hi");
    //Variables
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    private int dx, dy, h = 0, treeNum = 5,num = 0;
    public String wood = "wood";
    private final ArrayList<String> inventory = new ArrayList<>();
    private boolean up, down, left, right, t = false, harvest, inv = false,craft = false,one;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        add(button1);
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
        int k = e.getKeyCode();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        if (k == KeyEvent.VK_W) {
            up = true;
        }
        if (k == KeyEvent.VK_S) {
            down = true;
        }
        if (k == KeyEvent.VK_A) {
            left = true;
        }
        if (k == KeyEvent.VK_D) {
            right = true;
        }
        if (k == KeyEvent.VK_F) {
            harvest = true;
        }
        if (k == KeyEvent.VK_E) {
            inv = true;
        }
        if (k == KeyEvent.VK_C) {
            craft = !craft;
        }
        if(k == KeyEvent.VK_1){
            one = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();

        if (k == KeyEvent.VK_W) {
            up = false;
        }
        if (k == KeyEvent.VK_S) {
            down = false;
        }
        if (k == KeyEvent.VK_A) {
            left = false;
        }
        if (k == KeyEvent.VK_D) {
            right = false;
        }
        if (k == KeyEvent.VK_F) {
            harvest = false;
        }
        if (k == KeyEvent.VK_E) {
            inv = false;
        }
        if(k == KeyEvent.VK_1){
            one = false;
        }
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

        Collections.addAll(inventory, "i", "i", "i", "i", "i");

        pl = new Entity(SIZE, SIZE);
        tree1 = new Entity(SIZE, SIZE);
        tree2 = new Entity(SIZE, SIZE);
        topWall = new Entity(WIDTH, 5);
        topWall.setPos(0, 0);
        botWall = new Entity(WIDTH, 5);
        botWall.setPos(HEIGHT, 0);
        leftWall = new Entity(5, HEIGHT);
        leftWall.setPos(0, 0);
        rightWall = new Entity(5, HEIGHT);
        rightWall.setPos(WIDTH, 0);
        slot = new Entity(SIZE + 10, SIZE + 10);
        slot2 = new Entity(SIZE + 10, SIZE + 10);
        slot3 = new Entity(SIZE + 10, SIZE + 10);

        trees.add(tree1);
        trees.add(tree2);

        inventories.add(slot);
        inventories.add(slot2);
        inventories.add(slot3);

        walls.add(topWall);
        walls.add(botWall);
        walls.add(leftWall);
        walls.add(rightWall);
        trees.stream().forEach((tree) -> {
            int rand1 = (int) (Math.random() * WIDTH);
            int rand2 = (int) (Math.random() * HEIGHT);
            tree.setPos(rand1, rand2);
        });
    }

    //Draws the background and places anything that needs to be rendered ontop
    private void requestRender() {
        render(g2d);
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }

    //Function to continuosly initialize anything that needs to be checked at all times
    private void update() {

        if (up) {
            dy -= 1 * 0.0025;
        }
        if (down) {
            dy += 1 * 1.0025;
        }
        if (left) {
            dx -= 1 * 0.0025;
        }
        if (right) {
            dx += 1 * 1.0025;
        }

        if (dx > WIDTH - 10) {
            dx -= 10;
        }
        if (dy > HEIGHT - 10) {
            dy -= 10;
        }

        pl.setPos(dx, dy);

        for (int i = 0; i < trees.size(); i++) {
            if (pl.colliding(trees.get(i))) {
                h = i;
                t = true;
            }
        }
        if (harvest && t) {
            trees.remove(h);
            inventory.set(num,wood);
            num++;
            t = false;
        }
    }

    //Rendering graphics
    public void render(Graphics2D g2d) {
            g2d.clearRect(0, 0, WIDTH, HEIGHT);
            g2d.setColor(Color.BLUE);
            pl.render(g2d);

            if (t) {
                g2d.setColor(Color.WHITE);
                g2d.drawString("Press \"F\" to harvest", 40, 40);
            }
            if (inv) {
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        for (Entity e : inventories) {
                            //for(){
                                if (null != inventory.get(x)) 
                                   switch (inventory.get(x)) {
                                    case "i":
                                        g2d.setColor(Color.lightGray);
                                        e.setPos(x + 10 + x * 30, y + 10);
                                        e.render(g2d);
                                        break;
                                    case "wood":
                                        g2d.setColor(new Color(75,45,7));
                                        e.setPos(x + 10 + x * 30, y + 10);
                                        e.render(g2d);
                                        break;
                                    case "stick":
                                        g2d.setColor(new Color(133,85,31));
                                        e.setPos(x + 10 + x * 30, y + 10);
                                        e.render(g2d);
                                        break;
                                }
                                
                           // }
                        }
                    }
                }
            }
            
            g2d.setColor(Color.WHITE);
            walls.stream().forEach((e) -> {
                e.render(g2d);
            });

            g2d.setColor(Color.ORANGE);
            trees.stream().forEach((e) -> {
                e.render(g2d);
            });
            
            if(craft){
                g2d.setColor(Color.WHITE);
                g2d.fillRect(750, 50, 240, 500);
                g2d.drawString("Press \"1\" to craft a stick",760,60);
                if(one){
                    if(inventory.contains("wood")){
                        int check;
                        check = inventory.indexOf("wood");
                        inventory.set(check, "i");
                        inventory.add("stick");
                    }else{
                        g2d.drawString("You don't have any wood",760,400);
                    }
                }
            }
        }
    }
