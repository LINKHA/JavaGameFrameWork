package pers.LINKH.Game;

import java.util.ArrayList;
import java.util.List;

import pers.LINKH.Game.Compontent.Animator;

public class AnimationSystem extends FrameSystem{
	private static AnimationSystem instance;
	List<Animator> animators = new ArrayList<Animator>();
	
	
	private AnimationSystem() {}
	public void addAnimator(Animator animator) {
		animators.add(animator);
	}
	public void deleteAnimator(int keyValue) {
		for(Animator checkValue : animators) {
			if(checkValue.keyValue == keyValue) {
				animators.remove(checkValue);
				return;
			}
		}
	}
	public void runAnimation() {
		for(Animator animator : animators) {
			animator.run();
		}
	}
	public static AnimationSystem getSystem() {
		if(instance==null) {
			instance = new AnimationSystem();
		}
		return instance;
	}
	@Override
	public void addSystemRunLoop() {
		runAnimation();
	}
}
