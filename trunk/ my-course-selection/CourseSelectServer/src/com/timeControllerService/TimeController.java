package com.timeControllerService;

import java.rmi.RemoteException;

public interface TimeController {
	//判断是否可以发布课程
	public boolean isTimeForPublishCourse() throws RemoteException;
	
	//判断是否可以选课
	public boolean isTimeForSelectCourse() throws RemoteException;
	
	//判断是否系统开始根据算法筛选课程时间
	public boolean isTimeForSystemSelect() throws RemoteException;
	
	//是否可以退选
	public boolean isTimeForQuitCourse() throws RemoteException;
	
	//是否可以补选
	public boolean isTimeForByElection() throws RemoteException;
}
