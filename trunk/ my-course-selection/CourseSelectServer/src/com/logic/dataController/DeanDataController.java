package com.logic.dataController;

import java.rmi.Naming;

import com.data.dataImpl.DeanDatabaseImpl;
import com.dataService.DeanDatabaseMethod;
import com.logicService.DeanMethod;

public class DeanDataController {
	private static DeanDatabaseMethod method = null;

	public static DeanDatabaseMethod getMethod() {
		if (method == null) {
			method = new DeanDatabaseImpl();
		}
		return method;
	}
}
