package dinosaur.game.v3;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends javax.swing.JFrame {
    public static void main(String[] args){
        
        JFrame panel=new JFrame("RIP BOZO 1.0");
        panel.pack();
        panel.setSize(900,600);
        panel.setResizable(false);
        panel.setLocationRelativeTo(null);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(new Game());
        panel.setVisible(true);
         
    
    }

   
}
