package pers.LINKH.Scripts;

import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Compontent.UI.Button;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Setting.Layout;

public class Card {
	public static GameObject PeashooterCard;
	public static GameObject SunFlowerCard;
	public static GameObject WallNutCard;
	public static boolean PeashooterOn = false;
	public static boolean SunFlowerOn = false;
	public static boolean WallNutOn = false;
	public static GameObject peashooterMove;
	public static GameObject SunFlowerMove;
	public static GameObject WallNutMove;
	public Card(){

		PeashooterCard = new GameObject(new Vector2(350,75 ), 130, 130,Layout.Wall);
		PeashooterCard.addSprite(new Sprite("Assets/Peashooter/Peashooter001.png", PeashooterCard));
		PeashooterCard.addButton(new Button(PeashooterCard));
		
		SunFlowerCard = new GameObject(new Vector2(570,75 ), 130, 130,Layout.Wall);
		SunFlowerCard.addSprite(new Sprite("Assets/SunFlower/SunFlower001.png", SunFlowerCard));
		SunFlowerCard.addButton(new Button(SunFlowerCard));
		
		WallNutCard = new GameObject(new Vector2(790,75 ), 130, 130,Layout.Wall);
		WallNutCard.addSprite(new Sprite("Assets/WallNut/WallNut001.png", WallNutCard));
		WallNutCard.addButton(new Button(WallNutCard));
		
		
	}
}
