package com.server.start;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.logic.deanImpl.DeanMethodImpl;
import com.logic.facultyDeanImpl.FacultyDeanMethodImpl;
import com.logic.studentImpl.StudentMethodImpl;
import com.logic.teacherImpl.TeacherMethodImpl;
import com.logicService.DeanMethod;
import com.logicService.FacultyDeanMethod;
import com.logicService.StudentMethod;
import com.logicService.TeacherMethod;

public class ServerStart {
	public static void main(String[] args){
		try{
			DeanMethod deanMethod=new DeanMethodImpl();
			LocateRegistry.createRegistry(6600);
			Naming.rebind("rmi://127.0.0.1:6600/deanMethod",deanMethod);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		try{
			FacultyDeanMethod facultyDeanMethod=new FacultyDeanMethodImpl();
			LocateRegistry.createRegistry(6601);
			Naming.rebind("rmi://127.0.0.1:6601/facultyDeanMethod",facultyDeanMethod);
		}catch(Exception ex){
			ex.printStackTrace();
		}

		try{
			TeacherMethod teacherMethod=new TeacherMethodImpl();
			LocateRegistry.createRegistry(6602);
			Naming.rebind("rmi://127.0.0.1:6602/teacherMethod",teacherMethod);
		}catch(Exception ex){
			ex.printStackTrace();
		}

		try{
			StudentMethod studentMethod=new StudentMethodImpl();
			LocateRegistry.createRegistry(6603);
			Naming.rebind("rmi://127.0.0.1:6603/studentMethod",studentMethod);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Server Start!");
	}
}
