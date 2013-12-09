package com.client.ui.dataAdapter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.data.po.Course;

public class CourseListToFacultyAdapter {
	public static List<Course> adapter(List<Course> list,String faculty){
		List<Course> newList=new LinkedList<Course>();
		Iterator<Course> it=list.iterator();
		while(it.hasNext()){
			Course c=it.next();
			if(c.getFaculty().equals(faculty)){
				newList.add(c);
			}
		}
		return newList;
	}
	public static List<Course> adapterReverse(List<Course> list,String faculty){
		List<Course> newList=new LinkedList<Course>();
		Iterator<Course> it=list.iterator();
		while(it.hasNext()){
			Course c=it.next();
			if(!c.getFaculty().equals(faculty)){
				newList.add(c);
			}
		}
		return newList;
	}
}
