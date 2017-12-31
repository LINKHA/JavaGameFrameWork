package pers.LINKH.Scripts;

import pers.LINKH.Game.Compontent.GameObject;

public class MapStruct {
	public GameObject area;
	public boolean isOn;
	public MapStruct(GameObject area,boolean isOn) {
		this.area = area;
		this.isOn = isOn;
	}
}
