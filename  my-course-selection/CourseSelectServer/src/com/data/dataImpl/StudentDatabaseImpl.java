package com.data.dataImpl;

import java.util.ArrayList;
import java.util.List;

import com.data.dataImpl.method.student.StudentLiberalCourseGetter;
import com.dataService.StudentDatabaseMethod;


public class StudentDatabaseImpl extends DatabaseImpl implements StudentDatabaseMethod{

	public List<ArrayList<String>> getLiberalCourseList(String ID) {
		// TODO Auto-generated method stub
		return StudentLiberalCourseGetter.getLiberalCourseList(ID);
	}

}
