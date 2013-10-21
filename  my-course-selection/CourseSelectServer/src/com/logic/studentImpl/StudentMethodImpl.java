package com.logic.studentImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import com.data.po.Course;
import com.data.po.Student;
import com.logic.method.courseRelative.CourseGetter;
import com.logic.method.courseRelative.CourseSelect;
import com.logic.method.studentRelative.StudentCourseListGetter;
import com.logic.method.studentRelative.StudentGetter;
import com.logic.method.userRelative.Login;
import com.logic.method.userRelative.PasswordChange;
import com.logicService.StudentMethod;

public class StudentMethodImpl extends UnicastRemoteObject implements StudentMethod{

	public StudentMethodImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean login(String ID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		boolean admit=Login.studentLogin(ID, password);
		return admit;
	}

	@Override
	public boolean changePassword(String ID, String originalPassword,
			String password) throws RemoteException {
		// TODO Auto-generated method stub
		boolean admit=PasswordChange.studentChangePassword(ID, originalPassword, password);
		return admit;
	}

	@Override
	public boolean selectCourse(String ID, String cID) throws RemoteException {
		// TODO Auto-generated method stub
		boolean admit=CourseSelect.selectCourse(ID, cID);
		return admit;
	}

	@Override
	public boolean quitCourse(String ID, String cID) throws RemoteException {
		// TODO Auto-generated method stub
		boolean admit=CourseSelect.quitCourse(ID, cID);
		return admit;
	}

	@Override
	public int getScore(String ID, String cID) throws RemoteException {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public List<Course> getCourseList(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return StudentCourseListGetter.getCourseList(ID);
	}

	@Override
	public Course course(String cID) throws RemoteException {
		// TODO Auto-generated method stub
		return CourseGetter.getConcreteCourse(cID);
	}

	@Override
	public Student getSelf(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		Student st=StudentGetter.getConcreteStudent(ID);
		return st;
	}

}
