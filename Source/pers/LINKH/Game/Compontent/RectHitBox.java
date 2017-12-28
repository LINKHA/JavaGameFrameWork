package pers.LINKH.Game.Compontent;

import pers.LINKH.Game.Helper.Vector2;

public class RectHitBox{
	private Vector2 objectLocation;
	private int width;
	private int height;
	boolean blueBox;
	public RectHitBox(int x,int y,int width,int height,boolean blueBox) {
		objectLocation.x = x;
		objectLocation.y = y;
		this.width = width;
		this.height = height;
	}
	public RectHitBox(Vector2 location,int width,int height,boolean blueBox) {
		objectLocation = location;
		this.width = width;
		this.height = height;
	}
	public void move(Vector2 location) {
		this.objectLocation = location;
	}
	public boolean intersects(RectHitBox r) {
        int tw = this.width;
        int th = this.height;
        int rw = r.width;
        int rh = r.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = (int)objectLocation.x;
        int ty = (int)objectLocation.y;
        int rx = (int)r.objectLocation.x;
        int ry = (int)r.objectLocation.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }
	Vector2 getPosition() {
		return objectLocation;
	}

}
