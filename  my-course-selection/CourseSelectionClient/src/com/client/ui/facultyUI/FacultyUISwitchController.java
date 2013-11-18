package com.client.ui.facultyUI;

import java.awt.Point;

import com.client.ui.facultyUI.Course.CourseManagementPanel;
import com.client.ui.facultyUI.teachingPlan.TeachingPlanPanel;
import com.client.ui.main.MainFrame;

public class FacultyUISwitchController {
	private static FacultyUISwitchController controller = null;
	private static MainFrame frame = null;

	private FacultyUISwitchController() {

	}

	public static FacultyUISwitchController getUISwitchController() {
		if (controller == null) {
			controller = new FacultyUISwitchController();
		}
		if (frame == null) {
			frame = new MainFrame();
		}
		return controller;
	}

	public void swicthToMainFrame() {
		frame.getContentPane().removeAll();
		frame.add(new FacultyMainPanel(new Point(0, 0), frame.getSize()));
		frame.refresh();
	}

	public void switchToTeachingPlanPanel() {
		frame.getContentPane().removeAll();
		frame.add(new TeachingPlanPanel(new Point(0, 0), frame.getSize()));
		frame.refresh();
	}

	public void switchToCourseManagementPanel() {
		frame.getContentPane().removeAll();
		frame.add(new CourseManagementPanel(new Point(0, 0), frame.getSize()));
		frame.refresh();
	}

	public void dispose(){
		if (frame != null) {
			frame.dispose();
			frame=null;
		}
	}
}
