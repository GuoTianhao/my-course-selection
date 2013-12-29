package com.server.test;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.data.po.BasicFrame;
import com.data.po.Course;
import com.data.po.Dean;
import com.data.po.Frame;
import com.data.po.FrameElement;
import com.data.po.Student;
import com.data.po.Teacher;
import com.logic.deanImpl.DeanMethodImpl;
import com.logic.method.deanRelative.BasicFrameManagement;


import junit.framework.TestCase;

public class DeanMethodTest extends TestCase{

	protected static void tearDownAfterClass() throws Exception {
	}
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testLogin() {
		boolean val = false;
		try {
			val = new DeanMethodImpl().login("admin", "admin");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(val);
	}
	
	public void testGetSelf() {
		try {
			Dean dean = new DeanMethodImpl().getSelf("admin");
			System.out.println(dean.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testChangePassword() {
		String oldPassword = "admin";
		String newPassword = "000000";
		try {
			boolean val = new DeanMethodImpl().changePassword("admin",
					oldPassword, newPassword);
			assertTrue(val);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void testformulateFrame() {
		FrameElement fe1=new FrameElement("通识教育课程", "14~26", "1~8");
		FrameElement fe2=new FrameElement("思想政治理论课程", "14~26", "1~8");
		FrameElement fe3=new FrameElement("军事课程", "5~6", "1~2");
		FrameElement fe4=new FrameElement("分层次通修课程", "14~26", "1~8");
		FrameElement fe5=new FrameElement("专业必修课", "14~26", "1~8");
		FrameElement fe6=new FrameElement("专业选修课", "14~26", "1~8");
		FrameElement fe7=new FrameElement("体育课", "14~26", "1~4");
		FrameElement fe8=new FrameElement("毕业论文/设计", "2~5", "7~8");
		BasicFrame bf=new BasicFrame();
		bf.addFrameElement(fe1);
		bf.addFrameElement(fe2);
		bf.addFrameElement(fe3);
		bf.addFrameElement(fe4);
		bf.addFrameElement(fe5);
		bf.addFrameElement(fe6);
		bf.addFrameElement(fe7);
		bf.addFrameElement(fe8);
		try {
			boolean val=new DeanMethodImpl().formulateFrame(bf);
			assertTrue(val);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testmodifyFrame() {
		FrameElement fe1=new FrameElement("通识教育课程", "14~26", "1~8");
		FrameElement fe2=new FrameElement("思想政治理论课程", "14~26", "1~8");
		FrameElement fe3=new FrameElement("军事课程", "5~6", "1~2");
		FrameElement fe4=new FrameElement("分层次通修课程", "14~26", "1~8");
		FrameElement fe5=new FrameElement("专业必修课", "14~26", "1~8");
		FrameElement fe6=new FrameElement("专业选修课", "14~26", "1~8");
		FrameElement fe7=new FrameElement("体育课", "14~26", "1~4");
		FrameElement fe8=new FrameElement("毕业论文/设计", "1~2", "7~8");  //这里发生了变化
		BasicFrame bf=new BasicFrame();
		bf.addFrameElement(fe1);
		bf.addFrameElement(fe2);
		bf.addFrameElement(fe3);
		bf.addFrameElement(fe4);
		bf.addFrameElement(fe5);
		bf.addFrameElement(fe6);
		bf.addFrameElement(fe7);
		bf.addFrameElement(fe8);
		try {
			boolean val=new DeanMethodImpl().modifyFrame(bf);
			assertTrue(val);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testlookUpBasicFrame() {
		try {
			BasicFrame bf=new DeanMethodImpl().lookUpBasicFrame();
			Iterator<FrameElement> itr=bf.iterator();
			  while (itr.hasNext())
			  {
			  System.out.println("Type:"+itr.next().getType()+" Credit:"+itr.next().getCredit()+itr.next().getPeriod()+" Period:");
			  }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testlookUpFrame() {
		try {
			Frame f=new DeanMethodImpl().lookUpFrame("1250");
			Iterator<FrameElement> itr=f.iterator();
			  while (itr.hasNext())
			  {
			  System.out.println("Type:"+itr.next().getType()+" Credit:"+itr.next().getCredit()+itr.next().getPeriod()+" Period:");
			  }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testpublishCourse() {
		List<String> time = new ArrayList<String>();
		time.add("星期二_第五节_第六节");
		time.add("星期三_第五节_第六节");
		List<Teacher> teacher = new ArrayList<Teacher>();
		teacher.add(new Teacher("123", "daibi", "软件"));
		teacher.add(new Teacher("234", "daibi", "软件"));
		Course c=new Course("0001", "软件工程与计算", "仙2_303", "F", 3,
				"1_17", "1250", "打造全院最好软件教育", 60, 3, time,teacher );
		try {
			boolean val=new DeanMethodImpl().publishCourse(c);
			assertTrue(val);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testmodifyCourse() {
		List<String> time = new ArrayList<String>();
		time.add("星期二_第五节_第六节");
		time.add("星期三_第五节_第六节");
		List<Teacher> teacher = new ArrayList<Teacher>();
		teacher.add(new Teacher("123", "daibi", "软件"));
		teacher.add(new Teacher("234", "daibi", "软件"));
		Course c=new Course("0001", "软件工程与计算", "仙2_303", "F", 3,
				"1_17", "1250", "打造全院最好软件教育", 60, 4, time,teacher ); //修改学分
		try {
			boolean val=new DeanMethodImpl().modifyCourse(c);
			assertTrue(val);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void testgetAllTeacher() {
		try {
			List<Teacher> list=new DeanMethodImpl().getAllTeacher();
			 Iterator<Teacher> itr = list.iterator();
			 while (itr.hasNext())
			  {
			  System.out.println("Teacher Name:"+itr.next().getName());
			  }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testgetTeacher() {
		try {
			Teacher tea=new DeanMethodImpl().getTeacher("100000000");
			System.out.println("ID"+tea.getID()+" Name"+tea.getName()+" Faculty"+tea.getFaculty());
		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testgetFacultyTeacher() {
		try {
		List<Teacher> list=new DeanMethodImpl().getFacultyTeacher("1250");
		Iterator<Teacher> itr = list.iterator();
		 while (itr.hasNext())
		  {
		  System.out.println("Teacher Name:"+itr.next().getName());
		  }
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void testgetAllCourse() {
		try {
			List<Course> list=new DeanMethodImpl().getAllCourse();
			Iterator<Course> itr = list.iterator();
			 while (itr.hasNext())
			  {
			  System.out.println("Course Name:"+itr.next().getName());
			  }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testgetFacultyCourse() {
		try {
			List<Course> list=new DeanMethodImpl().getFacultyCourse("1250");
			Iterator<Course> itr = list.iterator();
			 while (itr.hasNext())
			  {
			  System.out.println("Course Name:"+itr.next().getName());
			  }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testgetFacultyStudent() {
		try {
			List<Student> list=new DeanMethodImpl().getFacultyStudent("1250");
			Iterator<Student> itr = list.iterator();
			 while (itr.hasNext())
			  {
			  System.out.println("Student Name:"+itr.next().getName());
			  }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testgetTypeCourse() {
		try {
			List<Course> list=new DeanMethodImpl().getTypeCourse("F");
			Iterator<Course> itr = list.iterator();
			 while (itr.hasNext())
			  {
			  System.out.println("Course Name:"+itr.next().getName());
			  }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testgetMCourse() {
		try {
			List<Course> list=new DeanMethodImpl().getMCourse();
			Iterator<Course> itr = list.iterator();
			 while (itr.hasNext())
			  {
			  System.out.println("Course Name:"+itr.next().getName());
			  }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testgetCourse() {
		try {
			Course c=new DeanMethodImpl().getCourse("0001");
			System.out.println("Course Name"+c.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void testgeFacultyTermCourse() {
		try {
			List<Course> list=new DeanMethodImpl().geFacultyTermCourse("1250", "3");
			Iterator<Course> itr = list.iterator();
			 while (itr.hasNext())
			  {
			  System.out.println("Course Name:"+itr.next().getName());
			  }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testimportStudent() {
		List<Student> list=new ArrayList<Student>();
		list.add(new Student("121250011","小小旭", "1250", 3));
		list.add(new Student("121250012","小大旭", "1250", 3));
		list.add(new Student("121250013","大大旭", "1250", 3));
		try {
			boolean val = new DeanMethodImpl().importStudent(list);
			assertTrue(val);
			
		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testimportTeacher() {
		List<Teacher> list=new ArrayList<Teacher>();
		list.add(new Teacher("100000000","小小旭", "1250"));
		list.add(new Teacher("100000001","小大旭", "1250"));
		list.add(new Teacher("100000002","大大旭", "1250"));
		try {
			boolean val = new DeanMethodImpl().importTeacher(list);
			assertTrue(val);
			
		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testsetPeriodTime() {
		String period="1~8";
		Date start=new Date(2013,3,4);
		try {
			boolean val = new DeanMethodImpl().setPeriodTime(period, start);
			assertTrue(val);
		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void testgetPeriodTime() {
		String period="1~8";
		try {
			Date date=new DeanMethodImpl().getPeriodTime(period);
			System.out.println(date);
		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
