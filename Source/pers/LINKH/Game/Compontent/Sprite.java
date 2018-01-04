package pers.LINKH.Game.Compontent;

import java.awt.Image;

import pers.LINKH.Game.Tools.LoadImage;

public class Sprite extends Compontent {
	public Image image;
	GameObject gameObject;
	
	public  Sprite(Image image,GameObject gameObject) {
		this.image =image;
		this.gameObject = gameObject;
	}
	public  Sprite(String imageName,GameObject gameObject) {
		image = LoadImage.load(imageName);
		this.gameObject = gameObject;
	}
	@Override
	public void Destroy() {
		// TODO Auto-generated method stub
		
	}

}
