package pers.LINKH.TimeScript;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.Animator;
import pers.LINKH.Game.Compontent.Collider;
import pers.LINKH.Game.Compontent.Collision;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Compontent.UI.Button;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.LKTimer;
import pers.LINKH.Game.Tools.LoadAnimation;
import pers.LINKH.Scripts.Peashooter;
import pers.LINKH.Scripts.Plant;
import pers.LINKH.Scripts.SunFlower;
import pers.LINKH.Scripts.SunManager;
import pers.LINKH.Scripts.Zombie;

public class PlantManager extends ScriptSuper {

	public static List<Peashooter> Peashooters = new ArrayList<Peashooter>();
	public static List<SunFlower> sunFlowers = new ArrayList<SunFlower>();
	public static List<Plant> plants = new ArrayList<Plant>();
	
	
	private List<GameObject> shells = new ArrayList<GameObject>();
	private List<GameObject> suns = new ArrayList<GameObject>();
	
	LKTimer aLkTimer=new LKTimer(2000, 0);
	LKTimer sLkTimer=new LKTimer(20000, 0);
	@Override
	public void Init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RunLoop() {
		boolean aTime = aLkTimer.timer();
		boolean sTime = sLkTimer.timer();
		if(sunFlowers.size()!=0) {
			if(sTime) {
				for(SunFlower s : sunFlowers) {
					if(aTime) {
						GameObject sun = new GameObject( new Vector2(s.gameObject.getPosition().x+50,s.gameObject.getPosition().y-50)  ,  80, 80);
						sun.addSprite(new Sprite("Assets/PB.png",sun));
						sun.addAnimator(new Animator( LoadAnimation.load("Assets/Sun/Sun0",".png", 1, 22),4, sun));
						sun.addButton(new Button(sun));
						suns.add(sun);
					}
				}
			}
		}
		if(suns.size()!=0) {
			for(GameObject s :suns ) {
				if(s.getButton().mouseDown()) {
					SunManager.flashSunValue(50);
					s.Destroy();
					suns.remove(s);
					break;
				}
			}
		}
		
		if(Peashooters.size()!=0) {
			//得到豌豆射手垂直位置
			int Hortarial;
			for(Peashooter p : Peashooters) {
				Hortarial = (int) ((p.gameObject.getPosition().y-230)/180.0f);
				if(aTime && ZombieManager.areaZombiesSize[Hortarial]!=0) {
					//发射炮弹
					GameObject shell = new GameObject(new Vector2(p.gameObject.getPosition().x+15 , p.gameObject.getPosition().y-35) ,  80, 50);
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
						Peashooters.remove(p);
						plants.remove(p);
						p.gameObject.Destroy();
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
