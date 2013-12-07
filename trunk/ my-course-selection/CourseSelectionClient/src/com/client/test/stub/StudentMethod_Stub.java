package com.client.test.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;

public class StudentMethod_Stub implements StudentMethod {
	private String ID = "121250041";

	private String name = "SB";
	private String password = "student";

	private String cID = "0001";

	private String faculty = "1250";

	public boolean changePassword(String ID, String originalPassword,
			String password) throws RemoteException {
		if (this.ID.equals(ID) && this.password.equals(originalPassword)) {

			this.password = password;
			return true;
		}
		return false;
	}

	public boolean selectCourse(String ID, String cID) throws RemoteException {
		if (cID.equals(this.cID)) {
			return true;
		}
		return false;
	}

	public boolean quitCourse(String ID, String cID) throws RemoteException {
		if (cID.equals(this.cID)) {
			return true;
		}
		return false;
	}

	public int getScore(String ID, String cID) throws RemoteException {
		if (this.ID.equals(ID) && this.cID.equals(cID)) {
			return 93;
		}
		return 99;

	}

	public List<Course> getCourseList(String ID) throws RemoteException {
		List<Course> list = new ArrayList<Course>();

		List<String> time = new ArrayList<String>();

		time.add("2_5_7");

		time.add("1_1_4");

		Course c1 = new Course("0001", "软件工程与计算", "仙2_303", "F", 3, "1_17",
				"1250", "打造全院最好软件教育", 0,3, time, null);
		time.clear();
		time.add("1_5_7");
		time.add("3_1_4");
		Course c2 = new Course("0002", "c++程序设计语言", "仙2_304", "E", 3, "12_17",
				"1251", "你们应该学会怎么自己实现，而不是去用现成的。", 0, 3,time, null);
		list.add(c1);

		list.add(c2);

			return list;
	}

	public Course getCourse(String cID) throws RemoteException {
		List<String> time = new ArrayList<String>();
		time.add("2_5_7");
		time.add("1_1_4");
		Course c = new Course("0001", "软件工程与计算", "仙2_303", "F", 3, "1_17",
				"1250", "打造全院最好软件教育", 0, 3,time, null);
		return c;
		
	}

	@Override
	public Student getSelf(String arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return new Student(ID, name, faculty, 2012);
	}

	@Override
	public boolean login(String arg0, String arg1) throws RemoteException {
		// TODO Auto-generated method stub
		if (this.ID.equals(ID) && this.password.equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Course> geFacultyTermCourse(String arg0, String arg1)
			throws RemoteException {
		// TODO Auto-generated method stub
		return getCourseList("1000");
	}

	@Override
	public List<Course> getTypeCourse(String arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return getCourseList(ID);
	}

	@Override
	public boolean isTimeForPublishCourse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTimeForQuitCourse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTimeForSelectCourse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> getWaitCourseList(String arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return new ArrayList<Course>();
	}

	@Override
	public boolean isTimeForByElection() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean quitSelectCourse(String arg0, String arg1)
			throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isTimeForGradeOneSelectCourse() {
		// TODO Auto-generated method stub
		return false;
	}
}
