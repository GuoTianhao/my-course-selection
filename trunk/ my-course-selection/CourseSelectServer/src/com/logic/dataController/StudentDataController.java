package com.logic.dataController;

import com.data.dataImpl.StudentDatabaseImpl;
import com.dataService.DatabaseMethod;
import com.dataService.StudentDatabaseMethod;

public class StudentDataController {
	private static StudentDatabaseMethod method = null;

	public static StudentDatabaseMethod getMethod() {
//		if (method == null) {
//			method = new StudentDatabaseImpl();
//		}
		return method;
	}
	public static void setMethod(StudentDatabaseMethod method){
		StudentDataController.method=method;
	}
}
