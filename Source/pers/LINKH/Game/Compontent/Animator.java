package pers.LINKH.Game.Compontent;

import java.awt.Image;
import java.util.List;

public class Animator extends Compontent {
	public boolean loop = true;
	
	List<Image> clips;
	//��λ֡���
	//������������֮֡���ʱ��������λ����
	double delayPerUnit;
	//���֡��
	//��ǰ����֡����һ������֡��Ҫ�ȴ��ĵ�λ֡����ĸ���
	int delayUnits;
	boolean run = true;
	GameObject gameObject;
	private int goTime = 0;
	private int goFrame = 0;
	
	public Animator(List<Image> clips,double delayPerUnit,GameObject gameObject) {
		this.gameObject = gameObject;
		this.delayPerUnit = delayPerUnit;
		delayUnits =  (int) (1/delayPerUnit);
		this.clips = clips;
	}
	public Animator(List<Image> clips,int delayUnits,GameObject gameObject) {
		this(clips,(double)(1/delayUnits), gameObject);
	}
	public Animator(List<Image> clips,GameObject gameObject){
		this(clips,4, gameObject);
	}
	public void run() {
		goTime++;
		if(run && goTime == delayUnits) {
			goTime = 0;
			if(goFrame == clips.size()-1) {
				goFrame = 0;
			}
			gameObject.image = clips.get(goFrame);
			goFrame++;
		}
	}
	public void enable(boolean b) {
		if(b) run = true;
		else run = false;
	}
	
	
	@Override
	public void Destroy() {
		// TODO Auto-generated method stub
		
	}
}
