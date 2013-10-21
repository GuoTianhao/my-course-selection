package com.data.po;

import java.io.Serializable;

public class Student implements Serializable{
	private String ID;
	private String name;
	private String faculty;
	private int grade;
	public Student(String ID,String name,String faculty,int grade){
		this.setID(ID);
		this.setName(name);
		this.setFaculty(faculty);
		this.setGrade(grade);
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
