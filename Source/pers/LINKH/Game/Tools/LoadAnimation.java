package pers.LINKH.Game.Tools;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class LoadAnimation {
	
/////////////////////////////////////////////////////////////////////////////////////////////
//暴露给应用层的接口
//类:LoadAnimation
/////////////////////////////////////////////////////////////////////////////////////////////	
	public static List<Image> load(String prefix,String postfix,int min,int max) {
		List<Image> ani = new ArrayList<Image>();
		if(min<0 || max<min) {
			Log.Print("Animation is fail to load");
			return ani;
		}
		
		if(min<10) {
			if(max<10) {
				for(int i = min;i<=max;i++) {
					ani.add(LoadImage.load(prefix+i+postfix));
				}
			}
			else if(10<=max&&max<100) {
				for(int i = min;i<10;i++) {
					ani.add(LoadImage.load(prefix+"0"+i+postfix));
				}
				for(int i=10;i<=max;i++) {
					ani.add(LoadImage.load(prefix+i+postfix));
				}
			}
			else if(100<=max&&max<1000) {
				for(int i = min;i<10;i++) {
					ani.add(LoadImage.load(prefix+"00"+i+postfix));
				}
				for(int i=10;i<100;i++) {
					ani.add(LoadImage.load(prefix+"0"+i+postfix));
				}
				for(int i=100;i<=max;i++) {
					ani.add(LoadImage.load(prefix+i+postfix));
				}
			}
		}
		else if(min<100) {
			if(max<100) {
				for(int i = min;i<=max;i++) {
					ani.add(LoadImage.load(prefix+i+postfix));
				}
			}
			else if(100<=max&&max<1000) {
				for(int i = min;i<100;i++) {
					ani.add(LoadImage.load(prefix+"0"+i+postfix));
				}
				for(int i=100;i<=max;i++) {
					ani.add(LoadImage.load(prefix+i+postfix));
				}
			}
		}
		else if(min<1000) {
			if(max<1000) {
				for(int i = min;i<=max;i++) {
					ani.add(LoadImage.load(prefix+i+postfix));
				}
			}
		}
		if(ani.size()==0)
			Log.Print("Animation is fail to load because index is to more than System");
		return ani;
	}
	
	
	
}
