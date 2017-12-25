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
		if(colliders.size()<=1) {
			return collistions;
		}
		//判断碰撞体是否在遍历后有碰撞
		boolean s = false;
		//ColliderMessage[] current = new ColliderMessage[2];

		for(int i = 0; i < colliders.size() ; i++) {
			s = false;
			for(int n = 0; n < colliders.size(); n++) {
				ColliderMessage[] current = new ColliderMessage[2];
				current[0] = colliders.get(i);
				current[1] = colliders.get(n);
				if(current[0] .collider.getHitBox().intersects(current[1] .collider.getHitBox())) {
					if(i!=n) {
						if(colliders.get(i).bHit==false) {
							colliders.get(i).collider.begainHit();
						}
						if(colliders.get(n).bHit==false) {
							colliders.get(n).collider.begainHit();
						}
						colliders.get(i).bHit = true; colliders.get(n).bHit=true;
						s = true;
						collistions.add(current);
					}
				}
			}
			if(colliders.get(i).bHit==true && s==false) {
				colliders.get(i).bHit = false;
				colliders.get(i).collider.releaseHit();
			}
		}
		/*
		for(int i = 0; i < colliders.size() ; i++) {
			s = false;
			for(int n = i + 1; n < colliders.size(); n++) {
				ColliderMessage[] current = new ColliderMessage[2];
				current[0] = colliders.get(i);
				current[1] = colliders.get(n);
				if(current[0] .collider.getHitBox().intersects(current[1] .collider.getHitBox())) {
					if(colliders.get(i).bHit==false) {
						colliders.get(i).collider.begainHit();
					}
					if(colliders.get(n).bHit==false) {
						colliders.get(n).collider.begainHit();
					}
					colliders.get(i).bHit = true; colliders.get(n).bHit=true;
					s = true;
					collistions.add(current);
				}
			}
			if(colliders.get(i).bHit==true && s==false) {
				colliders.get(i).bHit = false;
				colliders.get(i).collider.releaseHit();
			}
		}*/
		
		/*for(ColliderMessage c : colliders) {
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
		}*/
		return collistions;
	}
	public void performCollistions() {
		if(colliders.size()<=1) {
			return;
		}
		for(ColliderMessage[] current:checkCollisions()) {
//			Log.Print("Print"+current[0].keyValue);
//			Log.Print("Print"+current[1].keyValue);
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
		//checkCollisions();
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
	
	