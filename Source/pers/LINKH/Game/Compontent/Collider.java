package pers.LINKH.Game.Compontent;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.CollisionSystem;
import pers.LINKH.Game.Setting.Tag;

public class Collider  extends Collision {
	RectHitBox hitBox;
	GameObject gameObject;
	//碰撞该物体的碰撞体
	//private  Collision collision = null;
	private  List<Collision> collisions = new ArrayList<Collision>();
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
		//this.collision = collision;
		for(Collision c : collisions){
			if(c.keyValue==collision.keyValue) {
				return;
			}
		}
		collisions.add(collision);
	}
	@Override
	public void releaseHit() {
		outHit = true;
		isHit = false;
		this.collisions.clear();
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
	public List<Collision> getHit() {
		return collisions;
	} 
	/*
	 * 判断是否碰撞Tag为tag的碰撞体
	 */
	@Override
	public boolean hit(Tag tag) {
		if(isHit &&collisions.size()!=0) {
			for(Collision c : collisions) {
				if(c.tag==tag) {
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public  void clear() {
		collisions.clear();
	}
}
