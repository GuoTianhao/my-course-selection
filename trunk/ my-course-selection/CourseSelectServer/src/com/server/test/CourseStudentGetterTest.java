package com.server.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Student;
import com.logic.method.courseRelative.CourseStudentGetter;

import junit.framework.TestCase;

public class CourseStudentGetterTest extends TestCase{
	
	protected void setUp() {

		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			// 初始化课程
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9998','测试课程','E','2','1024')";
			st.execute(sql);
			// 初始化学生
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000000','1025','2010','测试学生1')";
			st.execute(sql);
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000001','1025','2010','测试学生1')";
			st.execute(sql);
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000002','1025','2010','测试学生1')";
			st.execute(sql);
			// 初始化选课
			sql = "INSERT INTO courseStudent (ID,Student) VALUES('9998','30000000')";
			st.execute(sql);
			sql = "INSERT INTO courseStudent (ID,Student) VALUES('9998','30000001')";
			st.execute(sql);
			sql = "INSERT INTO courseStudent (ID,Student) VALUES('9998','30000002')";
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
			sql = "DELETE FROM course WHERE Name='9998'";
			st.execute(sql);
			sql = "DELETE FROM student WHERE ID='30000000' OR ID='30000001' OR ID='30000002'";
			st.execute(sql);
			sql = "DELETE FROM courseStudent WHERE ID='9998'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}

	}
	
	public void getCourseStudent_1(){
		List<Student> list=CourseStudentGetter.getCourseStudent("9998");
		
		assertTrue(list.size()==3);
	}
	
	public void getCourseStudent_2(){
		List<Student> list=CourseStudentGetter.getCourseStudent("9999");
		
		assertTrue(list.size()==0);
	}
}
