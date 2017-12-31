package pers.LINKH.TimeScript;


import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.Animator;
import pers.LINKH.Game.Compontent.Collider;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Compontent.UI.Button;
import pers.LINKH.Game.Helper.ScreenSize;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Operate.Input;
import pers.LINKH.Game.Setting.Layout;
import pers.LINKH.Game.Tools.LoadAnimation;
import pers.LINKH.Game.Tools.LoadImage;
import pers.LINKH.Game.Tools.Log;
import pers.LINKH.Scripts.Card;
import pers.LINKH.Scripts.GameMap;
import pers.LINKH.Scripts.GameWorldSetting;
import pers.LINKH.Scripts.MapStruct;



public class Game extends ScriptSuper{
	GameObject BackGround;
	GameObject sun;

	public Game(){
		super.enable = false;
		Scriptname = "Game";
	}
	
	
	public void Init() {
		
		BackGround =new GameObject( new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2), ScreenSize.WIDTH, ScreenSize.HEIGHT,Layout.BackGround);
		BackGround.addSprite(new Sprite("Assets/BackGround.png",BackGround));
		
		
		
		sun = new GameObject(new Vector2(110,50 ), 100, 100,Layout.Wall);
		sun.addSprite(new Sprite("Assets/Sun/Sun001.png", sun));
		sun.addAnimator(new Animator( LoadAnimation.load("Assets/Sun/Sun0",".png", 1, 22),4, sun));
		

		
		new GameMap();
		new Card();
	}
	public void RunLoop() {
		if(Input.hitMouse() ){
			if(Card.PeashooterOn==true) {
				Card.peashooterMove.Destroy();
				for(MapStruct map:GameMap.PlantArea) {
					if(isHitArea(map.area) && !map.isOn) {
						GameObject gameObject =new GameObject(map.area.getPosition(), 100, 100);
						gameObject.addSprite(new Sprite("Assets/Peashooter/Peashooter001.png",gameObject));
						map.isOn = true;
					}
				}
				Card.PeashooterOn=false;
			}
			if(Card.SunFlowerOn==true) {
				Card.SunFlowerMove.Destroy();
				for(MapStruct map:GameMap.PlantArea) {
					if(isHitArea(map.area) && !map.isOn) {
						GameObject gameObject =new GameObject(map.area.getPosition(), 100, 100);
						gameObject.addSprite(new Sprite("Assets/SunFlower/SunFlower001.png",gameObject));
						map.isOn = true;
					}
				}
				Card.SunFlowerOn = false;
			}
			if(Card.WallNutOn == true) {
				Card.WallNutMove.Destroy();
				for(MapStruct map:GameMap.PlantArea) {
					if(isHitArea(map.area) && !map.isOn) {
						GameObject gameObject =new GameObject(map.area.getPosition(), 100, 100);
						gameObject.addSprite(new Sprite("Assets/WallNut/WallNut001.png",gameObject));
						map.isOn = true;
					}
				}
				Card.SunFlowerOn = false;
			}
		}	
		
		if(Card.PeashooterCard.getButton().mouseHit()) {
			Card.peashooterMove = new GameObject(new Vector2(1000,1000 ), 130, 130);
			Card.peashooterMove.addSprite(new Sprite("Assets/Peashooter/Peashooter001.png", Card.peashooterMove));
			Card.PeashooterOn = true;
		}
		if(Card.PeashooterCard.getButton().mouseDown()) {
			Card.peashooterMove.setPosition(Input.getMouseLocation());
		}
		
		
		if(Card.SunFlowerCard.getButton().mouseHit()) {
			Card.SunFlowerMove = new GameObject(new Vector2(1000,1000 ), 130, 130);
			Card.SunFlowerMove.addSprite(new Sprite("Assets/SunFlower/SunFlower001.png", Card.SunFlowerMove));
			Card.SunFlowerOn = true;
		}
		if(Card.SunFlowerCard.getButton().mouseDown()) {
			Card.SunFlowerMove.setPosition(Input.getMouseLocation());
		}
		
		
		if(Card.WallNutCard.getButton().mouseHit()) {
			Card.WallNutMove = new GameObject(new Vector2(1000,1000 ), 130, 130);
			Card.WallNutMove.addSprite(new Sprite("Assets/WallNut/WallNut001.png", Card.WallNutMove));
			Card.WallNutOn = true;
		}
		if(Card.WallNutCard.getButton().mouseDown()) {
			Card.WallNutMove.setPosition(Input.getMouseLocation());
		}
		
	}
	public void Destruction() {
		// TODO Auto-generated method stub
	}
	
	public boolean isHitArea(GameObject area) {
		Vector2 mousePosition =Input.getMouseLocation();
		return (int)area.getPosition().x-(int)area.getWidth()/2<=(int)mousePosition.x && 
				(int)area.getPosition().x+(int)area.getWidth()/2>=(int)mousePosition.x &&
				(int)area.getPosition().y-(int)area.getHeight()/2<=(int)mousePosition.y &&
				(int)area.getPosition().y+(int)area.getHeight()/2>=(int)mousePosition.y ;
	}
	
}
