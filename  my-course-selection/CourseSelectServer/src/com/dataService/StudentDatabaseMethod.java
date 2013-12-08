package com.dataService;

import java.util.ArrayList;
import java.util.List;

public interface StudentDatabaseMethod extends DatabaseMethod{
	public List<ArrayList<String>> getLiberalCourseList(String ID);
}
