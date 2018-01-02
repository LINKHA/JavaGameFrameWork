package pers.LINKH.Game.Compontent;

import pers.LINKH.Game.CollisionSystem;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.Log;

public class Collider  extends Collision {
	RectHitBox hitBox;
	GameObject gameObject;
	//碰撞该物体的碰撞体
	private  Collision collision = null;
	private  boolean isHit = false;
	
	boolean begainHit = false;
	boolean outHit = false;
	public Collider(GameObject gameObject){
		this.gameObject = gameObject;
		hitBox = new RectHitBox(gameObject.getPosition(),gameObject.getWidth()
				,gameObject.getHeight(),true);
		keyValue = gameObject.keyValue;
		CollisionSystem.getSystem().addCollider(this);
	}
	@Override
	public RectHitBox getHitBox() {
		return hitBox;
	}
	@Override
	public void begainHit() {
		begainHit = true;
	}
	@Override
	public void onHit(Collision collision) {
		isHit = true;
		this.collision = collision;
	}
	@Override
	public void releaseHit() {
		outHit = true;
		isHit = false;
		this.collision = null;
		
	}
	@Override
	public void move() {
		hitBox.move(gameObject.getPosition());
	}
	/*
	 * 控件开始发生碰撞
	 */
	public boolean onHit() {
		if(begainHit) {
			begainHit = false;
			return true;
		}
		return false;
	}
	/*
	 * 控件释放碰撞
	 */
	public boolean outHit() {
		if(outHit) {
			outHit = false;
			return true;
		}
		return false;
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
		if(isHit && collision!=null && tag == collision.tag) 
			return true;
		return false;
	}

	
}
