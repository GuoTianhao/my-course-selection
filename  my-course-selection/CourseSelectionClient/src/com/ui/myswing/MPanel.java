package com.ui.myswing;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;

import javax.swing.JPanel;

public class MPanel extends JPanel {
	public MPanel(Dimension size) {
		this();
		this.setSize(size);
		this.setPreferredSize(size);
	}
	
	public MPanel(Point loc,Dimension size){
		this(size);
		this.setLocation(loc);
	}

	public MPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	public MPanel(LayoutManager layout) {
		super(layout);
	}

	public MPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public MPanel() {
		super();
		setLayout(null);
	}
	
	public void refresh(){
		this.validate();
		this.repaint();
	}

}
