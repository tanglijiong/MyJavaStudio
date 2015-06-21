package com.xjj.http;

import java.util.Random;

public class BlogAccess {
	public static void main(String[] args) {
		Random random = new Random();
		int minutes = 10;
		int maxInterval = 3; //minutes
		
		long beginTime = System.currentTimeMillis()/1000;
		int succCount = 0;
		
		while ( System.currentTimeMillis()/1000 < beginTime + minutes*60) {
			HttpResult result = HttpHelper.doGet("http://blog.csdn.net/clementad/article/details/46491701");
			if(result.getCode()==200){
				succCount ++;
				System.out.println("请求成功，第" + succCount + "次。");
			}else {
				System.out.println(result);
			}
			
			int interval = Math.abs(random.nextInt())%(maxInterval*60*1000); //miliseconds
			System.out.println("下一次：" + interval/1000 + "秒后……");
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("结束，一共成功：" + succCount + "次。");
	}
}
