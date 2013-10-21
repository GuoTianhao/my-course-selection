package com.ui.myswing;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPasswordField;
import javax.swing.text.Document;

public class MPasswordField extends JPasswordField {
	public MPasswordField(Point location, Dimension size) {
		super();
		setLocation(location);
		setSize(size);
	}

	public MPasswordField() {
		super();
	}

	public MPasswordField(String text) {
		super(text);
	}

	public MPasswordField(int columns) {
		super(columns);
	}

	public MPasswordField(String text, int columns) {
		super(text, columns);
	}

	public MPasswordField(Document doc, String txt, int columns) {
		super(doc, txt, columns);
	}

}
