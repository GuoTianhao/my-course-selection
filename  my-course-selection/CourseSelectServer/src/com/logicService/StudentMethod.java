package com.logicService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.data.po.Course;
import com.data.po.Student;
import com.timeControllerService.TimeController;

public interface StudentMethod extends Remote, TimeController {
	// 学生登陆,传入ID（帐号）和password(密码)，当ID和password匹配return true，反之return false；
	public boolean login(String ID, String password) throws RemoteException;

	// 获取用户信息，传入ID（用户ID）
	public Student getSelf(String ID) throws RemoteException;

	// 学生修改密码,传入ID（帐号）、origninalassword（原密码）和password（现密码），若原密码正确return
	// true，若原密码错误return false。
	public boolean changePassword(String ID, String originalPassword,
			String password) throws RemoteException;

	// 学生选择课程,传入ID（学生ID）、cID（课程ID），若未选该课程，选课成功return true，若已选该课程，选课失败 return
	// false。
	public boolean selectCourse(String ID, String cID) throws RemoteException;

	// 补选
	public boolean bySelectCourse(String ID, String cID) throws RemoteException;

	// 学生退选课程，传入ID（学生ID）、cID（课程ID），若未选该课程，推选失败return false，若已选该课程，推选成功 return
	// true。
	public boolean quitCourse(String ID, String cID) throws RemoteException;

	// 学生放弃选课
	public boolean quitSelectCourse(String ID, String cID)
			throws RemoteException;

	// 查看成绩，传入ID（学生ID）、cID（课程ID），返回学生成绩
	public int getScore(String ID, String cID) throws RemoteException;

	// 查看自己选课列表，传入ID（学生）,返回该学生选课列表
	public List<Course> getCourseList(String ID) throws RemoteException;

	// 得到自己的已选待定课程列表
	public List<Course> getWaitCourseList(String ID) throws RemoteException;

	// 查看任意课程，传入cID（课程）ID，返回Course.
	public Course getCourse(String cID) throws RemoteException;

	//得到课程以选人数
	public int getCourseSelectNum(String cID) throws RemoteException;
	
	//得到已选课的人数
	public int getWaitCourseStudentNum(String cID)throws RemoteException;
	
	// 得到院系具体学期课程
	public List<Course> geFacultyTermCourse(String facultyID, String grade)
			throws RemoteException;

	// 得到具体类型课程
	public List<Course> getTypeCourse(String type) throws RemoteException;

}
