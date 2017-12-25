package pers.LINKH.Game.Compant;

import pers.LINKH.Game.CollisionSystem;
import pers.LINKH.Game.Setting.Setting;
import pers.LINKH.Game.Tools.Log;

public abstract class Collision extends Compant {
	public abstract RectHitBox getHitBox();
	public abstract void onHit(Collision collision);
	public abstract void move();
	Collision(){
		Setting.ObjectKey--;
		keyValue = Setting.ObjectKey-1;
	}
	@Override
	public void Destroy() {
		//Log.Print(("delete  Destroy"+keyValue));
		CollisionSystem.getSystem().deleteCollider(keyValue);
	}
}
