package dinosaur.game.v3.objects;

import dinosaur.game.v3.Game;

import static dinosaur.game.v3.Game.displayScore;
import dinosaur.game.v3.globalPositioningSystem;
import input.bushController;
import input.redController;
import input.treeController;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.*;
public class Player extends globalPositioningSystem{
    
    boolean left,right,up,down;
    boolean jumped=false;
    int velX=0,velY=0,gravity=1,drawded=0;
    int deadCount=0;
    
    Game g;
    treeController t;
    redController rc;
    bushController bc;
    
    private LinkedList<tree> EL = treeController.getEnemyBounds();
    private LinkedList<red> RL = redController.getRedBounds();
    private LinkedList<bush> BL = bushController.getBushBounds();
    
    public Player(int x,int y){
        super(x, y);
    }
    
    public void update() throws InterruptedException{ //updates to the player
     
        deadCount++;
        velY+=gravity;
        y+=velY;
        x+=velX;
        if(y>600-190){
            y=600-190;
            jumped=false;
        }
        if(y<0){
            y=0;
        }
        if(x>900-115){
            x=900-115;
        }
        if(x<0){
            x=0;
        }
        
        
        Collision();
        if(deadCount==120){
            tree.bozoDead=false;
            bush.bushBozoDead=false;
            red.redBozoDead=false;
            deadCount=0;
        }
    }
    
    public Rectangle getBounds() {
		return new Rectangle(x+5, y, 110, 100);
	}
    public Rectangle getBounds2() {
		return new Rectangle(x, y+70, 150, 75);
	}
     
    public void Collision() throws InterruptedException {
        
   
   
            if(down == false){
                    for(int i=0; i<EL.size(); i++) {
                            if(getBounds().intersects(EL.get(i).getTreeBounds())) {
                                    tree.bozoDead=true;
                            }
                            if(getBounds().intersects(RL.get(i).getRedBounds())){
                                    red.redBozoDead=true;
                            }
                            if(getBounds().intersects(BL.get(i).getBushBounds())){
                                    bush.bushBozoDead=true;
                            }
                    }
            }else{
                 for(int i=0; i<EL.size(); i++) {
                            if(getBounds2().intersects(EL.get(i).getTreeBounds())) {
                                    tree.bozoDead=true;
                            }
                            if(getBounds2().intersects(RL.get(i).getRedBounds())){
                                    red.redBozoDead=true;                               
                            }
                            if(getBounds2().intersects(BL.get(i).getBushBounds())){
                                    bush.bushBozoDead=true;
                            }
            }
	}
    }
   
    public void keyPressed(KeyEvent k) {//sets boolean of where you're moving to true depending on which buttons are pressed
        int key=k.getKeyChar();
        
        if((key == 'w'||key=='W')&&!jumped){
            up = true;
            velY=-25;
            jumped=true;
        }
        else if(key == 'a'||key=='A'){
            left = true;
            velX=-5;
        }
        else if(key == 's'||key=='S'){
            down = true;
            velY=15;
        }
        else if(key == 'd'||key=='D'){
            right = true;
            velX=5;
        }
    }

    public void keyReleased(KeyEvent k) {//sets boolean of where you're moving to false depending on which buttons are released
        int key=k.getKeyChar();
        
        if(key == 'w'||key=='W'){
            up = false;
            //velY=0;
        }
        else if(key == 'a'||key=='A'){
            left = false;
            velX=0;
        }
        else if(key == 's'||key=='S'){
            down = false;
            velY=0;
        }
        else if(key == 'd'||key=='D'){
            right = false;
            velX=0;
        }
    }
    
    public void draw(Graphics2D g2d){
        if(down == false){
            if(tree.bozoDead||red.redBozoDead||bush.bushBozoDead){
                g2d.drawImage(playerDeath(),x,y,null);
            }
            else if(left == true || right == true && right == false || left == false && displayScore%2 == 0 && down == false ){
            g2d.drawImage(playerRunfront(), x, y, null);
            }
            else if(left == false || right == false && left == false || right == false && displayScore%2 != 0 && down == false){
                g2d.drawImage(playerRunback(), x, y, null);
            }
        }
        
        if(down == true){
            if(left == true || right == true && right == false || left == false && displayScore%2 == 0 && down == true ){
            g2d.drawImage(playerDuckfront(), x, y+70, null);
            }
           else if(left == false || right == false && left == false || right == false && displayScore%2 != 0 && down == true){
                g2d.drawImage(playerDuckback(), x, y+70, null);
            }
        }
    }
    
    public Image playerRunfront(){
        ImageIcon i=new ImageIcon(getClass().getResource("/images/runningFrontFoot.png"));
        
        return i.getImage();
    }
    public Image playerRunback(){
        ImageIcon i=new ImageIcon(getClass().getResource("/images/runningBackFoot.png"));
        
        return i.getImage();
    }
     public Image playerDuckfront(){
        ImageIcon i=new ImageIcon(getClass().getResource("/images/DuckingSprite.png"));
        
        return i.getImage();
    }
      public Image playerDuckback(){
        ImageIcon i=new ImageIcon(getClass().getResource("/images/duckBackFoot.png"));
        
        return i.getImage();
    }
       public Image playerDeath(){
        ImageIcon i=new ImageIcon(getClass().getResource("/images/dead.png"));
        
        return i.getImage();
    }
     
}
