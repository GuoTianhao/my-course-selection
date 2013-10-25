package com.ui.bcswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import com.ui.myswing.MFrame;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class TipFrame extends MFrame {
	private static int width = 200;
	private static int height = 100;
	private static Color default_bColor = Color.BLUE;
	private static Color default_tColor = Color.YELLOW;
	private static Font font;
	private MLabel label;
	private MPanel panel;

	public TipFrame(Point loc, String tip) {
		super(false, loc, new Dimension(width, height));
		font = new Font("∫⁄ÃÂ", Font.PLAIN, 40);
		label = new MLabel(new Point(0, 0), new Dimension(width, height),
				textFactory(tip));
		panel = new MPanel();
		panel.setLayout(null);
		panel.setBackground(default_bColor);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
		System.out.println(tip.length());
	}

	private String textFactory(String text) {
		String str = "<html><font color='" + default_tColor + "' face='"
				+ font.getFontName() + "' size='" + (font.getSize()) + "'>"
				+ text + "</font></html>";
		return str;
	}
}
