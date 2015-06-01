package com.xjj.spring.properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MySQLConnectionInfo {
	//@Value("#{configProperties['mysql.url']}")
	@Value("${mysql.url}")
    private String url;
    //@Value("#{configProperties['mysql.userName']}")
	@Value("${mysql.userName}")
    private String userName;
   // @Value("#{configProperties['mysql.password']}")
	@Value("${mysql.password}")
    private String password;

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    public static void main(String[] args) {
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
