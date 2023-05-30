package input;


import dinosaur.game.v3.Game;
import dinosaur.game.v3.objects.Player;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyInput extends KeyAdapter{
    
    Player p;
    Game g;
    
    public keyInput(Player p){
        this.p=p;
    }
    
    
    @Override
    public void keyPressed(KeyEvent k){
        p.keyPressed(k);
    }
    
    @Override
    public void keyReleased(KeyEvent k){
        p.keyReleased(k);
    }

  
  
}
