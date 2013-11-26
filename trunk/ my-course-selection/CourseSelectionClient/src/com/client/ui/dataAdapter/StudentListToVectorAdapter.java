package com.client.ui.dataAdapter;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.data.po.Student;


public class StudentListToVectorAdapter {
	public static Vector adapter(List<Student> list){
		Vector<Vector> res = new Vector<Vector>();
		Iterator<Student> it = list.iterator();
		while (it.hasNext()) {
			Student s = (Student) it.next();
			Vector row = new Vector<>();
			row.add(s.getID());
			row.add(s.getName());
			row.add(s.getFaculty());
			row.add(s.getGrade());
			res.add(row);
 		}
 		return res;
	}
}
