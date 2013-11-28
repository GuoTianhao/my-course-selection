package com.client.ui.main;

import java.awt.Dimension;
import java.awt.Point;

import com.client.ui.deanUI.DeanMainPanel;
import com.client.ui.deanUI.DeanUISwitchController;
import com.client.ui.facultyUI.FacultyMainPanel;
import com.client.ui.facultyUI.FacultyUISwitchController;
import com.client.ui.loginUI.Login;
import com.client.ui.studentUI.StudentMainPanel;
import com.client.ui.studentUI.StudentUISwitchController;
import com.client.ui.teacherUI.TeacherMainPanel;
import com.client.ui.teacherUI.TeacherUISwitchController;

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
		DeanUISwitchController controller=DeanUISwitchController.getUISwitchController();
		controller.swicthToMainFrame();
	}

	public void switchToFacultyDeanMainPanel() {
		FacultyUISwitchController controller=FacultyUISwitchController.getUISwitchController();
		controller.swicthToMainFrame();
	}

	public void switchToTeacherMainPanel() {
		TeacherUISwitchController controller=TeacherUISwitchController.getUISwitchController();
		controller.switchToMainFrame();
	}

	public void switchToStudentMainPanel() {
		StudentUISwitchController controller=StudentUISwitchController.getUISwitchController();
		controller.switchToMainFrame();
	}
}
