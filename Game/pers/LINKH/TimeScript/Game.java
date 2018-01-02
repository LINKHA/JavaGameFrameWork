package pers.LINKH.TimeScript;

import java.util.Timer;
import java.util.TimerTask;

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
import pers.LINKH.Game.Setting.Setting;
import pers.LINKH.Game.Tools.LoadAnimation;
import pers.LINKH.Game.Tools.LoadImage;
import pers.LINKH.Game.Tools.Log;
import pers.LINKH.Game.Tools.Random;
import pers.LINKH.Game.Tools.LKTimer;
import pers.LINKH.Scripts.Card;
import pers.LINKH.Scripts.GameMap;
import pers.LINKH.Scripts.GameWorldSetting;
import pers.LINKH.Scripts.MapStruct;
import pers.LINKH.Scripts.Peashooter;
import pers.LINKH.Scripts.SunFlower;
import pers.LINKH.Scripts.WallNut;
import pers.LINKH.Scripts.Zombie;



public class Game extends ScriptSuper{
	GameObject BackGround;
	GameObject sun;

	LKTimer aLkTimer=new LKTimer(1000, 1000);
	public Game(){
		super.enable = false;
		Scriptname = "Game";
	}
	
	
	public void Init() {
		
		
<<<<<<< HEAD
		
		BackGround =new GameObject( new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2), ScreenSize.WIDTH, ScreenSize.HEIGHT,Layout.BackGround);
		BackGround.addSprite(new Sprite("Assets/BackGround.png",BackGround));
		
		
		
		sun = new GameObject(new Vector2(110,50 ), 100, 100,Layout.Wall);
		sun.addSprite(new Sprite("Assets/Sun/Sun001.png", sun));
		sun.addAnimator(new Animator( LoadAnimation.load("Assets/Sun/Sun0",".png", 1, 22),4, sun));
		
=======
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
		
		/*
		pic3 = new GameObject(LoadImage.load("hero.jpg"), new Vector2(800,500), 200, 200);
		pic3.setTag(Tag.Enemy);
		pic3.addCollider(new Collider(pic3));
		
		pic4 = new GameObject(LoadImage.load("hero.jpg"), new Vector2(Toolkit.getDefaultToolkit().getScreenSize().width - 100,Toolkit.getDefaultToolkit().getScreenSize().height - 100), 200, 200);
		pic4.setTag(Tag.Enemy);
		pic4.addCollider(new Collider(pic4));*/
		
		pic5 = new GameObject(new Vector2(800,200), 200, 200);
		pic5.addSprite(new Sprite("hero.jpg",pic5));
		pic5.setTag(Tag.Enemy);
		pic5.addButton((new Button(pic5,LoadImage.load("EnemyFly.png"))));

		

		
		
