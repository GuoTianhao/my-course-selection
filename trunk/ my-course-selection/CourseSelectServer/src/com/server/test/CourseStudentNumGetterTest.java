package com.server.test;

import java.sql.Connection;
import java.sql.Statement;

import com.data.dataImpl.method.DatabaseConnection;
import com.logic.method.courseRelative.CourseStudentNumGetter;

import junit.framework.TestCase;

public class CourseStudentNumGetterTest extends TestCase{
	protected void setUp() {

		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			// 初始化课程
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9999','测试课程','E','2','3000')";
			st.execute(sql);
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000000','1025','2012','测试学生1')";
			st.execute(sql);
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000001','1025','2012','测试学生2')";
			st.execute(sql);
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000002','1025','2012','测试学生3')";
			
			// 初始化选课
			sql = "INSERT INTO courseStudent (ID,Student,time) VALUES('9999','30000000','20130')";
			st.execute(sql);
			sql = "INSERT INTO courseStudent (ID,Student,time) VALUES('9999','30000001','20130')";
			st.execute(sql);
			sql = "INSERT INTO courseStudent (ID,Student,time) VALUES('9999','30000002','20130')";
			st.execute(sql);

			sql = "INSERT INTO courseStudentWait (ID,Student) VALUES('9999','30000000')";
			st.execute(sql);
			sql = "INSERT INTO courseStudentWait (ID,Student) VALUES('9999','30000001')";
			st.execute(sql);
			sql = "INSERT INTO courseStudentWait (ID,Student) VALUES('9999','30000002')";
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
			sql = "DELETE FROM course WHERE ID='9999' ";
			st.execute(sql);
			sql = "DELETE FROM courseStudent WHERE ID='9999'";
			st.execute(sql);
			sql = "DELETE FROM courseStudentWait WHERE ID='9999'";
			st.execute(sql);
			sql = "DELETE FROM student WHERE ID='30000000' OR ID='30000001' OR ID='30000002'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}

	}
	
	public void testGetCourseStudentNum(){
		int num=CourseStudentNumGetter.getCourseStudentNum("9999", "20130");
		System.out.println(num);
		assertTrue(num==3);
	}
	
	public void testGetWaitCourseStudentNum(){
		int num=CourseStudentNumGetter.getWaitCourseStudentNum("9999");
		System.out.println(num);
		assertTrue(num==3);
	}
}
