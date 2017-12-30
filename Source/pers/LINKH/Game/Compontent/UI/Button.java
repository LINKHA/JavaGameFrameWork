package pers.LINKH.Game.Compontent.UI;

import java.awt.Image;
import pers.LINKH.Game.UISystem;
import pers.LINKH.Game.Compontent.GameObject;

public class Button extends UICompontent {

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
		gameObject.setImage(changeImage);

	}
	@Override
	public void mouseOn() {
	}
	@Override
	public void mouseRelease() {
		mouseDown = false;
		gameObject.setImage(image);
	}
	public boolean mouseDown() {
		return mouseDown;
	}
}
