package pers.LINKH.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;
import pers.LINKH.Game.Compontent.Compontent;

public class Screen extends JPanel {
	
	/**
	 * °æ±¾ V1.0
	 */
	private static final long serialVersionUID = 1L;

	private static Screen instance;
	
	Application baseClass;
	private boolean fpsCounter = false;
	static Map<Integer, Compontent> controls = new Hashtable<Integer, Compontent>() ;
	
	
	
	
	public Screen(Application baseClass) {
		this.baseClass = baseClass;
	}
	public void setFpsCounter(boolean b) {
		fpsCounter = b;
	}
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		Iterator iter =controls.entrySet().iterator();
		
		while(iter.hasNext()) {
			  Map.Entry entry = (Map.Entry) iter.next();
			 ((PaintcControl) entry.getValue()).paint(g);
		}
		
		
		if(fpsCounter) {
			g.setColor(Color.black);
			g.drawString(baseClass.FPS + "", 20, 20);
		}

	}
	public static void addToScreen(Compontent gameObj) {
		controls.put(gameObj.keyValue,gameObj);
	}
	public static void deleteToScreen(int keyValue) {
		controls.remove(keyValue);
	}
}
