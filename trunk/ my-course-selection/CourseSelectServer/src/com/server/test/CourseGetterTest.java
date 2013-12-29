package com.server.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Course;
import com.logic.method.courseRelative.CourseGetter;
import com.server.start.DatabaseInit;

import junit.framework.TestCase;

public class CourseGetterTest extends TestCase {

	protected void setUp() {
		DatabaseInit.init();
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			// 初始化课程
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9999','测试课程1','E','2','3000','3')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9998','测试课程2','E','2','3001','3')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9997','测试课程3','F','2','3000','3')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9995','测试课程4','B','2','3000','4')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9994','测试课程5','C','2','3000','4')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9993','测试课程6','D','2','3000','4')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9992','测试课程7','L','2','3000','4')";
			st.execute(sql);
			sql = "INSERT INTO course (ID,Name,Type,Num,faculty,Grade) VALUES('9991','测试','K','2','2999','4')";
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
			sql = "DELETE FROM course WHERE faculty='3000' OR faculty='3001' OR faculty='2999'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("删除数据失败" + ex.getMessage());
		}

	}

	public void testGetFacultyCourse_1() {
		List<Course> list = CourseGetter.getFacultyCourse("3000");

		assertTrue(list.size() == 6);
	}

	public void testGetFacultyCourse_2() {
		List<Course> list = CourseGetter.getFacultyCourse("3001");

		assertTrue(list.size() == 1);
	}

	public void testGetFacultyCourse_3() {
		List<Course> list = CourseGetter.getFacultyCourse("3002");

		assertTrue(list.size() == 0);
	}

	public void testGetFacultyTermCourse_1() {
		List<Course> list = CourseGetter.getFacultyTermCourse("3000", "3");

		assertTrue(list.size() == 2);
	}

	public void testGetFacultyTermCourse_2(){
		List<Course> list = CourseGetter.getFacultyTermCourse("3000", "4");

		assertTrue(list.size() == 4);
	}
	
	public void testGetFacultyTypeCourse_1(){
		List<Course> list = CourseGetter.getFacultyTypeCourse("3000", "E");

		assertTrue(list.size() == 1);
	}
	
	public void testGetFacultyTypeCourse_2(){
		List<Course> list = CourseGetter.getFacultyTypeCourse("3000", "F");

		assertTrue(list.size() == 1);
	}
	
	public void testGetConcreteCourse(){
		Course c=CourseGetter.getConcreteCourse("9999");
		assertEquals(c.getName(),"测试课程1");
	}
	
	public void testGetTypeCourse(){
		List<Course> list = CourseGetter.getTypeCourse("K");

		assertTrue(list.size() == 1);
	}
}
