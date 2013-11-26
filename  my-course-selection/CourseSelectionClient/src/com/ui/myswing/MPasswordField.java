package com.ui.myswing;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPasswordField;
import javax.swing.text.Document;

import com.ui.input.ValidInput;

public class MPasswordField extends JPasswordField implements ValidInput {
	private ValidInput validInput;

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

	public boolean isValidInput() {
		boolean isValid = validInput.isValid();
		return isValid;
	}

	public void setValidInput(ValidInput validInput) {
		this.validInput = validInput;
	}

}
