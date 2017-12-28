package pers.LINKH.Game;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.Compontent.UI.UICompontent;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Operate.Input;




public class UISystem  extends FrameSystem{
	private static UISystem instance;
	List<UICompontent> compontents = new ArrayList<UICompontent>() ;
	private UISystem() {}
	public void addButton(UICompontent compontent) {
		compontents.add(compontent);
	}
	public void deleteButton(int keyValue) {
		for(UICompontent checkValue :  compontents) {
			if(checkValue.keyValue == keyValue) {
				compontents.remove(checkValue);
				return;
			}
		}
	}
	//检查鼠标是否在控件按下
	public List<UICompontent> pressedCompontents() {
		 List<UICompontent> comp = new ArrayList<UICompontent>();
		 if(compontents.size()==0) {
			 return comp;
		 }
			
		 for(UICompontent compontent :compontents ) {

			 if(compontent.isDown == false && isHitCompant(compontent)) {
				 compontent.isDown = true;
				 comp.add(compontent);
			 }
		 }
		 return comp;
	}
	
	public void performPressedCompontents() {
		if(compontents.size()==0) 
			return;

		for(UICompontent comp: pressedCompontents()) {

			comp.mouseBegain();
		}
	}

	public boolean isHitCompant(UICompontent comp) {
		Vector2 mousePosition = Input.getMouseLocation();
		return (int)comp.location.x-(int)comp.width/2<=(int)mousePosition.x && 
				(int)comp.location.x+(int)comp.width/2>=(int)mousePosition.x &&
				(int)comp.location.y-(int)comp.height/2<=(int)mousePosition.y &&
				(int)comp.location.y+(int)comp.height/2>=(int)mousePosition.y ;
	}

	//检查鼠标是否在控件弹起
		public List<UICompontent> releasedCompontents() {
			 List<UICompontent> comp = new ArrayList<UICompontent>();
			 if(compontents.size()==0) {
				 return comp;
			 }
			 for(UICompontent compontent :compontents ) {
				 if(compontent.isDown == true) {
					 compontent.isDown = false;
					 comp.add(compontent);
				 }
			 }
			 return comp;
		}
		
		public void performReleasedCompontents() {
			if(compontents.size()==0) 
				return;
			for(UICompontent comp: releasedCompontents()) {
				comp.mouseRelease();
			}
		}


	public static UISystem getSystem() {
		if(instance==null) {
			instance = new UISystem();
		}
		return instance;
	}

	@Override
	public void addSystemMousePressed() {	

		performPressedCompontents();
	}

	@Override
	public void addSystemMouseReleased() {
		performReleasedCompontents();
	}
}
