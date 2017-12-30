package pers.LINKH.Game.Compontent;

import pers.LINKH.Game.Setting.Layout;
import pers.LINKH.Game.Setting.Tag;

public abstract class Compontent {
	public int keyValue;
	public Tag tag;
	public Layout layout;
	public abstract void Destroy();
}
