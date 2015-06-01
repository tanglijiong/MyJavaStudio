package com.xjj.inherit;

public class AbstractClass {
	private int iAmAVar = 100;

	protected static int aaa = 1000;
	
	public AbstractClass() {
		System.out.println("super: " + aaa);
	}

	public int getiAmAVar() {
		return iAmAVar;
	}

	public void setiAmAVar(int iAmAVar) {
		this.iAmAVar = iAmAVar;
	}
}
