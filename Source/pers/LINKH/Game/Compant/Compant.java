package pers.LINKH.Game.Compant;

import pers.LINKH.Game.Setting.Setting;
import pers.LINKH.Game.Setting.Tag;

public abstract class Compant {
	public int keyValue;
	protected Tag tag;
	protected Compant(){
		keyValue = Setting.ObjectKey++;
	}
	public abstract void Destroy();
}
