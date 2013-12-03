package com.basicdata;

import java.util.HashMap;
import java.util.Map;

public class CourseTypeKind {
	private static String[] CourseTypeName = { "通识教育课程", "思想政治理论课程", "军事课程",
			"分层次同修课程", "专业必修课", "专业选修课", "毕业论文/设计" };
	private static String[] CourseType = {"A","B","C","D","E","F","L"};
	
	private static Map<String, String> nameToType;
	private static Map<String, String> typeToName;
	private static boolean state = false;
	
	private static void init() {
		nameToType = new HashMap<>();
		typeToName = new HashMap<>();
		for (int i = 0; i < CourseType.length; i++) {
			nameToType.put(CourseTypeName[i], CourseType[i]);
			typeToName.put(CourseType[i], CourseTypeName[i]);
		}
		state = true;
	}
	

	public static String getType(String name) {
		if (!state) {
			init();
		}
		return nameToType.get(name);
	}

	public static String getName(String type) {
		if (!state) {
			init();
		}
		return typeToName.get(type);
	}
}
