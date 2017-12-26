
package pers.LINKH.Game;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

import pers.LINKH.Game.Compant.GameObject;
import pers.LINKH.Game.Helper.KeyCodeIndex;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Operate.Input;
import pers.LINKH.Game.Setting.Setting;
import pers.LINKH.Game.Tools.Log;

public class Application extends JFrame{
	
	public static AppStates _appStates = AppStates.INVLID;
	public Screen screen;
	public boolean isRun = true;
	public Input input =new Input(this);
/////////////////////////////////////////////////////////////////////////////////////////////
//暴露给应用层的属性
//类:Application
	public static double deltaTime = 0.0f;
	public static int FPS = 0;
/////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/*
	 * Game Frame System
	 */
	FrameSystem collisionSystem;
	FrameSystem timeSystem;
	FrameSystem scriptSystem;
	
	public Application() throws Exception {
		_appStates = AppStates.INIT;
		screen = new Screen(this);
		add(screen);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//用户单击窗口的关闭按钮时程序执行的操作
		setFocusable(true);	//设置焦点为true
		addKeyListener(input);	
		addMouseListener(input);
		addMouseMotionListener(input);
		setLocation((int)Setting.WindowRect.x, (int)Setting.WindowRect.y);
		setSize((int)Setting.WindowSize.x,(int)Setting.WindowSize.y);
		
		setUndecorated(Setting.WIndwUndecorated);
		 //设置窗体可见，没有该语句，窗体将不可见，此语句必须有，否则没有界面就没有如何意义了
		setVisible(true);
		/////////////////////////////////////////////////////////////////////////////////////////////
		//add System Sington/////////////////////////////////////////////////////////////////////
		collisionSystem = CollisionSystem.getSystem();
		timeSystem = TimeSystem.getSystem();
		scriptSystem = ScriptSystem.getSystem();
		/////////////////////////////////////////////////////////////////////////////////////////////
	}
	/*
	 * 框架核心循环
	 */
	public void runLoop() {
		double  oldTime = System.currentTimeMillis();
		double newTime = System.currentTimeMillis();
		_appStates = AppStates.RUNING;
		while(isRun && _appStates == AppStates.RUNING) {
			oldTime = newTime;
			newTime = System.currentTimeMillis();
			deltaTime = newTime - oldTime;
			FPS = (int)(1000.0 / deltaTime);
			/////////////////////////////////////////////////////////////////////////////////////////////
			//add addSystemRunLoop////////////////////////////////////////////////////////////////
			collisionSystem.addSystemRunLoop();
			scriptSystem.addSystemRunLoop();
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			tickComponent();
			screen.repaint();
			try {
				Thread.sleep(10);
			} catch(Exception e) {
				System.out.println("Failed to sleep");
			}
		}
	}
	/*
	 * 初始化游戏调用此方法
	 */
	public void init() {
		/////////////////////////////////////////////////////////////////////////////////////////////
		//add addSystemInit///////////////////////////////////////////////////////////////////////
		timeSystem.addSystemInit();
		scriptSystem.addSystemInit();
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////
	}
	/*
	 * 每帧调用一次此方法
	 */
	public void tickComponent() {
		
	}
	/*
	 * 游戏结束调用此方法
	 */
	public void destruction() {
		/////////////////////////////////////////////////////////////////////////////////////////////
		//add addSystemDestruction/////////////////////////////////////////////////////////////
		scriptSystem.addSystemDestruction();
		/////////////////////////////////////////////////////////////////////////////////////////////
		_appStates = AppStates.SHUTDOWN;
	}
	/*
	 * 接收键值为keyCode键盘按键按下发生事件
	 */
	public void keyPressed(int keyCode) {
	
	}
	/*
	 * 接收键值为keyCode键盘按键释放发生事件
	 */
	public void keyReleased(int keyCode) {
		if(keyCode==KeyCodeIndex.ESC){
			dispose();
			_appStates = AppStates.SHUTDOWN;
		}
	}
	
	public void MousePressed(int mouseIndex) {
		
	}
	
	public void MouseReleased(int mouseIndex) {
		
	}
}
