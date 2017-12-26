package pers.LINKH.Game.Helper;

import java.awt.Toolkit;
//Only Read
//class : ScreenSize
public class ScreenSize {
	
	/*
	 * фад╩вСиоц╙╣Ц
	 */
	public static final Vector2 RECT_LU = Vector2.zero();
	/*
	 * фад╩вСобц╙╣Ц
	 */
	public static final Vector2 RECT_LD = new Vector2(0,Toolkit.getDefaultToolkit().getScreenSize().height);
	/*
	 * фад╩сриоц╙╣Ц
	 */
	public static final Vector2 RECT_RU = new Vector2(Toolkit.getDefaultToolkit().getScreenSize().width,0);
	/*
	 * фад╩сробц╙╣Ц
	 */
	public static final Vector2 RECT_RD = new Vector2(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
	/*
	 * фад╩©М
	 */
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	/*
	 * фад╩╦ъ
	 */
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	/*
	 * фад╩Ёъ╢Г
	 */
	public static final Vector2 SIZE = new Vector2(WIDTH,HEIGHT);
}
