package pers.LINKH.TimeScript;


import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.Animator;
import pers.LINKH.Game.Compontent.Collider;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Compontent.UI.Button;
import pers.LINKH.Game.Helper.ScreenSize;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Setting.Layout;
import pers.LINKH.Game.Tools.LoadAnimation;
import pers.LINKH.Game.Tools.LoadImage;
import pers.LINKH.Game.Tools.Log;
import pers.LINKH.Scripts.GameMap;
import pers.LINKH.Scripts.GameWorldSetting;



public class Game extends ScriptSuper{
	GameObject BackGround;
	GameObject sun;
	GameObject PeashooterCard;
	GameObject SunFlowerCard;
	GameObject WallNutCard;
	
	GameObject Test;
	public Game(){
		super.enable = false;
		Scriptname = "Game";
	}
	
	
	public void Init() {
		
		BackGround =new GameObject( new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2), ScreenSize.WIDTH, ScreenSize.HEIGHT,Layout.BackGround);
		BackGround.addSprite(new Sprite("Assets/BackGround.png",BackGround));
		
		
		
		sun = new GameObject(new Vector2(110,50 ), 100, 100);
		sun.addSprite(new Sprite("Assets/Sun/Sun001.png", sun));
		sun.addAnimator(new Animator( LoadAnimation.load("Assets/Sun/Sun0",".png", 1, 22),4, sun));
		
		PeashooterCard = new GameObject(new Vector2(350,75 ), 130, 130);
		PeashooterCard.addSprite(new Sprite("Assets/Peashooter/Peashooter001.png", PeashooterCard));
		
		SunFlowerCard = new GameObject(new Vector2(570,75 ), 130, 130);
		SunFlowerCard.addSprite(new Sprite("Assets/SunFlower/SunFlower001.png", SunFlowerCard));
		
		WallNutCard = new GameObject(new Vector2(790,75 ), 130, 130);
		WallNutCard.addSprite(new Sprite("Assets/WallNut/WallNut001.png", WallNutCard));
		
		Test = new GameObject(new Vector2(200,230 ), 100, 100);
		Test.addSprite(new Sprite("Assets/WallNut/WallNut001.png", Test));
		
		new GameMap();
	}
	public void RunLoop() {

		
	}
	public void Destruction() {
		// TODO Auto-generated method stub
	}
}
