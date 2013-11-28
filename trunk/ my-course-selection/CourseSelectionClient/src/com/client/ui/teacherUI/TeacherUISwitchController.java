package com.client.ui.teacherUI;

import java.awt.Point;

import com.client.ui.main.MainFrame;
import com.client.ui.teacherUI.CourseMagagement.CourseManagementPanel;
import com.client.ui.teacherUI.CourseMagagement.CourseScoreRecordPanel;

public class TeacherUISwitchController {
	private static TeacherUISwitchController controller = null;
	private static MainFrame frame = null;

	private TeacherUISwitchController() {

	}

	public static TeacherUISwitchController getUISwitchController() {
		if (controller == null) {
			controller = new TeacherUISwitchController();
		}
		if (frame == null) {
			frame = new MainFrame();
		}
		return controller;
	}

	public void switchToMainFrame() {
		frame.getContentPane().removeAll();
		frame.add(new TeacherMainPanel(new Point(0, 0), frame.getSize()));
		frame.refresh();
	}

	public void switchToCourseManagement() {
		frame.getContentPane().removeAll();
		frame.add(new CourseManagementPanel(new Point(0, 0), frame.getSize()));
		frame.refresh();
	}

	public CourseScoreRecordPanel switchToRecordScore(String courseID) {
		frame.getContentPane().removeAll();
		CourseScoreRecordPanel panel = new CourseScoreRecordPanel(new Point(0,
				0), frame.getSize(), courseID);
		frame.add(panel);
		frame.refresh();
		return panel;
	}

	public void dispose() {
		if (frame != null) {
			frame.dispose();
			frame = null;
		}
	}
}
