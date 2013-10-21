package com.logic.dataController;

import com.data.dataImpl.StudentDatabaseImpl;
import com.dataService.StudentDatabaseMethod;

public class StudentDataController {
	private static StudentDatabaseMethod method = null;

	public static StudentDatabaseMethod getMethod() {
		if (method == null) {
			method = new StudentDatabaseImpl();
		}
		return method;
	}
}
