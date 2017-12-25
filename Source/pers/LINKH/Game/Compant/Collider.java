package pers.LINKH.Game.Compant;

import java.awt.Image;
import pers.LINKH.Game.CollisionSystem;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.Log;

public class Collider  extends Collision {
	RectHitBox hitBox;
	GameObject gameObject;
	//��ײ���������ײ��
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
		
	}
	@Override
	public void onHit(Collision collision) {
		isHit = true;
		this.collision = collision;
	}
	@Override
	public void releaseHit() {
		
		isHit = false;
		this.collision = null;
		
	}
	@Override
	public void move() {
		hitBox.move(gameObject.getPosition());
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
