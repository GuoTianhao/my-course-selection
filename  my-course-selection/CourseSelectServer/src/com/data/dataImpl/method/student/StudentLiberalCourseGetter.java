package com.data.dataImpl.method.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;

public class StudentLiberalCourseGetter {
	public static List<ArrayList<String>> getLiberalCourseList(String ID){
		Connection conn = DatabaseConnection.getConnection();
		Statement st;
		List<ArrayList<String>> list = new LinkedList<ArrayList<String>>();
		try {
			String sql="SELECT course.ID,course.Credit FROM course,courseStudent "
					+ "WHERE course.ID=courseStudent.ID AND course.TYPE='A' AND Student="+"'"+ID+"'";
			st = (Statement) conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			ArrayList<String> l;
			while (res.next()) {
				l=new ArrayList<String>();
				l.add(res.getString("ID"));
				l.add(res.getString("Credit"));
				list.add(l);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取失败" + ex.getMessage());
		}
		return list;
	}
}
