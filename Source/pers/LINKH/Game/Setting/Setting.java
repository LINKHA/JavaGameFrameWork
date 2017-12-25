package pers.LINKH.Game.Setting;

import pers.LINKH.Game.ScriptSystem;

public class Setting {
	/*
	 * 暴露给系统
	 * 游戏对象的键值
	 */
	public static int ObjectKey = 0;
	
	
	/*
	 * 用户设置
	 * 与系统进行交互信息
	 */
	private String ScriptPackName = "pers.LINKH.TimeScript";
	public Setting(){
		ScriptSystem.ScriptPackName = ScriptPackName;
		
	}
}
