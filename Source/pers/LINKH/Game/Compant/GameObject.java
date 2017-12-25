package pers.LINKH.Game.Compant;

import java.awt.Graphics;
import java.awt.Image;

import pers.LINKH.Game.PaintcControl;
import pers.LINKH.Game.Screen;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Setting.Setting;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.Log;

public class GameObject extends Compant implements PaintcControl{
	protected boolean visible = true;
	private Vector2 position = new Vector2();
	private int width;
	private int height;
	Image image;
	Collision collider = null;
	public GameObject(Image image,float x,float y,int width,int height,Tag tag ) {
		this.image = image;
		position.x = x;
		position.y = y;
		this.width = width;
		this.height = height;
		if(tag==null) {
			tag = Tag.Default;
		}
		this.tag = tag;
		Screen.addToScreen(this);

	}
	public GameObject(Image image,Vector2 position,int width,int height,Tag tag) {
		this(image,position.x, position.y,width,height, tag);
	}
	public GameObject(Image image,float x,float y,int width,int height) {
		this(image,x, y,width,height, Tag.Default);
	}
	public GameObject(Image image,Vector2 position,int width,int height) {
		this(image,position.x, position.y,width,height, Tag.Default);
	}
	public void paint(Graphics g) {
		if(visible) {
			g.drawImage(image, (int)position.x, (int)position.y, width, height,null);
		}
	}
	public void addCollider(Collision collider) {
		this.collider = collider;
		this.collider.tag =tag;
	}
	public void move(float deltaX,float deltaY) {
		position.x+=deltaX;
		position.y+=deltaY;
		if(collider!=null) {
			collider.move();
		}
	}
	public void setTag(Tag tag) {
		this.tag = tag;
		if(collider!=null) {
			collider.tag =tag;
		}
	}
	public Tag getTag() {
		return tag;
	}
	public Vector2 getPosition() {
		return position;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getkeyValue() {
		return keyValue;
	}
	public Collision getCollision() {
		return collider;
	}
	@Override
	public void Destroy() {
		Screen.deleteToScreen(keyValue);
		
		if(collider!=null) {
			Log.Print(("delete "+keyValue));
			collider.Destroy();
		}
	}
}
