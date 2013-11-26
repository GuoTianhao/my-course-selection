package com.client.test.driver;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.client.test.stub.StudentMethod_Stub;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;

public class StudentMethod_Driver {
	private StudentMethod getMethod()
	{
		return new StudentMethod_Stub();
	}
	public void driveLogin()
	{			
		StudentMethod method=getMethod();					
		try {						
			if(method.login("121250041","student")){							
				System.out.println("登陆成功");						
			}else{						
				System.out.println("密码与帐号不匹配");		
			}		
		} catch (RemoteException e){
			e.printStackTrace();
		}
	}

	public void driveChangePassword(){
		StudentMethod method=getMethod();			
		try {			
			if(method.changePassword("121250041","student","StudentPassword")){						
				System.out.println("更改密码成功");					
			}
			else{						
				System.out.println("更改密码失败");
			}		
		}catch (RemoteException e) {				
			e.printStackTrace();
		}
	}
	
	public void driveSelectCourse()
	{
		StudentMethod method=getMethod();
		try {			
			if(method.selectCourse("121250041","0001")){						
			System.out.println("选课成功");					
			}
			else{						
			System.out.println("选课失败");
			}		
		} catch (RemoteException e) {				
			e.printStackTrace();
		}
	
		
	}
	
	public void driveQuitScore()
	{
		StudentMethod method=getMethod();
		try {			
			if(method.quitCourse("121250041","0001")){						
				System.out.println("退选成功");					
			}
			else{						
				System.out.println("退选失败");
			}		
		}catch(RemoteException e) {				
			e.printStackTrace();
		}
	}	
	
	public void driveGetScore()
	{
		StudentMethod method=getMethod();
		try {
			int score=method.getScore("121250041","0001");
			System.out.println("Your score: "+score);		
		} catch (RemoteException e) {				
			e.printStackTrace();
		}
	}
	
	public void driveGetCourseList()
	{
		StudentMethod method=getMethod();
		List<Course> list;
		try {			
			list=method.getCourseList("121250041");		
			if(list!=null){		
				Iterator<Course> it=list.iterator();		
				while(it.hasNext()){					
					Course c=it.next();					
					System.out.println("ID: "+c.getID()+" Name: "+c.getName()+" Faculty: "+c.getFaculty());
				}			
			}else{				
				System.out.println("你还未选课程");
			}
		} catch (RemoteException e) {		
			e.printStackTrace();
		}
	}
	
	public void driveCourse()
	{
		StudentMethod method=getMethod();
		try {
			Course c=method.getCourse("00001");
			if(c!=null){
				System.out.println("ID: "+c.getID()+" Name: "+c.getName()+" Faculty: "+c.getFaculty());
			}else{
				System.out.println("该课程不存在");
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		StudentMethod_Driver method= new StudentMethod_Driver();				
		method.driveGetCourseList();

    }
}