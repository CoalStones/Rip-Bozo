
package dinosaur.game.v3.objects;

import dinosaur.game.v3.Game;
import dinosaur.game.v3.globalPositioningSystem;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

public class red extends globalPositioningSystem{
    int speed = 5,speedCount=0;
    public static boolean redBozoDead;
    public static int running=0;
    public red(int x, int y) {
        super(x, y);
    }
    public void draw(Graphics2D g2d){
    g2d.drawImage(RedAmogus(),x,y,null);
    //g2d.draw(getRedBounds());
    if(redBozoDead){
        g2d.drawImage(ripRedBozo(),300,250,null);
        running++;
    }
    }
         int check = 0;
         int among = 0;
    public void update(){
     Random r = new Random();


     if(check == 0){among =r.nextInt(2);
     check = 1;
     }
             if(among == 1){
                 y=350;
                 
             }else{
                 y=450;
             }
        speedUpdates();
if(x <=  0 - 150){
x = 900+150;
Game.check=0;
check = 0;
}
x-=speed;
    }
    
    public Rectangle getRedBounds() {
		return new Rectangle(x, y, 100, 100);
	}
    
   public Image RedAmogus(){
   ImageIcon i = new ImageIcon(getClass().getResource("/images/Red.png"));
   return i.getImage();
   }
   
   public Image ripRedBozo(){
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
    

