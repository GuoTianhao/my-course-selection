package com.data.po;

import java.io.Serializable;

public class FacultyDean implements Serializable{
	private String ID=null;
	private String name=null;
	private String faculty=null;
	public FacultyDean(String ID,String name,String faculty){
		this.setID(ID);
		this.setName(name);
		this.setFaculty(faculty);
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
}
