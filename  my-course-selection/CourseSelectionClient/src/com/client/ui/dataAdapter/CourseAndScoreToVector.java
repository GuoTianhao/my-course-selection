package com.client.ui.dataAdapter;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import com.basicdata.CourseTypeKind;
import com.data.po.Course;

public class CourseAndScoreToVector {
	public static Vector adapter(Map<Course,Integer> map){
		Vector<Vector> res = new Vector<>();
		Iterator<Course> it = map.keySet().iterator();
		while (it.hasNext()) {
			Course c = it.next();
			Vector row = new Vector<>();
			row.add(c.getID());
			row.add(c.getName());
			row.add(CourseTypeKind.getName(c.getType()));
			row.add(c.getCredit());
			row.add(map.get(c));
			res.add(row);
		}
		return res;
	}
}
