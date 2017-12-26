package pers.LINKH.Game.Compant.UI;

import java.awt.Image;

import pers.LINKH.Game.Screen;
import pers.LINKH.Game.Compant.Collider;
import pers.LINKH.Game.Compant.GameObject;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.LoadImage;

public class Button extends UICompant {
	GameObject gameObject;
	public Button(Image image,float x,float y,int width,int height) {
	
		//Ìí¼Óµ½UISystem
		
	}
	public Button(Image image,Vector2 position,int width,int height) {
		this(image,position.x, position.y,width,height);
	
	}
	@Override
	public void mouseClick() {
		
	}
	@Override
	public void mouseOn() {
		
	}
	@Override
	public void mouseRelease() {
		
	}
}
