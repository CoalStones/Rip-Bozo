package dinosaur.game.v3.objects;

import dinosaur.game.v3.globalPositioningSystem;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy extends globalPositioningSystem {
    
    int speed=5;
    public static boolean bozoDead=false;
    
    public Enemy(int x, int y){
        super(x,y);
    }
    
    public void update(){
        x+=speed;
        if(x>900-150){
            speed=-5;
        }
        if(x<0){
            speed=5;
        }
        
    }
    
    public void draw(Graphics2D g2d){
        g2d.drawImage(getEnemyImage(),x,y,null);
        if(bozoDead)g2d.drawImage(ripBozo(),x-50,y-75,null);
        
    }
    
    public Image getEnemyImage(){
        ImageIcon i = new ImageIcon(getClass().getResource("/images/tree.png"));
        return i.getImage();
    }
    
    public Rectangle getBounds() {
	return new Rectangle(x, y, 150, 150);
    }
    
    public Image ripBozo(){
        ImageIcon b = new ImageIcon(getClass().getResource("/images/RIPBOZO.png"));
        return b.getImage();
    }
    
}
