package com.client.ui.dataAdapter;

import java.util.Iterator;
import java.util.Vector;

import com.data.po.Frame;
import com.data.po.FrameElement;

public class FrameToVectorAdapter {
	public static Vector adapter(Frame frame){
		Vector<Vector> res = new Vector<Vector>();
		Iterator<FrameElement> it = frame.iterator();
		while (it.hasNext()) {
			FrameElement e = (FrameElement) it.next();
			Vector row = new Vector();
			row.add(e.getType());
			row.add(e.getCredit());
			row.add(e.getPeriod());
			res.add(row);
		}
		return res;
	}
}
