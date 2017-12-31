package pers.LINKH.Game.Compontent.UI;

import java.awt.Image;
import pers.LINKH.Game.UISystem;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Tools.Log;

public class Button extends UICompontent {
	boolean mouseHit = false;
	boolean mouseUp = false;
	boolean mouseDown = false;
	Image image;
	Image changeImage;
	GameObject gameObject;
	public Button(GameObject gameObject,Image image) {
		this.gameObject = gameObject;
		keyValue = gameObject.keyValue;
		width = gameObject.getWidth();
		height = gameObject.getHeight();
		location = gameObject.getPosition();
		changeImage = image;
		this.image = gameObject.getImage();
		UISystem.getSystem().addButton(this);
	}
	public Button(GameObject gameObject) {
		this(gameObject,gameObject.getImage());
	}

	@Override
	public void mouseBegain() {
		mouseDown = true;
		mouseHit = true;
		gameObject.setImage(changeImage);
	}
	@Override
	public void mouseOn() {
	}
	@Override
	public void mouseRelease() {
		mouseDown = false;
		mouseUp = true;
		gameObject.setImage(image);
	}
	public boolean mouseHit() {
		if(mouseHit == true) {
			mouseHit = false;
			return true;
		}
		return false;
	}
	public boolean mouseDown() {
		return mouseDown;
	}
	public boolean mouseUp() {
		if(mouseUp == true) {
			mouseUp = false;
			return true;
		}
		return false;
	}
	@Override
	public void Destroy() {
		// TODO Auto-generated method stub
		UISystem.getSystem().deleteButton(keyValue);
	}
}
