package pers.LINKH.Game.Operate;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import pers.LINKH.Game.Application;
import pers.LINKH.Game.Helper.Vector2;

public class Input implements KeyListener, MouseListener,MouseMotionListener{
	private static boolean[] keys = new boolean[300];
	private static Vector2 MouseLocation = new Vector2();
	
	Application baseClass;
	static boolean leftMouseDown = false;
	static boolean rightMouseDown = false;
	
	private static boolean hitMouse = false;
	private static boolean releasedMouse = false;
	public Input(Application baseClass) {
		this.baseClass = baseClass;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		baseClass.mouseDragged();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		MouseLocation.x =e.getX();
		MouseLocation.y =e.getY();
		baseClass.mouseMoved(MouseLocation);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		baseClass.mouseClicked();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		hitMouse = true;
		if(e.isMetaDown()) {
			rightMouseDown = true;
			baseClass.MousePressed(1);
		}
		else {
			leftMouseDown = true;
			baseClass.MousePressed(0);
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		releasedMouse = true;
		if(e.isMetaDown()) {
			rightMouseDown = false;
			baseClass.MouseReleased(1);
		}
		else {
			leftMouseDown = false;
			baseClass.MouseReleased(0);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		baseClass.keyPressed(e.getKeyCode());

	}
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		baseClass.keyReleased(e.getKeyCode());
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////
//暴露给应用层的接口
//类:Input
/////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean getButtonDown(int indexKey){
		if(keys[indexKey] == true) {
			return true;
		}
		return false;
	}
	public static boolean leftMouseDown() {
		return leftMouseDown;
	}
	public static boolean rightMouseDown() {
		return rightMouseDown;
	}
	public static Vector2 getMouseLocation() {
		return MouseLocation;
	}
	public static boolean hitMouse() {
		if(hitMouse) {
			hitMouse = false;
			return true;
		}
		return false;
	}
	public static boolean releasedMouse() {
		if(releasedMouse) {
			releasedMouse = false;
			return true;
		}
		return false;
	}
}
