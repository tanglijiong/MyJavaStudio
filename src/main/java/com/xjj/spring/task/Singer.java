package com.xjj.spring.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xjj.service.MyScheduler111;

@Component
public class Singer {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Scheduled(fixedDelay=1000)  //第一种方式 ，fixedDelay延时多少毫秒，多少毫秒执行一次  
	@Scheduled(cron="0 * * * * *")     //第二种方式  
  
    /* 
        1 Seconds (0-59) 
        2 Minutes (0-59) 
        3 Hours (0-23) 
        4 Day of month (1-31) 
        5 Month (1-12 or JAN-DEC) 
        6 Day of week (1-7 or SUN-SAT) 
        7 Year (1970-2099) 
        取值：可以是单个值，如6； 
            也可以是个范围，如9-12； 
            也可以是个列表，如9,11,13 
            也可以是任意取值，使用* 
    */  
    //0 * * * * * 代表每分钟执行一次  
    /* 
        2011-09-07 09:23:00 
        2011-09-07 09:24:00 
        2011-09-07 09:25:00 
        2011-09-07 09:26:00 
     */  
    public void singing(){  
        Date date=new Date();  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        System.out.println(sdf.format(date));  
    }  
	
	@Autowired
	MyScheduler111 myScheduler;
	
	@Scheduled(fixedDelay=5000)
	public void doSomething() {
		logger.info("I am Singer.");
	    //System.out.println("每5秒钟执行一次。");
	    myScheduler.doSomething();
	}
}
