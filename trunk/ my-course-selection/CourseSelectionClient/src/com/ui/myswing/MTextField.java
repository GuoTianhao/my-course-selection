package com.ui.myswing;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.text.Document;

import com.ui.input.ValidInput;

public class MTextField extends JTextField implements ValidInput{
	private ValidInput validInput;
	public MTextField() {
		super(null, null, 0);
	}

	public MTextField(String text) {
		super(null, text, 0);

	}

	public MTextField(int columns) {
		super(null, null, columns);
	}

	public MTextField(String text, int columns) {
		super(null, text, columns);
	}

	public MTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
	}

	public MTextField(Point location, Dimension size) {
		setLocation(location);
		setSize(size);
	}
	
	public boolean isValidInput(){
		return false;
	}
	
	public void setValidInput(ValidInput validInput){
		this.validInput=validInput;
	}
}
