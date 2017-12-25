package pers.LINKH.Game.Helper;

public class Vector2 {
	public  float x;
	public float y;
	public Vector2() {
		x=0;
		y=0;
		// TODO Auto-generated constructor stub
	}
	public Vector2(float x,float y) {
		this.x = x;
		this.y =y;
	}
	public Vector2(Vector2 vec2) {
		this.x = vec2.x;
		this.y = vec2.y;
	}
	public static Vector2 zero() {
		return new Vector2();
	}
	@Override
	public String toString() {
		return x+" "+y;
	}
}
