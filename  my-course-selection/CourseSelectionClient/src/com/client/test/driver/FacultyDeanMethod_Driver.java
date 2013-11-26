package com.client.test.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.client.rmi.FacultyDeanMethodController;
import com.data.po.Course;
import com.data.po.FacultyDean;
import com.logicService.FacultyDeanMethod;

public class FacultyDeanMethod_Driver {
	private FacultyDeanMethod getMethod() {
		return new FacultyDeanMethodController().getMethod();
	}

	public void driveLogin() {
		FacultyDeanMethod method = getMethod();
		try {
			if (method.login("100000000", "facultyDean")) {
				System.out.println("登陆成功");
			} else {
				System.out.println("登陆失败");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void driveChangePassword() {
		FacultyDeanMethod method = getMethod();
		try {
			if (method.changePassword("100000000", "facultyDean",
					"facultyPassword")) {
				System.out.println("更改密码成功");
			} else {
				System.out.println("更改密码失败");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void driveGetSelf() {
		FacultyDeanMethod method = getMethod();
		try {
			FacultyDean self = method.getSelf("100000000");
			System.out.println("ID: " + self.getID() + "; Name: "
					+ self.getName() + "; Faculty: " + self.getFaculty());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void drivePublishClass() {
		List<String> time = new ArrayList<String>();
		time.add("2_5_7");
		time.add("1_1_4");
		Course c = new Course("0003", "数据结构与算法", "仙2_304", "F", 3, "1_17",
				"1250", "尼玛全市算法", 0, time, null);
		FacultyDeanMethod method = getMethod();
		try {
			if (method.publishCourse("100000000", c)) {
				System.out.println("发布课程成功");
			} else {
				System.out.println("课程号重复，发布课程失败");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void driveGetCourseList() {
		FacultyDeanMethod method = getMethod();
		List<Course> list;
		try {
			list = method.getCourseList("1250");
			if (list != null) {
				Iterator<Course> it = list.iterator();
				while (it.hasNext()) {
					Course c = it.next();
					System.out.println("ID: " + c.getID() + " Name: "
							+ c.getName() + " Faculty: " + c.getFaculty());
				}
			} else {
				System.out.println("院系号不存在或院校尚未发布课程");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void driveGetCourse() {
		FacultyDeanMethod method = getMethod();
		try {
			Course c = method.getCourse("0001");
			if (c != null) {
				System.out.println("ID: " + c.getID() + " Name: " + c.getName()
						+ " Faculty: " + c.getFaculty());
			} else {
				System.out.println("课程不存在");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void driveModifyCourse() {
		List<String> time = new ArrayList<String>();
		time.add("2_5_7");
		time.add("1_1_4");
		Course c = new Course("0003", "数据结构与算法", "仙2_304", "F", 3, "1_17",
				"1250", "尼玛全市算法", 0, time, null);
		FacultyDeanMethod method = getMethod();
		try {
			if (method.modifyCourse(c)) {
				System.out.println("更新课程成功");
			} else {
				System.out.println("课程更新失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FacultyDeanMethod_Driver method = new FacultyDeanMethod_Driver();
		method.driveGetCourseList();

	}
}
