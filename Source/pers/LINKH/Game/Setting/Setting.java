package pers.LINKH.Game.Setting;

import pers.LINKH.Game.ScriptSystem;

public class Setting {
	/*
	 * ��¶��ϵͳ
	 * ��Ϸ����ļ�ֵ
	 */
	public static int ObjectKey = 0;
	
	
	/*
	 * �û�����
	 * ��ϵͳ���н�����Ϣ
	 */
	private String ScriptPackName = "pers.LINKH.TimeScript";
	public Setting(){
		ScriptSystem.ScriptPackName = ScriptPackName;
		
	}
}
