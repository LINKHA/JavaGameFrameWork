package pers.LINKH.Game.Compontent;

import pers.LINKH.Game.CollisionSystem;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.Log;

public class Collider  extends Collision {
	RectHitBox hitBox;
	GameObject gameObject;
	//��ײ���������ײ��
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
	@Override
	public  Collision getHit() {
		return collision;
	} 
	/*
	 * �ж��Ƿ���ײTagΪtag����ײ��
	 */
	@Override
	public boolean hit(Tag tag) {
		if(isHit && collision!=null && tag == collision.tag) 
			return true;
		return false;
	}

	
}
