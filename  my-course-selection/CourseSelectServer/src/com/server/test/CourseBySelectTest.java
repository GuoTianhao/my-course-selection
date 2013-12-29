package com.server.test;

import java.sql.Connection;
import java.sql.Statement;

import junit.framework.TestCase;

import com.data.dataImpl.method.DatabaseConnection;
import com.logic.method.studentRelative.CourseBySelect;
import com.server.start.DatabaseInit;

public class CourseBySelectTest extends TestCase{
	
	protected void setUp() {
		DatabaseInit.init();
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO course (ID,Name,Type,Num) VALUES('9999','测试课程','A','2')";
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
			sql = "DELETE FROM course WHERE ID='9999'";
			st.execute(sql);
			sql = "DELETE FROM student WHERE ID='30000000' OR ID='30000001' OR ID='30000002'";
			st.execute(sql);
			sql="DELETE FROM courseStudent WHERE ID='9999'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}
		
	}

	public void testBySelectCourse_1() {
		assertTrue(CourseBySelect.bySelectCourse("30000000", "9999"));
		assertFalse(CourseBySelect.bySelectCourse("30000000", "9999"));
	}
	
	public void testBySelectCourse_2() {
		assertTrue(CourseBySelect.bySelectCourse("30000000", "9999"));
		assertTrue(CourseBySelect.bySelectCourse("30000001", "9999"));
		assertFalse(CourseBySelect.bySelectCourse("30000002", "9999"));
	}
}
