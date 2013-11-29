package com.client.ui.dataAdapter;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.data.po.Course;

public class StudentUnselectedCourseListToVectorAdapeter {
	public static Vector adapter(List<Course> list){
		Vector<Vector> res = new Vector<Vector>();
		Iterator<Course> it = list.iterator();
		while (it.hasNext()) {
			Course c = (Course) it.next();
			Vector row = new Vector<>();
			row.add(c.getID());
			row.add(c.getName());
			row.add(c.getCredit());
			row.add(c.getTime());
			row.add(c.getPeriod());
			res.add(row);
		}
		return res;
	}
}
