package pers.LINKH.Scripts;

import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Setting.Layout;

public class SunManager {
	public static GameObject B;
	public static GameObject S;
	public static GameObject G;
	public static int sunValue = 900;
	//改变阳关调用
	public static void flashSunValue(int num) {
		B.Destroy();
		S.Destroy();
		G.Destroy();
		
		sunValue+= num;
		if(sunValue>=950){
			sunValue=950;
		}
			B = new GameObject( new Vector2(150,120), 40, 40,Layout.Wall);
			B.addSprite(new Sprite("Assets/Number/"+sunValue/1%10+".png",B)); 
			
			S = new GameObject( new Vector2(120,120), 40, 40,Layout.Wall);
			S.addSprite(new Sprite("Assets/Number/"+(sunValue/ 10 % 10)+".png",S)); 

			G = new GameObject( new Vector2(90,120), 40, 40,Layout.Wall);
			G.addSprite(new Sprite("Assets/Number/"+sunValue / 100 % 10+".png",G)); 
		}
}
