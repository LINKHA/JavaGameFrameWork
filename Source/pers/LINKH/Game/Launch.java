package pers.LINKH.Game;



public class Launch {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Application application = new Application();
		application.init();
		application.runLoop();
		application.destruction();
		System.exit(0);
	}
}
