package com.ui.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumLimitInput extends KeyAdapter{
	public void keyTyped(KeyEvent e) {
		int keyChar = e.getKeyChar();
		if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {
		} else {
			e.consume();
		}
	}
}
