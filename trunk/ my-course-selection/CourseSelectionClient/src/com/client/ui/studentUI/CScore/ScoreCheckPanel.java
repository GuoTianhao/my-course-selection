package com.client.ui.studentUI.CScore;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.UIManager;

import com.basicdata.Identity;
import com.basicdata.YearKind;
import com.client.rmi.StudentMethodController;
import com.client.ui.dataAdapter.CourseAndScoreToVector;
import com.client.ui.main.MainFrame;
import com.client.ui.studentUI.StudentUISwitchController;
import com.data.po.Course;
import com.data.po.Student;
import com.logicService.StudentMethod;
import com.ui.bcswing.StudentGetScore;
import com.ui.bcswing.titleBar.StudentTitleBar;
import com.ui.bcswing.titleBar.TitleBar;
import com.ui.myswing.MComboBox;
import com.ui.myswing.MLabel;
import com.ui.myswing.MPanel;

public class ScoreCheckPanel extends MPanel{

	private TitleBar title;
	private MLabel choose;
	private MComboBox<String> term;
	private StudentGetScore table;
	private String[] yearItems = YearKind.getYear();
	private Object[] data;
	
	public ScoreCheckPanel(Point loc,Dimension size){
		super(loc,size);
		createComponent();
		addListener();
	}
	
	private void createComponent() {
		title = new StudentTitleBar(new Point(0, 0), new Dimension(this.getWidth(), 75));
		choose = new MLabel(new Point(15, 95), new Dimension(75, 22), "选择学期：");
		term = new MComboBox<>(YearKind.getAllTerm(), new Point(90, 95), new Dimension(150, 25));
		table = new StudentGetScore(new Point(10, 130), new Dimension(780,430));
		this.add(title);
		this.add(choose);
		this.add(term);
		this.add(table);
	}
	
	private void addListener(){
		title.addReturnMenu(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentUISwitchController controller = StudentUISwitchController
						.getUISwitchController();
				controller.switchToMainFrame();
			}
		});
	}
	
	class YearItemListener implements ItemListener{
		int time=0;
		public void itemStateChanged(ItemEvent e) {
			time++;
			if(time%2==0){
				Student student=(Student)(Identity.getIdentity());
				StudentMethod method=StudentMethodController.getMethod();
				String term=(String) ScoreCheckPanel.this.term.getSelectedItem();
				term=YearKind.getTerm(term);
				try {
					List<Course> list=method.getCourseList(student.getID());
					Iterator<Course> it=list.iterator();
					while(it.hasNext()){
						Course c=it.next();
						if(c.getGrade()!=Integer.parseInt(term)){
							it.remove();
						}
					}
					Map<Course,Integer> map=new HashMap<Course,Integer>();
					it=list.iterator();
					while(it.hasNext()){
						Course c=it.next();
						int score=method.getScore(student.getID(),c.getID());
						map.put(c,score);
					}
					table.setDataVector(CourseAndScoreToVector.adapter(map));
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
			}	
		}
		
	}
	public static void main(String[] args){
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MainFrame f=new MainFrame();
		f.add(new ScoreCheckPanel(new Point(0,0),new Dimension(f.getSize().width,f.getSize().height)));
		f.refresh();
	}
}

