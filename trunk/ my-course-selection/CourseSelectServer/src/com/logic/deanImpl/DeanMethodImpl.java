package com.logic.deanImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.data.dataImpl.DeanDatabaseImpl;
import com.data.dataImpl.method.dean.TimeGetter;
import com.data.dataImpl.method.dean.TimeSetter;
import com.data.po.BasicFrame;
import com.data.po.Course;
import com.data.po.Dean;
import com.data.po.Frame;
import com.data.po.Student;
import com.data.po.Teacher;
import com.logic.method.FaucltyDeanRelative.FrameManagement;
import com.logic.method.TeacherRelative.TeacherGetter;
import com.logic.method.courseRelative.CourseGetter;
import com.logic.method.courseRelative.CoursePublish;
import com.logic.method.courseRelative.CourseUpdate;
import com.logic.method.deanRelative.BasicFrameManagement;
import com.logic.method.deanRelative.DeanGetter;
import com.logic.method.deanRelative.DeanPublishCourse;
import com.logic.method.deanRelative.MCourseGetter;
import com.logic.method.deanRelative.StudentImport;
import com.logic.method.studentRelative.CourseBySelect;
import com.logic.method.studentRelative.StudentGetter;
import com.logic.method.userRelative.Login;
import com.logic.method.userRelative.PasswordChange;
import com.logicService.DeanMethod;
import com.timeControllerService.TimeController;
import com.timeControllerService.TimeControllerController;

public class DeanMethodImpl extends UnicastRemoteObject implements DeanMethod{
	TimeController time=TimeControllerController.getMethod();

	public DeanMethodImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean login(String ID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		boolean admit;
		admit=Login.deanLogin(ID, password);
		return admit;
	}

	@Override
	public boolean changePassword(String ID, String originalPassword,
			String password) throws RemoteException {
		// TODO Auto-generated method stub
		boolean admit;
		admit=PasswordChange.deanChangePassword(ID, originalPassword, password);
		return admit;
	}

	@Override
	public boolean formulateFrame(BasicFrame bf) throws RemoteException {
		// TODO Auto-generated method stub
		return BasicFrameManagement.publishBasicFrame(bf);
	}

	@Override
	public boolean modifyFrame(BasicFrame bf) throws RemoteException {
		// TODO Auto-generated method stub
		return BasicFrameManagement.modifyBasicFrame(bf);
	}

	@Override
	public BasicFrame lookUpBasicFrame() throws RemoteException {
		// TODO Auto-generated method stub
		return BasicFrameManagement.getBasicFrame();
	}

	@Override
	public Frame lookUpFrame(String facultyID) throws RemoteException {
		// TODO Auto-generated method stub
		return FrameManagement.getFrame(facultyID);
	}

	@Override
	public List<Teacher> getAllTeacher() throws RemoteException {
		// TODO Auto-generated method stub
		List list;
		list=TeacherGetter.getTeacher(null,null);
		return list;
	}

	@Override
	public List<Teacher> getFacultyTeacher(String facultyID) throws RemoteException {
		// TODO Auto-generated method stub
		List list;
		list=TeacherGetter.getFacultyTeacher(facultyID);
		return list;	
	}
	@Override
	public List<Course> getAllCourse() throws RemoteException {
		// TODO Auto-generated method stub
		List list;
		list=CourseGetter.getCourse(null,null);
		return list;
	}

	@Override
	public List<Course> getFacultyCourse(String facultyID) throws RemoteException {
		// TODO Auto-generated method stub
		List list;
		list=CourseGetter.getFacultyCourse(facultyID);
		return list;
	}

	@Override
	public Dean getSelf(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		Dean dean=DeanGetter.getDean(ID);
		return dean;
	}

	@Override
	public boolean publishCourse(Course c) throws RemoteException {
		// TODO Auto-generated method stub
		return DeanPublishCourse.publishCourse(c);
	}

	@Override
	public boolean modifyCourse(Course c) throws RemoteException {
		// TODO Auto-generated method stub
		return CourseUpdate.updateCourse(c);
	}

	@Override
	public List<Course> getTypeCourse(String type) throws RemoteException {
		// TODO Auto-generated method stub
		return CourseGetter.getTypeCourse(type);
	}

	@Override
	public List<Course> getMCourse() throws RemoteException {
		// TODO Auto-generated method stub
		return MCourseGetter.getMCourse();
	}

	@Override
	public Course getCourse(String courseID) throws RemoteException {
		// TODO Auto-generated method stub
		return CourseGetter.getConcreteCourse(courseID);
	}

	@Override
	public List<Course> geFacultyTermCourse(String facultyID, String grade)
			throws RemoteException {
		// TODO Auto-generated method stub
		return CourseGetter.getFacultyTermCourse(facultyID, grade);
	}

	@Override
	public Teacher getTeacher(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return TeacherGetter.getConcreteTeacher(id);
	}

	@Override
	public boolean importStudent(List<Student> list) throws RemoteException {
		// TODO Auto-generated method stub
		return StudentImport.importStudent(list);
	}

	@Override
	public boolean importTeacher(List<Teacher> list) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
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
	public boolean isTimeForSystemSelect() throws RemoteException {
		// TODO Auto-generated method stub
		return time.isTimeForSystemSelect();
	}

	@Override
	public void setIsTimeForPublishCourse(boolean admit) throws RemoteException {
		// TODO Auto-generated method stub
		time.setIsTimeForPublishCourse(admit);
	}

	@Override
	public void setIsTimeForSelectCourse(boolean admit) throws RemoteException {
		// TODO Auto-generated method stub
		time.setIsTimeForSelectCourse(admit);
	}

	@Override
	public void setIsTimeForGradeOneSelectCourse(boolean admit)
			throws RemoteException {
		// TODO Auto-generated method stub
		time.setIsTimeForGradeOneSelectCourse(admit);
	}

	@Override
	public void setIsTimeForQuitCourse(boolean admit) throws RemoteException {
		// TODO Auto-generated method stub
		time.setIsTimeForQuitCourse(admit);
	}

	@Override
	public void setIsTimeForByElection(boolean admit) throws RemoteException {
		// TODO Auto-generated method stub
		time.setIsTimeForByElection(admit);
	}

	@Override
	public void setIsTimeForSystemSelect(boolean admit) throws RemoteException {
		// TODO Auto-generated method stub
		time.setIsTimeForSystemSelect(admit);
	}

	@Override
	public boolean setPeriodTime(String period, Date start)
			throws RemoteException {
		// TODO Auto-generated method stub
		return TimeSetter.setTime(period, start);
	}

	@Override
	public Date getPeriodTime(String period) throws RemoteException {
		// TODO Auto-generated method stub
		return TimeGetter.getTime(period);
	}

	@Override
	public List<Student> getFacultyStudent(String facultyID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return StudentGetter.getFacultyStudent(facultyID);
	}		
}
