package dinosaur.game.v3;

import dinosaur.game.v3.objects.tree;
import dinosaur.game.v3.objects.red;
import dinosaur.game.v3.objects.bush;
import dinosaur.game.v3.objects.Player;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import input.bushController;
import input.keyInput;
import input.redController;
import input.treeController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    Timer gameLoopTimer;
    Player p;
    public static int scoreCalc=0,displayScore=1;
    treeController t;
    redController red;
    bushController Bush;
   
    tree normal;
    red sus;
    bush dead;
    
    public Game(){

            setFocusable(true);
            gameLoopTimer=new Timer(10,this);
            gameLoopTimer.start();
            p=new Player(100,600);//the position of the player
            t=new treeController();
            red=new redController();
            Bush=new bushController();
            addKeyListener((KeyListener) new keyInput(p));
    }
   
    public void paint (Graphics graphic){
        super.paint(graphic); //how to draw graphics
            
        Graphics2D g2d = (Graphics2D) graphic;
 
        g2d.drawImage(backgroundImage(),0,0,this);

            p.draw(g2d);//calls the draw function in the player class to draw the player
            t.draw(g2d);//draws the enemy
            red.draw(g2d);
            Bush.draw(g2d);
            Font fnt0 = new Font("Arial", Font.BOLD,30);
            graphic.setFont(fnt0);
            graphic.setColor(Color.black);
            graphic.drawString("Current Score:"+displayScore, 50, 50);}

  
   
    public Image backgroundImage(){
      
            ImageIcon i=new ImageIcon(getClass().getResource("/images/background.png"));
            return i.getImage();
   
    }
     Random r = new Random();
   int c=0,rand;
public static int check = 0;
  
    @Override
    public void actionPerformed(ActionEvent e) { //actions performed after every tick from the gameLoopTimer variable
        
        
      
    c++;

if(check==0){
    
rand = r.nextInt(3);
check = 1;}
        repaint(); //calls the paint function to repaint every ideration of the gameLoopTimer       
        try {
            p.update(); //calling the update function in the player class to move the player 
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
       scoreCalc++;
       //System.out.println(scoreCalc);
        if(scoreCalc%7==0){
            displayScore++;
            
        } //score output
        switch(rand){
            case 0:
        t.update();
        
        break;
            case 1:
        red.update();
        break;
            case 2:
        Bush.update();
        break;
        }
        
        if((normal.bozoDead&&normal.running==1)||(sus.redBozoDead&&sus.running==1)||(dead.bushBozoDead&&dead.running==1)){
        try {
            Thread.sleep(3000);
            System.exit(0);
        } catch (InterruptedException ex) {
        }
            
        }
    }
    
  
    }

