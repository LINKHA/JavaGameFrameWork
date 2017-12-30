package pers.LINKH.TimeScript;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.Animator;
import pers.LINKH.Game.Compontent.Collider;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Compontent.UI.Button;
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
	GameObject pic5;
	GameObject pic6;
	List<Image> images = new ArrayList<Image>();
	int i=0;
	public void Init() {
		
		
		pic1 = new GameObject( new Vector2(0,0), 300, 200);
		pic1.addSprite(new Sprite("EnemyFly.png",pic1));
		pic1.addCollider(new Collider(pic1));

		images.add(LoadImage.load("hero.jpg"));
		images.add(LoadImage.load("EnemyFly.png"));
		images.add(LoadImage.load("BackGround.jpg"));
		
		pic2 = new GameObject(new Vector2(500,500), 200, 200,Tag.Enemy);
		pic2.addSprite(new Sprite("hero.jpg",pic2));
		//pic2.addCollider(new Collider(pic2));
		pic2.addAnimator(new Animator(images,10, pic2));
		
		
		pic3 = new GameObject( new Vector2(800,500), 200, 200,Tag.Enemy);
		pic3.addSprite(new Sprite("hero.jpg",pic3));
		pic3.addCollider(new Collider(pic3));
		pic3.addAnimator(new Animator(images,10, pic3));
		
		/*
		pic4 = new GameObject(LoadImage.load("hero.jpg"), new Vector2(Toolkit.getDefaultToolkit().getScreenSize().width - 100,Toolkit.getDefaultToolkit().getScreenSize().height - 100), 200, 200);
		pic4.setTag(Tag.Enemy);
		pic4.addCollider(new Collider(pic4));*/
		
		pic5 = new GameObject(new Vector2(800,200), 200, 200);
		pic5.addSprite(new Sprite("hero.jpg",pic5));
		pic5.setTag(Tag.Enemy);
		pic5.addButton((new Button(pic5,LoadImage.load("EnemyFly.png"))));

		

				/*new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						Log.Print("run go");
						picGameObjects.add(new GameObject(LoadImage.load("hero.jpg"), new Vector2(500,500), 200, 200,Tag.Enemy));
					}
				}, 1000,2000);*/
				
		//pic3.Destroy();
	}
	public void RunLoop() {
		
		/*for(GameObject gameObject : picGameObjects) {
				gameObject.move(-3, 0);
		}
		for(GameObject gameObject : picGameObjects) {
				if(gameObject.getPosition().x<=0) {
					gameObject.Destroy();
				}
			}*/
		
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
		if(Input.rightMouseDown()){
			Log.Print("p");
		}
		
		pic2.moveTo(new Vector2(500,700),1);
		//pic2.move(-3.0f,0);

		if(pic2.getPosition().x<=0) {
			
			pic2.Destroy();
		}
		if(pic1.getCollision().hit(Tag.Enemy)) {
			
			Log.Print("hit");
		}
	}
	public void Destruction() {
		// TODO Auto-generated method stub
	}
}
