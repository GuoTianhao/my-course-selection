package com.ui.bcswing.courseEditPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.UIManager;

import com.basicdata.Identity;
import com.client.rmi.DeanMethodController;
import com.client.rmi.FacultyDeanMethodController;
import com.data.po.Course;
import com.data.po.FacultyDean;
import com.logicService.DeanMethod;
import com.logicService.FacultyDeanMethod;

public class FacultyCoursePane extends CourseEditPane {
	public FacultyCoursePane() {
		super();
		init();
	}

	public void addListener(ActionListener al) {
		courseEdit.addConfirmListener(al);
	}

	public Course getCourse(){
		FacultyDeanMethod method = FacultyDeanMethodController.getMethod();
		Course nCourse = getCourse();
		try {
			Course oCourse = method.getCourse(nCourse.getID());
			if (oCourse != null) {
				nCourse.setScript(oCourse.getScript());
				nCourse.setTeacher(oCourse.getTeacher());
				nCourse.setFaculty(oCourse.getFaculty());
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		return nCourse;
	}

	private void init() {
		String[] typeModel = { "专业选修课", "专业必修课" };
		courseEdit.setTypeModel(typeModel);
		courseEdit.initType();
	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new FacultyCoursePane();
	}
}
