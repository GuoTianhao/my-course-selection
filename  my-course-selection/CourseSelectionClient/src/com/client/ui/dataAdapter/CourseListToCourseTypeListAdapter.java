package com.client.ui.dataAdapter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.data.po.Course;

public class CourseListToCourseTypeListAdapter {
	public static List<Course> adapter(List<Course> list,String type){
		List<Course> newList=new LinkedList<Course>();
		Iterator<Course> it=list.iterator();
		while(it.hasNext()){
			Course c=it.next();
			if(c.getType().equals(type)){
				newList.add(c);
			}
		}
		return newList;
	}
}
