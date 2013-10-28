package com.ui.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

class MScrollTableDClick extends MouseAdapter {
	private int count = 0;
	private JTable t = null;
	private int selectNum = -1;

	public MScrollTableDClick(JTable t) {
		this.t = t;
	}

	public void mouseClicked(MouseEvent e) {
		if (t.getSelectedRow() != selectNum) {
			count = 1;
			selectNum = t.getSelectedRow();
		} else {
			count++;
			if (count % 2 == 0) {
				System.out.println("click");
				count = 0;
			}
		}
	}
}
