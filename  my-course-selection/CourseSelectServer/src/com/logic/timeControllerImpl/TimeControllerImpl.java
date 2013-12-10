package com.logic.timeControllerImpl;

import java.rmi.RemoteException;

import com.timeControllerService.TimeController;

public class TimeControllerImpl implements TimeController {
	boolean isTimeForPublishCourse = false;
	boolean isTimeForSelectCourse = false;
	boolean isTimeForGradeOneSelectCourse = false;
	boolean isTimeForQuitCourse = false;
	boolean isTimeForByElection = false;
	boolean isTimeForSystemSelect = false;

	@Override
	public boolean isTimeForPublishCourse() throws RemoteException {
		// TODO Auto-generated method stub
		return isTimeForPublishCourse;
	}

	@Override
	public boolean isTimeForSelectCourse() throws RemoteException {
		// TODO Auto-generated method stub
		return isTimeForSelectCourse;
	}

	@Override
	public boolean isTimeForGradeOneSelectCourse() throws RemoteException {
		// TODO Auto-generated method stub
		return isTimeForGradeOneSelectCourse;
	}

	@Override
	public boolean isTimeForQuitCourse() throws RemoteException {
		// TODO Auto-generated method stub
		return isTimeForQuitCourse;
	}

	@Override
	public boolean isTimeForByElection() throws RemoteException {
		// TODO Auto-generated method stub
		return isTimeForByElection;
	}

	@Override
	public boolean isTimeForSystemSelect() throws RemoteException {
		// TODO Auto-generated method stub
		return isTimeForSystemSelect;
	}

	@Override
	public void setIsTimeForPublishCourse(boolean admit) throws RemoteException {
		// TODO Auto-generated method stub
		isTimeForPublishCourse = admit;
	}

	@Override
	public void setIsTimeForSelectCourse(boolean admit) throws RemoteException {
		// TODO Auto-generated method stub
		isTimeForSelectCourse = admit;
	}

	@Override
	public void setIsTimeForGradeOneSelectCourse(boolean admit)
			throws RemoteException {
		// TODO Auto-generated method stub
		isTimeForGradeOneSelectCourse = admit;
	}

	@Override
	public void setIsTimeForQuitCourse(boolean admit) throws RemoteException {
		// TODO Auto-generated method stub
		isTimeForQuitCourse = admit;
	}

	@Override
	public void setIsTimeForByElection(boolean admit) throws RemoteException {
		// TODO Auto-generated method stub
		isTimeForByElection = admit;
	}

	@Override
	public void setIsTimeForSystemSelect(boolean admit) throws RemoteException {
		// TODO Auto-generated method stub
		isTimeForSystemSelect = admit;
	}

}
