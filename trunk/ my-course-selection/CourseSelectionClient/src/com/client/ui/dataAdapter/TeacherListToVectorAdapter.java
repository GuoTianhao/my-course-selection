package com.client.ui.dataAdapter;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.data.po.Teacher;

public class TeacherListToVectorAdapter {
	public static Vector adapter(List<Teacher> list){
		Vector<Vector> res=new Vector<Vector>();
		Iterator<Teacher> it=list.iterator();
		while(it.hasNext()){
			Teacher t=it.next();
			Vector row=new Vector();
			row.add(t.getID());
			row.add(t.getName());
			row.add(t.getFaculty());
			res.add(row);
		}
		return res;
	}
}
