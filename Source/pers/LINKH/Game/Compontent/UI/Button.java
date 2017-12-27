package pers.LINKH.Game.Compontent.UI;

import java.awt.Image;

import pers.LINKH.Game.Screen;
import pers.LINKH.Game.UISystem;
import pers.LINKH.Game.Compontent.Collider;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.LoadImage;
import pers.LINKH.Game.Tools.Log;

public class Button extends UICompontent {
	GameObject gameObject;
	public Button(GameObject gameObject) {
		this.gameObject = gameObject;
		keyValue = gameObject.keyValue;
		width = gameObject.getWidth();
		height = gameObject.getHeight();
		UISystem.getSystem().addButton(this);
	}
	@Override
	public void mouseBegain() {
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	//Œ Ã‚
	/////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void mouseOn() {
		Log.Print(keyValue+"Button hit");
	}
	@Override
	public void mouseRelease() {
		
	}
}
