package com.server.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.dataImpl.method.DatabaseDelete;
import com.data.dataImpl.method.DatabaseInsert;
import com.data.dataImpl.method.DatabaseSearch;
import com.data.po.Course;
import com.logic.method.courseRelative.CourseGetter;
import com.logic.method.courseRelative.CourseUpdate;

import junit.framework.TestCase;


class CourseUpateTest extends TestCase {

	protected void setUp() {

	}

	protected void tearDown() {
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "DELETE FROM course WHERE ID='9996'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("删除数据失败" + ex.getMessage());
		}
	}

	public void insertCourse() {
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9996','测试课程1','A','2','0000')";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}
	}

	public void testUpdateCourse_1() {
		insertCourse();
		Course c = CourseGetter.getConcreteCourse("9996");
		c.setName("测试已改名字");

		assertTrue(CourseUpdate.updateCourse(c));

		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "SELECT Name FROM course WHERE ID='9996'";
			ResultSet res = st.executeQuery(sql);
			res.next();
			String name = res.getString("Name");
			assertEquals("测试已改名字", name);
			conn.close();
		} catch (Exception ex) {
			System.out.println("读取数据失败" + ex.getMessage());
		}
	}

}
