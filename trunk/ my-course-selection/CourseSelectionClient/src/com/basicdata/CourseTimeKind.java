package com.basicdata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CourseTimeKind {
	public static Iterator<String> getSeperateTime(String time){
		List<String> list=new ArrayList<String>();
		String[] str=time.split("_");
		list.add("星期二");
		list.add("第二节");
		list.add("第四节");
		return list.iterator();
	}
	
	public static String getTime(Iterator<String> it){
		return "";
	}
}
