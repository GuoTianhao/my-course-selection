package com.logic.dataController;

import com.data.dataImpl.DatabaseImpl;
import com.dataService.DatabaseMethod;

public class DatabaseController {
	private static DatabaseMethod method = null;

	public static DatabaseMethod getMethod() {
		if (method == null) {
			method = new DatabaseImpl();
		}
		return method;
	}
}
