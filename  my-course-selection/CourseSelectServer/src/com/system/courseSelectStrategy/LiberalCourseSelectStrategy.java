package com.system.courseSelectStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Adapter.GradeToTermAdapter;
import Adapter.YearTerm;

import com.data.po.Course;
import com.dataService.DatabaseMethod;
import com.dataService.StudentDatabaseMethod;
import com.logic.dataController.DatabaseController;
import com.logic.dataController.StudentDataController;
import com.logic.method.courseRelative.CourseGetter;
import com.logic.method.courseRelative.CourseStudentNumGetter;
import com.logic.method.studentRelative.CourseSelect;
import com.logic.method.studentRelative.strategy.Ballot;

//通识课选课策略
public class LiberalCourseSelectStrategy implements SelectStrategy {
	public  void startSelect() {
		DatabaseMethod method = DatabaseController.getMethod();
		List<Course> list = CourseGetter.getTypeCourse("A");
		Iterator<Course> it = list.iterator();
		while (it.hasNext()) {
			Course c = it.next();
			List<String> student = method.search("courseStudentWait", "ID",
					c.getID(), "Student");
			
			Iterator<String> sIt = student.iterator();
			List<StudentAndPriority> l=new LinkedList<StudentAndPriority>();
			while (sIt.hasNext()) {
				String studentID = sIt.next();
				l.add(new StudentAndPriority(studentID, priority(studentID)));
			}
			Collections.sort(l, new Sort());
			Iterator<StudentAndPriority> pIt=l.iterator();
			
			int unselect=c.getNum()
					- CourseStudentNumGetter.getCourseStudentNum(c.getID(),YearTerm.getNowYearTerm());
			for(int i=0;i<unselect&&pIt.hasNext();i++){
				StudentAndPriority s=pIt.next();
				CourseSelect.selectCourseToReal(s.ID, c.getID(),YearTerm.getNowYearTerm());
			}
			
		}
	}

	public static double priority(String studentID) {
		double priority = 0;
		DatabaseMethod method = DatabaseController.getMethod();
		int term = Integer.parseInt(method.search("student", "ID", studentID,
				"Grade").get(0));
		term = GradeToTermAdapter.adapter(term);
		priority = Math.pow(term, 2) / (getCreditSum(studentID)+1);
		return priority;
	}

	public static int getCreditSum(String studentID) {
		int sum = 0;
		StudentDatabaseMethod method = StudentDataController.getMethod();
		List<ArrayList<String>> list = method.getLiberalCourseList(studentID);
		Iterator<ArrayList<String>> it = list.iterator();
		while (it.hasNext()) {
			ArrayList<String> l = it.next();
			sum += Integer.parseInt(l.get(1));
		}
		return sum;
	}
	
	class Sort implements Comparator<StudentAndPriority>{
		public int compare(StudentAndPriority o1,
				StudentAndPriority o2) {
			if(o1.priority>o2.priority){
				return -1;
			}
			return 1;
		}	
	}
	
	class StudentAndPriority{
		String ID;
		double priority;
		public StudentAndPriority(String ID,double priority){
			this.ID=ID;
			this.priority=priority;
		}
	}

	public static void main(String[] args) {
		new LiberalCourseSelectStrategy().startSelect();
	}
}
