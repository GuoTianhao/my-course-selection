package com.server.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Teacher;
import com.logic.method.TeacherRelative.TeacherGetter;
import com.server.start.DatabaseInit;

import junit.framework.TestCase;

public class TeacherGetterTest extends TestCase{
	protected void setUp() {
		DatabaseInit.init();
		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO teacher (ID,Name,Faculty) VALUES('40000000','测试老师名字1','3000')";
			st.execute(sql);
			sql = "INSERT INTO teacher (ID,Name,Faculty) VALUES('40000001','测试老师名字2','3000')";
			st.execute(sql);
			sql = "INSERT INTO teacher (ID,Name,Faculty) VALUES('40000002','测试老师名字3','3001')";
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
			sql = "DELETE FROM teacher WHERE Faculty='3000' OR Faculty='3001'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}
	}
	
	public void testGetFacultyTeacher_1(){
		List<Teacher> list=TeacherGetter.getFacultyTeacher("3000");
		
		assertTrue(list.size()==2);
		
		Iterator<Teacher> it=list.iterator();
		while(it.hasNext()){
			Teacher t=it.next();
			System.out.println("Name:"+t.getName()+" Faculty:"+t.getFaculty());
		}
	}
	
	public void testGetFacultyTeacher_2(){
		List<Teacher> list=TeacherGetter.getFacultyTeacher("3002");
		
		assertTrue(list.size()==0);
	}
	
	public void testGetConcreteTeacher_1(){
		Teacher t=TeacherGetter.getConcreteTeacher("40000000");
		assertEquals(t.getName(),"测试老师名字1");
	}
	
	public void testGetConcreteTeacher_2(){
		Teacher t=TeacherGetter.getConcreteTeacher("40000005");
		assertNull(t);
	}

}
