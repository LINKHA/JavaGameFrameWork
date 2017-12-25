package pers.LINKH.Game.Compant;

import pers.LINKH.Game.CollisionSystem;

public abstract class Collision extends Compant {
	public abstract RectHitBox getHitBox();
	public abstract void onHit(Collision collision);
	public abstract void move();
	@Override
	public void Destroy() {
		CollisionSystem.getSystem().deleteCollider(keyValue);
	}
}
