package com.server.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Course;
import com.logic.method.studentRelative.StudentCourseListGetter;

import junit.framework.TestCase;

public class StudentCourseListGetterTest extends TestCase{

	protected void setUp() {

		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			// 初始化课程
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9999','测试课程','E','2','3000','3')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9998','测试课程','E','2','1024','3')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9997','测试课程','F','2','3000','3')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty) VALUES('9996','测试课程','A','2','0000')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9995','测试课程','B','2','3000','3')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9994','测试课程','C','2','3000','3')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9993','测试课程','D','2','3000','3')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9992','测试课程','L','2','3000','3')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9991','测试课程','G','2','0000','3')";
			st.execute(sql);
			// 初始化学生
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000000','3000','2010','测试学生1')";
			st.execute(sql);
			// 初始化选课
			sql = "INSERT INTO courseStudent (ID,Student,time) VALUES('9998','30000000','20130')";
			st.execute(sql);
			sql = "INSERT INTO courseStudent (ID,Student,time) VALUES('9997','30000000','20130')";
			st.execute(sql);
			sql = "INSERT INTO courseStudent (ID,Student,time) VALUES('9996','30000000','20130')";
			st.execute(sql);
			sql = "INSERT INTO courseStudent (ID,Student,time) VALUES('9991','30000000','20130')";
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

	public void testGetMCourseList(){
		List<Course> c=StudentCourseListGetter.getMCourseList("30000000");
		assertTrue(c.size()==9);
	}
	
	public void testGetMWaitedCourseList(){
		List<Course> c=StudentCourseListGetter.getMWaitedCourseList("30000000");
		assertTrue(c.size()==3);
	}
	
}
