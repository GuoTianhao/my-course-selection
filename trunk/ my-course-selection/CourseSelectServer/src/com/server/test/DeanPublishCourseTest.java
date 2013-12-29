package com.server.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Course;
import com.data.po.Teacher;
import com.logic.method.deanRelative.DeanPublishCourse;

import junit.framework.TestCase;

public class DeanPublishCourseTest extends TestCase{

	protected void setUp(){
		
	}
	
	protected void tearDown(){
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "DELETE FROM course WHERE Name='认识地球' AND Loc='仙2_303'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("搜索数据失败：" + ex.getMessage());
		}

	}
	
	public void testPublishCourse_1(){
		DeanPublishCourse.publishCourse(getCourse());
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "SELECT script FROM course WHERE Name='认识地球' AND Loc='仙2_303'";
			ResultSet res = st.executeQuery(sql);
			res.next();
			String script=res.getString("script");
			assertEquals(script,"打造全院最好软件教育");
			conn.close();
		} catch (Exception ex) {
			System.out.println("搜索数据失败：" + ex.getMessage());
		}
		
	}
	
	public void testPublishCourse_2(){
		Course c=getCourse();
		c.setType("B");
		DeanPublishCourse.publishCourse(c);
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "SELECT COUNT(*) FROM course WHERE Name='认识地球' AND Loc='仙2_303'";
			ResultSet res = st.executeQuery(sql);
			res.next();
			int num=res.getInt(1);
			System.out.println(num);
			assertTrue(num>1);
			conn.close();
		} catch (Exception ex) {
			System.out.println("搜索数据失败：" + ex.getMessage());
		}
		
	}
	
	public Course getCourse(){
		List<String> time = new ArrayList<String>();
		time.add("星期二_第五节_第六节");
		time.add("星期三_第五节_第六节");
		List<Teacher> teacher = new ArrayList<Teacher>();
		teacher.add(new Teacher("123", "daibi", "软件"));
		teacher.add(new Teacher("234", "daibi", "软件"));
		Course c=new Course(null, "认识地球", "仙2_303", "A", 3,
				"1_17", "0000", "打造全院最好软件教育", 60, 3, time,teacher );
		return c;
	}
}
