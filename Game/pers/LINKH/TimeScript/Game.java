package pers.LINKH.TimeScript;


import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.Collider;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Compontent.UI.Button;
import pers.LINKH.Game.Helper.ScreenSize;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Tools.LoadImage;
import pers.LINKH.Game.Tools.Log;


public class Game extends ScriptSuper{
	public Game(){
		super.enable = false;
		Scriptname = "Game";
	}
	static GameObject BackGround;
	
	public void Init() {
		Log.Print("b");
	}
	public void RunLoop() {

		Log.Print("a");
	}
	public void Destruction() {
		// TODO Auto-generated method stub
	}
}
