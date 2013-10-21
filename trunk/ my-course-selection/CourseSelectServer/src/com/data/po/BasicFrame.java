package com.data.po;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BasicFrame implements Serializable{
	private List<FrameElement> list=new LinkedList<FrameElement>();
	public void addFrameElement(FrameElement e){
		list.add(e);
	}
	public Iterator<FrameElement> iterator(){
		return list.iterator();
	}
}
