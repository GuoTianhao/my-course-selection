package com.ui.bcswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class TipFrame extends MFrame {
	private static int clock = 200;
	private static float opacityPoint = (float) 0.3;
	private static int width = 200;
	private static int height = 100;
	private static Color default_bColor = new Color(0xBF3EFF);
	private static Color default_tColor = Color.RED;
	private static Font font;
	private MLabel label;
	private MPanel panel;

	public TipFrame(Point loc, Dimension size,int font_size, String tip) {
		super(new Dimension(width, height));
		this.setUndecorated(true);
		this.setOpacity(opacityPoint);
		
		this.setLocation(new Point(loc.x+size.width/2-width/2,loc.y+size.height/2-height/2));
		font = new Font("TimesRoman", Font.BOLD, font_size);
		label = new MLabel(new Point(0, 0), new Dimension(width, height),
				textFactory(tip));
		panel = new MPanel();
		panel.setLayout(null);
		panel.setBackground(default_bColor);
		panel.add(label);
		this.add(panel);
	//	this.add(label);
		this.setVisible(true);
	}

	private String textFactory(String text) {
		String str = "<html><font color='" + default_tColor + "' face='"
				+ font.getFontName() + "' size='" + (font.getSize()) + "'>"
				+ text + "</font></html>";
		return str;
	}

	public void startEndClock() {
		startEndClock(-1);
	}

	public void startEndClock(int time) {
		if (time >= 0) {
			clock = time;
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

	public static void main(String[] args) {
		try {
			// 设置本属性将改变窗口边框样式定义
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			 UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			// TODO exception
		}
		TipFrame t = new TipFrame(new Point(200, 200),new Dimension(100,100), 10, "Welcome!");
		 t.startEndClock();
	}
}
