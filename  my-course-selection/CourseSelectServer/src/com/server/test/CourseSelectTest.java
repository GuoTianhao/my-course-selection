package com.server.test;

import java.sql.Connection;
import java.sql.Statement;

import com.data.dataImpl.method.DatabaseConnection;
import com.logic.method.studentRelative.CourseBySelect;
import com.logic.method.studentRelative.CourseSelect;

import junit.framework.TestCase;

public class CourseSelectTest extends TestCase {

	protected void setUp() {

		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO course (ID,Name,Type,Num) VALUES('9999','测试课程','A','2')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num) VALUES('9998','测试课程','G','2')";
			st.execute(sql);
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000000','1025','2010','测试学生1')";
			st.execute(sql);
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000001','1025','2010','测试学生2')";
			st.execute(sql);
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000002','1025','2010','测试学生3')";
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
			sql = "DELETE FROM student WHERE ID='30000000' OR ID='30000001' OR ID='30000002'";
			st.execute(sql);
			sql = "DELETE FROM courseStudentWait WHERE ID='9999' OR ID='9998'";
			st.execute(sql);
			sql = "DELETE FROM courseStudent WHERE ID='9999' OR ID='9998'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}

	}

	public void testSelectCourse_1() {
		assertTrue(CourseSelect.selectCourse("30000000", "9999"));
		assertFalse(CourseSelect.selectCourse("30000000", "9999"));
	}
	
	public void testSelectCourse_2() {
		assertTrue(CourseSelect.selectCourse("30000000", "9999"));
		assertTrue(CourseSelect.selectCourse("30000001", "9999"));
		assertTrue(CourseSelect.selectCourse("30000002", "9999"));
	}
	
	public void testSelectCourse_3() {
		assertTrue(CourseSelect.selectCourse("30000000", "9998"));
		assertTrue(CourseSelect.selectCourse("30000001", "9998"));
		assertFalse(CourseSelect.selectCourse("30000002", "9998"));
	}

}
