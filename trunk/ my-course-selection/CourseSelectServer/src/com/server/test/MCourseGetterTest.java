package com.server.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Course;
import com.logic.method.deanRelative.MCourseGetter;
import com.server.start.DatabaseInit;

import junit.framework.TestCase;

public class MCourseGetterTest extends TestCase {

	protected void setUp() {
		DatabaseInit.init();
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9996','测试课程1','A','2','0000')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9995','测试课程2','A','2','0000')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9994','测试课程3','E','2','1250')";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}
	}

	protected void tearDown() {
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "DELETE FROM course WHERE ID='9996' OR ID='9995' OR ID='9994'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("删除数据失败" + ex.getMessage());
		}
	}

	public void testGetMCourse_1() {
		List<Course> list = MCourseGetter.getMCourse();

		Iterator<Course> it = list.iterator();

		while (it.hasNext()) {
			Course c = it.next();
			switch (c.getID()) {
			case "9996":
				assertTrue(c.getName().equals("测试课程1"));
				break;
			case "9995":
				assertTrue(c.getName().equals("测试课程2"));
				break;
			}
		}
	}

	public void testGetMCourse_2() {
		List<Course> list = MCourseGetter.getMCourse();

		Iterator<Course> it = list.iterator();

		while (it.hasNext()) {
			Course c = it.next();
			assertFalse(c.getID().equals("9994"));
		}
	}
}
