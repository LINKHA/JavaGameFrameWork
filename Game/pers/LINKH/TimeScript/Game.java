package pers.LINKH.TimeScript;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.Animator;
import pers.LINKH.Game.Compontent.Collider;
import pers.LINKH.Game.Compontent.Collision;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.RectHitBox;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Compontent.UI.Button;
import pers.LINKH.Game.Helper.ScreenSize;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Operate.Input;
import pers.LINKH.Game.Setting.Layout;
import pers.LINKH.Game.Setting.Setting;
import pers.LINKH.Game.Setting.Tag;
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

	LKTimer aLkTimer=new LKTimer(5000, 1000);
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
		

		ZombieManager.areaZombiesSize[0]++;
		
		
		/*GameObject gameObject =new GameObject(new Vector2(1920,210+0*180), 200, 200,Tag.Enemy,Layout.Sprite);
		
				gameObject.addSprite(new Sprite("Assets/Zombie/Zombie001.png",gameObject));
				gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/Zombie/Zombie0",".png", 1, 22),10,  gameObject));
				gameObject.addCollider(new Collider(gameObject));
				
				Zombie zombie = new Zombie();
				zombie.gameObject = gameObject;
				zombie.keyValue = gameObject.keyValue;
				ZombieManager.Zombies.add(zombie);*/

		
		
		new GameMap();
		new Card();
	}
	public void RunLoop() {

		
		createZombie();
		
		
		createPlant();
		
		
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
	public void createZombie() {
		if(aLkTimer.timer()) {
			int location = Random.Rang(0,5);
			int shape = Random.Rang(0,3);
			ZombieManager.areaZombiesSize[location]++;
			
			
			GameObject gameObject =new GameObject(new Vector2(1920,210+location*180), 200, 200,Tag.Enemy,Layout.Sprite);
				switch (shape) {
					case 0:
						
						gameObject.addSprite(new Sprite("Assets/Zombie/Zombie001.png",gameObject));
						gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/Zombie/Zombie0",".png", 1, 22),10,  gameObject));
						gameObject.addCollider(new Collider(gameObject));
						
						Zombie zombie = new Zombie();
						zombie.gameObject = gameObject;
						zombie.keyValue = gameObject.keyValue;
						zombie.type = 0;
						ZombieManager.Zombies.add(zombie);
						
						break;
					case 1:
						gameObject.addSprite(new Sprite("Assets/Zombie2/Zombie2001.png",gameObject));
						gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/Zombie2/Zombie20",".png", 1, 31),10,  gameObject));
						gameObject.addCollider(new Collider(gameObject));
						
						Zombie zombie2 = new Zombie();
						zombie2.gameObject = gameObject;
						zombie2.keyValue = gameObject.keyValue;
						zombie2.type = 1;
						ZombieManager.Zombies.add(zombie2);
						
						break;
					case 2:
						gameObject.addSprite(new Sprite("Assets/Zombie3/Zombie3001.png",gameObject));
						gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/Zombie3/Zombie30",".png", 1, 18),15,  gameObject));
						gameObject.addCollider(new Collider(gameObject));
						
						Zombie zombie3 = new Zombie();
						zombie3.gameObject = gameObject;
						zombie3.keyValue = gameObject.keyValue;
						zombie3.type = 2;
						ZombieManager.Zombies.add(zombie3);
						
						break;

				}
		}
	}
	public void createPlant() {
		if(Input.hitMouse() ){
			if(Card.PeashooterOn==true) {
				Card.peashooterMove.Destroy();
				for(MapStruct map:GameMap.PlantArea) {
					if(isHitArea(map.area) && !map.isOn) {
						GameObject gameObject =new GameObject(map.area.getPosition(), 100, 100,Tag.Player,Layout.Sprite);
						gameObject.addSprite(new Sprite("Assets/Peashooter/Peashooter001.png",gameObject));
						gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/Peashooter/Peashooter0",".png", 1, 13),15, gameObject));
						gameObject.addCollider(new Collider(gameObject));
						
						Peashooter peashooter = new Peashooter();
						peashooter.gameObject = gameObject;
						peashooter.keyValue = gameObject.keyValue;
						peashooter.hp = 70;
						peashooter.mapStruct = map;
						PlantManager.Peashooters.add(peashooter);
						PlantManager.plants.add(peashooter);
						map.isOn = true;
					}
				}
				Card.PeashooterOn=false;
			}
			if(Card.SunFlowerOn==true) {
				Card.SunFlowerMove.Destroy();
				for(MapStruct map:GameMap.PlantArea) {
					if(isHitArea(map.area) && !map.isOn) {
						GameObject gameObject =new GameObject(map.area.getPosition(), 100, 100,Tag.Player,Layout.Sprite);
						gameObject.addSprite(new Sprite("Assets/SunFlower/SunFlower001.png",gameObject));
						gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/SunFlower/SunFlower0",".png", 1, 18),10, gameObject));
						gameObject.addCollider(new Collider(gameObject));
						
						SunFlower sunFlower = new SunFlower();
						sunFlower.gameObject = gameObject;
						sunFlower.keyValue = gameObject.keyValue;
						sunFlower.hp = 50;
						sunFlower.mapStruct = map;
						PlantManager.plants.add(sunFlower);
						map.isOn = true;
					}
				}
				Card.SunFlowerOn = false;
			}
			if(Card.WallNutOn == true) {
				Card.WallNutMove.Destroy();
				for(MapStruct map:GameMap.PlantArea) {
					if(isHitArea(map.area) && !map.isOn) {
						GameObject gameObject =new GameObject(map.area.getPosition(), 100, 100,Tag.Player,Layout.Sprite);
						gameObject.addSprite(new Sprite("Assets/WallNut/WallNut001.png",gameObject));
						gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/WallNut/WallNut0",".png", 1, 16),10, gameObject));
						gameObject.addCollider(new Collider(gameObject));
						
						WallNut wallNut = new WallNut();
						wallNut.gameObject = gameObject;
						wallNut.keyValue = gameObject.keyValue;
						wallNut.hp = 200;
						wallNut.mapStruct = map;
						PlantManager.plants.add(wallNut);
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
		
		
		if(Card.WallNutCard.getButton().mouseHit()) {
			Card.WallNutMove = new GameObject(new Vector2(-1000,-1000 ), 130, 130);
			Card.WallNutMove.addSprite(new Sprite("Assets/WallNut/WallNut001.png", Card.WallNutMove));
			Card.WallNutOn = true;
		}
		if(Card.WallNutCard.getButton().mouseDown()) {
			Card.WallNutMove.setPosition(Input.getMouseLocation());
		}
		
	}
}