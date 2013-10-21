package com.data.dataImpl.method;

import java.sql.Connection;
import java.sql.Statement;

import com.data.dataImpl.DatabaseImpl;

public class DatabaseUpdate {
	public static boolean update(String tableName, String clueName,
			String clue, String aimName, String aim) {
		boolean correct;
		Connection conn;
		conn = DatabaseConnection.getConnection();
		try {
			String sql;
			sql = "UPDATE " + tableName + " SET " + aimName + "=" + "'" + aim
					+ "'" + " WHERE " + clueName + "=" + "'" + clue + "'";
			Statement st = conn.createStatement();
			st.execute(sql);
			conn.close();
			correct = true;
		} catch (Exception ex) {
			System.out.println("更新数据失败" + ex.getMessage());
			correct = false;
		}
		return correct;
	}
}
