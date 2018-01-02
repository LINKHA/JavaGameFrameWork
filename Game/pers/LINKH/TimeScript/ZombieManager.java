package pers.LINKH.TimeScript;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Scripts.Zombie;

public class ZombieManager extends ScriptSuper {
	public static List<Zombie> Zombies = new ArrayList<Zombie>();
	public static int[] areaZombiesSize = new int[5];
	
	
	@Override
	public void Init() {
		areaZombiesSize[0]=0;
		areaZombiesSize[1]=0;
		areaZombiesSize[2]=0;
		areaZombiesSize[3]=0;
		areaZombiesSize[4]=0;
	}

	@Override
	public void RunLoop() {
		if(Zombies.size()!=0) {
			for(Zombie z : Zombies) {
				z.gameObject.move(-0.2f,0);
			}
		}
		
	}

	@Override
	public void Destruction() {
		// TODO Auto-generated method stub
		
	}

	
}
