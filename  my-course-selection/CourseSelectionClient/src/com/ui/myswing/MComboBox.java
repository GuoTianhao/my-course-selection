package com.ui.myswing;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class MComboBox<E> extends JComboBox {
	public MComboBox(E[] items, Point loc, Dimension size) {
		this(items);
		this.setLocation(loc);
		this.setSize(size);
	}
	
	public MComboBox(ComboBoxModel<E> aModel) {
		super(aModel);
	}

	public MComboBox(E[] items) {
		super(items);
	}

	public MComboBox(Vector<E> items) {
		super(items);
	}

	public MComboBox() {
		super();
	}
}
