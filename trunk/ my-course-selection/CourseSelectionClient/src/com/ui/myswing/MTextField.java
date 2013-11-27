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

import com.ui.input.ValidInput;

public class MTextField extends JTextField implements ValidInput {
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
		initEvent();
		limitInput();
	}

	public boolean isValidInput() {
		boolean isValid = validInput.isValid();
		return isValid;
	}

	public void setValidInput(ValidInput validInput) {
		this.validInput = validInput;
	}

	protected void initEvent() {
		this.addFocusListener(new FocusAdapter() {
			public void focusLost(final FocusEvent arg0) {
				if (getText().length() >= 8) {
					JOptionPane.showMessageDialog(null, "过长，请重新输入");
					MTextField.this.setText("");
				}
			}
		});
	}
	protected void limitInput() {
		this.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {
				int keyChar=e.getKeyChar();
				if(keyChar>=KeyEvent.VK_0&&keyChar<=KeyEvent.VK_9){
				}
				else {
					e.consume();
				}
			}
		});
	}

}
