package com.server.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Student;
import com.data.po.Teacher;
import com.logic.method.deanRelative.StudentImport;
import com.logic.method.deanRelative.TeacherImport;

import junit.framework.TestCase;

public class TeacherImportTest extends TestCase{
	protected void setUp() {

	}

	protected void tearDown() {
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "DELETE FROM teacher WHERE ID='300000000' OR ID='300000001' OR ID='300000002'";
			st.execute(sql);
			sql = "DELETE FROM teacherPassword WHERE ID='300000000' OR ID='300000001' OR ID='300000002'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("删除数据失败" + ex.getMessage());
		}
	}

	public void testImportStudent() {
		List<Teacher> list = new ArrayList<Teacher>();
		list.add(new Teacher("300000000", "小小旭", "1251"));
		list.add(new Teacher("300000001", "小大旭", "1250"));
		list.add(new Teacher("300000002", "大大旭", "1250"));

		TeacherImport.importTeacher(list);

		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "SELECT Name FROM teacher WHERE ID='300000000'";
			ResultSet res = st.executeQuery(sql);
			res.next();
			String name = res.getString("Name");
			assertEquals(name, "小小旭");
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取数据失败" + ex.getMessage());
		}

	}
}
