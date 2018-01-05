package pers.LINKH.TimeScript;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.Animator;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Helper.ScreenSize;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.LoadAnimation;
import pers.LINKH.Scripts.Zombie;

public class ZombieManager extends ScriptSuper {
	public static List<Zombie> Zombies = new ArrayList<Zombie>();
	public static int[] areaZombiesSize = new int[5];
	
	private boolean zombieWin = false;
	
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
		areaZombiesSize[0]=0;
		areaZombiesSize[1]=0;
		areaZombiesSize[2]=0;
		areaZombiesSize[3]=0;
		areaZombiesSize[4]=0;
		if(Zombies.size()!=0) {
			
			for(Zombie z : Zombies) {
				int Hortarial = (int) ((z.gameObject.getPosition().y-210)/180.0f);
				areaZombiesSize[Hortarial]++;
			}
		}
		
		
		
		if(Zombies.size()!=0) {
			for(Zombie z : Zombies) {
				if(z.hp<=0) {
					
					z.gameObject.Destroy();
					
					Zombies.remove(z);
					break;
				}
				if(z.gameObject.getCollision().hit(Tag.Player)) {
					
					if(!z.isAttack) {
						z.isAttack = true;
						z.gameObject.getAnimator().Destroy();
						z.gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/ZombieAttack/ZombieAttack0",".png", 1, 21),10,  z.gameObject));
					}
				}else {
					if(z.isAttack) {
						z.isAttack = false;
						z.gameObject.getAnimator().Destroy();
						switch (z.type) {
						case 0:
							z.gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/Zombie/Zombie0",".png", 1, 22),10,  z.gameObject));
							break;
						case 1:
							z.gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/Zombie2/Zombie20",".png", 1, 31),10,  z.gameObject));
							break;
						case 2:
							z.gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/Zombie3/Zombie30",".png", 1, 18),15,  z.gameObject));
							break;
						}
					}
					z.gameObject.move(-0.15f,0);
				}
			}
		}
		if(Zombies.size()!=0) {
			for(Zombie z : Zombies) {
				if(!zombieWin && z.gameObject.getPosition().x<=0) {
					z.gameObject.Destroy();
					GameObject zombieWon = new GameObject(new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2), ScreenSize.WIDTH, ScreenSize.HEIGHT);
					zombieWon.addSprite(new Sprite("Assets/ZombiesWon.png",zombieWon));
					zombieWin = true;
					break;
				}
			}
		}
	}

	@Override
	public void Destruction() {
		// TODO Auto-generated method stub
		
	}

	
}
