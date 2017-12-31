package pers.LINKH.Scripts;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Helper.Vector2;

public class GameMap {
	public List<GameObject> PlantArea = new ArrayList<GameObject>();
	public GameMap(){
		for(int i=0;i<5;i++) {
			for(int n=0;n<9;n++) {
				GameWorldSetting.mapPoint.add(new Vector2(200+n*190,230+i*180));
			}
		}
		for(Vector2 vec2:GameWorldSetting.mapPoint) {
			GameObject a = new GameObject(vec2,190,180);
			PlantArea.add(a);
			//a.addSprite(new Sprite("Assets/Sun/Sun002.png",  a));
			a.addSprite(new Sprite("Assets/Square.png",  a));
		}
	}
}
