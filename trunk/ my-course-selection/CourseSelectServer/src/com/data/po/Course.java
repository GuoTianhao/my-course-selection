package com.data.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable{
	private String ID=null;
	private String name=null;
	private String loc=null;
	private String type=null;
	private int grade;
	private String period=null;
	private String faculty=null;
	private String script=null;
	private List<String> time=new ArrayList<String>();
	private List<Teacher> teacher=new ArrayList<Teacher>();
	public Course(String ID,String name,String loc,String type,int grade,String period,
			String faculty,String script,List<String> time,List<Teacher> teacher){
		this.ID=ID;
		this.name=name;
		this.setLoc(loc);
		this.setType(type);
		this.setGrade(grade);
		this.setPeriod(period);
		this.setFaculty(faculty);
		this.setScript(script);
		if(time!=null){
			this.time=time;
		}
		if(teacher!=null){
			this.teacher=teacher;
		}
	}
	public void setTime(List<String> time){
		if(time!=null){
			this.time=time;
		}
	}
	public List getTime(){
		return time;
	}
	public void setTeacher(List<Teacher> teacher){
		if(teacher!=null){
			this.teacher=teacher;
		}
	}
	public String getID(){
		return ID;
	}
	public String getName(){
		return name;
	}
	public List<Teacher> getTeacher(){
		return teacher;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
}
