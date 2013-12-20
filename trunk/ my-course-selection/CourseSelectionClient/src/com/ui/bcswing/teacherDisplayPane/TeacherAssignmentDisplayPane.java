package com.ui.bcswing.teacherDisplayPane;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.ui.bcswing.CourseTeacherDisplayTable;
import com.ui.myswing.MButton;
import com.ui.myswing.MFrame;
import com.ui.myswing.MPanel;

public class TeacherAssignmentDisplayPane extends MFrame {
	private static Dimension default_size = new Dimension(550, 500);
	protected MPanel panel;
	protected CourseTeacherDisplayTable table;
	protected MButton confirm;

	public TeacherAssignmentDisplayPane() {
		super(default_size);
		createComponent();
		addListener();
	}

	protected void createComponent() {
		panel = new MPanel(new Point(0, 0), default_size);
		table = new CourseTeacherDisplayTable(new Point(25, 20), new Dimension(
				default_size.width - 50, default_size.height - 120));
		confirm = new MButton(null, null, null, new Point(230, 420),
				new Dimension(80, 25));
		confirm.setText("确定");
		panel.add(table);
		panel.add(confirm);
		this.add(panel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	protected void addListener() {

	}

	
	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new TeacherAssignmentDisplayPane();
	}
}
