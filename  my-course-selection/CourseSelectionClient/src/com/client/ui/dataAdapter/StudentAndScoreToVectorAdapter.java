package com.client.ui.dataAdapter;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import com.data.po.Course;
import com.data.po.Student;

public class StudentAndScoreToVectorAdapter {
	public static Vector adapter(Map<Student,Integer> map){
		Vector<Vector> res = new Vector<>();
		Iterator<Student> it = map.keySet().iterator();
		while (it.hasNext()) {
			Student student=it.next();
			Vector row = new Vector<>();
			row.add(student.getID());
			row.add(student.getName());
			row.add(student.getFaculty());
			row.add(student.getGrade());
			row.add(map.get(student));
			res.add(row);
		}
		return res;

	}
}
