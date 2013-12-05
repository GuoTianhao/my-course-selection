package com.ui.bcswing;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.UIManager;

import com.ui.myswing.MFrame;
import com.ui.myswing.MPanel;

public class TeacherDisplayPane extends MFrame {
	private static Dimension default_size = new Dimension(550, 500);
	private MPanel panel;
	private TeacherDisplayTable table;

	public TeacherDisplayPane() {
		super(default_size);
		createComponent();
		addListener();
	}

	private void createComponent() {
		panel = new MPanel(new Point(0, 0), default_size);
		table = new TeacherDisplayTable(new Point(0, 0), new Dimension(
				default_size.width-50, default_size.height-120));

		panel.add(table);
		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void addListener() {

	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new TeacherDisplayPane();
	}
}
