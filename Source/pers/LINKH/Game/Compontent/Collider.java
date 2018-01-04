package pers.LINKH.Game.Compontent;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.CollisionSystem;
import pers.LINKH.Game.Setting.Tag;

public class Collider  extends Collision {
	RectHitBox hitBox;
	GameObject gameObject;
	//��ײ���������ײ��
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
	 * �ؼ���ʼ������ײ
	 */
	public boolean onHit() {
		if(begainHit) {
			begainHit = false;
			return true;
		}
		return false;
	}
	/*
	 * �ؼ��ͷ���ײ
	 */
	public boolean outHit() {
		if(outHit) {
			outHit = false;
			return true;
		}
		return false;
	}
	/*
	 * �ؼ��Ƿ�����ײ
	 */
	@Override
	public  Boolean isHit() {
		return isHit;
	}
	/*
	 * �ؼ���ײ����
	 */
	public List<Collision> getHit() {
		return collisions;
	} 
	/*
	 * �ж��Ƿ���ײTagΪtag����ײ��
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
