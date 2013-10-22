package com.logic.deanImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import com.data.dataImpl.DeanDatabaseImpl;
import com.data.po.BasicFrame;
import com.data.po.Course;
import com.data.po.Dean;
import com.data.po.Frame;
import com.data.po.Teacher;
import com.logic.method.FaucltyDeanRelative.FrameManagement;
import com.logic.method.TeacherRelative.TeacherGetter;
import com.logic.method.courseRelative.CourseGetter;
import com.logic.method.courseRelative.CoursePublish;
import com.logic.method.courseRelative.CourseUpdate;
import com.logic.method.deanRelative.BasicFrameManagement;
import com.logic.method.deanRelative.DeanGetter;
import com.logic.method.userRelative.Login;
import com.logic.method.userRelative.PasswordChange;
import com.logicService.DeanMethod;

public class DeanMethodImpl extends UnicastRemoteObject implements DeanMethod{

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
		return CoursePublish.publishCourse(c);
	}

	@Override
	public boolean modifyCourse(Course c) throws RemoteException {
		// TODO Auto-generated method stub
		return CourseUpdate.updateCourse(c);
	}

}
