package com.ui.myswing;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class MFont {
	public static Font titleFont = new Font("华文细黑", Font.BOLD, 16);
	public static Font btnFont = new Font("宋体", Font.PLAIN, 14);

	
	public static void main(String[] args) {
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontnames = e.getAvailableFontFamilyNames();
		
		for (int i = 0; i < fontnames.length; i++) {
			System.out.println(fontnames[i]);
		}
	}
}
