package com.data.po;

import java.io.Serializable;

public class Teacher implements Serializable{
	private String ID;
	private String name;
	private String faculty;
	public Teacher(String ID,String name,String faculty){
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
