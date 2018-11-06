package pers.LINKH2.TimeScript;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.Animator;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Compontent.UI.Button;
import pers.LINKH.Game.Helper.ScreenSize;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Setting.Layout;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.LoadAnimation;
import pers.LINKH.Game.Tools.LoadImage;

public class Menu extends ScriptSuper{

	static GameObject MainMenuGround;
	static GameObject MainMenuGround2;
	static GameObject buttonLaunch;
	static GameObject gameObject;
	
	public Menu(){
		super.enable = true;
		Scriptname = "Menu";
	}

	@Override
	public void Init() {
		buttonLaunch = new GameObject( new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2+400), 700, 300);
		buttonLaunch.addSprite(new Sprite("Assets/button_ok.png",buttonLaunch));
		buttonLaunch.addButton(new Button(buttonLaunch, LoadImage.load("Assets/button_ok.png")));
		
		MainMenuGround = new GameObject( new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2), ScreenSize.WIDTH, ScreenSize.HEIGHT,Layout.BackGround);
		MainMenuGround.addSprite(new Sprite("Assets/bg_day.png",MainMenuGround));

		MainMenuGround2 = new GameObject( new Vector2(ScreenSize.WIDTH * 1.5f,ScreenSize.HEIGHT/2), ScreenSize.WIDTH, ScreenSize.HEIGHT,Layout.BackGround);
		MainMenuGround2.addSprite(new Sprite("Assets/bg_day.png",MainMenuGround2));
		
		gameObject =new GameObject( new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2), 300, 300);
		gameObject.addSprite(new Sprite("Assets/bird2_001.png",gameObject));
		gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/bird2_00",".png", 1, 3),15,  gameObject));
	}

	@Override
	public void RunLoop() {
		MainMenuGround2.move(-1, 0);
		MainMenuGround.move(-1, 0);
		if(MainMenuGround.getPosition().x<=-(ScreenSize.WIDTH/2))
			MainMenuGround.setPosition(ScreenSize.WIDTH* 1.5f, ScreenSize.HEIGHT/2);
		
		if(MainMenuGround2.getPosition().x<=-(ScreenSize.WIDTH/2))
			MainMenuGround2.setPosition(ScreenSize.WIDTH* 1.5f,ScreenSize.HEIGHT/2);
		
		if(buttonLaunch.getButton().mouseUp()) {
			buttonLaunch.Destroy();
			gameObject.Destroy();
			MainMenuGround.Destroy();
			MainMenuGround2.Destroy();
			super.enable = false;
			ScriptOn("Game");
		}
	}

	@Override
	public void Destruction() {

	}

}
