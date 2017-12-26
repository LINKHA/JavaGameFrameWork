package pers.LINKH.Game.Compontent.UI;

import pers.LINKH.Game.Compontent.Compontent;
import pers.LINKH.Game.Helper.Vector2;

public abstract class UICompontent  {
	public int keyValue;
	public Vector2 location;
	public int width;
	public int height;
	/*
	 * ������ؼ�ʱ���ô˷���
	 * ˲ʱ����
	 */
	public abstract void mouseBegain() ;
	/*
	 * ������ؼ�ʱ���ô˷���
	 * ��ʱ����
	 */
	public abstract void mouseOn() ;
	/*
	 * ����ͷ�ʱ���ô˷���
	 * ˲ʱ����
	 */
	public abstract void mouseRelease() ;
}
