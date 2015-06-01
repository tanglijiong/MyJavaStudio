package com.xjj.spring.task;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {  
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/xjj/spring/task/application.xml");

		try {
			@SuppressWarnings("unused")
			Singer singer=(Singer) appContext.getBean(Singer.class);  

		} catch (BeansException e) {
			e.printStackTrace();
			
		}finally{
			//((ClassPathXmlApplicationContext) appContext).close();
		}
        
        
        
    }  
}
