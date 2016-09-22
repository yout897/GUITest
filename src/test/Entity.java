/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Entity {
    
    private int x,y,size;
    
    public Entity(int size){
        this.size = size;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setPos(int x , int y){
        this.x = x;
        this.y = y;
    }
    public void move(int x, int y){
        x += x;
        y += y;
        //test
    }
    public Rectangle getBound(){
        return new Rectangle(x,y,size,size);
    }
    public boolean colliding(Entity e){
        if(e == this)return false;
        return getBound().intersects(e.getBound());
    }
    public void render(Graphics2D g2d){
        g2d.fillRect(x + 1, y + 1, size - 2, size - 2);
    }
}
