
package pers.LINKH.Game;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import pers.LINKH.Game.Compontent.GameObject;
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
//��¶��Ӧ�ò������
//��:Application
	public static double deltaTime = 0.0f;
	public static int FPS = 0;
/////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * Game Frame System
	 */
	FrameSystem collisionSystem;
	FrameSystem timeSystem;
	FrameSystem scriptSystem;
	FrameSystem uiSystem;
	
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
	 * ��ʼ����Ϸ���ô˷���
	 */
	public void init() {
		/////////////////////////////////////////////////////////////////////////////////////////////
		//add addSystemInit///////////////////////////////////////////////////////////////////////
		timeSystem.addSystemInit();
		scriptSystem.addSystemInit();
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////
	}
	/*
	 * ÿ֡����һ�δ˷���
	 */
	public void tickComponent() {
		
	}
	/*
	 * ��Ϸ�������ô˷���
	 */
	public void destruction() {
		/////////////////////////////////////////////////////////////////////////////////////////////
		//add addSystemDestruction/////////////////////////////////////////////////////////////
		scriptSystem.addSystemDestruction();
		/////////////////////////////////////////////////////////////////////////////////////////////
		_appStates = AppStates.SHUTDOWN;
	}
	/*
	 * ���ռ�ֵΪkeyCode���̰������·����¼�
	 * ���ܷ���
	 */
	public void keyPressed(int keyCode) {
	
	}
	/*
	 * ���ռ�ֵΪkeyCode���̰����ͷŷ����¼�
	 * ���շ���
	 */
	public void keyReleased(int keyCode) {
		if(keyCode==KeyCodeIndex.ESC) {
			_appStates = AppStates.SHUTDOWN;
			System.exit(0);
		}
	}
	/*
	 * ���ܼ�ֵΪmouseIndex��갴���¼�
	 * ���շ���
	 */
	public void MousePressed(int mouseIndex) {
		uiSystem.addSystemMousePressed();
	}
	/*
	 * ���ռ�ֵΪmouseIndex����ͷ��¼�
	 * ���շ���
	 */
	public void MouseReleased(int mouseIndex) {

	}
	/*
	 * ��������ƶ��¼�
	 * ���շ���
	 */
	public void mouseMoved(Vector2 location) {

	}	
	/*
	 * ��������϶��¼�
	 * ���շ���
	 */
	public void mouseDragged() {

	}
	/*
	 * ����������¼�(�ͷ�ʱ����)
	 * ���շ���
	 */
	public void mouseClicked() {

	}
}
