package com.ui.myswing;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MButton extends JButton {
	private final Dimension default_size=new Dimension(100,30);
	public MButton(ImageIcon defaultIcon, ImageIcon pressedIcon,
			ImageIcon rolloverIcon, Point location, Dimension size) {
		setIcon(defaultIcon);
		setPressedIcon(pressedIcon);
		setRolloverIcon(rolloverIcon);
		setRolloverEnabled(true);
		if(!(defaultIcon==null&&pressedIcon==null&&rolloverIcon==null)){
			setContentAreaFilled(false);
			this.setBorderPainted(false);
		}
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
	public void setSize(Dimension size){
		if(size!=null){
			super.setSize(size);
		}else{
			super.setSize(default_size);
		}
	}
}
