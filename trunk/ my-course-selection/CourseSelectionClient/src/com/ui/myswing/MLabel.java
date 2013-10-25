package com.ui.myswing;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public class MLabel extends JLabel {
	public MLabel(Point location,Dimension size){
		this(location,size,null);
	}
	public MLabel(Point location, Dimension size,String text) {
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
}
