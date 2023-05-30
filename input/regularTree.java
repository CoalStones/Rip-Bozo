package input;

import dinosaur.game.v3.objects.Enemy;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class regularTree {

	static LinkedList<Enemy> f=new LinkedList<Enemy>();
	
	Enemy TempEnemy;
	
	public regularTree() {
		addEnemy(new Enemy(1000,420));
		/*addEnemy(new enemy(200,20));
		addEnemy(new enemy(300,30));
		addEnemy(new enemy(400,40));
		addEnemy(new enemy(500,50));
		addEnemy(new enemy(600,60));
		addEnemy(new enemy(700,70));*/
	}
	
	public void draw(Graphics2D g2d) {
		for(int count=0; count<f.size(); count++) {
			TempEnemy=f.get(count);
			TempEnemy.draw(g2d);
		}
	}
	
	public void update() {
		for(int i=0; i<f.size(); i++) {
			TempEnemy=f.get(i);
			
			/*if(TempEnemy.x<20) { //removes enemies
				removeEnemy(TempEnemy);
			}*/
			
			TempEnemy.update();
		}
	}
	
	public void addEnemy(Enemy enemy) {
		f.add(enemy);
	}
	public void removeEnemy(Enemy enemy) {
		f.remove(enemy);
	}
	
	public static LinkedList<Enemy> getEnemyBounds(){
		return f;
	}
}
