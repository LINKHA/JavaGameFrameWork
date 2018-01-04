package pers.LINKH.Game.Compontent;

import java.util.List;

import pers.LINKH.Game.CollisionSystem;
import pers.LINKH.Game.Setting.Tag;

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
	 * 释放所有碰撞时调用此方法
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
	public abstract  List<Collision> getHit();
	/*
	 * 判断是否碰撞Tag为tag的碰撞体
	 */
	public abstract boolean hit(Tag tag) ;
	/*
	 * 清空碰撞体
	 */
	public abstract void clear() ;
	@Override
	public void Destroy() {
		CollisionSystem.getSystem().deleteCollider(keyValue);
	}
}
