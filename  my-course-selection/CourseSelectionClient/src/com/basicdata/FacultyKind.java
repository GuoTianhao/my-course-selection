package com.basicdata;

import java.util.Map;

public class FacultyKind {
	private static String[] faculty = { "文学院", "历史学系", "法学院", "哲学系", "新闻传播学院",
			"政府管理学院", "信息管理学院", "社会学院", "商学院", "外国语学院", "数学系", "物理学院",
			"化学化工学院", "生命科学学院", "地球科学与工程学院", "地理与海洋科学学院", "大气科学学院",
			"电子科学与工程学院", "现代工程与应用科学学院", "环境学院", "天文与空间科学学院", "计算机科学与技术系",
			"医学院", "匡亚明学院", "软件学院", "工程管理学院", "海外教育学院", "建筑与城市规划学院" };

	private Map<Integer, String> facultyMap;
	
	
	public static String[] getAllFaculty() {
		return faculty;
	}

	// 具体变序列
	public static String getID(String name) {
		return "";
	}

	public static String getName(String type) {
		return "";
	}
}
