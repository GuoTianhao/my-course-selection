package com.server.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.po.BasicFrame;
import com.data.po.Course;
import com.data.po.FrameElement;
import com.logic.method.deanRelative.BasicFrameManagement;

import junit.framework.TestCase;

public class BaiscFrameTest extends TestCase {
	// public void testPublishBasicFrame(){
	// BasicFrame f=new BasicFrame();
	// List<Course> list=new ArrayList<Course>();
	// f.addFrameElement(new FrameElement("A","30_40","1_8"));
	// f.addFrameElement(new FrameElement("b","20_25","1_4"));
	// BasicFrameManagement.publishBasicFrame(f, list);
	// }
	public void testGetBasicFrame() {
		BasicFrame f = BasicFrameManagement.getBasicFrame();
		Iterator<FrameElement> it = f.iterator();
		while (it.hasNext()) {
			FrameElement e = it.next();
			System.out.println("Type: " + e.getType() + " Credit: "
					+ e.getCredit() + " Period: " + e.getPeriod());
		}
	}
}
