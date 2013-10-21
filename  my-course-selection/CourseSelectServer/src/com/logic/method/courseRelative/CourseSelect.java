package com.logic.method.courseRelative;

import java.util.ArrayList;
import java.util.List;

import com.data.dataImpl.DatabaseImpl;
import com.logic.dataController.StudentDataController;

public class CourseSelect {
	public static boolean selectCourse(String ID, String cID){
		if(!(isSelected(ID,cID))){
			List<String> clueName=new ArrayList<String>();
			List<String> clue=new ArrayList<String>();
			clueName.add("ID");
			clueName.add("Student");
			clue.add(cID);
			clue.add(ID);
			StudentDataController.getMethod().insert("courseStudent", clueName, clue);
			return true;
		}else{
			return false;
		}
	}
	public static boolean quitCourse(String ID,String cID){
		if(isSelected(ID,cID)){
			List<String> clueName=new ArrayList<String>();
			List<String> clue=new ArrayList<String>();
			clueName.add("ID");
			clueName.add("Student");
			clue.add(cID);
			clue.add(ID);
			StudentDataController.getMethod().delete("courseStudent", clueName, clue);
			return true;
		}else{
			return false;
		}
	}
	public static boolean isSelected(String ID, String cID){
		List<String> clueName=new ArrayList<String>();
		List<String> clue=new ArrayList<String>();
		List<String> aimName=new ArrayList<String>();
		clueName.add("ID");
		clueName.add("Student");
		clue.add(cID);
		clue.add(ID);
		aimName.add("ID");
		List res=StudentDataController.getMethod().search("courseStudent", clueName, clue, aimName);
		if(res.size()!=0){
			return true;
		}{
			return false;
		}
	}
}
