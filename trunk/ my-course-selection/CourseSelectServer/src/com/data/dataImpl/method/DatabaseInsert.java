package com.data.dataImpl.method;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.data.dataImpl.DatabaseImpl;

public class DatabaseInsert {
	public static boolean insert(String tableName, List<String> clueName,
			List<String> clue) {
		boolean correct;
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO " + tableName + "(";
			Iterator<String> itN = clueName.iterator();
			Iterator<String> itV = clue.iterator();
			while (itN.hasNext()) {
				sql += itN.next();
				if (itN.hasNext()) {
					sql += ",";
				}
			}
			sql += ")" + " VALUES(";
			while (itV.hasNext()) {
				sql += "'" + itV.next() + "'";
				if (itV.hasNext()) {
					sql += ",";
				}
			}
			sql += ")";
			st.execute(sql);
			conn.close();
			correct = true;

		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
			correct = false;
		}
		return correct;
	}
}
