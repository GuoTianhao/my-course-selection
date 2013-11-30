package com.ui.bcswing.courseEditPane;

import javax.swing.UIManager;

public class FacultyCoursePane extends CourseEditPane{
	public FacultyCoursePane(){
		String[] typeModel = { "专业选修课","专业必修课"};
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
