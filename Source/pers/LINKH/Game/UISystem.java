package pers.LINKH.Game;
/////////////////////////////////////////////////////////////////////////////////////////////
//�����

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.Compant.UI.Button;
import pers.LINKH.Game.Compant.UI.UICompant;

public class UISystem  implements FrameSystem{
	
	private static UISystem instance;
	
	List<UICompant> buttons = new ArrayList<UICompant>() ;
	
	
	private UISystem() {}
	
	//�������Ƿ��ڿؼ�����
	public void checkMouseButton() {
		
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

	public static UISystem getSystem() {
		if(instance==null) {
			instance = new UISystem();
		}
		return instance;
	}
}
