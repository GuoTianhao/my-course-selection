package com.timeControllerService;

import java.rmi.RemoteException;

public interface TimeController {
	// 判断是否可以发布课程
	public boolean isTimeForPublishCourse() throws RemoteException;

	// 判断是否可以选课
	public boolean isTimeForSelectCourse() throws RemoteException;

	// 判断大一上学生是否可以选课
	public boolean isTimeForGradeOneSelectCourse() throws RemoteException;

	// 是否可以退选
	public boolean isTimeForQuitCourse() throws RemoteException;
	
	//是否可以补选
	public boolean isTimeForByElection() throws RemoteException;
	
	//系统是否开始选课
	public boolean isTimeForSystemSelect() throws RemoteException;
	
	public void setIsTimeForPublishCourse(boolean admit) throws RemoteException;
	
	public void setIsTimeForSelectCourse(boolean admit) throws RemoteException;
	
	public void setIsTimeForGradeOneSelectCourse(boolean admit) throws RemoteException;
	
	public void setIsTimeForQuitCourse(boolean admit) throws RemoteException;
	
	public void setIsTimeForByElection(boolean admit) throws RemoteException;
	
	public void setIsTimeForSystemSelect(boolean admit) throws RemoteException;
}
