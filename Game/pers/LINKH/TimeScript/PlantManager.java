package pers.LINKH.TimeScript;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.Collider;
import pers.LINKH.Game.Compontent.Collision;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.LKTimer;
import pers.LINKH.Game.Tools.Log;
import pers.LINKH.Game.Tools.Random;
import pers.LINKH.Scripts.GameMap;
import pers.LINKH.Scripts.MapStruct;
import pers.LINKH.Scripts.Peashooter;
import pers.LINKH.Scripts.Plant;
import pers.LINKH.Scripts.SunFlower;
import pers.LINKH.Scripts.Zombie;

public class PlantManager extends ScriptSuper {

	public static List<Peashooter> Peashooters = new ArrayList<Peashooter>();
	public static List<Plant> plants = new ArrayList<Plant>();
	
	
	private List<GameObject> shells = new ArrayList<GameObject>();
	
	LKTimer aLkTimer=new LKTimer(1000, 0);
	@Override
	public void Init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RunLoop() {
		boolean aTime = aLkTimer.timer();

		if(Peashooters.size()!=0) {
			//得到豌豆射手垂直位置
			int Hortarial;
			for(Peashooter p : Peashooters) {
				Hortarial = (int) ((p.gameObject.getPosition().y-230)/180.0f);
				if(aTime && ZombieManager.areaZombiesSize[Hortarial]!=0) {
					//发射炮弹
					GameObject shell = new GameObject(p.gameObject.getPosition() ,  80, 50);
					shell.addSprite(new Sprite("Assets/PB.png",shell));
					shell.addCollider(new Collider(shell));
					shells.add(shell);
				}
			}
		}
		
		if(shells.size()!=0) {
			for(GameObject shell : shells) {
				
				//如果碰到Enemy Destory 改变Sprite    PeaBullHit
				//得到的Zombie Hp--
				shell.move(5.0f,0);
				if(shell.getCollision().hit(Tag.Enemy)) {
					shells.remove(shell);
					for(Zombie  z : ZombieManager.Zombies) {
						for(Collision c : shell.getCollision().getHit()) {
							if(c.keyValue==z.keyValue) {
								z.hp-=10;
								break;
							}
						}
					}
					shell.Destroy();
					break;
				}
			}
		}
		
		
		if(plants.size()!=0 && aTime) {
			for(Plant p : plants) {
				if(p.gameObject.getCollision().hit(Tag.Enemy)) {
					p.hp-=10;
					if(p.hp<=0) {
						p.gameObject.Destroy();
						plants.remove(p);
						p.mapStruct.isOn=false;
						
						break;
					}
				}
			}
		}
		
		
		
		
		
	}

	@Override
	public void Destruction() {
		// TODO Auto-generated method stub
		
	}

}
