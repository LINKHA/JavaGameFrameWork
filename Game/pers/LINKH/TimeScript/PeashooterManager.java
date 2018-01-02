package pers.LINKH.TimeScript;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Tools.LKTimer;
import pers.LINKH.Game.Tools.Log;
import pers.LINKH.Game.Tools.Random;
import pers.LINKH.Scripts.Peashooter;
import pers.LINKH.Scripts.SunFlower;
import pers.LINKH.Scripts.Zombie;

public class PeashooterManager extends ScriptSuper {

	public static List<Peashooter> Peashooters = new ArrayList<Peashooter>();
	
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
			//�õ��㶹���ִ�ֱλ��
			int Hortarial;
			for(Peashooter p : Peashooters) {
				Hortarial = (int) ((p.gameObject.getPosition().y-230)/180.0f);
				if(aTime && ZombieManager.areaZombiesSize[Hortarial]!=0) {
					//�����ڵ�
					GameObject shell = new GameObject(p.gameObject.getPosition() ,  80, 50);
					shell.addSprite(new Sprite("Assets/PB.png",shell));
					shells.add(shell);
				}
			}
		}
		
		if(shells.size()!=0) {
			for(GameObject shell : shells) {
				//�������Enemy Destory �ı�Sprite    PeaBullHit
				//�õ���Zombie Hp--
				shell.move(10.0f,0);
			}
		}
		
		
		
	}

	@Override
	public void Destruction() {
		// TODO Auto-generated method stub
		
	}

}
