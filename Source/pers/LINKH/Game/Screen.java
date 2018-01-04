package pers.LINKH.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import pers.LINKH.Game.Compontent.Compontent;
import pers.LINKH.Game.Compontent.GameObject;



public class Screen extends JPanel {
	
	/**
	 * °æ±¾ V1.0
	 */
	private static final long serialVersionUID = 1L;

	Application baseClass;
	private boolean fpsCounter = false;
	
	static List<GameObject> gameObjects = new ArrayList<GameObject>();
	
	
	
	public Screen(Application baseClass) {
		this.baseClass = baseClass;
	}
	public void setFpsCounter(boolean b) {
		fpsCounter = b;
	}
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		for(int i=0;i<gameObjects.size();i++) {
			gameObjects.get(i).paint(g);
		}		
		if(fpsCounter) {
			g.setColor(Color.black);
			g.drawString(baseClass.FPS + "", 20, 20);
		}

	}
	public static void addToScreen(GameObject gameObj) {

		if(gameObjects.size()==0) {
			gameObjects.add(gameObj);
			return;
		}

		
		int i=0;
		for(GameObject object : gameObjects) {
			
			if(object.layout.getValue()>=gameObj.layout.getValue()) {
				gameObjects.add(i, gameObj);
				return;
			}
			i++;
		}
		
		gameObjects.add(gameObj);
	}
	public static void deleteToScreen(int keyValue) {
		for(Compontent compontent : gameObjects) {
			if(keyValue==compontent.keyValue) {
				gameObjects.remove(compontent);
				return;
			}
		}
	}
}
