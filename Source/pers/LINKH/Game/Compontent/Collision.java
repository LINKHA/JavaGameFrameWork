package pers.LINKH.Game.Compontent;

import pers.LINKH.Game.CollisionSystem;
import pers.LINKH.Game.Setting.Setting;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.Log;

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
	
	
	Collision(){
		Setting.ObjectKey--;
		keyValue = Setting.ObjectKey-1;
	}
	@Override
	public void Destroy() {
		CollisionSystem.getSystem().deleteCollider(keyValue);
	}
}
