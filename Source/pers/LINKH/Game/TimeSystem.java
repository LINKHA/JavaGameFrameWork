package pers.LINKH.Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimeSystem implements FrameSystem{
	private static TimeSystem instance;
	
	private  double StartGameTime;
	private  double currentTime;
	private Timer timer;
	private boolean isTimeGo = true;
	private TimeSystem() {
		StartGameTime = System.currentTimeMillis();
		timer = new Timer();
		
	}
	/**
	*��ʱ��:��¼��ʼ��Ϸ����ǰʱ�侭����ʱ��
	*��ȷ��100����
	*/
	public void stopWatch() {
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if(isTimeGo) {
					currentTime+=100.0;
				}
			}
		}, 0,100);
	}
	@Override
	public void addSystemInit() {
		// TODO Auto-generated method stub
		stopWatch();
	}
	@Override
	public void addSystemRunLoop() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addSystemDestruction() {
		// TODO Auto-generated method stub
		
	}

	public static TimeSystem getSystem() {
		if(instance==null) {
			instance = new TimeSystem();
		}
		return instance;
	}
}

