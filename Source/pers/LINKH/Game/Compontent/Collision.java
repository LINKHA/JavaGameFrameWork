package pers.LINKH.Game.Compontent;

import pers.LINKH.Game.CollisionSystem;
import pers.LINKH.Game.Setting.Tag;

public abstract class Collision extends Compontent {
	public abstract RectHitBox getHitBox();
	/*
	 * ������ײ���ô˷���
	 * ˲ʱ��Ӧ
	 */
	public abstract void begainHit();
	/*
	 * ������ײ���ô˷���
	 * ��ʱ��Ӧ
	 */
	public abstract void onHit(Collision collision);
	/*
	 * �ͷ���ײʱ���ô˷���
	 * ˲ʱ��Ӧ
	 */
	public abstract void releaseHit();
	/*
	 * GameObject����move()ʱ���ô˷���
	 * ��ʱ��Ӧ
	 */
	public abstract void move();
	/*
	 * �ؼ��Ƿ�����ײ
	 */
	public abstract  Boolean isHit() ;
	/*
	 * �ؼ���ײ����
	 */
	public abstract  Collision getHit();
	/*
	 * �ж��Ƿ���ײTagΪtag����ײ��
	 */
	public abstract boolean hit(Tag tag) ;
	
	@Override
	public void Destroy() {
		CollisionSystem.getSystem().deleteCollider(keyValue);
	}
}
