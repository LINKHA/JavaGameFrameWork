
package pers.LINKH.Game;


import javax.swing.JFrame;
import pers.LINKH.Game.Helper.KeyCodeIndex;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Operate.Input;
import pers.LINKH.Game.Setting.Setting;


public class Application extends JFrame{
	/**
	 * �汾 V1.0
	 */
	private static final long serialVersionUID = 1L;
	public static AppStates _appStates = AppStates.INVLID;
	public Screen screen;
	public boolean isRun = true;
	public Input input =new Input(this);
/////////////////////////////////////////////////////////////////////////////////////////////
//��¶��Ӧ�ò������
//��:Application
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
	 * ��ܺ���ѭ��
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
//ϵͳ��ӷ����б�
/////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * ��ʼ����Ϸ���ô˷���
	 */
	public void init() {
		timeSystem.addSystemInit();
		scriptSystem.addSystemInit();
	}
	/*
	 * ÿ֡����һ�δ˷���
	 * ��ʱ����
	 */
	public void tickComponent() {
		collisionSystem.addSystemRunLoop();
		scriptSystem.addSystemRunLoop();
		animationSystem.addSystemRunLoop();
	}
	/*
	 * ��Ϸ�������ô˷���
	 */
	public void destruction() {
		scriptSystem.addSystemDestruction();
		_appStates = AppStates.SHUTDOWN;
	}
	/*
	 * ���ռ�ֵΪkeyCode���̰������·����¼�
	 * ���ܷ���
	 * ˲ʱ����
	 */
	public void keyPressed(int keyCode) {
	
	}
	/*
	 * ���ռ�ֵΪkeyCode���̰����ͷŷ����¼�
	 * ���շ���
	 * ˲ʱ����
	 */
	public void keyReleased(int keyCode) {
		if(keyCode==KeyCodeIndex.ESC) {
			_appStates = AppStates.SHUTDOWN;
			System.exit(0);
		}
/////////////////////////////////////////////////////////////////////////////////////////////
		
		
	}
	/*
	 * ���ܼ�ֵΪmouseIndex��갴���¼�
	 * ���շ���
	 * ˲ʱ����
	 */
	public void MousePressed(int mouseIndex) {
		bMouseDown = true;
		mouseDown();
/////////////////////////////////////////////////////////////////////////////////////////////
		uiSystem.addSystemMousePressed();
	}
	/*
	 * ������갴��״̬�¼�
	 * ���ܷ���
	 * ��ʱ����
	 */
	public void mouseDown() {

	}
	/*
	 * ���ռ�ֵΪmouseIndex����ͷ��¼�
	 * ���շ���
	 * ˲ʱ����
	 */
	public void MouseReleased(int mouseIndex) {
		bMouseDown = false;
/////////////////////////////////////////////////////////////////////////////////////////////
		uiSystem.addSystemMouseReleased();
	}
	/*
	 * ��������ƶ��¼�
	 * ���շ���
	 * ��ʱ����
	 * @Param
	 */
	public void mouseMoved(Vector2 location) {

	}	
	/*
	 * ��������϶��¼�
	 * ���շ���
	 * ��ʱ����
	 */
	public void mouseDragged() {

	}
	/*
	 * ����������¼�(�ͷ�ʱ����)
	 * ���շ���
	 * ˲ʱ����
	 */
	public void mouseClicked() {

	}
}
