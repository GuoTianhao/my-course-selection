package com.logic.method.deanRelative;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Student;

public class StudentImport {
	public static boolean importStudent(List<Student> list) {
		Iterator<Student> it = list.iterator();
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			while (it.hasNext()) {
				Student s = it.next();

				sql = "INSERT INTO student (ID,Name,Faculty,Grade) VALUES("
						+ "'" + s.getID() + "'," + "'" + s.getName() + "',"
						+ "'" + s.getFaculty() + "'," + "'" + s.getGrade()
						+ "')";
				st.execute(sql);
				sql = "INSERT INTO studentPassword (ID,Password) VALUES(" + "'"
						+ s.getID() + "'," + "'" + s.getID() + "')";
				st.execute(sql);
			}

		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}
		return true;
	}
}
