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

	private MainUISwitchController() {

	}

	public static MainUISwitchController getUISwitchController() {
		if (controller == null) {
			controller = new MainUISwitchController();
		}
		return controller;
	}

	public void switchToLoginPanel() {
		new Login();
	}

	public void switchToDeanMainPanel() {

	}

	public void switchToFacultyDeanMainPanel() {

	}

	public void switchToTeacherMainPanel() {

	}

	public void switchToStudentMainPanel() {

	}
}
