package com.data.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
	private String ID = "";
	private String name = "";
	private String loc = "";
	private String type = "";
	private int grade;
	private String period = "";
	private String faculty = "";
	private String script = "";
	private int num=0;
	private int credit;
	private List<String> time = new ArrayList<String>();
	private List<Teacher> teacher = new ArrayList<Teacher>();

	public Course(String ID, String name, String loc, String type, int grade,
			String period, String faculty, String script, int num,int credit,
			List<String> time, List<Teacher> teacher) {
		this.ID = ID;
		this.name = name;
		this.setLoc(loc);
		this.setType(type);
		this.setGrade(grade);
		this.setPeriod(period);
		this.setFaculty(faculty);
		this.setScript(script);
		this.setNum(num);
		this.setCredit(credit);
		if (time != null) {
			this.time = time;
		}
		if (teacher != null) {
			this.teacher = teacher;
		}
	}

	public void setTime(List<String> time) {
		if (time != null) {
			this.time = time;
		}
	}

	public List getTime() {
		return time;
	}

	public void setTeacher(List<Teacher> teacher) {
		if (teacher != null) {
			this.teacher = teacher;
		}
	}

	public void setID(String id){
		if (id != null) {
			this.ID = id;
		}
	}
	
	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		if (loc != null) {
			this.loc = loc;
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (type != null) {
			this.type = type;
		}
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
		if (period != null) {
			this.period = period;
		}
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		if (faculty != null) {
			this.faculty = faculty;
		}
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		if (script != null) {
			this.script = script;
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if(num>=0){
			this.num = num;	
		}
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
}
