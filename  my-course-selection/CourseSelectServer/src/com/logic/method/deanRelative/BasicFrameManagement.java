package com.logic.method.deanRelative;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.BasicFrame;
import com.data.po.Course;
import com.data.po.FrameElement;
import com.dataService.DeanDatabaseMethod;
import com.logic.dataController.DeanDataController;
import com.logic.method.courseRelative.CoursePublish;
import com.logic.method.courseRelative.CourseUpdate;

public class BasicFrameManagement {
	private static List<String> getClueName(){
		ArrayList<String> clueName=new ArrayList<String>();
		clueName.add("type");
		clueName.add("credit");
		clueName.add("Period");
		return clueName;
	}
	public static boolean publishBasicFrame(BasicFrame f){
		DeanDatabaseMethod method=DeanDataController.getMethod();
		List<String> clueName=getClueName();
		List<String> clue=new ArrayList<String>();
		Iterator<FrameElement> it=f.iterator();
		while(it.hasNext()){
			FrameElement e=it.next();
			clue.add(e.getType());
			clue.add(e.getCredit());
			clue.add(e.getPeriod());
			method.insert("basicFrame", clueName, clue);
			clue.clear();
		}
		
		return true;
	}
	public static boolean modifyBasicFrame(BasicFrame f){
		DeanDatabaseMethod method=DeanDataController.getMethod();
		method.delete("basicFrame",(List)null,(List)null);
		return publishBasicFrame(f);	
	}
	public static BasicFrame getBasicFrame(){
		BasicFrame f=new BasicFrame();
		DeanDatabaseMethod method=DeanDataController.getMethod();
		List<String> aimName=getClueName();
		List<ArrayList<String>> list=method.search("basicFrame",null, null, aimName);
		Iterator<ArrayList<String>> it=list.iterator();
		while(it.hasNext()){
			ArrayList<String> innerList=it.next();
			Iterator<String> innerIt=innerList.iterator();
			f.addFrameElement(new FrameElement(innerIt.next(),innerIt.next(),innerIt.next()));
		}
		return f;
	}
}
