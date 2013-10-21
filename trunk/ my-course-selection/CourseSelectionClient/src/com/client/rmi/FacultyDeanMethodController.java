package com.client.rmi;

import java.rmi.Naming;

import com.logicService.FacultyDeanMethod;

public class FacultyDeanMethodController {
	private static FacultyDeanMethod facultyMethod = null;
	private static String look="rmi://127.0.0.1:6601/facultyDeanMethod";
	public static FacultyDeanMethod getFacultyDeanMethod() {
		if (facultyMethod == null) {
			try {
				facultyMethod = (FacultyDeanMethod) Naming
						.lookup(look);
			} catch (Exception ex) {
				System.out.println("连接失败");
				ex.printStackTrace();
			}
		}
		return facultyMethod;
	}
}
