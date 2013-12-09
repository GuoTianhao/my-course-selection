package com.client.ui.dataAdapter;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.client.rmi.StudentMethodController;
import com.data.po.Course;
import com.logicService.StudentMethod;

public class CourseListToBallotCourseTableVectorAdapter {
	public static Vector adapter(List<Course> list){
		StudentMethod method=StudentMethodController.getMethod();
		Vector<Vector> res = new Vector<Vector>();
		Iterator<Course> it = list.iterator();
		while (it.hasNext()) {
			Course c = (Course) it.next();
			Vector row = new Vector<>();
			row.add(c.getID());
			row.add(c.getName());
			row.add(c.getCredit());
			row.add(c.getLoc());
			row.add(c.getTime());
			row.add(c.getNum());
			int select=0;
			try {
				select = method.getWaitCourseStudentNum(c.getID());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			row.add(select);
			res.add(row);
		}
		return res;
	}

}
