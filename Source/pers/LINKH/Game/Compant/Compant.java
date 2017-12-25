package pers.LINKH.Game.Compant;

import pers.LINKH.Game.Setting.Setting;

public abstract class Compant {
	public int keyValue;
	Compant(){
		keyValue = Setting.ObjectKey++;
	}
	public abstract void Destroy();
}
