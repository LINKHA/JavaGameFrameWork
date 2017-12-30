package pers.LINKH.Game.Compontent;

import java.awt.Graphics;
import java.awt.Image;

import pers.LINKH.Game.PaintcControl;
import pers.LINKH.Game.Screen;
import pers.LINKH.Game.Compontent.UI.Button;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Setting.Setting;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.LKTween;
public class GameObject extends Compontent implements PaintcControl,LKTween{
	protected boolean visible = true;
	private Vector2 position = new Vector2();
	private int width;
	private int height;
	Vector2 targetPosition;
	Image image = null;
	Collision collider = null;
	Button button = null;
	Sprite sprite = null;
	Animator animator = null;
	/*
	 * 带Image的构造函数
	 */
	public GameObject(Image image,float x,float y,int width,int height,Tag tag ) {
		this.image = image;
		position.x = x;
		position.y = y;
		this.width = width;
		this.height = height;
		if(tag==null) {
			this.tag = Tag.Default;
		}else {
			this.tag = tag;
		}
		keyValue = Setting.ObjectKey++;
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
	/*
	 * 不带Image的构造函数
	 */
	public GameObject(float x,float y,int width,int height,Tag tag) {
		position.x = x;
		position.y = y;
		this.width = width;
		this.height = height;
		if(tag==null) {
			this.tag = Tag.Default;
		}else {
			this.tag = tag;
		}
		keyValue = Setting.ObjectKey++;
		Screen.addToScreen(this);
	}
	public GameObject(Vector2 position,int width,int height,Tag tag) {
		this(position.x, position.y,width,height, tag);
	}
	
	public GameObject(float x,float y,int width,int height) {
		this(x, y,width,height, Tag.Default);
	}
	
	public GameObject(Vector2 position,int width,int height) {
		this(position.x, position.y,width,height, Tag.Default);
	}
	public void paint(Graphics g) {
		if(visible) {
			g.drawImage(image, (int)(position.x-width/2.0f), (int)(position.y-height/2.0f), width, height,null);
		}
	}
	public void addCollider(Collision collider) {
		this.collider = collider;
		this.collider.tag =tag;
	}
	public void addButton(Button button) {
		this.button = button;
	}
	public void addSprite(Sprite sprite) {
		this.sprite = sprite;
		image = sprite.image;
	}
	public void addAnimator(Animator animator) {
		this.animator = animator;
	}
	@Override
	public void move(float deltaX,float deltaY) {
		position.x+=deltaX;
		position.y+=deltaY;
		if(collider!=null) {
			collider.move();
		}
	}
	@Override
	public void move(Vector2 vec) {
		move(vec.x,vec.y);
	}
	@Override
	public  boolean moveTo(Vector2 position,float speed) {
		targetPosition = position;
		Vector2 countVec2 = new Vector2(targetPosition.sub(this.position));
		if(!countVec2.equals(Vector2.zero())) {
			move(countVec2.direction().x*speed,countVec2.direction().y*speed);
			return false;
		}
		return true;
	}
	@Override
	public  boolean moveAdd(Vector2 distance,float speed) {
		targetPosition = position.add(distance);
		return moveTo(targetPosition, speed);
	}
	public void setTag(Tag tag) {
		this.tag = tag;
		if(collider!=null) {
			collider.tag =tag;
		}
	}
	public void setImage(Image changeImage) {
		image = changeImage;
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
	public Image getImage() {
		return image;
	}
	public Button getButton() {
		return button;
	}
	public Animator getAnimator() {
		return animator;
	}
	public Sprite getSprite() {
		return sprite;
	}
	@Override
	public void Destroy() {
		if(visible) {
			Screen.deleteToScreen(keyValue);
			visible = false;
			if(collider!=null) {
				collider.Destroy();
			}
			if(animator!=null) {
				animator.Destroy();
			}
			if(button!=null) {
				button.Destroy();
			}
		}
	}
}
