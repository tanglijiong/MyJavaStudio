package com.xjj.timer;

import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("定时器开始执行任务……" + new Date());
	}

}
