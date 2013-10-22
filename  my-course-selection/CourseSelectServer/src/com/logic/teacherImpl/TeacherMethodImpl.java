package com.logic.teacherImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import com.data.po.Course;
import com.data.po.Student;
import com.data.po.Teacher;
import com.logic.method.TeacherRelative.ScoreRecord;
import com.logic.method.TeacherRelative.TeacherCourseListGetter;
import com.logic.method.TeacherRelative.TeacherGetter;
import com.logic.method.courseRelative.CourseInforFiln;
import com.logic.method.courseRelative.CourseStudentGetter;
import com.logic.method.userRelative.Login;
import com.logic.method.userRelative.PasswordChange;
import com.logicService.TeacherMethod;

public class TeacherMethodImpl extends UnicastRemoteObject implements TeacherMethod{

	public TeacherMethodImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean login(String ID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		boolean admit=Login.teacherLogin(ID, password);
		return admit;
	}

	@Override
	public boolean changePassword(String ID, String originalPassword,
			String password) throws RemoteException {
		// TODO Auto-generated method stub
		boolean admit=PasswordChange.teacherChangePassword(ID, originalPassword, password);
		return admit;
	}

	@Override
	public boolean filnCourseInfor(String cID, String text)
			throws RemoteException {
		// TODO Auto-generated method stub
		boolean admit=CourseInforFiln.filnCourseInfor(cID, text);
		return admit;
	}

	@Override
	public List<Student> getCourseStudent(String cID) throws RemoteException {
		// TODO Auto-generated method stub
		return CourseStudentGetter.getCourseStudent(cID);
	}

	@Override
	public boolean recordScore(String cID, Map score) throws RemoteException {
		// TODO Auto-generated method stub
		ScoreRecord.recordScore(cID, score);
		return true;
	}

	@Override
	public Teacher getSelf(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		Teacher t=TeacherGetter.getConcreteTeacher(ID);
		return t;
	}

	@Override
	public List<Course> getMyCourseList(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		List<Course> list=TeacherCourseListGetter.getCourseList(ID);
		return list;
	}
}
