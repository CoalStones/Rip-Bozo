package input;
import java.util.Random;
import dinosaur.game.v3.objects.red;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class redController {
    
    static LinkedList<red> rc = new LinkedList<red>();
    
    red redEnemy;
    public redController(){

        addEnemy(new red(1000,450));
    }
       
    
    public void draw(Graphics2D g2d){
        for(int i=0; i<rc.size(); i++){
            redEnemy = rc.get(i);
            
            redEnemy.draw(g2d);
        }
    }
    
    public void update(){
        for(int i=0; i<rc.size(); i++){
            redEnemy = rc.get(i);
            
            redEnemy.update();
        }
    }
    
    public void addEnemy(red sus){
        rc.add(sus);
    }
    
    public static LinkedList<red> getRedBounds(){
        return rc;
    }
    
    
}
