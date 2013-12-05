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
		addListener();
	}

	private void addListener() {

		courseEdit.addConfirmListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				FacultyDean facultyDean=(FacultyDean) Identity.getIdentity();
				
				FacultyDeanMethod method = FacultyDeanMethodController.getMethod();
				Course nCourse = courseEdit.getCourse();
				try {
					Course oCourse = method.getCourse(nCourse.getID());
					if (oCourse == null) {
						if(method.publishCourse(facultyDean.getFaculty(),nCourse)){
							System.out.println("发布课程成功");
						}
					} else {
						nCourse.setScript(oCourse.getScript());
						nCourse.setTeacher(oCourse.getTeacher());
						nCourse.setFaculty(oCourse.getFaculty());
						if(method.modifyCourse(nCourse)){
							System.out.println("更改课程成功");
						}
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}

		});

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
