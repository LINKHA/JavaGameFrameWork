package pers.LINKH.Game.Tools;

import java.util.List;

import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Helper.Vector2;

public interface LKTween {
	 void move(float deltaX,float deltaY) ;
	 void move(Vector2 vec) ;
	 void moveTo(Vector2 position,float speed) ;
	 void moveAdd(Vector2 distance,float speed) ;
}
