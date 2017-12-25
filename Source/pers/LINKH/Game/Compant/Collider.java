package pers.LINKH.Game.Compant;

import java.awt.Image;

import pers.LINKH.Game.CollisionSystem;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Tools.Log;

public class Collider  extends Collision {
	RectHitBox hitBox;
	GameObject gameObject;
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
	public void onHit(Collision collision) {
		Log.Print("hit");
	}
	@Override
	public void move() {
		hitBox.move(gameObject.getPosition());
		//Log.Print(gameObject.getPosition()," ",hitBox.getPosition());
	}
}
