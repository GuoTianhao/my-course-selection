package com.data.dataImpl.method;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMax {
	public static String getMax(String tableName, String clueName) {
		Connection conn = DatabaseConnection.getConnection();
		Statement st;
		List<String> list = new ArrayList<String>();
		String result="";
		try {
			String sql="SELECT "+"MAX("+clueName+")"+" FROM "+tableName;
			st = (Statement) conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			while(res.next()){
				result=res.getString(1);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取失败" + ex.getMessage());
		}
		return result;
	}
}
