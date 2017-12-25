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


public class CollisionSystem implements FrameSystem {
	
	private static CollisionSystem instance;
	private  Map<String,Collision> colliders = new Hashtable<String,Collision>();
	private CollisionSystem(){}
	
	
	public  List<Collision[]> checkCollisions(){
		
		Iterator iter =colliders.entrySet().iterator();
		Iterator iterCheck =colliders.entrySet().iterator();
		List<Collision[]> collistions = new ArrayList<Collision[]>();
		Collision[] current = new Collider[2];

	
		while(iter.hasNext()) {
			 Map.Entry entry = (Map.Entry) iter.next();
			
			while(iterCheck.hasNext()) {
				 Map.Entry entryCheck = (Map.Entry) iterCheck.next();
				 
				
					current[0] = (Collision)entry.getValue();
					current[1] = (Collision)entryCheck.getValue();
			}
			if(current[0] .getHitBox().intersects(current[1].getHitBox())) {
				collistions.add(current);
			}
		}

		return collistions;
	}
	public void performCollistions() {
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
		colliders.put(collider.keyValue+"", collider);
	}
	public void deleteCollider(int keyValue) {
		colliders.remove(keyValue+"");
	}
	
	public static CollisionSystem getSystem() {
		if(instance==null) {
			instance = new CollisionSystem();
		}
		return instance;
	}
}
	
	