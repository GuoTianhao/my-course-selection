package com.ui.myswing;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Point;

import javax.swing.JFrame;

public class MFrame extends JFrame {
	private static int clock = 2000;
	private static float opacityPoint = (float) 0.3;

	public MFrame() throws HeadlessException {
		super();
	}

	public MFrame(GraphicsConfiguration gc) {
		super(gc);
	}

	public MFrame(String title) throws HeadlessException {
		super(title);
	}

	public MFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

	public MFrame(boolean opacity, Point location, Dimension size) {
		if (!opacity) {
			this.setUndecorated(true);
			this.setOpacity(opacityPoint);
		}
		if (location != null) {
			this.setLocation(location);
		}
		if (size != null) {
			this.setSize(size);
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void startEndClock(){
		startEndClock(-1);
	}
	public void startEndClock(int time) {
		if(time>=0){
			clock=time;
		}
		new CloseClock().start();
	}

	private class CloseClock extends Thread {
		private long startTime;
		private long instance;

		public CloseClock() {
			startTime = System.currentTimeMillis();
		}

		public void run() {
			while ((instance - startTime) <= clock) {
				instance = System.currentTimeMillis();
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			MFrame.this.dispose();
		}
	}
}
