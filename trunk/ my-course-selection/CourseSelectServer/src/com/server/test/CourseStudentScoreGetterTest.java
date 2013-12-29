package com.server.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.data.dataImpl.method.DatabaseConnection;
import com.data.po.Student;
import com.logic.method.TeacherRelative.CourseStudentScoreGetter;
import com.server.start.DatabaseInit;

import junit.framework.TestCase;

public class CourseStudentScoreGetterTest extends TestCase {

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

			sql = "INSERT INTO courseScore (cID,sID,score) VALUES('9999','30000000','99')";
			st.execute(sql);
			sql = "INSERT INTO courseScore (cID,sID,score) VALUES('9999','30000001','98')";
			st.execute(sql);
			sql = "INSERT INTO courseScore (cID,sID,score) VALUES('9999','30000001','97')";
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
			sql = "DELETE FROM courseScore WHERE cID='9999'";
			st.execute(sql);
			conn.close();
		} catch (Exception ex) {
			System.out.println("插入数据失败" + ex.getMessage());
		}

	}
	
	public void testScoreGetter_1(){
		Map<Student, Integer> map=CourseStudentScoreGetter.ScoreGetter("9999");
		Set<Student> set=map.keySet();
		Iterator<Student> it=set.iterator();
		while(it.hasNext()){
			Student s=it.next();
			if(s.getID().equals("30000000")){
				assertTrue(map.get(s)==99);
			}
		}
	}
	
	public void testScoreGetter_2(){
		Map<Student, Integer> map=CourseStudentScoreGetter.ScoreGetter("9998");
		assertTrue(map.isEmpty());
	}
}
