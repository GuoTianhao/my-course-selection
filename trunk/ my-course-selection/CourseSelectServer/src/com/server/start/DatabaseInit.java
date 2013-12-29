package com.server.start;

import com.data.dataImpl.DatabaseImpl;
import com.data.dataImpl.DeanDatabaseImpl;
import com.data.dataImpl.FacultyDeanDatabaseImpl;
import com.data.dataImpl.StudentDatabaseImpl;
import com.data.dataImpl.TeacherDatabaseImpl;
import com.logic.dataController.DatabaseController;
import com.logic.dataController.DeanDataController;
import com.logic.dataController.FacultyDeanDataController;
import com.logic.dataController.StudentDataController;
import com.logic.dataController.TeacherDataController;

public class DatabaseInit {
	public static void init() {
		DatabaseController.setMethod(new DatabaseImpl());
		DeanDataController.setMethod(new DeanDatabaseImpl());
		FacultyDeanDataController.setMethod(new FacultyDeanDatabaseImpl());
		StudentDataController.setMethod(new StudentDatabaseImpl());
		TeacherDataController.setMethod(new TeacherDatabaseImpl());
	}
}
