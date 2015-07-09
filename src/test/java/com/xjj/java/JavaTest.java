package com.xjj.java;

import org.junit.Test;

public class JavaTest {

	@Test
	public void HelloWorld(){
	
		//if(System.out.printf("Hello ")==null){
		if(System.out.format("Hello ")==null){
			System.out.print("Hello ");
		}else {
			System.out.println("World");
		}
	}
}
