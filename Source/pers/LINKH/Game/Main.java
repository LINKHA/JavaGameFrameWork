package pers.LINKH.Game;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Application application = new Application();
		application.init();
		application.runLoop();
		application.destruction();
		System.exit(0);
	}
}
