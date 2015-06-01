package com.xjj.spring.properties;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	@Test
	public void test1() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/xjj/spring/properties/application.xml");

		try {
			MySQLConnectionInfo connInfo = appContext.getBean(MySQLConnectionInfo.class);
			System.out.println(connInfo.getUrl());
			System.out.println(connInfo.getUserName());
			System.out.println(connInfo.getPassword());
		} catch (BeansException e) {
			e.printStackTrace();
			
		}finally{
			((ClassPathXmlApplicationContext) appContext).close();
		}
		
		
	}
}
