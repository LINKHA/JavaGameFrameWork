package pers.LINKH.Game.Compontent;

import pers.LINKH.Game.Setting.Setting;
import pers.LINKH.Game.Setting.Tag;

public abstract class Compontent {
	public int keyValue;
	protected Tag tag;
	protected Compontent(){
		keyValue = Setting.ObjectKey++;
	}
	public abstract void Destroy();
}
