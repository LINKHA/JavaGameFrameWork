package pers.LINKH.Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pers.LINKH.Game.Compant.Collider;
import pers.LINKH.Game.Compant.Collision;
import pers.LINKH.Game.Tools.Log;

class ColliderMessage{
	public int keyValue;
	public Collision collider;
	public boolean bHit;
	ColliderMessage(int keyValue,Collision collider){
		this.keyValue = keyValue;
		this.collider = collider;
		this.bHit = false;
	}
}


public class CollisionSystem implements FrameSystem {
	
	private static CollisionSystem instance;
	private List <ColliderMessage> colliders = new ArrayList<ColliderMessage>();
	private CollisionSystem(){}
	
	
	public  List<ColliderMessage[]> checkCollisions(){
		List<ColliderMessage[]> collistions = new ArrayList<ColliderMessage[]>();
		if(colliders.size()==1) {
			return collistions;
		}
		//判断碰撞体是否在遍历后有碰撞
		boolean s = false;
		ColliderMessage[] current = new ColliderMessage[2];
		for(ColliderMessage c : colliders) {
			s = false;
			for(ColliderMessage k : colliders) {
				if(c.keyValue!=k.keyValue) {
					current[0] =c;
					current[1] =k;
					if(current[0].collider.getHitBox().intersects(current[1].collider.getHitBox())) {
						if(c.bHit==false) {
							c.collider.begainHit();
						}
						if(k.bHit==false) {
							k.collider.begainHit();
						}
						c.bHit = true; k.bHit=true;
						s = true;
						collistions.add(current);
					}
				}
			}
			//碰撞体遍历后无碰撞
			if(c.bHit==true && s==false) {
				c.bHit = false;
				c.collider.releaseHit();
			}
		}
		return collistions;
	}
	public void performCollistions() {
		if(checkCollisions().size()==0) {
			return;
		}
		for(ColliderMessage[] current:checkCollisions()) {
			current[0].collider.onHit(current[1].collider);
			current[1].collider.onHit(current[0].collider);
		}
	}
	@Override
	public void addSystemInit() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addSystemRunLoop() {
		// TODO Auto-generated method stub
		checkCollisions();
		performCollistions();
	}
	@Override
	public void addSystemDestruction() {
		// TODO Auto-generated method stub
		
	}
	

	public   void addCollider(Collision collider) {
		
		//遍历  检查是否有重复
		for(ColliderMessage checkValue : colliders) {
			if(checkValue.keyValue == collider.keyValue) {
				Log.Print("Fail to add Collider");
				return;
			}
		}
		
		colliders.add(new ColliderMessage(collider.keyValue,collider));
		
		
	}
	public void deleteCollider(int keyValue) {
		Log.Print(("deleteCollider "+keyValue));
		
		//遍历  查找到keyValue
		for(ColliderMessage checkValue : colliders) {
			if(checkValue.keyValue == keyValue) {
				colliders.remove(checkValue);
				return;
			}
		}
		//colliders.remove(keyValue+"");
	}
	
	public static CollisionSystem getSystem() {
		if(instance==null) {
			instance = new CollisionSystem();
		}
		return instance;
	}
}
	
	