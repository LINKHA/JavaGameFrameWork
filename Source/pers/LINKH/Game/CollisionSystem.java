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
	ColliderMessage(int keyValue,Collision collider){
		this.keyValue = keyValue;
		this.collider = collider;
	}
}


public class CollisionSystem implements FrameSystem {
	
	private static CollisionSystem instance;
	//private  Map<String,Collision> colliders = new Hashtable<String,Collision>();
	private List <ColliderMessage> colliders = new ArrayList<ColliderMessage>();
	private CollisionSystem(){}
	
	
	public  List<Collision[]> checkCollisions(){
		List<Collision[]> collistions = new ArrayList<Collision[]>();
		if(colliders.size()==1) {
			return collistions;
		}
		Collision[] current = new Collider[2];
		for(ColliderMessage c : colliders) {
			for(ColliderMessage k : colliders) {
				if(c.keyValue!=k.keyValue) {
					current[0] =c.collider;
					current[1] =k.collider;
					if(current[0].getHitBox().intersects(current[1].getHitBox())) {
						collistions.add(current);
					}
				}
			}
		}
		return collistions;
	}
	public void performCollistions() {
		if(checkCollisions().size()==0) {
			return;
		}
		for(Collision[] current:checkCollisions()) {
			current[0].onHit(current[1]);
			current[1].onHit(current[0]);
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
		Log.Print("add Colloder "+collider.keyValue);
		//colliders.put(collider.keyValue+"", collider);
		
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
	
	