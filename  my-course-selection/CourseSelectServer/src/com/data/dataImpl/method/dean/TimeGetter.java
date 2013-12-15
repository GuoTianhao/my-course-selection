package com.data.dataImpl.method.dean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;

public class TimeGetter {
	public static Date getTime(String period){
		Connection conn = DatabaseConnection.getConnection();
		Statement st;
		Date date=null;
		try {
			String sql = "SELECT start FROM time WHERE period="+"'"+period+"'";
			st = (Statement) conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {
				date=res.getDate("start");
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取失败" + ex.getMessage());
		}
		return date;
	}
	
}
