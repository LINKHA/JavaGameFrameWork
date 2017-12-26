package pers.LINKH.Game.Compant.UI;

import pers.LINKH.Game.Compant.Compant;

public abstract class UICompant  {
	public int keyValue;
	/*
	 * 鼠标点击控件时调用此方法
	 * 瞬时方法
	 */
	public abstract void mouseClick() ;
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
