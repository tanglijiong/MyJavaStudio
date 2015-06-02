package com.xjj.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjj.BaseJunit4Test;
import com.xjj.spring.properties.MySQLConnectionInfo;

public class PropertiesTest extends BaseJunit4Test {
	@Autowired
	MySQLConnectionInfo connInfo;

	@Test
	public void getProperties(){
		System.out.println(connInfo.getUrl());
		System.out.println(connInfo.getUserName());
		System.out.println(connInfo.getPassword());
	}
}
