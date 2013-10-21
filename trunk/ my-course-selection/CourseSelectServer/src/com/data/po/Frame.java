package com.data.po;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Frame implements Serializable{
	private List<FrameElement> list=new LinkedList<FrameElement>();
	private String Faculty=null;
	public Frame(String faculty){
		this.setFaculty(faculty);
	}
	public void addFrameElement(FrameElement e){
		list.add(e);
	}
	public Iterator<FrameElement> iterator(){
		return list.iterator();
	}
	public String getFaculty() {
		return Faculty;
	}
	public void setFaculty(String faculty) {
		Faculty = faculty;
	}
}
