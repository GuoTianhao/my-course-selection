package com.server.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Student;
import com.logic.method.studentRelative.StudentGetter;

public class StudentGetterTest extends TestCase{
	protected void setUp() {

		Connection conn;
		conn = DatabaseConnection.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql;
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000000','3000','2010','测试学生1')";
			st.execute(sql);
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000001','3000','2010','测试学生2')";
			st.execute(sql);
			sql = "INSERT INTO student (ID,Faculty,Grade,Name) VALUES('30000002','3000','2010','测试学生3')";
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
			sql = "DELETE FROM student WHERE ID='30000000' OR ID='30000001' OR ID='30000002'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}
	}
	
	public void testGetFacultyStudent_1(){
		List<Student> list=StudentGetter.getFacultyStudent("3000");
		assertTrue(list.size()==3);
		
		Iterator<Student> it=list.iterator();
		while(it.hasNext()){
			Student student=it.next();
			if(student.getID().equals("30000000")){
				assertEquals(student.getName(),"测试学生1");
			}
		}
	}
	
	public void testGetFacultyStudent_2(){
		List<Student> list=StudentGetter.getFacultyStudent("-1");
		assertTrue(list.size()==0);
	}
	
	public void testGetConcreteStudent_1(){
		Student student=StudentGetter.getConcreteStudent("30000000");
		assertEquals(student.getName(), "测试学生1");
	}
	
	public void testGetConcreteStudent_2(){
		Student student=StudentGetter.getConcreteStudent("30000004");
		assertNull(student);
	}
}
