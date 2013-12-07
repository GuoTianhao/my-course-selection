package com.systemTimeController;

import java.rmi.RemoteException;

import com.timeControllerService.TimeController;

public interface SystemTimeController extends TimeController{
	// 判断是否系统开始根据算法筛选课程时间
		public boolean isTimeForSystemSelect() throws RemoteException;
}
