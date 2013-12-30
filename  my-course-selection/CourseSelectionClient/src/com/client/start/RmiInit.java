package com.client.start;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.client.rmi.DeanMethodController;
import com.client.rmi.FacultyDeanMethodController;
import com.client.rmi.IPController;
import com.client.rmi.StudentMethodController;
import com.client.rmi.TeacherMethodController;
import com.logicService.DeanMethod;
import com.logicService.FacultyDeanMethod;
import com.logicService.StudentMethod;
import com.logicService.TeacherMethod;

public class RmiInit {
	private static String dean = "rmi://" + IPController.getIP()
			+ ":6600/deanMethod";
	private static String faculty="rmi://"+IPController.getIP()+":6601/facultyDeanMethod";
	private static String student="rmi://"+IPController.getIP()+":6603/studentMethod";
	private static String teacher="rmi://"+IPController.getIP()+":6602/teacherMethod";

	public static void init() {
		try {
			DeanMethodController.setMethod((DeanMethod) Naming.lookup(dean));
		} catch (MalformedURLException | RemoteException | NotBoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			FacultyDeanMethodController.setMethod((FacultyDeanMethod) Naming
							.lookup(faculty));
		} catch (MalformedURLException | RemoteException | NotBoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			StudentMethodController.setMethod( (StudentMethod) Naming
							.lookup(student));
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			TeacherMethodController.setMethod((TeacherMethod) Naming
							.lookup(teacher));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
