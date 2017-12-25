package pers.LINKH.TimeScript;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compant.Collider;
import pers.LINKH.Game.Compant.GameObject;
import pers.LINKH.Game.Helper.KeyCodeIndex;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Operate.Input;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.LoadImage;
import pers.LINKH.Game.Tools.Log;

public class Game extends ScriptSuper{
	GameObject pic1;
	GameObject pic2;
	GameObject pic3;
	GameObject pic4;
	public void Init() {

		pic1 = new GameObject(LoadImage.load("EnemyFly.png"), new Vector2(0,0), 300, 200);
		pic1.addCollider(new Collider(pic1));

		pic2 = new GameObject(LoadImage.load("hero.jpg"), new Vector2(500,500), 200, 200,Tag.Enemy);
		pic2.addCollider(new Collider(pic2));
		
		
		
		pic3 = new GameObject(LoadImage.load("hero.jpg"), new Vector2(800,500), 200, 200);
		pic3.setTag(Tag.Enemy);
		pic3.addCollider(new Collider(pic3));
		
		pic4 = new GameObject(LoadImage.load("hero.jpg"), new Vector2(1200,500), 200, 200);
		pic4.setTag(Tag.Enemy);
		pic4.addCollider(new Collider(pic4));
		
	
		
		
		
		//Log.Print(pic1.keyValue);
		
		pic3.Destroy();
	}
	public void RunLoop() {
		// TODO Auto-generated method stub
		if(Input.getButtonDown(KeyCodeIndex.A)) {
			pic1.move(-3.0f, 0);
		}
		if(Input.getButtonDown(KeyCodeIndex.S)) {
			pic1.move(0, 3.0f);
		}
		if(Input.getButtonDown(KeyCodeIndex.D)) {
			pic1.move(3.0f, 0);
		}
		if(Input.getButtonDown(KeyCodeIndex.W)) {
			pic1.move(0, -3.0f);
		}
		/*if(Input.leftMouseDown()){
			Log.Print("p");
		}*/
		pic2.move(-1, 0);

		if(pic1.getCollision().hit(Tag.Enemy)) {
			
			Log.Print("hit");
		}
	}
	public void Destruction() {
		// TODO Auto-generated method stub
	}
}
