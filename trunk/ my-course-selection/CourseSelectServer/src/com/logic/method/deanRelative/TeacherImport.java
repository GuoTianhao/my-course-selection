package com.logic.method.deanRelative;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Student;
import com.data.po.Teacher;

public class TeacherImport {
	public static boolean importTeacher(List<Teacher> list) {
		Iterator<Teacher> it = list.iterator();
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			while (it.hasNext()) {
				Teacher s = it.next();

				sql = "INSERT INTO teacher (ID,Name,Faculty) VALUES("
						+ "'" + s.getID() + "'," + "'" + s.getName() + "',"
						+ "'" + s.getFaculty()+ "')";
				st.execute(sql);
				sql = "INSERT INTO teacherPassword (ID,Password) VALUES(" + "'"
						+ s.getID() + "'," + "'" + s.getID() + "')";
				st.execute(sql);
			}

		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
			return false;
		}
		return true;
	}
}
