package pers.LINKH.Game.Setting;

/*
 * 层次键值小的会被层次键值大的遮住
 * 如果没有设置层次默认为Default
 */
public enum Layout {
/////////////////////////////////////////////////////////////////////////////////////////////
//系统定义
//可修改
/////////////////////////////////////////////////////////////////////////////////////////////
BackGround,
Wall,
Sprite,

/////////////////////////////////////////////////////////////////////////////////////////////
//用户定义









/////////////////////////////////////////////////////////////////////////////////////////////
//系统定义
//不能修改
/////////////////////////////////////////////////////////////////////////////////////////////
Default;


	private  int value;
	Layout(){
		 this(Counter.nextValue);
	}
	Layout(int value) {
		this.value = value;
		Counter.nextValue = value + 1;
	}
	public int getValue(){
	    return value;
	}
	private static class Counter{
	     private static int nextValue = 0;
	}
}
