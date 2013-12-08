package com.client.ui.dataAdapter;

import java.util.Iterator;
import java.util.Vector;

import com.basicdata.CourseTypeKind;
import com.data.po.BasicFrame;
import com.data.po.FrameElement;

public class BasicFrameToVectorAdapter {
	public static Vector adapter(BasicFrame frame){
		Vector<Vector> res = new Vector<Vector>();
		Iterator<FrameElement> it = frame.iterator();
		while (it.hasNext()) {
			FrameElement e = (FrameElement) it.next();
			Vector row = new Vector();
			row.add(CourseTypeKind.getName(e.getType()));
			row.add(e.getCredit());
			row.add(e.getPeriod());
			res.add(row);
		}
		return res;
	}
}
