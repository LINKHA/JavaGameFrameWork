package pers.LINKH.Game;

import java.util.List;

import pers.LINKH.Game.Tools.Log;

public abstract class ScriptSuper {
	public String Scriptname;
	public boolean enable = true;
	public abstract void Init() ;
	public abstract void RunLoop();
	public abstract void Destruction() ;
	public void print(Object object) {
		Log.Print(object);
	}
	/*
	 * 根据name找到指定脚本
	 */
	public ScriptSuper getScriptForName(String name){
		try {
			for(ScriptSuper script : ScriptSystem.getSystem().getScripts()) {
				if(name.equals(script.Scriptname)) {
					return script;
				}
			}
		}catch (Exception e) {
			Log.Print("File to get Script");
		}
		
		return null;
	}
	/*
	 * 找到所有脚本
	 */
	public List<ScriptSuper> getScripts(){
		try {
			return ScriptSystem.getSystem().getScripts() ;
		} catch (Exception e) {
			Log.Print("File to get Scripts");
		}
		return null;
	}
	public void ScriptOn(String name) {
		ScriptSuper script = getScriptForName(name);
		if(!script.enable) {
			getScriptForName(name).enable = true;
			getScriptForName(name).Init();
		}
	}
}
