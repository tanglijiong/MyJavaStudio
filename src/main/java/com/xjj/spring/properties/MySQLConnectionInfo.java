package com.xjj.spring.properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 使用@Value获取配置文件中的值
 * @author XuJijun
 *
 */
@Component
public class MySQLConnectionInfo {
	@Value("${db.url}")
    private String url;
	@Value("${db.username}")
    private String userName;
	@Value("${db.password}")
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
