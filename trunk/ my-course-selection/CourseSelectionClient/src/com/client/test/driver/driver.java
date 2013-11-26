package com.client.test.driver;

import java.rmi.RemoteException;
import java.util.Iterator;

import com.client.rmi.DeanMethodController;
import com.data.po.BasicFrame;
import com.data.po.FrameElement;
import com.logicService.DeanMethod;

public class driver {
	public static void main(String[] args){
		DeanMethod controller=DeanMethodController.getMethod();
		try {
			BasicFrame frame=controller.lookUpBasicFrame();
			Iterator<FrameElement> it=frame.iterator();
			while(it.hasNext()){
				FrameElement e=it.next();
				System.out.println("Type:"+e.getType()+" Credit:"+e.getCredit()+" Period:"+e.getPeriod());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
