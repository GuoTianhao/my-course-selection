package com.data.dataImpl.method.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;

public class PESelectJudge {
	public static boolean isSelectPE(String ID, String yearTerm){
		Connection conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			String sql="SELECT * FROM course,courseStudent "
					+ "WHERE course.ID=courseStudent.ID AND course.TYPE='G' AND Student="+"'"+ID+"'"
					+" AND time="+"'"+yearTerm+"'";
			st = (Statement) conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			ArrayList<String> l;
			while (res.next()) {
				return true;
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取失败" + ex.getMessage());
		}
		return false;
	}
}
