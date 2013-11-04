package com.ui.myswing;

import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class MPanel extends JPanel {
	public MPanel(Dimension size) {
		this();
		setLayout(null);
		setSize(size);
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
	}

}
