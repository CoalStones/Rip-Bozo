package dinosaur.game.v3.objects;

import dinosaur.game.v3.Game;
import dinosaur.game.v3.globalPositioningSystem;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class tree extends globalPositioningSystem {
    
    int speed=5,speedCount=0;
    public static boolean bozoDead;
    public static int running=0;
    
    public tree(int x, int y){
        super(x,y);
    }
    
   
       
    public void update(){
        speedUpdates();
      if(x <=  0 - 150){
x = 900+150;
Game.check=0;
}
x-=speed;
        
    }
    
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getEnemyImage(),x,y,null);
        if(bozoDead){
            g2d.drawImage(ripBozo(),300,250,null);
            running++;
        }
    }
    
    public Image getEnemyImage(){
        ImageIcon i = new ImageIcon(getClass().getResource("/images/tree.png"));
        return i.getImage();
    }
    
    public Rectangle getTreeBounds() {
	return new Rectangle(x, y, 150, 150);
    }
    
    public Image ripBozo(){
        ImageIcon b = new ImageIcon(getClass().getResource("/images/RIPBOZO.png"));
        return b.getImage();
    }
    
    public void speedUpdates(){
        if(Game.displayScore<100)speed=5;
        else if(Game.displayScore<200)speed=7;
        else if(Game.displayScore<300)speed=9;
        else if(Game.displayScore<400)speed=11;
        else if(Game.displayScore<500)speed=13;
        else if(Game.displayScore>=500)speed=15;
    }
}
