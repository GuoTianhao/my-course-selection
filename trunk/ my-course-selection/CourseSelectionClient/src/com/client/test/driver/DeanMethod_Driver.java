package com.client.test.driver;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

import com.client.test.stub.DeanMethod_Stub;
import com.data.po.BasicFrame;
import com.data.po.Course;
import com.data.po.Dean;
import com.data.po.Frame;
import com.data.po.Teacher;
import com.logicService.DeanMethod;

public class DeanMethod_Driver {
	private DeanMethod method;

	private DeanMethod getMethod() {
		return new DeanMethod_Stub();
	}

	public void driveLogin() {
		try {
			if (method.login("121250041", "godMotion")) {
				System.out.println("登录成功");
			} else
				System.out.println("登录失败");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void driveChangePassword() {
		try {
			if (method.changePassword("121250041", "godMotion", "newPassword")) {
				System.out.println("修改密码成功");
			} else
				System.out.println("修改密码失败");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void driveGetSelf() {
		try {
			Dean self = method.getSelf("121250041");
			System.out.println("ID: " + self.getID() + "; Name: "
					+ self.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void driveFomulateFrame() {
		BasicFrame bf = new BasicFrame();
		try {
			if (method.formulateFrame(bf)) {
				System.out.println("制定整体框架策略成功");
			} else
				System.out.println("制定整体框架策略失败");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void driveModifyFrame() {
		BasicFrame bf = new BasicFrame();
		try {
			if (method.modifyFrame(bf)) {
				System.out.println("修改整体框架策略成功");
			} else
				System.out.println("修改整体框架策略失败");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void driveLookUpFrame() {
		Frame fr;
		try {
			fr = method.lookUpFrame("1250");
			if (fr != null) {
//				System.out.println("The credits of the modules are:");
//				System.out.println("A:" + fr.getACredit() + " ;B:"
//						+ fr.getBCredit() + " ;C:" + fr.getCCredit() + " ;D:"
//						+ fr.getDCredit() + " ;E:" + fr.getECredit() + " ;F:"
//						+ fr.getFCredit() + " ;L:" + fr.getLCredit());
			} else
				System.out.println("院系号不存在或院系尚未制定教学计划");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void driveGetAllTeacher() {
		List<Teacher> list;
		try {
			list = method.getAllTeacher();
			if (list != null) {
				Iterator<Teacher> it = list.iterator();
				while (it.hasNext()) {
					Teacher t = it.next();
					System.out.println("ID:" + t.getID() + " ;Name:"
							+ t.getName() + " ;Faculty:" + t.getFaculty());
				}
			} else
				System.out.println("错误，无教师信息");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void driveGetFacultyTeacher() {
		List<Teacher> list;
		try {
			list = method.getFacultyTeacher("1250");
			if (list != null) {
				Iterator<Teacher> it = list.iterator();
				while (it.hasNext()) {
					Teacher t = it.next();
					System.out.println("ID:" + t.getID() + " ;Name:"
							+ t.getName() + " ;Faculty:" + t.getFaculty());
				}
			} else
				System.out.println("院系号不存在或无该院系教师信息");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void driveGetAllCourse() {
		List<Course> list;
		try {
			list=method.getAllCourse();
			if(list!=null){
				Iterator<Course> it=list.iterator();
				while(it.hasNext()){
					Course c=it.next();
					System.out.println("ID: "+c.getID()+" Name: "+c.getName()+" Faculty: "+c.getFaculty());
				}
			}else{
				System.out.println("错误，无课程信息");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void driveGetFacultyCourse() {
		List<Course> list;
		try {
			list = method.getFacultyCourse("1250");
			if(list!=null){
				Iterator<Course> it=list.iterator();
				while(it.hasNext()){
					Course c=it.next();
					System.out.println("ID: "+c.getID()+" Name: "+c.getName()+" Faculty: "+c.getFaculty());
				}
			}else{
				System.out.println("院系号不存在或院系尚未发布课程");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
