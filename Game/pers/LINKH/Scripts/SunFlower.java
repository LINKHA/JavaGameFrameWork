package pers.LINKH.Scripts;

import pers.LINKH.Game.Compontent.GameObject;

public class SunFlower extends Plant {
	public int hp = 50;
	public int sunValue = 50;
	public GameObject gameObject;
	public int createSunTime = 10;;
	
	public SunFlower() {
		hp = GameWorldSetting.SUNFLOWER_HP;
	}
}
