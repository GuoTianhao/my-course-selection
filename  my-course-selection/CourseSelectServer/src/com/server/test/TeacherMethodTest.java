package com.server.test;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.data.po.Course;
import com.data.po.Student;
import com.data.po.Teacher;
import com.logic.teacherImpl.TeacherMethodImpl;

import junit.framework.TestCase;

public class TeacherMethodTest extends TestCase {

	protected static void tearDownAfterClass() throws Exception {
	}

	// protected void setUp() throws Exception {
	// super.setUp();
	//
	// }

	public void testLogin() {
		boolean val = false;
		try {
			val = new TeacherMethodImpl().login("100000003", "godMotion");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(val);
	}

	public void testGetSelf() {
		try {
			Teacher t = new TeacherMethodImpl().getSelf("100000003");
			System.out.println(t.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testChangePassword() {
		String oldPassword = "godMotion";
		String newPassword = "000000";
		try {
			boolean val = new TeacherMethodImpl().changePassword("100000003",
					oldPassword, newPassword);
			assertTrue(val);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testFilnCourseInfor() {
		boolean val = false;
		try {
			val = new TeacherMethodImpl().filnCourseInfor("id",
					"This is the test");
			assertTrue(val);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testGetCourseStudent() {
		try {
			List<Student> res = new TeacherMethodImpl().getCourseStudent("");
			Iterator<Student> it = res.iterator();
			while (it.hasNext()) {
				Student s = it.next();
				System.out.println(s.getName());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testRecordScore() {
		boolean val = false;
		Map map = new HashMap<>();
		map.put("id", 60);
		try {
			val = new TeacherMethodImpl().recordScore("id", map);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(val);
	}

	public void testGetScore() {
		try {
			Map<Student, Integer> res = new TeacherMethodImpl().getScore("id");
			Set set = res.entrySet();
			Iterator it = set.iterator();
			while (it.hasNext()) {
				Map.Entry<Student, Integer> entry = (Entry<Student, Integer>) it
						.next();
				System.out.println(entry.getKey().getName() + "->"
						+ entry.getValue());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testGetMyCourseList() {
		try {
			List<Course> res = new TeacherMethodImpl().getMyCourseList("");
			Iterator<Course> it = res.iterator();
			while (it.hasNext()) {
				Course c = it.next();
				System.out.println(c.getName());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testGetCourse() {
		Course c;
		try {
			c = new TeacherMethodImpl().getCourse("");
			System.out.println(c.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
