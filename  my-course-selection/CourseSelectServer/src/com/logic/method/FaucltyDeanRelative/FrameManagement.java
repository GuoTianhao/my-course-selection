package com.logic.method.FaucltyDeanRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.Course;
import com.data.po.Frame;
import com.data.po.FrameElement;
import com.dataService.DeanDatabaseMethod;
import com.dataService.FacultyDeanDatabaseMethod;
import com.logic.dataController.DeanDataController;
import com.logic.dataController.FacultyDeanDataController;
import com.logic.method.courseRelative.CourseUpdate;

public class FrameManagement {
	private static List<String> getClueName(){
		ArrayList<String> clueName=new ArrayList<String>();
		clueName.add("type");
		clueName.add("credit");
		clueName.add("Period");
		clueName.add("faculty");
		return clueName;
	}
	public static boolean publishFrame(Frame f){
		FacultyDeanDatabaseMethod method=FacultyDeanDataController.getMethod();
		List<String> clueName=getClueName();
		List<String> clue=new ArrayList<String>();
		Iterator<FrameElement> it=f.iterator();
		while(it.hasNext()){
			FrameElement e=it.next();
			clue.add(e.getType());
			clue.add(e.getCredit());
			clue.add(e.getPeriod());
			clue.add(f.getFaculty());
			method.insert("frame", clueName, clue);
			clue.clear();
		}
		return true;
	}
	public static boolean modifyFrame(Frame f){
		FacultyDeanDatabaseMethod method=FacultyDeanDataController.getMethod();
		method.delete("frame","faculty",f.getFaculty());
		return publishFrame(f);	
	}
	public static Frame getFrame(String faculty){
		Frame f=new Frame(faculty);
		DeanDatabaseMethod method=DeanDataController.getMethod();
		List<String> aimName=getClueName();
		List<String> clueName=new ArrayList<String>();
		List<String> clue=new ArrayList<String>();
		clueName.add("faculty");
		clue.add(faculty);
		List<ArrayList<String>> list=method.search("frame",clueName,clue, aimName);
		Iterator<ArrayList<String>> it=list.iterator();
		while(it.hasNext()){
			ArrayList<String> innerList=it.next();
			Iterator<String> innerIt=innerList.iterator();
			f.addFrameElement(new FrameElement(innerIt.next(),innerIt.next(),innerIt.next()));
		}
		return f;
	}
}
