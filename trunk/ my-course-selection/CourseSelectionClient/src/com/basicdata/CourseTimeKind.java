package com.basicdata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CourseTimeKind {
	public static Iterator<String> getSeperateTime(String time) {
		List<String> list = new ArrayList<String>();
		String[] str = time.split("_");
		// list.add("星期二");
		// list.add("第二节");
		// list.add("第四节");
		list.add(str[0]);
		list.add(str[1]);
		list.add(str[2]);
		return list.iterator();
	}

	public static String getTime(Iterator<String> it) {
		StringBuilder str = new StringBuilder();
		while (it.hasNext()) {
			str.append(it.next());
			str.append('_');
		}
		str.deleteCharAt(str.length()-1);
		return str.toString();
	}
	
	// public static void main(String[] args) {
	// List<String> list = new LinkedList<>();
	// list.add("Monday");
	// list.add("17week");
	// list.add("4hours");
	// System.out.println(getTime(list.iterator()));
	// }
}
