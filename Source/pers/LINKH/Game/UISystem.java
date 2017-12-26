package pers.LINKH.Game;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.Compontent.UI.Button;
import pers.LINKH.Game.Compontent.UI.UICompontent;
import pers.LINKH.Game.Helper.Vector2;
import pers.LINKH.Game.Operate.Input;



public class UISystem  implements FrameSystem{
	
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
	public List<UICompontent> checkMouseButton() {
		 List<UICompontent> comp = new ArrayList<UICompontent>();
		 if(compontents.size()==0) {
			 return comp;
		 }
		 for(UICompontent compontent :compontents ) {
			 if(isHitCompant(compontent)) {
				 comp.add(compontent);
			 }
		 }
			 
		 return comp;
	}
	public void performMouseButton() {
		if(compontents.size()==0) 
			return;
		for(UICompontent comp: checkMouseButton()) {
			comp.mouseOn();
		}
	}
	public boolean isHitCompant(UICompontent comp) {
		Vector2 mousePosition = Input.getMouseLocation();
		return comp.location.x-comp.width/2<=mousePosition.x && 
				comp.location.x+comp.width/2>=mousePosition.x && 
				comp.location.y-comp.height/2<=mousePosition.y &&
				comp.location.y+comp.height/2>=mousePosition.y ;
	}

	public static UISystem getSystem() {
		if(instance==null) {
			instance = new UISystem();
		}
		return instance;
	}

	
	
	@Override
	public void addSystemInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSystemRunLoop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSystemDestruction() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addSystemKeyPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSystemKeyReleased() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSystemMousePressed() {
		// TODO Auto-generated method stub
		performMouseButton();
	}

	@Override
	public void addSystemMouseReleased() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSystemMouseMoved() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSystemMouseDragged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSystemMouseClicked() {
		// TODO Auto-generated method stub
		
	}
}
