package com.ui.myswing;


import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.Document;

import com.ui.input.InvalidAction;
import com.ui.input.ValidInput;

public class MTextField extends JTextField implements ValidInput {
	private ValidInput validInput;
	private InvalidAction action;
	public MTextField() {
		this(null, null, 0);
		setFont(MFont.textFont);
	}

	public MTextField(String text) {
		this(null, text, 0);
		setFont(MFont.textFont);

	}

	public MTextField(int columns) {
		this(null, null, columns);
		setFont(MFont.textFont);
	}

	public MTextField(String text, int columns) {
		this(null, text, columns);
		setFont(MFont.textFont);
	}

	public MTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		setFont(MFont.textFont);
	}

	public MTextField(Point location, Dimension size) {
		setLocation(location);
		setSize(size);
		setFont(MFont.textFont);
	}
	
	public boolean isValidInput() {
		boolean isValid = true;
		if(validInput!=null){
			isValid =validInput.isValid();
		}
		return isValid;
	}

	public void setValidInput(ValidInput validInput) {
		this.validInput = validInput;
	}
	public void setTextandBool(String string,boolean bool) {
		setText(string);
		setEditable(bool);
	}
}
