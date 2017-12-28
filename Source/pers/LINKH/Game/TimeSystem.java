package pers.LINKH.Game;


import java.util.Timer;
import java.util.TimerTask;

public class TimeSystem extends FrameSystem{
	private static TimeSystem instance;
	
	private  double currentTime;
	private Timer timer;
	private boolean isTimeGo = true;
	private TimeSystem() {
		timer = new Timer();
		currentTime = 0.0;
	}
	/**
	*计时器:记录开始游戏到当前时间经过的时间
	*精确到100毫秒
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
	public static TimeSystem getSystem() {
		if(instance==null) {
			instance = new TimeSystem();
		}
		return instance;
	}
	@Override
	public void addSystemInit() {
		// TODO Auto-generated method stub
		stopWatch();
	}
}

