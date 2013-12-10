package com.client.test.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.data.po.BasicFrame;
import com.data.po.Course;
import com.data.po.FacultyDean;
import com.data.po.Frame;
import com.data.po.FrameElement;
import com.data.po.Teacher;
import com.logicService.FacultyDeanMethod;

public class FacultyDeanMethod_Stub implements FacultyDeanMethod{
	private String ID="100000000";
	private String password="facultyDean";
	private String faculty="1250";
	private String name="CRX";
	@Override
	public boolean changePassword(String ID,String originalPassword,String password)
			throws RemoteException {
		// TODO Auto-generated method stub
		if(this.ID.equals(ID)&&this.password.equals(originalPassword)){
			password=password;
			return true;
		}
		return false;
	}

	@Override
	public Course getCourse(String cID) throws RemoteException {
		// TODO Auto-generated method stub
		List<String> time=new ArrayList<String>();
		time.add("2_5_7");
		time.add("1_1_4");
		Course c=new Course("0001","软件工程与计算","仙2_303","F",3,"1_17","1250","打造全院最好软件教育",0,3, time, null);
		if(cID.equals(c.getID())){
			return c;
		}
		return null;
	}

	@Override
	public List<Course> getCourseList(String facultyID) throws RemoteException {
		// TODO Auto-generated method stub
		List<Course> list=new ArrayList<Course>();
		List<String> time=new ArrayList<String>();
		time.add("2_5_7");
		time.add("1_1_4");
		Course c1=new Course("0001","软件工程与计算","仙2_303","F",3,"1_17","1250","打造全院最好软件教育",0,3, time, null);
		time.clear();
		time.add("1_5_7");
		time.add("3_1_4");
		Course c2=new Course("0002","c++程序设计语言","仙2_304","",3,"12_17","1250",
				"你们应该学会怎么自己实现，而不是去用现成的。",0,3, time, null);
		list.add(c1);
		list.add(c2);
		return list;
	}

	@Override
	public boolean login(String arg0, String arg1) throws RemoteException {
		// TODO Auto-generated method stub
		if(this.ID.equals(ID)&&this.password.equals(password)){
			return true;
		}
		return true;
	}

	@Override
	public boolean modifyCourse(Course c) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean publishCourse(String ID, Course c)
			throws RemoteException {
		// TODO Auto-generated method stub
		if(c.getID().equals("0001")){
			return false;
		}
		return true;
	}

	@Override
	public FacultyDean getSelf(String arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return new FacultyDean(ID,name,faculty);
	}

	@Override
	public boolean formulateFrame(Frame arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BasicFrame lookBasicFrame() throws RemoteException {
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
	public Frame lookFrame(String facultyID) throws RemoteException {
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
	public boolean modifyFrame(Frame arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> geFacultyTermCourse(String arg0, String arg1)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> getFacultyTeacher(String arg0) throws RemoteException {
		// TODO Auto-generated method stub
		List<Teacher> list=new ArrayList<Teacher>();
		list.add(new Teacher("100000000","bb",arg0));
		return null;
	}

	@Override
	public Teacher getTeacher(String arg0) throws RemoteException {
		// TODO Auto-generated method stub
		return new Teacher(arg0,"bb","0000");
	}

	@Override
	public boolean isTimeForPublishCourse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTimeForQuitCourse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTimeForSelectCourse() {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public boolean isTimeForByElection() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTimeForGradeOneSelectCourse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTimeForSystemSelect() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setIsTimeForByElection(boolean arg0) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIsTimeForGradeOneSelectCourse(boolean arg0)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIsTimeForPublishCourse(boolean arg0) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIsTimeForQuitCourse(boolean arg0) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIsTimeForSelectCourse(boolean arg0) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIsTimeForSystemSelect(boolean arg0) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
