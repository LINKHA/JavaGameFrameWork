package pers.LINKH.Game.Setting;

import pers.LINKH.Game.ScriptSystem;

public class Setting {
	public static int ObjectKey;
	/*
	 * �û�����
	 * ��ϵͳ���н�����Ϣ
	 */
	private String ScriptPackName = "pers.LINKH.TimeScript";
	public Setting(){
		ScriptSystem.ScriptPackName = ScriptPackName;
		
	}
}
