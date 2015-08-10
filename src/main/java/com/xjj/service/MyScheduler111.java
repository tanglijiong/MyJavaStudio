package com.xjj.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MyScheduler111 {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Async
	public void doSomething() {
	    //System.out.println("每5秒钟执行一次。。。");
		logger.info("I am MyScheduler111.");
	}
}
