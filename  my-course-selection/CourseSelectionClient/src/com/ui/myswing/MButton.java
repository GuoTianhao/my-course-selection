package com.ui.myswing;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MButton extends JButton {
	public MButton(ImageIcon defaultIcon, ImageIcon pressedIcon,
			ImageIcon rolloverIcon, Point location, Dimension size) {
		setIcon(defaultIcon);
		setPressedIcon(pressedIcon);
		setRolloverIcon(rolloverIcon);
		setRolloverEnabled(true);
		setContentAreaFilled(false);
		setLocation(location);
		setSize(size);
	}

	public MButton() {
		super(null, null);
	}

	public MButton(Icon icon) {
		super(null, icon);
	}

	public MButton(String text) {
		super(text, null);
	}

	public MButton(Action a) {
		super(a);
	}

	public MButton(String text, Icon icon) {
		super(text, icon);
	}
}
