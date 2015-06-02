package com.xjj.log4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Test {
	static final Logger logger = LoggerFactory.getLogger(Log4j2Test.class);
	
	@Test
	public void log(){
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.error("error {}", "param");
		System.err.println("SYSTEM_ERR");
		System.out.println("SYSTEM_OUT");
	}
}
