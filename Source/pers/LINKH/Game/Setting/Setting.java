package pers.LINKH.Game.Setting;

import pers.LINKH.Game.ScriptSystem;
import pers.LINKH.Game.Helper.ScreenSize;
import pers.LINKH.Game.Helper.Vector2;

public class Setting {
	public static int ObjectKey;
	/*
	 * �û�����
	 * ��ϵͳ���н�����Ϣ
	 */
	//��ʱ���ð�
	public static String ScriptPackName = "pers.LINKH.TimeScript";
	//���ô���ê��
	public static Vector2 WindowRect = new Vector2(Vector2.zero());
	//���ô��ڴ�С
	public static Vector2 WindowSize = new Vector2(ScreenSize.SIZE);
	//���ô��ڶ�����ť�Ƿ�ȥ��
	public static boolean WIndwUndecorated = true;
}
