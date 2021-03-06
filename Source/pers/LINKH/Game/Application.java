
package pers.LINKH.Game;


import javax.swing.JFrame;
import pers.LINKH.Game.Helper.KeyCodeIndex;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Operate.Input;
import pers.LINKH.Game.Setting.Setting;


public class Application extends JFrame{
	/**
	 * 版本 V1.0
	 */
	private static final long serialVersionUID = 1L;
	public static AppStates _appStates = AppStates.INVLID;
	public Screen screen;
	public boolean isRun = true;
	public Input input =new Input(this);
/////////////////////////////////////////////////////////////////////////////////////////////
//暴露给应用层的属性
//类:Application
	public  double deltaTime = 0.0f;
	public  int FPS = 0;
/////////////////////////////////////////////////////////////////////////////////////////////
	private boolean bMouseDown = false;
	/*
	 * Game Frame System
	 */
	FrameSystem collisionSystem;
	FrameSystem timeSystem;
	FrameSystem scriptSystem;
	FrameSystem uiSystem;
	FrameSystem animationSystem;
	
	public Application() throws Exception {
		_appStates = AppStates.INIT;
		screen = new Screen(this);
		add(screen);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);	
		addKeyListener(input);	
		addMouseListener(input);
		addMouseMotionListener(input);
		setLocation((int)Setting.WindowRect.x, (int)Setting.WindowRect.y);
		setSize((int)Setting.WindowSize.x,(int)Setting.WindowSize.y);
		setUndecorated(Setting.WIndwUndecorated);
		setVisible(true);
		/////////////////////////////////////////////////////////////////////////////////////////////
		//add System Sington/////////////////////////////////////////////////////////////////////
		collisionSystem = CollisionSystem.getSystem();
		timeSystem = TimeSystem.getSystem();
		scriptSystem = ScriptSystem.getSystem();
		uiSystem = UISystem.getSystem();
		animationSystem = AnimationSystem.getSystem();
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
			if(bMouseDown == true) {
				mouseDown();
			}
			tickComponent();
			screen.repaint();
			try {
				Thread.sleep((long)1000.0/Setting.FPS);
			} catch(Exception e) {
				System.out.println("Failed to sleep");
			}
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////
//系统添加方法列表
/////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * 初始化游戏调用此方法
	 */
	public void init() {
		timeSystem.addSystemInit();
		scriptSystem.addSystemInit();
	}
	/*
	 * 每帧调用一次此方法
	 * 即时方法
	 */
	public void tickComponent() {
		collisionSystem.addSystemRunLoop();
		scriptSystem.addSystemRunLoop();
		animationSystem.addSystemRunLoop();
	}
	/*
	 * 游戏结束调用此方法
	 */
	public void destruction() {
		scriptSystem.addSystemDestruction();
		_appStates = AppStates.SHUTDOWN;
	}
	/*
	 * 接收键值为keyCode键盘按键按下发生事件
	 * 接受方法
	 * 瞬时方法
	 */
	public void keyPressed(int keyCode) {
	
	}
	/*
	 * 接收键值为keyCode键盘按键释放发生事件
	 * 接收方法
	 * 瞬时方法
	 */
	public void keyReleased(int keyCode) {
		if(keyCode==KeyCodeIndex.ESC) {
			_appStates = AppStates.SHUTDOWN;
			System.exit(0);
		}
/////////////////////////////////////////////////////////////////////////////////////////////
		
		
	}
	/*
	 * 接受键值为mouseIndex鼠标按下事件
	 * 接收方法
	 * 瞬时方法
	 */
	public void MousePressed(int mouseIndex) {
		bMouseDown = true;
		mouseDown();
/////////////////////////////////////////////////////////////////////////////////////////////
		uiSystem.addSystemMousePressed();
	}
	/*
	 * 接收鼠标按下状态事件
	 * 接受方法
	 * 即时方法
	 */
	public void mouseDown() {

	}
	/*
	 * 接收键值为mouseIndex鼠标释放事件
	 * 接收方法
	 * 瞬时方法
	 */
	public void MouseReleased(int mouseIndex) {
		bMouseDown = false;
/////////////////////////////////////////////////////////////////////////////////////////////
		uiSystem.addSystemMouseReleased();
	}
	/*
	 * 接收鼠标移动事件
	 * 接收方法
	 * 即时方法
	 * @Param
	 */
	public void mouseMoved(Vector2 location) {

	}	
	/*
	 * 接收鼠标拖动事件
	 * 接收方法
	 * 即时方法
	 */
	public void mouseDragged() {

	}
	/*
	 * 接收鼠标点击事件(释放时调用)
	 * 接收方法
	 * 瞬时方法
	 */
	public void mouseClicked() {

	}
}
