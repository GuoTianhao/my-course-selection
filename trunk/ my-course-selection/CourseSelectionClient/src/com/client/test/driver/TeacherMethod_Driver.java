package com.client.test.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.client.test.stub.TeacherMethod_Stub;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.TeacherMethod;

public class TeacherMethod_Driver {
	private TeacherMethod getMethod() {
		return new TeacherMethod_Stub();
	}

	public void driveLogin() {
		TeacherMethod method = getMethod();
		try {
			if (method.login("100000000", "Student")) {
				System.out.println("登陆成功");
			} else {
				System.out.println("登录失败");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void driveChangePassword() {
		TeacherMethod method = getMethod();
		try {
			if (method.changePassword("100000000", "OPassword", "NPassword")) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void drivefilnCourseInfor() {
		TeacherMethod method = getMethod();
		try {
			if (method.filnCourseInfor("0001", "这门课应该很好玩")) {
				System.out.println("课程信息登记成功");
			} else {
				System.out.println("课程信息登记失败");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void drivegetCourseStudent() {
		List<Student> stuList = new ArrayList<Student>();
		TeacherMethod method = getMethod();
		try {
			stuList = method.getCourseStudent("0001");
			if (stuList.equals(null)) {
				System.out.println("查找失败");
			} else {
				System.out.println("查找成功");
				for (int i = 0; i < stuList.size(); i++) {
					System.out.println("Name: " + stuList.get(i).getName()
							+ "ID: " + stuList.get(i).getID() + "Faculty: "
							+ stuList.get(i).getFaculty() + "Grade: "
							+ stuList.get(i).getGrade());
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public void driverecordScore() {
		TeacherMethod method = getMethod();
		Map<String, String> map = new HashMap<String, String>();
		try {
			if (method.recordScore("0001", map)) {
				System.out.println("登记成绩成功");
			} else {
				System.out.println("登记成绩失败");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TeacherMethod_Driver method = new TeacherMethod_Driver();
		method.drivegetCourseStudent();

	}
}
