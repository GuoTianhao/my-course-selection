package com.server.test;

import java.rmi.RemoteException;
import java.util.Iterator;

import com.data.po.Course;
import com.data.po.Student;
import com.logic.studentImpl.StudentMethodImpl;
import junit.framework.TestCase;

public class StudentMethodTest extends TestCase {

	protected static void tearDownAfterClass() throws Exception {
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testLogin() {
		boolean val = false;
		try {
			val = new StudentMethodImpl().login("121250039", "godMotion");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(val);
	}

	public void testGetSelf() {
		try {
			Student s = new StudentMethodImpl().getSelf("121250039");
			System.out.println(s.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testChangePassword() {
		String oldPassword = "121250039";
		String newPassword = "000000";
		try {
			boolean val = new StudentMethodImpl().changePassword("121250039",
					oldPassword, newPassword);
			assertTrue(val);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testSelectCourse() {
		try {
			boolean val = new StudentMethodImpl().selectCourse("121250039", "");
			assertTrue(val);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testBySelectCourse() {
		try {
			boolean val = new StudentMethodImpl().bySelectCourse("121250039", "");
			assertTrue(val);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testQuitCourse() {
		try {
			boolean val = new StudentMethodImpl().quitCourse("121250039", "");
			assertTrue(val);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testQuitSelectCourse() {
		try {
			boolean val = new StudentMethodImpl().quitSelectCourse("121250039", "");
			assertTrue(val);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testGetScore() {
		int res;
		try {
			res = new StudentMethodImpl().getScore("121250039", "");
			System.out.println(res);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testGetCourseList() {
		try {
			java.util.List<Course> list = new StudentMethodImpl().getCourseList("121250039");
			Iterator<Course> it = list.iterator();
			while (it.hasNext()) {
				Course course = (Course) it.next();
				System.out.println(course.getName());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testGetWaitCourseList() {
		try {
			java.util.List<Course> list = new StudentMethodImpl().getWaitCourseList("121250039");
			Iterator<Course> it = list.iterator();
			while (it.hasNext()) {
				Course course = (Course) it.next();
				System.out.println(course.getName());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testGetCourse() {
		try {
			Course c = new StudentMethodImpl().getCourse("");
			System.out.println(c.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void testGetCourseSelectNum() {
		try {
			int res = new StudentMethodImpl().getCourseSelectNum("");
			System.out.println(res);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void testGetWaitCourseStudentNum() {
		try {
			int res = new StudentMethodImpl().getWaitCourseStudentNum("");
			System.out.println(res);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testGeFacultyTermCourse() {
		try {
			java.util.List<Course> list = new StudentMethodImpl().geFacultyTermCourse("", "");
			Iterator<Course> it = list.iterator();
			while (it.hasNext()) {
				Course course = (Course) it.next();
				System.out.println(course.getName());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testGetTypeCourse() {
		try {
			java.util.List<Course> list = new StudentMethodImpl().getTypeCourse("");
			Iterator<Course> it = list.iterator();
			while (it.hasNext()) {
				Course course = (Course) it.next();
				System.out.println(course.getName());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
