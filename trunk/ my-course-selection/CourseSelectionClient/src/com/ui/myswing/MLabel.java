package com.ui.myswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public class MLabel extends JLabel {
	private static Color default_Color = new Color(0xBF3EFF);

	public MLabel(Point location, Dimension size) {
		this(location, size, null);
	}

	public MLabel(Point location, Dimension size, String text) {
		super();
		this.setLocation(location);
		this.setSize(size);
		this.setText(text);
		setHorizontalAlignment(CENTER);
	}

	public MLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
	}

	public MLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
	}

	public MLabel(String text) {
		super(text);
		setHorizontalAlignment(CENTER);
	}

	public MLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
	}

	public MLabel(Icon image) {
		super(image);
	}

	public MLabel() {
		super();
	}

	public void setText(String text) {
		super.setText(textFactory(text));
	}

	private String textFactory(String text) {
//		Font font = this.getFont();
		String str=text;
//		if (font != null) {
//			str = "<html><font color='" + default_tColor + "' face='"
//					+ font.getFontName() + "' size='" + (font.getSize()) + "'>"
//					+ text + "</font></html>";
//		}
//		System.out.println(str);
		return str;
	}
}
