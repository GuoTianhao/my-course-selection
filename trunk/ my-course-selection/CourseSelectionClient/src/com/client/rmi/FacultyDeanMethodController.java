package com.client.rmi;

import java.rmi.Naming;

import com.client.test.stub.FacultyDeanMethod_Stub;
import com.logicService.FacultyDeanMethod;

public class FacultyDeanMethodController {
	private static FacultyDeanMethod facultyMethod = null;
	private static String look="rmi://172.26.61.148:6601/facultyDeanMethod";
	public static FacultyDeanMethod getMethod() {
		if (facultyMethod == null) {
			try {
				facultyMethod = (FacultyDeanMethod) Naming
						.lookup(look);
			} catch (Exception ex) {
				System.out.println("连接失败");
				ex.printStackTrace();
			}
		}
//		facultyMethod=new FacultyDeanMethod_Stub();
		return facultyMethod;
	}
	public static void setMethod(FacultyDeanMethod method){
		facultyMethod=method;
	}
}
