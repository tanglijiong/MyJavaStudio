package com.xjj.inherit;


public class ChildClass extends AbstractClass {
	private int iAmAVar = 200;
	protected static int aaa = 2000;
	
	
	
	public ChildClass() {
		System.out.println("Child: " + aaa);
	}



	public int getiAmAVar() {
		return iAmAVar;
	}
	
	
	
	public static void main(String[] args) {
		ChildClass  c = new ChildClass();
		System.out.println(c.getiAmAVar());
	}
}
