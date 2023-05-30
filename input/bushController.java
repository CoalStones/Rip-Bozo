package input;

import dinosaur.game.v3.objects.bush;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class bushController {
    
    static LinkedList<bush> be = new LinkedList<bush>();
    
    bush bushEnemy;
    
    public bushController(){
        addEnemy(new bush(1000,475));
    }
    
    public void draw(Graphics2D g2d){
        for(int i=0; i<be.size(); i++){
            bushEnemy = be.get(i);
            
            bushEnemy.draw(g2d);
        }
    }
    
    public void update(){
        for(int i=0; i<be.size(); i++){
            bushEnemy = be.get(i);
            
            bushEnemy.update();
        }
    }
    
    public void addEnemy(bush enemy){
        be.add(enemy);
    }
    
    public static LinkedList<bush> getBushBounds(){
        return be;
    }
    
    
}
