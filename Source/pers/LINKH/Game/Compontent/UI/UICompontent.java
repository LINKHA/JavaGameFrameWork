package pers.LINKH.Game.Compontent.UI;

import pers.LINKH.Game.Compontent.Compontent;
import pers.LINKH.Game.Helper.Vector2;

public abstract class UICompontent extends Compontent {
	public Vector2 location;
	public int width;
	public int height;
	public boolean isDown = false;
	/*
	 * 鼠标点击控件时调用此方法
	 * 瞬时方法
	 */
	public abstract void mouseBegain() ;
	/*
	 * 鼠标点击控件时调用此方法
	 * 即时方法
	 */
	public abstract void mouseOn() ;
	/*
	 * 鼠标释放时调用此方法
	 * 瞬时方法
	 */
	public abstract void mouseRelease() ;
}
