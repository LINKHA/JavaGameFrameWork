package pers.LINKH2.TimeScript;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.ScriptSuper;
import pers.LINKH.Game.Compontent.Animator;
import pers.LINKH.Game.Compontent.Collider;
import pers.LINKH.Game.Compontent.GameObject;
import pers.LINKH.Game.Compontent.Sprite;
import pers.LINKH.Game.Helper.ScreenSize;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Operate.Input;
import pers.LINKH.Game.Setting.Layout;
import pers.LINKH.Game.Setting.Tag;
import pers.LINKH.Game.Tools.LKTimer;
import pers.LINKH.Game.Tools.LoadAnimation;
import pers.LINKH.Game.Tools.Log;
import pers.LINKH.Game.Tools.Random;

class Pair{
	public Pair(GameObject up , GameObject down){
		Up = up;
		Down = down;
	}
	public GameObject Up;
	public GameObject Down;
}

public class Game extends ScriptSuper{
	
	static GameObject gameObject;
	static GameObject MainMenuGround;
	static GameObject MainMenuGround2;
	
	List<Pair> pipes = new ArrayList<Pair>();
	boolean isJump = false;
	int frameCount = 0;
	final static int FRAME_COUNT_DEFINE = 50;
	/// 这是时间控制器 0毫秒延时后 每4000毫秒返回一次true
	LKTimer aLkTimer=new LKTimer(4000, 0);
	/**
	* @brief : 设置其为false使得不会在游戏开始时开启 
	*/
	public Game(){
		super.enable = false;
		Scriptname = "Game";
	}
	/**
	* @brief :  设置player 以及两个背景图像
	*/
	public void Init() {
		gameObject =new GameObject( new Vector2(ScreenSize.WIDTH/2 - 500,ScreenSize.HEIGHT/2), 200, 200);
		gameObject.addSprite(new Sprite("Assets/bird2_001.png",gameObject));
		gameObject.addAnimator(new Animator(LoadAnimation.load("Assets/bird2_00",".png", 1, 3),15,  gameObject));
		gameObject.addCollider(new Collider(gameObject));
		
		MainMenuGround = new GameObject( new Vector2(ScreenSize.WIDTH/2,ScreenSize.HEIGHT/2), ScreenSize.WIDTH, ScreenSize.HEIGHT,Layout.BackGround);
		MainMenuGround.addSprite(new Sprite("Assets/bg_day.png",MainMenuGround));

		MainMenuGround2 = new GameObject( new Vector2(ScreenSize.WIDTH * 1.5f,ScreenSize.HEIGHT/2), ScreenSize.WIDTH, ScreenSize.HEIGHT,Layout.BackGround);
		MainMenuGround2.addSprite(new Sprite("Assets/bg_day.png",MainMenuGround2));
		
	}
	
	public void RunLoop() {
///////////////////////////////////////////////////////////////////////////
//@brief :  设置背景对象移动并重置位置

		MainMenuGround2.move(-1, 0);
		MainMenuGround.move(-1, 0);
		if(MainMenuGround.getPosition().x<=-(ScreenSize.WIDTH/2))
			MainMenuGround.setPosition(ScreenSize.WIDTH* 1.5f, ScreenSize.HEIGHT/2);
		
		if(MainMenuGround2.getPosition().x<=-(ScreenSize.WIDTH/2))
			MainMenuGround2.setPosition(ScreenSize.WIDTH* 1.5f,ScreenSize.HEIGHT/2);

//////////////////////////////////////////////////////////////////////////
		///得到时间控制器boolean值
		boolean aTime = aLkTimer.timer();
		///每4000毫秒创建一次管道
		if(aTime)
			CreatePipe();
		///判断player是否碰撞管道以及边界
		DetermineCollide();
		
		MovePipe();
		///删除移到左边的管道
		DeletePipe();
		///控制player自由落体  以及向上减速度
		BirdMove(isJump);
		///如果鼠标点击  player跳
		if(Input.hitMouse()){
			frameCount = FRAME_COUNT_DEFINE;
			isJump = true;
		}
	}
	public void Destruction() {
		// TODO Auto-generated method stub
	}

	void CreatePipe(){
		int location = Random.Rang(0,200);
		GameObject up = new GameObject( new Vector2(ScreenSize.WIDTH +100,ScreenSize.HEIGHT -100 + location), 200, 500,Tag.Enemy,Layout.Sprite);
		up.addSprite(new Sprite("Assets/pipe_up.png",up));
		up.addCollider(new Collider(up));
		
		GameObject down = new GameObject( new Vector2(ScreenSize.WIDTH  +100 ,-100 + location), 200, 500,Tag.Enemy,Layout.Sprite);
		down.addSprite(new Sprite("Assets/pipe_down.png",down));
		down.addCollider(new Collider(down));
		Pair pipe =new Pair(up, down);
		
		pipes.add(pipe);
	}
	
	void DeletePipe() {
		for(Pair p : pipes) {
			if(p.Down.getPosition().x<-100){
				p.Down.Destroy();
				p.Up.Destroy();
				pipes.remove(p);
				break;
			}
		}
	}
	
	void MovePipe() {
		for(Pair p : pipes) {
			p.Down.move(-2, 0);
			p.Up.move(-2, 0);
		}
	
	}
	
	void BirdMove(boolean isJump) {
		if(isJump){
			Jump();
		}else {
			FreeFall();
		}
	}
	
	void DetermineCollide() {
		if(gameObject.getCollision().hit(Tag.Enemy)) {
			ClearScene();
		}
		if(gameObject.getPosition().y >=ScreenSize.HEIGHT  || gameObject.getPosition().y <=0) {
			ClearScene();
		}
	}
	
	void ClearScene() {
		gameObject.Destroy();
		MainMenuGround.Destroy();
		MainMenuGround2.Destroy();
		for(Pair p : pipes) {
			p.Down.Destroy();
			p.Up.Destroy();
		}
		pipes.clear();
		super.enable = false;
		ScriptOn("Menu");
	}
	
	void Jump() {
		if(frameCount<=0)
			isJump = false;
		frameCount--;
		gameObject.move(0, -frameCount/5);
	}
	
	void FreeFall() {
		frameCount++;
		gameObject.move(0, frameCount/5);
	}
	
}