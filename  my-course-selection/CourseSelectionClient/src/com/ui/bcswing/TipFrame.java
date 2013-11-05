package com.ui.bcswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class TipFrame extends MFrame {
	private static int clock = 200;
	private static float opacityPoint = (float) 0.3;
	private static int width = 200;
	private static int height = 100;
	private static Color default_bColor = new Color(0xBF3EFF);
	private static Color default_tColor = Color.YELLOW;
	private static Font font;
	private MLabel label;
	private MPanel panel;

	public TipFrame(Point loc,int font_size, String tip) {
		super();
		this.setUndecorated(true);
		this.setOpacity(opacityPoint);
		this.setLocation(loc);
		this.setSize(new Dimension(width, height));
		font = new Font("TimesRoman", Font.BOLD,font_size);
		label = new MLabel(new Point(0, 0), new Dimension(width, height),
				textFactory(tip));
		panel = new MPanel();
		panel.setLayout(null);
		panel.setBackground(default_bColor);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}

	private String textFactory(String text) {
		String str = "<html><font color='" + default_tColor + "' face='"
				+ font.getFontName() + "' size='" + (font.getSize()) + "'>"
				+ text + "</font></html>";
		return str;
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
			TipFrame.this.dispose();
		}
	}
}
