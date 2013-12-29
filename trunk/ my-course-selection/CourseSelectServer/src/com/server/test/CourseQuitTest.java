package com.server.test;

import java.sql.Connection;
import java.sql.Statement;

import junit.framework.TestCase;

import com.data.dataImpl.method.DatabaseConnection;
import com.logic.method.studentRelative.CourseQuit;
import com.server.start.DatabaseInit;

public class CourseQuitTest extends TestCase {

	protected void setUp() {
		DatabaseInit.init();
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			// 初始化课程
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9999','测试课程','E','2','1025')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9998','测试课程','E','2','1024')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9997','测试课程','F','2','1025')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9996','测试课程','A','2','0000')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9995','测试课程','B','2','1025')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9994','测试课程','C','2','1025')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9993','测试课程','D','2','1025')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9992','测试课程','L','2','1025')";
			st.execute(sql);
			// 初始化学生
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000000','1025','2010','测试学生1')";
			st.execute(sql);
			// 初始化选课
			sql = "INSERT INTO courseStudent (ID,Student) VALUES('9998','30000000')";
			st.execute(sql);
			sql = "INSERT INTO courseStudent (ID,Student) VALUES('9997','30000000')";
			st.execute(sql);
			sql = "INSERT INTO courseStudent (ID,Student) VALUES('9996','30000000')";
			st.execute(sql);

			sql = "INSERT INTO courseStudentWait (ID,Student) VALUES('9998','30000000')";
			st.execute(sql);
			sql = "INSERT INTO courseStudentWait (ID,Student) VALUES('9997','30000000')";
			st.execute(sql);
			sql = "INSERT INTO courseStudentWait (ID,Student) VALUES('9996','30000000')";
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
			sql = "DELETE FROM course WHERE Name='测试课程'";
			st.execute(sql);
			sql = "DELETE FROM student WHERE ID='30000000'";
			st.execute(sql);
			sql = "DELETE FROM courseStudent WHERE Student='30000000'";
			st.execute(sql);
			sql = "DELETE FROM courseStudentWait WHERE Student='30000000'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}

	}

	public void testQuitCourse_1() {
		assertFalse(CourseQuit.quitCourse("30000000", "9999"));
	}

	public void testQuitCourse_2() {
		assertTrue(CourseQuit.quitCourse("30000000", "9998"));
	}

	public void testQuitCourse_3() {
		assertTrue(CourseQuit.quitCourse("30000000", "9997"));
	}

	public void testQuitCourse_4() {
		assertTrue(CourseQuit.quitCourse("30000000", "9996"));
	}

	public void testQuitCourse_5() {
		assertFalse(CourseQuit.quitCourse("30000000", "9995"));
	}

	public void testQuitCourse_6() {
		assertFalse(CourseQuit.quitCourse("30000000", "9994"));
	}

	public void testQuitCourse_7() {
		assertFalse(CourseQuit.quitCourse("30000000", "9993"));
	}

	public void testQuitCourse_8() {
		assertFalse(CourseQuit.quitCourse("30000000", "9992"));
	}
	
	
	
	public void testQuitSelectCourse_1() {
		assertFalse(CourseQuit.quitSelectCourse("30000000", "9999"));
	}

	public void testQuitSelectCourse_2() {
		assertTrue(CourseQuit.quitSelectCourse("30000000", "9998"));
	}

	public void testQuitSelectCourse_3() {
		assertTrue(CourseQuit.quitSelectCourse("30000000", "9997"));
	}

	public void testQuitSelectCourse_4() {
		assertTrue(CourseQuit.quitSelectCourse("30000000", "9996"));
	}

	public void testQuitSelectCourse_5() {
		assertFalse(CourseQuit.quitSelectCourse("30000000", "9995"));
	}

	public void testQuitSelectCourse_6() {
		assertFalse(CourseQuit.quitSelectCourse("30000000", "9994"));
	}

	public void testQuitSelectCourse_7() {
		assertFalse(CourseQuit.quitSelectCourse("30000000", "9993"));
	}

	public void testQuitSelectCourse_8() {
		assertFalse(CourseQuit.quitSelectCourse("30000000", "9992"));
	}

}
