package com.ui.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.ui.myswing.MTextField;

public class NumAnd_LimitInput implements LimitInput{
	MTextField field;

	public NumAnd_LimitInput(MTextField field) {
		this.field = field;
	}

	public void limitInput() {
		field.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if ((keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)||(keyChar==95)) {
				} else {
					e.consume();
				}
			}
		});

	}

}
