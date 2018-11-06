package pers.LINKH.Game.Setting;

import pers.LINKH.Game.Helper.ScreenSize;
import pers.LINKH.Game.Helper.Vector2;

public class Setting {
	public static int ObjectKey;
	/*
	 * 用户设置
	 * 与系统进行交互信息
	 */
	//即时调用包
	public static String ScriptPackName = "pers.LINKH2.TimeScript"; 
	//设置窗口锚点
	public static Vector2 WindowRect = new Vector2(Vector2.zero());
	//设置窗口大小
	public static Vector2 WindowSize = new Vector2(ScreenSize.SIZE);
	//设置窗口顶部按钮是否去除
	public static boolean WIndwUndecorated = true;
	//系统每秒理论帧数(0,1000)
	public static int FPS = 100;
}
