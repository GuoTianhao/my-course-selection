package com.ui.bcswing.courseEditPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.UIManager;

import com.basicdata.Identity;
import com.client.rmi.DeanMethodController;
import com.client.rmi.FacultyDeanMethodController;
import com.client.ui.deanUI.DeanUISwitchController;
import com.client.ui.facultyUI.FacultyUISwitchController;
import com.data.po.Course;
import com.data.po.FacultyDean;
import com.logicService.DeanMethod;
import com.logicService.FacultyDeanMethod;
import com.ui.bcswing.TipFrame;

public class FacultyCoursePane extends CourseEditPane {
	public FacultyCoursePane() {
		super();
		init();
		addListener();
	}

	public void addListener() {
		courseEdit.addConfirmListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FacultyDeanMethod method = FacultyDeanMethodController.getMethod();
				FacultyDean faculty=(FacultyDean) Identity.getIdentity();
				FacultyUISwitchController controller=FacultyUISwitchController.getUISwitchController();
				Course nCourse = getCourse();
				try {
					TipFrame t;
					Course oCourse=method.getCourse(nCourse.getID());
					if(oCourse==null){
						if(method.publishCourse(faculty.getFaculty(),nCourse)){
							t = new TipFrame(controller.getLoc(),controller.getSize(), 5,
									"发布课程成功");
							notifyMObserver();
							dispose();
						}else{
							t = new TipFrame(controller.getLoc(),controller.getSize(), 5,
									"课程发布失败");
						}
					}else{
						switch(oCourse.getType()){
						case "B":case "C":case "D":
							nCourse.setType(oCourse.getType());
						}
						nCourse.setScript(oCourse.getScript());
						nCourse.setTeacher(oCourse.getTeacher());
						nCourse.setFaculty(oCourse.getFaculty());
						if(method.modifyCourse(nCourse)){
							t = new TipFrame(controller.getLoc(),controller.getSize(), 5,
									"课程修改成功");
							notifyMObserver();
							dispose();
						}else{
							t = new TipFrame(controller.getLoc(),controller.getSize(), 5,
									"课程发布修改失败");
						}
					}
					t.startEndClock();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
			
		});
	}
	
	public void setCourse(Course c){
		super.setCourse(c);
		switch(c.getType()){
		case "B":case "C":case "D":
			courseEdit.typeSelect.setEnabled(false);
		}
	}
	
	private void init() {
		String[] typeModel = {"专业选修课", "专业必修课" };
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
