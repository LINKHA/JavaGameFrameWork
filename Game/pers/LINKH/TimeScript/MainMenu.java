package pers.LINKH.TimeScript;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Compontent.UI.Button;
import pers.LINKH.Game.Helper.ScreenSize;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Tools.LoadImage;
import pers.LINKH.Game.Tools.Log;

public class MainMenu extends ScriptSuper {
	static GameObject MainMenuGround;
	static GameObject buttonLaunch;
	
	static GameObject pic1;
	
	@Override
	public void Init() {
		
		buttonLaunch = new GameObject( new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2+400), 700, 300);
		buttonLaunch.addSprite(new Sprite("Assets/GameLaunch_1.png",buttonLaunch));
		buttonLaunch.addButton(new Button(buttonLaunch, LoadImage.load("Assets/GameLaunch_2.png")));
		
		
		
		MainMenuGround = new GameObject( new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2), ScreenSize.WIDTH, ScreenSize.HEIGHT);
		MainMenuGround.addSprite(new Sprite("Assets/MainMenu.png",MainMenuGround));
	}

	@Override
	public void RunLoop() {
		if(buttonLaunch.getButton().mouseUp()) {
			buttonLaunch.Destroy();
			MainMenuGround.Destroy();
			
			Game.BackGround =new GameObject( new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2), ScreenSize.WIDTH, ScreenSize.HEIGHT);
			Game.BackGround.addSprite(new Sprite("Assets/BackGround.png",MainMenuGround));
			
			pic1= new GameObject( new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2+400), 700, 300);
			pic1.addSprite(new Sprite("Assets/GameLaunch_1.png",pic1));
		}
	}

	@Override
	public void Destruction() {

	}
}
