package com.dataService;

import java.util.ArrayList;
import java.util.List;

public interface StudentDatabaseMethod extends DatabaseMethod{
	//得到学生通识课与通识课对应的学分
	public List<ArrayList<String>> getLiberalCourseList(String ID);
	
	//得到学生是否已经选过体育课
	public boolean isSelectPE(String ID,String yearTerm);
}
