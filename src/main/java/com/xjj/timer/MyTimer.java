package com.xjj.timer;

import java.util.Timer;

public class MyTimer {

	public static void main(String[] args) {
		Timer timer = new Timer();
		int delay = 2*1000; //2秒后开始
		int period = 3*1000; //每3秒执行一次
		
		timer.scheduleAtFixedRate(new MyTimerTask(), delay, period);
	}
}
