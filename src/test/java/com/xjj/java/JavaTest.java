package com.xjj.java;

import org.junit.Test;

public class JavaTest {

	boolean p(){
		System.out.print("Hello ");
		return false;
	}
	
	@Test
	public void HelloWorld(){
	
		//if(System.out.printf("Hello ")==null){
		//if(System.out.format("Hello ")==null){
		if(p()){
			System.out.print("Hello ");
		}else {
			System.out.println("World");
		}
	}
}
