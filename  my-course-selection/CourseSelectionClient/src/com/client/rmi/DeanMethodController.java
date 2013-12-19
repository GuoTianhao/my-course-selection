package com.client.rmi;

import java.rmi.Naming;

import com.client.test.stub.DeanMethod_Stub;
import com.logicService.DeanMethod;

public class DeanMethodController {
	private static DeanMethod deanMethod = null;
	private static String look="rmi://172.25.132.15:6600/deanMethod";
	public static DeanMethod getMethod() {
//		if (deanMethod == null) {
//			try {
//				deanMethod = (DeanMethod) Naming
//						.lookup(look);
//			} catch (Exception ex) {
//				System.out.println("连接失败");
//				ex.printStackTrace();
//			}
//		}
	deanMethod=new DeanMethod_Stub();
		return deanMethod;
	}
	public static void setMethod(DeanMethod method){
		deanMethod=method;
	}
}
