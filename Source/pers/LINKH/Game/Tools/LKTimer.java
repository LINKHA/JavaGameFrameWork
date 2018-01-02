package pers.LINKH.Game.Tools;

import pers.LINKH.Game.TimeSystem;

public class LKTimer {
	boolean enable = true;
	double startTime;
	double interval;
	double delay;
	double stopTime;
	public LKTimer(double interval,double delay,double stopTime) {
		startTime = 0;
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
		
		if(getTime()>=stopTime) {
			enable = false;
		}
		if(delay!=0) {
			if(getTime()>=delay) {
				delay=0;
				startTime=getTime();
			}
		}
		else if(enable) {
			if((getTime()-startTime)>=interval) {
				startTime=getTime();
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
