package com.client.ui.main;

import java.awt.Dimension;
import java.awt.Point;

import com.client.ui.deanUI.DeanMainPanel;
import com.client.ui.facultyUI.FacultyMainPanel;
import com.client.ui.loginUI.Login;
import com.client.ui.studentUI.StudentMainPanel;
import com.client.ui.teacherUI.TeacherMainPanel;

public class MainUISwitchController {
	private static MainUISwitchController controller = null;
	private static MainFrame frame = null;

	private MainUISwitchController() {

	}

	public static MainUISwitchController getUISwitchController() {
		if (controller == null) {
			controller = new MainUISwitchController();
		}
		if (frame == null) {
			frame = new MainFrame();
		}
		return controller;
	}

	public void switchToLoginPanel() {
		frame.dispose();
		new Login();
	}

	public void switchToDeanMainPanel() {
		frame.add(new DeanMainPanel(new Point(0, 0), new Dimension(frame
				.getSize().width, frame.getSize().height)));
	}

	public void switchToFacultyDeanMainPanel() {
		frame.add(new FacultyMainPanel());
	}

	public void switchToTeacherMainPanel() {
		frame.add(new TeacherMainPanel());
	}

	public void switchToStudentMainPanel() {
		frame.add(new StudentMainPanel());
	}
}
