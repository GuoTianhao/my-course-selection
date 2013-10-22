package com.logic.facultyDeanImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import com.data.po.BasicFrame;
import com.data.po.Course;
import com.data.po.FacultyDean;
import com.data.po.Frame;
import com.logic.method.FaucltyDeanRelative.FacultyDeanGetter;
import com.logic.method.FaucltyDeanRelative.FrameManagement;
import com.logic.method.courseRelative.CourseGetter;
import com.logic.method.courseRelative.CoursePublish;
import com.logic.method.courseRelative.CourseUpdate;
import com.logic.method.deanRelative.BasicFrameManagement;
import com.logic.method.userRelative.Login;
import com.logic.method.userRelative.PasswordChange;
import com.logicService.FacultyDeanMethod;

public class FacultyDeanMethodImpl extends UnicastRemoteObject implements FacultyDeanMethod{

	public FacultyDeanMethodImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean login(String ID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		boolean admit;
		admit=Login.facultyDeanLogin(ID, password);
		return admit;
	}

	@Override
	public boolean changePassword(String ID, String originalPassword,
			String password) throws RemoteException {
		// TODO Auto-generated method stub
		boolean admit;
		admit=PasswordChange.facultyDeanChangePassword(ID, originalPassword,password);
		return false;
	}

	@Override
	public boolean publishCourse(String ID, Course c) throws RemoteException {
		// TODO Auto-generated method stub
		boolean admit;
		admit=CoursePublish.publishCourse(c);
		return admit;
	}

	@Override
	public List<Course> getCourseList(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		List<Course> list;
		list=CourseGetter.getFacultyCourse(ID);
		return list;
	}

	@Override
	public Course getCourse(String cID) throws RemoteException {
		// TODO Auto-generated method stub
		Course c=(Course)CourseGetter.getConcreteCourse(cID);
		return c;
	}

	@Override
	public boolean modifyCourse(Course c) throws RemoteException {
		// TODO Auto-generated method stub
		CourseUpdate.updateCourse(c);
		return false;
	}

	@Override
	public FacultyDean getSelf(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		FacultyDean fd=FacultyDeanGetter.getFacultyDean(ID);
		return fd;
	}

	@Override
	public boolean formulateFrame(Frame f) throws RemoteException {
		// TODO Auto-generated method stub
		return FrameManagement.publishFrame(f);
	}

	@Override
	public boolean modifyFrame(Frame f) throws RemoteException {
		// TODO Auto-generated method stub
		return FrameManagement.modifyFrame(f);
	}

	@Override
	public Frame lookFrame(String facultyID) throws RemoteException {
		// TODO Auto-generated method stub
		return FrameManagement.getFrame(facultyID);
	}

	@Override
	public BasicFrame lookBasicFrame() throws RemoteException {
		// TODO Auto-generated method stub
		return BasicFrameManagement.getBasicFrame();
	}

}
