package pers.LINKH.Game;

import pers.LINKH.Game.Tools.Log;

public abstract class ScriptSuper {
	public abstract void Init() ;
	public abstract void RunLoop();
	public abstract void Destruction() ;
	
	public void print(Object object) {
		Log.Print(object);
	}
}
