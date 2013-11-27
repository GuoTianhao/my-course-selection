package com.client.ui.teacherUI.CourseMagagement;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import com.client.ui.main.MainFrame;
import com.client.ui.teacherUI.TeacherUISwtichController;
import com.ui.bcswing.CourseScoreTable;
import com.ui.bcswing.titleBar.TeacherTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MButton;
import com.ui.myswing.MPanel;

public class CourseScoreRecordPanel extends MPanel {
	private TitleBar title;
	private CourseScoreTable table;
	private MButton backB;
	private MButton editB;

	public CourseScoreRecordPanel(Point loc, Dimension size) {
		super(loc, size);
		createComponent();
		addListener();
		init();
	}

	private void createComponent() {
		title = new TeacherTitleBar(new Point(0, 0), new Dimension(
				this.getWidth(), 75));
		table = new CourseScoreTable(new Point(10, 130),
				new Dimension(780, 430));
		backB = new MButton(null, null, null, new Point(10, 95), new Dimension(
				100, 30));
		editB = new MButton(null, null, null, new Point(700, 95),
				new Dimension(100, 30));

		backB.setText("返回");
		editB.setText("双击以编辑成绩");

		this.add(title);
		this.add(table);
		this.add(backB);
		this.add(editB);
	}

	private void addListener() {

		backB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherUISwtichController controller = TeacherUISwtichController
						.getUISwitchController();
				controller.switchToCourseManagement();
			}
		});

		editB.addActionListener(new EditListener());

	}

	private void init() {

	}

	class EditListener implements ActionListener {
		int time = 0;

		public void actionPerformed(ActionEvent e) {
			time++;
			if (time % 2 == 0) {
				table.setEditable(new EditScorePermission());
			}
		}

	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TeacherUISwtichController controller = TeacherUISwtichController
				.getUISwitchController();
		controller.switchToRecordScore();
	}

}
