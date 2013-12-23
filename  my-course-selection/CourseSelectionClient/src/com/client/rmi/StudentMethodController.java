package com.client.rmi;

import java.rmi.Naming;

import com.client.test.stub.StudentMethod_Stub;
import com.logicService.StudentMethod;

public class StudentMethodController {
	private static StudentMethod studentMethod = null;
	private static String look="rmi://"+IPController.getIP()+":6603/studentMethod";
	public static StudentMethod getMethod() {
		if (studentMethod == null) {
			try {
				studentMethod = (StudentMethod) Naming
						.lookup(look);
			} catch (Exception ex) {
				System.out.println("连接失败");
				ex.printStackTrace();
			}
		}
//		studentMethod=new StudentMethod_Stub();
		return studentMethod;
	}
	public static void setMethod(StudentMethod method){
		studentMethod=method;
	}
}
