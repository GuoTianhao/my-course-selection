package com.basicdata;

public class Identity {
	private static Object identity;
	public static void setIdentity(Object o){
		identity=o;
	}
	public static Object getIdentity(){
		return identity;
	}
}
