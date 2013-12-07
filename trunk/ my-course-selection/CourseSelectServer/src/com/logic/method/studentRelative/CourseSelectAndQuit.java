package com.logic.method.studentRelative;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Adapter.GradeToTermAdapter;

import com.data.dataImpl.DatabaseImpl;
import com.data.po.Course;
import com.dataService.StudentDatabaseMethod;
import com.logic.dataController.StudentDataController;
import com.logic.method.courseRelative.CourseGetter;
import com.timeControllerService.TimeController;
import com.timeControllerService.TimeControllerController;

public class CourseSelectAndQuit {
	public static boolean selectCourse(String ID, String cID) {
		TimeController time=TimeControllerController.getMethod();
		boolean admit=false;
	//	try {
	//		if(time.isTimeForSelectCourse()||time.isTimeForByElection()){
				admit=selectCourse(ID,cID, true);
	//		}
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
		return admit;
	}
	
	public static boolean selectCourse(String ID, String cID,boolean isWaited){
		String tableName;
		if(isWaited){
			tableName="courseStudentWait";
		}else{
			tableName="courseStudent";
		}
		StudentDatabaseMethod method = StudentDataController.getMethod();
		if (!(isSelected(ID, cID,isWaited))) {
			List<String> clueName = new ArrayList<String>();
			List<String> clue = new ArrayList<String>();
			String grade = method.search("student", "ID", ID, "Grade").get(0);
			int term = GradeToTermAdapter.adapter(Integer.parseInt(grade));
			clueName.add("ID");
			clueName.add("Student");
			clueName.add("Term");
			clue.add(cID);
			clue.add(ID);
			clue.add(term + "");
			method.insert(tableName, clueName, clue);
			return true;
		} else {
			return false;
		}
	}

	public static boolean quitCourse(String ID, String cID) {
		return quitCourse(ID,cID,false);
	}
	
	public static boolean quitSelectCourse(String ID, String cID){
		return quitCourse(ID,cID,true);
	}

	protected static boolean quitCourse(String ID, String cID,boolean isWaited){
		String tableName;
		if(isWaited){
			tableName="courseStudentWait";
		}else{
			tableName="courseStudent";
		}
		if (isSelected(ID, cID,isWaited)) {
			List<String> clueName = new ArrayList<String>();
			List<String> clue = new ArrayList<String>();
			clueName.add("ID");
			clueName.add("Student");
			clue.add(cID);
			clue.add(ID);
			StudentDataController.getMethod().delete(tableName, clueName,
					clue);
			return true;
		} else {
			return false;
		}
		
	}
	
	private static boolean isSelected(String ID, String cID,boolean isWaited) {
		String tableName;
		if(isWaited){
			tableName="courseStudentWait";
		}else{
			tableName="courseStudent";
		}
		List<String> clueName = new ArrayList<String>();
		List<String> clue = new ArrayList<String>();
		List<String> aimName = new ArrayList<String>();
		clueName.add("ID");
		clueName.add("Student");
		clue.add(cID);
		clue.add(ID);
		aimName.add("ID");
		List res = StudentDataController.getMethod().search(tableName,
				clueName, clue, aimName);
		if (res.size() != 0) {
			return true;
		}
		{
			return false;
		}
	}

	private static boolean isQuitable(String courseID) {
		Course c = CourseGetter.getConcreteCourse(courseID);
		switch (c.getType()) {
		case "B":case "C":case "D":case "E":case "L":
			return false;
		}
		return true;
	}
}
