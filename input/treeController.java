package input;

import dinosaur.game.v3.objects.tree;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class treeController {

	static LinkedList<tree> f=new LinkedList<tree>();
	
	tree treeEnemy;
	
	public treeController() {
		addEnemy(new tree(1000,420));
	}
	
	public void draw(Graphics2D g2d) {
		for(int count=0; count<f.size(); count++) {
			treeEnemy=f.get(count);
			treeEnemy.draw(g2d);
		}
	}
	
	public void update() {
		for(int i=0; i<f.size(); i++) {
			treeEnemy=f.get(i);
			
			/*if(TempEnemy.x<20) { //removes enemies
				removeEnemy(TempEnemy);
			}*/
			
			treeEnemy.update();
		}
	}
	
	public void addEnemy(tree enemy) {
		f.add(enemy);
	}
	public void removeEnemy(tree enemy) {
		f.remove(enemy);
	}
	
	public static LinkedList<tree> getEnemyBounds(){
		return f;
	}
}
