package pers.LINKH.Game.Setting;

import pers.LINKH.Game.ScriptSystem;

public class Setting {
	public static int ObjectKey;
	/*
	 * 用户设置
	 * 与系统进行交互信息
	 */
	private String ScriptPackName = "pers.LINKH.TimeScript";
	public Setting(){
		ScriptSystem.ScriptPackName = ScriptPackName;
		
	}
}