		new GameMap();
		new Card();
	}
	public void RunLoop() {

		
		if(aLkTimer.timer()) {
			int location = Random.Rang(0,5);
			int shape = Random.Rang(0,3);
			ZombieManager.areaZombiesSize[location]++;
			
			
			GameObject gameObject =new GameObject(new Vector2(1920,210+location*180), 200, 200);
				switch (shape) {
					case 0:
						gameObject.addSprite(new Sprite("Assets/Zombie/Zombie001.png",gameObject));
						gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/Zombie/Zombie0",".png", 1, 22),7,  gameObject));
						Zombie zombie = new Zombie();
						zombie.gameObject = gameObject;
						zombie.keyValue = gameObject.keyValue;
						ZombieManager.Zombies.add(zombie);
						
						break;
					case 1:
						gameObject.addSprite(new Sprite("Assets/Zombie2/Zombie2001.png",gameObject));
						gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/Zombie2/Zombie20",".png", 1, 31),10,  gameObject));
						gameObject.addCollider(new Collider(gameObject));
						
						Zombie zombie2 = new Zombie();
						zombie2.gameObject = gameObject;
						zombie2.keyValue = gameObject.keyValue;
						ZombieManager.Zombies.add(zombie2);
						
						break;
					case 2:
						gameObject.addSprite(new Sprite("Assets/Zombie3/Zombie3001.png",gameObject));
						gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/Zombie3/Zombie30",".png", 1, 18),8,  gameObject));
						Zombie zombie3 = new Zombie();
						zombie3.gameObject = gameObject;
						zombie3.keyValue = gameObject.keyValue;
						ZombieManager.Zombies.add(zombie3);
						
						break;

				}
		}
		
		
		
		
		if(Input.hitMouse() ){
			if(Card.PeashooterOn==true) {
				Card.peashooterMove.Destroy();
				for(MapStruct map:GameMap.PlantArea) {
					if(isHitArea(map.area) && !map.isOn) {
						GameObject gameObject =new GameObject(map.area.getPosition(), 100, 100);
						gameObject.addSprite(new Sprite("Assets/Peashooter/Peashooter001.png",gameObject));
						gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/Peashooter/Peashooter0",".png", 1, 13),10, gameObject));
						Peashooter peashooter = new Peashooter();
						peashooter.gameObject = gameObject;
						
						PeashooterManager.Peashooters.add(peashooter);
						
						map.isOn = true;
					}
				}
<<<<<<< HEAD
				Card.PeashooterOn=false;
			}
			if(Card.SunFlowerOn==true) {
				Card.SunFlowerMove.Destroy();
				for(MapStruct map:GameMap.PlantArea) {
					if(isHitArea(map.area) && !map.isOn) {
						GameObject gameObject =new GameObject(map.area.getPosition(), 100, 100);
						gameObject.addSprite(new Sprite("Assets/SunFlower/SunFlower001.png",gameObject));
						gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/SunFlower/SunFlower0",".png", 1, 18),10, gameObject));
						
						new SunFlower().gameObject = gameObject;
						
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
						gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/WallNut/WallNut0",".png", 1, 16),10, gameObject));
					
						new WallNut().gameObject = gameObject;
						
						map.isOn = true;
					}
				}
				Card.SunFlowerOn = false;
			}
		}	
		
		if(Card.PeashooterCard.getButton().mouseHit()) {
			Card.peashooterMove = new GameObject(new Vector2(-1000,-1000 ), 130, 130);
			Card.peashooterMove.addSprite(new Sprite("Assets/Peashooter/Peashooter001.png", Card.peashooterMove));
			Card.PeashooterOn = true;
=======
			}*/
		// TODO Auto-generated method stub
		if(Input.getButtonDown(KeyCodeIndex.A)) {
			pic1.move(-3.0f, 0);
>>>>>>> parent of 49d26bd... 引擎基本功能完成
		}
		if(Card.PeashooterCard.getButton().mouseDown()) {
			Card.peashooterMove.setPosition(Input.getMouseLocation());
		}
		
		
		if(Card.SunFlowerCard.getButton().mouseHit()) {
			Card.SunFlowerMove = new GameObject(new Vector2(-1000,-1000 ), 130, 130);
			Card.SunFlowerMove.addSprite(new Sprite("Assets/SunFlower/SunFlower001.png", Card.SunFlowerMove));
			Card.SunFlowerOn = true;
		}
		if(Card.SunFlowerCard.getButton().mouseDown()) {
			Card.SunFlowerMove.setPosition(Input.getMouseLocation());
		}
		
<<<<<<< HEAD
		
		if(Card.WallNutCard.getButton().mouseHit()) {
			Card.WallNutMove = new GameObject(new Vector2(-1000,-1000 ), 130, 130);
			Card.WallNutMove.addSprite(new Sprite("Assets/WallNut/WallNut001.png", Card.WallNutMove));
			Card.WallNutOn = true;
=======
		pic2.moveTo(new Vector2(500,700),1);

		if(pic2.getPosition().x<=0) {
			
			pic2.Destroy();
>>>>>>> parent of 49d26bd... 引擎基本功能完成
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
