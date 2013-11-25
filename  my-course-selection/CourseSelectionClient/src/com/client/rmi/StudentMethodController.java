package com.client.rmi;

import java.rmi.Naming;

import com.logicService.StudentMethod;

public class StudentMethodController {
	private static StudentMethod studentMethod = null;
	private static String look="rmi://127.0.0.1:6603/studentMethod";
	public static StudentMethod getStudentMethod() {
		if (studentMethod == null) {
			try {
				studentMethod = (StudentMethod) Naming
						.lookup(look);
			} catch (Exception ex) {
				System.out.println("连接失败");
				ex.printStackTrace();
			}
		}
		return studentMethod;
	}
	public static void setMethod(StudentMethod method){
		studentMethod=method;
	}
}
