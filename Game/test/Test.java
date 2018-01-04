package test;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.Collider;
import pers.LINKH.Game.Compontent.Collision;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Helper.KeyCodeIndex;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Operate.Input;
import pers.LINKH.Game.Setting.Layout;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.Log;

public class Test extends ScriptSuper{

	GameObject pic1;
	GameObject pic2;
	GameObject pic3;
	GameObject pic4;
	@Override
	public void Init() {
		pic1 = new GameObject( new Vector2(500,500), 300, 300,Tag.Player,Layout.Default);
		pic1.addSprite(new Sprite("Assets/Square.png",pic1));
		pic1.addCollider(new Collider(pic1));
		
		pic2 = new GameObject( new Vector2(1100,500), 300, 300,Tag.Enemy,Layout.Default);
		pic2.addSprite(new Sprite("Assets/Square.png",pic2));
		pic2.addCollider(new Collider(pic2));
		
		pic3 = new GameObject( new Vector2(1300,500), 300, 300,Tag.Wall,Layout.Default);
		pic3.addSprite(new Sprite("Assets/Square.png",pic3));
		pic3.addCollider(new Collider(pic3));
		
		pic4 = new GameObject( new Vector2(1500,500), 300, 300,Tag.Wall,Layout.Default);
		pic4.addSprite(new Sprite("Assets/Square.png",pic4));
		pic4.addCollider(new Collider(pic4));
	}

	@Override
	public void RunLoop() {
		
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
	}

	@Override
	public void Destruction() {
		
	}

}
