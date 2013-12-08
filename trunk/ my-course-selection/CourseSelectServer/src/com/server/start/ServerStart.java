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
		RmiInit.init();
		TimeInit.init();
	}
}
