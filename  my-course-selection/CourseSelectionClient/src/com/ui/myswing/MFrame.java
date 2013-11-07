package com.ui.myswing;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Point;

import javax.swing.JFrame;

public class MFrame extends JFrame {

	public MFrame() throws HeadlessException {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public MFrame(Dimension size){
		this();
		this.setSize(size);
	}
	public void refresh(){
		this.validate();
		this.repaint();
	}
}
