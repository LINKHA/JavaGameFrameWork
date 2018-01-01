package pers.LINKH.Game.Tools;

import pers.LINKH.Game.TimeSystem;

public class LKTimer {
	boolean enable = true;
	double startTime;
	double interval;
	double delay;
	double stopTime;
	
	double tempTime = 0;
	public LKTimer(double interval,double delay,double stopTime) {
		startTime = LKTimer.getTime();
		this.interval = interval;
		this.delay = delay;
		this.stopTime = stopTime;
	}
	public LKTimer(double interval,double delay) {
		this(interval,delay,Double.MAX_VALUE);
	}
	public LKTimer(double interval) {
		this(interval, 0,Double.MAX_VALUE);
	}
	public boolean timer() {
		
		if(getTime()-startTime>=stopTime) {
			enable = false;
		}
		if(delay!=0) {
			tempTime = tempTime+getTime()-startTime;
			if(tempTime>=delay) {
				delay=0;
				tempTime=0;
				startTime+=tempTime;
			}
		}
		
		else if(enable) {
			Log.Print(delay);
			
			tempTime = tempTime+getTime()-startTime;
			if(tempTime >=interval) {
				startTime+=tempTime;
				tempTime=0;
				return true;
			}
		}
		
		return false;
	}
	public void Destory() {
		enable = false;
	}
	public static double getTime() {
		return TimeSystem.getSystem().getCurrent();
	}
}
