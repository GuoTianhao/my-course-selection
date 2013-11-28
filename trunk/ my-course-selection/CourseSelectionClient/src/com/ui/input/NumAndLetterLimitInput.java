package com.ui.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.ui.myswing.MTextField;

public class NumAndLetterLimitInput implements LimitInput {
	MTextField field;

	public NumAndLetterLimitInput(MTextField field) {
		this.field = field;
	}

	public void limitInput() {
		field.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if ((keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)
						|| (keyChar >= 65 && keyChar <= 60)
						|| (keyChar >= 97 && keyChar <= 122)) {
				} else {
					e.consume();
				}
			}
		});

	}

}
