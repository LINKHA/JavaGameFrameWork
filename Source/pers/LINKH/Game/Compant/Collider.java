package pers.LINKH.Game.Compant;

import java.awt.Image;
import pers.LINKH.Game.CollisionSystem;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.Log;

public class Collider  extends Collision {
	RectHitBox hitBox;
	GameObject gameObject;
	private  Collision collision = null;
	private  boolean isHit = false;
	
	public Collider(GameObject gameObject){
		this.gameObject = gameObject;
		hitBox = new RectHitBox(gameObject.getPosition(),gameObject.getWidth()
				,gameObject.getHeight(),true);
		CollisionSystem.getSystem().addCollider(this);
	}
	@Override
	public RectHitBox getHitBox() {
		return hitBox;
	}
	@Override
	public void begainHit() {
		// TODO Auto-generated method stub
		Log.Print("begainHit");
	}
	@Override
	public void onHit(Collision collision) {
		//Log.Print(isHit);
		isHit = true;
		this.collision = collision;
		
		//Log.Print("hit");
		
	}
	@Override
	public void releaseHit() {
		
		isHit = false;
		this.collision = null;
		Log.Print("releaseHit");
		
	}
	@Override
	public void move() {
		hitBox.move(gameObject.getPosition());
	}
	
	/*
	 * 控件是否发生碰撞
	 */
	@Override
	public  Boolean isHit() {
		return isHit;
	}
	/*
	 * 控件碰撞对象
	 */
	@Override
	public  Collision getHit() {
		return collision;
	} 
	/*
	 * 判断是否碰撞Tag为tag的碰撞体
	 */
	@Override
	public boolean hit(Tag tag) {
		if(isHit==true) {
			Log.Print(isHit," ");
		}
		if(isHit && collision!=null && tag == collision.tag) 
			return true;
		return false;
	}

	
}
