package com.logic.dataController;

import com.data.dataImpl.FacultyDeanDatabaseImpl;
import com.dataService.FacultyDeanDatabaseMethod;

public class FacultyDeanDataController {
	private static FacultyDeanDatabaseMethod method = null;

	public static FacultyDeanDatabaseMethod getMethod() {
		if (method == null) {
			method = new FacultyDeanDatabaseImpl();
		}
		return method;
	}
}
