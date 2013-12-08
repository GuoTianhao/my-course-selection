package com.logic.studentImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Adapter.YearTerm;

import com.data.po.Course;
import com.data.po.Student;
import com.logic.method.courseRelative.CourseGetter;
import com.logic.method.courseRelative.CourseStudentNumGetter;
import com.logic.method.studentRelative.CourseBySelect;
import com.logic.method.studentRelative.CourseQuit;
import com.logic.method.studentRelative.CourseSelect;
import com.logic.method.studentRelative.StudentCourseListGetter;
import com.logic.method.studentRelative.StudentGetter;
import com.logic.method.studentRelative.StudentScoreGetter;
import com.logic.method.userRelative.Login;
import com.logic.method.userRelative.PasswordChange;
import com.logicService.StudentMethod;
import com.timeControllerService.TimeController;
import com.timeControllerService.TimeControllerController;

public class StudentMethodImpl extends UnicastRemoteObject implements StudentMethod{
	TimeController time=TimeControllerController.getMethod();
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
		boolean admit=CourseQuit.quitCourse(ID, cID);
		return admit;
	}
	
	@Override
	public boolean quitSelectCourse(String ID, String cID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return CourseQuit.quitSelectCourse(ID, cID);
	}

	@Override
	public int getScore(String ID, String cID) throws RemoteException {
		// TODO Auto-generated method stub
		
		return StudentScoreGetter.getScore(ID, cID);
	}

	@Override
	public List<Course> getCourseList(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return StudentCourseListGetter.getMCourseList(ID);
	}
	
	@Override
	public List<Course> getWaitCourseList(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return StudentCourseListGetter.getMWaitedCourseList(ID);
	}

	@Override
	public Course getCourse(String cID) throws RemoteException {
		// TODO Auto-generated method stub
		return CourseGetter.getConcreteCourse(cID);
	}

	@Override
	public Student getSelf(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		Student st=StudentGetter.getConcreteStudent(ID);
		return st;
	}

	@Override
	public List<Course> geFacultyTermCourse(String facultyID, String grade)
			throws RemoteException {
		// TODO Auto-generated method stub
		return CourseGetter.getFacultyTermCourse(facultyID, grade);
	}

	@Override
	public List<Course> getTypeCourse(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return CourseGetter.getTypeCourse(type);
	}

	@Override
	public boolean isTimeForPublishCourse() throws RemoteException{
		// TODO Auto-generated method stub
		return time.isTimeForPublishCourse();
	}

	@Override
	public boolean isTimeForSelectCourse() throws RemoteException{
		// TODO Auto-generated method stub
		return time.isTimeForSelectCourse();
	}

	@Override
	public boolean isTimeForQuitCourse() throws RemoteException{
		// TODO Auto-generated method stub
		return time.isTimeForQuitCourse();
	}

	@Override
	public boolean isTimeForGradeOneSelectCourse() throws RemoteException{
		// TODO Auto-generated method stub
		return time.isTimeForGradeOneSelectCourse();
	}

	@Override
	public boolean isTimeForByElection() throws RemoteException {
		// TODO Auto-generated method stub
		return time.isTimeForByElection();
	}

	@Override
	public boolean bySelectCourse(String ID, String cID) throws RemoteException {
		// TODO Auto-generated method stub
		return CourseBySelect.bySelectCourse(ID, cID);
	}

	@Override
	public int getCourseSelectNum(String cID) throws RemoteException {
		// TODO Auto-generated method stub
		return CourseStudentNumGetter.getCourseStudentNum(cID, YearTerm.getNowYearTerm());
	}
}
