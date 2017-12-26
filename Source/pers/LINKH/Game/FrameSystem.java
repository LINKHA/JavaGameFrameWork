package pers.LINKH.Game;

import pers.LINKH.Game.Helper.Vector2;

public interface FrameSystem {
	public void addSystemInit();
	public void addSystemRunLoop();
	public void addSystemDestruction();
	public  void addSystemKeyPressed() ;
	public  void addSystemKeyReleased() ;
	public  void addSystemMousePressed() ;
	public  void addSystemMouseReleased() ;
	public  void addSystemMouseMoved() ;
	public  void addSystemMouseDragged();
	public  void addSystemMouseClicked();
}
