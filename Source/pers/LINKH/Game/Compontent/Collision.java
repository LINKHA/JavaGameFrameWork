package pers.LINKH.Game.Compontent;

import pers.LINKH.Game.CollisionSystem;
import pers.LINKH.Game.Setting.Setting;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.Log;

public abstract class Collision extends Compontent {
	public abstract RectHitBox getHitBox();
	/*
	 * 发生碰撞调用此方法
	 * 瞬时响应
	 */
	public abstract void begainHit();
	/*
	 * 发生碰撞调用此方法
	 * 即时响应
	 */
	public abstract void onHit(Collision collision);
	/*
	 * 释放碰撞时调用此方法
	 * 瞬时响应
	 */
	public abstract void releaseHit();
	/*
	 * GameObject调用move()时调用此方法
	 * 即时响应
	 */
	public abstract void move();
	/*
	 * 控件是否发生碰撞
	 */
	public abstract  Boolean isHit() ;
	/*
	 * 控件碰撞对象
	 */
	public abstract  Collision getHit();
	/*
	 * 判断是否碰撞Tag为tag的碰撞体
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
