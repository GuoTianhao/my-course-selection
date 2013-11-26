package com.client.ui.loginUI;

import java.rmi.RemoteException;

import com.basicdata.Identity;
import com.client.rmi.DeanMethodController;
import com.client.rmi.FacultyDeanMethodController;
import com.client.rmi.StudentMethodController;
import com.client.rmi.TeacherMethodController;
import com.logicService.DeanMethod;
import com.logicService.FacultyDeanMethod;
import com.logicService.StudentMethod;
import com.logicService.TeacherMethod;

public class LoginHandle {
	public static boolean login(String id,String password,int type){
		switch(type){
		case 0:
			DeanMethod deanMethod=DeanMethodController.getMethod();
			try {
				if(deanMethod.login(id,password)){
					Identity.setIdentity(deanMethod.getSelf(id));
					return true;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case 1:
			FacultyDeanMethod faucltyMethod=FacultyDeanMethodController.getMethod();
			try {
				if(faucltyMethod.login(id,password)){
					Identity.setIdentity(faucltyMethod.getSelf(id));
					return true;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}

			break;
		case 2:
			TeacherMethod teacherMethod=TeacherMethodController.getMethod();
			try {
				if(teacherMethod.login(id,password)){
					Identity.setIdentity(teacherMethod.getSelf(id));
					return true;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			StudentMethod studentMethod=StudentMethodController.getMethod();
			try {
				if(studentMethod.login(id,password)){
					Identity.setIdentity(studentMethod.getSelf(id));
					return true;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		}
		return false;
	}
}
