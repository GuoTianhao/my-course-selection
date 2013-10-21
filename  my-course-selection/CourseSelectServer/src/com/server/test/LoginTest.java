package com.server.test;

import java.rmi.RemoteException;

import com.logic.deanImpl.DeanMethodImpl;

import junit.framework.TestCase;

public class LoginTest extends TestCase{
	public void testLogin(){
		boolean admit=false;
		try {
			admit=new DeanMethodImpl().login("121250041","godMotion");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(admit);
	}
}
