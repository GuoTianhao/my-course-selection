package com.client.rmi;

import java.rmi.Naming;

import com.logicService.TeacherMethod;

public class TeacherMethodController {
	private static TeacherMethod teacherMethod = null;
	private static String look="rmi://127.0.0.1:6602/teacherMethod";
	public static TeacherMethod getDeanMethod() {
		if (teacherMethod == null) {
			try {
				teacherMethod = (TeacherMethod) Naming
						.lookup(look);
			} catch (Exception ex) {
				System.out.println("连接失败");
				ex.printStackTrace();
			}
		}
		return teacherMethod;
	}
}
