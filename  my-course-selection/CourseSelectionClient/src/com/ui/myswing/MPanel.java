package com.ui.myswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Point;

import javax.swing.JPanel;

public class MPanel extends JPanel {
	public MPanel(Point loc,Dimension size){
		this(size);
		this.setLocation(loc);
	}
	
	public MPanel(Dimension size) {
		this();
		this.setSize(size);
		this.setPreferredSize(size);
	}

	public MPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		setBackground(Color.WHITE);
	}

	public MPanel(LayoutManager layout) {
		super(layout);
		setBackground(Color.WHITE);
	}

	public MPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		setBackground(Color.WHITE);
	}

	public MPanel() {
		super();
		setLayout(null);
		setBackground(Color.WHITE);
	}
	
	public void refresh(){
		this.validate();
		this.repaint();
	}

}
