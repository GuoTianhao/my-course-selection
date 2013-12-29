package com.server.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Course;
import com.logic.method.TeacherRelative.TeacherCourseListGetter;
import com.server.start.DatabaseInit;

import junit.framework.TestCase;

public class TeaherCourseListGetterTest extends TestCase {
	protected void setUp() {
		DatabaseInit.init();
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			// 初始化课程
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9999','测试课程1','E','2','1025')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9998','测试课程2','E','2','1024')";
			st.execute(sql);

			sql = "INSERT INTO teacher (ID,Name,Faculty) VALUES('40000000','测试老师名字','1250')";
			st.execute(sql);

			sql = "INSERT INTO courseTeacher (ID,Teacher) VALUES('9999','40000000')";
			st.execute(sql);
			sql = "INSERT INTO courseTeacher (ID,Teacher) VALUES('9998','40000000')";
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
			sql = "DELETE FROM course WHERE ID='9999' OR ID='9998'";
			st.execute(sql);
			sql = "DELETE FROM courseTeacher WHERE Teacher='40000000'";
			st.execute(sql);
			sql = "DELETE FROM teacher WHERE ID='40000000'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}
	}

	public void testGetCourseList_1() {
		List<Course> list = TeacherCourseListGetter.getCourseList("40000000");
		assertTrue(list.size() == 2);

		Iterator<Course> it = list.iterator();
		while (it.hasNext()) {
			Course c = it.next();
			if (c.getID().equals("9999")) {
				assertEquals(c.getName(), "测试课程1");
			}
		}
	}
	
	public void testGetCourseList_2() {
		List<Course> list = TeacherCourseListGetter.getCourseList("40000001");
		assertTrue(list.isEmpty());
	}

}
