package pers.LINKH.Game.Compant.UI;

import pers.LINKH.Game.Compant.Compant;

public abstract class UICompant  {
	public int keyValue;
	/*
	 * ������ؼ�ʱ���ô˷���
	 * ˲ʱ����
	 */
	public abstract void mouseClick() ;
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
