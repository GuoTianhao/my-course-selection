package com.data.dataImpl.method;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.data.dataImpl.DeanDatabaseImpl;

public class DatabaseSearch {
	public static List<String> search(String tableName, String clueName,
			String clue, String aimName) {
		Connection conn = DatabaseConnection.getConnection();
		Statement st;
		List list = new ArrayList<Object>();
		try {
			String sql = "SELECT " + aimName + " FROM " + tableName + " WHERE "
					+ clueName + "='" + clue + "'";
			st = (Statement) conn.createStatement();
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {
				list.add(res.getObject(aimName));
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取失败" + ex.getMessage());
		}
		return list;
	}

	public static List<ArrayList<String>> search(String tableName,
			List<String> aimName) {
		Connection conn = DatabaseConnection.getConnection();
		Statement st;
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		try {
			st = (Statement) conn.createStatement();
			String sql = "SELECT ";
			Iterator<String> it = aimName.iterator();
			while (it.hasNext()) {
				sql += it.next();
				if (it.hasNext()) {
					sql += ",";
				}
			}
			sql += " FROM " + tableName;
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {
				ArrayList<String> innerList = new ArrayList<String>();
				it = aimName.iterator();
				while (it.hasNext()) {
					innerList.add((String) res.getObject(it.next()));
				}
				list.add(innerList);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public static List<ArrayList<String>> search(String tableName,
			List<String> clueName, List<String> clue, List<String> aimName) {
		Connection conn = DatabaseConnection.getConnection();
		Statement st;
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		try {
			st = (Statement) conn.createStatement();
			String sql = "SELECT ";
			Iterator<String> it = aimName.iterator();
			while (it.hasNext()) {
				sql += it.next();
				if (it.hasNext()) {
					sql += ",";
				}
			}
			sql += " FROM " + tableName;
			if (clueName != null) {
				sql += " WHERE ";
				Iterator<String> cNIt = clueName.iterator();
				Iterator<String> cIt = clue.iterator();
				while (cNIt.hasNext()) {
					sql += cNIt.next() + "=" + "'" + cIt.next() + "' ";
					if (cNIt.hasNext()) {
						sql += " AND ";
					}
				}
			}
	//		 System.out.println(sql);
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {
				ArrayList<String> innerList = new ArrayList<String>();
				it = aimName.iterator();
				while (it.hasNext()) {
					innerList.add(res.getString(it.next()));
				}
				list.add(innerList);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
