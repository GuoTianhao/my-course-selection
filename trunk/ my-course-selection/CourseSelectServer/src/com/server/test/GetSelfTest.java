package com.server.test;

import java.rmi.RemoteException;

import com.data.po.Dean;
import com.logic.deanImpl.DeanMethodImpl;

import junit.framework.TestCase;

public class GetSelfTest extends TestCase{
	public void testGetSelf(){
		try {
			Dean dean=new DeanMethodImpl().getSelf("121250041");
			System.out.println(dean.getName());
			} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
