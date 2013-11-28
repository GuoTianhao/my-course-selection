package com.basicdata;

public class StudentSelectCourseType {
	public static String[] getAllSelectCourseType(){
		String[] type={"选修课程","通识课程","跨院系课程"};
		return type;
	}
	public static String getType(String name){
		switch(name){
		case "选修课程":
			return "F";
		case "通识课程":
			return "A";
		case "跨院系课程":
			return "G";
		}
		return null;
	}
}
