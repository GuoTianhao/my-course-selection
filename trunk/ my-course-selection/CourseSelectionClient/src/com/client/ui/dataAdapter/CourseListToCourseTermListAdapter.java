package com.client.ui.dataAdapter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.data.po.Course;

public class CourseListToCourseTermListAdapter {
	public static List<Course> adapter(List<Course> list,int term){
		List<Course> newList=new LinkedList<Course>();
		Iterator<Course> it=list.iterator();
		while(it.hasNext()){
			Course c=it.next();
			if(c.getGrade()==term){
				newList.add(c);
			}
		}
		return newList;
	}
}
