package com.client.test.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.data.po.BasicFrame;
import com.data.po.Course;
import com.data.po.Dean;
import com.data.po.Frame;
import com.data.po.FrameElement;
import com.data.po.Teacher;
import com.logicService.DeanMethod;

public class DeanMethod_Stub implements DeanMethod {
	private String ID = "121250041";
	private String password = "godMotion";
	private String Name = "Hx";

	public DeanMethod_Stub() {

	}

	@Override
	public boolean login(String ID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		if (ID.equals(this.ID) && password.equals(this.password)) {
			return true;
		} else
			return false;
	}

	@Override
	public Dean getSelf(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return new Dean(ID, Name);
	}

	@Override
	public boolean changePassword(String ID, String originalPassword,
			String password) throws RemoteException {
		// TODO Auto-generated method stub
		if (ID.equals(this.ID) && originalPassword.equals(this.password)) {
			this.password = password;
			return true;
		} else
			return false;
	}

	@Override
	public boolean formulateFrame(BasicFrame bf) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean modifyFrame(BasicFrame bf) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BasicFrame lookUpBasicFrame() throws RemoteException {
		// TODO Auto-generated method stub
		BasicFrame f=new BasicFrame();
		f.addFrameElement(new FrameElement("A","14","1~8"));
		f.addFrameElement(new FrameElement("B","16","1~8"));
		f.addFrameElement(new FrameElement("C","3","1~8"));
		f.addFrameElement(new FrameElement("D","19~33","1~8"));
		f.addFrameElement(new FrameElement("E","38~45","1~8"));
		f.addFrameElement(new FrameElement("F","31~52","1~8"));
		f.addFrameElement(new FrameElement("L","8~10","1~8"));
		return f;
	}

	@Override
	public Frame lookUpFrame(String facultyID) throws RemoteException {
		// TODO Auto-generated method stub
		Frame f=new Frame(facultyID);
		f.addFrameElement(new FrameElement("A","14","1~8"));
		f.addFrameElement(new FrameElement("B","16","1~8"));
		f.addFrameElement(new FrameElement("C","3","1~8"));
		f.addFrameElement(new FrameElement("D","33","1~8"));
		f.addFrameElement(new FrameElement("E","45","1~8"));
		f.addFrameElement(new FrameElement("F","52","1~8"));
		f.addFrameElement(new FrameElement("L","10","1~8"));
		
		return f;
	}

	@Override
	public List<Teacher> getAllTeacher() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Teacher> allTeacher = new ArrayList<Teacher>();
		allTeacher.add(new Teacher("1000000000", "Liu Qin", "1250"));
		allTeacher.add(new Teacher("1000000001", "Ren Tongwei", "1250"));
		return allTeacher;
	}

	@Override
	public List<Teacher> getFacultyTeacher(String facultyID)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<Teacher> seTeacher = new ArrayList<Teacher>();
		seTeacher.add(new Teacher("1000000000", "Liu Qin", "1250"));
		return new ArrayList<Teacher>();
	}

	@Override
	public List<Course> getAllCourse() throws RemoteException {
		// TODO Auto-generated method stub
		List<Course> list = new ArrayList<Course>();
		List<String> time = new ArrayList<String>();
		time.add("2_5_7");
		time.add("1_1_4");
		Course c1 = new Course("0001", "软件工程与计算", "仙2_303", "F", 3, "1_17",
				"1250", "打造全院最好软件教育", 0, time, null);
		time.clear();
		time.add("1_5_7");
		time.add("3_1_4");
		Course c2 = new Course("0002", "c++程序设计语言", "仙2_304", "", 3, "12_17",
				"1250", "你们应该学会怎么自己实现，而不是去用现成的。", 0, time, null);
		list.add(c1);
		list.add(c2);
		return list;
	}

	@Override
	public List<Course> getFacultyCourse(String facultyID)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<Course> list = new ArrayList<Course>();
		List<String> time = new ArrayList<String>();
		time.add("2_5_7");
		time.add("1_1_4");
		Course c1 = new Course("0001", "软件工程与计算", "仙2_303", "F", 3, "1_17",
				"1250", "打造全院最好软件教育", 0, time, null);
		time.clear();
		time.add("1_5_7");
		time.add("3_1_4");
		Course c2 = new Course("0002", "c++程序设计语言", "仙2_304", "", 3, "12_17",
				"1250", "你们应该学会怎么自己实现，而不是去用现成的。", 0, time, null);
		list.add(c1);
		list.add(c2);
		if (facultyID.equals("1250")) {
			return list;
		}
		return null;
	}

	@Override
	public boolean modifyCourse(Course arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean publishCourse(Course arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> getMCourse() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getTypeCourse(String arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
